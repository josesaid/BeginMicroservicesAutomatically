package com.mx.development.pojos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class BaseResult {
    private String microserviceName;
    private String pomFileLocation;
    private boolean success;
    private LocalDateTime timestamp;
}
