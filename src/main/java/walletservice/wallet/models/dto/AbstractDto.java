package walletservice.wallet.models.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
@Data
@MappedSuperclass
public abstract class AbstractDto {

    private String id;
    @CreatedDate
    private Date insetDate;
    @LastModifiedDate
    private Date lastModifiedDate;

}
