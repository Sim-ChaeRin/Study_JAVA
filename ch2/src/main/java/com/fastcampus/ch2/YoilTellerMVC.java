package com.fastcampus.ch2;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// 년월일을 입력하면 요일을 알려주는 프로그램
@Controller
public class YoilTellerMVC {

	@RequestMapping("/getYoilMVC")
	//public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
	public String main(int year, int month, int day, Model model) throws IOException {

		// 유효성 검사
		if(!isValid(year, month, day)) return "yoilError";
		
		// 요일 계산
		char yoil = getYoil(year, month, day);
		
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("yoil", yoil);

		return "yoil";
	}

	private boolean isValid(int year, int month, int day) {
	    try {
	        LocalDate.of(year, month, day);
	        return true;
	    } catch (DateTimeException e) {
	        return false;
	    }
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, day);
		
		int dayOfweek = cal.get(Calendar.DAY_OF_WEEK);	// 1:일요일, 2:월요일 ... 숫자로 반환
		return " 일월화수목금토".charAt(dayOfweek);		// 숫자를 문자로 바꿔줌
	}

}
