package walletservice.wallet.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class WalletTransaction extends BaseEntity {

    private Long amount;
    private Date dateTime;
    @Enumerated(value = EnumType.STRING)
    private TransactionType transactionType;
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;
    private Long userId;
    @ManyToOne(targetEntity = Wallet.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "WALLETID")
    private Long walletId;



}
