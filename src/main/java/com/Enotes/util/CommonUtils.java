package com.Enotes.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.Enotes.handler.GenericResponse;

public class CommonUtils {

	public static ResponseEntity<?> createBuildResponse(Object data, HttpStatus status) {

		GenericResponse response = GenericResponse.builder().responseStatus(status).message("success").status("success")
				.data(data).build();

		return response.create();
	}

	public static ResponseEntity<?> createBuildResponseMessage(String message, HttpStatus status) {

		GenericResponse response = GenericResponse.builder().responseStatus(status).message(message).status("success")
				.build();

		return response.create();
	}

	public static ResponseEntity<?> createErrorResponse(Object data, HttpStatus status) {

		GenericResponse response = GenericResponse.builder().responseStatus(status).message("failed").status("failed")
				.data(data).build();

		return response.create();
	}

	public static ResponseEntity<?> createErrorResponseMessage(String message, HttpStatus status) {

		GenericResponse response = GenericResponse.builder().responseStatus(status).message(message).status("failed")
				.build();

		return response.create();
	}

}
