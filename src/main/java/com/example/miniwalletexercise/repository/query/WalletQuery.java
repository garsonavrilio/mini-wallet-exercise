package com.example.miniwalletexercise.repository.query;

public class WalletQuery {

  public static final String DEPOSIT_QUERY =
      "UPDATE wallets "
          + "SET "
          + "balance = balance + :amount, "
          + "updated_at = :time "
          + "WHERE owned_by = :uuid";

}
