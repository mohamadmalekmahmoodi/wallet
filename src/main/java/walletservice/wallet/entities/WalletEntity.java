package walletservice.wallet.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WalletEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy = "walletId",targetEntity = WalletTransactionEntity.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<WalletTransactionEntity> walletTransaction;
    @Column(nullable = false)
    private Long balance;
    private Long walletCode;
    private String status;


}
