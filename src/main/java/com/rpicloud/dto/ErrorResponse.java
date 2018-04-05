package com.rpicloud.dto;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class ErrorResponse {
   @ApiModelProperty(notes = "Error Response", required = true)
	private List<Error> errors = new ArrayList<>();

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	private boolean success = true;

}
