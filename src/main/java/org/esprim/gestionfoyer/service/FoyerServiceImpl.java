package org.esprim.gestionfoyer.service;
import lombok.AllArgsConstructor;
import org.esprim.gestionfoyer.entities.Foyer;
import org.esprim.gestionfoyer.repositories.FoyerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class FoyerServiceImpl implements IFoyerService {

    FoyerRepository foyerRepository;

    @Override
    public List<Foyer> retrieveAllFoyer() {
        return foyerRepository.findAll();
    }
    @Override
    public Foyer retrieveFoyer(Long FoyerId) {
        return foyerRepository.findById(FoyerId).get();
    }
    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }
    @Override
    public void removeFoyer(Long FoyerId) {
        foyerRepository.deleteById(FoyerId);
    }
    @Override
    public Foyer modifyFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }
}
