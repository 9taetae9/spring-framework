package com.fastcampus.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model; // Import the Model class
@Controller
public class DayTellerMVC {
//	public static void main(String[] args){
	@RequestMapping("/getDayMVC")   //url 연결  
	//public void main(HttpServletRequest request, HttpServletResponse response) throws IOException{
	public String main(int year, int month, int date, Model model) throws IOException {
        char day = getDay(year, month, date);

        model.addAttribute("year", year); // Corrected method call
        model.addAttribute("month", month); // Corrected method call
        model.addAttribute("date", date); // Corrected method call
        model.addAttribute("day", day); // Corrected method call

        return "day";
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
