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

public class PembagianStageMenuScene extends BaseScene implements
		IOnMenuItemClickListener {

	private MenuScene pembagianStageMenuScene;
	public static final int MENU_PEMBAGIAN_1 = 1;
	public static final int MENU_PEMBAGIAN_2 = 2;
	public static final int MENU_PEMBAGIAN_3 = 3;
	public static final int MENU_PEMBAGIAN_4 = 4;
	public static final int MENU_PEMBAGIAN_5 = 5;
	public static final int MENU_PEMBAGIAN_6 = 6;
	public static final int MENU_PEMBAGIAN_7 = 7;
	public static final int MENU_PEMBAGIAN_8 = 8;
	public static final int MENU_PEMBAGIAN_9 = 9;
	public static final int MENU_PEMBAGIAN_10 = 10;
	public static final int MENU_BACK = 11;

	private final List<Stage> pembagianStage;
	
	public PembagianStageMenuScene(List<Stage> pembagianStages) {
		// TODO Auto-generated constructor stub
		this.pembagianStage = pembagianStages;
		createPembagianMenuChildScene();
	}

	@Override
	public void createScene() {
		// TODO Auto-generated method stub
		createBackground();
	}

	@Override
	public void onBackKeyPressed() {
		// TODO Auto-generated method stub
		gTracker.sendEvent("native back key", "user clicked native back key", "native back key pembagian Stage Menu scene", (long) 0);
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
				resourcesManager.pembagian_stage_menu_background_region, vbom) {
			@Override
			protected void preDraw(GLState pGLState, Camera pCamera) {
				// TODO Auto-generated method stub
				super.preDraw(pGLState, pCamera);
				pGLState.enableDither();
			}
		});
	}

	private void createPembagianMenuChildScene() {
		pembagianStageMenuScene = new MenuScene(camera);

		final IMenuItem[] pembagianMenu = new IMenuItem[10];
		final IMenuItem backButton = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_BACK,
						resourcesManager.back_button_region, vbom), 1.2f, 1);
		ITiledTextureRegion medal_region = resourcesManager.stage_medal_region;
		AnimatedSprite[] medals = new AnimatedSprite[10];
		AnimatedSprite medal = new AnimatedSprite(0, 0, medal_region, vbom);

		pembagianMenu[0] = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_PEMBAGIAN_1,
						resourcesManager.stage_select_3_region, vbom), 1.2f, 1);
		pembagianMenu[1] = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_PEMBAGIAN_2,
						resourcesManager.stage_select_2_region, vbom), 1.2f, 1);
		pembagianMenu[2] = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_PEMBAGIAN_3,
						resourcesManager.stage_select_1_region, vbom), 1.2f, 1);
		pembagianMenu[3] = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_PEMBAGIAN_4,
						resourcesManager.stage_select_3_region, vbom), 1.2f, 1);
		pembagianMenu[4] = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_PEMBAGIAN_5,
						resourcesManager.stage_select_2_region, vbom), 1.2f, 1);
		pembagianMenu[5] = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_PEMBAGIAN_6,
						resourcesManager.stage_select_1_region, vbom), 1.2f, 1);
		pembagianMenu[6] = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_PEMBAGIAN_7,
						resourcesManager.stage_select_3_region, vbom), 1.2f, 1);
		pembagianMenu[7] = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_PEMBAGIAN_8,
						resourcesManager.stage_select_2_region, vbom), 1.2f, 1);
		pembagianMenu[8] = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_PEMBAGIAN_9,
						resourcesManager.stage_select_1_region, vbom), 1.2f, 1);
		pembagianMenu[9] = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_PEMBAGIAN_10,
						resourcesManager.stage_select_3_region, vbom), 1.2f, 1);

		for (int i = 0; i < medals.length; i++) {
			medals[i] = new AnimatedSprite(0, 0, medal_region, vbom);
		}

		GameManager.setStageStatus(pembagianMenu, medals, pembagianStage,
				resourcesManager.menuFont, vbom);

		for (int i = 0; i < pembagianMenu.length; i++) {
			pembagianStageMenuScene.addMenuItem(pembagianMenu[i]);
		}
		
		pembagianStageMenuScene.addMenuItem(backButton);

		pembagianStageMenuScene.buildAnimations();
		pembagianStageMenuScene.setBackgroundEnabled(false);

		pembagianMenu[0].setPosition(120, 360);
		pembagianMenu[1].setPosition(350, 480);
		pembagianMenu[2].setPosition(380, 240);
		pembagianMenu[3].setPosition(610, 320);
		pembagianMenu[4].setPosition(580, 100);
		pembagianMenu[5].setPosition(860, 160);
		pembagianMenu[6].setPosition(730, 490);
		pembagianMenu[7].setPosition(930, 360);
		pembagianMenu[8].setPosition(1150, 230);
		pembagianMenu[9].setPosition(1100, 540);
		
		backButton.setPosition(150, 100);

		pembagianStageMenuScene.setOnMenuItemClickListener(this);

		setChildScene(pembagianStageMenuScene);

		if (GameManager.checkLockedStage(pembagianStage)) {

			Sprite lock = GameManager.createLockMenuItem(pembagianStage, medal, resourcesManager, vbom);

			pembagianStageMenuScene.attachChild(lock);
			lock.setPosition(pembagianMenu[9]);
			lock.registerEntityModifier(new LoopEntityModifier(new ScaleModifier(1, 1, 1.2f)));

			pembagianMenu[9].setPosition(-100, -100);
			pembagianMenu[9].setVisible(false);
		}
	}

	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
			float pMenuItemLocalX, float pMenuItemLocalY) {
		// TODO Auto-generated method stub
		resourcesManager.buttonSound.play();

		switch (pMenuItem.getID()) {
		case MENU_PEMBAGIAN_1:
			gTracker.sendEvent("play", "play pembagian", "pembagian 1", (long) 0);
			SceneManager.getInstance().loadPembagianGameScene(engine,
					MENU_PEMBAGIAN_1);
			return true;
		case MENU_PEMBAGIAN_2:
			gTracker.sendEvent("play", "play pembagian", "pembagian 2", (long) 0);
			SceneManager.getInstance().loadPembagianGameScene(engine,
					MENU_PEMBAGIAN_2);
			return true;
		case MENU_PEMBAGIAN_3:
			gTracker.sendEvent("play", "play pembagian", "pembagian 3", (long) 0);
			SceneManager.getInstance().loadPembagianGameScene(engine,
					MENU_PEMBAGIAN_3);
			return true;
		case MENU_PEMBAGIAN_4:
			gTracker.sendEvent("play", "play pembagian", "pembagian 4", (long) 0);
			SceneManager.getInstance().loadPembagianGameScene(engine,
					MENU_PEMBAGIAN_4);
			return true;
		case MENU_PEMBAGIAN_5:
			gTracker.sendEvent("play", "play pembagian", "pembagian 5", (long) 0);
			SceneManager.getInstance().loadPembagianGameScene(engine,
					MENU_PEMBAGIAN_5);
			return true;
		case MENU_PEMBAGIAN_6:
			gTracker.sendEvent("play", "play pembagian", "pembagian 6", (long) 0);
			SceneManager.getInstance().loadPembagianGameScene(engine,
					MENU_PEMBAGIAN_6);
			return true;
		case MENU_PEMBAGIAN_7:
			gTracker.sendEvent("play", "play pembagian", "pembagian 7", (long) 0);
			SceneManager.getInstance().loadPembagianGameScene(engine,
					MENU_PEMBAGIAN_7);
			return true;
		case MENU_PEMBAGIAN_8:
			gTracker.sendEvent("play", "play pembagian", "pembagian 8", (long) 0);
			SceneManager.getInstance().loadPembagianGameScene(engine,
					MENU_PEMBAGIAN_8);
			return true;
		case MENU_PEMBAGIAN_9:
			gTracker.sendEvent("play", "play pembagian", "pembagian 9", (long) 0);
			SceneManager.getInstance().loadPembagianGameScene(engine,
					MENU_PEMBAGIAN_9);
			return true;
		case MENU_PEMBAGIAN_10:
			gTracker.sendEvent("play", "play pembagian", "pembagian 10", (long) 0);
			SceneManager.getInstance().loadPembagianGameScene(engine,
					MENU_PEMBAGIAN_10);
			return true;
		case MENU_BACK:
			gTracker.sendEvent("back button", "user clicked back button", "back button pembagian stage menu scene", (long) 0);
			SceneManager.getInstance().setStageMenuScene();
			return true;
		default:
			return false;
		}
	}

}
