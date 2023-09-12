//package br.senai.sc.trunfo.controller.user;
//
//import br.senai.sc.supertrunfofrutas.SuperTrunfoFrutasApplication;
//
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.mockito.Mockito.when;
//
//import br.senai.sc.supertrunfofrutas.business.controller.PersonController;
//import br.senai.sc.supertrunfofrutas.business.model.dto.PersonDTO;
//import br.senai.sc.supertrunfofrutas.business.model.entity.Person;
//import br.senai.sc.supertrunfofrutas.business.service.PersonService;
//import org.springframework.beans.BeanUtils;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.http.MediaType;
//import org.junit.jupiter.api.Test;
//
//
//@ContextConfiguration(classes = SuperTrunfoFrutasApplication.class)
//@WebMvcTest(PersonController.class)
//public class PersonEditController {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private PersonService personService;
//
//    @Test
//    public void Create_shouldReturnUser() throws Exception {
//        PersonDTO personDTO = new PersonDTO("123", "Ana");
//        Person person = new Person();
//        BeanUtils.copyProperties(personDTO, person);
//        person.setId(1);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String requestBody = objectMapper.writeValueAsString(personDTO);
//
//        when(personService.edit(personDTO, 1))
//                .thenReturn(person);
//
//        mockMvc.perform(put("/user/edit/1")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(requestBody))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$").value(person));
//    }
//}