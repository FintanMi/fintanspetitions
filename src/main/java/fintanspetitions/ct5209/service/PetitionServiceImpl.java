package fintanspetitions.ct5209.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import fintanspetitions.ct5209.domain.PetitionRepository;
import fintanspetitions.ct5209.model.Petition;

@Service
public class PetitionServiceImpl implements PetitionService {
    private final PetitionRepository repository;

    public PetitionServiceImpl(PetitionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Petition> findAllPetitions() {
        return repository.findAll();
    }

    @Override
    public Petition save(Petition petition) {
        repository.save(petition);
        return petition;
    }

    @Override
    public Optional<Petition> findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<Petition> findByCategory(String category) {
        return repository.findAll().stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    @Override
    public List<Petition> searchByTitle(String search) {
        return repository.findAll().stream()
                .filter(p -> p.getTitle().toLowerCase().contains(search.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        repository.findAll().removeIf(p -> p.getId().equals(id));
    }

    @Override
    public List<Petition> findByAuthor(String author) {
        return repository.findAll().stream()
                .filter(p -> p.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }
}
