package double_p.ptravel.module.train.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import double_p.ptravel.module.train.dto.CreateTrainDto;
import double_p.ptravel.module.train.dto.SearchTrainDto;
import double_p.ptravel.module.train.dto.UpdateTrainDto;
import double_p.ptravel.module.train.entity.Train;
import double_p.ptravel.module.train.repository.ITrainRepository;
import double_p.ptravel.module.train.service.ITrainService;

@Service
public class TrainService implements ITrainService{
    private final ITrainRepository trainRepository;

    public TrainService(ITrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    @Override
    public Train findbyId(Long id) {
        return trainRepository.findById(id).orElse(null);
    }

    @Override
    public List<Train> search(SearchTrainDto dto) {
        return trainRepository.searchTrain(dto);
    }

    @Override
    public Train create(CreateTrainDto dto) {
        Train newTrain = new Train();
        newTrain.setName(dto.getName());
        newTrain.setStatus(dto.getStatus());
        newTrain.setCapacity(dto.getCapacity());
        return trainRepository.save(newTrain);
    }

    @Override
    public Train update(Long trainId, UpdateTrainDto dto) {
        Train train = trainRepository.findById(trainId).orElse(null);
        if(train!= null) {
            train.setName(dto.getName());
            train.setStatus(dto.getStatus());
            train.setCapacity(dto.getCapacity());
            return trainRepository.save(train);
        }
        return null;
    }

    @Override
    public void delete(Long trainId) {
        trainRepository.deleteById(trainId);
    }
}
