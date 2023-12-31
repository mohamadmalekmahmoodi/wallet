package walletservice.wallet.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import walletservice.wallet.controlleradvice.exception.ServiceException;
import walletservice.wallet.convertor.WalletRespConvertor;
import walletservice.wallet.models.dto.request.WalletDto;
import walletservice.wallet.models.dto.response.WalletResponseDto;
import walletservice.wallet.models.entities.Wallet;
import walletservice.wallet.securityconfig.JwtService;
import walletservice.wallet.service.WalletService;

@RestController
@RequestMapping("/wallet")
public class WalletController extends AbstractController<WalletDto, Wallet, WalletService> {

    @Autowired
    private JwtService jwtService;
    @Autowired
    private WalletRespConvertor walletRespConvertor;

    @PostMapping("/create")
    public WalletDto createWallet(@RequestHeader String token) throws ServiceException, JsonProcessingException {
        return adapter.convertEntity(service.createWallet(jwtService.getAllClaimsFromToken(token).getPhoneNumber()));
    }

    @PostMapping("/createTest")
    public WalletDto createWalletTest(@RequestBody WalletDto dto) {
        return adapter.convertEntity(service.createWallet(dto.getPhoneNumber()));
    }

    @GetMapping("/getBalance")
    public Long getBalance(@RequestBody WalletDto dto) throws ServiceException {
        return service.showBalance(dto.getPhoneNumber());
    }

    @GetMapping("/getWallet")
    public WalletResponseDto getWallet(@RequestBody WalletDto dto) {
        return walletRespConvertor.convertEntity(service.getWallet(dto.getWalletCode()));
    }
    @DeleteMapping("/delete/{phoneNumber}")
    public void removeWallet(@PathVariable String phoneNumber) throws ServiceException {
        service.removeWallet(phoneNumber);
    }

}
