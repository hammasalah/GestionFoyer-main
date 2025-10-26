package org.esprim.gestionfoyer.service;
import org.esprim.gestionfoyer.entities.Reservation;
import org.esprim.gestionfoyer.repositories.ResevationRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReservationServiceImpl implements IReservationService {

    @Autowired
     ResevationRespository reservationRespository;

    @Override
    public List<Reservation> retrieveAllReservation() {
        return reservationRespository.findAll();
    }
    @Override
    public Reservation retrieveReservation(Long ReservationId) {
        return reservationRespository.findById(ReservationId).get();
    }
    @Override
    public Reservation addReservation(Reservation r) {
        return reservationRespository.save(r);
    }
    @Override
    public void removeReservation(Long chambreId) {
        reservationRespository.deleteById(chambreId);
    }
    @Override
    public Reservation modifyReservation(Reservation chambre) {
        return reservationRespository.save(chambre);
    }
}
