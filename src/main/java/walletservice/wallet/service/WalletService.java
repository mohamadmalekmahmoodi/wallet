package walletservice.wallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import walletservice.wallet.controlleradvice.exception.ServiceException;
import walletservice.wallet.models.dto.request.WalletTransactionDto;
import walletservice.wallet.models.entities.TransactionType;
import walletservice.wallet.models.entities.Wallet;
import walletservice.wallet.models.entities.WalletStatus;

import walletservice.wallet.models.entities.WalletTransaction;
import walletservice.wallet.repositories.WalletRepository;

import java.util.Date;
import java.util.Random;


@Service
public class WalletService extends AbstractService<Wallet, WalletRepository> {


    public Wallet createWallet(String phoneNumber) {
        return repository.save(Wallet.builder()
                .walletCode(generateWalletCode(phoneNumber))
                .balance(0L)
                .phoneNumber(phoneNumber)
                .status(WalletStatus.CREATED)
                .build());
    }

    private String generateWalletCode(String phoneNumber) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString + phoneNumber;
    }


//    public Wallet showBalance(String id){
//        WalletTransaction walletTransaction = new WalletTransaction();
//
//        Long walletId = walletTransaction.getWalletId();
//        if (walletId == null){
//
//        }
//        return null;
//    }
}

