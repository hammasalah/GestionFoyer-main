package org.esprim.gestionfoyer.repositories;

import org.esprim.gestionfoyer.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResevationRespository extends JpaRepository <Reservation,Long> {
}
