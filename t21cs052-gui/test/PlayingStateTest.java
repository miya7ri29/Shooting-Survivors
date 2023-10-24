import static org.junit.Assert.*;
import org.junit.Test;

public class PlayingStateTest {

    @Test
    public void 弾の追加が正しく行われるかを確認するテスト() {
        Model model = new Model();
        PlayingState playingState = new PlayingState(model);

        // 初期状態では弾が0個
        assertEquals(0, model.getBullets().getBullets().size());

        // 弾を追加
        playingState.processTimeElapsed(1000);

        // 弾が1つ追加されているかを確認
        assertEquals(1, model.getBullets().getBullets().size());
    }

    @Test
    public void 敵の追加が正しく行われるかを確認するテスト() {
        Model model = new Model();
        PlayingState playingState = new PlayingState(model);

        // 初期状態では敵が0体
        assertEquals(0, model.getEnemys().getEnemys().size());

        // 敵を追加
        playingState.processTimeElapsed(1000);

        // 敵が1体追加されているかを確認
        assertEquals(1, model.getEnemys().getEnemys().size());
    }

    @Test
    public void 敵の弾の追加が正しく行われるかを確認するテスト() {
        Model model = new Model();
        PlayingState playingState = new PlayingState(model);

        // 初期状態では敵の弾が0個
        assertEquals(0, model.getEnemyBullets().getEnemyBullets().size());

        // 敵の弾を追加
        playingState.processTimeElapsed(1000);

        // 敵の弾が1つ追加されているかを確認
        assertEquals(1, model.getEnemyBullets().getEnemyBullets().size());
    }

    @Test
    public void キャラクターの位置が正しく更新されるかを確認するテスト() {
        Model model = new Model();
        PlayingState playingState = new PlayingState(model);

        // キャラクターの初期位置を設定
        model.setCharacter(new Character(100, 100));

        // キャラクターを移動
        playingState.processKeyTyped("RIGHT");

        // キャラクターの位置が正しく更新されているかを確認
        assertEquals(120, model.getCharacter().getX());
    }

  
}