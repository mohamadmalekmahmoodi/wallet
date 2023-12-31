package walletservice.wallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import walletservice.wallet.controlleradvice.exception.ServiceException;
import walletservice.wallet.models.entities.Wallet;
import walletservice.wallet.models.entities.WalletStatus;
import walletservice.wallet.repositories.WalletRepository;
import walletservice.wallet.repositories.WalletTransactionRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import walletservice.wallet.feign.AutoChargeFeignUtil;
import walletservice.wallet.feign.AutoChargeFeignUtil;
import java.util.Random;

@Service
public class WalletService extends AbstractService<Wallet, WalletRepository> {
    @Autowired
    private WalletTransactionService walletTransactionService;
    @Autowired
    private AutoChargeFeignUtil autoChargeFeignUtil;

    public Wallet createWallet(String phoneNumber) {
        return repository.save(Wallet.builder()
                .walletCode(generateWalletCode(phoneNumber))
                .balance(0L)
                .phoneNumber(phoneNumber)
                .status(WalletStatus.CREATED)
                .build());
    }


    public void removeWallet(String phoneNumber) throws ServiceException {
        if (phoneNumber == null){
            throw new ServiceException("phone-number-null");
        }
        Wallet wallet = repository.findByPhoneNumber(phoneNumber);
        repository.deleteById(wallet.getId());
        if (!phoneNumber.equals(wallet.getPhoneNumber())){
            throw new ServiceException("phoneNumber-not-found");
        }
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


    public Long showBalance(String phoneNumber) throws ServiceException {
        if (phoneNumber.isEmpty()) {
            throw new ServiceException("phone-number-null");
        }
        Wallet wallet = repository.findByPhoneNumber(phoneNumber);
        if (wallet == null) {
            throw new ServiceException("wallet-not-available");
        }
        if (!phoneNumber.equals(wallet.getPhoneNumber())) {
            throw new ServiceException("phoneNumber-not-found");
        }
        return wallet.getBalance();
    }

    public Wallet getWallet(String walletCode) {
        return repository.findByWalletCode(walletCode);
    }


}
