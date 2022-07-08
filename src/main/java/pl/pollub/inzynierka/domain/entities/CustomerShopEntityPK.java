package pl.pollub.inzynierka.domain.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;
@Data
public class CustomerShopEntityPK implements Serializable {
    @Column(name = "customer_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    @Column(name = "shop_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shopId;
}
