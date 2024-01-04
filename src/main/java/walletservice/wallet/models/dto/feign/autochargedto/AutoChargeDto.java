package walletservice.wallet.models.dto.feign.autochargedto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AutoChargeDto {
    private String phoneNumber;
    private String walletId;
    private Long chargeAmount;
    private CardDto cardDto;
}
