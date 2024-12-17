package double_p.ptravel.module.schedule.entity;

import double_p.ptravel.module.route.entity.Route;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private Date departureTime;
    private Date arrivalTime;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;
}