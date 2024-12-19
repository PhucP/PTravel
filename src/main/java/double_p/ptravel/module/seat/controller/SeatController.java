package double_p.ptravel.module.seat.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import double_p.ptravel.module.seat.dto.CreateSeatDto;
import double_p.ptravel.module.seat.dto.SearchSeatDto;
import double_p.ptravel.module.seat.dto.UpdateSeatDto;
import double_p.ptravel.module.seat.entity.Seat;
import double_p.ptravel.module.seat.service.ISeatService;

@RestController
@RequestMapping("/seat")
public class SeatController {
    private final ISeatService seatService;
    
    public SeatController(ISeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping("/{seatId}")
    public Seat findById(Long seatId) {
        return seatService.findById(seatId).orElse(null);
    }

    @PostMapping("/search")
    public Page<Seat> search(
        @RequestBody SearchSeatDto dto,
        @RequestParam int page,
        @RequestParam int size ,
        @RequestParam(defaultValue = "id") String sort,
        @RequestParam(defaultValue = "desc") String direction
        ) {
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC: Sort.Direction.DESC;
        Sort sortBy = Sort.by(sortDirection, sort);
        Pageable pageable = PageRequest.of(page, size, sortBy);
        return seatService.search(dto, pageable);
    } 

    @PostMapping("/create")
    public Seat create(@RequestBody CreateSeatDto dto) {
        return seatService.create(dto);
    }

    @DeleteMapping("/delete/{seatId}")
    public String delete(Long seatId) {
        return seatService.delete(seatId);
    }

    @PatchMapping("/update/{seatId}")
    public Seat update(Long seatId, @RequestBody UpdateSeatDto dto)  {
        return seatService.update(seatId, dto);
    }
}
