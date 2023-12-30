package walletservice.wallet.convertor;

import org.mapstruct.Mapper;
import walletservice.wallet.models.dto.WalletTransactionDto;
import walletservice.wallet.models.entities.WalletTransaction;
@Mapper(componentModel = "spring")
public interface WalletTransactionConvertor extends AbstractConvertor<WalletTransactionDto, WalletTransaction>{
}
