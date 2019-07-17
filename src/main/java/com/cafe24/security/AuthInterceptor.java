package com.cafe24.security;

import java.util.UUID;

import javax.servlet.http.*;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cafe24.jblog.vo.UserVo;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// Referrer 체크(csrf 방어를 위하여)
//		String prev_url =(String)request.getHeader("REFERER");
//		System.out.println("이 전 페이지:"+prev_url);
//		if (prev_url == null ) {
//			prev_url = "fail";
//		}
//		if (prev_url.matches("^*/jblog2/*")) {
//			System.out.println("접속 승인");
//			return true;
//		}
//		else if(prev_url.equals(("fail"))) {
//			System.out.println("접속차단요");
//			return false;
//		}
		//CSRF 방어를 위한 TOKEN 생성
		HttpSession tokenSession = request.getSession();
		String token = UUID.randomUUID().toString();
		tokenSession.setAttribute("CSRF_TOKEN", token);
		System.out.println("토큰생성"+ token);
				
		
		// 1. handler 종류 확인
		if (handler instanceof HandlerMethod == false) {
			return true;
		}

		// 2. casting
		HandlerMethod handlerMethod = (HandlerMethod) handler;

		// 3. Method의 @Auth 받아오기
		Auth auth = handlerMethod.getMethodAnnotation(Auth.class);

		// 4. Method에 @Auth 없으면
		// Class(Type)에 @Auth를 받아오기
		// if(auth == null) {
		// auth = ...
		// }

		// 5. @Auth가 안 붙어있는 경우
		if (auth == null) {
			return true;
		}

		// 6. @Auth가 (class또는 method에)붙어 있기 때문에
		// 인증 여부 체크	
		HttpSession session = request.getSession();
		
		
		if (session == null) { // 인증이 안 되어 있음
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false;
		}

		UserVo authUser = (UserVo) session.getAttribute("authUser");
		if (authUser == null) { // 인증이 안 되어 있음
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false;
		}
		
		

		// 7. Role 가져오기
		// Auth.Role role = auth.role();

		// 8. role이 Auth.Role.USER 라면,
		// 인증된 모든 사용자는 접근 가능
		// if( role == Auth.Role.USER ) {
		// return true;
		// }

		// 9. Admin Role 권한 체크
		//
		// authUser.getRole().equals("ADMIN")
		//

		return true;
	}

}