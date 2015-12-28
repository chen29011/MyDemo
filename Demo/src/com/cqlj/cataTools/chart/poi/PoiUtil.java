package com.cqlj.cataTools.chart.poi;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.util.CellRangeAddress;

public class PoiUtil {
	/**
	 * 解析传入的sheet对象，将sheet解析为Java实体集合
	 * 
	 * @param sheet
	 *            excel的sheet对象
	 * @return listObj 实体列表
	 * @throws Exception
	 */
	public static List<Object> getListOfEntity(HSSFSheet sheet) throws Exception {
		List<Object> listObj = new ArrayList<Object>();
		String sheetName = sheet.getSheetName();
		String[] colNameArr = CommonUtils.getParamcValue(sheetName).split(",");
		HSSFRow row = null;
		int rows = sheet.getLastRowNum();
		int beginLine = getBeginRowNum(sheetName);
		System.out.println(sheetName + "改sheet总行数为" + rows);
		System.out.println(sheetName + "中数据从第" + beginLine + "开始读取");
		for (int i = beginLine; i <= rows; i++) {
			Class<?> cla = Class.forName(CommonUtils.getParamcValue(sheetName + "实体"));
			Object obj = cla.newInstance();
			row = sheet.getRow(i);
			int allColNum = row.getLastCellNum();

			HSSFCell cell = null;
			for (int j = 0; j < allColNum; j++) {
				cell = row.getCell(j);
				String cellContent = null;
				switch (cell.getCellType()) {
				case HSSFCell.CELL_TYPE_STRING:
					cellContent = cell.getStringCellValue();
					break;
				case HSSFCell.CELL_TYPE_NUMERIC:
					cellContent = String.valueOf(cell.getNumericCellValue());
					break;
				case HSSFCell.CELL_TYPE_BOOLEAN:
					cellContent = String.valueOf(cell.getBooleanCellValue());
					break;
				case HSSFCell.CELL_TYPE_BLANK:
					cellContent = "";
					break;
				default:
					cellContent = "";
					break;
				}
				String methodName = CommonUtils.firstToUpperCase(colNameArr[j]);
				String paramType = CommonUtils.getParamcValue(sheetName + methodName);
				System.out.println(sheetName + "*******************" + methodName + "********************" + paramType
						+ "**********************" + cellContent);
				Method mtd = null;
				if ("float".equals(paramType)) {
					mtd = cla.getMethod("set" + methodName, Float.class);
					mtd.invoke(obj, Float.parseFloat(cellContent));
				} else if ("Decimal".equals(paramType)) {
					mtd = cla.getMethod("set" + methodName, BigDecimal.class);
					mtd.invoke(obj, new BigDecimal(cellContent));
				} else if ("percent".equals(paramType)) {
					mtd = cla.getMethod("set" + methodName, Float.class);
					mtd.invoke(obj, Float.parseFloat(cellContent.substring(0, cellContent.length() - 1)));
				} else if ("Integer".equals(paramType)) {
					mtd = cla.getMethod("set" + methodName, Integer.class);
					mtd.invoke(obj, Integer.parseInt(cellContent.substring(0, cellContent.length() - 2)));
				} else {
					mtd = cla.getMethod("set" + methodName, String.class);
					mtd.invoke(obj, cellContent);
				}
			}
			listObj.add(obj);
		}
		return listObj;
	}

