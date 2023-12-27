package walletservice.wallet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import walletservice.wallet.entities.WithdrawEntity;

public interface WithdrawRepository extends JpaRepository<WithdrawEntity,Long> {

}
