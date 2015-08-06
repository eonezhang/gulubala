package com.penglecode.gulubala.common.exception;

import com.penglecode.gulubala.common.consts.GlobalErrorCode;

/**
 * 用于数据校验的Exception
 * 
 * @author	  	pengpeng
 * @date	  	2014年7月28日 下午2:53:59
 * @version  	1.0
 */
public class DataValidationException extends SystemException {

	private static final long serialVersionUID = 1L;

	public DataValidationException(String message) {
		super(message);
		setCode(GlobalErrorCode.ERROR_CODE_UNKNOWN);
	}

	public DataValidationException(Throwable cause) {
		super(cause);
		setCode(GlobalErrorCode.ERROR_CODE_UNKNOWN);
	}

	public DataValidationException(String message, Throwable cause) {
		super(message, cause);
		setCode(GlobalErrorCode.ERROR_CODE_UNKNOWN);
	}
	
}
