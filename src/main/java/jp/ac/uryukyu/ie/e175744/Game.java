package jp.ac.uryukyu.ie.e175744;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import java.util.*;

public class Game {
    List<Integer> card_set = new ArrayList<Integer>();
    List<String> sp_card = new ArrayList<String>();
    private static int drawcard =4;
    String input;

    public void game(int my_card,int enemy_card,int drawcard) {
        Game a = new Game();
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("手札の合計は"+my_card+"です。");
            System.out.println(enemy_card);
            System.out.println("相手の手札の１枚は" + card_set.get(2) + "です。");
            if(my_card==21){
                break;
            }else if(enemy_card==21){
                break;
            }
            System.out.println("手札を交換しますか？");
            input = in.nextLine();
            if(input.equals("yes") == true){
                my_card +=  card_set.get(drawcard);
                if(a.Check(card_set,sp_card,1,my_card)==1){
                    my_card+=10;
                }
                drawcard++;
                if(my_card>21) {
                    System.out.println("dauto!!");
                    break;
                }
            }else if(input.equals("no") == true){
                break;
            }else{
                System.out.println("yesかnoを入力してください。");
            }
        }
        if(enemy_card<16){
            enemy_card+=card_set.get(drawcard);
        }if(enemy_card>21){
            System.out.println("dauto!!");
        }
        a.judge(my_card,enemy_card,drawcard);

    }



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

    public  void judge(int my_card,int enemy_card,int drawcard) {


        if(my_card==21&&drawcard==4&&enemy_card<21){
            System.out.println("ナチュラルブラックジャック！！あなたの勝ちです。");
        }else if(enemy_card==21&&drawcard==4&&my_card<21){
            System.out.println("ナチュラルブラックジャック！！あなたの負けです。");
        }else if(my_card==21) {
            System.out.println("ブラックジャック！！　あなたの勝ちです。");
        }else if(enemy_card==21){
            System.out.println("ブラックジャック！！　あなたの負けです。");
        }else if(my_card<enemy_card &&enemy_card<22){
            System.out.println("あなたの負けです。");
        }else if(my_card>enemy_card &&my_card<22){
            System.out.println("あなたの勝ちです。");
        }else if(my_card==enemy_card){
            System.out.println("Draw!");
        }
    }

    public List<String> SpName(List<Integer> card_set){
        for (int n=0;n<4;n++){
            sp_card.add("10");
            sp_card.add("J");
            sp_card.add("Q");
            sp_card.add("K");
        }
        Collections.shuffle(sp_card);
        return sp_card;
    }

    public int Check(List<Integer> card_set,List<String> sp_card,int drawcard,int my_card) {
        Scanner in = new Scanner(System.in);
       int mode=0;
        if(card_set.get(drawcard)==10){
            System.out.println(sp_card.get(drawcard)+"を引いた！");
        }else if (card_set.get(drawcard)==1) {
            System.out.println("Aを引いた！Aは１１と１のどちらかで使用できます。");
            System.out.println("使用したい番号を数字で入力してください。");
            while (true) {
                input = in.nextLine();
                if (input.equals("1") == true) {
                    break;
                } else if (input.equals("11") == true) {
                  mode+=1;
                          break;
                } else {
                    System.out.println("1か11を入力してください");
                }}
            }else{
                System.out.println(card_set.get(drawcard) + "を引いた！");
            }
        return mode;
        }
     public static int getDrawcard(){return drawcard;}
     public void setDrawcard(int drawcard){ this.drawcard = drawcard; }
}

