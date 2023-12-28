package walletservice.wallet.models.dto.request;
import lombok.Data;
import lombok.NoArgsConstructor;
import walletservice.wallet.models.entities.TransactionStatus;
import walletservice.wallet.models.entities.TransactionType;
import java.util.Date;

@Data
@NoArgsConstructor
public class WalletTransactionDto {

    private Long amount;
    private Date dateTime;
    private TransactionType transactionType;
    private TransactionStatus status;
    private Long userId;
    private Long walletId;

}
