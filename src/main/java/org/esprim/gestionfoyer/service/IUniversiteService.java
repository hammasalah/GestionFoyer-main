package org.esprim.gestionfoyer.service;
import org.esprim.gestionfoyer.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    public List<Universite> retrieveAllUniversite();
    public Universite retrieveUniversite(Long UniversiteId);
    public Universite addUniversite(Universite u);
    public void removeUniversite(Long UniversiteId);
    public Universite modifyUniversite(Universite universite);
    Universite affecterFoyerAUnUniversite(Long idFoyer,String nomUniversite);
    public Universite deaffecterFoyerAUnUniversite(Long idFoyer);
}

