package walletservice.wallet.models.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WalletDto {
    private Long balance;
    private String walletCode;
    private String phoneNumber;
}
