package double_p.ptravel.module.seat.entity;

import double_p.ptravel.module.train.entity.Train;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private int carriageNumber;
    private int number;
    private String status;

    @ManyToOne
    @JoinColumn(name = "train_id", nullable = false)
    private Train train;
}