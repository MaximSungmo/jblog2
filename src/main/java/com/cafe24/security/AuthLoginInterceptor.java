package com.cafe24.security;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cafe24.jblog.service.UserService;
import com.cafe24.jblog.vo.UserVo;

public class AuthLoginInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private UserService userService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
				
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		
		// 파라미터로 전달된 csrf 토큰 값 
		String param = request.getParameter("_csrf"); 
		System.out.println("파라미터러 넘어온녀석 "+param);
		// 세션에 저장된 토큰 값과 일치 여부 검증 
		if(param == null) {
			System.out.println("param 없음 ");
			return false;
		}
		if (request.getSession().getAttribute("CSRF_TOKEN").equals(param)){ 
			System.out.println("동일 token");
		} else if(!request.getSession().getAttribute("CSRF_TOKEN").equals(param)) {
			System.out.println("다른 토큰입니다.  "+request.getSession().getAttribute("CSRF_TOKEN") );
			System.out.println("시스템 생성 토큰 :  "+ param);
			return false;
		}
//		ApplicationContext ac = 
//		WebApplicationContextUtils.
//		getWebApplicationContext(request.getServletContext());
//		UserService userService = ac.getBean(UserService.class);
		
		UserVo userVo = new UserVo();
		userVo.setId(id);
		userVo.setPassword(password);
		
		UserVo authUser = userService.getUser(userVo);
		if(authUser == null) {
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false;
		}
		
		// session 처리
		HttpSession session = request.getSession(true);
		
		session.setAttribute("authUser", authUser);
		response.sendRedirect( request.getContextPath() );
		return false;
	}

}