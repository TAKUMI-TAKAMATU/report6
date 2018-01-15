package jp.ac.uryukyu.ie.e175744;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import java.util.*;

/**
 *ゲームクラス
 * private static int drawcard;//山札から引いた数
 * int mode//Aの数
 */
public class Game {


    private static int drawcard =4;
    String input;
    Scanner in = new Scanner(System.in);
    /**
    * メソッド。山札から初期の手札を引いた後の処理を行う
    * @param my_card 手札の合計
    * @param enemy_card 敵の手札の合計
    * @param drawcard 山札から引いた数
     */
    public void game(int my_card,int enemy_card,int drawcard,List<Integer> card_set,List<String> sp_card) {
        int A=0;
        int natural=0;
        Game g= new Game();
        Check ch =new Check();
        A+=ch.check(card_set,sp_card,0);
        A+=ch.check(card_set,sp_card,1);
        while (true) {
            if(card_set.get(0)==1&&card_set.get(1)==10){
            break;
        }else if(card_set.get(0)==10&&card_set.get(1)==1){
            break;
        }
        natural+=1;
        System.out.println("手札の合計は"+my_card+"です。");
        System.out.println("相手の手札の１枚は" + card_set.get(2) + "です。");
        System.out.println("手札を１枚追加しますか？yesかnoを入力してください。");
        input = in.nextLine();
        if(input.equals("yes") == true){
            my_card +=  card_set.get(drawcard);
            A+=ch.check(card_set,sp_card,drawcard);
            g.setDrawcard(drawcard+1);
                if(my_card>21) {
                    System.out.println("Bust!!手札が２１をこえました。あなたの負けです。");
                    break;
                }
            }else if(input.equals("no") == true){
                break;
            }else{
                System.out.println("yesかnoを入力してください。");
            }
        }

        if(enemy_card<16 && my_card<22){
            enemy_card += card_set.get(drawcard);
        }
        if(enemy_card>22){
            System.out.println("Bust!!相手の手札が２１をこえたため、あなたの勝ちです！");
        }
        if(natural>0 &&my_card<21&&enemy_card<22){
            if(ch.a_Check(A)==1){
                my_card+=10;
        }
        }
        g.judge(my_card,enemy_card,natural);
    }

    /**
    * メソッド　勝敗を決定して、それを表示する。
    * @param my_card 自分の手札の合計
    * @param enemy_card 敵の手札の合計
    * @param natural 初期の手札が２１か調べるもの
    */
    public  void judge(int my_card,int enemy_card,int natural) {

        if(my_card==11&&natural==0&&enemy_card<21){
            System.out.println("ナチュラルブラックジャック！！あなたの勝ちです。");
        }else if(my_card==21&&enemy_card<21) {
            System.out.println("ブラックジャック！！　あなたの勝ちです。");
            System.out.println("こちらの手札："+my_card +"相手の手札："+enemy_card);
        }else if(enemy_card==21&&my_card<21){
            System.out.println("ブラックジャック！！　あなたの負けです。");
            System.out.println("こちらの手札："+my_card+"相手の手札："+enemy_card);
        }else if(my_card<enemy_card &&enemy_card<22){
            System.out.println("あなたの負けです。");
            System.out.println("こちらの手札："+my_card +"相手の手札："+enemy_card);
        }else if(my_card>enemy_card &&my_card<22){
            System.out.println("あなたの勝ちです。");
            System.out.println("こちらの手札："+my_card +"相手の手札："+enemy_card);
        }else if(my_card==enemy_card){
            System.out.println("Draw!");
            System.out.println("こちらの手札："+my_card +"相手の手札："+enemy_card);
        }
    }


    /**
     * getterメソッド　
     * @return drawcard 引いた数を返す
     */
     public static int getDrawcard(){return drawcard;}

    /**
     *　setterメソッド
     * @param drawcard 引いた数
     */
     public void setDrawcard(int drawcard){ this.drawcard = drawcard; }
}

