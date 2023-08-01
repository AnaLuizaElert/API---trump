package br.senai.sc.supertrunfofrutas.business.model.entity;

import br.senai.sc.supertrunfofrutas.business.service.CardService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private static List<Card> cardPlayer = new ArrayList<>();
    private static List<Card> cardComputer = new ArrayList<>();

    private static Card cardPlayerModel;
    private static Card cardComputerModel;
    private static CardService cardService;

    public static void separateCards(){
        List<Card> allCards = cardService.listAll();
        Collections.shuffle(allCards);
        for(int i  = 0; i < allCards.size(); i ++){
            cardPlayer.add(allCards.get(i));
            i ++;
            cardComputer.add(allCards.get(i));
        }
    }

    public static void playerWonRound() {
        createCardsModel();
        addCardUser(cardComputerModel);
        removeCardComputer();
        removeCardUser();
        addCardUser(cardPlayerModel);
    }

    public static void computerWonRound() {
        createCardsModel();
        addCardComputer(cardPlayerModel);
        removeCardUser();
        removeCardComputer();
        addCardComputer(cardComputerModel);
    }

    private static void createCardsModel(){
        cardPlayerModel = cardPlayer.get(0);
        cardComputerModel = cardComputer.get(0);
    }

    private static void addCardUser(Card card){
        cardPlayer.add(card);
    }

    private static void addCardComputer(Card card){
        cardComputer.add(card);
    }

    private static void removeCardUser(){
        cardPlayer.remove(0);
    }

    private static void removeCardComputer(){
        cardComputer.remove(0);
    }

    public static List<Card> getCardPlayer() {
        return cardPlayer;
    }

    public static List<Card> getCardComputer() {
        return cardComputer;
    }
}
