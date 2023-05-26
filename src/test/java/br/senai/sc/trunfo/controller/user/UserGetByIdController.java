package br.senai.sc.trunfo.controller.user;

import br.senai.sc.supertrunfofrutas.SuperTrunfoFrutasApplication;
import br.senai.sc.supertrunfofrutas.controller.UserController;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import br.senai.sc.supertrunfofrutas.model.entity.User;
import org.springframework.boot.test.mock.mockito.MockBean;
import br.senai.sc.supertrunfofrutas.service.UserService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = SuperTrunfoFrutasApplication.class)
@WebMvcTest(UserController.class)
public class UserGetByIdController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void getById_shouldReturnUser() throws Exception {
        Integer userId = 1;
        User user = new User(1, "Ana", "123", 0, 0, 0);

        when(userService.listOne(1))
                .thenReturn(user);

        mockMvc.perform(get("/user/listOne/{id}", userId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", equalTo(userId)))
                .andExpect(jsonPath("$.name").value("Ana"));
    }
}