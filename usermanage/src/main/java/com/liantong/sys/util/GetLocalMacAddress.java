package com.liantong.sys.util;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class GetLocalMacAddress {
	public static String getLocalMacAddress() {
		
		Enumeration<NetworkInterface> ni = null;
		try {
			ni = NetworkInterface.getNetworkInterfaces();
		} catch (SocketException e) {
			e.printStackTrace();
		}
		if(ni != null) {
			while(ni.hasMoreElements()){
				NetworkInterface netI = ni.nextElement();
				
				byte[] bytes = null;
				try {
					bytes = netI.getHardwareAddress();
				} catch (SocketException e) {
					e.printStackTrace();
				}
				try {
					if(netI.isUp() && netI != null && bytes != null && bytes.length == 6){
						StringBuffer sb = new StringBuffer();
						for(byte b:bytes){
					    	 //与11110000作按位与运算以便读取当前字节高4位
					    	 sb.append(Integer.toHexString((b&240)>>4));
					    	 //与00001111作按位与运算以便读取当前字节低4位
					    	 sb.append(Integer.toHexString(b&15));
						 }
					     return sb.toString(); 
					}
				} catch (SocketException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	public static String messLocalMacAddress() {//乱序mac地址
		String mac = getLocalMacAddress();
		
		if(mac == null ) {
			return "";
		}
		
		String newString = "";
		for(int i=(mac.length()-1);i>=0;i--)
		{
			String bastr=mac.substring(i,i+1);
			newString=newString+bastr;
		} 
		char[] tempStr = newString.toCharArray();
		char temp;
		temp = tempStr[2] ; // 第3位跟第5位交换
		tempStr[2] = tempStr[4];
		tempStr[4] = temp;
		
		temp = tempStr[1] ;
		tempStr[1] = tempStr[7];//第2位跟第8位交换
		tempStr[7] = temp;
		
		temp = tempStr[4] ;
		tempStr[4] = tempStr[9];//第5位跟第10位交换
		tempStr[9] = temp;
		
		
		return String.valueOf(tempStr);
	}
}
