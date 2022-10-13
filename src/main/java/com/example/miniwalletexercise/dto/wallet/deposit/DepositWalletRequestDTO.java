package com.example.miniwalletexercise.dto.wallet.deposit;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepositWalletRequestDTO {

  private Long amount;
  @JsonProperty("reference_id")
  private UUID referenceId;

}
