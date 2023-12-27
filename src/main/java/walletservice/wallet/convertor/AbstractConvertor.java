package walletservice.wallet.convertor;

import java.util.List;

public interface AbstractConvertor <D,E>{

    D convertEntity(E dto);
    List<D> convertListEntity (List<E> dto);
    E convertDto(D dto);
    List<E> convertListDto (List<D> dto);
}
