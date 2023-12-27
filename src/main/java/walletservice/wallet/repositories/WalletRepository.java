package walletservice.wallet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import walletservice.wallet.entities.WalletEntity;

public interface WalletRepository extends JpaRepository<WalletEntity,Long> {
}
