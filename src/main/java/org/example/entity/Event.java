package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_event")
    private int id;
    private String name;
    private LocalDate date;
    private String hour;
    private int ticketNumber;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_address")
    private Address address;

    @Override
    public String toString(){
        return "Event{"+
                "id=" + id + " / " +
                "name=" + name + " / " +
                "date=" + date + " / " +
                "hour=" + hour + " / " +
                "number of tickets=" + ticketNumber +
                "}";
    }
}
