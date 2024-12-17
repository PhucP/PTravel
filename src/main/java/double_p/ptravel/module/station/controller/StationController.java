package double_p.ptravel.module.station.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import double_p.ptravel.module.station.dto.CreateStationDto;
import double_p.ptravel.module.station.dto.SearchStationDto;
import double_p.ptravel.module.station.dto.UpdateStationDto;
import double_p.ptravel.module.station.entity.Station;
import double_p.ptravel.module.station.service.IStationService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/station")
public class StationController {
    private final IStationService stationService;

    public StationController(IStationService stationService) {
        this.stationService = stationService;
    }

    @GetMapping("/{stationId}")
    public Station findById (@PathVariable Long stationId) {
        return stationService.findById(stationId);
    }
    
    @PostMapping("/create")
    public Station create(@RequestBody CreateStationDto dto) {
        return stationService.create(dto);
    }

    @DeleteMapping("/delete/{stationId}")
    public String delete(@PathVariable Long stationId) {
        return stationService.delete(stationId);
    }

    @PatchMapping("/update/{stationId}")
    public Station update(@PathVariable Long stationId, @RequestBody UpdateStationDto dto) {
        return stationService.update(stationId, dto);
    }
    
    @GetMapping("/search")
    public List<Station> search(@RequestBody SearchStationDto dto) {
        return stationService.search(dto);
    }
}
