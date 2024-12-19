package double_p.ptravel.module.seat.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import double_p.ptravel.module.seat.dto.CreateSeatDto;
import double_p.ptravel.module.seat.dto.SearchSeatDto;
import double_p.ptravel.module.seat.dto.UpdateSeatDto;
import double_p.ptravel.module.seat.entity.Seat;

public interface ISeatService {
    public Optional<Seat> findById(Long seatId);

    public String delete(Long seatId);

    public Seat create(CreateSeatDto dto);

    public Seat update(Long seatId, UpdateSeatDto dto);

    public Page<Seat> search(SearchSeatDto dto, Pageable pageable);
}
