package pl.pollub.application.domain.adapters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.pollub.application.domain.entities.CategoryEntity;
import pl.pollub.application.domain.entities.CustomerEntity;
import pl.pollub.application.domain.entities.OfferEntity;
import pl.pollub.application.domain.entities.RoleEntity;
import pl.pollub.application.domain.entities.StatusEntity;
import pl.pollub.application.domain.mappers.OfferMapper;
import pl.pollub.application.domain.repositories.CategoryRepository;
import pl.pollub.application.domain.repositories.CustomerRepository;
import pl.pollub.application.domain.repositories.OfferRepository;
import pl.pollub.application.domain.repositories.StatusRepository;
import pl.pollub.application.infrastructure.Offer.CreateOfferDto;
import pl.pollub.application.infrastructure.Offer.OfferDto;

@ContextConfiguration(classes = {OfferAdapter.class})
@ExtendWith(SpringExtension.class)
class OfferAdapterTest {
    @MockBean
    private CategoryRepository categoryRepository;

    @MockBean
    private CustomerRepository customerRepository;

    @Autowired
    private OfferAdapter offerAdapter;

    @MockBean
    private OfferMapper offerMapper;

    @MockBean
    private OfferRepository offerRepository;

    @MockBean
    private StatusRepository statusRepository;

    /**
     * Method under test: {@link OfferAdapter#getAllOffers()}
     */
    @Test
    void testGetAllOffers() {
        ArrayList<OfferDto> offerDtoList = new ArrayList<>();
        when(offerRepository.getAllOffers()).thenReturn(offerDtoList);
        List<OfferDto> actualAllOffers = offerAdapter.getAllOffers();
        assertSame(offerDtoList, actualAllOffers);
        assertTrue(actualAllOffers.isEmpty());
        verify(offerRepository).getAllOffers();
    }

