package walletservice.wallet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import walletservice.wallet.entities.Wallet;

public interface WalletRepository extends JpaRepository<Wallet,Long> {
}
