package double_p.ptravel.module.user.repository;

import double_p.ptravel.module.user.dto.SearchUserDto;
import double_p.ptravel.module.user.entity.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u " +
    "WHERE" +
    "(:#{#dto.email} IS NULL OR u.email = :#{#dto.email}%) " +
    "OR (:#{#dto.phone} IS NULL OR u.phone = %:#{#dto.phone}%)")
    Page<User> searchUser(@Param("dto") SearchUserDto dto, Pageable pageable);
}