	/**
	 * 解析"连续性测试"sheet
	 * 
	 * @param sheet
	 *            excel的sheet对象 category 该sheet中对用表的标识
	 * @return listObj 实体列表
	 * @throws Exception
	 */
	public static List<Object> getMergedExcelToEntity(HSSFSheet sheet, String category) throws Exception {
		List<Object> listObj = new ArrayList<Object>();
		String sheetName = sheet.getSheetName();
		String[] colNameArr = CommonUtils.getParamcValue(sheetName + category).split(",");
		HSSFRow row = null;
		int rows = sheet.getLastRowNum();
		System.out.println(sheetName + "改sheet总行数为" + rows);
		int beginLine = getBeginRowNum(sheetName + category);
		System.out.println(sheetName + "中数据从第" + beginLine + "开始读取");
		for (int i = beginLine; i <= rows - 4; i++) {
			System.out.println("开始读取第"+i+"行");
			Class<?> cla = Class.forName(CommonUtils.getParamcValue(sheetName + category + "实体"));
			Object obj = cla.newInstance();
			row = sheet.getRow(i);
			int allColNum = row.getLastCellNum();
			HSSFCell cell = null;
			String cellContent = null;
			for (int j = 0; j < allColNum; j++) {
				cell = row.getCell(j);
				if (isMergedRegion(sheet, i, j)) {
					cellContent = getMergedRegionValue(sheet, i, j);
				} else {
					cellContent = getCellValue(cell);
				}

				String methodName = CommonUtils.firstToUpperCase(colNameArr[j]);
				String paramType = CommonUtils.getParamcValue(sheetName + category + methodName);
				System.out.println(sheetName + "*******************" + methodName + "********************" + paramType
						+ "**********************" + cellContent);
				Method mtd = null;
				if ("float".equals(paramType)) {
					mtd = cla.getMethod("set" + methodName, Float.class);
					mtd.invoke(obj, Float.parseFloat(cellContent));
				} else if ("Decimal".equals(paramType)) {
					mtd = cla.getMethod("set" + methodName, BigDecimal.class);
					mtd.invoke(obj, new BigDecimal(cellContent));
				} else if ("Integer".equals(paramType)) {
					mtd = cla.getMethod("set" + methodName, Integer.class);
					mtd.invoke(obj, Integer.parseInt(cellContent.substring(0, cellContent.length() - 2)));
				} else if ("percent".equals(paramType)) {
					mtd = cla.getMethod("set" + methodName, Float.class);
					mtd.invoke(obj, Float.parseFloat(cellContent.substring(0, cellContent.length() - 1)));
				} else {
					mtd = cla.getMethod("set" + methodName, String.class);
					mtd.invoke(obj, cellContent);
				}
			}
			listObj.add(obj);
		}
		return listObj;
	}

	/**
	 * 施工质量-连续性测试结果
	 * 
	 * @param sheet
	 * @return
	 * @throws Exception
	 */
	public static List<Object> getTestResultEntity(HSSFSheet sheet,String category) throws Exception {
		List<Object> listObj = new ArrayList<Object>();
		String sheetName = sheet.getSheetName();
		String[] colNameArr = CommonUtils.getParamcValue(sheetName + category).split(",");
		HSSFRow row = null;
		int rows = sheet.getLastRowNum();
		System.out.println(sheetName + "改sheet总行数为" + rows);
		for (int i = (rows - 3); i <= rows; i++) {
			Class<?> cla = Class.forName(CommonUtils.getParamcValue(sheetName + category + "实体"));
			Object obj = cla.newInstance();
			row = sheet.getRow(i);
			int allColNum = row.getLastCellNum();
			System.out.println("xxxxxxxxxxxxxxx"+allColNum);
			HSSFCell cell = null;
			String cellContent = null;
			for (int j = 2; j < allColNum; j++) {
				cell = row.getCell(j);
				if (isMergedRegion(sheet, i, j)) {
					cellContent = getMergedRegionValue(sheet, i, j);
				} else {
					cellContent = getCellValue(cell);
				}

				String methodName = CommonUtils.firstToUpperCase(colNameArr[j-2]);
				String paramType = CommonUtils.getParamcValue(sheetName + category + methodName);
				System.out.println(sheetName + "*******************" + methodName + "********************" + paramType
						+ "**********************" + cellContent);
				Method mtd = null;
				if ("float".equals(paramType)) {
					mtd = cla.getMethod("set" + methodName, Float.class);
					mtd.invoke(obj, Float.parseFloat(cellContent));
				} else if ("Decimal".equals(paramType)) {
					mtd = cla.getMethod("set" + methodName, BigDecimal.class);
					mtd.invoke(obj, new BigDecimal(cellContent));
				} else if ("Integer".equals(paramType)) {
					mtd = cla.getMethod("set" + methodName, Integer.class);
					mtd.invoke(obj, Integer.parseInt(cellContent.substring(0, cellContent.length() - 2)));
				} else if ("percent".equals(paramType)) {
					mtd = cla.getMethod("set" + methodName, Float.class);
					mtd.invoke(obj, Float.parseFloat(cellContent.substring(0, cellContent.length() - 1)));
				} else {
					mtd = cla.getMethod("set" + methodName, String.class);
					mtd.invoke(obj, cellContent);
				}
			}
			listObj.add(obj);
		}
		return listObj;
	}

