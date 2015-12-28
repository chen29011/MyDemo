package com.cqlj.cataTools.chart.JFreeChartTest2;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class JFreeChartTest2 extends ApplicationFrame {

	public JFreeChartTest2(String title, DefaultCategoryDataset cd) {
		super(title);
		this.setContentPane(createChart(cd)); // 构造函数中自动创建Java的panel面板
	}

	public ChartPanel createChart(CategoryDataset dataset) // 用数据集创建一个图表
	{
		// 创建主题样式
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
		// 设置标题字体
		standardChartTheme.setExtraLargeFont(new Font("隶书", Font.BOLD, 20));
		// 设置图例的字体
		standardChartTheme.setRegularFont(new Font("宋书", Font.PLAIN, 15));
		// 设置轴向的字体
		standardChartTheme.setLargeFont(new Font("宋书", Font.PLAIN, 15));
		// 应用主题样式
		ChartFactory.setChartTheme(standardChartTheme);
		JFreeChart chart = ChartFactory.createBarChart("hi", "月份", "数值", dataset, PlotOrientation.VERTICAL, true, true,
				false); // 创建一个JFreeChart
		chart.setTitle(new TextTitle("气象数据拟合图", new Font("宋体", Font.BOLD + Font.ITALIC, 20)));// 可以重新设置标题，替换“hi”标题
		CategoryPlot plot = (CategoryPlot) chart.getPlot();// 获得图标中间部分，即plot
		CategoryAxis categoryAxis = plot.getDomainAxis();// 获得横坐标
		categoryAxis.setLabelFont(new Font("微软雅黑", Font.BOLD, 12));// 设置横坐标字体
		return new ChartPanel(chart);
	}

	public static void main(String[] args) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(10, "NASA", "1");
		dataset.setValue(15, "SolarGis", "1");
		dataset.setValue(20, "数据库拟合", "1");
		dataset.setValue(40, "预测", "1");

		dataset.setValue(10, "NASA", "2");
		dataset.setValue(15, "SolarGis", "2");
		dataset.setValue(20, "数据库拟合", "2");
		dataset.setValue(40, "预测", "2");

		dataset.setValue(10, "NASA", "3");
		dataset.setValue(15, "SolarGis", "3");
		dataset.setValue(20, "数据库拟合", "3");
		dataset.setValue(40, "预测", "3");

		dataset.setValue(10, "NASA", "4");
		dataset.setValue(15, "SolarGis", "4");
		dataset.setValue(20, "数据库拟合", "4");
		dataset.setValue(40, "预测", "4");

		dataset.setValue(10, "NASA", "5");
		dataset.setValue(15, "SolarGis", "5");
		dataset.setValue(20, "数据库拟合", "5");
		dataset.setValue(40, "预测", "5");

		dataset.setValue(10, "NASA", "6");
		dataset.setValue(15, "SolarGis", "6");
		dataset.setValue(20, "数据库拟合", "6");
		dataset.setValue(40, "预测", "6");

		dataset.setValue(10, "NASA", "7");
		dataset.setValue(15, "SolarGis", "7");
		dataset.setValue(20, "数据库拟合", "7");
		dataset.setValue(40, "预测", "7");

		dataset.setValue(10, "NASA", "8");
		dataset.setValue(15, "SolarGis", "8");
		dataset.setValue(20, "数据库拟合", "8");
		dataset.setValue(40, "预测", "8");

		dataset.setValue(10, "NASA", "9");
		dataset.setValue(15, "SolarGis", "9");
		dataset.setValue(20, "数据库拟合", "9");
		dataset.setValue(40, "预测", "9");

		dataset.setValue(10, "NASA", "10");
		dataset.setValue(15, "SolarGis", "10");
		dataset.setValue(20, "数据库拟合", "10");
		dataset.setValue(40, "预测", "10");

		dataset.setValue(10, "NASA", "11");
		dataset.setValue(15, "SolarGis", "11");
		dataset.setValue(20, "数据库拟合", "11");
		dataset.setValue(40, "预测", "11");

		dataset.setValue(10, "NASA", "12");
		dataset.setValue(15, "SolarGis", "12");
		dataset.setValue(20, "数据库拟合", "12");
		dataset.setValue(40, "预测", "12");
		JFreeChartTest2 chart = new JFreeChartTest2("气象数据拟合图", dataset);
		chart.pack();// 以合适的大小显示
		chart.setVisible(true);
	}
}
