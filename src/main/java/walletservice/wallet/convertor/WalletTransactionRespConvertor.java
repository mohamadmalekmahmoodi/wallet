package walletservice.wallet.convertor;

import org.mapstruct.Mapper;
import walletservice.wallet.models.dto.response.WalletTransactionDtoResp;
import walletservice.wallet.models.entities.WalletTransaction;
@Mapper(componentModel = "spring")
public interface WalletTransactionRespConvertor extends AbstractConvertor<WalletTransactionDtoResp, WalletTransaction> {
}
