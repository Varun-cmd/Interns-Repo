package com.example.demo;

public class ThreadCreator extends Thread {

	@Override
	public void run() {
		try {
		System.out.println(Singleton.getInstance().hashCode());
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
