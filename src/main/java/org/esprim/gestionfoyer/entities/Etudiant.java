package org.esprim.gestionfoyer.entities;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Etudiant implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEdutiant;

    @Column(nullable = false,name ="nom")
    private String nomEt;
    @Column(nullable = false ,name = "prenom")
    private String prenomEt;
    @Column(unique = true)
    private Long cin;
    @Column(nullable = false , length = 100)
    private String ecole;
    @DateTimeFormat(style = "dd/mm/yyyy")
    private LocalDate dateNaissance;

    @ManyToMany
    private List<Reservation> reservations;
}
