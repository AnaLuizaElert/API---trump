package br.senai.sc.supertrunfofrutas.business.service;

import br.senai.sc.supertrunfofrutas.business.model.dto.PersonDTO;
import br.senai.sc.supertrunfofrutas.business.model.dto.PersonUpdateDTO;
import br.senai.sc.supertrunfofrutas.business.model.entity.Person;
import br.senai.sc.supertrunfofrutas.business.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonService {
    
    private PersonRepository personRepository;
    
    public Person create(Person person) {
        return personRepository.save(person);
    }

    public void delete(Integer id) {
        personRepository.deleteById(id);
    }

    public List<Person> listAll() {
        return personRepository.findAll();
    }

    public Person listOne(Integer id) {
        Optional<Person> optionalUser = personRepository.findById(id);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }
        throw new RuntimeException("Deu ruim!");
    }

    public Person edit(PersonDTO personDTO, Integer id) {
        Person person = listOne(id);
        BeanUtils.copyProperties(personDTO, person);
        return create(person);
    }

    public Person editBySystem(PersonUpdateDTO personUpdateDTO, Integer id) {
        Person person = new Person();
        BeanUtils.copyProperties(personUpdateDTO, person);
        return create(person);
    }
}
