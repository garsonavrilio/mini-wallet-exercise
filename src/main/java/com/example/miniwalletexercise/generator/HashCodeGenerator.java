package com.example.miniwalletexercise.generator;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import org.springframework.stereotype.Component;

@Component
public class HashCodeGenerator {

  public String generateHashCode(String value) {
    return Hashing.sha256().hashString(value, StandardCharsets.UTF_8).toString();
  }

}
