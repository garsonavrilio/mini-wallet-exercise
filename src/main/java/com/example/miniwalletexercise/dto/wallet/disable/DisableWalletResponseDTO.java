package com.example.miniwalletexercise.dto.wallet.disable;

import com.example.miniwalletexercise.dto.wallet.WalletResponseBaseDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.ZonedDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisableWalletResponseDTO extends WalletResponseBaseDTO {

  @JsonProperty("disabled_at")
  private ZonedDateTime disabledAt;
  @JsonProperty("owned_by")
  private UUID ownedBy;
  private Long balance;

}
