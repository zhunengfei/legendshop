/*
 * 
 * LegendShop 多用户商城系统
 * 
 *  版权所有,并保留所有权利。
 * 
 */
package com.legendshop.business.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.legendshop.business.common.page.FrontPage;
import com.legendshop.business.service.CommonPageService;
import com.legendshop.business.service.locator.CommonPageServiceLocator;
import com.legendshop.core.base.BaseController;
import com.legendshop.core.constant.PathResolver;
import com.legendshop.core.helper.ThreadLocalContext;

/**
 * The Class CommonPageController.
 */
@Controller
public class CommonPageController extends BaseController {

	/** The locator. */
	@Autowired
	private CommonPageServiceLocator commonPageServiceLocator;

	/**
	 * Top.页面顶部
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the string
	 */
	@RequestMapping("/top")
	public String top(HttpServletRequest request, HttpServletResponse response) {
		String shopName = ThreadLocalContext.getCurrentShopName(request,response);
		CommonPageService commonPageService = commonPageServiceLocator.getCommonPageService(request,response, shopName, FrontPage.TOP);
		return commonPageService.getTop(request, response);
	}
	
	/**
	 * Top user info.
	 * 获取动态用户数据
	 * @param request the request
	 * @param response the response
	 * @return the string
	 */
	@RequestMapping("/topuserinfo")
	public String topUserInfo(HttpServletRequest request, HttpServletResponse response) {
		String shopName = ThreadLocalContext.getCurrentShopName(request,response);
		CommonPageService commonPageService = commonPageServiceLocator.getCommonPageService(request,response, shopName, FrontPage.TOP);
		return commonPageService.getTopUserInfo(request, response);
	}

	/**
	 * Home top.
	 *
	 * @param request the request
	 * @param response the response
	 * @return the string
	 */
	@RequestMapping("/home/top")
	public String homeTop(HttpServletRequest request, HttpServletResponse response) {
		return PathResolver.getPath(request,response,FrontPage.HOME_TOP);
	}

	/**
	 * Bottom.
	 *
	 * @param request the request
	 * @param response the response
	 * @return the string
	 */
	@RequestMapping("/bottom")
	public String bottom(HttpServletRequest request, HttpServletResponse response) {
		return PathResolver.getPath(request,response,FrontPage.BOTTOM);
	}
	
	/**
	 * All.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the string
	 */
	@RequestMapping("/all")
	public String all(HttpServletRequest request, HttpServletResponse response) {
		return PathResolver.getPath(request,response,FrontPage.ALL);
	}

	/**
	 * Topall. 页面顶部
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the string
	 */
	@RequestMapping("/topall")
	public String topall(HttpServletRequest request, HttpServletResponse response) {
		return PathResolver.getPath(request,response,FrontPage.TOPALL);
	}

	/**
	 * 页面底部.
	 *
	 * @param request the request
	 * @param response the response
	 * @param curPageNO the cur page no
	 * @param newsCategory the news category
	 * @return the string
	 */
	@RequestMapping("/copy")
	public String copyAll(HttpServletRequest request, HttpServletResponse response, String curPageNO,
			String newsCategory) {
		String shopName = ThreadLocalContext.getCurrentShopName(request,response);
		CommonPageService commonPageService = commonPageServiceLocator.getCommonPageService(request,response,shopName,
				FrontPage.COPY);
		return commonPageService.getCopy(request, response);
	}

}