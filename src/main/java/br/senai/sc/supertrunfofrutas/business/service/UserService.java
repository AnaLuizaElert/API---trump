package br.senai.sc.supertrunfofrutas.business.service;

import br.senai.sc.supertrunfofrutas.business.model.dto.UserDTO;
import br.senai.sc.supertrunfofrutas.business.model.dto.UserUpdateDTO;
import br.senai.sc.supertrunfofrutas.business.model.entity.User;
import br.senai.sc.supertrunfofrutas.business.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    
    private UserRepository userRepository;
    
    public User create(User user) {
        return userRepository.save(user);
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public User listOne(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }
        throw new RuntimeException("Deu ruim!");
    }

    public User edit(UserDTO userDTO, Integer id) {
        User user = listOne(id);
        BeanUtils.copyProperties(userDTO, user);
        return create(user);
    }

    public User editBySystem(UserUpdateDTO userUpdateDTO, Integer id) {
        User user = new User();
        BeanUtils.copyProperties(userUpdateDTO, user);
        return create(user);
    }
}
