package walletservice.wallet.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import walletservice.wallet.models.entities.TransactionType;

@Data
@Builder
@AllArgsConstructor
public class WalletTransactionDto {
    private String receiverWalletCode;
    private String senderWalletCode;
    private String phoneNumber;
    private Long amount;
    private TransactionType transactionType;
}
