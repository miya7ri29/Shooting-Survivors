import static org.junit.Assert.*;
import org.junit.Test;

public class EnemysTest {

    @Test
    public void 敵の追加が正しく行われるかを確認するテスト() {
        Model model = new Model();
        Enemys enemys = new Enemys(model);

        // 初期状態では敵が0体
        assertEquals(0, enemys.getEnemys().size());

        // 敵を追加
        enemys.add(System.currentTimeMillis());

        // 敵が1体追加されているかを確認
        assertEquals(1, enemys.getEnemys().size());
    }
}
  