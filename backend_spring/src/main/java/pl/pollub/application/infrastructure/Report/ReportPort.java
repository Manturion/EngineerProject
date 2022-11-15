package pl.pollub.application.infrastructure.Report;

import java.util.List;

public interface ReportPort {

    ReportDto getReportById(Long id);

    List<ReportDto> getAllReports();
}
