package double_p.ptravel.module.schedule.service.impl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import double_p.ptravel.module.schedule.IScheduleRepository;
import double_p.ptravel.module.schedule.dto.SearchScheduleDto;
import double_p.ptravel.module.schedule.dto.UpdateScheduleDto;
import double_p.ptravel.module.schedule.entity.Schedule;
import double_p.ptravel.module.schedule.service.IScheduleService;
import double_p.ptravel.module.user.dto.CreateUserDto;

@Service
public class ScheduleService implements IScheduleService {
    private final IScheduleRepository scheduleRepository;

    public ScheduleService(IScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public Schedule findById(Long id) {
        return scheduleRepository.findById(id).orElseThrow(() -> new RuntimeException("Schedule not found"));
    }

    @Override
    public Schedule create(CreateUserDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Schedule update(Long scheduleId, UpdateScheduleDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public String remove(Long scheduleId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public Page<Schedule> findALL() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findALL'");
    }

    @Override
    public Page<Schedule> searchSchedule(SearchScheduleDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchSchedule'");
    }

}
