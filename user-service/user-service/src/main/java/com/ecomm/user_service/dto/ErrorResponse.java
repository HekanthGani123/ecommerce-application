package com.ecomm.user_service.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ErrorResponse {

   private int statusCode;

   private String reason;

   private Map<String,String> errors;


}
