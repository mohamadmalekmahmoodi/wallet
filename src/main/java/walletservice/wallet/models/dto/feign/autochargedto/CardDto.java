package walletservice.wallet.models.dto.feign.autochargedto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@AllArgsConstructor
@Data
public class CardDto {
    private Date date;
    private String cardNumber;
}
