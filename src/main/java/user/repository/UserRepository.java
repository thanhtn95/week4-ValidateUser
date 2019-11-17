package user.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import user.model.User;

public interface UserRepository extends PagingAndSortingRepository<User,Integer> {
}
