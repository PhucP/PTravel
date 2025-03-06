package double_p.ptravel.module.schedule.service;

import org.springframework.data.domain.Page;

import double_p.ptravel.module.schedule.dto.SearchScheduleDto;
import double_p.ptravel.module.schedule.dto.UpdateScheduleDto;
import double_p.ptravel.module.schedule.entity.Schedule;
import double_p.ptravel.module.user.dto.CreateUserDto;

public interface IScheduleService {
    public Schedule findById(Long id);

    public Schedule create(CreateUserDto dto);

    public Schedule update(Long scheduleId, UpdateScheduleDto dto);

    public String remove(Long scheduleId);

    public Page<Schedule> findALL();

    public Page<Schedule> searchSchedule(SearchScheduleDto dto);
}
