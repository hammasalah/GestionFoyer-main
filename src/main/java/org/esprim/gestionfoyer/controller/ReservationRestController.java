package org.esprim.gestionfoyer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.esprim.gestionfoyer.entities.Reservation;
import org.esprim.gestionfoyer.service.IReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gestion Reservation")
@AllArgsConstructor
@RestController
@RequestMapping("/Reservation")
public class ReservationRestController {

    IReservationService reservationService;

    //http://localhost:8083/gestionfoyer/retrieve-all-reservations
    @Operation(description = "récupérer toutes les reservations de la base de données")
    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> retrieveAllReservations() {
        List<Reservation> reservationList = reservationService.retrieveAllReservation();
        return reservationList;
    }

    //http://localhost:8083/gestionfoyer/retrieve-reservations/4
    @Operation(description = "récupérer une reservation de la base de données")
    @GetMapping("/retrive-reservation/{reservation-id}")
    public Reservation retrieveReservation(@PathVariable ("reservation-id") Long rId /*,@PathVariable another variable*/){
        Reservation reservation= reservationService.retrieveReservation(rId);
        return reservation;
    }

    //http://localhost:8083/gestionfoyer/reservation/add-reservation
    @Operation(description = "ajouter une reservation de la base de données")
    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation r) {
        Reservation reservation = reservationService.addReservation(r);
        return reservation;
    }

    //http://localhost:8083/gestionfoyer/remove-reservations/2
    @Operation(description = "supprimer une reservation de la base de données")
    @DeleteMapping("/remove-reservation/{reservation-id}")
    public void RemoveReservation(@PathVariable ("reservation-id") Long rId /*,@PathVariable another variable*/){
        reservationService.removeReservation(rId);
    }

    //http://localhost:8083/gestionfoyer/retrieve-all-reservations
    @Operation(description = "modifier une reservation de la base de données")
    @PutMapping("/modify-reservation")
    public Reservation modifyReservation(@RequestBody Reservation r) {
        Reservation reservation = reservationService.modifyReservation(r);
        return reservation;
    }
}
