package br.senai.sc.supertrunfofrutas.controller;

import br.senai.sc.supertrunfofrutas.model.dto.UserDTO;
import br.senai.sc.supertrunfofrutas.model.dto.UserUpdateDTO;
import br.senai.sc.supertrunfofrutas.model.entity.Card;
import br.senai.sc.supertrunfofrutas.model.entity.User;
import br.senai.sc.supertrunfofrutas.service.UserService;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody @Valid UserDTO userDTO){
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        return ResponseEntity.ok(userService.create(user));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<User>> listAll(){
        return ResponseEntity.ok(userService.listAll());
    }

    @GetMapping("/listOne/{id}")
    public ResponseEntity<User> listOne(@PathVariable Integer id){
        return ResponseEntity.ok(userService.listOne(id));
    }

    @GetMapping("/listOneByName/{name}")
    public ResponseEntity<User> listOneByName(@PathVariable String name){
        for(User user : userService.listAll()){
            if(user.getName().equals(name)){
                return ResponseEntity.ok(userService.listOne(user.getId()));
            }
        }
        throw new RuntimeException("Item não encontrado!");
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<User> edit(@PathVariable Integer id, @RequestBody @Valid UserDTO userDTO){
        return ResponseEntity.ok(userService.edit(userDTO, id));
    }

    @PutMapping("/editBySytem/{id}")
    public ResponseEntity<User> editBySytem(@PathVariable Integer id, @RequestBody @Valid UserUpdateDTO userUpdateDTO){
        return ResponseEntity.ok(userService.editBySystem(userUpdateDTO, id));
    }
}
