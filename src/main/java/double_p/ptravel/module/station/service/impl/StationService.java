package double_p.ptravel.module.station.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import double_p.ptravel.module.station.IStationRepository;
import double_p.ptravel.module.station.dto.CreateStationDto;
import double_p.ptravel.module.station.dto.SearchStationDto;
import double_p.ptravel.module.station.dto.UpdateStationDto;
import double_p.ptravel.module.station.entity.Station;
import double_p.ptravel.module.station.service.IStationService;

@Service
public class StationService implements IStationService {
    private final IStationRepository stationRepository;

    public StationService(IStationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Override
    public Station findById(Long stationId) {
        return stationRepository.findById(stationId).orElse(null);
    }

    @Override
    public Station create(CreateStationDto dto) {
        Station station = new Station();
        station.setAddress(dto.getAddress());
        station.setCity(dto.getCity());
        station.setCode(dto.getCode());
        station.setName(dto.getName());

        return stationRepository.save(station);
    }

    @Override
    public String delete(Long stationId) {
        stationRepository.deleteById(stationId);
        return "Station with id " + stationId + " has been deleted";
    }

    @Override
    public Page<Station> findAll(Pageable pageable) {
        return stationRepository.findAll(pageable);
    }

    @Override
    public Page<Station> search(SearchStationDto dto, Pageable pageable) {
        return stationRepository.search(dto, pageable);
    }

    @Override
    public Station update(Long stationId, UpdateStationDto dto) {
        Station station = findById(stationId);
        if (station != null) {
            station.setAddress(dto.getAddress());
            station.setCity(dto.getCity());
            station.setCode(dto.getCode());
            station.setName(dto.getName());
        }

        return null;
    }

    @Override
    public Station findByName(String name) {
        return stationRepository.findByName(name).orElse(null);
    }
}
