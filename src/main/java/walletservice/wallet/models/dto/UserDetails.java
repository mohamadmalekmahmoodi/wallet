package walletservice.wallet.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserDetails {
    private String phoneNumber;
    private String token;


}
