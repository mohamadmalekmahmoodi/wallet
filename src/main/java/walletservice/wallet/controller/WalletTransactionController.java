package walletservice.wallet.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import walletservice.wallet.controlleradvice.exception.ServiceException;
import walletservice.wallet.convertor.WalletTransactionRespConvertor;
import walletservice.wallet.models.dto.WalletTransactionDto;
import walletservice.wallet.models.dto.response.WalletTransactionDtoResp;
import walletservice.wallet.models.entities.TransactionStatus;
import walletservice.wallet.models.entities.WalletTransaction;
import walletservice.wallet.service.WalletTransactionService;

import java.util.List;

@RestController
@RequestMapping("/walletTransaction")
public class WalletTransactionController extends AbstractController<WalletTransactionDto, WalletTransaction, WalletTransactionService> {
    @Autowired
    private WalletTransactionRespConvertor walletTransactionRespConvertor;
    @PostMapping("/walletToWallet")
    public TransactionStatus walletToWallet(@RequestBody WalletTransactionDto dto) throws ServiceException {
      return service.walletToWallet(dto.getSenderWalletCode(), dto.getReceiverWalletCode(), dto.getAmount(), dto.getTransactionType() , dto.getPhoneNumber());
    }
    @GetMapping("/showTransaction/{phoneNumber}")
    public List<WalletTransactionDtoResp> showTransaction(@PathVariable String phoneNumber ) throws ServiceException {
        return walletTransactionRespConvertor.convertEntity(service.ShowTransaction(phoneNumber));
    }
}
