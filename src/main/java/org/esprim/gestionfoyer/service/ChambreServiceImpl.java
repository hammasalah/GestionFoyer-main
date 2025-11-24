package org.esprim.gestionfoyer.service;


import java.util.List;

import org.esprim.gestionfoyer.entities.Chambre;
import org.esprim.gestionfoyer.entities.TypeChambre;
import org.esprim.gestionfoyer.repositories.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
// @AllArgsConstructor  here or @Autowired
public class ChambreServiceImpl implements IChambreService {

    @Autowired
    ChambreRepository chambreRepository;

    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambreRepository.findAll();
    }
    @Override
    public Chambre retrieveChambre(Long chambreId) {
        return chambreRepository.findById(chambreId).get();
    }
    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }
    @Override
    public void removeChambre(Long chambreId) {
        chambreRepository.deleteById(chambreId);
    }
    @Override
    public Chambre modifyChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public List<Chambre> getChambresParNomUniversite(String nomUniversite) {
        return chambreRepository.findByBlocFoyerUniversiteNomUniversite(nomUniversite);
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC) {
        return chambreRepository.findByBlocIdAndTipoChambre(idBloc, typeC);
    }

    @Override
    public List<Chambre> getChambresParBlocEtTypeJPQL(long idBloc, TypeChambre typeC) {
        return chambreRepository.findByBlocIdAndTipoChambreJPQL(idBloc, typeC);
    }
}
