package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TwoDice {
	
	@RequestMapping("/rollDice")
	 public void main(HttpServletResponse response) throws IOException{
		
		// 정적리소스(이미지 혹은 js,css등)를 랜덤으로 돌려서 작업
		int idx1 = (int)(Math.random()*6)+1;
		int idx2 = (int)(Math.random()*6)+1;
		
		// 1. 내보낼 타입 선택하고
		response.setContentType("text/html");
		// 2. 인코딩 설정 후
		response.setCharacterEncoding("utf-8");
		// 3. PrinWriter로 작성
		PrintWriter out = response.getWriter();
		// (임시) 현재는 직접 html을 그려서 작업
		out.println("<html>");
		out.println("<head>");
		out.println("<body>");
		out.println("<img src='resources/img/dice"+idx1+".jpg'>");
		out.println("<img src='resources/img/dice"+idx2+".jpg'>");
		out.println("</body>");
		out.println("</head>");
		out.println("</html>");
	 }
}