	/**
	 * @param is
	 *            读入文件的IO流
	 * @return HSSFWorkbook
	 * @throws IOException
	 */
	public static HSSFWorkbook getWebbook(InputStream is) throws Exception {
		POIFSFileSystem fs = new POIFSFileSystem(is);
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		return wb;
	}

	/**
	 * 获取sheet从第几行开始读取，默认从第一行开始读取
	 * 
	 * @param sheetName
	 * @return
	 */
	public static int getBeginRowNum(String sheetName) {
		int beginRow = 1;
		String lineNum = CommonUtils.getParamcValue(sheetName + "Num");
		if (!CommonUtils.isEmpty(lineNum)) {
			beginRow = Integer.parseInt(lineNum);
		}
		return beginRow;
	}

	/**
	 * 获取合并单元格的值
	 * 
	 * @param sheet
	 * @param row
	 * @param column
	 * @return
	 */
	public static String getMergedRegionValue(HSSFSheet sheet, int row, int column) {
		int sheetMergeCount = sheet.getNumMergedRegions();
		String cellValue = null;
		for (int i = 0; i < sheetMergeCount; i++) {
			CellRangeAddress ca = sheet.getMergedRegion(i);
			int firstColumn = ca.getFirstColumn();
			int lastColumn = ca.getLastColumn();
			int firstRow = ca.getFirstRow();
			int lastRow = ca.getLastRow();
			if (row >= firstRow && row <= lastRow) {
				if (column >= firstColumn && column <= lastColumn) {
					HSSFRow fRow = sheet.getRow(firstRow);
					HSSFCell fCell = fRow.getCell(firstColumn);
					cellValue = getCellValue(fCell);
				}
			}
		}
		if (cellValue == null) {
			HSSFCell cell = sheet.getRow(row).getCell(column);
			cellValue = getCellValue(cell);
		}
		return cellValue;
	}

	/**
	 * 判断指定的单元格是否是合并单元格
	 * 
	 * @param sheet
	 * @param row
	 * @param column
	 * @return
	 */
	public static boolean isMergedRegion(HSSFSheet sheet, int row, int column) {
		int sheetMergeCount = sheet.getNumMergedRegions();
		for (int i = 0; i < sheetMergeCount; i++) {
			CellRangeAddress ca = sheet.getMergedRegion(i);
			int firstColumn = ca.getFirstColumn();
			int lastColumn = ca.getLastColumn();
			int firstRow = ca.getFirstRow();
			int lastRow = ca.getLastRow();
			if (row >= firstRow && row <= lastRow) {
				if (column >= firstColumn && column <= lastColumn) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 获取单元格的值
	 * 
	 * @param cell
	 * @return
	 */
	public static String getCellValue(HSSFCell cell) {
		if (cell == null)
			return "";
		if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
			return cell.getStringCellValue();
		} else if (cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(cell.getBooleanCellValue());
		} else if (cell.getCellType() == HSSFCell.CELL_TYPE_FORMULA) {
			return cell.getCellFormula();
		} else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
			return String.valueOf(cell.getNumericCellValue());
		}
		return "";
	}
}
