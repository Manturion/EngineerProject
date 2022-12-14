package pl.pollub.application.api;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.pollub.application.infrastructure.Report.ReportDto;
import pl.pollub.application.infrastructure.Report.ReportService;

@ContextConfiguration(classes = {ReportController.class})
@ExtendWith(SpringExtension.class)
class ReportControllerTest {
    @Autowired
    private ReportController reportController;

    @MockBean
    private ReportService reportService;

    /**
     * Method under test: {@link ReportController#getAllReports()}
     */
    @Test
    void testGetAllReports() throws Exception {
        when(reportService.getAllReports()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/reports");
        MockMvcBuilders.standaloneSetup(reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ReportController#getAllReports()}
     */
    @Test
    void testGetAllReports2() throws Exception {
        when(reportService.getAllReports()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/reports");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(reportController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ReportController#getAllReports(Long)}
     */
    @Test
    void testGetAllReports3() throws Exception {
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        when(reportService.getReportById((Long) any()))
                .thenReturn(new ReportDto("The characteristics of someone or something",
                        Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()), 123L, 123L, 123L));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/report/{id}", 123L);
        MockMvcBuilders.standaloneSetup(reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"description\":\"The characteristics of someone or something\",\"date\":\"01-01-1970 12:00:00\",\"offerId\""
                                        + ":123,\"customerId\":123,\"id\":123}"));
    }
}

