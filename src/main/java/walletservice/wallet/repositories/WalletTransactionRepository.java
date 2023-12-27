package walletservice.wallet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import walletservice.wallet.entities.WalletTransaction;

public interface WalletTransactionRepository extends JpaRepository<WalletTransaction,Long> {
}
