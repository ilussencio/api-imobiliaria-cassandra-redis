package br.com.srbit.imobiliaria.services;

import br.com.srbit.imobiliaria.entities.Imovel;
import br.com.srbit.imobiliaria.repositories.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ImovelService {
    @Autowired
    private ImovelRepository repository;

    //CRUD
    @Cacheable(value = "imoveis")
    public List<Imovel> findAll(){
        var dbImovel = repository.findAll();
        return dbImovel;
    }
    //@Cacheable(value = "imoveis", key = "#id")
    public ResponseEntity<Imovel> findById(UUID id){
        var imovel = repository.findById(id);
        if(imovel.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(imovel.get());
    }
    //@CacheEvict(value = "imoveis", allEntries = true)
    public ResponseEntity<Imovel> save(Imovel imovel){
        return ResponseEntity.ok(repository.save(imovel));
    }

    //@CacheEvict(value = "imoveis", allEntries = true)
    public ResponseEntity<Imovel> update(Imovel imovel){
        if( imovel.getId() == null)
            return ResponseEntity.badRequest().build();

        var dbImovel = repository.findById(imovel.getId());
        if(dbImovel.isEmpty())
            return ResponseEntity.badRequest().build();

        var curImovel = dbImovel.get();
        curImovel.setEndereco(imovel.getEndereco());
        curImovel.setTipo_imovel(imovel.getTipo_imovel());
        curImovel.setArea(imovel.getArea());
        curImovel.setPreco(imovel.getPreco());
        return ResponseEntity.ok(repository.save(curImovel));
    }

    @CacheEvict(value = "imoveis", allEntries = true)
    public ResponseEntity<?> delete(UUID id){
        var imovel = repository.findById(id);
        if(imovel.isEmpty())
            return ResponseEntity.badRequest().build();
        repository.delete(imovel.get());
        return ResponseEntity.noContent().build();
    }

}
