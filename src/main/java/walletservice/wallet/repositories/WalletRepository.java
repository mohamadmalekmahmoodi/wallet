package walletservice.wallet.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import walletservice.wallet.models.entities.Wallet;

import java.time.LocalDateTime;

public interface WalletRepository extends JpaRepository<Wallet,String> {
    Wallet findByWalletCode (String walletCode);
    Wallet findByPhoneNumber (String phoneNumber);
}
