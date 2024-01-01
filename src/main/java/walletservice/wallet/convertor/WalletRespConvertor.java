package walletservice.wallet.convertor;

import org.mapstruct.Mapper;
import walletservice.wallet.models.dto.response.WalletResponseDto;
import walletservice.wallet.models.entities.Wallet;
@Mapper(componentModel = "spring")
public interface WalletRespConvertor extends AbstractConvertor<WalletResponseDto, Wallet> {
}
