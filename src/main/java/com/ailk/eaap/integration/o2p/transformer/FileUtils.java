package com.ailk.eaap.integration.o2p.transformer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.dom4j.Document;
import org.dom4j.Element;

import com.asiainfo.foundation.exception.BusinessException;
import com.asiainfo.foundation.log.Logger;
import com.ailk.eaap.op2.bo.EndpointAttr;
import com.ailk.eaap.op2.bo.TechImpl;

public final class FileUtils
{
    private static final Logger log = Logger.getLog(FileUtils.class);

    /**
     * 
     * @param tech
     * @param message
     * @param extension
     *            :such as xml or json ect.
     */
    public static void message2File(TechImpl tech, Object message,
            String extension)
    {
        String fileName = tech.getAttrMap().get(EndpointAttr.FILE_NAME);
        String productLocalPath = tech.getAttrMap().get(
                EndpointAttr.PRODUCT_LOCAL_PATH);
        FileOutputStream fout = null;
        StringBuffer jsonSb = new StringBuffer();
        try
        {
            Document doc = (Document) message;
            Element root = doc.getRootElement();
            root = (Element) root.elements().get(1);
            for (Iterator<?> iterator = root.elementIterator(); iterator
                    .hasNext();)
            {
                Element element = (Element) iterator.next();
                if ("/Reliance:EnterpriseProductCatalog/Reliance:Body/Reliance:ProductOffering"
                        .equals(element.getUniquePath()))
                {
                    jsonSb.append("{\"items\":[");
                    for (Iterator<?> items = element.elementIterator(); items
                            .hasNext();)
                    {
                        Element item = (Element) items.next();
                        jsonSb.append("{");
                        for (Iterator<?> values = item.elementIterator(); values
                                .hasNext();)
                        {
                            Element value = (Element) values.next();
                            jsonSb.append("\"" + value.getQName().getName()
                                    + "\"" + ":\"" + value.getText() + "\",");
                        }
                        jsonSb.deleteCharAt(jsonSb.length() - 1);
                        jsonSb.append("},");
                        jsonSb.append("\n");
                    }
                    jsonSb.deleteCharAt(jsonSb.length() - 1);
                    jsonSb.deleteCharAt(jsonSb.length() - 1);
                    jsonSb.append("]}");
                }
            }
            StringBuffer sbu = new StringBuffer();
            sbu.append(productLocalPath).append(fileName).append("_")
                    .append(getSystemDate()).append(".").append(extension);
            fout = new FileOutputStream(sbu.toString());
            fout.write(jsonSb.toString().getBytes());
            fout.close();
        }
        catch (Exception e)
        {
            log.error("transformer to file failed!", e);
            throw new BusinessException(9999, "transformer to file failed!");
        } finally {
        	try {
	        	if(fout != null) {
	        		fout.close();
	        		fout = null;
	        	}
        	} catch(IOException e) {
        		throw new BusinessException(9999, "transformer to file failed!", e);
        	}
        }
    }

    @SuppressWarnings("deprecation")
    public static void string2Excel(TechImpl tech, Document doc)
    {
        String fileName = tech.getAttrMap().get(EndpointAttr.FILE_NAME);
        String productLocalPath = tech.getAttrMap().get(
                EndpointAttr.PRODUCT_LOCAL_PATH);

        try
        {
            /* parse to dom */

            /* define file */
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet("PLAN_PARAMS");
            HSSFRow row = sheet.createRow((int) 0);
            HSSFCellStyle style = wb.createCellStyle();
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            HSSFFont font = wb.createFont();
            style.setFont(font);
            HSSFCell cell = row.createCell((short) 0);
            cell.setCellValue("Name");
            cell.setCellStyle(style);
            cell = row.createCell((short) 1);
            cell.setCellValue("Value");
            cell.setCellStyle(style);
            cell = row.createCell((short) 2);
            cell.setCellValue("Comparable");
            cell.setCellStyle(style);
            Element root = doc.getRootElement();
            /* set body content */
            for (Iterator<?> iterator = root.elementIterator(); iterator
                    .hasNext();)
            {
                Element element = (Element) iterator.next();
                log.debug(element.element("name").getText());
                row = sheet.createRow(sheet.getLastRowNum() + 1);
                row.createCell((short) 0).setCellValue(
                        element.element("name").getText());
                row.createCell((short) 1).setCellValue(
                        element.element("value").getText());
                row.createCell((short) 2).setCellValue(
                        element.element("Comparable").getText() == null ? ""
                                : element.element("Comparable").getText());
            }
            /* write to file */
            StringBuffer sbu = new StringBuffer();
            sbu.append(productLocalPath).append(fileName).append("_")
                    .append(getSystemDate()).append(".xlsx");
            FileOutputStream fout = new FileOutputStream(sbu.toString());
            wb.write(fout);
            fout.close();
        }
        catch (Exception e)
        {
            log.error("transform to excel file error!", e);
            throw new BusinessException(9999, "transform to excel file error!");
        }
    }

    private static String getSystemDate()
    {
        String time = "";
        Date d = new Date(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        time = formatter.format(d);
        return time;
    }
}
