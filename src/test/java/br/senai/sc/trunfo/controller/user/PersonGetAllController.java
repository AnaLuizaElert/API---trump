//package br.senai.sc.trunfo.controller.user;
//
//import br.senai.sc.supertrunfofrutas.SuperTrunfoFrutasApplication;
//import static org.hamcrest.Matchers.hasItems;
//
//import br.senai.sc.supertrunfofrutas.business.controller.PersonController;
//import br.senai.sc.supertrunfofrutas.business.model.entity.Person;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import br.senai.sc.supertrunfofrutas.business.service.PersonService;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.mockito.Mockito.when;
//
//@ContextConfiguration(classes = SuperTrunfoFrutasApplication.class)
//@WebMvcTest(PersonController.class)
//public class PersonGetAllController {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private PersonService personService;
//
//    @Test
//    public void getAll_shouldReturnUser() throws Exception {
//        List<Person> listPerson = new ArrayList<>();
//        Person person = new Person(1, "Ana", "123", 0, 0, 0);
//        Person person1 = new Person(2, "Annabel", "123", 0, 0, 0);
//        Person person2 = new Person(3, "Lucas", "123", 0, 0, 0);
//        listPerson.add(person);
//        listPerson.add(person1);
//        listPerson.add(person2);
//
//        when(personService.listAll())
//                .thenReturn(listPerson);
//
//        mockMvc.perform(get("/user/listAll"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0]").value(person))
//                .andExpect(jsonPath("$[1]").value(person1))
//                .andExpect(jsonPath("$[2]").value(person2));
//
//    }
//}