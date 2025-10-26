package org.esprim.gestionfoyer.service;
import org.esprim.gestionfoyer.entities.Universite;
import org.esprim.gestionfoyer.repositories.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UniversiteServiceImpl implements IUniversiteService {

    @Autowired
    UniversiteRepository universiteRepository;

    @Override
    public List<Universite> retrieveAllUniversite() {
        return universiteRepository.findAll();
    }
    @Override
    public Universite retrieveUniversite(Long UniversiteId) {
        return universiteRepository.findById(UniversiteId).get();
    }
    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }
    @Override
    public void removeUniversite(Long UniversiteId) {
        universiteRepository.deleteById(UniversiteId);
    }
    @Override
    public Universite modifyUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }


}
