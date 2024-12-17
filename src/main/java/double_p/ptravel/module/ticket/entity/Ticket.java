package double_p.ptravel.module.ticket.entity;

import double_p.ptravel.module.schedule.entity.Schedule;
import double_p.ptravel.module.seat.entity.Seat;
import double_p.ptravel.module.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ticket")
public class Ticket{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private Date bookingTime;
    private double price;
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "seat_id", referencedColumnName = "id")
    private Seat seat;

    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;
}