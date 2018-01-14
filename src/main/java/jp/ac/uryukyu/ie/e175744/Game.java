package jp.ac.uryukyu.ie.e175744;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import java.util.*;

/**
 *ゲームクラス
 * List<Integer> card_set;//トランプの山札
 * List<String> sp_card;//１０以上のときの画面に表示する絵柄
 * private static int drawcard;//山札から引いた数
 * int mode//Aの数
 */
public class Game {

    List<Integer> card_set = new ArrayList<Integer>();
    List<String> sp_card = new ArrayList<String>();
    private static int drawcard =4;
    int mode=0;
    String input;
    Scanner in = new Scanner(System.in);
    /**
    * メソッド。山札から初期の手札を引いた後の処理を行う
    * @param my_card 手札の合計
    * @param enemy_card 敵の手札の合計
    * @param drawcard 山札から引いた数
     */
    public void game(int my_card,int enemy_card,int drawcard) {
        int natural=0;
        Game game= new Game();
        while (true) {
            if(card_set.get(0)==1&&card_set.get(1)==10){
            break;
        }else if(card_set.get(0)==10&&card_set.get(1)==1){
            break;
        }
        natural+=1;
        System.out.println("手札の合計は"+my_card+"です。");
        System.out.println("相手の手札の１枚は" + card_set.get(2) + "です。");
        System.out.println("手札を１枚追加しますか？");
        input = in.nextLine();
        if(input.equals("yes") == true){
            my_card +=  card_set.get(drawcard);
            game.Check(card_set,sp_card,drawcard);
            game.setDrawcard(drawcard+1);
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
        if(enemy_card<16&&my_card<22){
            enemy_card+=card_set.get(drawcard);
        }
        if(enemy_card>21){
            System.out.println("Bust!!相手の手札が２１をこえたため、あなたの勝ちです！");
        }
        if(natural>0 &&my_card<21){
        for(int A=Game.A_check(mode);A>0;A-=1){
            my_card+=10;
        }
        }
        game.judge(my_card,enemy_card,natural);
    }
    /**
    *メソッド　トランプの山札を作る。ブラックジャックでは１０以上の数字は１０とする。
    */
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
        }else if(enemy_card==21&&my_card<21){
            System.out.println("ブラックジャック！！　あなたの負けです。");
        }else if(my_card<enemy_card &&enemy_card<22){
            System.out.println("あなたの負けです。");
        }else if(my_card>enemy_card &&my_card<22){
            System.out.println("あなたの勝ちです。");
        }else if(my_card==enemy_card){
            System.out.println("Draw!");
        }
    }
    /**
    * メソッド　山札から１０が出たときの画面に表示する絵柄をランダムにする
    *@return sp_card シャッフルされた絵柄の入ったリスト
    */
    public List<String> SpName(){
        for (int n=0;n<4;n++){
            sp_card.add("10");
            sp_card.add("J");
            sp_card.add("Q");
            sp_card.add("K");
        }
        Collections.shuffle(sp_card);
        return sp_card;
    }

    /** メソッド　引いた手札を調べて対応した文を出力する
     * @param card_set　山札
     * @param sp_card　１０を引いたとき表示する絵柄
     * @param drawcard　引いた数
     * @return mode Aを引いた数
     */
    public int Check(List<Integer> card_set,List<String> sp_card,int drawcard) {
        if(card_set.get(drawcard)==10){
            System.out.println(sp_card.get(drawcard)+"を引いた！");
        }else if (card_set.get(drawcard)==1) {
            System.out.println("Aを引いた！Aは１１と１のどちらかで使用できます。");
            System.out.println("デフォルトでは１とします。");
            mode+=1;
            }else{
                System.out.println(card_set.get(drawcard) + "を引いた！");
            }
            return mode;
        }

    /**
     * メソッド　Aを引いた際に
     * @param mode Aが出ている数をカウントしている。
     * @return A_check Aを１１にした数
     */
    public static int A_check(int mode){
        int A_check=0;
        String input;
        Scanner in = new Scanner(System.in);
        if(mode>0){
        System.out.println("Aが"+mode+"あります。Aは現在１としてカウントされています。");
        for (int a=mode;a>0;a-=1){
            System.out.println("Aを１枚１１にしますか？yesかnoを入力してください" );
            while (true) {
                input = in.nextLine();
                if (input.equals("yes") == true) {
                    A_check+=1;
                    break;
                } else if (input.equals("no") == true) {
                    break;
                } else {
                    System.out.println("yesかnoを入力してください");
                    }
                }
            }
        }
        return A_check;
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

