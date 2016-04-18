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

public class PenguranganStageMenuScene extends BaseScene implements
		IOnMenuItemClickListener {

	private MenuScene penguranganStageMenuScene;

	public static final int MENU_PENGURANGAN_1 = 1;
	public static final int MENU_PENGURANGAN_2 = 2;
	public static final int MENU_PENGURANGAN_3 = 3;
	public static final int MENU_PENGURANGAN_4 = 4;
	public static final int MENU_PENGURANGAN_5 = 5;
	public static final int MENU_PENGURANGAN_6 = 6;
	public static final int MENU_PENGURANGAN_7 = 7;
	public static final int MENU_PENGURANGAN_8 = 8;
	public static final int MENU_PENGURANGAN_9 = 9;
	public static final int MENU_PENGURANGAN_10 = 10;
	public static final int MENU_BACK = 11;

	private final List<Stage> penguranganStage;

	public PenguranganStageMenuScene(List<Stage> penguranganStages) {
		// TODO Auto-generated constructor stub
		this.penguranganStage = penguranganStages;
		createPenguranganMenuChildScene();
	}

	@Override
	public void createScene() {
		// TODO Auto-generated method stub
		createBackground();
	}

	@Override
	public void onBackKeyPressed() {
		// TODO Auto-generated method stub
		gTracker.sendEvent("native back key", "user clicked native back key", "native back key pengurangan stagem menu scene", (long) 0);
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
				resourcesManager.pengurangan_stage_menu_background_region, vbom) {
			@Override
			protected void preDraw(GLState pGLState, Camera pCamera) {
				// TODO Auto-generated method stub
				super.preDraw(pGLState, pCamera);
				pGLState.enableDither();
			}
		});
	}

	private void createPenguranganMenuChildScene() {
		penguranganStageMenuScene = new MenuScene(camera);

		final IMenuItem[] penguranganMenu = new IMenuItem[10];
		final IMenuItem backButton = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_BACK,
						resourcesManager.back_button_region, vbom), 1.2f, 1);
		ITiledTextureRegion medal_region = resourcesManager.stage_medal_region;
		AnimatedSprite[] medals = new AnimatedSprite[10];
		AnimatedSprite medal = new AnimatedSprite(0, 0, medal_region, vbom);

		penguranganMenu[0] = new ScaleMenuItemDecorator(new SpriteMenuItem(
				MENU_PENGURANGAN_1, resourcesManager.stage_select_3_region,
				vbom), 1.2f, 1);
		penguranganMenu[1] = new ScaleMenuItemDecorator(new SpriteMenuItem(
				MENU_PENGURANGAN_2, resourcesManager.stage_select_2_region,
				vbom), 1.2f, 1);
		penguranganMenu[2] = new ScaleMenuItemDecorator(new SpriteMenuItem(
				MENU_PENGURANGAN_3, resourcesManager.stage_select_1_region,
				vbom), 1.2f, 1);
		penguranganMenu[3] = new ScaleMenuItemDecorator(new SpriteMenuItem(
				MENU_PENGURANGAN_4, resourcesManager.stage_select_3_region,
				vbom), 1.2f, 1);
		penguranganMenu[4] = new ScaleMenuItemDecorator(new SpriteMenuItem(
				MENU_PENGURANGAN_5, resourcesManager.stage_select_2_region,
				vbom), 1.2f, 1);
		penguranganMenu[5] = new ScaleMenuItemDecorator(new SpriteMenuItem(
				MENU_PENGURANGAN_6, resourcesManager.stage_select_1_region,
				vbom), 1.2f, 1);
		penguranganMenu[6] = new ScaleMenuItemDecorator(new SpriteMenuItem(
				MENU_PENGURANGAN_7, resourcesManager.stage_select_3_region,
				vbom), 1.2f, 1);
		penguranganMenu[7] = new ScaleMenuItemDecorator(new SpriteMenuItem(
				MENU_PENGURANGAN_8, resourcesManager.stage_select_2_region,
				vbom), 1.2f, 1);
		penguranganMenu[8] = new ScaleMenuItemDecorator(new SpriteMenuItem(
				MENU_PENGURANGAN_9, resourcesManager.stage_select_1_region,
				vbom), 1.2f, 1);
		penguranganMenu[9] = new ScaleMenuItemDecorator(new SpriteMenuItem(
				MENU_PENGURANGAN_10, resourcesManager.stage_select_3_region,
				vbom), 1.2f, 1);

		for (int i = 0; i < medals.length; i++) {
			medals[i] = new AnimatedSprite(0, 0, medal_region, vbom);
		}

		GameManager.setStageStatus(penguranganMenu, medals, penguranganStage,
				resourcesManager.menuFont, vbom);

		for (int i = 0; i < penguranganMenu.length; i++) {
			penguranganStageMenuScene.addMenuItem(penguranganMenu[i]);
		}

		penguranganStageMenuScene.addMenuItem(backButton);

		penguranganStageMenuScene.buildAnimations();
		penguranganStageMenuScene.setBackgroundEnabled(false);

		penguranganMenu[0].setPosition(180, 450);
		penguranganMenu[1].setPosition(320, 250);
		penguranganMenu[2].setPosition(440, 570);
		penguranganMenu[3].setPosition(610, 400);
		penguranganMenu[4].setPosition(650, 180);
		penguranganMenu[5].setPosition(710, 660);
		penguranganMenu[6].setPosition(910, 270);
		penguranganMenu[7].setPosition(980, 510);
		penguranganMenu[8].setPosition(1150, 330);
		penguranganMenu[9].setPosition(1140, 680);

		backButton.setPosition(150, 100);

		penguranganStageMenuScene.setOnMenuItemClickListener(this);

		setChildScene(penguranganStageMenuScene);

		if (GameManager.checkLockedStage(penguranganStage)) {

			Sprite lock = GameManager.createLockMenuItem(penguranganStage, medal, resourcesManager, vbom);

			penguranganStageMenuScene.attachChild(lock);
			lock.setPosition(penguranganMenu[9]);
			lock.registerEntityModifier(new LoopEntityModifier(new ScaleModifier(1, 1, 1.2f)));

			penguranganMenu[9].setPosition(-100, -100);
			penguranganMenu[9].setVisible(false);
		}
	}

	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
			float pMenuItemLocalX, float pMenuItemLocalY) {
		// TODO Auto-generated method stub
		resourcesManager.buttonSound.play();
		// resourcesManager.backSound.stop();

		switch (pMenuItem.getID()) {
		case MENU_PENGURANGAN_1:
			gTracker.sendEvent("play", "play pengurangan", "Pengurangan 1", (long) 0);
			SceneManager.getInstance().loadPenguranganGameScene(engine,
					MENU_PENGURANGAN_1);
			return true;
		case MENU_PENGURANGAN_2:
			gTracker.sendEvent("play", "play pengurangan", "Pengurangan 2", (long) 0);
			SceneManager.getInstance().loadPenguranganGameScene(engine,
					MENU_PENGURANGAN_2);
			return true;
		case MENU_PENGURANGAN_3:
			gTracker.sendEvent("play", "play pengurangan", "Pengurangan 3", (long) 0);
			SceneManager.getInstance().loadPenguranganGameScene(engine,
					MENU_PENGURANGAN_3);
			return true;
		case MENU_PENGURANGAN_4:
			gTracker.sendEvent("play", "play pengurangan", "Pengurangan 4", (long) 0);
			SceneManager.getInstance().loadPenguranganGameScene(engine,
					MENU_PENGURANGAN_4);
			return true;
		case MENU_PENGURANGAN_5:
			gTracker.sendEvent("play", "play pengurangan", "Pengurangan 5", (long) 0);
			SceneManager.getInstance().loadPenguranganGameScene(engine,
					MENU_PENGURANGAN_5);
			return true;
		case MENU_PENGURANGAN_6:
			gTracker.sendEvent("play", "play pengurangan", "Pengurangan 6", (long) 0);
			SceneManager.getInstance().loadPenguranganGameScene(engine,
					MENU_PENGURANGAN_6);
			return true;
		case MENU_PENGURANGAN_7:
			gTracker.sendEvent("play", "play pengurangan", "Pengurangan 7", (long) 0);
			SceneManager.getInstance().loadPenguranganGameScene(engine,
					MENU_PENGURANGAN_7);
			return true;
		case MENU_PENGURANGAN_8:
			gTracker.sendEvent("play", "play pengurangan", "Pengurangan 8", (long) 0);
			SceneManager.getInstance().loadPenguranganGameScene(engine,
					MENU_PENGURANGAN_8);
			return true;
		case MENU_PENGURANGAN_9:
			gTracker.sendEvent("play", "play pengurangan", "Pengurangan 9", (long) 0);
			SceneManager.getInstance().loadPenguranganGameScene(engine,
					MENU_PENGURANGAN_9);
			return true;
		case MENU_PENGURANGAN_10:
			gTracker.sendEvent("play", "play pengurangan", "Pengurangan 10", (long) 0);
			SceneManager.getInstance().loadPenguranganGameScene(engine,
					MENU_PENGURANGAN_10);
			return true;
		case MENU_BACK:
			gTracker.sendEvent("back button", "user clicked back button", "back button pengurangan stage menu scene", (long) 0);
			SceneManager.getInstance().setStageMenuScene();
			return true;
		default:
			return false;
		}
	}
}
