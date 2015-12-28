package com.cqlj.cataTools.chart.jFreeChart;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleEdge;

/**
 * 蜘蛛图
 */
public class MySpriderWebPlotTest {
	public static void main(String args[]) {
		// 在SWING中显示
		JFrame jf = new JFrame();
		jf.add(erstelleSpinnenDiagramm());
		jf.pack();
		jf.setVisible(true);
		// 将JFreeChart保存为图片存在文件路径中
		saveAsFile("d:/JfreeChart/MySpiderWebPlot.jpg", 500, 400);
	}

	public static JPanel erstelleSpinnenDiagramm() {
		JFreeChart jfreechart = createChart();
		ChartPanel chartpanel = new ChartPanel(jfreechart);
		return chartpanel;
	}

	public static void saveAsFile(String outputPath, int weight, int height) {
		FileOutputStream out = null;
		try {
			File outFile = new File(outputPath);
			if (!outFile.getParentFile().exists()) {
				outFile.getParentFile().mkdirs();
			}
			out = new FileOutputStream(outputPath);

			// 保存为PNG
			ChartUtilities.writeChartAsPNG(out, createChart(), weight, height);
			// 保存为JPEG
			// ChartUtilities.writeChartAsJPEG(out, chart, 500, 400);
			out.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// do nothing
				}
			}
		}
	}

	public static JFreeChart createChart() {
		// SpiderWebPlot spiderwebplot1 = new SpiderWebPlot(createDataset());
		// //SpiderWebPlot是Jfreechart自带的
		CalibrationSpiderWebPlot spiderwebplot = new CalibrationSpiderWebPlot(createDataset()); // 不用Jfreechart自带的SpiderWebPlot，继承SpiderWebPlot重写MySpiderWebPlot
		JFreeChart jfreechart = new JFreeChart("光伏电站技术评级雷达图", TextTitle.DEFAULT_FONT, spiderwebplot, false);
		LegendTitle legendtitle = new LegendTitle(spiderwebplot);
		legendtitle.setPosition(RectangleEdge.BOTTOM);
		jfreechart.addSubtitle(legendtitle);
		return jfreechart;
	}

	public static DefaultCategoryDataset createDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		String group1 = "得分百分比 ";
		dataset.addValue(0.5, group1, "地址");
		dataset.addValue(0.2, group1, "安装部分");
		dataset.addValue(0.4, group1, "设备质量");
		dataset.addValue(0.6, group1, "系统性能");
		dataset.addValue(0.8, group1, "运维质量");

		return dataset;
	}
}
