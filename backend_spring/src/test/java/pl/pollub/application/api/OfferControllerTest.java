package pl.pollub.application.api;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.pollub.application.infrastructure.Offer.CreateOfferDto;
import pl.pollub.application.infrastructure.Offer.OfferDto;
import pl.pollub.application.infrastructure.Offer.OfferService;

@ContextConfiguration(classes = {OfferController.class})
@ExtendWith(SpringExtension.class)
class OfferControllerTest {
    @Autowired
    private OfferController offerController;

    @MockBean
    private OfferService offerService;

    /**
     * Method under test: {@link OfferController#getAllOffersBelongingToUser(Long)}
     */
    @Test
    void testGetAllOffersBelongingToUser() throws Exception {
        when(offerService.getAllOffersBelongingToUser((Long) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/offer/user/{id}", 123L);
        MockMvcBuilders.standaloneSetup(offerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link OfferController#getAllOffersBelongingToUser(Long)}
     */
    @Test
    void testGetAllOffersBelongingToUser2() throws Exception {
        when(offerService.getAllOffersBelongingToUser((Long) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/offer/user/{id}", 123L);
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(offerController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link OfferController#getAllOffers()}
     */
    @Test
    void testGetAllOffers() throws Exception {
        when(offerService.getAllOffers()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/offer");
        MockMvcBuilders.standaloneSetup(offerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link OfferController#getAllOffers()}
     */
    @Test
    void testGetAllOffers2() throws Exception {
        when(offerService.getAllOffers()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/offer");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(offerController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link OfferController#createOffer(CreateOfferDto)}
     */
    @Test
    void testCreateOffer() throws Exception {
        when(offerService.createOffer((CreateOfferDto) any())).thenReturn(1L);

        CreateOfferDto createOfferDto = new CreateOfferDto();
        createOfferDto.setAvailable(true);
        createOfferDto.setCategoryId(123L);
        createOfferDto.setDescription("The characteristics of someone or something");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        createOfferDto.setExpireDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        createOfferDto.setImage("Image");
        createOfferDto.setLatitude(BigDecimal.valueOf(42L));
        createOfferDto.setLongitude(BigDecimal.valueOf(42L));
        createOfferDto.setNewPrice(BigDecimal.valueOf(42L));
        createOfferDto.setOldPrice(BigDecimal.valueOf(42L));
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        createOfferDto.setStartDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        createOfferDto.setTitle("Dr");
        String content = (new ObjectMapper()).writeValueAsString(createOfferDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/offer/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(offerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("1"));
    }

    /**
     * Method under test: {@link OfferController#deleteOffer(Long)}
     */
    @Test
    void testDeleteOffer() throws Exception {
        when(offerService.deleteOffer((Long) any())).thenReturn(1L);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/offer/delete/{id}", 123L);
        MockMvcBuilders.standaloneSetup(offerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("1"));
    }

    /**
     * Method under test: {@link OfferController#deleteOffer(Long)}
     */
    @Test
    void testDeleteOffer2() throws Exception {
        when(offerService.deleteOffer((Long) any())).thenReturn(1L);
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/api/offer/delete/{id}", 123L);
        deleteResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(offerController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("1"));
    }

    /**
     * Method under test: {@link OfferController#editOffer(CreateOfferDto, Long)}
     */
    @Test
    void testEditOffer() throws Exception {
        when(offerService.editOffer((CreateOfferDto) any(), (Long) any())).thenReturn(Optional.of(42L));

        CreateOfferDto createOfferDto = new CreateOfferDto();
        createOfferDto.setAvailable(true);
        createOfferDto.setCategoryId(123L);
        createOfferDto.setDescription("The characteristics of someone or something");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        createOfferDto.setExpireDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        createOfferDto.setImage("Image");
        createOfferDto.setLatitude(BigDecimal.valueOf(42L));
        createOfferDto.setLongitude(BigDecimal.valueOf(42L));
        createOfferDto.setNewPrice(BigDecimal.valueOf(42L));
        createOfferDto.setOldPrice(BigDecimal.valueOf(42L));
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        createOfferDto.setStartDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        createOfferDto.setTitle("Dr");
        String content = (new ObjectMapper()).writeValueAsString(createOfferDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/offer/edit/{id}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(offerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("42"));
    }

    /**
     * Method under test: {@link OfferController#getOfferId(Long)}
     */
    @Test
    void testGetOfferId() throws Exception {
        BigDecimal oldPrice = BigDecimal.valueOf(42L);
        BigDecimal newPrice = BigDecimal.valueOf(42L);
        BigDecimal latitude = BigDecimal.valueOf(42L);
        BigDecimal longitude = BigDecimal.valueOf(42L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date startDate = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        when(offerService.getOfferById((Long) any())).thenReturn(Optional.of(new OfferDto("Dr",
                "The characteristics of someone or something", "Image", oldPrice, newPrice, latitude, longitude, startDate,
                Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()), true, 123L, 123L)));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/offer/{id}", 123L);
        MockMvcBuilders.standaloneSetup(offerController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"title\":\"Dr\",\"description\":\"The characteristics of someone or something\",\"image\":\"Image\",\"oldPrice\""
                                        + ":42,\"newPrice\":42,\"latitude\":42,\"longitude\":42,\"startDate\":\"1970-01-01T00:00:00.000+00:00\",\"expireDate"
                                        + "\":\"1970-01-01T00:00:00.000+00:00\",\"categoryId\":123,\"id\":123,\"available\":true}"));
    }
}

