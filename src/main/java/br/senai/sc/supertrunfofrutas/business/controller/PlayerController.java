package br.senai.sc.supertrunfofrutas.business.controller;

import br.senai.sc.supertrunfofrutas.business.service.PlayerService;
import br.senai.sc.supertrunfofrutas.business.model.dto.PlayerDTO;
import br.senai.sc.supertrunfofrutas.business.model.dto.PlayerUpdateDTO;
import br.senai.sc.supertrunfofrutas.business.model.entity.Player;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/create")
    public ResponseEntity<Player> create(@RequestBody @Valid PlayerDTO playerDTO){
        Player player = new Player();
        BeanUtils.copyProperties(playerDTO, player);
        return ResponseEntity.ok(playerService.create(player));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        playerService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Player>> listAll(){
        return ResponseEntity.ok(playerService.listAll());
    }

    @GetMapping("/listOne/{id}")
    public ResponseEntity<Player> listOne(@PathVariable Integer id){
        return ResponseEntity.ok(playerService.listOne(id));
    }

    @GetMapping("/listOneByName/{name}")
    public ResponseEntity<Player> listOneByName(@PathVariable String name){
        for(Player player : playerService.listAll()){
            if(player.getUsername().equals(name)){
                return ResponseEntity.ok(playerService.listOne(player.getId()));
            }
        }
        throw new RuntimeException("Item não encontrado!");
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Player> edit(@PathVariable Integer id, @RequestBody @Valid PlayerDTO playerDTO){
        return ResponseEntity.ok(playerService.edit(playerDTO, id));
    }

    @PutMapping("/editBySytem/{id}")
    public ResponseEntity<Player> editBySytem(@PathVariable Integer id, @RequestBody @Valid PlayerUpdateDTO playerUpdateDTO){
        return ResponseEntity.ok(playerService.editBySystem(playerUpdateDTO, id));
    }
}
