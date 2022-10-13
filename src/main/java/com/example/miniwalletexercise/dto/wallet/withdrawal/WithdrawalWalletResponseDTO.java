package com.example.miniwalletexercise.dto.wallet.withdrawal;

import com.example.miniwalletexercise.dto.wallet.WalletResponseBaseDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.ZonedDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WithdrawalWalletResponseDTO extends WalletResponseBaseDTO {

  @JsonProperty("deposited_by")
  private UUID withdrawnBy;
  @JsonProperty("reference_id")
  private UUID referenceId;
  @JsonProperty("deposited_at")
  private ZonedDateTime withdrawnAt;
  private Long amount;

}
