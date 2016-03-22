package com.cqlj.cataTools.javaRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements IHello {

	/**
	 * 因为UnicastRemoteObject的构造方法抛出了RemoteException异常，因此这里默认的构造方法必须写，
	 * 必须声明抛出RemoteException异常
	 * 
	 * @throws RemoteException
	 */
	protected HelloImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 简单的返回“Hello World！"字样
	 * 
	 * @return 返回“Hello World！"字样
	 * @throws java.rmi.RemoteException
	 */
	@Override
	public String helloWorld() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 一个简单的业务方法，根据传入的人名返回相应的问候语
	 * 
	 * @param someBodyName
	 *            人名
	 * @return 返回相应的问候语
	 * @throws java.rmi.RemoteException
	 */
	@Override
	public String sayHelloToSomeBody(String someBodyName) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
