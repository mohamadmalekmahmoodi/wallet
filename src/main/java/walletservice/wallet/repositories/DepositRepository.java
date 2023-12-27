package walletservice.wallet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import walletservice.wallet.entities.DepositEntity;

public interface DepositRepository extends JpaRepository<DepositEntity,Long> {
}
