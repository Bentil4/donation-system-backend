package donation.donationsystem.controllers;

import donation.donationsystem.entity.Donation;
import donation.donationsystem.repo.DonationRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/donations")
public class DonationController {

    private final DonationRepo donationRepo;

//    creating/making a donation
    @PostMapping
    public Donation createDonation(@RequestBody Donation donation) {
        return donationRepo.save(donation);
    };

//    filter donation by event id
    @GetMapping("/{eventId}")
    @PreAuthorize("isAuthenticated()")
    public List<Donation> findByEventId(@PathVariable String eventId) {
        return donationRepo.findByEventId(eventId);
    }
}
