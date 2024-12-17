package double_p.ptravel.module.train.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import double_p.ptravel.module.train.dto.CreateTrainDto;
import double_p.ptravel.module.train.entity.Train;
import double_p.ptravel.module.train.service.ITrainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/train")
public class TrainController {
    private final ITrainService trainService;

    public TrainController(ITrainService trainService) {
        this.trainService = trainService;
    }

    @GetMapping("/{trainId}")
    public Train findById(@PathVariable Long trainId) {
        return trainService.findbyId(trainId);
    }

    @PostMapping("/create")
    public Train create(@RequestBody CreateTrainDto dto) {
        return trainService.create(dto);
    }
    
    
}
