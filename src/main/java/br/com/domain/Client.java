package br.com.domain;

import jakarta.json.bind.annotation.JsonbPropertyOrder;
import jakarta.persistence.*;

@Entity
@JsonbPropertyOrder({"id", "name", "address"})
public class Client {

    @Id
    @GeneratedValue
    Long id;
    String name;

    @ManyToOne
    @JoinColumn(name = "address_id")
    Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
