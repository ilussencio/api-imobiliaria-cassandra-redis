package br.com.srbit.imobiliaria.controllers;

import br.com.srbit.imobiliaria.entities.Imovel;
import br.com.srbit.imobiliaria.services.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/imoveis")
public class ImovelControllers {

    @Autowired
    private ImovelService service;

    @GetMapping
    public ResponseEntity<List<Imovel>> findAll(){
        var list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Imovel> findById(@PathVariable UUID id){
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Imovel> save(@RequestBody Imovel imovel){
        return service.save(imovel);
    }

    @PutMapping
    public ResponseEntity<Imovel> update(@RequestBody Imovel imovel){
        return service.update(imovel);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable UUID id){
        return service.delete(id);
    }
}
