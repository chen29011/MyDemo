package com.cqlj.cataTools.chart.poi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public final class CommonUtils {
	static Properties prop = null;

	private CommonUtils() {
	}

	static {
		prop = new Properties();
		InputStream in = CommonUtils.class.getResourceAsStream("/param/excelToEntityMapping.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据参数名称返回/param/paramConfig.properties中配置的参数值
	 * 
	 * @param 参数名称
	 * @return 参数值
	 */
	public static String getParamcValue(String paramCode) {
		String temp = prop.getProperty(paramCode);
		if ("".equals(temp) || temp == null) {
			return temp;
		} else {
			return temp.trim();
		}
	}

	/**
	 * 获取当前系统时间，格式为：yyyy-MM-dd HH:mm:ss
	 */
	public static String getCurrentTime() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}

	/**
	 * 将传入的字符串首字母变为大写
	 * 
	 * @param s
	 *            需要转换的字符串
	 * @return 转换后的字符串
	 */
	public static String firstToUpperCase(String s) {
		if (Character.isUpperCase(s.charAt(0))) {
			return s;
		} else {
			return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1, s.length()))
					.toString();
		}
	}

	/**
	 * 获取用户id
	 **/
	public static Integer getUserId(HttpServletRequest request) {
		return (Integer) request.getSession().getAttribute("userSessionId");
	}

	

	/**
	 * 判断字符串是否为空
	 * @param string
	 * @return
	 */
	public static boolean isEmpty(CharSequence string) {
		return ((string == null) || (string.length() == 0));
	}
	
	/**
	 * 
	 * @param zf zip文件流
	 * @param projNo 项目编号
	 * @param path 照片存放路径
	 * @throws IOException
	 */
	public static void analyzePicture(ZipFile zf, String projNo, String filePath) throws IOException {
		// 判断是否存在该目录，如果存在则删除后再创建（支持重复上传），不存在就创建
		File fdir = new File(filePath + projNo);
		if (!fdir.exists()) {
			fdir.mkdirs();
		}
		FileOutputStream outputStream = null;
		ZipEntry entry = null;
		for (Enumeration<? extends ZipEntry> e = zf.getEntries(); e.hasMoreElements();) {
			entry = e.nextElement();
			if (entry.getName().toLowerCase().endsWith(".jpg")) {
				System.out.println("照片存放的地址为：" + filePath + entry.getName());
				InputStream is = zf.getInputStream(entry);
				File f = new File(filePath + entry.getName());
				if (!f.exists()) {
					f.createNewFile();
				}
				outputStream = new FileOutputStream(f);
				int size = 0;
				byte[] Buffer = new byte[1024 * 5];
				while ((size = is.read(Buffer)) != -1) {
					outputStream.write(Buffer, 0, size);
				}
			}
		}
		outputStream.flush();
		outputStream.close();
	}
}
