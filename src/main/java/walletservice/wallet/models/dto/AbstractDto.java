package walletservice.wallet.models.dto;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseDataSource;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
@Data
public class AbstractDto {

    private String id;
    @CreatedDate
    private Date insetDate;
    @LastModifiedDate
    private Date lastModifiedDate;

}