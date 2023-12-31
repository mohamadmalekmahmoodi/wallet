package walletservice.wallet.convertor;

import java.util.List;
import java.util.stream.Collectors;

public interface AbstractConvertor <D,E>{

    E convertDto(D d);

    D convertEntity(E e);
    default List<E> convertDto(List<D> dList) {
        if (dList != null) {
            return dList.stream()
                    .map(this::convertDto)
                    .collect(Collectors.toList());
        }
        return null;
    }

    default List<D> convertEntity(List<E> dList) {
        if (dList != null) {
            return dList.stream()
                    .map(this::convertEntity)
                    .collect(Collectors.toList());
        }
        return null;
    }


}
