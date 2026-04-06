package fintanspetitions.ct5209.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import fintanspetitions.ct5209.model.Petition;

@Repository
public class PetitionRepository {
    public final List<Petition> petitions = new ArrayList<>();

    public PetitionRepository() {
        petitions.add(new Petition("New Running Track", "The athletic club is looking to purchase unused land beside the existing clubhouse for it's new running track. Members have been pursuing this for two years and would like to provide another amenity for the people of Celbridge", "Kevin McBride", "Sports"));
        petitions.add(new Petition("Cleanup our Waterways", "The canal has been covered in weeds every summer for years making it impossible for kayaks and canoes to use. Bring back the dredger during the summer to clean up a 5km stretch when the canal becomes fully overgrown.", "Oisin Duffy", "Environment"));
        petitions.add(new Petition("Bring back BYOB Bowling", "Allow patrons of the local bowling facility to bring their own beer due to a lack of variety on offer.", "Mike O'Toole", "Social"));
        petitions.add(new Petition("Housing Supply", "Petition to get local council to purchase unused public land and build affordable homes.", "Alan Murphy", "Politics"));
    }

    public List<Petition> findAll() { return petitions; }
    
    public void save(Petition petition) { petitions.add(petition); } 

    public Optional<Petition> findById(UUID id) {
        return petitions.stream()
                .filter(p -> p.getId().equals(id)).findFirst();
    }
}
