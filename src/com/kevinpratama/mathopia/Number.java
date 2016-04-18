package com.kevinpratama.mathopia;

import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

public class Number extends Sprite {

	private int number;
	private Text text;
	
	public Number(float pX, float pY, ITextureRegion pTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager, int number) {

		super(pX, pY, pTextureRegion, pVertexBufferObjectManager);

		this.number = number;
		
		attachText(pVertexBufferObjectManager, this.number);
	}
	
	public Number(float pX, float pY, ITextureRegion pTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager) {

		super(pX, pY, pTextureRegion, pVertexBufferObjectManager);

//		this.number = number;
		
//		attachText(pVertexBufferObjectManager, this.number);
	}
	
//	public Number(int number){
//		this.number = number;
//	}

	private void attachText(
			VertexBufferObjectManager pVertexBufferObjectManager, int number) {

		Font font;

		if (number < 100) {
			font = ResourceManager.getInstance().dozensNumberFont;
		} else if (number < 1000) {
			font = ResourceManager.getInstance().hundredsNumberFont;
		} else if (number < 10000) {
			font = ResourceManager.getInstance().thousandsNumberFont;
		} else {
			font = ResourceManager.getInstance().dozensNumberFont;
		}

		text = new Text(this.getWidth() / 2, this.getHeight() / 2, font,
				"" + number, pVertexBufferObjectManager);
		text.setColor(0.318f, 0.325f, 0.325f);

		attachChild(text);
	}
	
//	private void detachText(){
//		detachChild(text);
//	}
	
	public int getNumber(){
		return this.number;
	}
	
	public void setTextColor(float red, float green, float blue){
		text.setColor(red, green, blue);
	}

}
