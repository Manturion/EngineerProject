package pl.pollub.inzynierka.infrastructure.Report;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public abstract class ReportDtoTemplate {

    protected String description;
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    protected Date date;
    protected Long offerId;
    protected Long customerId;
}
