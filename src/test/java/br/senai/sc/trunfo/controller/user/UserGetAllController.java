package br.senai.sc.trunfo.controller.user;

import br.senai.sc.supertrunfofrutas.SuperTrunfoFrutasApplication;
import static org.hamcrest.Matchers.hasItems;

import br.senai.sc.supertrunfofrutas.controller.UserController;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import br.senai.sc.supertrunfofrutas.model.entity.User;
import org.springframework.boot.test.mock.mockito.MockBean;
import br.senai.sc.supertrunfofrutas.service.UserService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = SuperTrunfoFrutasApplication.class)
@WebMvcTest(UserController.class)
public class UserGetAllController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void getAll_shouldReturnUser() throws Exception {
        List<User> listUser = new ArrayList<>();
        User user = new User(1, "Ana", "123", 0, 0, 0);
        User user1 = new User(2, "Annabel", "123", 0, 0, 0);
        User user2 = new User(3, "Lucas", "123", 0, 0, 0);
        listUser.add(user);
        listUser.add(user1);
        listUser.add(user2);

        when(userService.listAll())
                .thenReturn(listUser);

        mockMvc.perform(get("/user/listAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").value(user))
                .andExpect(jsonPath("$[1]").value(user1))
                .andExpect(jsonPath("$[2]").value(user2));

    }
}