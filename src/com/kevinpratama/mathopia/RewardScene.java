package com.kevinpratama.mathopia;

import java.util.List;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.util.GLState;

import com.kevinpratama.mathopia.SceneManager.SceneType;
import com.kevinpratama.mathopia.datamanager.DatabaseHandler;
import com.kevinpratama.mathopia.datamanager.Reward;

public class RewardScene extends BaseScene implements IOnMenuItemClickListener {

	AnimatedSprite[] rewardBoxSprite;

	private MenuScene creditMenuScene;
	private final int MENU_BACK = 0;

	@Override
	public void createScene() {
		// TODO Auto-generated method stub
		createBackground();
		createRewardMenuScene();
		initializeTexture();
		checkUnlockedBox();
	}

	@Override
	public void onBackKeyPressed() {
		// TODO Auto-generated method stub
		gTracker.sendEvent("native back key", "user clicked native back key", "native back key reward scene", (long) 0);
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
				resourcesManager.reward_scene_background_region, vbom) {
			@Override
			protected void preDraw(GLState pGLState, Camera pCamera) {
				// TODO Auto-generated method stub
				super.preDraw(pGLState, pCamera);
				pGLState.enableDither();
			}
		});
	}

	private void createRewardMenuScene() {
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

	private void initializeTexture() {
		rewardBoxSprite = new AnimatedSprite[9];
		ITiledTextureRegion[] rewardBoxRegion = new ITiledTextureRegion[9];

		rewardBoxRegion[0] = resourcesManager.reward_box_1;
		rewardBoxRegion[1] = resourcesManager.reward_box_2;
		rewardBoxRegion[2] = resourcesManager.reward_box_3;
		rewardBoxRegion[3] = resourcesManager.reward_box_4;
		rewardBoxRegion[4] = resourcesManager.reward_box_5;
		rewardBoxRegion[5] = resourcesManager.reward_box_6;
		rewardBoxRegion[6] = resourcesManager.reward_box_7;
		rewardBoxRegion[7] = resourcesManager.reward_box_8;
		rewardBoxRegion[8] = resourcesManager.reward_box_9;

		int h = 0;
		int y = 595;
		for (int i = 0; i < 3; i++) {
			int x = 420;
			for (int j = 0; j < 3; j++) {
				rewardBoxSprite[h] = new AnimatedSprite(x, y, rewardBoxRegion[h], vbom);
				h++;
				x += 265;
			}
			y -= 199;
		}

		for (int i = 0; i < rewardBoxSprite.length; i++) {
			attachChild(rewardBoxSprite[i]);
		}

	}

	// private void checkUnlockedBox1() {
	// if (DataManager.getInstance().getMaxUnlockedMysteryBox() == 0) {
	// // rewardBoxSprite[0].setVisible(false);
	// } else if (DataManager.getInstance().getMaxUnlockedMysteryBox() == 1) {
	// rewardBoxSprite[1].setVisible(false);
	// } else if (DataManager.getInstance().getMaxUnlockedMysteryBox() == 2) {
	// rewardBoxSprite[2].setVisible(false);
	// } else if (DataManager.getInstance().getMaxUnlockedMysteryBox() == 3) {
	// rewardBoxSprite[3].setVisible(false);
	// } else if (DataManager.getInstance().getMaxUnlockedMysteryBox() == 4) {
	// rewardBoxSprite[4].setVisible(false);
	// } else if (DataManager.getInstance().getMaxUnlockedMysteryBox() == 5) {
	// rewardBoxSprite[5].setVisible(false);
	// } else if (DataManager.getInstance().getMaxUnlockedMysteryBox() == 6) {
	// rewardBoxSprite[6].setVisible(false);
	// } else if (DataManager.getInstance().getMaxUnlockedMysteryBox() == 7) {
	// rewardBoxSprite[7].setVisible(false);
	// } else if (DataManager.getInstance().getMaxUnlockedMysteryBox() == 8) {
	// rewardBoxSprite[8].setVisible(false);
	// } else if (DataManager.getInstance().getMaxUnlockedMysteryBox() == 9) {
	// rewardBoxSprite[9].setVisible(false);
	// }
	// }

	private void checkUnlockedBox() {
		// DatabaseHandler dbHandler = new DatabaseHandler(activity);

		// dbHandler.addReward(new Reward("coba", 1));

		// Reward reward = databaseHandler.getReward(1);
		// reward.setStatus(DatabaseHandler.REWARD_LOCKED);
		// databaseHandler.updateReward(reward);
		// Reward reward2 = databaseHandler.getReward(6);
		// reward2.setStatus(DatabaseHandler.REWARD_LOCKED);
		// databaseHandler.updateReward(reward2);
		// Reward ngawur = new Reward(1, 0);
		// Reward ngawur2 = new Reward(2, 0);
		//
		// databaseHandler.updateReward(ngawur);
		// databaseHandler.updateReward(ngawur2);

		// Stage stage = databaseHandler.getStage(10);
		//
		// if (stage.getScore() ==0) {
		// rewardBoxSprite[8].setVisible(false);
		// }

		// List<Stage> stages = databaseHandler.getAllStages();

		// Stage stage = databaseHandler.getStage(2);
		// stage.setScore(0);
		// stage.setTurtleSaved(0);
		// databaseHandler.updateStage(stage);
		// List<Reward> rwds = databaseHandler.getAllRewards();
		// for (int i = 0; i < rwds.size(); i++) {
		// rwds.get(i).setStatus(DatabaseHandler.REWARD_LOCKED);
		// databaseHandler.updateReward(rwds.get(i));
		// }

		// Stage stage = databaseHandler.getSingleStage(30);
		// stage.setStatus(DatabaseHandler.STAGE_UNLOCKED);
		// databaseHandler.updateStage(stage);

		List<Reward> rewards = databaseHandler.getAllRewards();
		
		//cheat
//		for (int i = 0; i < rewards.size(); i++) {
//			rewards.get(i).setStatus(DatabaseHandler.REWARD_UNLOCKED);
//		}
		//cheat
		
		int count = 0;

		for (int i = 0; i < rewards.size(); i++) {
			switch (rewards.get(i).getStatus()) {
			case DatabaseHandler.REWARD_LOCKED:
				rewardBoxSprite[i].setCurrentTileIndex(0);
//				count++;
				break;
			case DatabaseHandler.REWARD_UNLOCKED:
				rewardBoxSprite[i].setCurrentTileIndex(1);
				count++;
				break;
			default:
				break;
			}
		}
		
		if (count == 9) {
			Sprite congratulation = new Sprite(680, 750, resourcesManager.reward_scene_congratulation_text_region, vbom);
			Sprite saved = new Sprite(680, 43, resourcesManager.reward_scene_saved_text_region, vbom);
			
			attachChild(congratulation);
			attachChild(saved);
		}
		// if (reward.getStatus() == 1) {
		// rewardBoxSprite[1].setVisible(false);
		// }
	}

	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
			float pMenuItemLocalX, float pMenuItemLocalY) {
		// TODO Auto-generated method stub
		resourcesManager.buttonSound.play();
		switch (pMenuItem.getID()) {
		case MENU_BACK:
			gTracker.sendEvent("back button", "user clicked back button", "back button reward scene", (long) 0);
			SceneManager.getInstance().setStageMenuScene();
			return true;
		default:
			return false;
		}
	}

}
