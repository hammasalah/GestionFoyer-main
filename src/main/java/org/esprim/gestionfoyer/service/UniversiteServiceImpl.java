package org.esprim.gestionfoyer.service;
import org.esprim.gestionfoyer.entities.Foyer;
import org.esprim.gestionfoyer.entities.Universite;
import org.esprim.gestionfoyer.repositories.FoyerRepository;
import org.esprim.gestionfoyer.repositories.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UniversiteServiceImpl implements IUniversiteService {

    @Autowired
    UniversiteRepository universiteRepository;
    @Autowired
    FoyerRepository foyerRepository;

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

    @Override
    public Universite affecterFoyerAUnUniversite(Long idFoyer, String nomUniversite) {
        Foyer foyer =  foyerRepository.findById(idFoyer).orElseThrow( ()-> new RuntimeException("Foyer n'existe pas : " + idFoyer));
        Universite universite =
                universiteRepository.findByNomUniversite(nomUniversite)
                        .orElseThrow( ()-> new RuntimeException("Universite n'existe pas : " + nomUniversite));
        if (foyer.getUniversite() != null || universite.getFoyer() != null) {
            throw new RuntimeException("l'assosiation existe deja pour ce foyer " + "ou cette universite");
        }

        universite.setFoyer(foyer);
        foyer.setUniversite(universite);
        universiteRepository.save(universite);
        foyerRepository.save(foyer);
        return universite;
    }

    @Override
    public Universite deaffecterFoyerAUnUniversite(Long idUniversite) {

        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new RuntimeException("Université n'existe pas : " + idUniversite));

        Foyer foyer = universite.getFoyer();
        if (foyer == null) {
            throw new RuntimeException("Cette université n'est associée à aucun foyer.");
        }

        universite.setFoyer(null);
        foyer.setUniversite(null);

        universiteRepository.save(universite);
        foyerRepository.save(foyer);

        return universite;
    }


}
