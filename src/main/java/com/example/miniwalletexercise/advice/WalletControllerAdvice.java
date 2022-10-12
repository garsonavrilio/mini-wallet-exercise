package com.example.miniwalletexercise.advice;

import static com.example.miniwalletexercise.constant.StatusConstant.FAIL;

import com.example.miniwalletexercise.dto.ResponseDTO;
import com.example.miniwalletexercise.exception.ServiceException;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class WalletControllerAdvice {

  @ExceptionHandler(ServiceException.class)
  public ResponseEntity<ResponseDTO<Map<String, String>>> errorHandler(ServiceException se) {
    return new ResponseEntity<>(
        ResponseDTO.<Map<String, String>>builder().status(FAIL).data(se.getErrors()).build(),
        HttpStatus.BAD_REQUEST);
  }
}
