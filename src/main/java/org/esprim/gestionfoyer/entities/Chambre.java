package org.esprim.gestionfoyer.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
