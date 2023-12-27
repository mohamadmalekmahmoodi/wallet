package walletservice.wallet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import walletservice.wallet.entities.P2PEntity;

public interface P2PRepository extends JpaRepository<P2PEntity,Long> {
}
