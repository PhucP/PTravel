package double_p.ptravel.module.route.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import double_p.ptravel.module.route.dto.CreateRouteDto;
import double_p.ptravel.module.route.dto.SearchRouteDto;
import double_p.ptravel.module.route.dto.UpdateRouteDto;
import double_p.ptravel.module.route.entity.Route;
import double_p.ptravel.module.route.service.IRouteService;

@RestController
@RequestMapping("/route")
public class RouteController {
    private final IRouteService routeService;

    public RouteController(IRouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/getRoute/{routeId}")
    public Route findById(@PathVariable Long routeId) {
        return routeService.findById(routeId);
    }

    @PostMapping("/create")
    public Route create(@RequestBody CreateRouteDto dto) {
        return routeService.create(dto);
    }

    @PatchMapping("/update/{routeId}")
    public Route update(@PathVariable Long routeId, @RequestBody UpdateRouteDto dto) {
        return routeService.update(routeId, dto);
    }

    @DeleteMapping("/delete/{rotueId}")
    public String delete(@PathVariable Long rotueId) {
        return routeService.delete(rotueId);
    }

    @GetMapping("/all")
    public Page<Route> findAll(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "desc") String direction) {
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(sortDirection, sort);
        Pageable pageable = PageRequest.of(page, size, sortBy);
        return routeService.findAll(pageable);
    }

    @PostMapping("/serach")
    public Page<Route> search(
            @RequestBody SearchRouteDto dto,
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "desc") String direction) {
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(sortDirection, sort);
        Pageable pageable = PageRequest.of(page, size, sortBy);
        return routeService.search(dto, pageable);
    }
}
