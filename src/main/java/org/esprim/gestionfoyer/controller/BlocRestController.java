package org.esprim.gestionfoyer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.esprim.gestionfoyer.entities.Bloc;
import org.esprim.gestionfoyer.service.IBlocService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gestion Bloc")
@AllArgsConstructor
@RestController
@RequestMapping("/Bloc")
public class BlocRestController {

    IBlocService blocService;
    //http://localhost:8083/gestionfoyer/retrieve-all-cBlocs
    @Operation(description = "récupérer toutes les blocs de la base de données")
    @GetMapping("/retrieve-all-blocs")
    public List<Bloc> retrieveAllBlocs() {
        List<Bloc> blocList = blocService.retrieveAllBloc();
        return blocList;
    }

    //http://localhost:8083/gestionfoyer/retrieve-blocs/3
    @Operation(description = "récupérer un bloc de la base de données")
    @GetMapping("/retrive-bloc/{bloc-id}")
    public Bloc retrieveBloc(@PathVariable ("bloc-id") Long bId /*,@PathVariable another variable*/){
        Bloc bloc= blocService.retrieveBloc(bId);
        return bloc;
    }

    //http://localhost:8083/gestionfoyer/bloc/add-bloc
    @Operation(description = "ajouter un bloc de la base de données")
    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc b) {
        Bloc bloc = blocService.addBloc(b);
        return bloc;
    }

    //http://localhost:8083/gestionfoyer/remove-blocs/1
    @Operation(description = "supprimer un bloc de la base de données")
    @DeleteMapping("/remove-bloc/{bloc-id}")
    public void RemoveBloc(@PathVariable ("bloc-id") Long bId /*,@PathVariable another variable*/){
        blocService.removeBloc(bId);
    }

    //http://localhost:8083/gestionfoyer/retrieve-all-blocs
    @Operation(description = "modifier un bloc de la base de données")
    @PutMapping("/modify-bloc")
    public Bloc modifyBloc(@RequestBody Bloc b) {
        Bloc bloc = blocService.modifyBloc(b);
        return bloc;
    }
}
