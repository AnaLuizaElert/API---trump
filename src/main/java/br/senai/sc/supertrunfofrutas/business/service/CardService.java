package br.senai.sc.supertrunfofrutas.business.service;

import br.senai.sc.supertrunfofrutas.business.exception.CardNotFound;
import br.senai.sc.supertrunfofrutas.business.exception.InvalidName;
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

    public Card create(CardDTO cardDTO) {
        Optional<Card> optionalUser = cardRepository.findByName(cardDTO.getName());
        if(optionalUser.isPresent()){
            throw new InvalidName();
        }
        Card card = new Card();
        BeanUtils.copyProperties(cardDTO, card);
        return cardRepository.save(card);
    }

    public Card edit(CardDTO cardDTO, Integer id) {
        Optional<Card> optionalCardById = cardRepository.findById(id);
        Optional<Card> optionalCardByName = cardRepository.findByName(cardDTO.getName());

        if(optionalCardById.isPresent()){
            if(optionalCardByName.isPresent()){
                Card cardById = optionalCardById.get();
                Card cardByName = optionalCardByName.get();
                //se existem ambos e os nomes são iguais a carta pode ser editada
                if(cardById.equals(cardByName)){
                    Card card = new Card();
                    BeanUtils.copyProperties(cardDTO, card);
                    card.setId(id);
                    return cardRepository.save(card);
                }
                //senão indica que já havia alguém com esse nome editado
                throw new InvalidName();
            } else {
                //Significa que o nome foi editado e não há ninguém cadastrado com ele no sistema
                Card card = new Card();
                BeanUtils.copyProperties(cardDTO, card);
                return cardRepository.save(card);
            }
        }
        throw new CardNotFound();
    }

    public List<Card> listAll(){
        return cardRepository.findAll();
    }

    public Card listOneByName(String name){
        Optional<Card> optionalCard = cardRepository.findByName(name);
        if(optionalCard.isPresent()){
            return optionalCard.get();
        }
        throw new InvalidName();
    }

    public Card listOne(Integer id){
        Optional<Card> optionalCard = cardRepository.findById(id);
        if(optionalCard.isPresent()){
            return optionalCard.get();
        }
        throw new InvalidName();
    }

    public void delete(Integer id) {
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
