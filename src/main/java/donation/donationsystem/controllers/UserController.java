package donation.donationsystem.controllers;

import donation.donationsystem.dto.ApiResponseDTO;
import donation.donationsystem.dto.UserResponseDTO;
import donation.donationsystem.entity.User;
import donation.donationsystem.repo.UserRepo;
import donation.donationsystem.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private final UserRepo userRepo;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<ApiResponseDTO<List<UserResponseDTO>>> getAllUsers() {
        List<UserResponseDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(new ApiResponseDTO<>(true, "Users retrieved successfully", users));
    }

    @GetMapping("/{username}")
    public ResponseEntity<ApiResponseDTO<UserResponseDTO>> getUserByUsername(@PathVariable String username) {
        UserResponseDTO user = userService.getUserByUsername(username);
        return ResponseEntity.ok(new ApiResponseDTO<>(true, "User found", user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<String>> deleteUser (@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(new ApiResponseDTO<>(true, "User deleted successfully", null));
    }
}
