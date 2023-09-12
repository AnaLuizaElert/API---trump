//package br.senai.sc.trunfo.controller.user;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import br.senai.sc.supertrunfofrutas.SuperTrunfoFrutasApplication;
//import br.senai.sc.supertrunfofrutas.business.controller.PersonController;
//import br.senai.sc.supertrunfofrutas.business.model.dto.PersonDTO;
//import br.senai.sc.supertrunfofrutas.business.model.entity.Person;
//import br.senai.sc.supertrunfofrutas.business.service.PersonService;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.beans.BeanUtils;
//import org.junit.jupiter.api.Test;
//
//@ContextConfiguration(classes = SuperTrunfoFrutasApplication.class)
//@WebMvcTest(PersonController.class)
//public  class PersonDeleteController {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private PersonService personService;
//
//    @Test
//    public void deleteControllerTest() throws Exception {
//        PersonDTO personDTO = new PersonDTO("123", "Ana");
//        Person person = new Person();
//        BeanUtils.copyProperties(personDTO, person);
//
//        mockMvc.perform(delete("/user/delete/1"))
//                .andExpect(status().isOk());
//    }
//}
