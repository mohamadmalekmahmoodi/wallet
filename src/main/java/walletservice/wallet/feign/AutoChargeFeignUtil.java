package walletservice.wallet.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import walletservice.wallet.models.dto.feign.autochargedto.AutoChargeDto;

@FeignClient(value = "feign", url = "http://localhost:8081/autoCharge")
public interface AutoChargeFeignUtil {
    @RequestMapping(method = RequestMethod.POST, value = "/createAutoCharge", produces = "application/json")
    String createAutoCharge( @RequestBody AutoChargeDto dto);

    @RequestMapping(method = RequestMethod.POST,value = "/depositAutoCharge",produces = "application/json")
    AutoChargeDto depositAutoCharge(@RequestHeader String token, @RequestParam String walletId);
}
