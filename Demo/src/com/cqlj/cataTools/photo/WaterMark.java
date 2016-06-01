package com.cqlj.cataTools.photo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.ImageIcon;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
public class WaterMark {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 //1.jpg是你的 主图片的路径
        InputStream is = new FileInputStream("D:\\wp\\aa.jpg");
        //通过JPEG图象流创建JPEG数据流解码器
        JPEGImageDecoder jpegDecoder = JPEGCodec.createJPEGDecoder(is);
        //解码当前JPEG数据流，返回BufferedImage对象
        BufferedImage buffImg = jpegDecoder.decodeAsBufferedImage();
        System.out.println(buffImg.getHeight()+""+buffImg.getWidth());
        //得到画笔对象
        Graphics g = buffImg.getGraphics();
        //创建你要附加的图象。
        //2.jpg是你的小图片的路径
        ImageIcon imgIcon = new ImageIcon("D:\\wp\\wpx.png"); 
        //得到Image对象。
        Image img = imgIcon.getImage();
        //将小图片绘到大图片上。
        //5,300 .表示你的小图片在大图片上的位置。
        g.drawImage(img,buffImg.getWidth()-135,buffImg.getHeight()-35,null);
        g.dispose();
        OutputStream os = new FileOutputStream("D:\\wp\\union.jpg");
        //创键编码器，用于编码内存中的图象数据。
        JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(os);
        en.encode(buffImg);
        is.close();
        os.close();
        System.out.println ("合成结束。。。。。。。。");
	}

}
