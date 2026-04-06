package fintanspetitions.ct5209.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import fintanspetitions.ct5209.model.Petition;
import fintanspetitions.ct5209.service.PetitionService;

@Controller
public class PetitionController {
    private final PetitionService petitionService;

    public PetitionController(PetitionService petitionService) {
        this.petitionService = petitionService;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("petitions", petitionService.findAllPetitions());
        return "home";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("petition", new Petition());
        return "create";
    }

    @PostMapping("/create")
    public String submitCreateForm(@ModelAttribute("petition") Petition petition) {
        petitionService.save(petition);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(
        @RequestParam(required = false) String title,
        @RequestParam(required = false) String author,
        Model model) {

            List<Petition> petitionResults = petitionService.findAllPetitions();

            if (title != null && !title.isEmpty()) {
                petitionResults = petitionResults.stream()
                        .filter(p -> p.getTitle().toLowerCase().contains(title.toLowerCase())).toList();
            }

            if (author != null && !author.isEmpty()) {
                petitionResults = petitionResults.stream()
                        .filter(p -> p.getAuthor().toLowerCase().contains(author.toLowerCase())).toList();
            }

            model.addAttribute("results", petitionResults);
            model.addAttribute("author", author);
            model.addAttribute("title", title);

            return "search";
        }

    @GetMapping("/petition/{id}")
    public String viewPetition(@PathVariable UUID id, Model model) {
        Optional<Petition> petitionOpt = petitionService.findById(id);

        if(petitionOpt.isPresent()) {
            model.addAttribute("petition", petitionOpt.get());
            return "view-petition";
        }

        return "redirect:/";
    }
}
