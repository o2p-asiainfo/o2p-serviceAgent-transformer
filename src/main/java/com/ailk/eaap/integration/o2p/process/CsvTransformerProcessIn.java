package com.ailk.eaap.integration.o2p.process;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.util.Assert;

import au.com.bytecode.opencsv.CSVReader;

import com.ailk.eaap.op2.serviceagent.common.MessageBO;
import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.LogModel;
import com.asiainfo.foundation.log.Logger;
import com.ailk.eaap.op2.bo.Contract2AttrSpec;
import com.ailk.eaap.op2.bo.ContractFormat;
import com.ailk.eaap.op2.bo.MessageDesc;
import com.ailk.eaap.op2.bo.MessageNode;
import com.ailk.eaap.op2.bo.NodeDesc;

public class CsvTransformerProcessIn extends AbstractTransformerProcessIn
{

    private static final Logger LOG = Logger
            .getLog(CsvTransformerProcessIn.class);

    private String csv_String = "o2p.serviceAgent.transformer.csvFile";

    @Override
    public Object parseNodeValBySrcMsg(MessageBO<?> srcMsg,
            ContractFormat contractFormat, NodeDesc nodeDesc)
    {
        csvAssert(srcMsg, contractFormat, nodeDesc);
        File file = csvFile(srcMsg);
        String encoding = "";// 编码
        String separators = "";// 分隔符
        int ascii;

        csvAssertFile(file);
        List<String> tarList = new ArrayList<String>();
        // 获取节点Path
        int location = TransformerProcessUtils.getNumberByPattern(nodeDesc
                .getNodePath());
        // header
        if (nodeDesc.getNodeType().equals(Constant.NODETYPE_HEADER))
        {
            return csvGetHeaderVal(srcMsg, nodeDesc);
        }
        CSVReader csvReader = null;
        int rowNumber = 0;
        // 判断属性为空情况
        if (contractFormat.getContract2AttrSpecs().size() == 0)
        {
            csvGetBodyValByAttrNull(file, tarList, location, rowNumber);
        }
        else
        {// 判断属性不为空情况
            List<Contract2AttrSpec> contract2AttrSpecss = contractFormat
                    .getContract2AttrSpecs();
            // 获取属性信息
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
                        .toLowerCase().equals(Constant.ASCII_SEPARATORS))
                {
                    ascii = Integer.valueOf(conAttrSpec.getValue());
                    separators = Character.toString((char) ascii);
                }
            }

            debugProperties(encoding, separators);
            if ("".equals(encoding))
            {
                encoding = "gbk";
            }
            if ("".equals(separators))
            {
                separators = ",";
            }
            char car = separators.toCharArray()[0];
            debugProperties(encoding, separators);

