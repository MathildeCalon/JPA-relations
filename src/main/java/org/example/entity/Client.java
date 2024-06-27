package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private int id;

    private String firstname;
    private String lastname;
    private int age;
    private String telephone;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_address")
    private Address address;

    @OneToMany(mappedBy = "client")
    private List<Ticket> tickets;

    @Override
    public String toString(){
        return "Client{"+
                "firstname=" + firstname + " / " +
                "lastname=" + lastname + " / " +
                "age="+ age + " / " +
                "telephone=" + " / " +
                "id=" + id +
                "}";
    }
}
