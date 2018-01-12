package jp.ac.uryukyu.ie.e175744;


import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String args[]) {

       Game a = new Game();

        List<Integer> card_set = a.duck();
        List<String> sp_card = a.SpName(card_set);
        int my_card = card_set.get(0) + card_set.get(1);
        int enemy_card = card_set.get(2) + card_set.get(3);
        if(a.Check(card_set,sp_card,0,my_card)==1){
            my_card+=10;
        }
        if(a.Check(card_set,sp_card,1,my_card)==1){
            my_card+=10;
        }
      a.game(my_card,enemy_card,a.getDrawcard());
    }
}
