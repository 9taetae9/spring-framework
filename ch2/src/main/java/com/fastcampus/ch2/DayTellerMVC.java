package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DayTellerMVC {
//	public static void main(String[] args){
	@RequestMapping("/getDayMVC")   //url 연결  
	//public void main(HttpServletRequest request, HttpServletResponse response) throws IOException{
	//public void main(int year, int month, int date, Model model) throws IOException{
	public ModelAndView main(int year, int month, int date) throws IOException{
		
		ModelAndView mv = new ModelAndView();
// 1. 입력   
//		String year = request.getParameter("year");
//		String month = request.getParameter("month"); 
//		String date = request.getParameter("date");
		
		
//		int yyyy = Integer.parseInt(year);
//		int mm = Integer.parseInt(month);
//		int dd = Integer.parseInt(date);
		//1. 유효성 검사 
		//if(!isValid(year, month, date))
			//return "dayError";
			
		//2 요일 계산 
		char day = getDay(year, month, date);
		
		//3.계산한 결과를 Model에 저장
		mv.addObject("year",year);
		mv.addObject("month",month);
		mv.addObject("date",date);
		mv.addObject("day",day);
		
		//4. 결과를 보여줄 view를 지정 
		mv.setViewName("day");
		
		return mv;
		//return "day"; // WEB-INF/views/day.jsp

	}

private boolean isValid(int year, int month, int date) {
	// TODO Auto-generated method stub
	return true;
}

private char getDay(int year, int month, int date) {
	Calendar cal = Calendar.getInstance();
	cal.set(year, month - 1, date);
	
	int daysOfWeek = cal.get(Calendar.DAY_OF_WEEK); //1:일요일, 2:월요일 ...
	return " 일월화수목금".charAt(daysOfWeek);
}
}
