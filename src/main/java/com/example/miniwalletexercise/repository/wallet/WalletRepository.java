package com.example.miniwalletexercise.repository.wallet;

import static com.example.miniwalletexercise.repository.query.WalletQuery.DEPOSIT_QUERY;
import static com.example.miniwalletexercise.repository.query.WalletQuery.WITHDRAW_QUERY;

import com.example.miniwalletexercise.model.Wallet;
import java.time.ZonedDateTime;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

  Wallet findWalletByOwnedBy(UUID uuid);

  @Transactional
  @Modifying
  @Query(value = DEPOSIT_QUERY, nativeQuery = true)
  void deposit(Long amount, ZonedDateTime time, UUID uuid);

  @Transactional
  @Modifying
  @Query(value = WITHDRAW_QUERY, nativeQuery = true)
  void withdraw(Long amount, ZonedDateTime time, UUID uuid);
}
