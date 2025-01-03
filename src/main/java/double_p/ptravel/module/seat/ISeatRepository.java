package double_p.ptravel.module.seat;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import double_p.ptravel.module.seat.dto.SearchSeatDto;
import double_p.ptravel.module.seat.entity.Seat;

@Repository
public interface ISeatRepository extends JpaRepository<Seat, Long> {
    @Query("SELECT s FROM Seat s JOIN Train t ON s.train.id = t.id WHERE " +
            "(:#{#dto.status} IS NULL OR s.status = :#{#dto.status}) " +
            "AND (:#{#dto.trainName} IS NULL OR t.name = :#{#dto.trainName})")
    Page<Seat> search(SearchSeatDto dto, Pageable pageable);
}
