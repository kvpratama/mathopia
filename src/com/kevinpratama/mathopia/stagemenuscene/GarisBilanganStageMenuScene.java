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

public class GarisBilanganStageMenuScene extends BaseScene implements
		IOnMenuItemClickListener {

	private MenuScene garisBilanganStageMenuScene;
	public static final int MENU_GARIS_BILANGAN_1 = 1;
	public static final int MENU_GARIS_BILANGAN_2 = 2;
	public static final int MENU_GARIS_BILANGAN_3 = 3;
	public static final int MENU_GARIS_BILANGAN_4 = 4;
	public static final int MENU_GARIS_BILANGAN_5 = 5;
	public static final int MENU_GARIS_BILANGAN_6 = 6;
	public static final int MENU_GARIS_BILANGAN_7 = 7;
	public static final int MENU_GARIS_BILANGAN_8 = 8;
	public static final int MENU_GARIS_BILANGAN_9 = 9;
	public static final int MENU_GARIS_BILANGAN_10 = 10;
	public static final int MENU_BACK = 11;

	private final List<Stage> garisBilanganStages;

	public GarisBilanganStageMenuScene(List<Stage> garisBilanganStages) {
		// TODO Auto-generated constructor stub
		this.garisBilanganStages = garisBilanganStages;
		createGarisBilanganMenuChildScene();
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
		gTracker.sendEvent("native back key", "user clicked native back key", "native back key GB Stage Menu scene", (long) 0);
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
				resourcesManager.garis_bilangan_stage_menu_background_region,
				vbom) {
			@Override
			protected void preDraw(GLState pGLState, Camera pCamera) {
				// TODO Auto-generated method stub
				super.preDraw(pGLState, pCamera);
				pGLState.enableDither();
			}
		});
	}

	private void createGarisBilanganMenuChildScene() {
		garisBilanganStageMenuScene = new MenuScene(camera);

		final IMenuItem[] garisBilanganMenu = new IMenuItem[10];
		final IMenuItem backButton = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_BACK,
						resourcesManager.back_button_region, vbom), 1.2f, 1);
		ITiledTextureRegion medal_region = resourcesManager.stage_medal_region;
		AnimatedSprite[] medals = new AnimatedSprite[10];
		AnimatedSprite medal = new AnimatedSprite(0, 0, medal_region, vbom);

		garisBilanganMenu[0] = new ScaleMenuItemDecorator(new SpriteMenuItem(
				MENU_GARIS_BILANGAN_1, resourcesManager.stage_select_2_region,
				vbom), 1.2f, 1);
		garisBilanganMenu[1] = new ScaleMenuItemDecorator(new SpriteMenuItem(
				MENU_GARIS_BILANGAN_2, resourcesManager.stage_select_3_region,
				vbom), 1.2f, 1);
		garisBilanganMenu[2] = new ScaleMenuItemDecorator(new SpriteMenuItem(
				MENU_GARIS_BILANGAN_3, resourcesManager.stage_select_1_region,
				vbom), 1.2f, 1);
		garisBilanganMenu[3] = new ScaleMenuItemDecorator(new SpriteMenuItem(
				MENU_GARIS_BILANGAN_4, resourcesManager.stage_select_2_region,
				vbom), 1.2f, 1);
		garisBilanganMenu[4] = new ScaleMenuItemDecorator(new SpriteMenuItem(
				MENU_GARIS_BILANGAN_5, resourcesManager.stage_select_3_region,
				vbom), 1.2f, 1);
		garisBilanganMenu[5] = new ScaleMenuItemDecorator(new SpriteMenuItem(
				MENU_GARIS_BILANGAN_6, resourcesManager.stage_select_1_region,
				vbom), 1.2f, 1);
		garisBilanganMenu[6] = new ScaleMenuItemDecorator(new SpriteMenuItem(
				MENU_GARIS_BILANGAN_7, resourcesManager.stage_select_2_region,
				vbom), 1.2f, 1);
		garisBilanganMenu[7] = new ScaleMenuItemDecorator(new SpriteMenuItem(
				MENU_GARIS_BILANGAN_8, resourcesManager.stage_select_3_region,
				vbom), 1.2f, 1);
		garisBilanganMenu[8] = new ScaleMenuItemDecorator(new SpriteMenuItem(
				MENU_GARIS_BILANGAN_9, resourcesManager.stage_select_1_region,
				vbom), 1.2f, 1);
		garisBilanganMenu[9] = new ScaleMenuItemDecorator(new SpriteMenuItem(
				MENU_GARIS_BILANGAN_10, resourcesManager.stage_select_2_region,
				vbom), 1.2f, 1);

		for (int i = 0; i < medals.length; i++) {
			medals[i] = new AnimatedSprite(0, 0, medal_region, vbom);
		}

		GameManager.setStageStatus(garisBilanganMenu, medals,
				garisBilanganStages, resourcesManager.menuFont, vbom);

		for (int i = 0; i < garisBilanganMenu.length; i++) {
			garisBilanganStageMenuScene.addMenuItem(garisBilanganMenu[i]);
		}

		garisBilanganStageMenuScene.addMenuItem(backButton);

		garisBilanganStageMenuScene.buildAnimations();
		garisBilanganStageMenuScene.setBackgroundEnabled(false);

		garisBilanganMenu[0].setPosition(150, 380);
		garisBilanganMenu[1].setPosition(270, 630);
		garisBilanganMenu[2].setPosition(380, 180);
		garisBilanganMenu[3].setPosition(450, 410);
		garisBilanganMenu[4].setPosition(530, 690);
		garisBilanganMenu[5].setPosition(680, 220);
		garisBilanganMenu[6].setPosition(750, 540);
		garisBilanganMenu[7].setPosition(900, 360);
		garisBilanganMenu[8].setPosition(970, 700);
		garisBilanganMenu[9].setPosition(1130, 510);

		backButton.setPosition(150, 100);

		garisBilanganStageMenuScene.setOnMenuItemClickListener(this);

		setChildScene(garisBilanganStageMenuScene);

		if (GameManager.checkLockedStage(garisBilanganStages)) {

			Sprite lock = GameManager.createLockMenuItem(garisBilanganStages, medal,
					resourcesManager, vbom);

			garisBilanganStageMenuScene.attachChild(lock);
			lock.setPosition(garisBilanganMenu[9]);
			lock.registerEntityModifier(new LoopEntityModifier(
					new ScaleModifier(1, 1, 1.2f)));

			garisBilanganMenu[9].setPosition(-100, -100);
			garisBilanganMenu[9].setVisible(false);
		}
	}

	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
			float pMenuItemLocalX, float pMenuItemLocalY) {
		// TODO Auto-generated method stub
		resourcesManager.buttonSound.play();
		// resourcesManager.backSound.stop();

		switch (pMenuItem.getID()) {
		case MENU_GARIS_BILANGAN_1:
			gTracker.sendEvent("play", "play GB", "GB1", (long) 0);
			SceneManager.getInstance().loadGarisBilanganGameScene(engine,
					MENU_GARIS_BILANGAN_1);
			return true;
		case MENU_GARIS_BILANGAN_2:
			gTracker.sendEvent("play", "play GB", "GB2", (long) 0);
			SceneManager.getInstance().loadGarisBilanganGameScene(engine,
					MENU_GARIS_BILANGAN_2);
			return true;
		case MENU_GARIS_BILANGAN_3:
			gTracker.sendEvent("play", "play GB", "GB3", (long) 0);
			SceneManager.getInstance().loadGarisBilanganGameScene(engine,
					MENU_GARIS_BILANGAN_3);
			return true;
		case MENU_GARIS_BILANGAN_4:
			gTracker.sendEvent("play", "play GB", "GB4", (long) 0);
			SceneManager.getInstance().loadGarisBilanganGameScene(engine,
					MENU_GARIS_BILANGAN_4);
			return true;
		case MENU_GARIS_BILANGAN_5:
			gTracker.sendEvent("play", "play GB", "GB5", (long) 0);
			SceneManager.getInstance().loadGarisBilanganGameScene(engine,
					MENU_GARIS_BILANGAN_5);
			return true;
		case MENU_GARIS_BILANGAN_6:
			gTracker.sendEvent("play", "play GB", "GB6", (long) 0);
			SceneManager.getInstance().loadGarisBilanganGameScene(engine,
					MENU_GARIS_BILANGAN_6);
			return true;
		case MENU_GARIS_BILANGAN_7:
			gTracker.sendEvent("play", "play GB", "GB7", (long) 0);
			SceneManager.getInstance().loadGarisBilanganGameScene(engine,
					MENU_GARIS_BILANGAN_7);
			return true;
		case MENU_GARIS_BILANGAN_8:
			gTracker.sendEvent("play", "play GB", "GB8", (long) 0);
			SceneManager.getInstance().loadGarisBilanganGameScene(engine,
					MENU_GARIS_BILANGAN_8);
			return true;
		case MENU_GARIS_BILANGAN_9:
			gTracker.sendEvent("play", "play GB", "GB9", (long) 0);
			SceneManager.getInstance().loadGarisBilanganGameScene(engine,
					MENU_GARIS_BILANGAN_9);
			return true;
		case MENU_GARIS_BILANGAN_10:
			gTracker.sendEvent("play", "play GB", "GB10", (long) 0);
			SceneManager.getInstance().loadGarisBilanganGameScene(engine,
					MENU_GARIS_BILANGAN_10);
			return true;
		case MENU_BACK:
			gTracker.sendEvent("back button", "user clicked back button", "back button GB stage menu scene", (long) 0);
			SceneManager.getInstance().setStageMenuScene();
			return true;
		default:
			return false;
		}
	}

}
