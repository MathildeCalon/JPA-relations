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

    @Override
    public String toString(){
        return "Event{"+
                "id=" + id + " / " +
                "street=" + street + " / " +
                "city=" + city + " / " +
                "}";
    }
}
