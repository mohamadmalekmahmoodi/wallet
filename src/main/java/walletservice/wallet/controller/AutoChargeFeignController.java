package walletservice.wallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import walletservice.wallet.feign.AutoChargeFeignUtil;
import walletservice.wallet.models.dto.feign.autochargedto.AutoChargeDto;

@RestController
@RequestMapping("/feign")
public class AutoChargeFeignController {
    @Autowired
    private AutoChargeFeignUtil autoChargeFeignUtil;

    @PostMapping("/createAutoCharge")
    public String createAutoCharge(@RequestBody AutoChargeDto dto) {
        return autoChargeFeignUtil.createAutoCharge(dto);
    }
}
