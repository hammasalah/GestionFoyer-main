package org.esprim.gestionfoyer.service;

import lombok.AllArgsConstructor;
import org.esprim.gestionfoyer.entities.Bloc;
import org.esprim.gestionfoyer.repositories.BlocRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class BlocServiceImpl implements IBlocService {

    BlocRepository blocRepository;

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

}
