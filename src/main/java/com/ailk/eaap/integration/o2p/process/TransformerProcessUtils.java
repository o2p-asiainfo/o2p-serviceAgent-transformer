package com.ailk.eaap.integration.o2p.process;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
//import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.ailk.eaap.integration.o2p.transformer.MessageTransformationException;
import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.Logger;
import com.ailk.eaap.op2.bo.MessageDesc;
import com.ailk.eaap.op2.bo.MessageNode;
import com.ailk.eaap.op2.bo.NodeDesc;
import com.ailk.eaap.op2.bo.NodeDescMapper;

public class TransformerProcessUtils
{
    private static final Logger LOG = Logger
            .getLog(TransformerProcessUtils.class);

    private Map<String, Object> map = new ConcurrentHashMap<String, Object>();// 构造后关系
    private Map<Integer, Object> mapGroup = new HashMap<Integer, Object>();// 多维
    private Map<String, Object> mapHeaderNameSpace = new HashMap<String, Object>();// 根节点命名空间
    private Map<String, Object> mapChildNameSpace = new HashMap<String, Object>();// 子节点命名空间
    private Map<Integer, Object> mapAttr = new HashMap<Integer, Object>();// 属性
    private Map<Integer, NodeDesc> mapNodeDesc = new HashMap<Integer, NodeDesc>();// 节点信息
    private Map<Integer, String> mapTree = new HashMap<Integer, String>();// 初始节点路径
    private Map<Integer, Object> mapValue = new HashMap<Integer, Object>();// 目标节点值信息

    private Map<Object, Object> mapMultiple = new HashMap<Object, Object>();// 主实例节点
    private Map<Object, Object> mapMultiples = new HashMap<Object, Object>();// 多实例节点
    private Map<Object, Object> mapParseMultiple = new HashMap<Object, Object>();// 转换实例节点
    private Map<Object, Object> mapParseMultipleChild = new HashMap<Object, Object>();// 转换值实例节点
    private Map<Integer, NodeDesc> mapSrcNodeDescs = new HashMap<Integer, NodeDesc>();// 目标对应源节点信息
    private Map<Integer, List<Integer>> mapMultipleChild = new HashMap<Integer, List<Integer>>();// 实例节点对应子节点信息
    private String srcConType = "";

    public Object dataSortingHelp(MessageDesc md)
    {
        settle(md);
        mergeMap(mapGroup);
        return map;
    }

    /**
     * 根据数据集合组装数据
     * 
     * @param md
     */
    @SuppressWarnings("unchecked")
    private void settle(MessageDesc md)
    {
        prepare();
        srcConType = "";

        srcConType = md.getSrcConType();

        if (md.getMessageNodes() != null)
        {
            for (NodeDescMapper ndm : md.getNodeMappers())
            {
                if (ndm.getSrcNode() != null)
                {
                    mapSrcNodeDescs.put(ndm.getTarNode().getNodeDescId(),
                            ndm.getSrcNode());
                }
            }
            // 相关map初始化
            for (MessageNode mn : md.getMessageNodes())
            {
                initialize(mn);
            }

            for (MessageNode mn : md.getMessageNodes())
            {
                NodeDesc nd = mn.getNodeDesc();
                if (nd.getNodeType().equals(Constant.NODETYPE_BODY))
                {
                    structure(nd, nd.getNodeDescId(), null);// 初始节点路径
                    if (mapMultiples.get(nd.getParentNodeId()) != null)
                    {// 判断多实例节点
                        if (mapMultipleChild.get(nd.getParentNodeId()) == null)
                        {
                            List<Integer> list = new ArrayList<Integer>();
                            list.add(nd.getNodeDescId());
                            mapMultipleChild.put(nd.getParentNodeId(), list);
                            mapMultiples.put(nd.getNodeDescId(),
                                    nd.getNodeDescId());
                        }
                        else
                        {
                            List<Integer> list = mapMultipleChild.get(nd
                                    .getParentNodeId());
                            list.add(nd.getNodeDescId());
                            mapMultiples.put(nd.getNodeDescId(),
                                    nd.getNodeDescId());
                        }
                    }
                }
            }

            for (int i : mapTree.keySet())
            {
                String fullpath = mapTree.get(i);
                String[] strs = fullpath.split("-");
                int hierarchy = strs.length;
                if (mapGroup.get(hierarchy) == null)
                {
                    Map<String, Object> hierarchy_Map = new HashMap<String, Object>();
                    mapGroup.put(hierarchy, hierarchy_Map);
                }
                Map<String, Object> group_Map = (Map<String, Object>) mapGroup
                        .get(hierarchy);
                int length = hierarchy - 1;

                NodeDesc nd = mapNodeDesc.get(i);
                multiple(i, fullpath, strs, group_Map, length, nd);
            }

        }

    }

