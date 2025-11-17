//service_impl
package org.esprim.gestionfoyer.service;

import lombok.AllArgsConstructor;
import org.esprim.gestionfoyer.entities.Bloc;
import org.esprim.gestionfoyer.entities.Chambre;
import org.esprim.gestionfoyer.repositories.BlocRepository;
import org.esprim.gestionfoyer.repositories.ChambreRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class BlocServiceImpl implements IBlocService {

    BlocRepository blocRepository;
    ChambreRepository chambreRepository;

    @Override
    public List<Bloc> retrieveAllBloc() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc retrieveBloc(Long BlocId) {
        return blocRepository.findById(BlocId).get();
    }

    @Override
    public Bloc addBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public void removeBloc(Long BlocId) {
        blocRepository.deleteById(BlocId);
    }

    @Override
    public Bloc modifyBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc affecterChambreABloc(List<Long> numChambre, Long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).
                orElseThrow(() -> new RuntimeException("Bloc n'existe pas : " + idBloc));
        List<Chambre> chambres = chambreRepository.findAllByNumeroChambreIn(numChambre);
        if (chambres.size() != numChambre.size())
            throw new RuntimeException("une ou plusieurs chambre sont introuvable ");
        for (Chambre chambre : chambres) {
            if (chambre.getBloc() != null &&
                    chambre.getBloc().getId() != idBloc) {

                throw new RuntimeException(
                        "La chambre numéro " + chambre.getNumeroChambre() +
                                " est déjà associée à ce bloc."
                );
            }
        }
        for (Chambre chambre : chambres) {
            chambre.setBloc(bloc);
        }
        chambreRepository.saveAll(chambres);

        return bloc;
    }

}
