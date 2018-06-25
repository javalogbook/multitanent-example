package com.javalogbook.mulittenant.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.javalogbook.mulittenant.filters.TenantNameFilter;
import com.javalogbook.mulittenant.interceptors.TenantInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	@Autowired
	TenantNameFilter filter;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		TenantInterceptor tenantInterceptor = new TenantInterceptor();
		tenantInterceptor.setFilter(filter);
		registry.addInterceptor(tenantInterceptor);
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}
