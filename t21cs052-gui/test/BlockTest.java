import static org.junit.Assert.*;

import org.junit.Test;

public class BlockTest {

	@Test
	public void 足場が指定した座標と幅を保持しているか確認(){
		Block b = new Block(10,10,10);
		assertEquals(10,b.getX());
		assertEquals(10,b.getY());
		assertEquals(10,b.getWidth());
	}
	
	

}
