package pl.pollub.application.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.pollub.application.domain.entities.ReportEntity;
import pl.pollub.application.infrastructure.Report.ReportDto;

import java.util.List;

public interface ReportRepository extends JpaRepository<ReportEntity, Long> {

    @Query("select new pl.pollub.application.infrastructure.Report.ReportDto(r.description, r.date, r.offerByOfferId.id, r.customerByCustomerId.id, r.id) from ReportEntity r")
    List<ReportDto> getAllReports();

    @Query("select new pl.pollub.application.infrastructure.Report.ReportDto(r.description, r.date, r.offerByOfferId.id, r.customerByCustomerId.id, r.id) from ReportEntity r where r.id = :id")
    ReportDto getReportById(Long id);

}
