package walletservice.wallet.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "charityFeign",url = "")
public interface CharityFeignUtil {
    @RequestMapping(value = "/tokenVerify", method = RequestMethod.POST,produces = "application/json")
    String checkTokenValidity(@RequestHeader("Authorization") String token);
}
