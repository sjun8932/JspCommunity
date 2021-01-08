package com.sjun8932.example.jspCommunity;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 주소 : /jspCommunity/HomeServlet
// 팁 : 실행은 F11>>>>>>>>>>>

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		
  		// 입력된 데이터의 문자셋은 UTF-8이다. 이걸 안할시 주소창에서 한글 입력 시 안될 수 있음.
  		request.setCharacterEncoding("UTF-8");
  		
  		// request = http://localhost:8080/jspCommunity/HomeServlet , -> 리퀘스트는 옆의 주소와 같다
  		// 리퀘스트에 매개변수를 달 수 있는데
  		// http://localhost:8080/jspCommunity/HomeServlet?lang=한국어&count=2
  		// 에서 매개변수는 한국어 또는 count를 의미한다. count=2 에서 2는 숫자가 아니라 문자이다
  			
  		
  		// 출력될 문서는 UTF-8 HTML이다
  		response.setContentType("text/html; charset=UTF-8");
  		
  		//http://localhost:8080/jspCommunity/HomeServlet?lang=영어
  		String lang = request.getParameter("lang");
  		
  		// 삼항연산자 개념 int a = 조건문 ? 참일 때 : 거짓일 때;
  		int count = request.getParameter("count") != null ? Integer.parseInt(request.getParameter("count")) : 1;
  	
  		
  		if (lang == null) {
  			lang="영어";
  		}
  		
  		
		response.getWriter().append("<h1>입력된 언어: " + lang +"</h1>");
		response.getWriter().append("<br>");
		
		String hello = "";
		
		if (lang.equals("한국어")) {
			hello = "안녕하세요";
		}
		else if (lang.equals("일본어")) {
			hello = "곤니치와";
		}
		else {
			hello = "hello";		
		}
		
		for (int i=1; i <= count; i++ ) {
			response.getWriter().append(hello+"<br>");
		}
	}
}
