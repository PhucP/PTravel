package double_p.ptravel.module.station.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import double_p.ptravel.module.station.dto.CreateStationDto;
import double_p.ptravel.module.station.dto.SearchStationDto;
import double_p.ptravel.module.station.dto.UpdateStationDto;
import double_p.ptravel.module.station.entity.Station;

public interface IStationService {
    public Station findById(Long stationId);
    
    public Station create(CreateStationDto dto);

    public String delete(Long stationId);
    
    public Page<Station> findAll(Pageable pageable);

    public Page<Station> search(SearchStationDto dto, Pageable pageable);

    public Station update(Long stationId, UpdateStationDto dto);

    public Station findByName(String name);
}
