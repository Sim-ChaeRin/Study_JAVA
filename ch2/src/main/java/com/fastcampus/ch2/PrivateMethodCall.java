package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class PrivateMethodCall {
	public static void main(String[] args) throws Exception {
		//Hello hello = new Hello();
		//hello.main();	// �ش� �޼���� Ŭ������ private�̶� ȣ�� �ȵ�
		
		/* HelloŬ������ Class��ü(Ŭ������ ������ ����ִ� ��ü)�� ���´�. */
		// ��Ű������ �ۼ��ؾ� ��
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
		// Class��ü�� ���� ������ ��ü ����(����ȯ �ʿ�)
		Hello hello = (Hello) helloClass.newInstance();
		// main�̶�� �޼��� ������ ������
		Method main = helloClass.getDeclaredMethod("main");
		// �ش� �޼��� ���� �����ϰ� ��
		main.setAccessible(true);
		// hello.main�� ȣ���� �Ͱ� ����
		main.invoke(hello);
	}
}
