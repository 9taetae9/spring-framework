package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DayTeller {
//	public static void main(String[] args){
	@RequestMapping("/getDay")   //url 연결  
	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// 1. 입력   
		String year = request.getParameter("year");
		String month = request.getParameter("month"); 
		String date = request.getParameter("date");
		
		
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(date);
		
		//2. 작업
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm - 1, dd);
		
		int daysOfWeek = cal.get(Calendar.DAY_OF_WEEK); //1:일요일, 2:월요일 ...
		char day = " 일월화수목금".charAt(daysOfWeek);
		
		//3. 출력
		response.setContentType("text/html"); //text type 설정  
		response.setCharacterEncoding("utf-8");  //encoding 설정 
		PrintWriter out = response.getWriter(); //response 객체에서 브라우저로출력 스트림을 얻는다.  
		out.println(year + "년 "+ month + "월 "+date+"일은 ");
		out.println(day + "요일입니다.");
	}

}
