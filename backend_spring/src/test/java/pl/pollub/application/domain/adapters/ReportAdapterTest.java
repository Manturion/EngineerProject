package pl.pollub.application.domain.adapters;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.pollub.application.domain.repositories.ReportRepository;
import pl.pollub.application.infrastructure.Report.ReportDto;

@ContextConfiguration(classes = {ReportAdapter.class})
@ExtendWith(SpringExtension.class)
class ReportAdapterTest {
    @Autowired
    private ReportAdapter reportAdapter;

    @MockBean
    private ReportRepository reportRepository;

    /**
     * Method under test: {@link ReportAdapter#getReportById(Long)}
     */
    @Test
    void testGetReportById() {
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        ReportDto reportDto = new ReportDto("The characteristics of someone or something",
                Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()), 123L, 123L, 123L);

        when(reportRepository.getReportById((Long) any())).thenReturn(reportDto);
        assertSame(reportDto, reportAdapter.getReportById(123L));
        verify(reportRepository).getReportById((Long) any());
    }

    /**
     * Method under test: {@link ReportAdapter#getAllReports()}
     */
    @Test
    void testGetAllReports() {
        ArrayList<ReportDto> reportDtoList = new ArrayList<>();
        when(reportRepository.getAllReports()).thenReturn(reportDtoList);
        List<ReportDto> actualAllReports = reportAdapter.getAllReports();
        assertSame(reportDtoList, actualAllReports);
        assertTrue(actualAllReports.isEmpty());
        verify(reportRepository).getAllReports();
    }
}

