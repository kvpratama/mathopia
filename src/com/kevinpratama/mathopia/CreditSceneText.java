package com.kevinpratama.mathopia;

import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.adt.align.HorizontalAlign;

public class CreditSceneText extends Sprite {

	public CreditSceneText(float pX, float pY, ITextureRegion pTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager,
			ResourceManager resourceManager, String title, String content) {

		super(pX, pY, pTextureRegion, pVertexBufferObjectManager);

		// String content = "";
		//
		// for (int i = 0; i < contents.length; i++) {
		// content += contents[i];
		// }

		Text titleText = new Text(this.getWidth() / 2, this.getHeight() / 2,
				resourceManager.segoeFont, title, new TextOptions(
						HorizontalAlign.CENTER), pVertexBufferObjectManager);
		Text contentsText = new Text(this.getWidth() / 2, this.getHeight() / 2,
				resourceManager.curlzFont, content, new TextOptions(
						HorizontalAlign.CENTER), pVertexBufferObjectManager);

		titleText.setColor(0.385f, 0.4813f, 0.1332f);
		contentsText.setColor(0.647f, 0.808f, 0.224f);

		if (this.getHeight() < titleText.getHeight() + contentsText.getHeight()
				+ 150) {
			this.setHeight(titleText.getHeight() + contentsText.getHeight()
					+ 150);
			this.setWidth(this.getWidth() + this.getHeight());
		}
		if (this.getWidth() < titleText.getWidth() + 100) {
			this.setWidth(titleText.getWidth() + 100);
		}
		if (this.getWidth() < contentsText.getWidth() + 100) {
			this.setWidth(contentsText.getWidth() + 100);
		}

		titleText.setPosition(this.getWidth() / 2,
				this.getHeight() - titleText.getHeight() - 40);
		contentsText.setPosition(titleText.getX(), titleText.getY()
				- contentsText.getHeight() / 2 - 30);

		this.attachChild(titleText);
		this.attachChild(contentsText);

		// Text kevinPratamaText = new Text(developedByText.getX(),
		// developedByText.getY() - 30, resourceManager.font,
		// kevinPratama, pVertexBufferObjectManager);
	}

	public CreditSceneText(float pX, float pY, ITextureRegion pTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager,
			ResourceManager resourceManager, String title) {

		super(pX, pY, pTextureRegion, pVertexBufferObjectManager);

		Text titleText = new Text(this.getWidth() / 2, this.getHeight() / 2,
				resourceManager.titleFont, title, new TextOptions(
						HorizontalAlign.CENTER), pVertexBufferObjectManager);

		titleText.setColor(0.385f, 0.4813f, 0.1332f);

		this.setHeight(titleText.getHeight() + 200);
		this.setWidth(titleText.getWidth() + 250);

		titleText.setPosition(this.getWidth() / 2,
				this.getHeight() /2);

		this.attachChild(titleText);

		// Text kevinPratamaText = new Text(developedByText.getX(),
		// developedByText.getY() - 30, resourceManager.font,
		// kevinPratama, pVertexBufferObjectManager);
	}

}
