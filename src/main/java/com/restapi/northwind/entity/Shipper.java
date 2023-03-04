package com.restapi.northwind.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@Table(name = "shippers")
@AllArgsConstructor
@NoArgsConstructor
public class Shipper implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "shipper_name")
    private String shipperName;
    @Column(name = "phone")
    private String phone;
    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "shipper", fetch = FetchType.LAZY)
    private Set<Order> orders;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shipper shipper = (Shipper) o;
        return id.equals(shipper.id) && shipperName.equals(shipper.shipperName) && phone.equals(shipper.phone) && orders.equals(shipper.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shipperName, phone, orders);
    }
}
