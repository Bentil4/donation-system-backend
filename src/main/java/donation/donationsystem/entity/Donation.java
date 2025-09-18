package donation.donationsystem.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Document(collation = "donations")
public class Donation {
    @Id
    private String id;
    private String eventId;
    private String donorName;
    private String donationType;   // CASH, GOODS, SERVICE
    private String donationTo;
    private Double amount;
    private String description;
    private String recordedBy;
    private Instant recordAt  = Instant.now();
}
