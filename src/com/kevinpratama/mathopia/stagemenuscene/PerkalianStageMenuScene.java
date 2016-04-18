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

public class PerkalianStageMenuScene extends BaseScene implements
		IOnMenuItemClickListener {

	private MenuScene perkalianStageMenuScene;
	public static final int MENU_PERKALIAN_1 = 1;
	public static final int MENU_PERKALIAN_2 = 2;
	public static final int MENU_PERKALIAN_3 = 3;
	public static final int MENU_PERKALIAN_4 = 4;
	public static final int MENU_PERKALIAN_5 = 5;
	public static final int MENU_PERKALIAN_6 = 6;
	public static final int MENU_PERKALIAN_7 = 7;
	public static final int MENU_PERKALIAN_8 = 8;
	public static final int MENU_PERKALIAN_9 = 9;
	public static final int MENU_PERKALIAN_10 = 10;
	public static final int MENU_BACK = 11;
	
	private final List<Stage> perkalianStage;

	public PerkalianStageMenuScene(List<Stage> perkalianStages) {
		// TODO Auto-generated constructor stub
		this.perkalianStage = perkalianStages;
		createPerkaliannMenuChildScene();
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
		gTracker.sendEvent("native back key", "user clicked native back key", "native back key perkalian stage menu scene", (long) 0);
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
				resourcesManager.perkalian_stage_menu_background_region, vbom) {
			@Override
			protected void preDraw(GLState pGLState, Camera pCamera) {
				// TODO Auto-generated method stub
				super.preDraw(pGLState, pCamera);
				pGLState.enableDither();
			}
		});
	}

	private void createPerkaliannMenuChildScene() {
		perkalianStageMenuScene = new MenuScene(camera);

		final IMenuItem[] perkalianMenu = new IMenuItem[10];
		final IMenuItem backButton = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_BACK,
						resourcesManager.back_button_region, vbom), 1.2f, 1);
		ITiledTextureRegion medal_region = resourcesManager.stage_medal_region;
		AnimatedSprite[] medals = new AnimatedSprite[10];
		AnimatedSprite medal = new AnimatedSprite(0, 0, medal_region, vbom);

		perkalianMenu[0] = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_PERKALIAN_1,
						resourcesManager.stage_select_2_region, vbom), 1.2f, 1);
		perkalianMenu[1] = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_PERKALIAN_2,
						resourcesManager.stage_select_1_region, vbom), 1.2f, 1);
		perkalianMenu[2] = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_PERKALIAN_3,
						resourcesManager.stage_select_3_region, vbom), 1.2f, 1);
		perkalianMenu[3] = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_PERKALIAN_4,
						resourcesManager.stage_select_2_region, vbom), 1.2f, 1);
		perkalianMenu[4] = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_PERKALIAN_5,
						resourcesManager.stage_select_1_region, vbom), 1.2f, 1);
		perkalianMenu[5] = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_PERKALIAN_6,
						resourcesManager.stage_select_3_region, vbom), 1.2f, 1);
		perkalianMenu[6] = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_PERKALIAN_7,
						resourcesManager.stage_select_2_region, vbom), 1.2f, 1);
		perkalianMenu[7] = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_PERKALIAN_8,
						resourcesManager.stage_select_1_region, vbom), 1.2f, 1);
		perkalianMenu[8] = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_PERKALIAN_9,
						resourcesManager.stage_select_3_region, vbom), 1.2f, 1);
		perkalianMenu[9] = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_PERKALIAN_10,
						resourcesManager.stage_select_2_region, vbom), 1.2f, 1);

		for (int i = 0; i < medals.length; i++) {
			medals[i] = new AnimatedSprite(0, 0, medal_region, vbom);
		}

		GameManager.setStageStatus(perkalianMenu, medals, perkalianStage,
				resourcesManager.menuFont, vbom);

		for (int i = 0; i < perkalianMenu.length; i++) {
			perkalianStageMenuScene.addMenuItem(perkalianMenu[i]);
		}

		perkalianStageMenuScene.addMenuItem(backButton);
		
		perkalianStageMenuScene.buildAnimations();
		perkalianStageMenuScene.setBackgroundEnabled(false);

		perkalianMenu[0].setPosition(180, 450);
		perkalianMenu[1].setPosition(320, 250);
		perkalianMenu[2].setPosition(440, 570);
		perkalianMenu[3].setPosition(610, 400);
		perkalianMenu[4].setPosition(650, 180);
		perkalianMenu[5].setPosition(710, 660);
		perkalianMenu[6].setPosition(910, 270);
		perkalianMenu[7].setPosition(970, 490);
		perkalianMenu[8].setPosition(1150, 330);
		perkalianMenu[9].setPosition(1140, 680);
		
		backButton.setPosition(150, 100);

		perkalianStageMenuScene.setOnMenuItemClickListener(this);

		setChildScene(perkalianStageMenuScene);

		if (GameManager.checkLockedStage(perkalianStage)) {

			Sprite lock = GameManager.createLockMenuItem(perkalianStage, medal, resourcesManager, vbom);

			perkalianStageMenuScene.attachChild(lock);
			lock.setPosition(perkalianMenu[9]);
			lock.registerEntityModifier(new LoopEntityModifier(new ScaleModifier(1, 1, 1.2f)));

			perkalianMenu[9].setPosition(-100, -100);
			perkalianMenu[9].setVisible(false);
		}
	}

	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
			float pMenuItemLocalX, float pMenuItemLocalY) {
		// TODO Auto-generated method stub
		resourcesManager.buttonSound.play();

		switch (pMenuItem.getID()) {
		case MENU_PERKALIAN_1:
			gTracker.sendEvent("play", "play perkalian", "Perkalian 1", (long) 0);
			SceneManager.getInstance().loadPerkalianGameScene(engine,
					MENU_PERKALIAN_1);
			return true;
		case MENU_PERKALIAN_2:
			gTracker.sendEvent("play", "play perkalian", "Perkalian 2", (long) 0);
			SceneManager.getInstance().loadPerkalianGameScene(engine,
					MENU_PERKALIAN_2);
			return true;
		case MENU_PERKALIAN_3:
			gTracker.sendEvent("play", "play perkalian", "Perkalian 3", (long) 0);
			SceneManager.getInstance().loadPerkalianGameScene(engine,
					MENU_PERKALIAN_3);
			return true;
		case MENU_PERKALIAN_4:
			gTracker.sendEvent("play", "play perkalian", "Perkalian 4", (long) 0);
			SceneManager.getInstance().loadPerkalianGameScene(engine,
					MENU_PERKALIAN_4);
			return true;
		case MENU_PERKALIAN_5:
			gTracker.sendEvent("play", "play perkalian", "Perkalian 5", (long) 0);
			SceneManager.getInstance().loadPerkalianGameScene(engine,
					MENU_PERKALIAN_5);
			return true;
		case MENU_PERKALIAN_6:
			gTracker.sendEvent("play", "play perkalian", "Perkalian 6", (long) 0);
			SceneManager.getInstance().loadPerkalianGameScene(engine,
					MENU_PERKALIAN_6);
			return true;
		case MENU_PERKALIAN_7:
			gTracker.sendEvent("play", "play perkalian", "Perkalian 7", (long) 0);
			SceneManager.getInstance().loadPerkalianGameScene(engine,
					MENU_PERKALIAN_7);
			return true;
		case MENU_PERKALIAN_8:
			gTracker.sendEvent("play", "play perkalian", "Perkalian 8", (long) 0);
			SceneManager.getInstance().loadPerkalianGameScene(engine,
					MENU_PERKALIAN_8);
			return true;
		case MENU_PERKALIAN_9:
			gTracker.sendEvent("play", "play perkalian", "Perkalian 9", (long) 0);
			SceneManager.getInstance().loadPerkalianGameScene(engine,
					MENU_PERKALIAN_9);
			return true;
		case MENU_PERKALIAN_10:
			gTracker.sendEvent("play", "play perkalian", "Perkalian 10", (long) 0);
			SceneManager.getInstance().loadPerkalianGameScene(engine,
					MENU_PERKALIAN_10);
			return true;
		case MENU_BACK:
			gTracker.sendEvent("back button", "user clicked back button", "back button perkalian stage menu scene", (long) 0);
			SceneManager.getInstance().setStageMenuScene();
			return true;
		default:
			return false;
		}
	}

}
