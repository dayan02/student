package cn.ylcto.util;


import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ObjectToJson {

	public static JSONObject converterObjectToJson(Object vo) {
		JSONObject obj = new JSONObject();
		java.lang.reflect.Field[] files = vo.getClass().getDeclaredFields();
		for (int i = 0; i < files.length; i++) {
			java.lang.reflect.Field f= files[i];
			String methodName = "get"+f.getName().substring(0,1).toUpperCase()+f.getName().substring(1);
			System.out.println(methodName);
			try {
				Method method = vo.getClass().getMethod(methodName);
				if ("Date".equalsIgnoreCase(f.getType().getSimpleName())) {
					Date date = (Date) method.invoke(vo);
					obj.put(f.getName(),new SimpleDateFormat("yyyy-MM-dd").format(date));
				}else{
				obj.put(f.getName(), method.invoke(vo));
				}	
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		return obj;
		
	}

	public static JSONObject converterListObjectToJson(String name, List<?> all) {

		JSONObject obj = new JSONObject();
		
		JSONArray array = new JSONArray();
		Iterator<?> allIterator = all.iterator();
		while (allIterator.hasNext()) {
			array.add(converterObjectToJson(allIterator.next()));
			
		}
		obj.put(name, array);
		return obj;
	}
	
	//JSON处理分页
	public static JSONObject converterListSpiltObjectToJson(String name, List<?> all,Integer allResources) {

		JSONObject obj = converterListObjectToJson(name, all);
		obj.put("allResources", allResources);
		return obj;
		
	}
}
