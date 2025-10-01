package donation.donationsystem.service;

import donation.donationsystem.dto.UserResponseDTO;
import donation.donationsystem.entity.User;
import donation.donationsystem.exception.ResourceNotFoundException;
import donation.donationsystem.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
        );
    }


//    Get all users
    public List<UserResponseDTO> getAllUsers() {
        return userRepo.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

//    Get user by first name
    public UserResponseDTO getUserByUsername(String username) {
        User user  = userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        return mapToDto(user);
    }

//    Delete user by id
    public void deleteUser (String id) {
        if(!userRepo.existsById(id)) {
            throw new ResourceNotFoundException("User not found: " + id);
        }
        userRepo.deleteById(id);
    }

    private UserResponseDTO mapToDto(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setRole(user.getRole());
        return dto;
    }
}
