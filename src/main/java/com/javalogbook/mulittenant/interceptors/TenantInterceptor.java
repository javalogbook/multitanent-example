package com.javalogbook.mulittenant.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.javalogbook.mulittenant.filters.TenantNameFilter;

public class TenantInterceptor extends HandlerInterceptorAdapter {
	TenantNameFilter filter;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String tenantId = this.filter.filter(request);
		if (StringUtils.isEmpty(tenantId)) {
			System.out.println("Tenant Id Can not be null.");
		}

		logRequestInfo(request);

		return super.preHandle(request, response, handler);
	}

	private void logRequestInfo(HttpServletRequest request) {
		System.out.println("Request URL-> " + request.getRequestURL());
		System.out.println("Request Locale-> " + request.getLocale());
		System.out.println("Request Parameters-> " + request.getParameterMap());
		System.out.println("Request " + request.getAttributeNames());
		System.out.println("Request " + request.getServerName());
		System.out.println("Request " + request.getServerPort());
		System.out.println("Request " + request.getRemoteUser());
		System.out.println("Request " + request.getRemoteAddr());
		System.out.println("Request " + request.getRemoteHost());
		System.out.println("Request " + request.getRemotePort());
		System.out.println("Request " + request.getQueryString());
		System.out.println("Request " + request.getProtocol());
		System.out.println("Request " + request.getPathInfo());
		System.out.println("Request " + request.getPathTranslated());
		System.out.println("Request " + request.getMethod());
		System.out.println("Request " + request.getHeaderNames());
		System.out.println("Request " + request.getContentType());
		System.out.println("Request " + HttpServletRequest.DIGEST_AUTH);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		super.afterConcurrentHandlingStarted(request, response, handler);
	}

	public void setFilter(TenantNameFilter filter) {
		this.filter = filter;

	}

}
