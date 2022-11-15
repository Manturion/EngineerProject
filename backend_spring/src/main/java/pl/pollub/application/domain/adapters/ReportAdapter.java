package pl.pollub.application.domain.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.pollub.application.domain.repositories.ReportRepository;
import pl.pollub.application.infrastructure.Report.ReportDto;
import pl.pollub.application.infrastructure.Report.ReportPort;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ReportAdapter implements ReportPort {

    private final ReportRepository reportRepository;

    @Override
    public ReportDto getReportById(Long id) {
        return reportRepository.getReportById(id);
    }

    @Override
    public List<ReportDto> getAllReports() {
        return reportRepository.getAllReports();
    }
}
