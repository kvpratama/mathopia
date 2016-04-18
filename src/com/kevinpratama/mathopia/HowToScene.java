package com.kevinpratama.mathopia;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;

import com.kevinpratama.mathopia.SceneManager.SceneType;

public class HowToScene extends BaseScene implements IOnMenuItemClickListener{

	private MenuScene creditMenuScene;
	private final int MENU_BACK = 0;
	
	@Override
	public void createScene() {
		// TODO Auto-generated method stub
		createBackground();
		createHowTo();
		createCreditMenuScene();
	}

	@Override
	public void onBackKeyPressed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SceneType getSceneType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void disposeScene() {
		// TODO Auto-generated method stub
		
	}
	
	private void createBackground() {
		// TODO Auto-generated method stub
		attachChild(new Sprite(640, 400,
				resourcesManager.stage_menu_background_region, vbom) {
			@Override
			protected void preDraw(GLState pGLState, Camera pCamera) {
				// TODO Auto-generated method stub
				super.preDraw(pGLState, pCamera);
				pGLState.enableDither();
			}
		});
	}
	
	private void createHowTo() {
		// TODO Auto-generated method stub
		attachChild(new Sprite(740, 400,
				resourcesManager.howTo_region, vbom) {
			@Override
			protected void preDraw(GLState pGLState, Camera pCamera) {
				// TODO Auto-generated method stub
				super.preDraw(pGLState, pCamera);
				pGLState.enableDither();
			}
		});
	}
	
	private void createCreditMenuScene() {
		creditMenuScene = new MenuScene(camera);
		creditMenuScene.setPosition(0, 0);

		final IMenuItem backMenuItem = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_BACK,
						resourcesManager.back_button_region, vbom), 1.2f, 1);

		creditMenuScene.addMenuItem(backMenuItem);

		creditMenuScene.buildAnimations();
		creditMenuScene.setBackgroundEnabled(false);

		backMenuItem.setPosition(150, 100);

		creditMenuScene.setOnMenuItemClickListener(this);

		setChildScene(creditMenuScene);
	}

	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
			float pMenuItemLocalX, float pMenuItemLocalY) {
		// TODO Auto-generated method stub
		resourcesManager.buttonSound.play();
		switch (pMenuItem.getID()) {
		case MENU_BACK:
			SceneManager.getInstance().setStageMenuScene();
			return true;
		default:
			return false;
		}
	}

}
