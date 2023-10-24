import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class StartState implements State {
    private Model model;

  
    public StartState(Model model) {
        this.model = model;
    }

    @Override
    public State processTimeElapsed(int msec) {
       
        return null;
    }

    @Override
    public State processKeyTyped(String typed) {
        // キー入力による操作を行う
        if (typed.equals("ENTER")) {
            // ENTERキーが押された場合、ゲームプレイ画面に遷移
            model.setGamePlaying();
        } else if (typed.equals("BS")) {
            // BSキーが押された場合、遊び方画面に遷移
            model.setHowtoPlay();
        }

        return null;
    }

    @Override
    public State processMousePressed(int x, int y) {
       
        return null;
    }

   
    @Override
    public void paintComponent(Graphics g) {
        // タイトルの表示
        String title = "Shooting Survivors";
        Font titleFont = new Font("Arial", Font.BOLD, 60);
        g.setFont(titleFont);
        int titleX = 320;
        int titleY = 200;
        g.setColor(Color.GREEN);
        g.drawString(title, titleX, titleY);

        // 遊び方の表示
        String howToPlay = "遊び方 : press BackSpace";
        Font howToPlayFont = new Font("Arial", Font.BOLD, 40);
        g.setFont(howToPlayFont);
        int howToPlayX = 320;
        int howToPlayY = 600;
        g.setColor(Color.BLACK);
        g.drawString(howToPlay, howToPlayX, howToPlayY);

        // ゲーム開始の表示
        String start = "始める : press Enter";
        g.setFont(howToPlayFont);
        int startX = 320;
        int startY = 400;
        g.setColor(Color.BLACK);
        g.drawString(start, startX, startY);
    }
}