package walletservice.wallet.models.entities;

import jakarta.persistence.*;
import lombok.*;
import walletservice.wallet.models.entities.BaseEntity;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class WalletTransaction extends BaseEntity {

    private Long amount;
    private LocalDateTime dateTime;
    @Enumerated(value = EnumType.STRING)
    private TransactionType transactionType;
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;
    private String phoneNumber;
    @ManyToOne(targetEntity = Wallet.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "WALLETID")
    private Wallet walletId;
    @Enumerated(EnumType.STRING)
    private DepositWithdraw depositWithdraw;



}
