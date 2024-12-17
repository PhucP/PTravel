package double_p.ptravel.module.order.entity;

import double_p.ptravel.module.ticket.entity.Ticket;
import double_p.ptravel.module.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany
    @JoinColumn(name = "order_id", nullable = false)
    private List<Ticket> tickets;
}