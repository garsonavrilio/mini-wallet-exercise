package com.example.miniwalletexercise.dto.wallet;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalletResponseBaseDTO {

  private UUID id;
  @JsonProperty("owned_by")
  private UUID ownedBy;
  private String status;
  private Long balance;

}
