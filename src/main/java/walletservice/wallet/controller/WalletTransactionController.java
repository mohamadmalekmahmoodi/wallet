package walletservice.wallet.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import walletservice.wallet.controlleradvice.exception.ServiceException;
import walletservice.wallet.models.dto.WalletTransactionDto;
import walletservice.wallet.models.entities.TransactionStatus;
import walletservice.wallet.models.entities.WalletTransaction;
import walletservice.wallet.service.WalletTransactionService;

@RestController
@RequestMapping("/walletTransaction")
public class WalletTransactionController extends AbstractController<WalletTransactionDto, WalletTransaction, WalletTransactionService> {
    @PostMapping("/walletToWallet")
    public TransactionStatus walletToWallet(@RequestBody WalletTransactionDto dto) throws ServiceException {
      return service.walletToWallet(dto.getSenderWalletCode(), dto.getReceiverWalletCode(), dto.getAmount(), dto.getTransactionType() , dto.getPhoneNumber());
    }
}
