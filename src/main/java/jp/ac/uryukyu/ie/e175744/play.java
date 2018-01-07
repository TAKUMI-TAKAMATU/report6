package jp.ac.uryukyu.ie.e175744;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import java.util.*;

public class play {
    List<Integer> card_set = new ArrayList<Integer>();
    public static void game() {
        String input, reply; //botへの入力文、応答文を保存するための変数
        Scanner in = new Scanner(System.in);
        int count = 0;

        while (true) {
            System.out.println();
            System.out.println("手札を交換しますか？");
            input = in.nextLine();

            break;

        }
    }

    public  List getCard_Set(){return card_set;}

    public  List<Integer> duck() {

        int count = 0;

        for (int i = 0; i < 40; i++) {
            card_set.add(i % 10 + 1);
            count += 1;
        }

        for (int j = 0; j < 12; j++) {
            card_set.add(10);
        }

        Collections.shuffle(card_set);

        return card_set;
    }



}

