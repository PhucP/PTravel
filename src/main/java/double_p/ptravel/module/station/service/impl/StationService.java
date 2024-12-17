package double_p.ptravel.module.station.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import double_p.ptravel.module.station.dto.CreateStationDto;
import double_p.ptravel.module.station.dto.SearchStationDto;
import double_p.ptravel.module.station.dto.UpdateStationDto;
import double_p.ptravel.module.station.entity.Station;
import double_p.ptravel.module.station.repository.IStationRepository;
import double_p.ptravel.module.station.service.IStationService;

@Service
public class StationService implements IStationService{
    private final IStationRepository stationRepository;

    public StationService(IStationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Override
    public Station findById(Long stationId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Station create(CreateStationDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public String delete(Long stationId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Station> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public List<Station> search(SearchStationDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    @Override
    public Station update(Long stationId, UpdateStationDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

}
