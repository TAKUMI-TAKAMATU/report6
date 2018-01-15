package jp.ac.uryukyu.ie.e175744;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 山札クラス
 * List<Integer> card_set;//トランプの山札
 * List<String> sp_card;//１０以上のときの画面に表示する絵柄　
 */
public class Duck {
    List<Integer> card_set = new ArrayList<Integer>();
    List<String> sp_card = new ArrayList<String>();
    /**
     *メソッド　トランプの山札を作る。ブラックジャックでは１０以上の数字は１０とする。
     */
    public List<Integer> duck() {
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
     * メソッド　山札から１０が出たときの画面に表示する絵柄をランダムにする
     *@return sp_card シャッフルされた絵柄の入ったリスト
     */
    public List<String> spName(){
        for (int n=0;n<4;n++){
            sp_card.add("10");
            sp_card.add("J");
            sp_card.add("Q");
            sp_card.add("K");
        }
        Collections.shuffle(sp_card);
        return sp_card;
    }
}
