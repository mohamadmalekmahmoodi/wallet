package walletservice.wallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import walletservice.wallet.models.dto.request.WalletDto;
import walletservice.wallet.models.entities.Wallet;
import walletservice.wallet.securityconfig.JwtService;
import walletservice.wallet.service.WalletService;

@RestController
@RequestMapping("/wallet")
public class WalletController extends AbstractController<WalletDto, Wallet, WalletService> {
    @Autowired
    private JwtService jwtService;

    @PostMapping("/create")
    public WalletDto createWallet(@RequestHeader String token) {
        return adapter.convertEntity(service.createWallet(jwtService.getAllClaimsFromToken(token).getPhoneNumber()));
    }
    @PostMapping("/createTest")
    public WalletDto createWalletTest(@RequestBody WalletDto dto) {
        return adapter.convertEntity(service.createWallet(dto.getPhoneNumber()));
    }
}
