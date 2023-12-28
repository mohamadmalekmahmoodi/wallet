package walletservice.wallet.models.dto.request;


import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WalletDto {
    private Long balance;
    @NotNull(message = "wallet.walletCode.null")
    private String walletCode;
    private String phoneNumber;
}
