package com.org.exceptions;

import org.springframework.stereotype.Component;

@Component
public class HotelNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
}
