package com.restapi.northwind.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "contact_name")
    private String contactName;
    @Column(name = "adress")
    private String adress;
    @Column(name = "city")
    private String city;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "country")
    private String country;
    @ToString.Exclude
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<Order> orders;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id.equals(customer.id) && customerName.equals(customer.customerName) && contactName.equals(customer.contactName) && adress.equals(customer.adress) && city.equals(customer.city) && postalCode.equals(customer.postalCode) && country.equals(customer.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerName, contactName, adress, city, postalCode, country);
    }
}
