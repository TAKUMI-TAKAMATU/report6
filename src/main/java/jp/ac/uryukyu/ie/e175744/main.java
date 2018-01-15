package jp.ac.uryukyu.ie.e175744;


import java.util.List;

public class main {
    public static void main(String args[]) {

       Game g = new Game();
       Duck d = new Duck();
       Check ch =new Check();

        List<Integer> card_set = d.duck();
        List<String> sp_card = d.spName();
        int my_card = card_set.get(0) + card_set.get(1);
        int enemy_card = card_set.get(2) + card_set.get(3);

      g.game(my_card,enemy_card,g.getDrawcard(),card_set,sp_card);
    }
}
