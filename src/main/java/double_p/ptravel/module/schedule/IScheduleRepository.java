package double_p.ptravel.module.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import double_p.ptravel.module.schedule.entity.Schedule;

@Repository
public interface IScheduleRepository extends JpaRepository<Schedule, Long> {

}
