package pl.pollub.inzynierka.infrastructure.Report;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ReportPort reportPort;

    public ReportDto getReportById(Long id){
        return reportPort.getReportById(id);
    }

    public List<ReportDto> getAllReports(){
        return reportPort.getAllReports();
    }

}
