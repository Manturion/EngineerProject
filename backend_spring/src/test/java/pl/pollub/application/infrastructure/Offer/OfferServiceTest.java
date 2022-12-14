package pl.pollub.application.infrastructure.Offer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {OfferService.class})
@ExtendWith(SpringExtension.class)
class OfferServiceTest {
    @MockBean
    private OfferPort offerPort;

    @Autowired
    private OfferService offerService;

    /**
     * Method under test: {@link OfferService#getOfferById(Long)}
     */
    @Test
    void testGetOfferById() {
        BigDecimal oldPrice = BigDecimal.valueOf(42L);
        BigDecimal newPrice = BigDecimal.valueOf(42L);
        BigDecimal latitude = BigDecimal.valueOf(42L);
        BigDecimal longitude = BigDecimal.valueOf(42L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date startDate = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Optional<OfferDto> ofResult = Optional.of(new OfferDto("Dr", "The characteristics of someone or something",
                "Image", oldPrice, newPrice, latitude, longitude, startDate,
                Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()), true, 123L, 123L));
        when(offerPort.getOfferById((Long) any())).thenReturn(ofResult);
        Optional<OfferDto> actualOfferById = offerService.getOfferById(123L);
        assertSame(ofResult, actualOfferById);
        assertTrue(actualOfferById.isPresent());
        OfferDto getResult = actualOfferById.get();
        assertEquals("42", getResult.getLatitude().toString());
        assertEquals("42", getResult.getLongitude().toString());
        assertEquals("42", getResult.getNewPrice().toString());
        assertEquals("42", getResult.getOldPrice().toString());
        verify(offerPort).getOfferById((Long) any());
    }

    /**
     * Method under test: {@link OfferService#getAllOffers()}
     */
    @Test
    void testGetAllOffers() {
        ArrayList<OfferDto> offerDtoList = new ArrayList<>();
        when(offerPort.getAllOffers()).thenReturn(offerDtoList);
        List<OfferDto> actualAllOffers = offerService.getAllOffers();
        assertSame(offerDtoList, actualAllOffers);
        assertTrue(actualAllOffers.isEmpty());
        verify(offerPort).getAllOffers();
    }

    /**
     * Method under test: {@link OfferService#getAllOffersBelongingToUser(Long)}
     */
    @Test
    void testGetAllOffersBelongingToUser() {
        ArrayList<OfferDto> offerDtoList = new ArrayList<>();
        when(offerPort.getAllOffersBelongingToUser((Long) any())).thenReturn(offerDtoList);
        List<OfferDto> actualAllOffersBelongingToUser = offerService.getAllOffersBelongingToUser(123L);
        assertSame(offerDtoList, actualAllOffersBelongingToUser);
        assertTrue(actualAllOffersBelongingToUser.isEmpty());
        verify(offerPort).getAllOffersBelongingToUser((Long) any());
    }

    /**
     * Method under test: {@link OfferService#createOffer(CreateOfferDto)}
     */
    @Test
    void testCreateOffer() {
        when(offerPort.createOffer((CreateOfferDto) any())).thenReturn(1L);
        assertEquals(1L, offerService.createOffer(new CreateOfferDto()).longValue());
        verify(offerPort).createOffer((CreateOfferDto) any());
    }

    /**
     * Method under test: {@link OfferService#deleteOffer(Long)}
     */
    @Test
    void testDeleteOffer() {
        when(offerPort.deleteOffer((Long) any())).thenReturn(1L);
        assertEquals(1L, offerService.deleteOffer(123L).longValue());
        verify(offerPort).deleteOffer((Long) any());
    }

    /**
     * Method under test: {@link OfferService#editOffer(CreateOfferDto, Long)}
     */
    @Test
    void testEditOffer() {
        Optional<Long> ofResult = Optional.of(42L);
        when(offerPort.editOffer((Long) any(), (CreateOfferDto) any())).thenReturn(ofResult);
        Optional<Long> actualEditOfferResult = offerService.editOffer(new CreateOfferDto(), 123L);
        assertSame(ofResult, actualEditOfferResult);
        assertTrue(actualEditOfferResult.isPresent());
        assertEquals(42L, actualEditOfferResult.get());
        verify(offerPort).editOffer((Long) any(), (CreateOfferDto) any());
    }
}