            BufferedReader br = null;
            InputStreamReader isr = null;
            FileInputStream fis = null;
            try
            {
            	fis = new FileInputStream(file);
            	isr = new InputStreamReader(fis,encoding);
            	br = new BufferedReader(isr, car);
                csvReader = new CSVReader(br);
                if (null != csvReader)
                {
                    tarList = csvGetBodyVal(location, csvReader, rowNumber);
                }
            }
            catch (UnsupportedEncodingException e)
            {
                LOG.error(LogModel.EVENT_APP_EXCPT, e);
                throw new BusinessException(9152, csv_String, null, e);
            }
            catch (FileNotFoundException e)
            {
                LOG.error(LogModel.EVENT_APP_EXCPT, e);
                throw new BusinessException(9152, csv_String, null, e);
            } finally {
            	try {
	            	if(csvReader != null) {
	            		csvReader.close();
	            		csvReader = null;
	            	}
	            	if(br != null) {
	            		br.close();
	            		br = null;
	            	}
	            	if(isr != null) {
	            		isr.close();
	            		isr = null;
	            	}
	            	if(fis != null) {
	            		fis.close();
	            		fis = null;
	            	}
            	} catch(IOException e) {
            		throw new BusinessException(9152, csv_String, null, e);
            	}
            }
        }
        if (LOG.isDebugEnabled())
        {
            LOG.debug("file encoding {0}", System.getProperty("file.encoding"));
            LOG.debug("Default Charset {0}", Charset.defaultCharset());
            LOG.debug("Csv " + location + " {0}", tarList.toString());
        }

        return tarList;
    }

    // 获取节点值信息
    protected List<String> csvGetBodyVal(int location, CSVReader csvReader,
            int rowNumber)
    {
        List<String> tarList = new ArrayList<String>();
        String[] csvRow;
        try
        {
            while (null != (csvRow = csvReader.readNext()))
            {
                rowNumber++;
                if (location > csvRow.length)
                {
                    LOG.error(LogModel.EVENT_APP_EXCPT, "(" + rowNumber
                            + ")  Error line dividing the number of columns.");
                    throw new BusinessException(9152, csv_String, null);

                }
                tarList.add(csvRow[location]);
            }
        }
        catch (IOException e)
        {
            LOG.error(LogModel.EVENT_APP_EXCPT, e);
            throw new BusinessException(9152, csv_String, null, e);
        }
        return tarList;
    }

    // DEBUG File
    protected void csvAssertFile(File file)
    {
        Assert.notNull(file, "The CSV file is null");
        if (LOG.isDebugEnabled())
        {
            if (null != file)
            {
                LOG.debug("CSV File absolute path : {0}",
                        file.getAbsolutePath());
            }
        }
    }

    @SuppressWarnings("resource")
    // body val by attr is null
    protected void csvGetBodyValByAttrNull(File file, List<String> tarList,
            int location, int rowNumber)
    {
        CSVReader csvReader = null;
        String[] csvRow;
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try
        {
        	fis = new FileInputStream(file);
        	isr = new InputStreamReader(fis, super.getEncoding());
        	br = new BufferedReader(isr);
            csvReader = new CSVReader(br);
            if (null != csvReader)
            {
                while (null != (csvRow = csvReader.readNext()))
                {
                    rowNumber++;
                    if (location > csvRow.length)
                    {
                        LOG.error(
                                LogModel.EVENT_APP_EXCPT,
                                "("
                                        + rowNumber
                                        + ")  Error line dividing the number of columns.");
                        throw new BusinessException(9152, csv_String, null);

                    }
                    tarList.add(csvRow[location]);
                }
            }

        }
        catch (IOException e)
        {
            LOG.error(LogModel.EVENT_APP_EXCPT, e.getMessage());
            throw new BusinessException(9152, csv_String, null, e);
        } finally {
        	try {
	        	if(csvReader != null) {
	        		csvReader.close();
	        		csvReader = null;
	        	}
	        	if(br != null) {
	        		br.close();
	        		br = null;
	        	}
	        	if(isr != null) {
	        		isr.close();
	        		isr = null;
	        	}
	        	if(fis != null) {
	        		fis.close();
	        		fis = null;
	        	}
        	} catch(IOException e) {
        		throw new BusinessException(9152, csv_String, null, e);
        	}
        }
    }

    // 获取header信息
    protected List<String> csvGetHeaderVal(MessageBO<?> srcMsg,
            NodeDesc nodeDesc)
    {

        List<String> tarList = new ArrayList<String>();
        tarList.add(srcMsg.getMsgHead().get(nodeDesc.getNodeCode()).toString());
        return tarList;
    }

    protected void csvAssert(MessageBO<?> srcMsg,
            ContractFormat contractFormat, NodeDesc nodeDesc)
    {
        Assert.notNull(srcMsg.getMsgBody(), "The CSV MsgBody is null ");
        Assert.notNull(contractFormat, "The CSV contractFormat is null");
        Assert.notNull(nodeDesc, "The CSV nodeDesc is null");
    }

    protected void debugProperties(String encoding, String separators)
    {
        if (LOG.isDebugEnabled())
        {
            LOG.debug("CSV parseNodeValBySrcMsg encoding {0}", encoding);
            LOG.debug("CSV parseNodeValBySrcMsg separators {0}", separators);
        }
    }

    // 获取文件信息
    protected File csvFile(MessageBO<?> srcMsg)
    {
        File file = null;
        if (srcMsg.getMsgBody() instanceof File[])
        {
            List<File> list = new ArrayList<File>();
            File[] files = (File[]) srcMsg.getMsgBody();
            for (File csv : files)
            {
                list.add(csv);
            }
            if (list.size() > 1)
            {
                LOG.error("serviceAgent-transformer",
                        "Array type is a CSV file");
                throw new BusinessException(9145, csv_String, null);
            }
            file = list.get(0);
        }
        else if (srcMsg.getMsgBody() instanceof File)
        {
            file = (File) srcMsg.getMsgBody();
        }
        return file;
    }

    @Override
    public MessageBO<?> processContent(MessageDesc md, MessageBO<?> bo)
            throws Exception
    {
        processContentDebug(md);
        List<MessageNode> messageNodes = md.getMessageNodes();
        Assert.notNull(messageNodes, "The CSV messageNodes is null");

        String encoding = "";// 编码
        String separators = "";// 分隔符
        String newline = "";// 换行符

        if (null != md.getAttrs())
        {
            List<Contract2AttrSpec> conAttrSpecs = md.getAttrs();
            // 获取属性信息
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
        debug(encoding, separators, newline);
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        List<Integer> lengthList = new ArrayList<Integer>();
        StringBuilder sbu = new StringBuilder();
        judgeBody(messageNodes, map, lengthList);
        Collections.sort(lengthList);

        for (int i = 0; i < map.get(lengthList.get(0)).size(); i++)
        {
            judgeNewLine(separators, newline, map, lengthList, sbu, i);
        }

        lengthList.clear();

        File file = null;
        if (bo.getMsgBody() instanceof File[])
        {
            file = judgeFile(bo);
        }
        else if (bo.getMsgBody() instanceof File)
        {
            file = (File) bo.getMsgBody();
        }
        Assert.notNull(file,
                "CSV file to perform processContent when the file is empty");
        String parentPath = "";
        if (null != file)
        {
            parentPath = file.getParent();
        }
        if (LOG.isDebugEnabled())
        {
            LOG.debug("Csv processContent {0}", sbu.toString());
            if(null != file) {
            	LOG.debug("Csv processContent file name {0}", file.getName());
            } else {
            	LOG.debug("Csv processContent file name {0}", null);
            }
        }
        String fileName = null;
        if(file == null) {
        	fileName = "";
        } else {
        	fileName = file.getName();
        }
         
        String name = fileName.substring(0, fileName.lastIndexOf("."));

        // 新建文件
        File newFile = new File(parentPath + File.separator + name + ".csv");
        if (!newFile.exists())
        {
            boolean nbl = newFile.createNewFile();
            if (!nbl && LOG.isDebugEnabled())
            {
                LOG.debug("create file error {0}", newFile.getAbsolutePath());
            }
        }
        else
        {
            newFile = new File(parentPath + File.separator
                    + TransformerProcessUtils.getTime() + ".csv");
            boolean nbl = newFile.createNewFile();
            if (!nbl && LOG.isDebugEnabled())
            {
                LOG.debug("create file error {0}", newFile.getAbsolutePath());
            }
        }

        if ("".equals(encoding))
        {
            encoding = "gbk";
        }
        FileUtils.writeStringToFile(newFile, sbu.toString(), encoding);

        MessageBO<File[]> tarBO = new MessageBO<File[]>();
        File[] files =
        { newFile };
        tarBO.setMsgBody(files);

        Map<String, Object> msgMap = super.msgHeader(md);
        tarBO.setMsgHead(msgMap);

        return tarBO;
    }

    protected void processContentDebug(MessageDesc md)
    {
        Assert.notNull(md, "The CSV MessageDesc is null");
        if (LOG.isDebugEnabled())
        {
            LOG.debug("Csv process type : {0}", md.getContractFormat()
                    .getConType());
        }
    }

    protected File judgeFile(MessageBO<?> bo)
    {
        File file;
        List<File> list = new ArrayList<File>();
        File[] files = (File[]) bo.getMsgBody();
        for (File csv : files)
        {
            list.add(csv);
        }
        if (list.size() > 1)
        {
            LOG.error(LogModel.EVENT_APP_EXCPT, "Array type is a CSV file");
            throw new BusinessException(9145, csv_String, null);
        }
        file = list.get(0);
        return file;
    }

    protected void judgeNewLine(String separators, String newline,
            Map<Integer, List<String>> map, List<Integer> lengthList,
            StringBuilder sbu, int i)
    {
        for (int j = 0; j < lengthList.size(); j++)
        {
            sbu.append(map.get(lengthList.get(j)).get(i));
            // Add a separator
            if ("".equals(separators) && j != map.size() - 1)
            {
                sbu.append(",");
            }
            else if (!"".equals(separators) && j != map.size() - 1)
            {
                sbu.append(separators);
            }
        }
        // 添加换行符
        if ("".equals(newline))
        {
            newline = TransformerProcessUtils.getPathSeparator();
        }
        sbu.append(newline);
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

    protected void debug(String encoding, String separators, String newline)
    {
        if (LOG.isDebugEnabled())
        {
            LOG.debug("CSV processContent encoding {0}", encoding);
            LOG.debug("CSV processContent newline {0}", newline);
            LOG.debug("CSV processContent separators {0}", separators);
        }
    }

}
