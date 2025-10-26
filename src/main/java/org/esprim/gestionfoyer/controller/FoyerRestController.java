package org.esprim.gestionfoyer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.esprim.gestionfoyer.entities.Foyer;
import org.esprim.gestionfoyer.service.IFoyerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gestion Foyer")
@AllArgsConstructor
@RestController
@RequestMapping("/Foyer")
public class FoyerRestController {

    IFoyerService foyerService;

    //http://localhost:8083/gestionfoyer/retrieve-all-foyers
    @Operation(description = "récupérer toutes les foyes de la base de données")
    @GetMapping("/retrieve-all-foyers")
    public List<Foyer> retrieveAllFoyers() {
        List<Foyer> foyerList = foyerService.retrieveAllFoyer();
        return foyerList;
    }

    //http://localhost:8083/gestionfoyer/retrieve-foyers/1
    @Operation(description = "récupérer un foyer de la base de données")
    @GetMapping("/retrive-foyer/{foyer-id}")
    public Foyer retrieveFoyer(@PathVariable ("foyer-id") Long fId /*,@PathVariable another variable*/){
        Foyer foyer= foyerService.retrieveFoyer(fId);
        return foyer;
    }

    //http://localhost:8083/gestionfoyer/foyer/add-foyer
    @Operation(description = "ajouter un foyer de la base de données")
    @PostMapping("/add-foyer")
    public Foyer addfoyer(@RequestBody Foyer f) {
        Foyer foyer = foyerService.addFoyer(f);
        return foyer;
    }

    //http://localhost:8083/gestionfoyer/remove-foyers/6
    @Operation(description = "supprimer un foyer de la base de données")
    @DeleteMapping("/remove-foyer/{foyer-id}")
    public void RemoveFoyer(@PathVariable ("foyer-id") Long chId /*,@PathVariable another variable*/){
        foyerService.removeFoyer(chId);
    }

    //http://localhost:8083/gestionfoyer/retrieve-all-foyers
    @Operation(description = "modifier un foyer de la base de données")
    @PutMapping("/modify-foyer")
    public Foyer modifyFoyer(@RequestBody Foyer f) {
        Foyer foyer = foyerService.modifyFoyer(f);
        return foyer;
    }
}
