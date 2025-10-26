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
public class Chambre implements Serializable {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idChambre;
    @Column(nullable=false)
    private Long numeroChambre;
    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private TypeChambre tipoChambre;
    @ManyToOne
    @JoinColumn(name = "bloc_id")
    private Bloc bloc ;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)

    private List<Reservation> reservations = new ArrayList<>();

}
