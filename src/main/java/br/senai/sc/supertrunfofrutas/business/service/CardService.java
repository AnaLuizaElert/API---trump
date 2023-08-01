package br.senai.sc.supertrunfofrutas.business.service;

import br.senai.sc.supertrunfofrutas.business.model.dto.CardDTO;
import br.senai.sc.supertrunfofrutas.business.model.entity.Card;
import br.senai.sc.supertrunfofrutas.business.repository.CardRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CardService {
    private CardRepository cardRepository;
    public Card create(Card card) {
        return cardRepository.save(card);
    }
    public Card edit(CardDTO cardDTO, Integer id) {
        Card card = listSpecific(id);
        BeanUtils.copyProperties(cardDTO, card);
        return create(card);
    }
    public List<Card> listAll(){
        return cardRepository.findAll();
    }
    public Card listSpecific(Integer id){
        Optional<Card> optionalcard = cardRepository.findById(id);
        if(optionalcard.isPresent()){
            return optionalcard.get();
        }
        throw new RuntimeException("Deu ruim!");
    }
    public void deleteSpecific(Integer id) {
        cardRepository.deleteById(id);
    }
    public Page<Card> createPage(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return cardRepository.findAll(pageable);
    }

    public Long qtyCards(){
        return cardRepository.count();
    }
}
