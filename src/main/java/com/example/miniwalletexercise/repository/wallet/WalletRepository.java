package com.example.miniwalletexercise.repository.wallet;

import com.example.miniwalletexercise.model.Wallet;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

  Wallet findWalletByOwnedBy(UUID uuid);
}
