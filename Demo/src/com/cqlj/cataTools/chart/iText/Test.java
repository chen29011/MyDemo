package com.cqlj.cataTools.chart.iText;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.cqlj.model.Student;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Test {
	public static Document writeIn(Document doc, Student stu) {

		return doc;
	}

	public static void main(String[] args) throws Exception {
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream("E://" + "createSamplePDF.pdf"));
		document.open();
		BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
		Font f12 = new Font(bfChinese, 12, Font.BOLD);
		Font f2 = new Font(bfChinese, 2, Font.NORMAL);
		Font f6 = new Font(bfChinese, 6, Font.NORMAL);
		Font f8 = new Font(bfChinese, 8, Font.NORMAL);
		Font f10 = new Font(bfChinese, 10, Font.NORMAL);
		List<Student> ls = new ArrayList<Student>();
		Student stu = new Student();
		stu.setId(1);
		stu.setStuName("张三");
		stu.setAge(22);
		stu.setSex("男");
		ls.add(stu);
		stu = new Student();
		stu.setId(2);
		stu.setSex("男");
		stu.setAge(23);
		stu.setStuName("李四");
		ls.add(stu);

		document.add(new Paragraph("学生信息", f12));
		document.add(new Paragraph(" ", f6));
		if (ls != null && ls.size() > 0) {
			PdfPTable table = new PdfPTable(4);
			table.setWidthPercentage(100);
			table.setHorizontalAlignment(PdfPTable.ALIGN_LEFT);
			PdfPCell cell = new PdfPCell();
			cell.setBackgroundColor(BaseColor.WHITE);
			cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			cell.setPhrase(new Paragraph("学号", f8));
			table.addCell(cell);
			cell.setPhrase(new Paragraph("姓名", f8));
			table.addCell(cell);
			cell.setPhrase(new Paragraph("性别", f8));
			table.addCell(cell);
			cell.setPhrase(new Paragraph("年龄", f8));
			table.addCell(cell);
			PdfPCell newcell = new PdfPCell();
			newcell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			System.out.println(ls.size());
			for (int i = 0; i < ls.size(); i++) {
				stu = ls.get(i);
				newcell.setPhrase(new Paragraph(stu.getId().toString(), f6));
				table.addCell(newcell);
				newcell.setPhrase(new Paragraph(stu.getStuName().toString(), f6));
				table.addCell(newcell);
				newcell.setPhrase(new Paragraph(stu.getSex().toString(), f6));
				table.addCell(newcell);
				newcell.setPhrase(new Paragraph(stu.getAge().toString(), f6));
				table.addCell(newcell);
			}
			document.add(table);
		}
		Image img = Image.getInstance("src/source/test04.png");
		//img.setRotation(-20);//旋转 弧度
		//img.setRotationDegrees(45);// 旋转 角度
		//img.scaleAbsolute(200,200);//自定义大小
		img.scalePercent(50);//依照比例缩放
		img.setAlignment(Element.ALIGN_CENTER);
		document.add(img);
		document.close();
	}
}
