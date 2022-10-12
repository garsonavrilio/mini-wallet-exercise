package com.example.miniwalletexercise.dto.init;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InitRequestDTO {

  @JsonProperty("customer_xid")
  private UUID customerXid;

}
