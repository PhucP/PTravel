package double_p.ptravel.module.train.service;

import java.util.List;

import double_p.ptravel.module.train.dto.CreateTrainDto;
import double_p.ptravel.module.train.dto.SearchTrainDto;
import double_p.ptravel.module.train.dto.UpdateTrainDto;
import double_p.ptravel.module.train.entity.Train;

public interface ITrainService {
    public Train findbyId(Long id);

    public List<Train> search(SearchTrainDto dto);

    public Train create(CreateTrainDto dto);

    public Train update(Long trainId, UpdateTrainDto dto);

    public void delete(Long trainId);
}
