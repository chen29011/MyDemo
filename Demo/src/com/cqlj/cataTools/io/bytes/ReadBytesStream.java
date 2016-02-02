package com.cqlj.cataTools.io.bytes;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadBytesStream {

	public static void main(String[] args) throws Exception {
		InputStream fis = new FileInputStream("D:\\text.txt");
		byte input[] = new byte[55];
		fis.read(input);

		String inputString = new String(input, "UTF-8");
		System.out.println(inputString);
		fis.close();
	}
}
