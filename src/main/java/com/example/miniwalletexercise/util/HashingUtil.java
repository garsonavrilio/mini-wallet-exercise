package com.example.miniwalletexercise.util;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class HashingUtil {

  public static String hash(UUID value) {
    return Hashing.sha256().hashString(value.toString(), StandardCharsets.UTF_8).toString();
  }
}
