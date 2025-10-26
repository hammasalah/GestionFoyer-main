package org.esprim.gestionfoyer.entities;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Foyer implements Serializable {
    @Id
    private Long idFoyer;
    @Column(nullable = false, name="nom")
    private String nomFoyer;
    @Column (nullable = false , name ="capacite")
    private String capaciteFoyer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foyer")

    private List<Bloc> blocs;
    @OneToOne ()
    @JoinColumn(name="universite_id")
    private Universite universite ;


}
