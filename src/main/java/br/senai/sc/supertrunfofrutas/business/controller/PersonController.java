package br.senai.sc.supertrunfofrutas.business.controller;

import br.senai.sc.supertrunfofrutas.business.model.entity.Person;
import br.senai.sc.supertrunfofrutas.business.service.PersonService;
import br.senai.sc.supertrunfofrutas.business.model.dto.PersonDTO;
import br.senai.sc.supertrunfofrutas.business.model.dto.PersonUpdateDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/user")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody @Valid PersonDTO personDTO){
        return ResponseEntity.ok(personService.create(personDTO));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Person> edit(@PathVariable Integer id, @RequestBody @Valid PersonDTO personDTO){
        return ResponseEntity.ok(personService.edit(personDTO, id));
    }

    @GetMapping("/listOne/{id}")
    public ResponseEntity<Person> listOne(@PathVariable Integer id){
        return ResponseEntity.ok(personService.listOne(id));
    }

    @GetMapping("/listOneByName/{name}")
    public ResponseEntity<Person> listOneByName(@PathVariable String name){
        return ResponseEntity.ok(personService.listOneByName(name));
    }

    @GetMapping
    public ResponseEntity<List<Person>> listAll(){
        return ResponseEntity.ok(personService.listAll());
    }

    @PutMapping("/editBySytem/{id}")
    public ResponseEntity<Person> editBySytem(@PathVariable Integer id, @RequestBody @Valid PersonUpdateDTO personUpdateDTO){
        return ResponseEntity.ok(personService.editBySystem(personUpdateDTO, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        personService.delete(id);
        return ResponseEntity.ok().build();
    }

}
