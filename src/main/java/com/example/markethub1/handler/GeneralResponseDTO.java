package com.example.markethub1.handler;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GeneralResponseDTO {
    private Integer status;
    private String message;
    private String error;
    private String path;
}
