//package br.senai.sc.trunfo.controller.user;
//
//import br.senai.sc.supertrunfofrutas.SuperTrunfoFrutasApplication;
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
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.hamcrest.Matchers.equalTo;
//import static org.mockito.Mockito.when;
//
//@ContextConfiguration(classes = SuperTrunfoFrutasApplication.class)
//@WebMvcTest(PersonController.class)
//public class PersonGetByIdController {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private PersonService personService;
//
//    @Test
//    public void getById_shouldReturnUser() throws Exception {
//        Integer userId = 1;
//        Person person = new Person(1, "Ana", "123", 0, 0, 0);
//
//        when(personService.listOne(1))
//                .thenReturn(person);
//
//        mockMvc.perform(get("/user/listOne/{id}", userId))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id", equalTo(userId)))
//                .andExpect(jsonPath("$.name").value("Ana"));
//    }
//}