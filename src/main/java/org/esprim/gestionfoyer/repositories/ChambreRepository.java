package org.esprim.gestionfoyer.repositories;

import org.esprim.gestionfoyer.entities.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre,Long> {
    public List<Chambre>   findAllByNumeroChambreIn(List<Long> numChambre);
}
