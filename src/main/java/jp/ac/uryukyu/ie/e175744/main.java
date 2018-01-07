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

        int[] enemy = new int[7];
        int my_card = card_set.get(0) + card_set.get(1);
        int enemy_card = card_set.get(2) + card_set.get(3);
        int enemy_card_show = card_set.get(2);
        String input, reply;

        System.out.println("現在の私の手札は" + my_card + "です。");
        System.out.println(enemy_card);
        System.out.println("相手の手札の１枚は" + enemy_card_show + "です。");
        Scanner in = new Scanner(System.in);
        int count = 0;

        while (true) {
            System.out.println();
            System.out.println("手札を交換しますか？");
            input = in.nextLine();

            break;
        }
    }
}
