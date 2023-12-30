package walletservice.wallet.models.documents;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Document("walletLogs")
@Setter
@Getter
public class LogDocument {
    @MongoId
    private String id;
    private Object request;
    private Object response;
    private String methodName;
    private String errorTrace;
}
