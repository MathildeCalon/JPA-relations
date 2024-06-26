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
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address")
    private int id;
    private String street;
    private String city;

    @OneToOne
    @JoinColumn(name = "id_client")
    private Client client;
    @OneToOne
    @JoinColumn(name = "id_event")
    private Event events;

}
