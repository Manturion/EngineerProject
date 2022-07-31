package pl.pollub.inzynierka.infrastructure.Report;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ReportDto extends ReportDtoTemplate{
    private Long id;

    public ReportDto(String description, Date date, Long offerId, Long customerId, Long id) {
        super(description, date, offerId, customerId);
        this.id = id;
    }
}
