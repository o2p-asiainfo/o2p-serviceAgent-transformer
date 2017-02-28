package com.ailk.eaap.integration.o2p.process;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.util.Assert;

import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.LogModel;
import com.asiainfo.foundation.log.Logger;
import com.ailk.eaap.op2.bo.Contract2AttrSpec;
import com.ailk.eaap.op2.bo.ContractFormat;
import com.ailk.eaap.op2.bo.MessageDesc;
import com.ailk.eaap.op2.bo.MessageNode;
import com.ailk.eaap.op2.bo.NodeDesc;

public class TxtTransformerProcessIn extends AbstractTransformerProcessIn
{

    private static final Logger LOG = Logger
            .getLog(TxtTransformerProcessIn.class);

    private static String txt_String = "o2p.serviceAgent.transformer.txtFile";

    @Override
    public Object parseNodeValBySrcMsg(MessageBO<?> srcMsg,
            ContractFormat contractFormat, NodeDesc nodeDesc)
    {
        txtAssert(srcMsg, contractFormat, nodeDesc);
        File file = null;
        file = judgeFile(srcMsg, file);
        judgeFileLog(file);

//        List<String> srcList = new ArrayList<String>();
        List<String> tarList = new ArrayList<String>();
        // According to the node Path for information
        int location = TransformerProcessUtils.getNumberByPattern(nodeDesc
                .getNodePath());
        // header
        if (nodeDesc.getNodeType().equals(Constant.NODETYPE_HEADER))
        {
            try
            {
                return judgeTarList(srcMsg, nodeDesc);
            }
            catch (IOException e)
            {
                LOG.error(LogModel.EVENT_APP_EXCPT,
                        "serviceAgent-transformer Read the Txt file header error");
                throw new BusinessException(9145, txt_String, null, e);
            }
        }
        // Judge the attribute is empty
        if (contractFormat.getContract2AttrSpecs().size() == 0)
        {
            propertiesToNull(file, tarList, location);
        }
        else
        {// Judge the attribute is not null
            String encoding = "";// coding
            String separators = "";// separators
            String newline = "";// A newline
            int ascii;
            List<Contract2AttrSpec> contract2AttrSpecss = contractFormat
                    .getContract2AttrSpecs();
            // Attribute information
            for (Contract2AttrSpec conAttrSpec : contract2AttrSpecss)
            {
                if (conAttrSpec.getAttrSpec().getAttrSpecCode().toLowerCase()
                        .equals(Constant.ENCODING))
                {
                    encoding = conAttrSpec.getValue();
                }
                else if (conAttrSpec.getAttrSpec().getAttrSpecCode()
                        .toLowerCase().equals(Constant.SEPARATORS))
                {
                    separators = conAttrSpec.getValue();
                }
                else if (conAttrSpec.getAttrSpec().getAttrSpecCode()
                        .toLowerCase().equals(Constant.NEWLINE))
                {
                    newline = conAttrSpec.getValue();
                }
                else if (conAttrSpec.getAttrSpec().getAttrSpecCode()
                        .toLowerCase().equals(Constant.ASCII_SEPARATORS))
                {
                    ascii = Integer.valueOf(conAttrSpec.getValue());
                    separators = Character.toString((char) ascii);
                }
                else if (conAttrSpec.getAttrSpec().getAttrSpecCode()
                        .toLowerCase().equals(Constant.ASCII_NEWLINE))
                {
                    ascii = Integer.valueOf(conAttrSpec.getValue());
                    newline = Character.toString((char) ascii);
                }
            }
            debugProperties(encoding, separators, newline);

            // Judge separator is empty
            judgeTxtSeparators(judgeTxtEncoding(file, encoding, newline), tarList, location, separators);
        }
        if (LOG.isDebugEnabled())
        {
            LOG.debug("file encoding {0}", System.getProperty("file.encoding"));
            LOG.debug("Default Charset {0}", Charset.defaultCharset());
            LOG.debug("Txt {0}" + location, tarList.toString());
        }

        return tarList;
    }

    protected List<String> judgeTarList(MessageBO<?> srcMsg, NodeDesc nodeDesc)
            throws IOException
    {
        List<String> tarList = new ArrayList<String>();
        tarList.add(srcMsg.getMsgHead().get(nodeDesc.getNodeCode()).toString());
        return tarList;
    }

    protected File judgeFile(MessageBO<?> srcMsg, File file)
    {
        if (srcMsg.getMsgBody() instanceof File[])
        {
            List<File> list = new ArrayList<File>();
            getList(srcMsg, list);
            judgeTxtList(list);
            file = list.get(0);
        }
        else if (srcMsg.getMsgBody() instanceof File)
        {
            file = (File) srcMsg.getMsgBody();
        }
        return file;
    }

    protected void getList(MessageBO<?> srcMsg, List<File> list)
    {
        File[] files = (File[]) srcMsg.getMsgBody();
        judgeFile(list, files);
    }

