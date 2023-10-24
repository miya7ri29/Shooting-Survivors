import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;

public class GameOverState implements State {
    private Model model;
    private Image gameoverimage;
    private View view;

    // コンストラクタ（ゲームオーバー画像の読み込み）
    public GameOverState(Model model) {
        this.gameoverimage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("text_gameover_j.png"));
    }

    // コンストラクタ（ランキングを更新する場合）
    public GameOverState(Model model, ArrayList<Integer> ranking) {
        this.model = model;
        this.gameoverimage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("text_gameover_j.png"));

        try {
            // ランキングを更新
            model.getRanking().update(model.getCharacter().getExp());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public State processTimeElapsed(int msec) {
       
        return null;
    }

    @Override
    public State processKeyTyped(String typed) {
    	if (typed.equals("BS")) {
            model.setStart();
        }
        return null;
    }

    @Override
    public State processMousePressed(int x, int y) {
    
        return null;
    }

   
    @Override
    public void paintComponent(Graphics g) {
        // ゲームオーバー画像の描画
        g.drawImage(gameoverimage, 400, 200, view);

        // フォントとカラーの設定
        Font font = new Font("Arial", Font.BOLD, 20);
        g.setFont(font);
        g.setColor(Color.black);

        // プレイヤーの獲得経験値とトップ5のランキングの表示
        g.drawString("Your Experience Points: " + model.getCharacter().getExp(), 400, 500);

        ArrayList<Integer> ranking = model.getRanking().getRanking();
        g.drawString("Top Five Scores:", 400, 350);
        for (int i = 0; i < Math.min(5, ranking.size()); i++) {
            g.drawString(String.valueOf(ranking.get(i)), 400, 400 + i * 20);
        }
    }
}