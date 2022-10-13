package com.example.miniwalletexercise.dto.wallet.disable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisableWalletRequestDTO {

  @JsonProperty("is_disabled")
  private Boolean isDisabled;

}
