package fintanspetitions.ct5209.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import fintanspetitions.ct5209.model.Petition;

public interface PetitionService {
    Petition save(Petition petition);
    Optional<Petition> findById(UUID id);
    List<Petition> findAllPetitions();
    void deleteById(UUID id);
    List<Petition> findByAuthor(String author);
    List<Petition> findByCategory(String category);
    List<Petition> searchByTitle(String search);
}
