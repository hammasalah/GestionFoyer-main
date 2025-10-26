package org.esprim.gestionfoyer.service;
import org.esprim.gestionfoyer.entities.Foyer;

import java.util.List;

public interface IFoyerService {
    public List<Foyer> retrieveAllFoyer();
    public Foyer retrieveFoyer(Long FoyerId);
    public Foyer addFoyer(Foyer f);
    public void removeFoyer(Long FoyerId);
    public Foyer modifyFoyer(Foyer foyer);
}