    @SuppressWarnings("unchecked")
    protected void initialize(MessageNode mn)
    {
        NodeDesc nd = mn.getNodeDesc();
        if (nd.getNodeType().equals(Constant.NODETYPE_NAMESPACE))
        {
            mapHeaderNameSpace.put(nd.getNodeCode().split("=")[0], nd
                    .getNodeCode().split("=")[1]);
        }
        if (nd.getNodeType().equals(Constant.NODETYPE_ATTR))
        {
            mapAttr.put(nd.getParentNodeId(), mn);
        }
        if (nd.getNodeType().equals(Constant.NODETYPE_CHILD_NAMESPACE))
        {
            if (null == mapChildNameSpace.get(nd.getNodeName()))
            {
                mapChildNameSpace.put(nd.getNodeName(), nd.getNodeCode());
            }
            else
            {
                if (mapChildNameSpace.get(nd.getNodeName()) instanceof List)
                {
                    List<Object> list = (List<Object>) mapChildNameSpace.get(nd
                            .getNodeName());
                    list.add(nd.getNodeCode());
                    mapChildNameSpace.put(nd.getNodeName(), list);
                }
                if (mapChildNameSpace.get(nd.getNodeName()) instanceof String)
                {
                    List<Object> list = new ArrayList<Object>();
                    list.add(mapChildNameSpace.get(nd.getNodeName()));
                    list.add(nd.getNodeCode());
                    mapChildNameSpace.put(nd.getNodeName(), list);
                }
            }

        }
        // 获取主实例节点
        if (!nd.getNodeNumberCons().trim().equals("")
                && Integer.valueOf(nd.getNodeNumberCons()) >= 2)
        {
            mapMultiple.put(nd.getNodeDescId(), nd.getNodeDescId());
            mapMultiples.put(nd.getNodeDescId(), nd.getNodeDescId());
        }
        // 获取转换值节点
        if (!"".equals(nd.getNodeTypeCons().trim())
                && Integer.valueOf(nd.getNodeTypeCons()) == 7)
        {
            mapParseMultipleChild.put(nd.getNodeCode(), nd.getNodeCode());
        }

        mapNodeDesc.put(nd.getNodeDescId(), nd);
        mapValue.put(nd.getNodeDescId(), mn.getNodeVal());
    }

    // 多实例结构
    protected void multiple(int i, String fullpath, String[] strs,
            Map<String, Object> group_Map, int length, NodeDesc nd)
    {
        if (mapValue.get(i) != null)
        {

            if (mapMultiples.get(i) == null)
            {
                Map<String, Object> node_Map = new HashMap<String, Object>();
                node_Map.put(nd.getNodeCode(), mapValue.get(i));
                group_Map.put(strs[length], node_Map);
                map.put(fullpath, node_Map);
            }
            mapMultiple(i, fullpath, strs, group_Map, length, nd);

        }
        else
        {
            mapMultiple(i, fullpath, strs, group_Map, length, nd);
            if (nd.getNodeName() != null)
            {
                group_Map.put(strs[length], nd.getNodeCode());
                map.put(fullpath, nd.getNodeCode());
            }
            else
            {
                group_Map.put(strs[length], "");
                map.put(fullpath, "");
            }
        }
    }

    protected void prepare()
    {
        map.clear();
        mapGroup.clear();
        mapHeaderNameSpace.clear();
        mapChildNameSpace.clear();
        mapAttr.clear();
        mapNodeDesc.clear();
        mapTree.clear();
        mapValue.clear();

        mapMultiple.clear();
        mapMultiples.clear();
        mapSrcNodeDescs.clear();
        mapMultipleChild.clear();
        mapParseMultiple.clear();
        mapParseMultipleChild.clear();
    }

    protected void mapMultiple(int i, String fullpath, String[] strs,
            Map<String, Object> group_Map, int length, NodeDesc nd)
    {
        if (mapMultiples.get(i) != null)
        {
            mapMultiples.remove(i);
            mapMultiples.put(fullpath, i);
            mapParseMultiple.put(fullpath, nd.getNodeCode());
            group_Map.put(strs[length], nd.getNodeCode());
            map.put(fullpath, nd.getNodeCode());
        }
    }

