package br.senai.sc.supertrunfofrutas.business.service;

import br.senai.sc.supertrunfofrutas.business.model.dto.PlayerDTO;
import br.senai.sc.supertrunfofrutas.business.model.dto.PlayerUpdateDTO;
import br.senai.sc.supertrunfofrutas.business.model.entity.Player;
import br.senai.sc.supertrunfofrutas.business.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlayerService {
    
    private PlayerRepository playerRepository;
    public Player create(Player user) {
        return playerRepository.save(user);
    }
    public void delete(Integer id) {
        playerRepository.deleteById(id);
    }
    public List<Player> listAll() {
        return playerRepository.findAll();
    }
    public Player listOne(Integer id) {
        Optional<Player> optionalUser = playerRepository.findById(id);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }
        throw new RuntimeException("Deu ruim!");
    }
    public Player edit(PlayerDTO playerDTO, Integer id) {
        Player user = listOne(id);
        BeanUtils.copyProperties(playerDTO, user);
        return create(user);
    }
    public Player editBySystem(PlayerUpdateDTO playerUpdateDTO, Integer id) {
        Player user = new Player();
        BeanUtils.copyProperties(playerUpdateDTO, user);
        return create(user);
    }
}
