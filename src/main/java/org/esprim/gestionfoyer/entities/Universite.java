package org.esprim.gestionfoyer.entities;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Universite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUniversite;
    @Column(nullable = false, length = 100)
    private String nomUniversite;
    @Column(nullable = false, length = 100)
    private String adresse;
    @OneToOne(mappedBy ="universite",optional = false)
    private Foyer foyer  ;

}
