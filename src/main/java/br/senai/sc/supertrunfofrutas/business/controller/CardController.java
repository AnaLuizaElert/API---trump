package br.senai.sc.supertrunfofrutas.business.controller;

import br.senai.sc.supertrunfofrutas.business.model.dto.CardDTO;
import br.senai.sc.supertrunfofrutas.business.model.entity.Card;
import br.senai.sc.supertrunfofrutas.business.service.CardService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping
    public ResponseEntity<Card> create(@RequestBody @Valid CardDTO cardDTO){
        return  ResponseEntity.ok(cardService.create(cardDTO));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Card> edit(@RequestBody @Valid CardDTO cardDTO, @PathVariable Integer id){
        return  ResponseEntity.ok(cardService.edit(cardDTO, id));
    }

    @GetMapping("/listOne/{id}")
    public ResponseEntity<Card> listOne(@PathVariable Integer id){
        return ResponseEntity.ok(cardService.listOne(id));
    }

    @GetMapping("/listOneByName/{name}")
    public ResponseEntity<Card> listOneByName(@PathVariable String name){
        return ResponseEntity.ok(cardService.listOneByName(name));
    }

    @GetMapping
    public ResponseEntity<List<Card>> listAll(){
        return  ResponseEntity.ok(cardService.listAll());
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Card>> listAllPageable(@RequestParam int page, @RequestParam int size){
        return ResponseEntity.ok().body(cardService.createPage(page,size));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        cardService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/qtyCards")
    public ResponseEntity<Long> qtyCards(){
        return ResponseEntity.ok(cardService.qtyCards());
    }
}


