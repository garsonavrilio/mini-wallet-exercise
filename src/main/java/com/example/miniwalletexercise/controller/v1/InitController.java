package com.example.miniwalletexercise.controller.v1;

import com.example.miniwalletexercise.constant.ApiConstant;
import com.example.miniwalletexercise.dto.ResponseDTO;
import com.example.miniwalletexercise.dto.init.InitRequestDTO;
import com.example.miniwalletexercise.dto.init.InitResponseDTO;
import com.example.miniwalletexercise.service.init.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitController {

  @Autowired
  private InitService initService;

  @PostMapping(ApiConstant.INIT)
  public ResponseEntity<ResponseDTO<InitResponseDTO>> init(@RequestBody InitRequestDTO requestDTO) {
    return new ResponseEntity<>(initService.init(requestDTO), HttpStatus.CREATED);
  }


}
