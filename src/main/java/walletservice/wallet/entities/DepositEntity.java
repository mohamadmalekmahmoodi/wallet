package walletservice.wallet.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DepositEntity extends WalletTransactionEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    private Long senderCardNumber;
//    private Long receiverCardNumber;
//    private Integer cvv2;
//    private Date expireDate;


}
