import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class StrengthenCharacter implements State {
    private Model model;

   
    public StrengthenCharacter(Model model) {
        this.model = model;
    }

    @Override
    public State processTimeElapsed(int msec) {
       
        return null;
    }

    @Override
    public State processKeyTyped(String typed) {
        // キー入力による操作を行う
      
        if (typed.equals("SHIFT")) {
            // SHIFTキーが押された場合、弾の連射速度をUPさせる
            model.getBullets().UpRateOfFire();
            model.setGamePlaying();
        } else if (typed.equals("CTRL")) {
            // CTRLキーが押された場合、弾の速度をUPさせる
            model.getBullets().UpSpeed();
            model.setGamePlaying();
        } else if (typed.equals("ESC")) {
            // ESCキーが押された場合、プレイヤーの体力を回復させる
            model.getCharacter().UpHp();
            model.setGamePlaying();
        }

        return null;
    }

    @Override
    public State processMousePressed(int x, int y) {
      
        return null;
    }

  
    @Override
    public void paintComponent(Graphics g) {
    
     
        String s2 = "連射速度UP：PUSH SHIFTキー";
        String s3 = "弾速UP：PUSH CTRLキー";
        String s4 = "体力回復：PUSH ESCキー";

        // フォントの設定
        Font font = new Font("Arial", Font.BOLD, 60);
        g.setFont(font);

      
       
        int c = 200;
        int d = 300;
        int e = 200;
        int f = 400;
        int h = 200;
        int i = 500;

        // 文字色の設定
        g.setColor(Color.RED);

        // 文字列の描写
      
        g.drawString(s2, c, d);
        g.drawString(s3, e, f);
        g.drawString(s4, h, i);
    }
}