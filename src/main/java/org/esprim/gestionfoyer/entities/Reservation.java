package org.esprim.gestionfoyer.entities;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reservation implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;
    private LocalDate anneeUniversitaire;
    private Boolean estValide;

    @ManyToMany
    @JoinTable (name="reservation_etudiant" , joinColumns = @JoinColumn(name = "id eservation" ),inverseJoinColumns = @JoinColumn(name = "etudiant_id"))
    private List<Etudiant> etudiants =new ArrayList<>();
}
