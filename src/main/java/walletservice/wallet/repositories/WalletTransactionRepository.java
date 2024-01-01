package walletservice.wallet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import walletservice.wallet.models.entities.Wallet;
import walletservice.wallet.models.entities.WalletTransaction;

import java.time.LocalDateTime;
import java.util.List;

public interface WalletTransactionRepository extends JpaRepository<WalletTransaction,String> {
  List <WalletTransaction> findAllByWalletId(Wallet walletId);
}
