package double_p.ptravel.module.station;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import double_p.ptravel.module.station.dto.SearchStationDto;
import double_p.ptravel.module.station.entity.Station;

@Repository
public interface IStationRepository extends JpaRepository<Station, Long> {
    @Query("SELECT s FROM Station s WHERE " +
            ":#{#dto.name} IS NULL OR s.name LIKE %:#{dto.name}%")
    Page<Station> search(SearchStationDto dto, Pageable pageable);

    Optional<Station> findByName(String name);
}
