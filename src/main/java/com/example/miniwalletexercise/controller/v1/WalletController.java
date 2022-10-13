package com.example.miniwalletexercise.controller.v1;

import static com.example.miniwalletexercise.constant.ApiConstant.DEPOSITS;
import static com.example.miniwalletexercise.constant.ApiConstant.WALLET;
import static com.example.miniwalletexercise.constant.ApiConstant.WITHDRAWALS;
import static com.example.miniwalletexercise.constant.HeaderConstant.AUTHORIZATION;

import com.example.miniwalletexercise.dto.ResponseDTO;
import com.example.miniwalletexercise.dto.wallet.WalletResponseDTO;
import com.example.miniwalletexercise.dto.wallet.deposit.DepositResponseDTO;
import com.example.miniwalletexercise.dto.wallet.deposit.DepositWalletRequestDTO;
import com.example.miniwalletexercise.dto.wallet.disable.DisableWalletRequestDTO;
import com.example.miniwalletexercise.dto.wallet.disable.DisableWalletResponseDTO;
import com.example.miniwalletexercise.dto.wallet.enable.EnableWalletResponseDTO;
import com.example.miniwalletexercise.dto.wallet.view.ViewWalletResponseDTO;
import com.example.miniwalletexercise.dto.wallet.withdrawal.WithdrawalResponseDTO;
import com.example.miniwalletexercise.dto.wallet.withdrawal.WithdrawalWalletRequestDTO;
import com.example.miniwalletexercise.service.wallet.deposit.DepositWalletService;
import com.example.miniwalletexercise.service.wallet.disable.DisableWalletService;
import com.example.miniwalletexercise.service.wallet.enable.EnableWalletService;
import com.example.miniwalletexercise.service.wallet.view.ViewWalletService;
import com.example.miniwalletexercise.service.wallet.withdrawal.WithdrawalWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {

  @Autowired
  private EnableWalletService enableWalletService;
  @Autowired
  private ViewWalletService viewWalletService;
  @Autowired
  private DepositWalletService depositWalletService;
  @Autowired
  private WithdrawalWalletService withdrawalWalletService;
  @Autowired
  private DisableWalletService disableWalletService;

  @GetMapping(WALLET)
  public ResponseEntity<ResponseDTO<WalletResponseDTO<ViewWalletResponseDTO>>> viewWallet(
      @RequestHeader(value = AUTHORIZATION) String token) {
    return new ResponseEntity<>(viewWalletService.view(token), HttpStatus.OK);
  }

  @PostMapping(WALLET)
  public ResponseEntity<ResponseDTO<WalletResponseDTO<EnableWalletResponseDTO>>> enableWallet(
      @RequestHeader(value = AUTHORIZATION) String token) {
    return new ResponseEntity<>(enableWalletService.enableWallet(token), HttpStatus.CREATED);
  }

  @PatchMapping(WALLET)
  public ResponseEntity<ResponseDTO<WalletResponseDTO<DisableWalletResponseDTO>>> disableWallet(
      @RequestHeader(value = AUTHORIZATION) String token,
      @RequestBody DisableWalletRequestDTO disableWalletRequestDTO) {
    return new ResponseEntity<>(disableWalletService.disableWallet(token, disableWalletRequestDTO),
        HttpStatus.OK);
  }

  @PostMapping(DEPOSITS)
  public ResponseEntity<ResponseDTO<DepositResponseDTO>> deposits(
      @RequestHeader(value = AUTHORIZATION) String token,
      @RequestBody DepositWalletRequestDTO depositWalletRequestDTO) {
    return new ResponseEntity<>(depositWalletService.deposit(token, depositWalletRequestDTO),
        HttpStatus.CREATED);
  }

  @PostMapping(WITHDRAWALS)
  public ResponseEntity<ResponseDTO<WithdrawalResponseDTO>> withdrawals(
      @RequestHeader(value = AUTHORIZATION) String token,
      @RequestBody WithdrawalWalletRequestDTO withdrawalWalletRequestDTO) {
    return new ResponseEntity<>(withdrawalWalletService.withdraw(token, withdrawalWalletRequestDTO),
        HttpStatus.CREATED);
  }

}
