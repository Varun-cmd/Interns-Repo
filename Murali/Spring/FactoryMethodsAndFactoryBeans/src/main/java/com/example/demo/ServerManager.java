package com.example.demo;

public class ServerManager {
	public static boolean restrictedAccess=false;
	
	ServerManager(boolean restricedAccess){
		this.restrictedAccess = restrictedAccess;
	}
	
//	public static ServerManager getInstance(int apiKey) {
//		if(isValidApiKey(apiKey)) {
//			return new ServerManager();
//		}else {
//			restrictedAccess = true;
//			return new ServerManager();
//		}
//	}
//	
//	public static boolean isValidApiKey(int apiKey) {
//		return true;
//	}
	
	public void getAccessDetails() {
		if(restrictedAccess==false) {
			System.out.println("Premium Access Available");
		}else {
			System.out.println("Restricted Acess Only");
		}
	}
	
	
}
