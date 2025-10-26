package org.esprim.gestionfoyer.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bloc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    @Column(nullable = false , length = 20 ,name = "nome_du_bloc")
    private String nomBloc;
    @Column(nullable = false)
    private Long capaciteFoyer;

    @ManyToOne
    @JoinColumn(name="foyer_id")
    private Foyer foyer;
    @OneToMany (mappedBy = "bloc")
    private List<Chambre> chambres ;

}

