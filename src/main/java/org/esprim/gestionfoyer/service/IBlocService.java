package org.esprim.gestionfoyer.service;
import org.esprim.gestionfoyer.entities.Bloc;

import java.util.List;

public interface IBlocService {
    public List<Bloc> retrieveAllBloc();
    public Bloc retrieveBloc(Long BlocId);
    public Bloc addBloc(Bloc b);
    public void removeBloc(Long BlocId);
    public Bloc modifyBloc(Bloc bloc);
}
