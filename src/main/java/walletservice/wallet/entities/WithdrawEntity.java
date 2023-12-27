package walletservice.wallet.entities;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor

public class WithdrawEntity extends WalletTransactionEntity{

}
