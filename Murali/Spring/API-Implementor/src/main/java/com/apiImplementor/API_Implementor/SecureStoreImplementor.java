package com.apiImplementor.API_Implementor;

import java.util.List;
import java.util.Map;

import com.trustedcompany.trusted_company.SecureStoreAcess;

public class SecureStoreImplementor implements SecureStoreAcess{
	
	int accid;
	String username,  password;
	List<Integer> serverlist;
	Map<String,String> configparms;
	
	public SecureStoreImplementor(int accid, String username, String password, List<Integer> serverlist, Map<String,String> configparms) {
		// TODO Auto-generated constructor stub
		this.accid = accid;
		this.username = username;
		this.password = password;
		this.serverlist = serverlist;
		this.configparms = configparms;
	}

	@Override
	public void accessData() {
		System.out.println("Data is being accessed");
		
	}

	@Override
	public void configServer(int arg0, String arg1, String arg2, List<Integer> arg3, Map<String, String> arg4) {
		// TODO Auto-generated method stub
		System.out.println("Server Configured!!");
		
	}

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		configServer(accid, username, password, serverlist, configparms);
		System.out.println("Connected to the Server :)");
		
	}

	@Override
	public void disconnect() {
		// TODO Auto-generated method stub
		System.out.println("Disonnected to the Server :(");
	}

	@Override
	public void uploadData() {
		// TODO Auto-generated method stub
		System.out.println("Data uploaded successfully!!");
		
	}
	
}
