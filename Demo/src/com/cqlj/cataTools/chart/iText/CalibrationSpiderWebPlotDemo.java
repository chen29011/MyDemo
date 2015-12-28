package com.cqlj.cataTools.chart.iText;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;



/**
 * 刻度雷达图示例
 * @version 1.0
 */
public class CalibrationSpiderWebPlotDemo extends JFrame{

	private static final long serialVersionUID = 1L;

	/**
	 * 创建DEMO实例
	 * @param s
	 */
	public CalibrationSpiderWebPlotDemo(String s){
		super(s);
		JPanel jpanel = createDemoPanel();
		jpanel.setPreferredSize(new Dimension(600, 600));
		setContentPane(jpanel);
	}

	/**
	 * 构造数据集
	 * @return
	 */
	private static CategoryDataset createDataset(){
		String group1 = "示例程序";
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(50, group1, "示例A");
        dataset.addValue(0, group1, "示例B");
		return dataset;
	}

	/**
	 * 创建图表
	 * @param categorydataset
	 * @return
	 */
	public static JFreeChart createChart(){
		CategoryDataset categorydataset =createDataset();
//		MySpiderWebPlot spiderwebplot = new MySpiderWebPlot(categorydataset);  
		CalibrationSpiderWebPlot spiderwebplot = new CalibrationSpiderWebPlot(categorydataset);  
		spiderwebplot.setStartAngle(90D);//刻度轴方向:54度,默认是90度即垂直于水平面
		spiderwebplot.setInteriorGap(0.3D);
		spiderwebplot.setToolTipGenerator(new StandardCategoryToolTipGenerator());//标准分类提示器
		//是否画环
//		spiderwebplot.setDrawRing(false);
		//刻度最大值
//		spiderwebplot.setMaxValue(500);
		//刻度数
//		spiderwebplot.setTicks(5);
		//刻度前缀
		//spiderwebplot.setLablePrefix("%");
		//刻度后缀
//		spiderwebplot.setLableSuffix("%");
        JFreeChart jfreechart = new JFreeChart("示例", TextTitle.DEFAULT_FONT,spiderwebplot, false);
        jfreechart.setBackgroundPaint(Color.darkGray); //设置背景颜色
        LegendTitle legendtitle = new LegendTitle(spiderwebplot);
        legendtitle.setPosition(RectangleEdge.BOTTOM); //X说明所在的位置
        jfreechart.addSubtitle(legendtitle);
        //应用标准的主题外观
//    	ChartUtilities.applyCurrentTheme(jfreechart);
		return jfreechart;
	}
	/**
	 * 创建面板
	 * @return
	 */
	@SuppressWarnings("unused")
	public static JPanel createDemoPanel(){
		
		JFreeChart jfreechart = createChart();
		return new ChartPanel(jfreechart);
	}

	/**
	 * 程序入口
	 * @param args
	 */
	public static void main(String args[]){
		CalibrationSpiderWebPlotDemo calibrationSpiderWebPlotDemo = new CalibrationSpiderWebPlotDemo("JFreeChart: CalibrationSpiderWebPlotDemo.java");
		calibrationSpiderWebPlotDemo.pack();
		RefineryUtilities.centerFrameOnScreen(calibrationSpiderWebPlotDemo);
		calibrationSpiderWebPlotDemo.setVisible(true);
	}
}
