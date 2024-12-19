package double_p.ptravel.module.route.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import double_p.ptravel.module.route.dto.CreateRouteDto;
import double_p.ptravel.module.route.dto.SearchRouteDto;
import double_p.ptravel.module.route.dto.UpdateRouteDto;
import double_p.ptravel.module.route.entity.Route;
import double_p.ptravel.module.route.repository.IRouteRepository;
import double_p.ptravel.module.route.service.IRouteService;
import double_p.ptravel.module.station.entity.Station;
import double_p.ptravel.module.station.service.IStationService;

@Service
public class RouteService implements IRouteService{
    private final IRouteRepository routeRepository;
    private final IStationService stationService;

    public RouteService(IRouteRepository routeRepository, IStationService stationService) {
        this.routeRepository = routeRepository;
        this.stationService = stationService;
    }

    @Override
    public Route findById(Long routeId) {
        return routeRepository.findById(routeId).orElse(null);
    }

    @Override
    public Page<Route> findAll(Pageable pageable) {
        return routeRepository.findAll(pageable);
    }

    @Override
    public String delete(Long routeId) {
        routeRepository.deleteById(routeId);
        return "Route with id " + routeId + " has been deleted";
    }

    @Override
    public Page<Route> search(SearchRouteDto dto, Pageable pageable) {
        return routeRepository.search(dto, pageable);
    }

    @Override
    public Route update(Long routeId, UpdateRouteDto dto) {
        Route route = findById(routeId);
        if(route!= null) {
            Station originStation = stationService.findByName(dto.getOriginStationName());
            Station destinationStation = stationService.findByName(dto.getDestinationStationName());
            if(originStation!=null && destinationStation!=null) {
                route.setOriginStation(originStation);
                route.setDestinationStation(destinationStation);
                route.setDistance(dto.getDistance());
                route.setDuration(dto.getDuration());
                
                return routeRepository.save(route);
            }
        }
        return null;
    }

    @Override
    public Route create(CreateRouteDto dto) {
        Route route = new Route();
        Station originStation = stationService.findByName(dto.getOriginStationName());
        Station destinationStation = stationService.findByName(dto.getDestinationStationName());
        if(originStation!=null && destinationStation!=null) {
            route.setOriginStation(originStation);
            route.setDestinationStation(destinationStation);
            route.setDistance(dto.getDistance());
            route.setDuration(dto.getDuration());
            
            return routeRepository.save(route);
        }
        return routeRepository.save(route);
    }
}
