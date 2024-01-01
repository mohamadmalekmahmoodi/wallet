package walletservice.wallet.models.dto.response;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import walletservice.wallet.models.entities.WalletStatus;

@Data
@AllArgsConstructor
public class WalletResponseDto {
    private Long balance;
    private String walletCode;
    private WalletStatus status;
    private String phoneNumber;
}
