package source.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import source.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    Iterable<User> findAllByUsername(String username);

    User findUserByUsername (String username);
}
