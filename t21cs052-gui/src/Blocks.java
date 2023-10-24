import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

public class Blocks {

	private LinkedList<Block> blocks;

	public Blocks() {
		  // ブロックを作成してリストに追加
		blocks = new LinkedList<>();
		Block b1 = new Block(300, 300, 200);
		Block b2 = new Block(100, 400, 280);
		Block b3 = new Block(300, 600 , 200);
		Block b4 = new Block(500, 550, 200);
		Block b5 = new Block(700, 450, 200);
		Block b6 = new Block(900, 550, 200);
		Block b7 = new Block(900, 350, 200);
		Block b8 = new Block(500, 200, 200);
	
		
		blocks.add(b4);
		blocks.add(b3);
		blocks.add(b2);
		blocks.add(b1);
		blocks.add(b5);
		blocks.add(b6);
		blocks.add(b7);
		blocks.add(b8);
	
	}

	public void drawBlock(Graphics g) {
		for (Block b : blocks) {
			  // ブロックを描画
			g.drawRect(b.getX(), b.getY(), b.getWidth(), 10);
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(b.getX(), b.getY(), b.getWidth(), 10);
		}

	}

	   public boolean isCharacterOnBlock(Character character) {
	        int characterX = character.getX();
	        int characterY = character.getY();

	        for (Block block : blocks) {
	            int blockX = block.getX();
	            int blockY = block.getY();
	            int blockWidth = block.getWidth();
	            int blockHeight = 10; 
	            // キャラクターがブロックの上にいるかを判定
	            if (characterX + 50 >= blockX && characterX + 70 <= blockX + blockWidth
	                    && characterY <= blockY + blockHeight && characterY + 70 >= blockY) {
	                return true;
	            }
	        }

	        return false;
	    }


}
