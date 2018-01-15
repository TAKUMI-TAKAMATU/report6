package jp.ac.uryukyu.ie.e175744;

import java.util.List;
import java.util.Scanner;

public class Check {
   private int A=0;
    /** メソッド　引いた手札を調べて対応した文を出力する
     * @param card_set　山札
     * @param sp_card　１０を引いたとき表示する絵柄
     * @param drawcard　引いた数
     * @return mode Aを引いた数
     */
    public int check(List<Integer> card_set, List<String> sp_card, int drawcard) {

        if(card_set.get(drawcard)==10){
            System.out.println(sp_card.get(drawcard)+"を引いた！");
        }else if (card_set.get(drawcard)==1) {
            System.out.println("Aを引いた！Aは１１と１のどちらかで使用できます。");
            System.out.println("デフォルトでは１とします。");
            A+=1;
        }else{
            System.out.println(card_set.get(drawcard) + "を引いた！");
        }
        return A;
    }

    public int a_Check(int A){
        this.A=A;
        int A_check=0;
        String input;
        Scanner in = new Scanner(System.in);
        if(A>0){
            System.out.println("Aがあります。Aは現在１としてカウントされています。");
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

        return A_check;
    }
}
