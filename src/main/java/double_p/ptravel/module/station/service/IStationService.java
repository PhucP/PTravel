package double_p.ptravel.module.station.service;

import java.util.List;

import double_p.ptravel.module.station.dto.CreateStationDto;
import double_p.ptravel.module.station.dto.SearchStationDto;
import double_p.ptravel.module.station.dto.UpdateStationDto;
import double_p.ptravel.module.station.entity.Station;

public interface IStationService {
    public Station findById(Long stationId);
    
    public Station create(CreateStationDto dto);

    public String delete(Long stationId);
    
    public List<Station> getAll();

    public List<Station> search(SearchStationDto dto);

    public Station update(Long stationId, UpdateStationDto dto);
}