    /**
     * 根据父子节点构造层级
     * 
     * @param nd
     *            节点
     * @param nodeDescId
     *            节点ID
     * @param str
     */
    public void structure(NodeDesc nd, int nodeDescId, String str)
    {
        if (mapTree.get(nd.getNodeDescId()) != null)
        {
            String path = mapTree.get(nd.getNodeDescId()) + str;
            mapTree.put(nodeDescId, path);
        }
        else
        {
            if (nd.getParentNodeId() == 0)
            {
                if (str == null)
                {
                    mapTree.put(nodeDescId, nd.getNodeCode());
                }
                else
                {
                    mapTree.put(nodeDescId, nd.getNodeCode() + str);
                }
            }
            else
            {
                NodeDesc parentNd = mapNodeDesc.get(nd.getParentNodeId());
                if (parentNd == null)
                {
                    throw new MessageTransformationException(
                            "The parent node ID is not configured : "
                                    + nd.getParentNodeId());
                }
                if (str == null)
                {
                    structure(parentNd, nodeDescId, "-" + nd.getNodeCode());
                }
                else
                {
                    structure(parentNd, nodeDescId, "-" + nd.getNodeCode()
                            + str);
                }

            }
        }
    }

    /**
     * 根据父子节点MAP整理成一个大MAP
     * 
     * @param maps
     */
    @SuppressWarnings(
    { "unchecked" })
    private void mergeMap(Map<Integer, Object> maps)
    {
        if (maps.size() >= 2)
        {
            for (int i = maps.size(); i > 1; i--)
            {// 先判断最里层，由内而外
                Map<String, Object> merge_Map = (Map<String, Object>) maps
                        .get(i);
                Map<String, String> mmap = new HashMap<String, String>();
                String ss = null;
                for (String s_Path : merge_Map.keySet())
                {
                    // 获取完整路径前缀
                    for (String s0 : map.keySet())
                    {
                        if (s_Path
                                .equals(s0.substring(s0.lastIndexOf("-") + 1))
                                && s0.split("-").length == i)
                        {// 判断里层信息与大MAP是否一致
                            ss = s0.substring(0, s0.lastIndexOf("-"));
                            break;
                        }
                    }
                    // 判断前缀是否已经处理过，避免操作
                    if (null != ss && exists(mmap, ss))
                    {
                        judgePrefix(maps, i, ss);
                    }
                    mmap.put(ss, ss);
                }
            }
        }
        else
        {
            Map<String, Object> merge_Map = new HashMap<String, Object>();
            for (String key : map.keySet())
            {
                if (map.get(key) instanceof Map)
                {
                    merge_Map
                            .putAll((Map<? extends String, ? extends Object>) map
                                    .get(key));
                }
                if (map.get(key) instanceof String)
                {
                    merge_Map.put(key, "");
                }
            }
            map.clear();
            map.putAll(merge_Map);
        }
    }

