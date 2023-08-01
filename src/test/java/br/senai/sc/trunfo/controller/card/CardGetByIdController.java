package br.senai.sc.trunfo.controller.card;

import br.senai.sc.supertrunfofrutas.SuperTrunfoFrutasApplication;
import br.senai.sc.supertrunfofrutas.business.controller.CardController;
import br.senai.sc.supertrunfofrutas.business.model.entity.Card;
import br.senai.sc.supertrunfofrutas.business.service.CardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = SuperTrunfoFrutasApplication.class)
@WebMvcTest(CardController.class)
public class CardGetByIdController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CardService cardService;

    @Test
    public void getById_shouldReturnCard() throws Exception {
        Integer cardId = 1;
        Card card = new Card(1, "Banana", 1.0, 7.0, 6.0, 5.0);

        when(cardService.listSpecific(1))
                .thenReturn(card);

        mockMvc.perform(get("/card/listOne/{id}", cardId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", equalTo(cardId)))
                .andExpect(jsonPath("$.name").value("Banana"))
                .andExpect(jsonPath("$.qtyCalories").value(1.0))
                .andExpect(jsonPath("$.qtyGlucose").value(7.0))
                .andExpect(jsonPath("$.ranking").value(6.0))
                .andExpect(jsonPath("$.qtyProteins").value(5.0));
    }
}
