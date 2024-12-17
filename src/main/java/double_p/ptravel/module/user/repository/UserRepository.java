package double_p.ptravel.module.user.repository;

import double_p.ptravel.module.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long userId);
    User save(User user);
}
