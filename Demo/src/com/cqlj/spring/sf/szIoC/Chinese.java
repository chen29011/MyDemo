package com.cqlj.spring.sf.szIoC;

public class Chinese implements Person {
	private Axe axe;

	/**
	 * 设值注入所需的setter方法
	 * 
	 * @param axe
	 */
	public void setAxe(Axe axe) {
		this.axe = axe;
	}

	/**
	 * 实现Person接口的useAxe方法
	 */
	@Override
	public void useAxe() {
		System.out.println(axe.chop());
	}

}
