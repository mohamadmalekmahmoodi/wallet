package walletservice.wallet.models.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import walletservice.wallet.models.entities.DepositWithdraw;
import walletservice.wallet.models.entities.TransactionStatus;
import walletservice.wallet.models.entities.TransactionType;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
public class WalletTransactionDtoResp {
    private Long amount;
    private LocalDateTime dateTime;
    private TransactionType transactionType;
    private TransactionStatus status;
    private DepositWithdraw depositWithdraw;
}
