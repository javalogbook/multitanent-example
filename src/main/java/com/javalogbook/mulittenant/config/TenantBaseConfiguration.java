package com.javalogbook.mulittenant.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:tenants.properties")
@Component
public class TenantBaseConfiguration {

	@Value("#{'${tenantIds}'.split(',')}")
	private List<String> tenantIds;

	public List<String> getTenantIds() {
		return tenantIds;
	}

	public void setTenantIds(List<String> tenantIds) {
		this.tenantIds = tenantIds;
	}

}
