package org.esprim.gestionfoyer.repositories;

import java.util.List;

import org.esprim.gestionfoyer.entities.Chambre;
import org.esprim.gestionfoyer.entities.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre,Long> {
    public List<Chambre>   findAllByNumeroChambreIn(List<Long> numChambre);

    @Query("SELECT c FROM Chambre c WHERE c.bloc.foyer.universite.nomUniversite = :nomUniversite")
    public List<Chambre> findByBlocFoyerUniversiteNomUniversite(@Param("nomUniversite") String nomUniversite);

    public List<Chambre> findByBlocIdAndTipoChambre(long idBloc, TypeChambre typeC);

    @Query("SELECT c FROM Chambre c WHERE c.bloc.id = :idBloc AND c.tipoChambre = :typeC")
    public List<Chambre> findByBlocIdAndTipoChambreJPQL(@Param("idBloc") long idBloc, @Param("typeC") TypeChambre typeC);
}