    @SuppressWarnings("unchecked")
    protected void judgePrefix(Map<Integer, Object> maps, int i, String ss)
    {
        Map<String, Object> mTest = new HashMap<String, Object>();
        List<Object> list = new ArrayList<Object>();
        if (i != maps.size())
        {// 其他层
            for (String s0 : map.keySet())
            {
                if (s0.split("-").length > 1)
                {
                    if (s0.substring(0, s0.lastIndexOf("-")).equals(ss))
                    {
                        if (map.get(s0) instanceof String)
                        {
                            Map<String, Object> other_Name_Map = new HashMap<String, Object>();
                            other_Name_Map.put((String) map.get(s0), "");
                            list.add(other_Name_Map);
                        }
                        else if (map.get(s0) instanceof Map)
                        {
                            list.add((Map<String, Object>) map.get(s0));
                        }
                        else if (map.get(s0) instanceof List)
                        {
                            String s = s0.substring(ss.length() + 1);
                            Map<String, Object> _mapList = new HashMap<String, Object>();
                            // 判断是否主节点
                            if (null != mapMultiples.get(s0)
                                    && !"".equals(mapMultiples.get(s0)))
                            {
                                Object id = mapMultiples.get(s0);
                                if (null != mapMultiple.get(id)
                                        && !"".equals(mapMultiple.get(id)))
                                {
                                    list.addAll((Collection<? extends Object>) map
                                            .get(s0));
                                }
                                else
                                {
                                    _mapList.put(s, map.get(s0));
                                    list.add(_mapList);
                                }
                            }
                        }
                        map.remove(s0);
                    }
                }
            }
            if (map.get(ss) != null)
            {// 判断大MAP是否有值，有就合并小MAP；没有直接添加

                if (mapMultiples.get(ss) == null)
                {
                    Map<String, Object> mp_Map = new HashMap<String, Object>();

                    mp_Map.put(map.get(ss).toString(), list);
                    map.put(ss, mp_Map);
                }
                else
                {
                    if (list.size() > 0)
                    {

                        for (Object mapList : list)
                        {
                            Set<Entry<Object, Object>> entrySet = ((HashMap<Object, Object>) mapList)
                                    .entrySet();
                            // 需要判断是否多实例情况
                            for (Entry<Object, Object> entry : entrySet)
                            {
                                if (null != entry.getValue()
                                        && !"".equals(entry.getValue()))
                                {
                                    if (entry.getValue() instanceof String)
                                    {
                                        Map<String, Object> mp_Map = new HashMap<String, Object>();
                                        mp_Map.put(entry.getKey().toString(),
                                                entry.getValue());
                                        map.put(ss, mp_Map);
                                    }
                                    else if (entry.getValue() instanceof List)
                                    {
                                        List<Object> oList = (List<Object>) entry
                                                .getValue();
                                        List<Map<String, Object>> otherList = new ArrayList<Map<String, Object>>();

                                        for (Object m : oList)
                                        {
                                            Map<String, Object> mp_Map = new HashMap<String, Object>();
                                            mp_Map.put(mapParseMultiple.get(ss)
                                                    .toString(), m);
                                            otherList.add(mp_Map);
                                        }
                                        map.put(ss, otherList);
                                    }
                                    // mp_Map.put(entry.getKey(),
                                    // entry.getValue());
                                    // map.put(ss, mp_Map);
                                }
                            }
                        }
                    }
                }
                getMultiple(ss);

            }
            else
            {
                map.put(ss, list);
            }

        }
        else
        {// 获取最里层
            for (String s0 : map.keySet())
            {
                if (s0.split("-").length > 1)
                {
                    if (s0.substring(0, s0.lastIndexOf("-")).equals(ss))
                    {
                        if (map.get(s0) instanceof String)
                        {
                            mTest.put((String) map.get(s0), "");
                        }
                        else if (map.get(s0) instanceof Map)
                        {
                            mTest.putAll((Map<String, Object>) map.get(s0));
                        }
                        map.remove(s0);
                    }
                }
            }
            if (mTest.size() > 0)
            {
                if (!map.get(ss).equals(""))
                {
                    if (map.get(ss) instanceof String)
                    {
                        if (mapMultiples.get(ss) == null)
                        {
                            Map<String, Object> m_Map = new HashMap<String, Object>();
                            m_Map.put((String) map.get(ss), mTest);
                            map.put(ss, m_Map);
                        }
                        getMultiple(ss);
                    }

                }
                else
                {
                    map.put(ss, mTest);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void getMultiple(String ss)
    {
        // 实例子节点
        if (mapMultiples.get(ss) != null && srcConType.equals("1"))
        {
            int multiple = (Integer) mapMultiples.get(ss);
            List<Element> elist = (List<Element>) mapValue.get(multiple);
            List<Integer> childlist = mapMultipleChild.get(multiple);

            if (null != elist)
            {
                List<Map<String, Map<String, String>>> mulist = new ArrayList<Map<String, Map<String, String>>>();
                for (Element e : elist)
                {
                    Map<String, String> childmap = new HashMap<String, String>();
                    for (int child : childlist)
                    {
                        childmap.put(mapNodeDesc.get(child).getNodeCode(), e
                                .elementText(mapSrcNodeDescs.get(child)
                                        .getNodeCode()));
                    }
                    Map<String, Map<String, String>> mumap = new HashMap<String, Map<String, String>>();
                    mumap.put(map.get(ss).toString(), childmap);
                    mulist.add(mumap);
                }
                map.put(ss, mulist);
            }
            else
            {
                muList(ss, childlist);
            }
        }
        if (mapMultiples.get(ss) != null && srcConType.equals("2"))
        {
            int multiple = (Integer) mapMultiples.get(ss);
            List<Object> list = (List<Object>) mapValue.get(multiple);
            List<Integer> childlist = mapMultipleChild.get(multiple);

            if (null != list)
            {
                List<Map<String, Map<String, String>>> mulist = new ArrayList<Map<String, Map<String, String>>>();
                for (Object str : list)
                {
                    JSONObject json = JSONObject.fromObject(str);
                    Map<String, String> childmap = new HashMap<String, String>();
                    for (int child : childlist)
                    {
                        childmap.put(mapNodeDesc.get(child).getNodeCode(), json
                                .getString(mapSrcNodeDescs.get(child)
                                        .getNodeCode()));
                    }
                    Map<String, Map<String, String>> mumap = new HashMap<String, Map<String, String>>();
                    mumap.put(map.get(ss).toString(), childmap);
                    mulist.add(mumap);
                }

                map.put(ss, mulist);
            }
            else
            {
                muList(ss, childlist);
            }

        }

    }

    @SuppressWarnings(
    { "unchecked", "rawtypes" })
    protected void muList(String ss, List<Integer> childlist)
    {
        List<Map<String, Object>> mulist = new ArrayList<Map<String, Object>>();

        for (int child : childlist)
        {
            if (!"".equals(mapValue.get(child)) && null != mapValue.get(child))
            {

                if (mapValue.get(child) instanceof String)
                {
                    Map<String, Object> childmap = new HashMap<String, Object>();
                    Map<String, Object> mumap = new HashMap<String, Object>();
                    childmap.put(mapNodeDesc.get(child).getNodeCode(), mapValue
                            .get(child).toString());
                    mumap.put(map.get(ss).toString(), childmap);
                }
                else if (mapValue.get(child) instanceof List)
                {
                    List<Object> list = (List<Object>) mapValue.get(child);

                    // 判断是否已生成部分信息
                    for (int i = 0; i < list.size(); i++)
                    {
                        Object obj = list.get(i);
                        Map<String, Object> childmap = new HashMap<String, Object>();
                        Map<String, Object> mumap = new HashMap<String, Object>();
                        if (obj instanceof String)
                        {
                            childmap.put(mapNodeDesc.get(child).getNodeCode(),
                                    obj.toString());
                            if (null != map.get(ss))
                            {
                                Object sunMultipleList = map.get(ss);
                                if (sunMultipleList instanceof String)
                                {
                                    mumap.put(sunMultipleList.toString(),
                                            childmap);
                                    mulist.add(mumap);
                                }
                                else if (sunMultipleList instanceof List)
                                {
                                    Object sunMultiple = ((List) sunMultipleList)
                                            .get(i);
                                    if (sunMultiple instanceof Map)
                                    {
                                        Set<Entry<String, Object>> entrySet = ((Map) sunMultiple)
                                                .entrySet();

                                        for (Entry<String, Object> entry : entrySet)
                                        {
                                            if (mapParseMultiple.get(ss)
                                                    .equals(entry.getKey()))
                                            {
                                                List<Map<String, Object>> mulist2 = new ArrayList<Map<String, Object>>();
                                                mulist2.add(childmap);
                                                mulist2.add((Map<String, Object>) entry
                                                        .getValue());
                                                mumap.put(entry.getKey(),
                                                        mulist2);
                                            }
                                        }
                                        mulist.add(mumap);
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
        // mulist.add(childmap);
        if (mulist.size() > 0)
        {
            map.put(ss, mulist);
        }

    }

    /**
     * 判断前缀是否已经处理
     * 
     * @param map
     * @param s
     * @return
     */
    private boolean exists(Map<String, String> map, String s)
    {
        boolean b = false;
        if (map.size() == 0)
        {
            return true;
        }
        if (map.get(s) == null)
        {
            return true;
        }
        return b;
    }

    /**
     * 根据MAP解析成XML
     * 
     * @param mapArray
     * @return
     * @throws DocumentException
     */
    @SuppressWarnings(
    { "rawtypes", "unchecked" })
    public Document parseXml(Map<String, Object> mapArray)
            throws DocumentException
    {
        try
        {
            if (mapArray.size() > 0)
            {
                Document document = DocumentHelper.createDocument();
                Element employees = null;
                Set<Entry<String, Object>> entryseSet = mapArray.entrySet();
                for (Entry<String, Object> entry : entryseSet)
                {
                    if (mapArray.get(entry.getKey()) instanceof List)
                    {
                        if (mapArray.keySet() instanceof Map)
                        {
                            Map<String, Object> rootMap = (Map) mapArray
                                    .keySet();
                            Set<String> set = rootMap.keySet();
                            employees = document.addElement(set.toString());
                            employees.setText(rootMap.get(set).toString());
                        }
                        else
                        {
                            employees = document.addElement(entry.getKey());
                        }
                        // 根节点命名空间
                        rootNameSpece(employees);
                        parseList(employees,
                                (List) mapArray.get(entry.getKey()));
                    }
                    if (mapArray.get(entry.getKey()) instanceof Map)
                    {
                        employees = document.addElement(entry.getKey());
                        // 根节点命名空间
                        rootNameSpece(employees);
                        parseMap(employees,
                                (Map<String, Object>) mapArray.get(entry
                                        .getKey()));
                    }
                    // 只有一个根节点
                    if (mapArray.get(entry.getKey()).equals(""))
                    {
                        employees = document.addElement(entry.getKey());
                    }
                }
                // 属性添加
                if (mapAttr.size() > 0)
                {
                    Document body = DocumentHelper.parseText(document
                            .getRootElement().asXML().toString());
                    for (int i : mapAttr.keySet())
                    {
                        MessageNode mn = (MessageNode) mapAttr.get(i);
                        List nodes = body.selectNodes(mn.getNodeDesc()
                                .getNodePath());
                        Element e = (Element) nodes.get(0);

                        if (null != mn.getNodeVal()
                                && !"".equals(mn.getNodeVal()))
                        {
                            e.addAttribute(mn.getNodeDesc().getNodeCode(), mn
                                    .getNodeVal().toString());
                        }
                        else
                        {
                            String[] atts = mn.getNodeDesc().getNodeCode()
                                    .toString().split("=");
                            if (2 == atts.length)
                            {
                                e.addAttribute(atts[0], atts[1]);
                            }
                        }

                    }
                    return body;
                }

                return document;
            }
        }
        catch (Exception e)
        {
            LOG.error("serviceAgent-transformer parseXml error {0}-{1}",
                    mapArray.toString(), e);
            throw new BusinessException(
                    9102,
                    "o2p.serviceAgent.transformer.TransformerProcessUtils.parseXml",
                    null, e);
        }
        finally
        {
            map.clear();
            mapGroup.clear();
            mapHeaderNameSpace.clear();
            mapChildNameSpace.clear();
            mapAttr.clear();
            mapNodeDesc.clear();
            mapTree.clear();
            mapValue.clear();

            mapMultiple.clear();
            mapMultiples.clear();
            mapSrcNodeDescs.clear();
            mapMultipleChild.clear();
        }

        return null;
    }

    private void rootNameSpece(Element employees)
    {
        // 获取命名空间
        if (mapHeaderNameSpace.size() > 0)
        {
            for (String str : mapHeaderNameSpace.keySet())
            {
                if (!str.trim().equals(""))
                {
                    employees.addNamespace(str, mapHeaderNameSpace.get(str)
                            .toString());
                }
                else
                {
                    employees.addNamespace("", mapHeaderNameSpace.get(str)
                            .toString());
                }
            }
        }
    }

    /**
     * 解析List成XML
     * 
     * @param e
     * @param list
     */
    @SuppressWarnings(
    { "unchecked", "rawtypes" })
    private void parseList(Element e, List list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i) instanceof Map)
            {
                Map<String, Object> maps = (Map<String, Object>) list.get(i);
                Set<Entry<String, Object>> entrysSet = maps.entrySet();
                for (Entry<String, Object> entry : entrysSet)
                {
                    if (mapChildNameSpace.get(entry.getKey()) == null)
                    {
                        Element employee = null;
                        // 判断是否是key-value字符串
                        if (entry.getKey().split("=").length == 1)
                        {
                            employee = e.addElement(entry.getKey());
                        }
                        if (entry.getKey().split("=").length > 1)
                        {
                            String keyMap = entry.getKey().substring(1,
                                    entry.getKey().length() - 1);
                            employee = e.addElement(keyMap.split("=")[0]);
                            employee.setText(keyMap.split("=")[1]);
                        }

                        if (maps.get(entry.getKey()) instanceof List)
                        {
                            parseList(employee, (List) maps.get(entry.getKey()));
                        }
                        else if (maps.get(entry.getKey()) instanceof String)
                        {
                            employee.setText(maps.get(entry.getKey())
                                    .toString());
                        }
                        else if (maps.get(entry.getKey()) instanceof Map)
                        {
                            parseMap(employee,
                                    (Map<String, Object>) maps.get(entry
                                            .getKey()));
                        }
                        else if (maps.get(entry.getKey()) instanceof Long)
                        {
                            employee.setText(maps.get(entry.getKey())
                                    .toString());
                        }
                        else if (maps.get(entry.getKey()) instanceof Integer)
                        {
                            employee.setText(maps.get(entry.getKey())
                                    .toString());
                        }
                    }

                    if (mapChildNameSpace.get(entry.getKey()) != null)
                    {
                        Document document = DocumentHelper.createDocument();
                        Element employees = document.addElement(entry.getKey());

                        Object childNameSpaces = mapChildNameSpace.get(entry
                                .getKey());
                        if (childNameSpaces instanceof List)
                        {
                            List listChildNameSpace = (List) childNameSpaces;
                            for (int j = 0; j < listChildNameSpace.size(); j++)
                            {
                                String childNameSpace = listChildNameSpace.get(
                                        j).toString();
                                employees.addNamespace(
                                        childNameSpace.split("=")[0],
                                        childNameSpace.split("=")[1]);
                            }
                        }
                        else if (childNameSpaces instanceof String)
                        {
                            String childNameSpace = mapChildNameSpace.get(
                                    entry.getKey()).toString();
                            employees.addNamespace(
                                    childNameSpace.split("=")[0],
                                    childNameSpace.split("=")[1]);
                        }

                        else if (maps.get(entry.getKey()) instanceof List)
                        {
                            parseList(employees,
                                    (List) maps.get(entry.getKey()));
                        }
                        else if (maps.get(entry.getKey()) instanceof String)
                        {
                            employees
                                    .setText((String) maps.get(entry.getKey()));
                        }
                        else if (maps.get(entry.getKey()) instanceof Map)
                        {
                            parseMap(employees,
                                    (Map<String, Object>) maps.get(entry
                                            .getKey()));
                        }

                        e.add(employees);
                    }

                }
            }
            else if (list.get(i) instanceof String)
            {
                e.setText(list.get(i).toString());
            }

        }
    }

    /**
     * 解析MAP成XML
     * 
     * @param e
     * @param map
     */
    @SuppressWarnings(
    { "unchecked", "rawtypes" })
    private void parseMap(Element e, Map<String, Object> map)
    {
        if (null == map)
        {
            return;
        }
        Set<Entry<String, Object>> entrysSet = map.entrySet();
        for (Entry<String, Object> entry : entrysSet)
        {
            if (mapChildNameSpace.get(entry.getKey()) == null)
            {
                Element element = e.addElement(entry.getKey());
                if (map.get(entry.getKey()) instanceof String)
                {
                    element.setText((String) map.get(entry.getKey()));
                }
                else if (map.get(entry.getKey()) instanceof Map)
                {
                    parseMap(element,
                            (Map<String, Object>) map.get(entry.getKey()));
                }
                else if (map.get(entry.getKey()) instanceof Long)
                {
                    element.setText(map.get(entry.getKey()).toString());
                }
                else if (map.get(entry.getKey()) instanceof Integer)
                {
                    element.setText(map.get(entry.getKey()).toString());
                }
                else if (map.get(entry.getKey()) instanceof List)
                {
                }
            }

            if (mapChildNameSpace.get(entry.getKey()) != null)
            {
                Document document = DocumentHelper.createDocument();
                Element employees = document.addElement(entry.getKey());
                String childNameSpace = mapChildNameSpace.get(entry.getKey())
                        .toString();
                employees.addNamespace(childNameSpace.split("=")[0],
                        childNameSpace.split("=")[1]);
                if (map.get(entry.getKey()) instanceof List)
                {
                    parseList(employees, (List) map.get(entry.getKey()));
                }
                if (map.get(entry.getKey()) instanceof String)
                {
                    employees.setText((String) map.get(entry.getKey()));
                }
                e.add(employees);
            }

        }

    }

    /**
     * 根据MAP解析成JSON
     * 
     * @param maps
     */
    @SuppressWarnings(
    { "unchecked", "rawtypes" })
    public JSONObject parseJson(Map<String, Object> maps)
    {
        JSONObject json = new JSONObject();
        try
        {
            for (String str : maps.keySet())
            {
                if (maps.get(str) instanceof List)
                {
                    Object o = parseJsonArray(
                            (List<Map<String, Object>>) maps.get(str), str);
                    json.put(str, o);
                }
                else if (maps.get(str) instanceof Map)
                {
                    Object o = parseJsonObject(
                            (Map<String, Object>) maps.get(str),
                            new JSONObject());

                    json.putAll((Map) o);
                }
                else if (maps.get(str) instanceof String)
                {
                    json.put(str, maps.get(str).toString());
                }
                else if (maps.get(str) instanceof Long)
                {
                    json.put(str, maps.get(str).toString());
                }
                else if (maps.get(str) instanceof Integer)
                {
                    json.put(str, maps.get(str));
                }
            }
        }
        catch (Exception e)
        {
            LOG.error("serviceAgent-transformer parseJSON error {0}-{1}",
                    maps.toString(), e);
            throw new BusinessException(
                    9103,
                    "o2p.serviceAgent.transformer.TransformerProcessUtils.parseJson",
                    null, e);
        }
        finally
        {
            prepare();
        }

        return json;
    }

    /**
     * List解析JSON
     * 
     * @param list
     * @return
     */
    @SuppressWarnings("unchecked")
    private Object parseJsonArray(List<Map<String, Object>> list, String key)
    {
        Object return_Object = null;
        boolean b = false;
        if (list.size() >= 2)
        {
            Map<String, Object> map0 = list.get(0);
            Map<String, Object> map1 = list.get(1);

            for (String str : map0.keySet())
            {
                if (map1.get(str) != null && !map1.get(str).equals(""))
                {
                    b = true;
                    break;
                }
            }
        }

        if (null != mapParseMultiple.get(key))
        {
            b = true;
        }

        if (!b)
        {// 为假
            JSONObject json = new JSONObject();
            for (Map<String, Object> m : list)
            {
                for (String str : m.keySet())
                {
                    if (m.get(str) instanceof Map)
                    {
                        Object o = parseJsonObject(
                                (Map<String, Object>) m.get(str),
                                new JSONObject());
                        json.put(str, o);
                    }
                    if (m.get(str) instanceof String)
                    {
                        JSONArray jsonArray = new JSONArray();
                        if (null != mapParseMultipleChild.get(str))
                        {
                            jsonArray.add(m.get(str));
                        }
                        if (jsonArray.size() > 0)
                        {
                            json.put(str, jsonArray);
                        }
                        else
                        {
                            json.put(str, m.get(str));
                        }

                    }
                    if (m.get(str) instanceof List)
                    {
                        Object o = parseJsonArray(
                                (List<Map<String, Object>>) m.get(str), key
                                        + "-" + str);
                        json.put(str, o);
                    }
                }
            }
            return_Object = json;
        }
        else
        {// 真
            JSONArray ja = new JSONArray();
            for (Map<String, Object> m : list)
            {
                JSONObject json = new JSONObject();
                for (String str : m.keySet())
                {
                    if (m.get(str) instanceof Map)
                    {
                        parseJsonObject((Map<String, Object>) m.get(str), json);
                    }
                    if (m.get(str) instanceof String)
                    {
                        JSONArray jsonArray = new JSONArray();
                        if (null != mapParseMultipleChild.get(str))
                        {
                            jsonArray.add(m.get(str));
                        }
                        if (jsonArray.size() > 0)
                        {
                            json.put(str, jsonArray);
                        }
                        else
                        {
                            json.put(str, m.get(str));
                        }
                    }
                    if (m.get(str) instanceof List)
                    {
                        Object o = parseJsonArray(
                                (List<Map<String, Object>>) m.get(str), key
                                        + "-" + str);
                        json.put(str, o);
                    }
                }
                ja.add(json);
            }
            return_Object = ja;
        }

        return return_Object;
    }

    /**
     * 对象解析JSON
     * 
     * @param maps
     * @return
     */
    @SuppressWarnings("unchecked")
    private Object parseJsonObject(Map<String, Object> maps, JSONObject json)
    {
        if (null == maps)
        {
            return json;
        }
        Set<Entry<String, Object>> entryseSet = maps.entrySet();

        for (Entry<String, Object> entry : entryseSet)
        {
            if (maps.get(entry.getKey()) instanceof Map)
            {
                JSONObject j = new JSONObject();
                Object o = parseJsonObject(
                        (Map<String, Object>) maps.get(entry.getKey()), j);
                json.put(entry.getKey(), o);
            }
            else if (maps.get(entry.getKey()) instanceof String)
            {
                json.put(entry.getKey(), maps.get(entry.getKey()));
            }
            else if (maps.get(entry.getKey()) instanceof List)
            {
                Object o = parseJsonArray(
                        (List<Map<String, Object>>) maps.get(entry.getKey()),
                        entry.getKey());
                json.put(entry.getKey(), o);
            }
            else if (maps.get(entry.getKey()) instanceof Long)
            {
                json.put(entry.getKey(), maps.get(entry.getKey()));
            }
            else if (maps.get(entry.getKey()) instanceof Integer)
            {
                json.put(entry.getKey(), maps.get(entry.getKey()));
            }
        }

        return json;
    }

    /**
     * 获取TLV节点PATH，返回整形数组
     * 
     * @param nodePath
     * @return
     */
    public static int[] regexNodepath(String nodePath)
    {
        String[] strs = nodePath.split(",");
        int[] iArray = new int[strs.length];
        for (int i = 0; i < strs.length; i++)
        {
            iArray[i] = Integer.valueOf(strs[i]);
        }

        return iArray;
    }

    /**
     * 正则获取数字
     * 
     * @param str
     * @return
     */
    public static int getNumberByPattern(String str)
    {
        return Integer.valueOf(Pattern.compile("\\D+").matcher(str)
                .replaceAll(""));
    }

    /**
     * 换行符
     * 
     * @return
     */
    public static String getPathSeparator()
    {
        String systemName = System.getProperty("os.name").toUpperCase();
        if (systemName.startsWith("WIN"))
        {
            return Constant.WLine_Delimiter;
        }
        else if (systemName.startsWith("UNIX")
                || systemName.startsWith("LINUX"))
        {
            return Constant.ULine_Delimiter;
        }
        else if (systemName.startsWith("MAX"))
        {
            return Constant.Mline_Delimiter;
        }
        return System.getProperty("line.separator");
    }

    /**
     * 获取当前时间
     * 
     * @return
     */
    public static String getTime()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS");
        return sdf.format(System.currentTimeMillis());
    }

}
