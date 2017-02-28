package com.ailk.eaap.integration.xquery;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import org.apache.activemq.util.IOExceptionSupport;

/**
 * Created by david on 14-7-24.
 */
public class CommonFileUtils {

    public static void writeFileByPath(String path, String param) {
        BufferedWriter outputStream = null;
        OutputStreamWriter osw = null;
        FileOutputStream fos = null;
        try {
        	fos = new FileOutputStream(path);
        	osw = new OutputStreamWriter(fos, "UTF-8");
            outputStream = new BufferedWriter(osw);
            int i = 0;
            String separators = Character.toString((char) 0x0A);
            while(i<600000) {
                outputStream.write(param + separators);
                i++;
            }
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        	try {
	        	if(outputStream != null) {
	        		outputStream.close();
	        		outputStream = null;
	        	}
	        	if(osw != null) {
	        		osw.close();
	        		osw = null;
	        	}
	        	if(fos != null) {
	        		fos.close();
	        		fos = null;
	        	}
        	} catch(IOException e) {
        		e.printStackTrace();
        	}
        }
    }

    private static void writeFileByLine(FileChannel outFileChannel, ByteBuffer wBuffer, String line) {
        try {
            outFileChannel.write(wBuffer.wrap(line.getBytes()), outFileChannel.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readAndWrite(String inPath, String outPath) throws IOException {
        ByteBuffer byteBuf = ByteBuffer.allocate(1024 * 14 * 1024);
        byte[] bbb = new byte[14 * 1024 * 1024];
        File file1 = new File(inPath);
        File file2 = new File(outPath);
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel fc = null;
        FileChannel fo = null;
        try {
	        fis = new FileInputStream(file1);
	        fos = new FileOutputStream(file2);
	        fc = fis.getChannel();
	        fo = fos.getChannel();
	        long timeStar = System.currentTimeMillis();// 得到当前的时间
	//        fc.read(byteBuf);// 1 读取
	        MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
	        System.out.println(fc.size() / 1024);
	        long timeEnd = System.currentTimeMillis();// 得到当前的时间
	        System.out.println("Read time :" + (timeEnd - timeStar) + "ms");
	        timeStar = System.currentTimeMillis();
	//        fos.write(bbb);//2.写入
	        // 记得执行这个方法，使得 position=0, limit=30, 才能写入正确的数据
	        // 否则 position 为 30, limit 为 1024，将会把 30 之后的全部空数据(0) 填到文件中
	        while(mbb.hasRemaining()) {
	            fo.write(mbb);
	        }
	        mbb.flip();
	        timeEnd = System.currentTimeMillis();
	        System.out.println("Write time :" + (timeEnd - timeStar) + "ms");
        } catch(IOException e) {
        	throw e;
        } finally {
    		try {
    			if(fc != null) {
	        		fc.close();
	        		fc = null;
    			}
    			if(fo != null) {
	    			fo.close();
	    			fo = null;
    			}
    			if(fis != null) {
    				fis.close();
    				fis = null;
    			}
    			if(fos != null) {
    				fos.close();
    				fos = null;
    			}
    		} catch(IOException e) {
    			throw e;
    		}
        }
    }

    /**
     *
     * @param inPath
     * @throws IOException
     */
    public static void getFileTxtByAll(String inPath) throws IOException {
        FileInputStream fis = new FileInputStream(inPath);
        FileChannel fc = fis.getChannel();
        //分配与文件尺寸等大的缓冲区
        ByteBuffer bf = ByteBuffer.allocate((int) fc.size());
        //读入缓冲区，即是内存映射文件
        fc.read(bf);
        //把缓冲中当前位置回复为零
        bf.rewind();
        //输出缓冲区中的内容
        while (bf.hasRemaining()) {
            System.out.print((char) bf.get());
        }
    }

    /**
     *
     * @param inPath
     * @throws IOException
     */
    public static void getFileTxtByBuffSize(String inPath) throws IOException {
        FileInputStream fis = null;
        FileChannel fc = null;
        try {
        	fis = new FileInputStream(inPath);
        	fc = fis.getChannel();
	        //分配与文件尺寸等大的缓冲区
	        ByteBuffer bf = ByteBuffer.allocate(1024);
	        // 读取通道中的下一块数据到缓冲区中
	        // 缓冲区的 position 即为当前缓冲区中最后有效位置
	        while (fc.read(bf) != -1) {
	            //把缓冲中当前位置回复为零，前把缓冲区的 limit 设置为之前 position 值
	            bf.flip();
	            //输出缓冲区中的内容
	//            while (bf.hasRemaining()) {
	//                System.out.print((char) bf.get());
	//            }
	            //把缓冲中当前位置回复为零
	            bf.clear();
	        }
        } catch(IOException e) {
        	throw e;
        } finally {
        	try {
	        	if(fc != null) {
	        		fc.close();
	        		fc = null;
	        	}
	        	if(fis != null) {
	        		fis.close();
	        		fis = null;
	        	}
        	} catch(IOException ex) {
        		throw ex;
        	}
        }
    }

    /**
     *
     * @param inPath
     * @throws IOException
     */
    public static void writeFileTxtByBuffSize(String inPath, String outPath) throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel fc = null;
        FileChannel fo = null;
        try {
        	fis = new FileInputStream(inPath);
        	fos = new FileOutputStream(outPath);
        	fc = fis.getChannel();
        	fo = fos.getChannel();
	        //分配与文件尺寸等大的缓冲区
	        ByteBuffer bf = ByteBuffer.allocate(1024);
	        long start = System.currentTimeMillis();
	        while(true)
	        {
	            int eof = fc.read(bf);
	            if(eof == -1 ) break;
	            bf.flip();
	            fo.write(bf);
	            bf.clear();
	        }
	        System.out.println("time : " + (System.currentTimeMillis()-start));
        } catch(IOException e) {
        	throw e;
        } finally {
        	if(fc != null) {
        		fc.close();
        		fc = null;
        	}
        	if(fo != null) {
        		fo.close();
        		fo = null;
        	}
        	if(fis != null) {
        		fis.close();
        		fis = null;
        	}
        	if(fos != null) {
        		fos.close();
        		fos = null;
        	}
        }
        fc.close();
        fo.close();
    }

    public static void readFileByLine(int buff, String inPath, String outPath) {
        String enter = Character.toString((char) 0x0A);;
        byte[] bytes = new byte[buff];
        FileChannel inFileChannel = null;
        FileChannel outFileChannel = null;
        StringBuffer stringBuffer = new StringBuffer("");
        ByteBuffer rBuffer = null;
        ByteBuffer wBuffer = null;
        try {
            inFileChannel = new RandomAccessFile(new File(inPath),"r").getChannel();
            outFileChannel = new RandomAccessFile(new File(outPath),"rws").getChannel();
            rBuffer = ByteBuffer.allocate(buff);
            wBuffer = ByteBuffer.allocateDirect(buff);
            while(inFileChannel.read(rBuffer) != -1) {
                int rSize = rBuffer.position();
                rBuffer.rewind();
                rBuffer.get(bytes);
                rBuffer.clear();
                String tempString = new String(bytes, 0, rSize);
                int fromIndex = 0;
                int endIndex = 0;
                while((endIndex = tempString.indexOf(enter, fromIndex)) != -1){
                    String line = tempString.substring(fromIndex, endIndex);
                    line = new String(stringBuffer.toString() + line);
                    //write to anthone file
                    writeFileByLine(outFileChannel, wBuffer, line);
                    stringBuffer.delete(0, stringBuffer.length());
                    fromIndex = endIndex + 1;
                }
                if(rSize > tempString.length()){
                    stringBuffer.append(tempString.substring(fromIndex, tempString.length()));
                }else{
                    stringBuffer.append(tempString.substring(fromIndex, rSize));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readAndWrite2(String inPath, String outPath) throws IOException {
        ByteBuffer byteBuf = ByteBuffer.allocate(1024 * 14 * 1024);
        byte[] bbb = new byte[14 * 1024 * 1024];
        File file1 = new File(inPath);
        File file2 = new File(outPath);
        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);
        FileChannel fc = fis.getChannel();
        FileChannel fo = fos.getChannel();
        long timeStar = System.currentTimeMillis();// 得到当前的时间
//        fc.read(byteBuf);// 1 读取
        MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());

        while(mbb.get() != -1) {

        }
        System.out.println(mbb.toString());

    }

    public static void getBigTxt(String path) throws IOException {
        File file = new File(path);
        BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file));
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis,"utf-8"),5*1024*1024);// 用5M的缓冲读取文本文件

        String line = "";
        while((line = reader.readLine()) != null){
        }
    }

    public static long getFileSize(String str) {
        File file = new File(str);
        return file.length();
    }

}
