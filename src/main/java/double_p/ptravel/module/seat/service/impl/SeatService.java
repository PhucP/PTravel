package double_p.ptravel.module.seat.service.impl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import double_p.ptravel.module.seat.dto.CreateSeatDto;
import double_p.ptravel.module.seat.dto.SearchSeatDto;
import double_p.ptravel.module.seat.dto.UpdateSeatDto;
import double_p.ptravel.module.seat.entity.Seat;
import double_p.ptravel.module.seat.repository.ISeatRepository;
import double_p.ptravel.module.seat.service.ISeatService;
import double_p.ptravel.module.train.entity.Train;
import double_p.ptravel.module.train.service.ITrainService;
import jakarta.transaction.Transactional;

@Service
public class SeatService implements ISeatService{
    private final ISeatRepository seatRepository;
    private final ITrainService trainService;

    public SeatService(ISeatRepository seatRepository, ITrainService trainService) {
        this.seatRepository = seatRepository;
        this.trainService = trainService;
    }

    @Override
    public Optional<Seat> findById(Long seatId) {
        return seatRepository.findById(seatId);
    }

    @Override
    public String delete(Long seatId) {
        seatRepository.deleteById(seatId);
        return "Seat with id " + seatId + " has been deleted";
    }

    @Transactional
    @Override
    public Seat create(CreateSeatDto dto) {
        Train train = trainService.findbyId(dto.getTrainId());
        if(train != null) {
        Seat seat = new Seat();
        seat.setNumber(dto.getNumber());
        seat.setCarriageNumber(dto.getCarriageNumber());
        seat.setStatus("Available");
        seat.setTrain(train);
        return seatRepository.save(seat);
        }
        return null;
    }

    @Override
    public Page<Seat> search(SearchSeatDto dto, Pageable pageable) {
        return seatRepository.search(dto, pageable);
    }

    @Override
    public Seat update(Long seatId, UpdateSeatDto dto) {
        Seat seat = findById(seatId).orElse(null);
        if(seat != null) {

        } 
        return null;
    }

}
