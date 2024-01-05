package walletservice.wallet.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import walletservice.wallet.models.dto.feign.walletcall.TokenValidityResponseDto;

@FeignClient(value = "checkToken",url = "")
public interface WalletCheckToken {
    @RequestMapping(value = "/tokenVerify", method = RequestMethod.POST,produces = "application/json")
    TokenValidityResponseDto checkTokenValidity(@RequestHeader("Authorization") String token);
}
