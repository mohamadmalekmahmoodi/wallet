package walletservice.wallet.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import walletservice.wallet.models.documents.LogDocument;

public interface LogMongoRepository extends MongoRepository<LogDocument,String> {
}
