package org.esprim.gestionfoyer.service;
import org.esprim.gestionfoyer.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    public List<Etudiant> retrieveAllEtudiant();
    public Etudiant retrieveEtudiant(Long EtudiantId);
    public Etudiant addEtudiant(Etudiant e);
    public void removeEtudiant(Long EtudiantId);
    public Etudiant modifyEtudiant(Etudiant etudiant);
}
