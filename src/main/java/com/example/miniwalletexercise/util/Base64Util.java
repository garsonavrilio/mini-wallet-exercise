package com.example.miniwalletexercise.util;

import java.util.Base64;
import java.util.UUID;

public class Base64Util {

  public static String encode(UUID uuid) {
    return Base64.getEncoder().encodeToString(uuid.toString().getBytes());
  }

  public static UUID decode(String value) {
    return UUID.fromString(new String(Base64.getDecoder().decode(value)));
  }

}
