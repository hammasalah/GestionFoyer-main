package org.esprim.gestionfoyer.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.esprim.gestionfoyer.entities.Etudiant;
import org.esprim.gestionfoyer.service.IEtudiantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gestion Etudiant")
@AllArgsConstructor
@RestController
@RequestMapping("/Etudiant")

public class EtudiantRestController {

    IEtudiantService etudiantService;

    //http://localhost:8083/gestionfoyer/retrieve-all-etudiants
    @Operation(description = "récupérer toutes les etudiantss de la base de données")
    @GetMapping("/retrieve-all-etudiants")
    public List<Etudiant> retrieveAllEtudiants() {
        List<Etudiant> etudiantList = etudiantService.retrieveAllEtudiant();
        return etudiantList;
    }

    //http://localhost:8083/gestionfoyer/retrieve-etudiants/5
    @Operation(description = "récupérer un etudiant de la base de données")
    @GetMapping("/retrive-etudiant/{etudiant-id}")
    public Etudiant retrieveEtudiant(@PathVariable ("etudiant-id") Long eId /*,@PathVariable another variable*/){
        Etudiant etudiant= etudiantService.retrieveEtudiant(eId);
        return etudiant;
    }

    //http://localhost:8083/gestionfoyer/etudiant/add-etudiant
    @Operation(description = "ajouter un etudiant de la base de données")
    @PostMapping("/add-etudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        Etudiant etudiant = etudiantService.addEtudiant(e);
        return etudiant;
    }

    //http://localhost:8083/gestionfoyer/remove-etudiants/12
    @Operation(description = "supprimer un etudiant de la base de données")
    @DeleteMapping("/remove-etudiant/{etudiant-id}")
    public void RemoveEtudiant(@PathVariable ("etudiant-id") Long eId /*,@PathVariable another variable*/){
        etudiantService.removeEtudiant(eId);
    }

    //http://localhost:8083/gestionfoyer/retrieve-all-etudiants
    @Operation(description = "modifier un etudiant de la base de données")
    @PutMapping("/modify-etudiant")
    public Etudiant modifyEtudiant(@RequestBody Etudiant e) {
        Etudiant etudiant = etudiantService.modifyEtudiant(e);
        return etudiant;
    }
}
