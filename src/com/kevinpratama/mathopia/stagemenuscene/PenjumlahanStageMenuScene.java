package com.kevinpratama.mathopia.stagemenuscene;

import java.util.List;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.modifier.LoopEntityModifier;
import org.andengine.entity.modifier.ScaleModifier;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.util.GLState;

import com.kevinpratama.mathopia.BaseScene;
import com.kevinpratama.mathopia.GameManager;
import com.kevinpratama.mathopia.SceneManager;
import com.kevinpratama.mathopia.SceneManager.SceneType;
import com.kevinpratama.mathopia.datamanager.Stage;

public class PenjumlahanStageMenuScene extends BaseScene implements
		IOnMenuItemClickListener {

	private MenuScene penjumlahanStageMenuScene;
	public static final int MENU_PENJUMLAHAN_1 = 1;
	public static final int MENU_PENJUMLAHAN_2 = 2;
	public static final int MENU_PENJUMLAHAN_3 = 3;
	public static final int MENU_PENJUMLAHAN_4 = 4;
	public static final int MENU_PENJUMLAHAN_5 = 5;
	public static final int MENU_PENJUMLAHAN_6 = 6;
	public static final int MENU_PENJUMLAHAN_7 = 7;
	public static final int MENU_PENJUMLAHAN_8 = 8;
	public static final int MENU_PENJUMLAHAN_9 = 9;
	public static final int MENU_PENJUMLAHAN_10 = 10;
	public static final int MENU_BACK = 11;

	private final List<Stage> penjumlahanStage;
	
	public PenjumlahanStageMenuScene(List<Stage> penjumlahanStages) {
		// TODO Auto-generated constructor stub
		this.penjumlahanStage = penjumlahanStages;
		createPenjumlahanMenuChildScene();
	}

	@Override
	public void createScene() {
		// TODO Auto-generated method stub
		createBackground();
		// createStageMenuText();
	}

	@Override
	public void onBackKeyPressed() {
		// TODO Auto-generated method stub
		gTracker.sendEvent("native back key", "user clicked native back key", "native back key penjumlahan stage menu scene", (long) 0);
	}

	@Override
	public SceneType getSceneType() {
		// TODO Auto-generated method stub
		return SceneType.SCENE_MENU;
	}

	@Override
	public void disposeScene() {
		// TODO Auto-generated method stub

	}

	private void createBackground() {
		// TODO Auto-generated method stub
		attachChild(new Sprite(640, 400,
				resourcesManager.penjumlahan_stage_menu_background_region, vbom) {
			@Override
			protected void preDraw(GLState pGLState, Camera pCamera) {
				// TODO Auto-generated method stub
				super.preDraw(pGLState, pCamera);
				pGLState.enableDither();
			}
		});
	}

	private void createPenjumlahanMenuChildScene() {
		penjumlahanStageMenuScene = new MenuScene(camera);
		// penjumlahanStageMenuScene.setPosition(0, 0);

		final IMenuItem[] penjumlahanMenu = new IMenuItem[10];
		final IMenuItem backButton = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_BACK,
						resourcesManager.back_button_region, vbom), 1.2f, 1);
		ITiledTextureRegion medal_region = resourcesManager.stage_medal_region;
		AnimatedSprite[] medals = new AnimatedSprite[10];
		AnimatedSprite medal = new AnimatedSprite(0, 0, medal_region, vbom);

		penjumlahanMenu[0] = new ScaleMenuItemDecorator(new SpriteMenuItem(
				MENU_PENJUMLAHAN_1, resourcesManager.stage_select_1_region,
				vbom), 1.2f, 1);
		penjumlahanMenu[1] = new ScaleMenuItemDecorator(new SpriteMenuItem(
				MENU_PENJUMLAHAN_2, resourcesManager.stage_select_2_region,
				vbom), 1.2f, 1);
		penjumlahanMenu[2] = new ScaleMenuItemDecorator(new SpriteMenuItem(
				MENU_PENJUMLAHAN_3, resourcesManager.stage_select_3_region,
				vbom), 1.2f, 1);
		penjumlahanMenu[3] = new ScaleMenuItemDecorator(new SpriteMenuItem(
				MENU_PENJUMLAHAN_4, resourcesManager.stage_select_1_region,
				vbom), 1.2f, 1);
		penjumlahanMenu[4] = new ScaleMenuItemDecorator(new SpriteMenuItem(
				MENU_PENJUMLAHAN_5, resourcesManager.stage_select_2_region,
				vbom), 1.2f, 1);
		penjumlahanMenu[5] = new ScaleMenuItemDecorator(new SpriteMenuItem(
				MENU_PENJUMLAHAN_6, resourcesManager.stage_select_3_region,
				vbom), 1.2f, 1);
		penjumlahanMenu[6] = new ScaleMenuItemDecorator(new SpriteMenuItem(
				MENU_PENJUMLAHAN_7, resourcesManager.stage_select_1_region,
				vbom), 1.2f, 1);
		penjumlahanMenu[7] = new ScaleMenuItemDecorator(new SpriteMenuItem(
				MENU_PENJUMLAHAN_8, resourcesManager.stage_select_2_region,
				vbom), 1.2f, 1);
		penjumlahanMenu[8] = new ScaleMenuItemDecorator(new SpriteMenuItem(
				MENU_PENJUMLAHAN_9, resourcesManager.stage_select_3_region,
				vbom), 1.2f, 1);
		penjumlahanMenu[9] = new ScaleMenuItemDecorator(new SpriteMenuItem(
				MENU_PENJUMLAHAN_10, resourcesManager.stage_select_2_region,
				vbom), 1.2f, 1);

		for (int i = 0; i < medals.length; i++) {
			medals[i] = new AnimatedSprite(0, 0, medal_region, vbom);
		}

		GameManager.setStageStatus(penjumlahanMenu, medals, penjumlahanStage, resourcesManager.menuFont, vbom);

		for (int i = 0; i < penjumlahanMenu.length; i++) {
			penjumlahanStageMenuScene.addMenuItem(penjumlahanMenu[i]);
		}
		
		penjumlahanStageMenuScene.addMenuItem(backButton);

		penjumlahanStageMenuScene.buildAnimations();
		penjumlahanStageMenuScene.setBackgroundEnabled(false);

		penjumlahanMenu[0].setPosition(130, 320);
		penjumlahanMenu[1].setPosition(380, 200);
		penjumlahanMenu[2].setPosition(650, 130);
		penjumlahanMenu[3].setPosition(920, 140);
		penjumlahanMenu[4].setPosition(1130, 180);
		penjumlahanMenu[5].setPosition(300, 490);
		penjumlahanMenu[6].setPosition(510, 380);
		penjumlahanMenu[7].setPosition(790, 310);
		penjumlahanMenu[8].setPosition(770, 500);
		penjumlahanMenu[9].setPosition(520, 610);
		
		backButton.setPosition(150, 100);

		penjumlahanStageMenuScene.setOnMenuItemClickListener(this);

		setChildScene(penjumlahanStageMenuScene);
		
		if (GameManager.checkLockedStage(penjumlahanStage)) {

			Sprite lock = GameManager.createLockMenuItem(penjumlahanStage, medal, resourcesManager, vbom);

			penjumlahanStageMenuScene.attachChild(lock);
			lock.setPosition(penjumlahanMenu[9]);
			lock.registerEntityModifier(new LoopEntityModifier(new ScaleModifier(1, 1, 1.2f)));

			penjumlahanMenu[9].setPosition(-100, -100);
			penjumlahanMenu[9].setVisible(false);
		}
	}


	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
			float pMenuItemLocalX, float pMenuItemLocalY) {
		// TODO Auto-generated method stub
		
		resourcesManager.buttonSound.play();

		switch (pMenuItem.getID()) {
		case MENU_PENJUMLAHAN_1:
			gTracker.sendEvent("play", "play penjumlahan", "Penjumlahan 1", (long) 0);
			SceneManager.getInstance().loadPenjumlahanGameScene(engine,
					MENU_PENJUMLAHAN_1);
			return true;
		case MENU_PENJUMLAHAN_2:
			gTracker.sendEvent("play", "play penjumlahan", "Penjumlahan 2", (long) 0);
			SceneManager.getInstance().loadPenjumlahanGameScene(engine,
					MENU_PENJUMLAHAN_2);
			return true;
		case MENU_PENJUMLAHAN_3:
			gTracker.sendEvent("play", "play penjumlahan", "Penjumlahan 3", (long) 0);
			SceneManager.getInstance().loadPenjumlahanGameScene(engine,
					MENU_PENJUMLAHAN_3);
			return true;
		case MENU_PENJUMLAHAN_4:
			gTracker.sendEvent("play", "play penjumlahan", "Penjumlahan 4", (long) 0);
			SceneManager.getInstance().loadPenjumlahanGameScene(engine,
					MENU_PENJUMLAHAN_4);
			return true;
		case MENU_PENJUMLAHAN_5:
			gTracker.sendEvent("play", "play penjumlahan", "Penjumlahan 5", (long) 0);
			SceneManager.getInstance().loadPenjumlahanGameScene(engine,
					MENU_PENJUMLAHAN_5);
			return true;
		case MENU_PENJUMLAHAN_6:
			gTracker.sendEvent("play", "play penjumlahan", "Penjumlahan 6", (long) 0);
			SceneManager.getInstance().loadPenjumlahanGameScene(engine,
					MENU_PENJUMLAHAN_6);
			return true;
		case MENU_PENJUMLAHAN_7:
			gTracker.sendEvent("play", "play penjumlahan", "Penjumlahan 7", (long) 0);
			SceneManager.getInstance().loadPenjumlahanGameScene(engine,
					MENU_PENJUMLAHAN_7);
			return true;
		case MENU_PENJUMLAHAN_8:
			gTracker.sendEvent("play", "play penjumlahan", "Penjumlahan 8", (long) 0);
			SceneManager.getInstance().loadPenjumlahanGameScene(engine,
					MENU_PENJUMLAHAN_8);
			return true;
		case MENU_PENJUMLAHAN_9:
			gTracker.sendEvent("play", "play penjumlahan", "Penjumlahan 9", (long) 0);
			SceneManager.getInstance().loadPenjumlahanGameScene(engine,
					MENU_PENJUMLAHAN_9);
			return true;
		case MENU_PENJUMLAHAN_10:
			gTracker.sendEvent("play", "play penjumlahan", "Penjumlahan 10", (long) 0);
			SceneManager.getInstance().loadPenjumlahanGameScene(engine,
					MENU_PENJUMLAHAN_10);
			return true;
		case MENU_BACK:
			gTracker.sendEvent("back button", "user clicked back button", "back button Penjumlahan stage menu scene", (long) 0);
			SceneManager.getInstance().setStageMenuScene();
			return true;
		default:
			return false;
		}
	}
}
