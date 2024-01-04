package walletservice.wallet.repositoryes;


import org.springframework.data.jpa.repository.JpaRepository;
import walletservice.wallet.models.entities.Wallet;

public interface WalletRepository extends JpaRepository<Wallet,String> {
    Wallet findByWalletCode (String walletCode);
    Wallet findByPhoneNumber (String phoneNumber);
}
