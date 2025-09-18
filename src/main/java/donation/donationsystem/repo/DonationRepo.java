package donation.donationsystem.repo;

import donation.donationsystem.entity.Donation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DonationRepo extends MongoRepository<Donation, String> {
    List<Donation> findByEventId(String eventId);
}
