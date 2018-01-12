package jp.ac.uryukyu.ie.e175744;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    void getDrawcard() {
        int drawcard=4;
        Game game=new Game();
        game.setDrawcard(drawcard);
        assertEquals(drawcard,Game.getDrawcard());
    }

}