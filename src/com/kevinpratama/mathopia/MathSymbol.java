package com.kevinpratama.mathopia;

import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

public class MathSymbol extends Sprite{
	
	private String symbol = "=+-X:";
	
	public MathSymbol(float pX, float pY, ITextureRegion pTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager, String symbol) {

		super(pX, pY, pTextureRegion, pVertexBufferObjectManager);

		this.symbol = symbol;
		
		attachText(pVertexBufferObjectManager, this.symbol);
	}
	
	private void attachText(
			VertexBufferObjectManager pVertexBufferObjectManager, String symbol) {

		Font font = ResourceManager.getInstance().dozensNumberFont;


		Text text = new Text(this.getWidth() / 2, this.getHeight() / 2, font,
				"" + symbol, pVertexBufferObjectManager);
		text.setColor(0.318f, 0.325f, 0.325f);

		attachChild(text);
	}
	
}
