package br.senai.sc.trunfo.controller.card;

import br.senai.sc.supertrunfofrutas.SuperTrunfoFrutasApplication;
import br.senai.sc.supertrunfofrutas.business.controller.CardController;
import br.senai.sc.supertrunfofrutas.business.model.dto.CardDTO;
import br.senai.sc.supertrunfofrutas.business.model.entity.Card;
import br.senai.sc.supertrunfofrutas.business.service.CardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = SuperTrunfoFrutasApplication.class)
@WebMvcTest(CardController.class)
public class CardDeleteController {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private CardService cardService;

        @Test
        public void deleteControllerTest() throws Exception {
            CardDTO cardDTO = new CardDTO("Banana", 7.0, 7.0, 7.0, 7.0);
            Card card = new Card();
            BeanUtils.copyProperties(cardDTO, card);

            mockMvc.perform(delete("/card/delete/1"))
                    .andExpect(status().isOk());
        }
    }

