package com.example.miniwalletexercise.controller.v1;

import static com.example.miniwalletexercise.constant.HeaderConstant.AUTHORIZATION;

import com.example.miniwalletexercise.constant.ApiConstant;
import com.example.miniwalletexercise.dto.ResponseDTO;
import com.example.miniwalletexercise.dto.wallet.enable.EnableWalletResponseDTO;
import com.example.miniwalletexercise.dto.wallet.view.ViewWalletResponseDTO;
import com.example.miniwalletexercise.service.wallet.enable.EnableWalletService;
import com.example.miniwalletexercise.service.wallet.view.ViewWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {

  @Autowired
  private EnableWalletService enableWalletService;
  @Autowired
  private ViewWalletService viewWalletService;

  @PostMapping(ApiConstant.WALLET)
  public ResponseEntity<ResponseDTO<EnableWalletResponseDTO>> enableWallet(
      @RequestHeader(value = AUTHORIZATION) String token) {
    return new ResponseEntity<>(enableWalletService.enableWallet(token), HttpStatus.CREATED);
  }

  @GetMapping(ApiConstant.WALLET)
  public ResponseEntity<ResponseDTO<ViewWalletResponseDTO>> viewWallet(
      @RequestHeader(value = AUTHORIZATION) String token) {
    return new ResponseEntity<>(viewWalletService.view(token), HttpStatus.OK);
  }

}
