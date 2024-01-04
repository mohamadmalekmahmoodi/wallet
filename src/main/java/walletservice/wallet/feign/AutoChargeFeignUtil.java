package walletservice.wallet.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import walletservice.wallet.models.dto.feign.autochargedto.AutoChargeDto;

@FeignClient(value = "feign", url = "http://localhost:8081/autoCharge")
public interface AutoChargeFeignUtil {
    @RequestMapping(method = RequestMethod.POST, value = "/createAutoCharge", produces = "application/json")
    String createAutoCharge( @RequestBody AutoChargeDto dto);
}
