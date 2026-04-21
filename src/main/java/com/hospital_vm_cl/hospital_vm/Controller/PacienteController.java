package com.hospital_vm_cl.hospital_vm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital_vm_cl.hospital_vm.Services.PacienteService;
import com.hospital_vm_cl.hospital_vm.model.Paciente;

@RestController
@RequestMapping("api/v1/Pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;
    
    
 //con este metodo ademas de listar los paciente, informamos bajo un status que el proceso se completo satisfactoriamente
    @GetMapping
    public ResponseEntity<List<Paciente>> listar(){

        List<Paciente> pacientes = pacienteService.findAll();

        if (pacientes.isEmpty()) {
            return ResponseEntity.noContent().build();
    
        }
        return ResponseEntity.ok(pacientes);

    }
}
