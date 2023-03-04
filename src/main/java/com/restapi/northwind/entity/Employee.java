package com.restapi.northwind.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String customerName;
    @Column(name = "last_name")
    private String contactName;
    @Column(name = "birth_date")
    private String birthDate;
    @Column(name = "photo")
    private String photo;
    @Column(name = "notes")
    private String note;
    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
    private Set<Order> orders;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id.equals(employee.id) && customerName.equals(employee.customerName) && contactName.equals(employee.contactName) && birthDate.equals(employee.birthDate) && photo.equals(employee.photo) && note.equals(employee.note) && orders.equals(employee.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerName, contactName, birthDate, photo, note);
    }
}
