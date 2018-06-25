package com.javalogbook.mulittenant.filters;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.javalogbook.mulittenant.core.ThreadLocaleStorage;

@Service
public class TenantNameFilter {

	public String filter(HttpServletRequest request) throws IOException {

		if (request.getHeader("X-TenantID") == null) {
			return null;
		}

		String tenantName = request.getHeader("X-TenantID");

		if (tenantName == null) {
			return null;
		}

		ThreadLocaleStorage.setTenant(tenantName);
		return tenantName;
	}
}