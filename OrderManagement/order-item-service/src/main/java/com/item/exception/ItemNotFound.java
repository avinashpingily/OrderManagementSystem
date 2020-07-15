package com.item.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFound extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ItemNotFound(String exception) {
	        super(exception);
	    }
}