    /**
     * Method under test: {@link OfferAdapter#getOfferById(Long)}
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
        when(offerRepository.getOfferById((Long) any())).thenReturn(new OfferDto("Dr",
                "The characteristics of someone or something", "Image", oldPrice, newPrice, latitude, longitude, startDate,
                Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()), true, 123L, 123L));
        Optional<OfferDto> actualOfferById = offerAdapter.getOfferById(123L);
        assertTrue(actualOfferById.isPresent());
        OfferDto getResult = actualOfferById.get();
        assertEquals("42", getResult.getLatitude().toString());
        assertEquals("42", getResult.getLongitude().toString());
        assertEquals("42", getResult.getNewPrice().toString());
        assertEquals("42", getResult.getOldPrice().toString());
        verify(offerRepository).getOfferById((Long) any());
    }

    /**
     * Method under test: {@link OfferAdapter#createOffer(CreateOfferDto)}
     */
    @Test
    void testCreateOffer() {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(123L);
        categoryEntity.setName("Name");
        categoryEntity.setOffersById(new ArrayList<>());

        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setCustomersById(new ArrayList<>());
        roleEntity.setId(123L);
        roleEntity.setName("Name");

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setBanned(true);
        customerEntity.setBannedCustomersById(new ArrayList<>());
        customerEntity.setCustomers(new HashSet<>());
        customerEntity.setDeleted(true);
        customerEntity.setEmail("jane.doe@example.org");
        customerEntity.setGrades(new HashSet<>());
        customerEntity.setId(123L);
        customerEntity.setName("Name");
        customerEntity.setOfferCounter(3);
        customerEntity.setPassword("iloveyou");
        customerEntity.setPhoneNumber("4105551212");
        customerEntity.setReportsById(new ArrayList<>());
        customerEntity.setRespect(1);
        customerEntity.setRoleByRoleId(roleEntity);
        customerEntity.setSalt("Salt");
        customerEntity.setToken("ABC123");

        StatusEntity statusEntity = new StatusEntity();
        statusEntity.setId(123L);
        statusEntity.setName("Name");
        statusEntity.setOffersById(new ArrayList<>());

        OfferEntity offerEntity = new OfferEntity();
        offerEntity.setAvailable(true);
        offerEntity.setCategoryByCategoryId(categoryEntity);
        offerEntity.setCreatedBy(customerEntity);
        offerEntity.setDeleted(true);
        offerEntity.setDescription("The characteristics of someone or something");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        offerEntity.setExpireDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        offerEntity.setGrades(new HashSet<>());
        offerEntity.setId(123L);
        offerEntity.setImage("Image");
        offerEntity.setLatitude(BigDecimal.valueOf(42L));
        offerEntity.setLongitude(BigDecimal.valueOf(42L));
        offerEntity.setNewPrice(BigDecimal.valueOf(42L));
        offerEntity.setOldPrice(BigDecimal.valueOf(42L));
        offerEntity.setReportsById(new ArrayList<>());
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        offerEntity.setStartDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        offerEntity.setStatusByStatusId(statusEntity);
        offerEntity.setTitle("Dr");
        when(offerRepository.save((OfferEntity) any())).thenReturn(offerEntity);

        RoleEntity roleEntity1 = new RoleEntity();
        roleEntity1.setCustomersById(new ArrayList<>());
        roleEntity1.setId(123L);
        roleEntity1.setName("Name");

        CustomerEntity customerEntity1 = new CustomerEntity();
        customerEntity1.setBanned(true);
        customerEntity1.setBannedCustomersById(new ArrayList<>());
        customerEntity1.setCustomers(new HashSet<>());
        customerEntity1.setDeleted(true);
        customerEntity1.setEmail("jane.doe@example.org");
        customerEntity1.setGrades(new HashSet<>());
        customerEntity1.setId(123L);
        customerEntity1.setName("Name");
        customerEntity1.setOfferCounter(3);
        customerEntity1.setPassword("iloveyou");
        customerEntity1.setPhoneNumber("4105551212");
        customerEntity1.setReportsById(new ArrayList<>());
        customerEntity1.setRespect(1);
        customerEntity1.setRoleByRoleId(roleEntity1);
        customerEntity1.setSalt("Salt");
        customerEntity1.setToken("ABC123");
        Optional<CustomerEntity> ofResult = Optional.of(customerEntity1);
        when(customerRepository.findById((Long) any())).thenReturn(ofResult);

        StatusEntity statusEntity1 = new StatusEntity();
        statusEntity1.setId(123L);
        statusEntity1.setName("Name");
        statusEntity1.setOffersById(new ArrayList<>());
        Optional<StatusEntity> ofResult1 = Optional.of(statusEntity1);
        when(statusRepository.findById((Long) any())).thenReturn(ofResult1);

        CategoryEntity categoryEntity1 = new CategoryEntity();
        categoryEntity1.setId(123L);
        categoryEntity1.setName("Name");
        categoryEntity1.setOffersById(new ArrayList<>());
        Optional<CategoryEntity> ofResult2 = Optional.of(categoryEntity1);
        when(categoryRepository.findById((Long) any())).thenReturn(ofResult2);

        CategoryEntity categoryEntity2 = new CategoryEntity();
        categoryEntity2.setId(123L);
        categoryEntity2.setName("Name");
        categoryEntity2.setOffersById(new ArrayList<>());

        RoleEntity roleEntity2 = new RoleEntity();
        roleEntity2.setCustomersById(new ArrayList<>());
        roleEntity2.setId(123L);
        roleEntity2.setName("Name");

        CustomerEntity customerEntity2 = new CustomerEntity();
        customerEntity2.setBanned(true);
        customerEntity2.setBannedCustomersById(new ArrayList<>());
        customerEntity2.setCustomers(new HashSet<>());
        customerEntity2.setDeleted(true);
        customerEntity2.setEmail("jane.doe@example.org");
        customerEntity2.setGrades(new HashSet<>());
        customerEntity2.setId(123L);
        customerEntity2.setName("Name");
        customerEntity2.setOfferCounter(3);
        customerEntity2.setPassword("iloveyou");
        customerEntity2.setPhoneNumber("4105551212");
        customerEntity2.setReportsById(new ArrayList<>());
        customerEntity2.setRespect(1);
        customerEntity2.setRoleByRoleId(roleEntity2);
        customerEntity2.setSalt("Salt");
        customerEntity2.setToken("ABC123");

        StatusEntity statusEntity2 = new StatusEntity();
        statusEntity2.setId(123L);
        statusEntity2.setName("Name");
        statusEntity2.setOffersById(new ArrayList<>());

        OfferEntity offerEntity1 = new OfferEntity();
        offerEntity1.setAvailable(true);
        offerEntity1.setCategoryByCategoryId(categoryEntity2);
        offerEntity1.setCreatedBy(customerEntity2);
        offerEntity1.setDeleted(true);
        offerEntity1.setDescription("The characteristics of someone or something");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        offerEntity1.setExpireDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        offerEntity1.setGrades(new HashSet<>());
        offerEntity1.setId(123L);
        offerEntity1.setImage("Image");
        offerEntity1.setLatitude(BigDecimal.valueOf(42L));
        offerEntity1.setLongitude(BigDecimal.valueOf(42L));
        offerEntity1.setNewPrice(BigDecimal.valueOf(42L));
        offerEntity1.setOldPrice(BigDecimal.valueOf(42L));
        offerEntity1.setReportsById(new ArrayList<>());
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        offerEntity1.setStartDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        offerEntity1.setStatusByStatusId(statusEntity2);
        offerEntity1.setTitle("Dr");
        when(offerMapper.mapToEntity((CreateOfferDto) any())).thenReturn(offerEntity1);
        assertEquals(123L, offerAdapter.createOffer(new CreateOfferDto()).longValue());
        verify(offerRepository).save((OfferEntity) any());
        verify(customerRepository).findById((Long) any());
        verify(statusRepository).findById((Long) any());
        verify(categoryRepository).findById((Long) any());
        verify(offerMapper).mapToEntity((CreateOfferDto) any());
    }

