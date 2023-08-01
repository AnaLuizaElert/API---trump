package br.senai.sc.trunfo.controller.card;

import br.senai.sc.supertrunfofrutas.SuperTrunfoFrutasApplication;
import br.senai.sc.supertrunfofrutas.business.controller.CardController;
import br.senai.sc.supertrunfofrutas.business.model.dto.CardDTO;
import br.senai.sc.supertrunfofrutas.business.model.entity.Card;
import br.senai.sc.supertrunfofrutas.business.service.CardService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = SuperTrunfoFrutasApplication.class)
@WebMvcTest(CardController.class)
public class CardEditController {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private CardService userService;

        @Test
        public void Create_shouldReturnCard() throws Exception {
            CardDTO cardDTO = new CardDTO("Banana", 7.0, 7.0, 7.0, 7.0);
            Card card = new Card();
            BeanUtils.copyProperties(cardDTO, card);
            card.setId(1);

            ObjectMapper objectMapper = new ObjectMapper();
            String requestBody = objectMapper.writeValueAsString(cardDTO);

            when(userService.edit(cardDTO, 1))
                    .thenReturn(card);

            mockMvc.perform(put("/card/edit/1")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(requestBody))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$").value(card));
        }
}
