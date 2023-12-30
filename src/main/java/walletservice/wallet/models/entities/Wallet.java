package walletservice.wallet.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Wallet extends BaseEntity{
    @Column(nullable = false)
    private Long balance;
    @Column(unique = true)
    private String walletCode;
    @Enumerated(value = EnumType.STRING)
    private WalletStatus status;
    private String phoneNumber;
    @OneToMany(mappedBy = "walletId",targetEntity = WalletTransaction.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<WalletTransaction> walletTransaction;


}
