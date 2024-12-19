package double_p.ptravel.module.train.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import double_p.ptravel.module.train.dto.CreateTrainDto;
import double_p.ptravel.module.train.dto.SearchTrainDto;
import double_p.ptravel.module.train.dto.UpdateTrainDto;
import double_p.ptravel.module.train.entity.Train;
import double_p.ptravel.module.train.service.ITrainService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @DeleteMapping("delete/{trainId}")
    public String delete(@PathVariable Long trainId) {
        return trainService.delete(trainId);
    }

    @PatchMapping("update/{trainId}")
    public Train update(@PathVariable Long trainId, @RequestBody UpdateTrainDto dto) {
        return trainService.update(trainId, dto);
    }

    @GetMapping("/search")
    public Page<Train> search(@RequestBody SearchTrainDto dto,
    @RequestParam int page,
    @RequestParam int size ,
    @RequestParam(defaultValue = "id") String sort,
    @RequestParam(defaultValue = "desc") String direction
    ) {
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC: Sort.Direction.DESC;
        Sort sortBy = Sort.by(sortDirection, sort);
        Pageable pageable = PageRequest.of(page, size, sortBy);
        return trainService.search(dto, pageable);
    }
 
    @GetMapping("/all")
    public Page<Train> findALl(
        @RequestParam int page,
        @RequestParam int size ,
        @RequestParam(defaultValue = "id") String sort,
        @RequestParam(defaultValue = "desc") String direction
    ) {
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC: Sort.Direction.DESC;
        Sort sortBy = Sort.by(sortDirection, sort);
        Pageable pageable = PageRequest.of(page, size, sortBy);
        return trainService.findAll(pageable);
    }
    
}
