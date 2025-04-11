package com.coding.LoanApp.exceptions;

import com.coding.LoanApp.model.response.ApiResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(LoanException.class)
    ResponseEntity<ApiResponseDTO<?>> loanExceptionHandler(LoanException e ){
        ApiResponseDTO<Object> failureResponse = ApiResponseDTO.failure(e.getMessage());
        return ResponseEntity.ok(failureResponse);
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<ApiResponseDTO<?>> exceptionHandler(LoanException e ){
        ApiResponseDTO<Object> failureResponse = ApiResponseDTO.failure(e.getMessage());
        return ResponseEntity.internalServerError().body(failureResponse);
    }

}
