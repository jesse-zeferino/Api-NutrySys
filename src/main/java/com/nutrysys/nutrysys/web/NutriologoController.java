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

import com.nutrysys.nutrysys.model.Nutriologo;
import com.nutrysys.nutrysys.repository.NutriologoRepository;
import com.nutrysys.nutrysys.web.dto.NutriologoDTO;

import jakarta.persistence.EntityNotFoundException;
@CrossOrigin
@RestController
@RequestMapping("/nutriologos")
public class NutriologoController {
    @Autowired
    private NutriologoRepository nutriologoRepository;
    
    @GetMapping("/list")
    List<Nutriologo> list(){
        return nutriologoRepository.findAll();
    }
    
    @GetMapping("/{id}")
    Nutriologo get(@PathVariable Integer id) {
        return nutriologoRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    
    
    
    @ResponseStatus(HttpStatus.CREATED )
    @PostMapping
    Nutriologo create(@RequestBody NutriologoDTO nutriologoDTO){
    ModelMapper  mapper= new ModelMapper();
    Nutriologo nutriologo= new Nutriologo();
    mapper.map(nutriologoDTO, nutriologo);
    return nutriologoRepository.save(nutriologo);
    }
    
    @PutMapping("/{id}")
    Nutriologo update( @PathVariable Integer id, @RequestBody NutriologoDTO nutriologoDTO){
    
        Nutriologo nutriologo= nutriologoRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    
    new ModelMapper().map(nutriologoDTO, nutriologo);
    nutriologoRepository.save(nutriologo);
    return nutriologo;
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT )
    @DeleteMapping("/{id}")
    void delete( @PathVariable Integer id){
        Nutriologo nutriologo= nutriologoRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        nutriologoRepository.delete(nutriologo);
    
    }
    
    
    @GetMapping
    Page<Nutriologo> paginate(@PageableDefault(size = 10) Pageable pageable){
        return nutriologoRepository.findAll(pageable);
    }
    }
    