package com.ruby.java.ch10;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Test07 {

	public static void main(String[] args) {
		
		HashMap<String, String> dic = new HashMap<String, String>();
		
		dic.put("고진감래", "고생");
		dic.put("분골쇄신", "노력");
		dic.put("권토중래", "실패");
		dic.put("교학상자", "성장");
		dic.put(null,null); //HashMap은 null 값 저장 가능
		
		//방법1
		
		Iterator<String>keys=dic.keySet().iterator();
		while(keys.hasNext()){ //; 달면 무한루프
			String key = keys.next();
			System.out.println(String.format("%s :%s", key, dic.get(key)));
		}
		//방법2
		
		for(Map.Entry<String,String> elem : dic.entrySet()) {
			System.out.println(String.format("%s :%s", elem.getKey(), elem.getValue()));
		}
		//방법3
		for(String key : dic.keySet()) {
			System.out.println(String.format("%s :%s", key, dic.get(key)));
		}
	}

}
