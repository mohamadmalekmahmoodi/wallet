package walletservice.wallet.convertor;

import org.mapstruct.Mapper;
import walletservice.wallet.models.dto.request.WalletDto;
import walletservice.wallet.models.entities.Wallet;
@Mapper(componentModel = "spring")
public interface WalletConvertor extends AbstractConvertor<WalletDto,Wallet>{

}
