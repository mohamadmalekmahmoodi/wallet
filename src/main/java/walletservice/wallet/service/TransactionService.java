package walletservice.wallet.service;

import org.springframework.stereotype.Service;
import walletservice.wallet.entities.WalletTransaction;
import walletservice.wallet.repositories.WalletTransactionRepository;

@Service
public class TransactionService extends AbstractService<WalletTransactionRepository, WalletTransaction> {

}
