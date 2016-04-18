package com.kevinpratama.mathopia;

import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

public class CreditSceneTextHolder extends Sprite {

	public CreditSceneTextHolder(float pX, float pY,
			ITextureRegion pTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager,
			ResourceManager resourceManager) {

		super(pX, pY, pTextureRegion, pVertexBufferObjectManager);

		initializeText(pVertexBufferObjectManager, resourceManager);

	}

	private void initializeText(
			VertexBufferObjectManager pVertexBufferObjectManager,
			ResourceManager resourceManager) {

		// String developedBy = "Developed By";
		// String kevinPratama = "Kevin Pratama";

		// Sprite cloud = new Sprite(this.getWidth() / 2, this.getHeight(),
		// resourceManager.cloud_region, pVertexBufferObjectManager);

		// Text developedByText = new Text(this.getWidth() / 2,
		// this.getHeight() / 2, resourceManager.font, developedBy,
		// pVertexBufferObjectManager);
		// Text kevinPratamaText = new Text(developedByText.getX(),
		// developedByText.getY() - 30, resourceManager.font,
		// kevinPratama, pVertexBufferObjectManager);
		//
		// developedByText.setColor(1, 0, 0);
		// kevinPratamaText.setColor(0, 1, 0);

		String titleDevelopedBy = "Developed By";
		String titleGraphicsBy = "Graphics By";
		String titleSoundsBy = "Sounds By";
		String titleSpecialThanks = "Special Thanks To";
		String titleAdvisor = "Advisor";
		String titleAndEngineCreator = "AndEngine Creator";
		String titleMatimDevelopment = "Matim Development";
		String titleAndEngineCookbook = "AndEngine Cookbook";
		String titleAndEngineCommunity = "AndEngine Community";
		String titleBigThanksTo = "Big Thanks To";
		String titleMyFamily = "My Family";

		String contentsDevelopedBy = "Kevin Pratama";
		String contentsGraphicsBy = "Edbert Johnson\nRicky Wiranata\nDevlin Candra";
		String contentsSoundsBy = "machinimasound.com\nfreesfx.co.uk\nsoundjay.com";
		String contentsAdvisor = "Trianggoro Wiradinata\nAlfon Wicaksi";
		String contentsAndEngineCreator = "Nicolas Gramlich";
		String contentsMatimDevelopment = "matim-dev.com";
		String contentsAndEngineCookBook = "Jayme Schroeder\nBrian Broyles";
		String contentsAndEngineCommunity = "AndEngine.org";
		String contentsMyFamily = "Father\nMother\nSister";

		Sprite developedBy = new CreditSceneText(this.getWidth() / 2,
				this.getHeight() / 2, resourceManager.cloud_region,
				pVertexBufferObjectManager, resourceManager, titleDevelopedBy,
				contentsDevelopedBy);
		Sprite graphicsBy = new CreditSceneText(this.getWidth() / 2,
				developedBy.getY() - developedBy.getHeight() - 50,
				resourceManager.cloud_region2, pVertexBufferObjectManager,
				resourceManager, titleGraphicsBy, contentsGraphicsBy);
		Sprite soundsBy = new CreditSceneText(this.getWidth() / 2,
				graphicsBy.getY() - graphicsBy.getHeight() - 50,
				resourceManager.cloud_region2, pVertexBufferObjectManager,
				resourceManager, titleSoundsBy, contentsSoundsBy);
		Sprite specialThanks = new CreditSceneText(this.getWidth() / 2,
				soundsBy.getY() - soundsBy.getHeight() - 50,
				resourceManager.cloud_region, pVertexBufferObjectManager,
				resourceManager, titleSpecialThanks);
		Sprite logo = new Sprite(this.getWidth() / 2, specialThanks.getY()
				- specialThanks.getHeight() - 50, resourceManager.logo_region,
				pVertexBufferObjectManager);
		Sprite advisor = new CreditSceneText(this.getWidth() / 2,
				logo.getY() - logo.getHeight() - 50,
				resourceManager.cloud_region2, pVertexBufferObjectManager,
				resourceManager, titleAdvisor, contentsAdvisor);
		Sprite andEngineCreator = new CreditSceneText(this.getWidth() / 2,
				advisor.getY() - advisor.getHeight() - 50,
				resourceManager.cloud_region, pVertexBufferObjectManager,
				resourceManager, titleAndEngineCreator,
				contentsAndEngineCreator);
		Sprite matimDev = new CreditSceneText(this.getWidth() / 2,
				andEngineCreator.getY() - andEngineCreator.getHeight() - 50,
				resourceManager.cloud_region, pVertexBufferObjectManager,
				resourceManager, titleMatimDevelopment,
				contentsMatimDevelopment);
		Sprite andEngineCookbook = new CreditSceneText(this.getWidth() / 2,
				matimDev.getY() - matimDev.getHeight() - 50,
				resourceManager.cloud_region2, pVertexBufferObjectManager,
				resourceManager, titleAndEngineCookbook,
				contentsAndEngineCookBook);
		Sprite andEngineCommunity = new CreditSceneText(this.getWidth() / 2,
				andEngineCookbook.getY() - andEngineCookbook.getHeight() - 50,
				resourceManager.cloud_region, pVertexBufferObjectManager,
				resourceManager, titleAndEngineCommunity,
				contentsAndEngineCommunity);
		Sprite bigThanksTo = new CreditSceneText(
				this.getWidth() / 2,
				andEngineCommunity.getY() - andEngineCommunity.getHeight() - 50,
				resourceManager.cloud_region, pVertexBufferObjectManager,
				resourceManager, titleBigThanksTo);
		Sprite myFamily = new CreditSceneText(this.getWidth() / 2,
				bigThanksTo.getY() - bigThanksTo.getHeight() - 50,
				resourceManager.cloud_region2, pVertexBufferObjectManager,
				resourceManager, titleMyFamily, contentsMyFamily);

		this.attachChild(developedBy);
		this.attachChild(graphicsBy);
		this.attachChild(soundsBy);
		this.attachChild(specialThanks);
		this.attachChild(logo);
		this.attachChild(advisor);
		this.attachChild(andEngineCreator);
		this.attachChild(matimDev);
		this.attachChild(andEngineCookbook);
		this.attachChild(andEngineCommunity);
		this.attachChild(bigThanksTo);
		this.attachChild(myFamily);
	}

}
