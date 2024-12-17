package double_p.ptravel.module.train.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import double_p.ptravel.module.train.dto.SearchTrainDto;
import double_p.ptravel.module.train.entity.Train;

import java.util.List;


public interface ITrainRepository extends JpaRepository<Train, Long>{
    @Query (
    "SELECT t FROM Train t " +
    "WHERE (:#{#dto.name} IS NULL OR t.name LIKE %:#{#dto.name}%) " + 
    "AND (:#{#dto.status} IS NULL OR t.status = :#{#dto.status})")
    List<Train> searchTrain(SearchTrainDto dto);
}
