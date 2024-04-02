package com.trustedcompany.trusted_company;

import java.util.List;
import java.util.Map;

public interface SecureStoreAcess {
	public void configServer(int accid, String username, String password, List<Integer> serverlist, Map<String,String> configparms);
	public void connect();
	public void accessData();
	public void uploadData();
	public void disconnect();
}
