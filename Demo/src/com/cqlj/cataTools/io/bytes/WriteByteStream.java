package com.cqlj.cataTools.io.bytes;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteByteStream {

	public static void main(String[] args) throws Exception {
		OutputStream os = new FileOutputStream("D:\\text2.txt");
		String outString = "write 123456写出数据";
		byte output[] = outString.getBytes("UTF-8");
		os.write(output);
		os.close();
	}

}
