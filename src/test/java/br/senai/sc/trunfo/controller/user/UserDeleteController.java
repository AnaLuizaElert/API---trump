package br.senai.sc.trunfo.controller.user;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.senai.sc.supertrunfofrutas.SuperTrunfoFrutasApplication;
import br.senai.sc.supertrunfofrutas.controller.UserController;
import br.senai.sc.supertrunfofrutas.model.dto.UserDTO;
import br.senai.sc.supertrunfofrutas.model.entity.User;
import br.senai.sc.supertrunfofrutas.service.UserService;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.BeanUtils;
import org.junit.jupiter.api.Test;

@ContextConfiguration(classes = SuperTrunfoFrutasApplication.class)
@WebMvcTest(UserController.class)
public  class UserDeleteController {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void deleteControllerTest() throws Exception {
        UserDTO userDTO = new UserDTO("123", "Ana");
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);

        mockMvc.perform(delete("/user/delete/1"))
                .andExpect(status().isOk());
    }
}
