package com.rpicloud.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

//@Data

public class Error {
	private String responseCode;
	private String errorType;
	private String message;

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
