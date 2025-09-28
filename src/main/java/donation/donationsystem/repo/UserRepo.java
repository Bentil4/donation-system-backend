package donation.donationsystem.repo;

import donation.donationsystem.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepo extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);

    String username(String username);
}
