package br.senai.sc.supertrunfofrutas.business.service;

import br.senai.sc.supertrunfofrutas.business.exception.InvalidName;
import br.senai.sc.supertrunfofrutas.business.exception.PasswordWrong;
import br.senai.sc.supertrunfofrutas.business.exception.PersonNotFound;
import br.senai.sc.supertrunfofrutas.business.model.dto.PersonDTO;
import br.senai.sc.supertrunfofrutas.business.model.dto.PersonEditDTO;
import br.senai.sc.supertrunfofrutas.business.model.dto.PersonUpdateDTO;
import br.senai.sc.supertrunfofrutas.business.model.entity.Person;
import br.senai.sc.supertrunfofrutas.business.model.entity.Profile;
import br.senai.sc.supertrunfofrutas.business.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonService {
    
    private PersonRepository personRepository;
    
    public Person create(PersonDTO personDTO) throws InvalidName {
        Optional<Person> optionalUser = personRepository.findByName(personDTO.getName());
        if(optionalUser.isPresent()){
            throw new InvalidName();
        }
        Person person = new Person();
        BeanUtils.copyProperties(personDTO, person);
        return personRepository.save(person);
    }

    public List<Person> listAll() {
        return personRepository.findAll();
    }

    public Person listOne(Integer id) throws PersonNotFound {
        Optional<Person> optionalUser = personRepository.findById(id);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }
        throw new PersonNotFound();
    }

    public Person editBySystem(PersonUpdateDTO personUpdateDTO, Integer id) throws PersonNotFound {
        Person person = listOne(id);
        BeanUtils.copyProperties(personUpdateDTO, person);
        return personRepository.save(person);
    }

    public Person editByWeb(PersonEditDTO personEditDTO, Integer id) throws InvalidName {
        Optional<Person> optionalUserById = personRepository.findById(id);
        Optional<Person> optionalUserByName = personRepository.findByName(personEditDTO.getName());

        if(optionalUserById.isPresent()){
            Person userById = optionalUserById.get();
            if(optionalUserByName.isPresent()){
                Person userByName = optionalUserByName.get();
                //se existem ambos e os nomes são iguais o usuário pode ser editado
                if(userById.equals(userByName)){
                    if(new BCryptPasswordEncoder()
                            .matches(personEditDTO.getCurrentPassword(), userById.getPassword())){
                        return editPerson(personEditDTO, id);
                    }
                    throw new PasswordWrong();
                }
                //senão indica que já havia alguém com esse nome editado
                throw new InvalidName();
            } else {
                //Significa que o nome foi editado e não há ninguém cadastrado com ele no sistema
                if(new BCryptPasswordEncoder()
                        .matches(personEditDTO.getCurrentPassword(), userById.getPassword())){
                    return editPerson(personEditDTO, id);
                }
                throw new PasswordWrong();
            }
        }
        throw new PersonNotFound();
    }

    public Person editPerson(PersonEditDTO personEditDTO, Integer id){
        Person person = new Person();
        person.setId(id);
        person.setAuthorities(List.of(Profile.ADMIN));
        person.setName(personEditDTO.getName());
        person.setPassword(new BCryptPasswordEncoder().encode(personEditDTO.getPassword()));
        return personRepository.save(person);
    }

    public Person listOneByName(String name) {
        Optional<Person> optionalUser = personRepository.findByName(name);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }
        throw new PersonNotFound();
    }

    public void delete(Integer id) throws PersonNotFound {
        Person person = listOne(id);
        personRepository.delete(person);
    }

}
