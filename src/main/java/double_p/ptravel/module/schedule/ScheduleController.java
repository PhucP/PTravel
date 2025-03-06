package double_p.ptravel.module.schedule;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import double_p.ptravel.module.schedule.service.IScheduleService;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    private final IScheduleService scheduleService;

    public ScheduleController(IScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

}
