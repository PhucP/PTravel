package double_p.ptravel.module.train;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import double_p.ptravel.module.train.dto.SearchTrainDto;
import double_p.ptravel.module.train.entity.Train;

@Repository
public interface ITrainRepository extends JpaRepository<Train, Long> {
    @Query("SELECT t FROM Train t " +
            "WHERE (:#{#dto.name} IS NULL OR t.name LIKE %:#{#dto.name}%) " +
            "AND (:#{#dto.status} IS NULL OR t.status = :#{#dto.status})")
    Page<Train> searchTrain(SearchTrainDto dto, Pageable pageable);
}
