package walletservice.wallet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import walletservice.wallet.models.entities.WalletTransaction;

public interface WalletTransactionRepository extends JpaRepository<WalletTransaction,String> {
}
