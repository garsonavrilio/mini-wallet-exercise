package com.example.miniwalletexercise.dto.wallet.enable;

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
public class EnableWalletResponseDTO extends WalletResponseBaseDTO {

  @JsonProperty("enabled_at")
  private ZonedDateTime enabledAt;
  @JsonProperty("owned_by")
  private UUID ownedBy;
  private Long balance;
}
