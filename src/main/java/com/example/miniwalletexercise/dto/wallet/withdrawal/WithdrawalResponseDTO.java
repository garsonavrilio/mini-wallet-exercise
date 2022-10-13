package com.example.miniwalletexercise.dto.wallet.withdrawal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WithdrawalResponseDTO {

  private WithdrawalWalletResponseDTO withdrawal;

}
