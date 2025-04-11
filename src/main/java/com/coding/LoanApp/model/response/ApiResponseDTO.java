package com.coding.LoanApp.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponseDTO<T> {

    private T data;
    private String message;
    private String status;

    public ApiResponseDTO() {
    }

    public ApiResponseDTO(T data, String message, String status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    // Static factory methods
    public static <T> ApiResponseDTO<T> success(T data, String message) {
        return new ApiResponseDTO<>(data, message, "success");
    }

    public static <T> ApiResponseDTO<T> failure(String message) {
        return new ApiResponseDTO<>(null, message, "failure");
    }
}
