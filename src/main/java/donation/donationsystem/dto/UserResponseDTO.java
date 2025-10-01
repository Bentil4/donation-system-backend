package donation.donationsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@AllArgsConstructor
public class UserResponseDTO {
    private String id;
    private String username;
    private String role;

    public UserResponseDTO() {

    }
}



