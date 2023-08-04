package br.senai.sc.trunfo.controller.user;

import br.senai.sc.supertrunfofrutas.SuperTrunfoFrutasApplication;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

import br.senai.sc.supertrunfofrutas.business.controller.PlayerController;
import br.senai.sc.supertrunfofrutas.business.model.dto.PlayerUpdateDTO;
import br.senai.sc.supertrunfofrutas.business.model.entity.Player;
import br.senai.sc.supertrunfofrutas.business.service.PlayerService;
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
@WebMvcTest(PlayerController.class)
public class UserEditBySystemController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerService playerService;

    @Test
    public void Create_shouldReturnUser() throws Exception {
        PlayerUpdateDTO playerUpdateDTO = new PlayerUpdateDTO(1,2,3);
        Player user = new Player();
        BeanUtils.copyProperties(playerUpdateDTO, user);
        user.setId(1);

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(playerUpdateDTO);

        when(playerService.editBySystem(playerUpdateDTO, 1))
                .thenReturn(user);

        mockMvc.perform(put("/user/editBySytem/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(user));
    }
}