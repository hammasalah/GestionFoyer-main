package org.esprim.gestionfoyer.service;
import lombok.AllArgsConstructor;
import org.esprim.gestionfoyer.entities.Etudiant;
import org.esprim.gestionfoyer.repositories.EtudiantRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService {
    EtudiantRepository etudiantRepository;


    @Override
    public List<Etudiant> retrieveAllEtudiant() {
        return etudiantRepository.findAll();
    }
    @Override
    public Etudiant retrieveEtudiant(Long EtudiantId) {
        return etudiantRepository.findById(EtudiantId).get();
    }
    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }
    @Override
    public void removeEtudiant(Long EtudiantId) {
        etudiantRepository.deleteById(EtudiantId);
    }
    @Override
    public Etudiant modifyEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }
}
