package walletservice.wallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import walletservice.wallet.models.documents.LogDocument;
import walletservice.wallet.repositories.LogMongoRepository;

public class LogMongoService {
    @Autowired
    private LogMongoRepository logMongoRepository;


    public void save(LogDocument logDocument){
        this.logMongoRepository.save(logDocument);
    }

}
