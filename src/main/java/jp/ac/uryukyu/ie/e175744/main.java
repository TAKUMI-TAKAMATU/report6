package jp.ac.uryukyu.ie.e175744;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String args[]) {
        // 盤面状態

        //play.player();
        //play.MyCard();
        play a = new play();

        List<Integer> card_set = a.duck();

        int my_card = card_set.get(0) + card_set.get(1);
        int enemy_card = card_set.get(2) + card_set.get(3);
        int enemy_card_show = card_set.get(2);
        String input, reply;
        int drawcard =4;
        
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("現在の私の手札は" + my_card + "です。");
            System.out.println(enemy_card);
            System.out.println("相手の手札の１枚は" + enemy_card_show + "です。");

            System.out.println("手札を交換しますか？");
            input = in.nextLine();
            if(input.equals("yes") == true){
                 my_card = my_card+ card_set.get(drawcard);
                 drawcard++;
            }else if(input.equals("no") == true){
                break;
            }else{
                System.out.println("yesかnoを入力してください。");
            }

        }
    }
}
