package com.example.miniwalletexercise.controller.v1;

import static com.example.miniwalletexercise.constant.HeaderConstant.AUTHORIZATION;

import com.example.miniwalletexercise.constant.ApiConstant;
import com.example.miniwalletexercise.dto.ResponseDTO;
import com.example.miniwalletexercise.dto.wallet.enable.EnableWalletResponseDTO;
import com.example.miniwalletexercise.service.wallet.enable.EnableWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {

  @Autowired
  private EnableWalletService enableWalletService;

  @PostMapping(ApiConstant.WALLET)
  public ResponseEntity<ResponseDTO<EnableWalletResponseDTO>> enableWallet(
      @RequestHeader(value = AUTHORIZATION) String token) {
    return new ResponseEntity<>(enableWalletService.enableWallet(token), HttpStatus.CREATED);
  }

}
