package com.javalogbook.mulittenant.routing;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.javalogbook.mulittenant.core.ThreadLocaleStorage;

public class TenantRouting extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return ThreadLocaleStorage.getTenant();
	}
}
