package walletservice.wallet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositRepository extends JpaRepository<DepositEntity,Long> {
}
