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

import com.nutrysys.nutrysys.model.Verduras;
import com.nutrysys.nutrysys.repository.VerdurasRepository;
import com.nutrysys.nutrysys.web.dto.VerdurasDTO;

import jakarta.persistence.EntityNotFoundException;
@CrossOrigin
@RestController
@RequestMapping("/verduras")
public class VerdurasController {
    @Autowired
    private VerdurasRepository verdurasRepository;
    
    @GetMapping("/list")
    List<Verduras> list(){
        return verdurasRepository.findAll();
    }
    
    @GetMapping("/{id}")
    Verduras get(@PathVariable Integer id) {
        return verdurasRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    
    
    
    @ResponseStatus(HttpStatus.CREATED )
    @PostMapping
    Verduras create(@RequestBody VerdurasDTO verdurasDTO){
    ModelMapper  mapper= new ModelMapper();
    Verduras verduras= new Verduras();
    mapper.map(verdurasDTO, verduras);
    return verdurasRepository.save(verduras);
    }
    
    @PutMapping("/{id}")
    Verduras update( @PathVariable Integer id, @RequestBody VerdurasDTO verdurasDTO){
    
        Verduras verduras= verdurasRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    
    new ModelMapper().map(verdurasDTO, verduras);
    verdurasRepository.save(verduras);
    return verduras;
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT )
    @DeleteMapping("/{id}")
    void delete( @PathVariable Integer id){
        Verduras verduras= verdurasRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        verdurasRepository.delete(verduras);
    
    }
    
    
    @GetMapping
    Page<Verduras> paginate(@PageableDefault(size = 10) Pageable pageable){
        return verdurasRepository.findAll(pageable);
    }
    }
    