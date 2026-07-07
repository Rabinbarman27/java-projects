package Tic_Tac_Toe;

import java.util.ArrayList;

public class Scoreboard {

    private ArrayList<Integer> scoreX = new ArrayList<>();
    private ArrayList<Integer> scoreO = new ArrayList<>();

    public int viewWinsX() {
        return scoreX.size();
    }

    public int viewWinsO() {
        return scoreO.size();
    }

    public void addWinX() {
        scoreX.add(1);
    }

    public void addWinO() {
        scoreO.add(1);
    }
}
