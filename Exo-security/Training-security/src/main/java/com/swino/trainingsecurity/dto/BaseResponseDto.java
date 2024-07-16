package com.swino.trainingsecurity.dto;

import lombok.Data;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

@Data
public class BaseResponseDto  {
    private Object message;
    private Object data;

    public BaseResponseDto(Object message) {
        this.message = message;
    }
    public BaseResponseDto(Object message, Object data) {
        this.message = message;
        this.data = data;
    }
}
