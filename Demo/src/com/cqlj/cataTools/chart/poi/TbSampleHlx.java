package com.cqlj.cataTools.chart.poi;

import java.io.Serializable;
import java.util.Date;

public class TbSampleHlx implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4284420619860754165L;

	/**
     * tb_sample_hlx.id (自增ID号)
     */
    private Integer id;

    /**
     * tb_sample_hlx.projNo (项目编号)
     */
    private String projNo;

    /**
     * tb_sample_hlx.userId (测试员ID号)
     */
    private Integer userId;

    /**
     * tb_sample_hlx.nbqCode (逆变器编号)
     */
    private String nbqCode;

    /**
     * tb_sample_hlx.hlxCode (汇流箱编号)
     */
    private String hlxCode;

    /**
     * tb_sample_hlx.twh (发电量(kWh))
     */
    private Float twh;

    /**
     * tb_sample_hlx.isOpt (是否选中:01-选中;02-未选中)
     */
    private String isOpt;

    /**
     * tb_sample_hlx.createTime (录入时间)
     */
    private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProjNo() {
		return projNo;
	}

	public void setProjNo(String projNo) {
		this.projNo = projNo;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getNbqCode() {
		return nbqCode;
	}

	public void setNbqCode(String nbqCode) {
		this.nbqCode = nbqCode;
	}

	public String getHlxCode() {
		return hlxCode;
	}

	public void setHlxCode(String hlxCode) {
		this.hlxCode = hlxCode;
	}

	public Float getTwh() {
		return twh;
	}

	public void setTwh(Float twh) {
		this.twh = twh;
	}

	public String getIsOpt() {
		return isOpt;
	}

	public void setIsOpt(String isOpt) {
		this.isOpt = isOpt;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

   
}