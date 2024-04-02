package com.smallcompany.small_company;

import com.trustedcompany.trusted_company.SecureStoreAcess;

public class ServerConnection{
	SecureStoreAcess secureStoreAccess;
	
	public ServerConnection(SecureStoreAcess secureStoreAccess) {
		// TODO Auto-generated constructor stub
		this.secureStoreAccess  = secureStoreAccess;
	}
	
	public void storeData() {
		secureStoreAccess.connect();
		secureStoreAccess.uploadData();
	}
	
	public void getData() {
		secureStoreAccess.connect();
		secureStoreAccess.accessData();
	}
	
	public void disconnect() {
		secureStoreAccess.disconnect();
	}
	
}
