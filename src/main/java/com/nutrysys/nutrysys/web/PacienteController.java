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

import com.nutrysys.nutrysys.repository.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import com.nutrysys.nutrysys.web.dto.PacienteDTO;
import  com.nutrysys.nutrysys.model.Paciente;

@CrossOrigin
@RestController
@RequestMapping("/pacientes")
public class PacienteController {
@Autowired
private PacienteRepository pacienteRepository;

@GetMapping("/list")
List<Paciente> list(){
    return pacienteRepository.findAll();
}

@GetMapping("/{id}")
Paciente get(@PathVariable Integer id) {
    return pacienteRepository.findById(id).orElseThrow(EntityNotFoundException::new);
}



@ResponseStatus(HttpStatus.CREATED )
@PostMapping
Paciente create(@RequestBody PacienteDTO pacienteDTO){
ModelMapper  mapper= new ModelMapper();
Paciente paciente= new Paciente();
mapper.map(pacienteDTO, paciente);
return pacienteRepository.save(paciente);
}

@PutMapping("/{id}")
Paciente update( @PathVariable Integer id, @RequestBody PacienteDTO pacienteDTO){

    Paciente paciente= pacienteRepository.findById(id).orElseThrow(EntityNotFoundException::new);

new ModelMapper().map(pacienteDTO, paciente);
pacienteRepository.save(paciente);
return paciente;
}

@ResponseStatus(HttpStatus.NO_CONTENT )
@DeleteMapping("/{id}")
void delete( @PathVariable Integer id){
    Paciente paciente= pacienteRepository.findById(id).orElseThrow(EntityNotFoundException::new);
pacienteRepository.delete(paciente);

}


@GetMapping
Page<Paciente> paginate(@PageableDefault(size = 10) Pageable pageable){
    return pacienteRepository.findAll(pageable);
}
}
