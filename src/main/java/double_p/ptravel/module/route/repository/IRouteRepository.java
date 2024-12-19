package double_p.ptravel.module.route.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import double_p.ptravel.module.route.dto.SearchRouteDto;
import double_p.ptravel.module.route.entity.Route;

public interface IRouteRepository extends JpaRepository<Route, Long>{
    @Query("SELECT r FROM Route r WHERE " +
    "(:#{#dto.originStationName} IS NULL OR r.originStation.name LIKE %:#{#dto.originStationName}%) " +
    "AND (:#{#dto.destinationStationName} IS NULL OR r.destinationStation.name LIKE %:#{#dto.destinationStationName}%)")
    Page<Route> search(SearchRouteDto dto, Pageable pageable);
}
