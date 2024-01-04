package walletservice.wallet.models.dto.feign.qrcodedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
public class QrCodeDto {
    private Long walletId;
    private String phoneNumber;
}
