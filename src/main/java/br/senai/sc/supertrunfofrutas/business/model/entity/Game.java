package br.senai.sc.supertrunfofrutas.business.model.entity;

import java.util.Random;

public class Game {
    private static Random generator = new Random();
    private static int player;
    private static Person personModel;
    public static void startGame(){
        Deck.separateCards();
        whoStarts();
        do {
            if (player == 0) {
                playerPlays();
                player = 1;
            } else {
                computerPlays();
                player = 0;
            }
        }while(Deck.getCardPlayer().size() > 0 || Deck.getCardComputer().size() > 0);
        if (Deck.getCardPlayer().size() == 0) {
            personModel.setQtyLosses();
        } else {
            personModel.setQtyVitories();
        }
    }
    public static void whoStarts(){
        player = generator.nextInt(2);
    }
    public static void computerPlays(){
        int randomAttribute = generator.nextInt(5);
        match(randomAttribute + 1);
    }
    public static void playerPlays(){
        int attribute = 0;
        match(attribute);
    }
    public static void match(int attribute){
        boolean wonRound = Card.compareAttributes(attribute);
        if(wonRound){
            Deck.playerWonRound();
        } else {
            Deck.computerWonRound();
        }
    }
    public static int getPlayer() {
        return player;
    }
}