    protected void judgeTxtList(List<File> list)
    {
        if (list.size() > 1)
        {
            LOG.error(LogModel.EVENT_APP_EXCPT,
                    "serviceAgent-transformer Array type is a TXT file");
            throw new BusinessException(9145, txt_String, null);
        }
    }

    protected void judgeFileLog(File file)
    {
        Assert.notNull(file, "The TXT file is null");
        if (LOG.isDebugEnabled() && file != null)
        {
            LOG.debug("Txt File absolute path : {0}", file.getAbsolutePath());
        }
    }

    // 文件属性信息空
    protected void propertiesToNull(File file, List<String> tarList,
            int location)
    {
        List<String> srcList;
        try
        {
            srcList = FileUtils.readLines(file);
            Assert.notNull(srcList,
                    "When Contract2AttrSpecs is empty, The Txt list is null");
            for (int i = 0; i < srcList.size(); i++)
            {
                String[] lineInformation = srcList.get(i).split(";");
                if (lineInformation.length > 1)
                {
                    tarList.add(lineInformation[location]);
                }

            }
        }
        catch (IOException e)
        {
            LOG.error(LogModel.EVENT_APP_EXCPT,
                    "serviceAgent-transformer Read the Txt file attribute error");
            throw new BusinessException(9145, txt_String, null, e);
        }

    }

    protected void judgeTxtSeparators(List<String> srcList,
            List<String> tarList, int location, String separators)
    {
        if ("".equals(separators))
        {
            separators = ";";
        }
        for (String str : srcList)
        {
            String[] lineInformation = str.split(separators);
            if (lineInformation.length > 1)
            {
                if (location > lineInformation.length)
                {
                    LOG.error(LogModel.EVENT_APP_EXCPT,
                            "serviceAgent-transformer Txt an array");
                    throw new BusinessException(9145,
                            "o2p.serviceAgent.transformer.txtArray", null, null);
                }
                tarList.add(lineInformation[location]);
            }
        }
    }

    protected List<String> judgeTxtEncoding(File file, String encoding,
            String newline)
    {
        List<String> srcList = new ArrayList<String>();
        String fileStr;
        if ("".equals(encoding))
        {
            encoding = super.getEncoding();
        }
        if ("".equals(newline))
        {
            newline = TransformerProcessUtils.getPathSeparator();
        }

        try
        {
            fileStr = FileUtils.readFileToString(file, encoding);
            String[] newlineStr = fileStr.split(newline);
            for (String str : newlineStr)
            {
                srcList.add(str);
            }
            Assert.notNull(srcList,
                    "When Contract2AttrSpecs is not empty, Encoding is empty, The TXT list is null");
        }
        catch (IOException e)
        {
            LOG.error(LogModel.EVENT_APP_EXCPT,
                    "serviceAgent-transformer Read the Txt file attribute error");
            throw new BusinessException(9145, txt_String, null, e);
        }

        return srcList;
    }

    protected void debugProperties(String encoding, String separators,
            String newline)
    {
        if (LOG.isDebugEnabled())
        {
            LOG.debug("TXT parseNodeValBySrcMsg encoding {0}", encoding);
            LOG.debug("TXT parseNodeValBySrcMsg newline {0}", newline);
            LOG.debug("TXT parseNodeValBySrcMsg separators {0}", separators);
        }
    }

    protected void txtAssert(MessageBO<?> srcMsg,
            ContractFormat contractFormat, NodeDesc nodeDesc)
    {
        Assert.notNull(srcMsg.getMsgBody(), "The TXT MsgBody is null ");
        Assert.notNull(contractFormat, "The TXT contractFormat is null");
        Assert.notNull(nodeDesc, "The TXT nodeDesc is null");
    }

