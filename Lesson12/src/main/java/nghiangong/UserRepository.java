package nghiangong;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByAtk(int atk);

    List<User> findAllByAgiBetween(int start, int end);

    @Query("SELECT u FROM User u WHERE u.def = ?1")
    User findUserByDefQuery(Integer def);

    List<User> findAllByAgiGreaterThan(int agiThreshold);
}
