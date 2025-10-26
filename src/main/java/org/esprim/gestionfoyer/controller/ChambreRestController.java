package org.esprim.gestionfoyer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.esprim.gestionfoyer.entities.Chambre;
import org.esprim.gestionfoyer.service.IChambreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gestion Chambre")
@AllArgsConstructor
@RestController
@RequestMapping("/Chambre")
public class ChambreRestController {

    IChambreService chambreService;

    //http://localhost:8083/gestionfoyer/retrieve-all-chambres
    @Operation(description = "récupérer toutes les chambres de la base de données")
    @GetMapping("/retrieve-all-chambres")
    public List<Chambre> retrieveAllChambres() {
        List<Chambre> chambreList = chambreService.retrieveAllChambres();
        return chambreList;
    }

    //http://localhost:8083/gestionfoyer/retrieve-chambres/8
    @Operation(description = "récupérer une chambre de la base de données")
    @GetMapping("/retrive-chambre/{chambre-id}")
    public Chambre retrieveChambre(@PathVariable ("chambre-id") Long chId /*,@PathVariable another variable*/){
     Chambre chambre= chambreService.retrieveChambre(chId);
        return chambre;
    }

    //http://localhost:8083/gestionfoyer/chambre/add-chambre
    @Operation(description = "ajouter une chambre de la base de données")
    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.addChambre(c);
        return chambre;
    }

    //http://localhost:8083/gestionfoyer/remove-chambres/2
    @Operation(description = "supprimer une chambre de la base de données")
    @DeleteMapping("/remove-chambre/{chambre-id}")
    public void RemoveChambre(@PathVariable ("chambre-id") Long chId /*,@PathVariable another variable*/){
        chambreService.removeChambre(chId);
    }

    //http://localhost:8083/gestionfoyer/retrieve-all-chambres
    @Operation(description = "modifier une chambre de la base de données")
    @PutMapping("/modify-chambre")
    public Chambre modifyChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.modifyChambre(c);
        return chambre;
    }

}
