package walletservice.wallet.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import walletservice.wallet.models.dto.feign.qrcodedto.QrCodeDto;

import java.io.IOException;

@FeignClient(value = "qrFeign" ,url = "http://192.168.200.123:8080/qrcode")
public interface QRCodeFeignUtil {

    @RequestMapping(method = RequestMethod.POST,value = "/create", produces = "application/json")
    void creat(@RequestHeader String token, @RequestBody QrCodeDto qrCodeDto) throws IOException;
    }

