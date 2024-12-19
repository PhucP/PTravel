package double_p.ptravel.module.route.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import double_p.ptravel.module.route.dto.CreateRouteDto;
import double_p.ptravel.module.route.dto.SearchRouteDto;
import double_p.ptravel.module.route.dto.UpdateRouteDto;
import double_p.ptravel.module.route.entity.Route;

public interface IRouteService {
    public Route findById(Long routeId);

    public Page<Route> findAll(Pageable pageable);

    public String delete(Long routeId);

    public Page<Route> search(SearchRouteDto dto, Pageable pageable);

    public Route update(Long routeId, UpdateRouteDto dto);

    public Route create(CreateRouteDto dto);
}
