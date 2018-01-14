package jp.ac.uryukyu.ie.e175744;


import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String args[]) {

       Game game = new Game();

        List<Integer> card_set = game.duck();
        List<String> sp_card = game.SpName();
        int my_card = card_set.get(0) + card_set.get(1);
        int enemy_card = card_set.get(2) + card_set.get(3);
        game.Check(card_set,sp_card,0);
        game.Check(card_set,sp_card,1);
      game.game(my_card,enemy_card,game.getDrawcard());
    }
}
