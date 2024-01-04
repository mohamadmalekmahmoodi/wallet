package walletservice.wallet.repositoryes;

import org.springframework.data.mongodb.repository.MongoRepository;
import walletservice.wallet.models.documents.LogDocument;

public interface LogMongoRepository extends MongoRepository<LogDocument,String> {
}
