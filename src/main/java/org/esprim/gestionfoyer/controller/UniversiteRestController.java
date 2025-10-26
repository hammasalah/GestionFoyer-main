package org.esprim.gestionfoyer.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.esprim.gestionfoyer.entities.Universite;
import org.esprim.gestionfoyer.service.IUniversiteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gestion Universite")
@AllArgsConstructor
@RestController
@RequestMapping("/Universite")
public class UniversiteRestController {
    IUniversiteService universiteService;

    //http://localhost:8083/gestionfoyer/retrieve-all-Universites
    @Operation(description = "récupérer toutes les universites de la base de données")
    @GetMapping("/retrieve-all-Universites")
    public List<Universite> retrieveAllUniversite() {
        List<Universite> UniversiteList = universiteService.retrieveAllUniversite();
        return UniversiteList;
    }

    //http://localhost:8083/gestionfoyer/retrieve-universites/5
    @Operation(description = "récupérer une universite de la base de données")
    @GetMapping("/retrive-universite/{universite-id}")
    public Universite retrieveUniversite(@PathVariable ("universite-id") Long uId /*,@PathVariable another variable*/){
        Universite universite= universiteService.retrieveUniversite(uId);
        return universite;
    }

    //http://localhost:8083/gestionfoyer/universite/add-universite
    @Operation(description = "ajouter une universite de la base de données")
    @PostMapping("/add-chambre")
    public Universite addUniversite(@RequestBody Universite u) {
        Universite universite = universiteService.addUniversite(u);
        return universite;
    }

    //http://localhost:8083/gestionfoyer/remove-universites/3
    @Operation(description = "supprimer une universite de la base de données")
    @DeleteMapping("/remove-universite/{universite-id}")
    public void RemoveUniversite(@PathVariable ("universite-id") Long uId /*,@PathVariable another variable*/){
        universiteService.removeUniversite(uId);
    }

    //http://localhost:8083/gestionfoyer/retrieve-all-universites
    @Operation(description = "modifier une universite de la base de données")
    @PutMapping("/modify-universite")
    public Universite modifyUniversite(@RequestBody Universite u) {
        Universite universite = universiteService.modifyUniversite(u);
        return universite;
    }
}
