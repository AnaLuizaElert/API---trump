package br.senai.sc.trunfo.controller.card;

import br.senai.sc.supertrunfofrutas.SuperTrunfoFrutasApplication;
import br.senai.sc.supertrunfofrutas.controller.CardController;
import br.senai.sc.supertrunfofrutas.controller.UserController;
import br.senai.sc.supertrunfofrutas.model.dto.CardDTO;
import br.senai.sc.supertrunfofrutas.model.entity.Card;
import br.senai.sc.supertrunfofrutas.service.CardService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = SuperTrunfoFrutasApplication.class)
@WebMvcTest(CardController.class)
public class CardCreateController {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private CardService cardService;

        @Test
        public void Create_shouldReturnCard() throws Exception {
            CardDTO cardDTO = new CardDTO("Banana", 7.0, 7.0, 7.0, 7.0);
            Card card = new Card();
            BeanUtils.copyProperties(cardDTO, card);
            card.setId(1);

            ObjectMapper objectMapper = new ObjectMapper();
            String requestBody = objectMapper.writeValueAsString(cardDTO);

            when(cardService.create(any()))
                    .thenReturn(card);

            mockMvc.perform(post("/card/create")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(requestBody))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$").value(card));
        }
}
