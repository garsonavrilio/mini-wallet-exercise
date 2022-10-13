package com.example.miniwalletexercise.dto.wallet;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WalletResponseDTO<T> {

  private T wallet;

}
