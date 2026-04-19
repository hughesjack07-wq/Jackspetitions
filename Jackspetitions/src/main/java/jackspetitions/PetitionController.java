package jackspetitions;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PetitionController {

    // In-memory list to store petitions
    private List<Petition> petitions = new ArrayList<>();
    private int nextId = 1;

    public PetitionController() {
        // Sample data for the start
        petitions.add(new Petition(nextId++, "Save the Local Park", "We need to stop the construction of the motorway."));
        petitions.add(new Petition(nextId++, "Better Public Transport", "More buses needed for the countryside."));
    }

    // 1. View All Petitions
    @GetMapping("/")
    public String viewAllPetitions(Model model) {
        model.addAttribute("petitions", petitions);
        return "view-all";
    }

    // 2. Create Petition (Show Form)
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        return "create-petition";
    }

    // 2. Create Petition (Handle Submission)
    @PostMapping("/create")
    public String createPetition(@RequestParam String title, @RequestParam String description) {
        petitions.add(new Petition(nextId++, title, description));
        return "redirect:/";
    }

    // 3. Search Petitions
    @GetMapping("/search")
    public String searchPetitions(@RequestParam(required = false) String query, Model model) {
        List<Petition> results = petitions;
        if (query != null && !query.isEmpty()) {
            results = petitions.stream()
                    .filter(p -> p.getTitle().toLowerCase().contains(query.toLowerCase()))
                    .collect(Collectors.toList());
        }
        model.addAttribute("results", results);
        return "search-results";
    }

    // 4. View and Sign Petition
    @GetMapping("/view/{id}")
    public String viewPetition(@PathVariable int id, Model model) {
        Petition petition = petitions.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
        model.addAttribute("petition", petition);
        return "view-petition";
    }

    @PostMapping("/sign/{id}")
    public String signPetition(@PathVariable int id, @RequestParam String name) {
        petitions.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .ifPresent(p -> p.addSignature(name));
        return "redirect:/view/" + id;
    }
}