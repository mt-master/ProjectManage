package com.liantong.sys.po;

import java.io.Serializable;

/**
 * @description: 基础vo对象
 * @create_time：2014年10月8日 下午4:08:44
 */
public class BaseResultVo implements Serializable {

	/**
	 * 正常
	 */
	public static final int RESULT_OK = 200;
	public static final String RESULT_OK_MSG = "请求成功";


	/**
	 * 服务器内部异常
	 */
	public static final int SERVER_ERROR = 500;
	public static final String SEVER_ERROE_MSG = "服务器繁忙，请稍后重试！";

	/**
	 * {变量说明}
	 */
	private static final long serialVersionUID = -7978635757653362784L;

	// 返回码，200表示成功，非200表示失败
	public int resultCode;

	// 返回消息，成功为“success”，失败为具体失败信息
	public String resultMessage;

	// 返回数据
	public Object resultData;

	public BaseResultVo() {

	}

	public BaseResultVo(String resultMessage, Object resultData) {
		this.resultCode = 0;
		this.resultMessage = resultMessage;
		this.resultData = resultData;
	}

	public BaseResultVo(int resultCode, String resultMessage) {
		this.resultCode = resultCode;
		this.resultMessage = resultMessage;
		this.resultData = "";
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public Object getResultData() {
		return resultData;
	}

	public void setResultData(Object resultData) {
		this.resultData = resultData;
	}

	@Override
	public String toString() {
		return "BaseResultVo [resultCode=" + resultCode + ", resultMessage=" + resultMessage
				+ ", resultData=" + resultData + "]";
	}

}