    /**
     * Method under test: {@link OfferAdapter#deleteOffer(Long)}
     */
    @Test
    void testDeleteOffer() {
        doNothing().when(offerRepository).deleteById((Long) any());
        assertEquals(123L, offerAdapter.deleteOffer(123L).longValue());
        verify(offerRepository).deleteById((Long) any());
    }

    /**
     * Method under test: {@link OfferAdapter#getAllOffersBelongingToUser(Long)}
     */
    @Test
    void testGetAllOffersBelongingToUser() {
        when(offerRepository.getAllOffers()).thenReturn(new ArrayList<>());
        assertNull(offerAdapter.getAllOffersBelongingToUser(123L));
        verify(offerRepository).getAllOffers();
    }

    /**
     * Method under test: {@link OfferAdapter#editOffer(Long, CreateOfferDto)}
     */
    @Test
    void testEditOffer() {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(123L);
        categoryEntity.setName("Name");
        categoryEntity.setOffersById(new ArrayList<>());

        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setCustomersById(new ArrayList<>());
        roleEntity.setId(123L);
        roleEntity.setName("Name");

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setBanned(true);
        customerEntity.setBannedCustomersById(new ArrayList<>());
        customerEntity.setCustomers(new HashSet<>());
        customerEntity.setDeleted(true);
        customerEntity.setEmail("jane.doe@example.org");
        customerEntity.setGrades(new HashSet<>());
        customerEntity.setId(123L);
        customerEntity.setName("Name");
        customerEntity.setOfferCounter(3);
        customerEntity.setPassword("iloveyou");
        customerEntity.setPhoneNumber("4105551212");
        customerEntity.setReportsById(new ArrayList<>());
        customerEntity.setRespect(1);
        customerEntity.setRoleByRoleId(roleEntity);
        customerEntity.setSalt("Salt");
        customerEntity.setToken("ABC123");

        StatusEntity statusEntity = new StatusEntity();
        statusEntity.setId(123L);
        statusEntity.setName("Name");
        statusEntity.setOffersById(new ArrayList<>());

        OfferEntity offerEntity = new OfferEntity();
        offerEntity.setAvailable(true);
        offerEntity.setCategoryByCategoryId(categoryEntity);
        offerEntity.setCreatedBy(customerEntity);
        offerEntity.setDeleted(true);
        offerEntity.setDescription("The characteristics of someone or something");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        offerEntity.setExpireDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        offerEntity.setGrades(new HashSet<>());
        offerEntity.setId(123L);
        offerEntity.setImage("Image");
        offerEntity.setLatitude(BigDecimal.valueOf(42L));
        offerEntity.setLongitude(BigDecimal.valueOf(42L));
        offerEntity.setNewPrice(BigDecimal.valueOf(42L));
        offerEntity.setOldPrice(BigDecimal.valueOf(42L));
        offerEntity.setReportsById(new ArrayList<>());
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        offerEntity.setStartDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        offerEntity.setStatusByStatusId(statusEntity);
        offerEntity.setTitle("Dr");
        Optional<OfferEntity> ofResult = Optional.of(offerEntity);

        CategoryEntity categoryEntity1 = new CategoryEntity();
        categoryEntity1.setId(123L);
        categoryEntity1.setName("Name");
        categoryEntity1.setOffersById(new ArrayList<>());

        RoleEntity roleEntity1 = new RoleEntity();
        roleEntity1.setCustomersById(new ArrayList<>());
        roleEntity1.setId(123L);
        roleEntity1.setName("Name");

        CustomerEntity customerEntity1 = new CustomerEntity();
        customerEntity1.setBanned(true);
        customerEntity1.setBannedCustomersById(new ArrayList<>());
        customerEntity1.setCustomers(new HashSet<>());
        customerEntity1.setDeleted(true);
        customerEntity1.setEmail("jane.doe@example.org");
        customerEntity1.setGrades(new HashSet<>());
        customerEntity1.setId(123L);
        customerEntity1.setName("Name");
        customerEntity1.setOfferCounter(3);
        customerEntity1.setPassword("iloveyou");
        customerEntity1.setPhoneNumber("4105551212");
        customerEntity1.setReportsById(new ArrayList<>());
        customerEntity1.setRespect(1);
        customerEntity1.setRoleByRoleId(roleEntity1);
        customerEntity1.setSalt("Salt");
        customerEntity1.setToken("ABC123");

        StatusEntity statusEntity1 = new StatusEntity();
        statusEntity1.setId(123L);
        statusEntity1.setName("Name");
        statusEntity1.setOffersById(new ArrayList<>());

        OfferEntity offerEntity1 = new OfferEntity();
        offerEntity1.setAvailable(true);
        offerEntity1.setCategoryByCategoryId(categoryEntity1);
        offerEntity1.setCreatedBy(customerEntity1);
        offerEntity1.setDeleted(true);
        offerEntity1.setDescription("The characteristics of someone or something");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        offerEntity1.setExpireDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        offerEntity1.setGrades(new HashSet<>());
        offerEntity1.setId(123L);
        offerEntity1.setImage("Image");
        offerEntity1.setLatitude(BigDecimal.valueOf(42L));
        offerEntity1.setLongitude(BigDecimal.valueOf(42L));
        offerEntity1.setNewPrice(BigDecimal.valueOf(42L));
        offerEntity1.setOldPrice(BigDecimal.valueOf(42L));
        offerEntity1.setReportsById(new ArrayList<>());
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        offerEntity1.setStartDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        offerEntity1.setStatusByStatusId(statusEntity1);
        offerEntity1.setTitle("Dr");
        when(offerRepository.save((OfferEntity) any())).thenReturn(offerEntity1);
        when(offerRepository.findById((Long) any())).thenReturn(ofResult);
        Optional<Long> actualEditOfferResult = offerAdapter.editOffer(123L, new CreateOfferDto());
        assertTrue(actualEditOfferResult.isPresent());
        assertEquals(123L, actualEditOfferResult.get());
        verify(offerRepository).save((OfferEntity) any());
        verify(offerRepository).findById((Long) any());
    }
}

