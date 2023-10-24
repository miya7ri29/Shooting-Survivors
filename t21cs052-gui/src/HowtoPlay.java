
import java.awt.Font;


public class HowtoPlay extends TextDisplayState {
    public HowtoPlay(Model model) {
        super(model, new String[]{
            "敵の攻撃を避けながら敵を倒していくゲーム",
            "１：方向キーで押した方向に移動できる",
            "２：足場から落ちたらゲームオーバー",
            "３：HPが０になったらゲームオーバー",
            "４：１分生き残れたらゲームクリア",
            "５：敵を倒して経験値を集めると強化内容を選べる",
            "スタート画面戻る：PUSH　BACKSPACE"
        }, new Font("Arial", Font.BOLD, 48));
    }

    @Override
    public State processKeyTyped(String typed) {
        if (typed.equals("BS")) {
            model.setStart();
        }
        return null;
    }
}
