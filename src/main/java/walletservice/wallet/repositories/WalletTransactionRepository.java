package walletservice.wallet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import walletservice.wallet.entities.WalletEntity;
import walletservice.wallet.entities.WalletTransactionEntity;

public interface WalletTransactionRepository extends JpaRepository<WalletTransactionEntity,Long> {
}
