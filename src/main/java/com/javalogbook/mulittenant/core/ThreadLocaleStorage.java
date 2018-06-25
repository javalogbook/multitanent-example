package com.javalogbook.mulittenant.core;

public class ThreadLocaleStorage {
	private static ThreadLocal<String> tenant = new ThreadLocal<>();

	public static void setTenant(String tanentName) {
		tenant.set(tanentName);
	}

	public static String getTenant() {
		String tenantName = tenant.get();
		return tenantName == null ? "school" : tenant.get();
	}
}
