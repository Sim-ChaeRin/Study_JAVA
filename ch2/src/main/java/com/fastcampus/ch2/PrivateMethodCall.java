package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class PrivateMethodCall {
	public static void main(String[] args) throws Exception {
		//Hello hello = new Hello();
		//hello.main();	// 해당 메서드는 클래스내 private이라서 호출 안됨
		
		/* Hello클래스의 Class객체(클래스의 정보를 담고있는 객체)를 얻어온다. */
		// 패키지까지 작성해야 함
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
		// Class객체가 가진 정보로 객체 생성(형변환 필요)
		Hello hello = (Hello) helloClass.newInstance();
		// main이라는 메서드 정보를 가져옴
		Method main = helloClass.getDeclaredMethod("main");
		// 해당 메서드 접근 가능하게 함
		main.setAccessible(true);
		// hello.main을 호출한 것과 같음
		main.invoke(hello);
	}
}
