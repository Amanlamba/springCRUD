package com.imdbrating.imdb.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {
    private Object data;
//    private Error error;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
