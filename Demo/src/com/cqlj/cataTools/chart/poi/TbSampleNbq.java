package com.cqlj.cataTools.chart.poi;

import java.io.Serializable;
import java.util.Date;

public class TbSampleNbq implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8850317023477406227L;

	/**
     * tb_sample_nbq.id (自增ID号)
     */
    private Integer id;

    /**
     * tb_sample_nbq.projNo (项目编号)
     */
    private String projNo;

    /**
     * tb_sample_nbq.userId (测试员ID号)
     */
    private Integer userId;

    /**
     * tb_sample_nbq.nbqCode (逆变器编号)
     */
    private String nbqCode;

    /**
     * tb_sample_nbq.twh (发电量(kWh))
     */
    private Float twh;

    /**
     * tb_sample_nbq.isOpt (是否被选中,由excel表格导入，是/否)
     */
    private String isOpt;

    /**
     * tb_sample_nbq.createTime (录入时间)
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