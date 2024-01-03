package com.fastcampus.ch2;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

public class MethodCall3 {
	public static void main(String[] args) throws Exception{
		//1. 요청시 제공된 값 - request.getParameterMap(); 
		Map map = new HashMap();
		map.put("year", "2021");
		map.put("month", "10");
		map.put("day", "1");

		Model model = null;
		Class clazz = Class.forName("com.fastcampus.ch2.DayTellerMVC");
		Object obj  = clazz.newInstance();
		
		// YoilTellerMVC.main(int year, int month, int day, Model model)
		Method main = clazz.getDeclaredMethod("main", int.class, int.class, int.class, Model.class);
				
		Parameter[] paramArr = main.getParameters();
		Object[] argArr = new Object[main.getParameterCount()];
		
		for (int i = 0; i < paramArr.length; i++) {
		    Class paramType = paramArr[i].getType();

		    if (paramType == Model.class) {
		        argArr[i] = model = new BindingAwareModelMap();
		    } else {
		        // Assign values based on expected order
		        if (i == 0) { // year
		            argArr[i] = convertTo(map.get("year"), int.class);
		        } else if (i == 1) { // month
		            argArr[i] = convertTo(map.get("month"), int.class);
		        } else if (i == 2) { // day
		            argArr[i] = convertTo(map.get("day"), int.class);
		        }
		    }
		}

		System.out.println("paramArr="+Arrays.toString(paramArr));
		System.out.println("argArr="+Arrays.toString(argArr));
		
		
		// Controller의 main()을 호출 - YoilTellerMVC.main(int year, int month, int day, Model model)
		String viewName = (String)main.invoke(obj, argArr); 	
		System.out.println("viewName="+viewName);	
		
		// Model의 내용을 출력 
		System.out.println("[after] model="+model);
				
		// 텍스트 파일을 이용한 rendering
		render(model, viewName);			
	} // main
	
	private static Object convertTo(Object value, Class type) {
	    if (type == null || value == null || type.isInstance(value)) {
	        return value;
	    }

	    try {
	        if (String.class.isInstance(value) && type == int.class) {
	            return Integer.parseInt((String) value);
	        } else if (String.class.isInstance(value) && type == double.class) {
	            return Double.parseDouble((String) value);
	        }
	        // Add more conversions here if necessary
	    } catch (NumberFormatException e) {
	        // Log the exception, handle it, or rethrow, depending on your requirements
	        System.err.println("Error converting value: " + e.getMessage());
	    }
	    
	    return null; // or throw an exception if an unsupported conversion is attempted
	}
	
	private static void render(Model model, String viewName) throws IOException {
		String result = "";
		
		// 1. 뷰의 내용을 한줄씩 읽어서 하나의 문자열로 만든다.
		Scanner sc = new Scanner(new File("src/main/webapp/WEB-INF/views/"+viewName+".jsp"), "utf-8");
		
		while(sc.hasNextLine())
			result += sc.nextLine()+ System.lineSeparator();
		
		// 2. model을 map으로 변환 
		Map map = model.asMap();
		
		// 3.key를 하나씩 읽어서 template의 ${key}를 value바꾼다.
		Iterator it = map.keySet().iterator();
		
		while(it.hasNext()) {
			String key = (String)it.next();

			// 4. replace()로 key를 value 치환한다.
			result = result.replace("${"+key+"}", ""+map.get(key));
		}
		
		// 5.렌더링 결과를 출력한다.
		System.out.println(result);
	}
}