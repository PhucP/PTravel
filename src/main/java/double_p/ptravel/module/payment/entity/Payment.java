package double_p.ptravel.module.payment.entity;

import double_p.ptravel.module.order.entity.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private String status;

    @OneToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id", unique = true)
    private Order order;
}