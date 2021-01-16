package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservationId")
    private Integer id;

    private Integer isPaid;

    //relacioni

    @ManyToOne
    @JoinColumn(name="clientId")
    private Client client;

    @ManyToMany
    @JoinTable(
            name="reservation_seat",
            joinColumns={@JoinColumn(name="reservationId")},
            inverseJoinColumns={@JoinColumn(name="seatId")}
    )
    private Set<Seat> seats=new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Integer isPaid) {
        this.isPaid = isPaid;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<Seat> getSeats() {
        return seats;
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", isPaid=" + isPaid +
                '}';
    }
}