    @Override
    public MessageBO<?> processContent(MessageDesc md, MessageBO<?> bo)
            throws Exception
    {
        processContextDebug(md);
        List<MessageNode> messageNodes = md.getMessageNodes();
        Assert.notNull(messageNodes, "The TXT messageNodes is null");

        String encoding = "";// encoding
        String separators = "";// separators
        String newline = "";// A newline

        if (null != md.getAttrs())
        {
            List<Contract2AttrSpec> conAttrSpecs = md.getAttrs();
            // Attribute information
            for (Contract2AttrSpec conAttrSpec : conAttrSpecs)
            {
                if (conAttrSpec.getAttrSpec().getAttrSpecCode().toLowerCase()
                        .equals(Constant.ENCODING))
                {
                    encoding = conAttrSpec.getValue();
                }
                else if (conAttrSpec.getAttrSpec().getAttrSpecCode()
                        .toLowerCase().equals(Constant.SEPARATORS))
                {
                    separators = conAttrSpec.getValue();
                }
                else if (conAttrSpec.getAttrSpec().getAttrSpecCode()
                        .toLowerCase().equals(Constant.NEWLINE))
                {
                    newline = conAttrSpec.getValue();
                }
            }
        }

        elementDebug(encoding, separators, newline);
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        List<Integer> lengthList = new ArrayList<Integer>();
        StringBuilder sbu = new StringBuilder();

        judgeBody(messageNodes, map, lengthList);
        Collections.sort(lengthList);

        for (int i = 0; i < map.get(lengthList.get(0)).size(); i++)
        {
            appendLengthList(separators, map, lengthList, sbu, i);
            // Add a newline
            judgeNewLine(newline, sbu);
        }
        lengthList.clear();

        File file = null;
        if (bo.getMsgBody() instanceof File[])
        {
            List<File> list = new ArrayList<File>();
            File[] files = (File[]) bo.getMsgBody();
            judgeFile(list, files);
            if (list.size() > 1)
            {
                LOG.error(LogModel.EVENT_APP_EXCPT, "Array type is a TXT file");
                throw new BusinessException(9145, txt_String, null);
            }
            file = list.get(0);
        }
        else if (bo.getMsgBody() instanceof File)
        {
            file = (File) bo.getMsgBody();
        }
        Assert.notNull(file,
                "TXT file to perform processContent when the file is empty");
        String parentPath = "";
        if (null != file)
        {
            parentPath = file.getParent();
        }

        String fileName = null;
        if(file == null) {
        	fileName = "";
        } else {
        	fileName = file.getName();
        }
        String name = fileName.substring(0, fileName.lastIndexOf(".".toCharArray()[0]));
        if (LOG.isDebugEnabled())
        {
            LOG.debug("Txt processContent {0}", sbu.toString());
            LOG.debug("TXT name : {0}", name);
        }
        // The new file
        File newFile = new File(parentPath + File.separator + name + ".txt");
        judegNewFileOrEncoding(encoding, sbu, newFile);

        MessageBO<File[]> tarBO = new MessageBO<File[]>();
        File[] files =
        { newFile };
        tarBO.setMsgBody(files);

        Map<String, Object> msgMap = super.msgHeader(md);
        tarBO.setMsgHead(msgMap);

        return tarBO;
    }

    protected void judegNewFileOrEncoding(String encoding, StringBuilder sbu, File newFile) throws IOException {
        if (!newFile.exists()) {
            newFile.createNewFile();
        }
        else {
            newFile = new File(newFile.getParent() + File.separator + TransformerProcessUtils.getTime() + ".txt");
            if (!newFile.exists()) {
                newFile.createNewFile();
            }
        }

        if ("".equals(encoding)) {
            encoding = super.getEncoding();
        }
        FileUtils.writeStringToFile(newFile, sbu.toString(), encoding);
    }

    protected void judgeFile(List<File> list, File[] files)
    {
        for (File txt : files)
        {
            list.add(txt);
        }
    }

    protected void judgeNewLine(String newline, StringBuilder sbu)
    {
        if ("".equals(newline))
        {
            newline = TransformerProcessUtils.getPathSeparator();
        }
        sbu.append(newline);
    }

    protected void appendLengthList(String separators,
            Map<Integer, List<String>> map, List<Integer> lengthList,
            StringBuilder sbu, int i)
    {
        for (int j = 0; j < lengthList.size(); j++)
        {
            sbu.append(map.get(lengthList.get(j)).get(i));
            // Add a separator
            if ("".equals(separators) && j != map.size() - 1)
            {
                sbu.append(";");
            }
            else if (!"".equals(separators) && j != map.size() - 1)
            {
                sbu.append(separators);
            }
        }
    }

    @SuppressWarnings("unchecked")
    protected void judgeBody(List<MessageNode> messageNodes,
            Map<Integer, List<String>> map, List<Integer> lengthList)
    {
        for (int i = 0; i < messageNodes.size(); i++)
        {
            if (messageNodes.get(i).getNodeDesc().getNodeType()
                    .equals(Constant.NODETYPE_BODY))
            {
                int length = TransformerProcessUtils
                        .getNumberByPattern(messageNodes.get(i).getNodeDesc()
                                .getNodePath());
                map.put(length, (List<String>) messageNodes.get(i).getNodeVal());
                lengthList.add(length);
            }
        }
    }

    protected void elementDebug(String encoding, String separators,
            String newline)
    {
        if (LOG.isDebugEnabled())
        {
            LOG.debug("TXT processContent encoding {0}", encoding);
            LOG.debug("TXT processContent newline {0}", newline);
            LOG.debug("TXT processContent separators {0}", separators);
        }
    }

    protected void processContextDebug(MessageDesc md)
    {
        Assert.notNull(md, "The TXT MessageDesc is null");
        if (LOG.isDebugEnabled())
        {
            LOG.debug("TXT process type : {0}", md.getContractFormat()
                    .getConType());
        }
    }

}
