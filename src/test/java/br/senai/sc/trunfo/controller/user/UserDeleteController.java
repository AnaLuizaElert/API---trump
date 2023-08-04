package br.senai.sc.trunfo.controller.user;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.senai.sc.supertrunfofrutas.SuperTrunfoFrutasApplication;
import br.senai.sc.supertrunfofrutas.business.controller.PlayerController;
import br.senai.sc.supertrunfofrutas.business.model.dto.PlayerDTO;
import br.senai.sc.supertrunfofrutas.business.model.entity.Player;
import br.senai.sc.supertrunfofrutas.business.service.PlayerService;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.BeanUtils;
import org.junit.jupiter.api.Test;

@ContextConfiguration(classes = SuperTrunfoFrutasApplication.class)
@WebMvcTest(PlayerController.class)
public  class UserDeleteController {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerService playerService;

    @Test
    public void deleteControllerTest() throws Exception {
        PlayerDTO playerDTO = new PlayerDTO("Ana");
        Player user = new Player();
        BeanUtils.copyProperties(playerDTO, user);

        mockMvc.perform(delete("/user/delete/1"))
                .andExpect(status().isOk());
    }
}
