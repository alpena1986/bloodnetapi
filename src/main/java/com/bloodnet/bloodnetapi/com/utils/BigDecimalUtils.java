package com.bloodnet.bloodnetapi.com.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import org.apache.commons.lang.NullArgumentException;
import org.apache.commons.lang.StringUtils;


public class BigDecimalUtils{
                                                   
    //@Autowired
    //protected LoggedInUser loggedInUser;
	
    public final BigDecimal ONE_HUNDRED = new BigDecimal(100);
    
    /**
     * 加算
     * Null Safe
     */
    public BigDecimal add(String a, String b){
        if(StringUtils.isBlank(a)){
            a = "0";
        }
        if(StringUtils.isBlank(a)){
            b = "0";
        }
        return toBigDecimal(a).add(toBigDecimal(b));
    }
    
    /**
     * 除算
     * Null Safe
     */
    public BigDecimal divide(String a, String b, int scale){
        if(StringUtils.isBlank(a)){
            a = "0";
        }
        return toBigDecimal(a).divide(toBigDecimal(b), scale, BigDecimal.ROUND_FLOOR);
    }
    
	public String toString(BigDecimal bdc){
		if(bdc== null){
			return null;
		}else{
			return bdc.toString();
		}
	}
	
	/**
	 * 文字列を数値に変換
	 * ※カンマ編集した文字列でも変換可能
	 * Null Safe
	 */
	public BigDecimal toBigDecimal(String str){
	    if(StringUtils.isBlank(str)){
	        return null;
	    }
        BigDecimal bdc = new BigDecimal(str.replaceAll(",", ""));
        return bdc;
	}
    
    /**
     * 数量（非金額）をカンマ区切りで編集
     * Not Null Safe
     */
    public String addThousandsSeparator(BigDecimal number){
    	NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
    	numberFormat.setMinimumFractionDigits(number.scale());
    	numberFormat.setMaximumFractionDigits(number.scale());
        return numberFormat.format(number);
    }
    
    /**
     * 数量（非金額）をカンマ区切りで編集
     * Not Null Safe
     */
    public String addThousandsSeparator(String numberString){
    	if(StringUtils.isBlank(numberString)){
        	throw new NullArgumentException("String numberString");
    	}
    	BigDecimal number = toBigDecimal(numberString);
    	NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
    	numberFormat.setMinimumFractionDigits(number.scale());
    	numberFormat.setMaximumFractionDigits(number.scale());
        return numberFormat.format(number);
    }
    
    /**
     * 金額をカンマ区切りで編集し、
     * 通貨に応じて小数点以降の表示桁数を制御
     * 現時点、円を想定しているため、小数点以降はゼロ桁。
     * Not Null Safe
     */
    public String formatAsMoney(BigDecimal number){
    	if(number == null){
    		throw new NullArgumentException("bigdecimal number");
    	}
    	NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
    	//numberFormat.setMinimumFractionDigits(loggedInUser.getCurrencyInfo().getFractionDigits());
    	//numberFormat.setMaximumFractionDigits(loggedInUser.getCurrencyInfo().getFractionDigits());
        return numberFormat.format(number);
    }
    
    /**
     * 金額をカンマ区切りで編集し、
     * 通貨に応じて小数点以降の表示桁数を制御
     * 現時点、円を想定しているため、小数点以降はゼロ桁。
     * Not Null Safe
     */
    public String formatAsMoney(String numberString){
        return formatAsMoney(toBigDecimal(numberString));
    }
}