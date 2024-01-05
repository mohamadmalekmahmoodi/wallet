package walletservice.wallet.models.dto.feign.walletcall;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TokenValidityRequestDto {
    private String token;
}
