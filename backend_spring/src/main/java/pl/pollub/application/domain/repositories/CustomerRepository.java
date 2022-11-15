package pl.pollub.inzynierka.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.pollub.inzynierka.domain.entities.CustomerEntity;
import pl.pollub.inzynierka.infrastructure.Customer.CustomerDto;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    @Query("select new pl.pollub.inzynierka.infrastructure.Customer.CustomerDto(c.email, c.name, c.password, c.salt, c.phoneNumber, c.respect, c.isBanned, c.offerCounter, c.token, c.roleByRoleId.id, c.deleted, c.id) from CustomerEntity c")
    List<CustomerDto> getAllCustomers();

    @Query("select new pl.pollub.inzynierka.infrastructure.Customer.CustomerDto(c.email, c.name, c.password, c.salt, c.phoneNumber, c.respect, c.isBanned, c.offerCounter, c.token, c.roleByRoleId.id, c.deleted, c.id) from CustomerEntity c where c.id = :id")
    CustomerDto getCustomerById(Long id);

}
