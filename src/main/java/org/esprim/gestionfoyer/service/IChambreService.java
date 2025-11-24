package org.esprim.gestionfoyer.service;
import java.util.List;

import org.esprim.gestionfoyer.entities.Chambre;
import org.esprim.gestionfoyer.entities.TypeChambre;

public interface IChambreService {
    public List<Chambre> retrieveAllChambres();
    public Chambre retrieveChambre(Long chambreId);
    public Chambre addChambre(Chambre c);
    public void removeChambre(Long chambreId);
    public Chambre modifyChambre(Chambre chambre);
    public List<Chambre> getChambresParNomUniversite( String nomUniversite) ;
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC);
    public List<Chambre> getChambresParBlocEtTypeJPQL(long idBloc, TypeChambre typeC);
}





