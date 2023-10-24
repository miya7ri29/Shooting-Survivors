
import java.awt.Font;


public class GameClear extends TextDisplayState {
    public GameClear(Model model) {
        super(model, new String[]{"GameClear", "スタート画面戻る：PUSH　ENTER"}, new Font("Arial", Font.BOLD, 60));
    }

    @Override
    public State processKeyTyped(String typed) {
        if (typed.equals("ENTER")) {
            model.setStart();
        }
        return null;
    }
}