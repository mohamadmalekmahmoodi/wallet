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

public class WalletTransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long amount;
    private Date dateTime;
    @Column(nullable = false)
    private String description;
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;
    private Long userId;
    @ManyToOne(targetEntity = WalletEntity.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "wallet_id")
    private Long walletId;



}
