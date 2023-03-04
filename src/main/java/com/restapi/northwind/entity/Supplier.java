package com.restapi.northwind.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "suppliers")
@AllArgsConstructor
@NoArgsConstructor
public class Supplier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "supplier_name")
    private String supplierName;
    @Column(name = "contact_name")
    private String contactName;
    @Column(name = "address")
    private String adress;
    @Column(name = "city")
    private String city;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "country")
    private String country;
    @Column(name = "phone")
    private String phone;
    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY)
    private Set<Product> products;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return id.equals(supplier.id) && supplierName.equals(supplier.supplierName) && contactName.equals(supplier.contactName) && adress.equals(supplier.adress) && postalCode.equals(supplier.postalCode) && country.equals(supplier.country) && phone.equals(supplier.phone) && products.equals(supplier.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, supplierName, contactName, adress, postalCode, country, phone);
    }
}
