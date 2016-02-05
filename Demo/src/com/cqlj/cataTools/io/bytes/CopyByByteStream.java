package com.cqlj.cataTools.io.bytes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyByByteStream {
	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("D:\\");
		OutputStream os = new FileOutputStream("D:\\");
		byte input[] = new byte[50];
		long before = System.currentTimeMillis();
		int count = 0;
		while (is.read(input) != -1) {
			os.write(input);
			count++;
		}
		os.flush();
		os.close();
		is.close();
		System.out.println(System.currentTimeMillis() - before + "ms");
		System.out.println("done");
		System.out.println("读取了：" + count + "次");
	}
}
