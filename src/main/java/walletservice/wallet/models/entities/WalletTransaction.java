package walletservice.wallet.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import walletservice.wallet.models.entities.BaseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class WalletTransaction extends BaseEntity {

    private Long amount;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
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
