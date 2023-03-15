package com.nutrysys.nutrysys.web;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nutrysys.nutrysys.model.Frutas;
import com.nutrysys.nutrysys.repository.FrutasRepository;
import com.nutrysys.nutrysys.web.dto.FrutasDTO;

import jakarta.persistence.EntityNotFoundException;
@CrossOrigin
@RestController
@RequestMapping("/frutas")
public class FrutasController {
    @Autowired
    private FrutasRepository frutasRepository;
    
    @GetMapping("/list")
    List<Frutas> list(){
        return frutasRepository.findAll();
    }
    
    @GetMapping("/{id}")
    Frutas get(@PathVariable Integer id) {
        return frutasRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    
    
    
    @ResponseStatus(HttpStatus.CREATED )
    @PostMapping
    Frutas create(@RequestBody FrutasDTO frutasDTO){
    ModelMapper  mapper= new ModelMapper();
    Frutas frutas= new Frutas();
    mapper.map(frutasDTO, frutas);
    return frutasRepository.save(frutas);
    }
    
    @PutMapping("/{id}")
    Frutas update( @PathVariable Integer id, @RequestBody FrutasDTO frutasDTO){
    
        Frutas frutas= frutasRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    
    new ModelMapper().map(frutasDTO, frutas);
    frutasRepository.save(frutas);
    return frutas;
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT )
    @DeleteMapping("/{id}")
    void delete( @PathVariable Integer id){
        Frutas frutas= frutasRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        frutasRepository.delete(frutas);
    
    }
    
    
    @GetMapping
    Page<Frutas> paginate(@PageableDefault(size = 10) Pageable pageable){
        return frutasRepository.findAll(pageable);
    }
    }