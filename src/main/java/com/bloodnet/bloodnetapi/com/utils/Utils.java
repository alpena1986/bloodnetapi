package com.bloodnet.bloodnetapi.com.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.thymeleaf.util.StringUtils;

import com.bloodnet.bloodnetapi.com.consts.Consts;


public class Utils{
	
    public static String getExceptionStackString(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.toString();
    }
    
    public static <T> List<T> safe( List<T> other ) {
        return other == null ? (List<T>)Collections.<T>emptyList() : other;
    }
    
    public static <T> Set<T> safe( Set<T> other ) {
        return other == null ? (Set<T>)Collections.<T>emptySet() : other;
    }
    
    public static Cookie createSecureCookie(String key,String value){
    	value = StringUtils.replace(value, "\r\n", "");
    	value = StringUtils.replace(value, "\r", "");
    	value = StringUtils.replace(value, "\n", "");
    	
		Cookie cookie = new Cookie(key,value);
		cookie.setSecure(true);
		cookie.setHttpOnly(true);
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24*186);  // 186 days
		return cookie;
    }
    
    public static boolean isAjax(HttpServletRequest request) {
        String requestedWithHeader = request.getHeader("X-Requested-With");
        return "XMLHttpRequest".equals(requestedWithHeader);
    }
    
    public static String tranlateRelation(String r){
    	String relation = "";
    	for(int i = 0; i< r.length(); i++){
    		char c = r.charAt(i);
    		if (c == Consts.RELATION_IS_FATHER) {
    			relation += "的父亲";
    		}
    		if (c == Consts.RELATION_IS_MOTHER) {
    			relation += "的母亲";
    		}
    		if (c == Consts.RELATION_IS_SON) {
    			relation += "的儿子";
    		}
    	}
    	return relation;
    }
    
}