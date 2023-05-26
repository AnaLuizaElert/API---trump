package br.senai.sc.supertrunfofrutas.controller;

import br.senai.sc.supertrunfofrutas.model.dto.CardDTO;
import br.senai.sc.supertrunfofrutas.model.entity.Card;
import br.senai.sc.supertrunfofrutas.service.CardService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping("/create")
    public ResponseEntity<Card> create(@RequestBody @Valid CardDTO cardDTO){
        Card card = new Card();
        BeanUtils.copyProperties(cardDTO, card);
        return  ResponseEntity.ok(cardService.create(card));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Card> edit(@RequestBody @Valid CardDTO cardDTO, @PathVariable Integer id){
        return  ResponseEntity.ok(cardService.edit(cardDTO, id));
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Card>> listAll(){
        return  ResponseEntity.ok(cardService.listAll());
    }

    @GetMapping("/listOne/{id}")
    public ResponseEntity<Card> listOne(@PathVariable Integer id){
        return ResponseEntity.ok(cardService.listSpecific(id));
    }

    @GetMapping("/listOneByName/{name}")
    public ResponseEntity<Card> listOneByName(@PathVariable String name){
        for(Card card : cardService.listAll()){
            if(card.getName().equals(name)){
                return ResponseEntity.ok(cardService.listSpecific(card.getId()));
            }
        }
        throw new RuntimeException("Item não encontrado!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        cardService.deleteSpecific(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Card>> findAll(@RequestParam int page, @RequestParam int size){
        return ResponseEntity.ok().body(cardService.createPage(page,size));
    }

    @GetMapping("/qtyCards")
    public ResponseEntity<Long> qtyCards(){
        return ResponseEntity.ok(cardService.qtyCards());
    }
}


