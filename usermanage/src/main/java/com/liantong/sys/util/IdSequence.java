package com.liantong.sys.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class IdSequence {
	
	private static int ServerPort;
	
	private static final String mac = GetLocalMacAddress.messLocalMacAddress();
	
	private static int count = 100;
	
	private static long lastTimestamp = -1L;
	
	@Value("${server.port}")
	public void setServerPort(int serverPort) {
		IdSequence.ServerPort = serverPort;
	}
	
	public static synchronized String nextId() {
		String portHex = Integer.toHexString(ServerPort);
		switch(portHex.length()) {
			case 1:portHex="000"+portHex;break;
			case 2:portHex="00"+portHex;break;
			case 3:portHex="0"+portHex;break;
			default :;
		}
		
		long currentTime = System.currentTimeMillis();
		String nextId =mac + portHex+ "" + (currentTime < lastTimestamp ? lastTimestamp :currentTime) + count ;
		count ++;
		
		if(count == 1000) {
			lastTimestamp = currentTime + 1;//当序列溢出后,lastTimestamp = 当前时间往下走一秒 ，然后重置 count数值
			count = 100;
		}
		return nextId;
	}
	
}
