package com.cqlj.cataTools.chart.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class TestPoiUtil {

	/**
	 * 模拟服务层，解析excel并将数据导入数据库
	 * 
	 * @param is
	 *            读入文件的IO流
	 * @param excelFlag
	 *            检测类型标识
	 * @return excel
	 */
	public static void serviceName(InputStream is, String excelFlag) throws Exception {
		HSSFWorkbook wb = PoiUtil.getWebbook(is);
		String[] sheetArr = CommonUtils.getParamcValue(excelFlag).split(",");
		for (int i = 0; i < sheetArr.length; i++) {
			String sheetName = sheetArr[i];
			HSSFSheet sheet = wb.getSheet(sheetName);
			List<Object> list = PoiUtil.getListOfEntity(sheet);
			if ("逆变器的选择".equals(sheetName)) {
				Iterator<?> iter = list.iterator();
				List<TbSampleNbq> nbqList = new ArrayList<TbSampleNbq>();
				while (iter.hasNext()) {
					TbSampleNbq nbq = (TbSampleNbq) iter.next();
					// 加入项目编号
					nbq.setProjNo("AK0001");
					// 加入用户ID号
					nbq.setUserId(100);
					nbqList.add(nbq);
				}
				System.out.println("将逆变器的选择添加到数据库");
				// 调用dao，将stuList插入数据库
				int ll = nbqList.size();
				System.out.println("项目编号	逆变器编号	发电量	是否选中	测试员");
				for (int j = 0; j < ll; j++) {
					TbSampleNbq ss = nbqList.get(j);
					System.out.println(ss.getProjNo() + "	" + ss.getNbqCode() + "	" + ss.getTwh() + "	"
							+ ss.getIsOpt() + "	" + ss.getUserId());
				}
			} else if ("汇流箱的选择".equals(sheetName)) {
				Iterator<?> iter = list.iterator();
				List<TbSampleHlx> hlxList = new ArrayList<TbSampleHlx>();
				while (iter.hasNext()) {
					TbSampleHlx hlx = (TbSampleHlx) iter.next();
					// 加入项目编号
					hlx.setProjNo("AK0001");
					// 加入用户ID号
					hlx.setUserId(100);
					hlxList.add(hlx);
				}

				System.out.println("将汇流箱的选择添加到数据库");
				// 调用dao，将stuList插入数据库
				int ll = hlxList.size();
				System.out.println("项目编号	逆变器编号	汇流箱编号	发电量	是否选中	测试员");
				for (int j = 0; j < ll; j++) {
					TbSampleHlx ss = hlxList.get(j);
					System.out.println(ss.getProjNo() + "	" + ss.getNbqCode() + "	" + ss.getHlxCode() + "	"
							+ ss.getTwh() + "	" + ss.getIsOpt() + "	" + ss.getUserId());
				}
			}
		}
	}

	public static void mergeCell(InputStream is) throws Exception {
		HSSFWorkbook wb = PoiUtil.getWebbook(is);
		HSSFSheet sheet = wb.getSheet("连续性测试");
		// HSSFSheet sheet = wb.getSheet("student");
		//解析阵列区域
		PoiUtil.getMergedExcelToEntity(sheet, "A");
		//解析测试结果
		PoiUtil.getTestResultEntity(sheet,"B");
	}

	/**
	 * 模拟控制层调用服务层
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File f = new File("E:\\poiTest\\mergeCell.xls");
		InputStream is = new FileInputStream(f);
		mergeCell(is);
	}

}
