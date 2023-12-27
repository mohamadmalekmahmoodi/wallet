package walletservice.wallet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WithdrawRepository extends JpaRepository<WithdrawEntity,Long> {

}
