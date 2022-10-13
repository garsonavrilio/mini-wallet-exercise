package com.example.miniwalletexercise.dto.wallet.deposit;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepositResponseDTO {

  private DepositWalletResponseDTO deposit;

}
