package br.senai.sc.trunfo.controller.card;

import br.senai.sc.supertrunfofrutas.SuperTrunfoFrutasApplication;
import br.senai.sc.supertrunfofrutas.controller.CardController;
import br.senai.sc.supertrunfofrutas.model.entity.Card;
import br.senai.sc.supertrunfofrutas.service.CardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = SuperTrunfoFrutasApplication.class)
@WebMvcTest(CardController.class)
public class CardGetAllController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CardService cardService;

    @Test
    public void getAll_shouldReturnCard() throws Exception {
        List<Card> listCard = new ArrayList<>();
        Card card = new Card(1, "Banana", 7.0, 7.0, 7.0, 7.0);
        Card card1 = new Card(2,"Banana", 7.0, 7.0, 7.0, 7.0);
        Card card2 = new Card(3, "Banana", 7.0, 7.0, 7.0, 7.0);
        listCard.add(card);
        listCard.add(card1);
        listCard.add(card2);

        when(cardService.listAll())
                .thenReturn(listCard);

        System.out.println(listCard);

        mockMvc.perform(get("/card/listAll")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").value(card))
                .andExpect(jsonPath("$[1]").value(card1))
                .andExpect(jsonPath("$[2]").value(card2));

    }
}
