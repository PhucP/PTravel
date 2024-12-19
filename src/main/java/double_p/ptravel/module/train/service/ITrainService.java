package double_p.ptravel.module.train.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import double_p.ptravel.module.seat.entity.Seat;
import double_p.ptravel.module.train.dto.CreateTrainDto;
import double_p.ptravel.module.train.dto.SearchTrainDto;
import double_p.ptravel.module.train.dto.UpdateTrainDto;
import double_p.ptravel.module.train.entity.Train;

public interface ITrainService {
    public Train findbyId(Long id);

    public Page<Train> search(SearchTrainDto dto, Pageable pageable);

    public Train create(CreateTrainDto dto);

    public Train update(Long trainId, UpdateTrainDto dto);

    public String delete(Long trainId);

    public Page<Train> findAll(Pageable pageable);
}
