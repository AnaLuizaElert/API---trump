package br.senai.sc.trunfo.controller.user;

import br.senai.sc.supertrunfofrutas.SuperTrunfoFrutasApplication;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

import br.senai.sc.supertrunfofrutas.controller.UserController;
import br.senai.sc.supertrunfofrutas.model.dto.UserDTO;
import br.senai.sc.supertrunfofrutas.model.entity.User;
import br.senai.sc.supertrunfofrutas.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.junit.jupiter.api.Test;


@ContextConfiguration(classes = SuperTrunfoFrutasApplication.class)
@WebMvcTest(UserController.class)
public class UserCreateController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void Create_shouldReturnUser() throws Exception {
        UserDTO userDTO = new UserDTO("123", "Ana");
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        user.setId(1);

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(userDTO);

        when(userService.create(any()))
                .thenReturn(user);

        mockMvc.perform(post("/user/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(user));
    }
}