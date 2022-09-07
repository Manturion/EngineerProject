package pl.pollub.inzynierka.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.pollub.inzynierka.infrastructure.Report.ReportDto;
import pl.pollub.inzynierka.infrastructure.Report.ReportService;

import java.util.List;

@RequestMapping("/api")
@Controller
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/reports")
    @ResponseBody
    public List<ReportDto> getAllReports(){
        return reportService.getAllReports();
    }

    @GetMapping("/report/{id}")
    @ResponseBody
    public ReportDto getAllReports(@PathVariable Long id){
        return reportService.getReportById(id);
    }

}
