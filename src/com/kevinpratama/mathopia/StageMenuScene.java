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

public class StageMenuScene extends BaseScene implements
		IOnMenuItemClickListener {

	private MenuScene stageMenuChildScene;
	private final int MENU_GARIS_BILANGAN = 0;
	private final int MENU_PENJUMLAHAN = 1;
	private final int MENU_PENGURANGAN = 2;
	private final int MENU_PERKALIAN = 3;
	private final int MENU_PEMBAGIAN = 4;
	private final int REWARD = 5;
	public static final int MENU_BACK = 11;
	public static final int MENU_HOW_TO = 12;

//	private Sound buttonSound;
	
	@Override
	public void createScene() {
		// TODO Auto-generated method stub
		createSound();
		createBackground();
		createStageMenuChildScene();
	}

	@Override
	public void onBackKeyPressed() {
		// TODO Auto-generated method stub
		gTracker.sendEvent("native back key", "user clikc native back key", "native back key stage menu scene", (long) 0);
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

	private void createSound(){
//		buttonSound = resourcesManager.buttonSound;
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

	private void createStageMenuChildScene() {
		stageMenuChildScene = new MenuScene(camera);
		stageMenuChildScene.setPosition(0, 0);

		final IMenuItem garisBilanganMenuItem = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_GARIS_BILANGAN,
						resourcesManager.garis_bilangan_region, vbom), 1.2f, 1);
		final IMenuItem penjumlahanMenuItem = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_PENJUMLAHAN,
						resourcesManager.penjumlahan_region, vbom), 1.2f, 1);
		final IMenuItem penguranganMenuItem = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_PENGURANGAN,
						resourcesManager.pengurangan_region, vbom), 1.2f, 1);
		final IMenuItem perkalianMenuItem = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_PERKALIAN,
						resourcesManager.perkalian_region, vbom), 1.2f, 1);
		final IMenuItem pembagianMenuItem = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_PEMBAGIAN,
						resourcesManager.pembagian_region, vbom), 1.2f, 1);
		final IMenuItem rewardMenuItem = new ScaleMenuItemDecorator(
				new SpriteMenuItem(REWARD,
						resourcesManager.reward_region, vbom), 1.2f, 1);
		final IMenuItem backButton = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_BACK,
						resourcesManager.back_button_region, vbom), 1.2f, 1);
		final IMenuItem howToMenuItem = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_HOW_TO,
						resourcesManager.how_to_button_region, vbom), 1.2f, 1);

//		garisBilanganMenuItem.registerEntityModifier(new MoveModifier(2, 780,
//				900, 780, 90, EaseElasticOut.getInstance()));

		stageMenuChildScene.addMenuItem(garisBilanganMenuItem);
		stageMenuChildScene.addMenuItem(penjumlahanMenuItem);
		stageMenuChildScene.addMenuItem(penguranganMenuItem);
		stageMenuChildScene.addMenuItem(perkalianMenuItem);
		stageMenuChildScene.addMenuItem(pembagianMenuItem);
		stageMenuChildScene.addMenuItem(rewardMenuItem);
		stageMenuChildScene.addMenuItem(backButton);
		stageMenuChildScene.addMenuItem(howToMenuItem);

		stageMenuChildScene.buildAnimations();
		stageMenuChildScene.setBackgroundEnabled(false);

		garisBilanganMenuItem.setPosition(1040, 300);
		penjumlahanMenuItem.setPosition(420, 590);
		penguranganMenuItem.setPosition(310, 310);
		perkalianMenuItem.setPosition(940, 710);
		pembagianMenuItem.setPosition(710, 350);
		rewardMenuItem.setPosition(1180, 100);
		backButton.setPosition(150, 100);
		howToMenuItem.setPosition(640, 80);
		
		stageMenuChildScene.setOnMenuItemClickListener(this);

		setChildScene(stageMenuChildScene);

	}

	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
			float pMenuItemLocalX, float pMenuItemLocalY) {
		// TODO Auto-generated method stub
		
		resourcesManager.buttonSound.play();
		
		switch (pMenuItem.getID()) {
		case MENU_GARIS_BILANGAN:
			gTracker.sendEvent("garis bilangan button", "user clicked garis bilangan button", "garis bilangan button stage menu scene", (long) 0);
			SceneManager.getInstance().setGarisBilanganStageMenuScene();
			return true;
		case MENU_PENJUMLAHAN:
			gTracker.sendEvent("penjumlahan button", "user clicked penjumlahan button", "penjumlahan button stage menu scene", (long) 0);
			SceneManager.getInstance().setPenjumlahanStageMenuScene();
			return true;
		case MENU_PENGURANGAN:
			gTracker.sendEvent("pengurangan button", "user clicked pengurangan button", "pengurangan button stage menu scene", (long) 0);
			SceneManager.getInstance().setPenguranganStageMenuScene();
			return true;
		case MENU_PERKALIAN:
			gTracker.sendEvent("perkalian button", "user clicked perkalian button", "perkalian button stage menu scene", (long) 0);
			SceneManager.getInstance().setPerkalianStageMenuScene();
			return true;
		case MENU_PEMBAGIAN:
			gTracker.sendEvent("pembagian button", "user clicked pembagian button", "pembagian button stage menu scene", (long) 0);
			SceneManager.getInstance().setPembagianStageMenuScene();
			return true;
		case REWARD:
			gTracker.sendEvent("reward button", "user clicked reward button", "reward button stage menu scene", (long) 0);
			SceneManager.getInstance().setRewardScene();
			return true;
		case MENU_BACK:
			gTracker.sendEvent("back button", "user clicked back button", "back button stage menu scene", (long) 0);
			SceneManager.getInstance().setMenuScene();
			return true;
		case MENU_HOW_TO:
			gTracker.sendEvent("how to button", "user clicked how to button", "how to button stage menu scene", (long) 0);
			SceneManager.getInstance().setHowToScene();
			return true;
		default:
			return false;
		}
	}

}
