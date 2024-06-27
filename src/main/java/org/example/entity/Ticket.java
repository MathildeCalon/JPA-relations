package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.util.Type;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket")
    private int id;
    private int ticketNumber;
    private Enum<Type> type;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_client")
    private Client client;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_event")
    private Event event;

        @Override
    public String toString(){
        return "Event{"+
                "id=" + id + " / " +
                "ticket number=" + ticketNumber + " / " +
                "type=" + type + " / " +
                "client=" + client.getId() + " / " +
                "event=" + event.getId() +
                "}";
    }
}
