package com.kevinpratama.mathopia;

import java.util.ArrayList;
import java.util.List;

import org.andengine.engine.Engine;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.ui.IGameInterface.OnCreateSceneCallback;

import com.kevinpratama.mathopia.datamanager.Stage;
import com.kevinpratama.mathopia.gamescene.garisbilangan.GarisBilanganGameScene;
import com.kevinpratama.mathopia.gamescene.garisbilangan.GarisBilanganGameScene10;
import com.kevinpratama.mathopia.gamescene.garisbilangan.GarisBilanganGameScene2;
import com.kevinpratama.mathopia.gamescene.garisbilangan.GarisBilanganGameScene3;
import com.kevinpratama.mathopia.gamescene.garisbilangan.GarisBilanganGameScene4;
import com.kevinpratama.mathopia.gamescene.garisbilangan.GarisBilanganGameScene5;
import com.kevinpratama.mathopia.gamescene.garisbilangan.GarisBilanganGameScene6;
import com.kevinpratama.mathopia.gamescene.garisbilangan.GarisBilanganGameScene7;
import com.kevinpratama.mathopia.gamescene.garisbilangan.GarisBilanganGameScene8;
import com.kevinpratama.mathopia.gamescene.garisbilangan.GarisBilanganGameScene9;
import com.kevinpratama.mathopia.gamescene.pembagian.PembagianGameScene;
import com.kevinpratama.mathopia.gamescene.pembagian.PembagianGameScene10;
import com.kevinpratama.mathopia.gamescene.pembagian.PembagianGameScene2;
import com.kevinpratama.mathopia.gamescene.pembagian.PembagianGameScene3;
import com.kevinpratama.mathopia.gamescene.pembagian.PembagianGameScene4;
import com.kevinpratama.mathopia.gamescene.pembagian.PembagianGameScene5;
import com.kevinpratama.mathopia.gamescene.pembagian.PembagianGameScene6;
import com.kevinpratama.mathopia.gamescene.pembagian.PembagianGameScene7;
import com.kevinpratama.mathopia.gamescene.pembagian.PembagianGameScene8;
import com.kevinpratama.mathopia.gamescene.pembagian.PembagianGameScene9;
import com.kevinpratama.mathopia.gamescene.pengurangan.PenguranganGameScene;
import com.kevinpratama.mathopia.gamescene.pengurangan.PenguranganGameScene10;
import com.kevinpratama.mathopia.gamescene.pengurangan.PenguranganGameScene2;
import com.kevinpratama.mathopia.gamescene.pengurangan.PenguranganGameScene3;
import com.kevinpratama.mathopia.gamescene.pengurangan.PenguranganGameScene4;
import com.kevinpratama.mathopia.gamescene.pengurangan.PenguranganGameScene5;
import com.kevinpratama.mathopia.gamescene.pengurangan.PenguranganGameScene6;
import com.kevinpratama.mathopia.gamescene.pengurangan.PenguranganGameScene7;
import com.kevinpratama.mathopia.gamescene.pengurangan.PenguranganGameScene8;
import com.kevinpratama.mathopia.gamescene.pengurangan.PenguranganGameScene9;
import com.kevinpratama.mathopia.gamescene.penjumlahan.PenjumlahanGameScene;
import com.kevinpratama.mathopia.gamescene.penjumlahan.PenjumlahanGameScene10;
import com.kevinpratama.mathopia.gamescene.penjumlahan.PenjumlahanGameScene2;
import com.kevinpratama.mathopia.gamescene.penjumlahan.PenjumlahanGameScene3;
import com.kevinpratama.mathopia.gamescene.penjumlahan.PenjumlahanGameScene4;
import com.kevinpratama.mathopia.gamescene.penjumlahan.PenjumlahanGameScene5;
import com.kevinpratama.mathopia.gamescene.penjumlahan.PenjumlahanGameScene6;
import com.kevinpratama.mathopia.gamescene.penjumlahan.PenjumlahanGameScene7;
import com.kevinpratama.mathopia.gamescene.penjumlahan.PenjumlahanGameScene8;
import com.kevinpratama.mathopia.gamescene.penjumlahan.PenjumlahanGameScene9;
import com.kevinpratama.mathopia.gamescene.perkalian.PerkalianGameScene;
import com.kevinpratama.mathopia.gamescene.perkalian.PerkalianGameScene10;
import com.kevinpratama.mathopia.gamescene.perkalian.PerkalianGameScene2;
import com.kevinpratama.mathopia.gamescene.perkalian.PerkalianGameScene3;
import com.kevinpratama.mathopia.gamescene.perkalian.PerkalianGameScene4;
import com.kevinpratama.mathopia.gamescene.perkalian.PerkalianGameScene5;
import com.kevinpratama.mathopia.gamescene.perkalian.PerkalianGameScene6;
import com.kevinpratama.mathopia.gamescene.perkalian.PerkalianGameScene7;
import com.kevinpratama.mathopia.gamescene.perkalian.PerkalianGameScene8;
import com.kevinpratama.mathopia.gamescene.perkalian.PerkalianGameScene9;
import com.kevinpratama.mathopia.stagemenuscene.GarisBilanganStageMenuScene;
import com.kevinpratama.mathopia.stagemenuscene.PembagianStageMenuScene;
import com.kevinpratama.mathopia.stagemenuscene.PenguranganStageMenuScene;
import com.kevinpratama.mathopia.stagemenuscene.PenjumlahanStageMenuScene;
import com.kevinpratama.mathopia.stagemenuscene.PerkalianStageMenuScene;

public class SceneManager {
	// ---------------------------------------------
	// SCENES
	// ---------------------------------------------

	private BaseScene splashScene;
	public static BaseScene menuScene;
	// private BaseScene gameScene;
	public static BaseScene stageMenuScene;
	public static BaseScene rewardScene;
	public static BaseScene creditScene;
	public static BaseScene howToScene;

	public static BaseScene garisBilanganStageMenuScene;
	public static BaseScene penjumlahanStageMenuScene;
	public static BaseScene penguranganStageMenuScene;
	public static BaseScene perkalianStageMenuScene;
	public static BaseScene pembagianStageMenuScene;

	public static BaseScene garisBilanganGameScene;
	public static BaseScene penjumlahanGameScene;
	public static BaseScene penguranganGameScene;
	public static BaseScene perkalianGameScene;
	public static BaseScene pembagianGameScene;

	private BaseScene loadingScene;

	// ---------------------------------------------
	// VARIABLES
	// ---------------------------------------------

	private static final SceneManager INSTANCE = new SceneManager();

	private SceneType currentSceneType = SceneType.SCENE_SPLASH;

	private BaseScene currentScene;

	private final Engine engine = ResourceManager.getInstance().engine;

	public enum SceneType {
		SCENE_SPLASH, SCENE_MENU, SCENE_GAME, SCENE_LOADING,
	}

	// ---------------------------------------------
	// CLASS LOGIC
	// ---------------------------------------------

	public void setScene(BaseScene scene) {
		engine.setScene(scene);
		currentScene = scene;
		currentSceneType = scene.getSceneType();
	}

	public void setScene(SceneType sceneType) {
		switch (sceneType) {
		case SCENE_MENU:
			setScene(menuScene);
			break;
		// case SCENE_GAME:
		// setScene(gameScene);
		// break;
		case SCENE_SPLASH:
			setScene(splashScene);
			break;
		case SCENE_LOADING:
			setScene(loadingScene);
			break;
		default:
			break;
		}
	}

	// ---------------------------------------------
	// GETTERS AND SETTERS
	// ---------------------------------------------

	public static SceneManager getInstance() {
		return INSTANCE;
	}

	public SceneType getCurrentSceneType() {
		return currentSceneType;
	}

	public BaseScene getCurrentScene() {
		return currentScene;
	}

	public void createSplashScene(OnCreateSceneCallback pOnCreateSceneCallback) {
		ResourceManager.getInstance().loadSplashScreen();
		splashScene = new SplashScene();
		currentScene = splashScene;
		pOnCreateSceneCallback.onCreateSceneFinished(splashScene);
	}

	private void disposeSplashScene() {
		ResourceManager.getInstance().unloadSplashScreen();
		splashScene.disposeScene();
		splashScene = null;
	}

	public void createMenuScene() {
		ResourceManager.getInstance().loadLoadingScene();
		loadingScene = new LoadingScene();

		loadAllMenuSceneResources();

		disposeSplashScene();
		SceneManager.getInstance().setScene(menuScene);
	}

	public void setMenuScene() {
		ResourceManager.getInstance().gTracker.sendView("Main Menu Scene");
		setScene(menuScene);
	}

	public void loadGameScene() {
		setScene(loadingScene);
	}

	public void setStageMenuScene() {
		ResourceManager.getInstance().gTracker.sendView("Stage Menu Scene");
		setScene(stageMenuScene);
	}

	public void setRewardScene() {
//		loadRewardScene();
		ResourceManager.getInstance().gTracker.sendView("Reward Scene");
		setScene(rewardScene);
	}

	public void setCreditScene() {
		ResourceManager.getInstance().gTracker.sendView("Credit Scene");
		setScene(creditScene);
	}

	public void setHowToScene() {
		ResourceManager.getInstance().gTracker.sendView("How To Scene");
		setScene(howToScene);
	}

	public void setGarisBilanganStageMenuScene() {
		ResourceManager.getInstance().gTracker.sendView("GB Stage Menu Scene");
		setScene(garisBilanganStageMenuScene);
	}

	public void setPenjumlahanStageMenuScene() {
		ResourceManager.getInstance().gTracker
				.sendView("Penjumlahan Stage Menu Scene");
		setScene(penjumlahanStageMenuScene);
	}

	public void setPenguranganStageMenuScene() {
		ResourceManager.getInstance().gTracker
				.sendView("Pengurangan Stage Menu Scene");
		setScene(penguranganStageMenuScene);
	}

	public void setPerkalianStageMenuScene() {
		ResourceManager.getInstance().gTracker
				.sendView("Perkalian Stage Menu Scene");
		setScene(perkalianStageMenuScene);
	}

	public void setPembagianStageMenuScene() {
		ResourceManager.getInstance().gTracker
				.sendView("Pembagian Stage Menu Scene");
		setScene(pembagianStageMenuScene);
	}
	
//	private void loadRewardScene(){
//		unloadAllMenuSceneResources();
//		disposeAllMenuScene();
//		ResourceManager.getInstance().loadRewardSceneGraphics();
//		rewardScene = new RewardScene();
//	}

	private void loadAllMenuSceneResources() {
		ResourceManager.getInstance().loadMenuResources();
		ResourceManager.getInstance().loadStageMenuGraphics();
		ResourceManager.getInstance().loadRewardSceneGraphics();
		ResourceManager.getInstance().loadCreditScene();
		ResourceManager.getInstance().loadHowToScene();

		ResourceManager.getInstance().loadAllStagesMenuGraphics();

		menuScene = new MainMenuScene();
		stageMenuScene = new StageMenuScene();
		rewardScene = new RewardScene();
		creditScene = new CreditScene();
		howToScene = new HowToScene();

		List<Stage> allStages = ResourceManager.getInstance().databaseHandler
				.getAllStages();
		List<Stage> garisBilanganStages = new ArrayList<Stage>();
		List<Stage> penjumlahanStages = new ArrayList<Stage>();
		List<Stage> penguranganStages = new ArrayList<Stage>();
		List<Stage> perkalianStages = new ArrayList<Stage>();
		List<Stage> pembagianStages = new ArrayList<Stage>();

		for (int i = 0; i < allStages.size(); i++) {
			if (i < 10) {
				garisBilanganStages.add(allStages.get(i));

			} else if (i >= 10 && i < 20) {
				penjumlahanStages.add(allStages.get(i));

			} else if (i >= 20 && i < 30) {
				penguranganStages.add(allStages.get(i));

			} else if (i >= 30 && i < 40) {
				perkalianStages.add(allStages.get(i));

			} else if (i >= 40 && i < 50) {
				pembagianStages.add(allStages.get(i));

			} else {

			}
		}

		garisBilanganStageMenuScene = new GarisBilanganStageMenuScene(
				garisBilanganStages);
		penjumlahanStageMenuScene = new PenjumlahanStageMenuScene(
				penjumlahanStages);
		penguranganStageMenuScene = new PenguranganStageMenuScene(
				penguranganStages);
		perkalianStageMenuScene = new PerkalianStageMenuScene(perkalianStages);
		pembagianStageMenuScene = new PembagianStageMenuScene(pembagianStages);
	}

	private void unloadAllMenuSceneResources() {
		ResourceManager.getInstance().unloadMenuResources();

		ResourceManager.getInstance().unloadStageMenuTexture();

		ResourceManager.getInstance().unloadAllStagesMenuGraphics();

		ResourceManager.getInstance().unloadRewardSceneTexture();

		ResourceManager.getInstance().unloadCreditScene();

		ResourceManager.getInstance().unloadHowToScene();
	}

	private void disposeAllMenuScene() {
		menuScene.disposeScene();
		stageMenuScene.disposeScene();
		garisBilanganStageMenuScene.disposeScene();
		penjumlahanStageMenuScene.disposeScene();
		penguranganStageMenuScene.disposeScene();
		perkalianStageMenuScene.disposeScene();
		pembagianStageMenuScene.disposeScene();
		rewardScene.disposeScene();
	}

	public void onResetApplicationData() {
		setScene(loadingScene);
		unloadAllMenuSceneResources();
		loadAllMenuSceneResources();
		setCreditScene();
	}

//	private void onLoadGarisBilanganStageMenuFromGameScene() {
//
//		ResourceManager.getInstance().loadMenuResourcesAgain();
//		ResourceManager.getInstance().loadStageMenuTexture();
//		ResourceManager.getInstance().loadRewardSceneTexture();
//		ResourceManager.getInstance().loadCreditSceneTexture();
//		ResourceManager.getInstance().loadHowToSceneTexture();
//		ResourceManager.getInstance().loadAllStagesMenuGraphicsTexture();
//		
//		List<Stage> garisBilanganStages = ResourceManager.getInstance().databaseHandler
//				.getStages(DatabaseHandler.GARIS_BILANGAN_STAGE_START_ID);
//		garisBilanganStageMenuScene = new GarisBilanganStageMenuScene(
//				garisBilanganStages);
//	}

	public void loadGarisBilanganStageMenuSceneFromGameScene(
			final Engine mEngine) {
		setScene(loadingScene);
		ResourceManager.getInstance().unloadGarisBilanganGameResource();

		mEngine.registerUpdateHandler(new TimerHandler(1, new ITimerCallback() {

			@Override
			public void onTimePassed(TimerHandler pTimerHandler) {
				// TODO Auto-generated method stub
				mEngine.unregisterUpdateHandler(pTimerHandler);

				loadAllMenuSceneResources();
//				onLoadGarisBilanganStageMenuFromGameScene();

				ResourceManager.getInstance().backSound.play();
				SceneManager.getInstance()
						.setScene(garisBilanganStageMenuScene);
			}
		}));
	}

	public void loadGarisBilanganGameScene(final Engine mEngine,
			final int sceneNumber) {
		setScene(loadingScene);
		unloadAllMenuSceneResources();
		disposeAllMenuScene();
		mEngine.registerUpdateHandler(new TimerHandler(1, new ITimerCallback() {

			@Override
			public void onTimePassed(TimerHandler pTimerHandler) {
				// TODO Auto-generated method stub
				mEngine.unregisterUpdateHandler(pTimerHandler);
				// ResourceManager.getInstance().loadGameSceneAudio();
				switch (sceneNumber) {
				case GarisBilanganStageMenuScene.MENU_GARIS_BILANGAN_1:
					ResourceManager.getInstance().loadGarisBilanganGameScene();
					garisBilanganGameScene = new GarisBilanganGameScene();
					ResourceManager.getInstance().gTracker
							.sendView("GB Game Scene 1");
					break;
				case GarisBilanganStageMenuScene.MENU_GARIS_BILANGAN_2:
					ResourceManager.getInstance().loadGarisBilanganGameScene2();
					garisBilanganGameScene = new GarisBilanganGameScene2();
					ResourceManager.getInstance().gTracker
							.sendView("GB Game Scene 2");
					break;
				case GarisBilanganStageMenuScene.MENU_GARIS_BILANGAN_3:
					ResourceManager.getInstance().loadGarisBilanganGameScene3();
					garisBilanganGameScene = new GarisBilanganGameScene3();
					ResourceManager.getInstance().gTracker
							.sendView("GB Game Scene 3");
					break;
				case GarisBilanganStageMenuScene.MENU_GARIS_BILANGAN_4:
					ResourceManager.getInstance().loadGarisBilanganGameScene4();
					garisBilanganGameScene = new GarisBilanganGameScene4();
					ResourceManager.getInstance().gTracker
							.sendView("GB Game Scene 4");
					break;
				case GarisBilanganStageMenuScene.MENU_GARIS_BILANGAN_5:
					ResourceManager.getInstance().loadGarisBilanganGameScene5();
					garisBilanganGameScene = new GarisBilanganGameScene5();
					ResourceManager.getInstance().gTracker
							.sendView("GB Game Scene 5");
					break;
				case GarisBilanganStageMenuScene.MENU_GARIS_BILANGAN_6:
					ResourceManager.getInstance().loadGarisBilanganGameScene6();
					garisBilanganGameScene = new GarisBilanganGameScene6();
					ResourceManager.getInstance().gTracker
							.sendView("GB Game Scene 6");
					break;
				case GarisBilanganStageMenuScene.MENU_GARIS_BILANGAN_7:
					ResourceManager.getInstance().loadGarisBilanganGameScene7();
					garisBilanganGameScene = new GarisBilanganGameScene7();
					ResourceManager.getInstance().gTracker
							.sendView("GB Game Scene 7");
					break;
				case GarisBilanganStageMenuScene.MENU_GARIS_BILANGAN_8:
					ResourceManager.getInstance().loadGarisBilanganGameScene8();
					garisBilanganGameScene = new GarisBilanganGameScene8();
					ResourceManager.getInstance().gTracker
							.sendView("GB Game Scene 8");
					break;
				case GarisBilanganStageMenuScene.MENU_GARIS_BILANGAN_9:
					ResourceManager.getInstance().loadGarisBilanganGameScene9();
					garisBilanganGameScene = new GarisBilanganGameScene9();
					ResourceManager.getInstance().gTracker
							.sendView("GB Game Scene 9");
					break;
				case GarisBilanganStageMenuScene.MENU_GARIS_BILANGAN_10:
					ResourceManager.getInstance()
							.loadGarisBilanganGameScene10();
					garisBilanganGameScene = new GarisBilanganGameScene10();
					ResourceManager.getInstance().gTracker
							.sendView("GB Game Scene 10");
					break;
				default:
					break;
				}
				setScene(garisBilanganGameScene);
			}
		}));
	}

	public void resetGarisBilanganGameScene(final Engine mEngine,
			final int sceneNumber) {
		setScene(loadingScene);
		ResourceManager.getInstance().unloadGarisBilanganGameResource();
		mEngine.registerUpdateHandler(new TimerHandler(1, new ITimerCallback() {
			@Override
			public void onTimePassed(TimerHandler pTimerHandler) {
				// TODO Auto-generated method stub
				mEngine.unregisterUpdateHandler(pTimerHandler);
				switch (sceneNumber) {
				case 1:
					ResourceManager.getInstance().loadGarisBilanganGameScene();
					garisBilanganGameScene = new GarisBilanganGameScene();
					ResourceManager.getInstance().gTracker
							.sendView("GB Reset Game Scene 1");
					break;
				case 2:
					ResourceManager.getInstance().loadGarisBilanganGameScene2();
					garisBilanganGameScene = new GarisBilanganGameScene2();
					ResourceManager.getInstance().gTracker
							.sendView("GB Reset Game Scene 2");
					break;
				case 3:
					ResourceManager.getInstance().loadGarisBilanganGameScene3();
					garisBilanganGameScene = new GarisBilanganGameScene3();
					ResourceManager.getInstance().gTracker
							.sendView("GB Reset Game Scene 3");
					break;
				case 4:
					ResourceManager.getInstance().loadGarisBilanganGameScene4();
					garisBilanganGameScene = new GarisBilanganGameScene4();
					ResourceManager.getInstance().gTracker
							.sendView("GB Reset Game Scene 4");
					break;
				case 5:
					ResourceManager.getInstance().loadGarisBilanganGameScene5();
					garisBilanganGameScene = new GarisBilanganGameScene5();
					ResourceManager.getInstance().gTracker
							.sendView("GB Reset Game Scene 5");
					break;
				case 6:
					ResourceManager.getInstance().loadGarisBilanganGameScene6();
					garisBilanganGameScene = new GarisBilanganGameScene6();
					ResourceManager.getInstance().gTracker
							.sendView("GB Reset Game Scene 6");
					break;
				case 7:
					ResourceManager.getInstance().loadGarisBilanganGameScene7();
					garisBilanganGameScene = new GarisBilanganGameScene7();
					ResourceManager.getInstance().gTracker
							.sendView("GB Reset Game Scene 7");
					break;
				case 8:
					ResourceManager.getInstance().loadGarisBilanganGameScene8();
					garisBilanganGameScene = new GarisBilanganGameScene8();
					ResourceManager.getInstance().gTracker
							.sendView("GB Reset Game Scene 8");
					break;
				case 9:
					ResourceManager.getInstance().loadGarisBilanganGameScene9();
					garisBilanganGameScene = new GarisBilanganGameScene9();
					ResourceManager.getInstance().gTracker
							.sendView("GB Reset Game Scene 9");
					break;
				case 10:
					ResourceManager.getInstance()
							.loadGarisBilanganGameScene10();
					garisBilanganGameScene = new GarisBilanganGameScene10();
					ResourceManager.getInstance().gTracker
							.sendView("GB Reset Game Scene 10");
					break;
				default:
					break;
				}
				setScene(garisBilanganGameScene);
			}
		}));
	}

	public void loadPenjumlahanStageMenuSceneFromGameScene(final Engine mEngine) {
		setScene(loadingScene);
		ResourceManager.getInstance().unloadPenjumlahanGameResource();

		mEngine.registerUpdateHandler(new TimerHandler(1, new ITimerCallback() {

			@Override
			public void onTimePassed(TimerHandler pTimerHandler) {
				// TODO Auto-generated method stub
				mEngine.unregisterUpdateHandler(pTimerHandler);

				loadAllMenuSceneResources();

				ResourceManager.getInstance().backSound.play();
				SceneManager.getInstance().setScene(penjumlahanStageMenuScene);
			}
		}));
	}

	public void loadPenjumlahanGameScene(final Engine mEngine,
			final int sceneNumber) {
		setScene(loadingScene);
		unloadAllMenuSceneResources();
		disposeAllMenuScene();
		mEngine.registerUpdateHandler(new TimerHandler(1, new ITimerCallback() {

			@Override
			public void onTimePassed(TimerHandler pTimerHandler) {
				// TODO Auto-generated method stub
				mEngine.unregisterUpdateHandler(pTimerHandler);
				// ResourceManager.getInstance().loadGameSceneAudio();
				switch (sceneNumber) {
				case PenjumlahanStageMenuScene.MENU_PENJUMLAHAN_1:
					ResourceManager.getInstance().loadPenjumlahanGameScene();
					penjumlahanGameScene = new PenjumlahanGameScene();
					ResourceManager.getInstance().gTracker
							.sendView("Penjumlahan Game Scene 1");
					break;
				case PenjumlahanStageMenuScene.MENU_PENJUMLAHAN_2:
					ResourceManager.getInstance().loadPenjumlahanGameScene2();
					penjumlahanGameScene = new PenjumlahanGameScene2();
					ResourceManager.getInstance().gTracker
							.sendView("Penjumlahan Game Scene 2");
					break;
				case PenjumlahanStageMenuScene.MENU_PENJUMLAHAN_3:
					ResourceManager.getInstance().loadPenjumlahanGameScene3();
					penjumlahanGameScene = new PenjumlahanGameScene3();
					ResourceManager.getInstance().gTracker
							.sendView("Penjumlahan Game Scene 3");
					break;
				case PenjumlahanStageMenuScene.MENU_PENJUMLAHAN_4:
					ResourceManager.getInstance().loadPenjumlahanGameScene4();
					penjumlahanGameScene = new PenjumlahanGameScene4();
					ResourceManager.getInstance().gTracker
							.sendView("Penjumlahan Game Scene 4");
					break;
				case PenjumlahanStageMenuScene.MENU_PENJUMLAHAN_5:
					ResourceManager.getInstance().loadPenjumlahanGameScene5();
					penjumlahanGameScene = new PenjumlahanGameScene5();
					ResourceManager.getInstance().gTracker
							.sendView("Penjumlahan Game Scene 5");
					break;
				case PenjumlahanStageMenuScene.MENU_PENJUMLAHAN_6:
					ResourceManager.getInstance().loadPenjumlahanGameScene6();
					penjumlahanGameScene = new PenjumlahanGameScene6();
					ResourceManager.getInstance().gTracker
							.sendView("Penjumlahan Game Scene 6");
					break;
				case PenjumlahanStageMenuScene.MENU_PENJUMLAHAN_7:
					ResourceManager.getInstance().loadPenjumlahanGameScene7();
					penjumlahanGameScene = new PenjumlahanGameScene7();
					ResourceManager.getInstance().gTracker
							.sendView("Penjumlahan Game Scene 7");
					break;
				case PenjumlahanStageMenuScene.MENU_PENJUMLAHAN_8:
					ResourceManager.getInstance().loadPenjumlahanGameScene8();
					penjumlahanGameScene = new PenjumlahanGameScene8();
					ResourceManager.getInstance().gTracker
							.sendView("Penjumlahan Game Scene 8");
					break;
				case PenjumlahanStageMenuScene.MENU_PENJUMLAHAN_9:
					ResourceManager.getInstance().loadPenjumlahanGameScene9();
					penjumlahanGameScene = new PenjumlahanGameScene9();
					ResourceManager.getInstance().gTracker
							.sendView("Penjumlahan Game Scene 9");
					break;
				case PenjumlahanStageMenuScene.MENU_PENJUMLAHAN_10:
					ResourceManager.getInstance().loadPenjumlahanGameScene10();
					penjumlahanGameScene = new PenjumlahanGameScene10();
					ResourceManager.getInstance().gTracker
							.sendView("Penjumlahan Game Scene 10");
					break;
				default:
					break;
				}
				setScene(penjumlahanGameScene);
			}
		}));
	}

	public void resetPenjumlahanGameScene(final Engine mEngine,
			final int sceneNumber) {
		setScene(loadingScene);
		ResourceManager.getInstance().unloadPenjumlahanGameResource();
		mEngine.registerUpdateHandler(new TimerHandler(1, new ITimerCallback() {
			@Override
			public void onTimePassed(TimerHandler pTimerHandler) {
				// TODO Auto-generated method stub
				mEngine.unregisterUpdateHandler(pTimerHandler);
				switch (sceneNumber) {
				case 11:
					ResourceManager.getInstance().loadPenjumlahanGameScene();
					penjumlahanGameScene = new PenjumlahanGameScene();
					ResourceManager.getInstance().gTracker
							.sendView("Penjumlahan Reset Game Scene 1");
					break;
				case 12:
					ResourceManager.getInstance().loadPenjumlahanGameScene2();
					penjumlahanGameScene = new PenjumlahanGameScene2();
					ResourceManager.getInstance().gTracker
							.sendView("Penjumlahan Reset Game Scene 2");
					break;
				case 13:
					ResourceManager.getInstance().loadPenjumlahanGameScene3();
					penjumlahanGameScene = new PenjumlahanGameScene3();
					ResourceManager.getInstance().gTracker
							.sendView("Penjumlahan Reset Game Scene 3");
					break;
				case 14:
					ResourceManager.getInstance().loadPenjumlahanGameScene4();
					penjumlahanGameScene = new PenjumlahanGameScene4();
					ResourceManager.getInstance().gTracker
							.sendView("Penjumlahan Reset Game Scene 4");
					break;
				case 15:
					ResourceManager.getInstance().loadPenjumlahanGameScene5();
					penjumlahanGameScene = new PenjumlahanGameScene5();
					ResourceManager.getInstance().gTracker
							.sendView("Penjumlahan Reset Game Scene 5");
					break;
				case 16:
					ResourceManager.getInstance().loadPenjumlahanGameScene6();
					penjumlahanGameScene = new PenjumlahanGameScene6();
					ResourceManager.getInstance().gTracker
							.sendView("Penjumlahan Reset Game Scene 6");
					break;
				case 17:
					ResourceManager.getInstance().loadPenjumlahanGameScene7();
					penjumlahanGameScene = new PenjumlahanGameScene7();
					ResourceManager.getInstance().gTracker
							.sendView("Penjumlahan Reset Game Scene 7");
					break;
				case 18:
					ResourceManager.getInstance().loadPenjumlahanGameScene8();
					penjumlahanGameScene = new PenjumlahanGameScene8();
					ResourceManager.getInstance().gTracker
							.sendView("Penjumlahan Reset Game Scene 8");
					break;
				case 19:
					ResourceManager.getInstance().loadPenjumlahanGameScene9();
					penjumlahanGameScene = new PenjumlahanGameScene9();
					ResourceManager.getInstance().gTracker
							.sendView("Penjumlahan Reset Game Scene 9");
					break;
				case 20:
					ResourceManager.getInstance().loadPenjumlahanGameScene10();
					penjumlahanGameScene = new PenjumlahanGameScene10();
					ResourceManager.getInstance().gTracker
							.sendView("Penjumlahan Reset Game Scene 10");
					break;
				default:
					break;
				}
				setScene(penjumlahanGameScene);
			}
		}));
	}

	public void loadPenguranganStageMenuSceneFromGameScene(final Engine mEngine) {
		setScene(loadingScene);
		ResourceManager.getInstance().unloadPenguranganGameResource();

		mEngine.registerUpdateHandler(new TimerHandler(1, new ITimerCallback() {

			@Override
			public void onTimePassed(TimerHandler pTimerHandler) {
				// TODO Auto-generated method stub
				mEngine.unregisterUpdateHandler(pTimerHandler);

				loadAllMenuSceneResources();

				ResourceManager.getInstance().backSound.play();
				SceneManager.getInstance().setScene(penguranganStageMenuScene);
			}
		}));
	}

	public void loadPenguranganGameScene(final Engine mEngine,
			final int sceneNumber) {
		setScene(loadingScene);
		unloadAllMenuSceneResources();
		disposeAllMenuScene();
		mEngine.registerUpdateHandler(new TimerHandler(1, new ITimerCallback() {

			@Override
			public void onTimePassed(TimerHandler pTimerHandler) {
				// TODO Auto-generated method stub
				mEngine.unregisterUpdateHandler(pTimerHandler);
				// ResourceManager.getInstance().loadGameSceneAudio();
				switch (sceneNumber) {
				case PenguranganStageMenuScene.MENU_PENGURANGAN_1:
					ResourceManager.getInstance().loadPenguranganGameScene();
					penguranganGameScene = new PenguranganGameScene();
					ResourceManager.getInstance().gTracker
							.sendView("Pengurangan Game Scene 1");
					break;
				case PenguranganStageMenuScene.MENU_PENGURANGAN_2:
					ResourceManager.getInstance().loadPenguranganGameScene2();
					penguranganGameScene = new PenguranganGameScene2();
					ResourceManager.getInstance().gTracker
							.sendView("Pengurangan Game Scene 2");
					break;
				case PenguranganStageMenuScene.MENU_PENGURANGAN_3:
					ResourceManager.getInstance().loadPenguranganGameScene3();
					penguranganGameScene = new PenguranganGameScene3();
					ResourceManager.getInstance().gTracker
							.sendView("Pengurangan Game Scene 3");
					break;
				case PenguranganStageMenuScene.MENU_PENGURANGAN_4:
					ResourceManager.getInstance().loadPenguranganGameScene4();
					penguranganGameScene = new PenguranganGameScene4();
					ResourceManager.getInstance().gTracker
							.sendView("Pengurangan Game Scene 4");
					break;
				case PenguranganStageMenuScene.MENU_PENGURANGAN_5:
					ResourceManager.getInstance().loadPenguranganGameScene5();
					penguranganGameScene = new PenguranganGameScene5();
					ResourceManager.getInstance().gTracker
							.sendView("Pengurangan Game Scene 5");
					break;
				case PenguranganStageMenuScene.MENU_PENGURANGAN_6:
					ResourceManager.getInstance().loadPenguranganGameScene6();
					penguranganGameScene = new PenguranganGameScene6();
					ResourceManager.getInstance().gTracker
							.sendView("Pengurangan Game Scene 6");
					break;
				case PenguranganStageMenuScene.MENU_PENGURANGAN_7:
					ResourceManager.getInstance().loadPenguranganGameScene7();
					penguranganGameScene = new PenguranganGameScene7();
					ResourceManager.getInstance().gTracker
							.sendView("Pengurangan Game Scene 7");
					break;
				case PenguranganStageMenuScene.MENU_PENGURANGAN_8:
					ResourceManager.getInstance().loadPenguranganGameScene8();
					penguranganGameScene = new PenguranganGameScene8();
					ResourceManager.getInstance().gTracker
							.sendView("Pengurangan Game Scene 8");
					break;
				case PenguranganStageMenuScene.MENU_PENGURANGAN_9:
					ResourceManager.getInstance().loadPenguranganGameScene9();
					penguranganGameScene = new PenguranganGameScene9();
					ResourceManager.getInstance().gTracker
							.sendView("Pengurangan Game Scene 9");
					break;
				case PenguranganStageMenuScene.MENU_PENGURANGAN_10:
					ResourceManager.getInstance().loadPenguranganGameScene10();
					penguranganGameScene = new PenguranganGameScene10();
					ResourceManager.getInstance().gTracker
							.sendView("Pengurangan Game Scene 10");
					break;
				default:
					break;
				}
				setScene(penguranganGameScene);
			}
		}));
	}

	public void resetPenguranganGameScene(final Engine mEngine,
			final int sceneNumber) {
		setScene(loadingScene);
		ResourceManager.getInstance().unloadPenguranganGameResource();
		mEngine.registerUpdateHandler(new TimerHandler(1, new ITimerCallback() {
			@Override
			public void onTimePassed(TimerHandler pTimerHandler) {
				// TODO Auto-generated method stub
				mEngine.unregisterUpdateHandler(pTimerHandler);
				switch (sceneNumber) {
				case 21:
					ResourceManager.getInstance().loadPenguranganGameScene();
					penguranganGameScene = new PenguranganGameScene();
					ResourceManager.getInstance().gTracker
							.sendView("Pengurangan Reset Game Scene 1");
					break;
				case 22:
					ResourceManager.getInstance().loadPenguranganGameScene2();
					penguranganGameScene = new PenguranganGameScene2();
					ResourceManager.getInstance().gTracker
							.sendView("Pengurangan Reset Game Scene 2");
					break;
				case 23:
					ResourceManager.getInstance().loadPenguranganGameScene3();
					penguranganGameScene = new PenguranganGameScene3();
					ResourceManager.getInstance().gTracker
							.sendView("Pengurangan Reset Game Scene 3");
					break;
				case 24:
					ResourceManager.getInstance().loadPenguranganGameScene4();
					penguranganGameScene = new PenguranganGameScene4();
					ResourceManager.getInstance().gTracker
							.sendView("Pengurangan Reset Game Scene 4");
					;
				case 25:
					ResourceManager.getInstance().loadPenguranganGameScene5();
					penguranganGameScene = new PenguranganGameScene5();
					ResourceManager.getInstance().gTracker
							.sendView("Pengurangan Reset Game Scene 5");
					;
				case 26:
					ResourceManager.getInstance().loadPenguranganGameScene6();
					penguranganGameScene = new PenguranganGameScene6();
					ResourceManager.getInstance().gTracker
							.sendView("Pengurangan Reset Game Scene 6");
					break;
				case 27:
					ResourceManager.getInstance().loadPenguranganGameScene7();
					penguranganGameScene = new PenguranganGameScene7();
					ResourceManager.getInstance().gTracker
							.sendView("Pengurangan Reset Game Scene 7");
					break;
				case 28:
					ResourceManager.getInstance().loadPenguranganGameScene8();
					penguranganGameScene = new PenguranganGameScene8();
					ResourceManager.getInstance().gTracker
							.sendView("Pengurangan Reset Game Scene 8");
					break;
				case 29:
					ResourceManager.getInstance().loadPenguranganGameScene9();
					penguranganGameScene = new PenguranganGameScene9();
					ResourceManager.getInstance().gTracker
							.sendView("Pengurangan Reset Game Scene 9");
					break;
				case 30:
					ResourceManager.getInstance().loadPenguranganGameScene10();
					penguranganGameScene = new PenguranganGameScene10();
					ResourceManager.getInstance().gTracker
							.sendView("Pengurangan Reset Game Scene 10");
					break;
				default:
					break;
				}
				setScene(penguranganGameScene);
			}
		}));
	}

	public void loadPerkalianStageMenuSceneFromGameScene(final Engine mEngine) {
		setScene(loadingScene);
		ResourceManager.getInstance().unloadPerkalianGameResource();

		mEngine.registerUpdateHandler(new TimerHandler(1, new ITimerCallback() {

			@Override
			public void onTimePassed(TimerHandler pTimerHandler) {
				// TODO Auto-generated method stub
				mEngine.unregisterUpdateHandler(pTimerHandler);

				loadAllMenuSceneResources();

				ResourceManager.getInstance().backSound.play();
				SceneManager.getInstance().setScene(perkalianStageMenuScene);
			}
		}));
	}

	public void loadPerkalianGameScene(final Engine mEngine,
			final int sceneNumber) {
		setScene(loadingScene);
		unloadAllMenuSceneResources();
		disposeAllMenuScene();
		mEngine.registerUpdateHandler(new TimerHandler(1, new ITimerCallback() {

			@Override
			public void onTimePassed(TimerHandler pTimerHandler) {
				// TODO Auto-generated method stub
				mEngine.unregisterUpdateHandler(pTimerHandler);
				// ResourceManager.getInstance().loadGameSceneAudio();
				switch (sceneNumber) {
				case PerkalianStageMenuScene.MENU_PERKALIAN_1:
					ResourceManager.getInstance().loadPerkalianGameScene();
					perkalianGameScene = new PerkalianGameScene();
					ResourceManager.getInstance().gTracker
							.sendView("Perkalian Game Scene 1");
					break;
				case PerkalianStageMenuScene.MENU_PERKALIAN_2:
					ResourceManager.getInstance().loadPerkalianGameScene2();
					perkalianGameScene = new PerkalianGameScene2();
					ResourceManager.getInstance().gTracker
							.sendView("Perkalian Game Scene 2");
					break;
				case PerkalianStageMenuScene.MENU_PERKALIAN_3:
					ResourceManager.getInstance().loadPerkalianGameScene3();
					perkalianGameScene = new PerkalianGameScene3();
					ResourceManager.getInstance().gTracker
							.sendView("Perkalian Game Scene 3");
					break;
				case PerkalianStageMenuScene.MENU_PERKALIAN_4:
					ResourceManager.getInstance().loadPerkalianGameScene4();
					perkalianGameScene = new PerkalianGameScene4();
					ResourceManager.getInstance().gTracker
							.sendView("Perkalian Game Scene 4");
					break;
				case PerkalianStageMenuScene.MENU_PERKALIAN_5:
					ResourceManager.getInstance().loadPerkalianGameScene5();
					perkalianGameScene = new PerkalianGameScene5();
					ResourceManager.getInstance().gTracker
							.sendView("Perkalian Game Scene 5");
					break;
				case PerkalianStageMenuScene.MENU_PERKALIAN_6:
					ResourceManager.getInstance().loadPerkalianGameScene6();
					perkalianGameScene = new PerkalianGameScene6();
					ResourceManager.getInstance().gTracker
							.sendView("Perkalian Game Scene 6");
					break;
				case PerkalianStageMenuScene.MENU_PERKALIAN_7:
					ResourceManager.getInstance().loadPerkalianGameScene7();
					perkalianGameScene = new PerkalianGameScene7();
					ResourceManager.getInstance().gTracker
							.sendView("Perkalian Game Scene 7");
					break;
				case PerkalianStageMenuScene.MENU_PERKALIAN_8:
					ResourceManager.getInstance().loadPerkalianGameScene8();
					perkalianGameScene = new PerkalianGameScene8();
					ResourceManager.getInstance().gTracker
							.sendView("Perkalian Game Scene 8");
					break;
				case PerkalianStageMenuScene.MENU_PERKALIAN_9:
					ResourceManager.getInstance().loadPerkalianGameScene9();
					perkalianGameScene = new PerkalianGameScene9();
					ResourceManager.getInstance().gTracker
							.sendView("Perkalian Game Scene 9");
					break;
				case PerkalianStageMenuScene.MENU_PERKALIAN_10:
					ResourceManager.getInstance().loadPerkalianGameScene10();
					perkalianGameScene = new PerkalianGameScene10();
					ResourceManager.getInstance().gTracker
							.sendView("Perkalian Game Scene 10");
					break;
				default:
					break;
				}
				setScene(perkalianGameScene);
			}
		}));
	}

	public void resetPerkalianGameScene(final Engine mEngine,
			final int sceneNumber) {
		setScene(loadingScene);
		ResourceManager.getInstance().unloadPerkalianGameResource();
		mEngine.registerUpdateHandler(new TimerHandler(1, new ITimerCallback() {
			@Override
			public void onTimePassed(TimerHandler pTimerHandler) {
				// TODO Auto-generated method stub
				mEngine.unregisterUpdateHandler(pTimerHandler);
				switch (sceneNumber) {
				case 31:
					ResourceManager.getInstance().loadPerkalianGameScene();
					perkalianGameScene = new PerkalianGameScene();
					ResourceManager.getInstance().gTracker
							.sendView("Perkalian Reset Game Scene 1");
					break;
				case 32:
					ResourceManager.getInstance().loadPerkalianGameScene2();
					perkalianGameScene = new PerkalianGameScene2();
					ResourceManager.getInstance().gTracker
							.sendView("Perkalian Reset Game Scene 2");
					break;
				case 33:
					ResourceManager.getInstance().loadPerkalianGameScene3();
					perkalianGameScene = new PerkalianGameScene3();
					ResourceManager.getInstance().gTracker
							.sendView("Perkalian Reset Game Scene 3");
					break;
				case 34:
					ResourceManager.getInstance().loadPerkalianGameScene4();
					perkalianGameScene = new PerkalianGameScene4();
					ResourceManager.getInstance().gTracker
							.sendView("Perkalian Reset Game Scene 4");
					break;
				case 35:
					ResourceManager.getInstance().loadPerkalianGameScene5();
					perkalianGameScene = new PerkalianGameScene5();
					ResourceManager.getInstance().gTracker
							.sendView("Perkalian Reset Game Scene 5");
					break;
				case 36:
					ResourceManager.getInstance().loadPerkalianGameScene6();
					perkalianGameScene = new PerkalianGameScene6();
					ResourceManager.getInstance().gTracker
							.sendView("Perkalian Reset Game Scene 6");
					break;
				case 37:
					ResourceManager.getInstance().loadPerkalianGameScene7();
					perkalianGameScene = new PerkalianGameScene7();
					ResourceManager.getInstance().gTracker
							.sendView("Perkalian Reset Game Scene 7");
					break;
				case 38:
					ResourceManager.getInstance().loadPerkalianGameScene8();
					perkalianGameScene = new PerkalianGameScene8();
					ResourceManager.getInstance().gTracker
							.sendView("Perkalian Reset Game Scene 8");
					break;
				case 39:
					ResourceManager.getInstance().loadPerkalianGameScene9();
					perkalianGameScene = new PerkalianGameScene9();
					ResourceManager.getInstance().gTracker
							.sendView("Perkalian Reset Game Scene 9");
					;
				case 40:
					ResourceManager.getInstance().loadPerkalianGameScene10();
					perkalianGameScene = new PerkalianGameScene10();
					ResourceManager.getInstance().gTracker
							.sendView("Perkalian Reset Game Scene 10");
					break;
				default:
					break;
				}
				setScene(perkalianGameScene);
			}
		}));
	}

	public void loadPembagianStageMenuSceneFromGameScene(final Engine mEngine) {
		setScene(loadingScene);
		ResourceManager.getInstance().unloadPembagianGameResource();

		mEngine.registerUpdateHandler(new TimerHandler(1, new ITimerCallback() {

			@Override
			public void onTimePassed(TimerHandler pTimerHandler) {
				// TODO Auto-generated method stub
				mEngine.unregisterUpdateHandler(pTimerHandler);

				loadAllMenuSceneResources();

				ResourceManager.getInstance().backSound.play();
				SceneManager.getInstance().setScene(pembagianStageMenuScene);
			}
		}));
	}

	public void loadPembagianGameScene(final Engine mEngine,
			final int sceneNumber) {
		setScene(loadingScene);
		unloadAllMenuSceneResources();
		disposeAllMenuScene();
		mEngine.registerUpdateHandler(new TimerHandler(1, new ITimerCallback() {

			@Override
			public void onTimePassed(TimerHandler pTimerHandler) {
				// TODO Auto-generated method stub
				mEngine.unregisterUpdateHandler(pTimerHandler);
				// ResourceManager.getInstance().loadGameSceneAudio();
				switch (sceneNumber) {
				case PembagianStageMenuScene.MENU_PEMBAGIAN_1:
					ResourceManager.getInstance().loadPembagianGameScene();
					pembagianGameScene = new PembagianGameScene();
					ResourceManager.getInstance().gTracker
							.sendView("Pembagian Game Scene 1");
					break;
				case PembagianStageMenuScene.MENU_PEMBAGIAN_2:
					ResourceManager.getInstance().loadPembagianGameScene2();
					pembagianGameScene = new PembagianGameScene2();
					ResourceManager.getInstance().gTracker
							.sendView("Pembagian Game Scene 2");
					break;
				case PembagianStageMenuScene.MENU_PEMBAGIAN_3:
					ResourceManager.getInstance().loadPembagianGameScene3();
					pembagianGameScene = new PembagianGameScene3();
					ResourceManager.getInstance().gTracker
							.sendView("Pembagian Game Scene 3");
					break;
				case PembagianStageMenuScene.MENU_PEMBAGIAN_4:
					ResourceManager.getInstance().loadPembagianGameScene4();
					pembagianGameScene = new PembagianGameScene4();
					ResourceManager.getInstance().gTracker
							.sendView("Pembagian Game Scene 4");
					break;
				case PembagianStageMenuScene.MENU_PEMBAGIAN_5:
					ResourceManager.getInstance().loadPembagianGameScene5();
					pembagianGameScene = new PembagianGameScene5();
					ResourceManager.getInstance().gTracker
							.sendView("Pembagian Game Scene 5");
					break;
				case PembagianStageMenuScene.MENU_PEMBAGIAN_6:
					ResourceManager.getInstance().loadPembagianGameScene6();
					pembagianGameScene = new PembagianGameScene6();
					ResourceManager.getInstance().gTracker
							.sendView("Pembagian Game Scene 6");
					break;
				case PembagianStageMenuScene.MENU_PEMBAGIAN_7:
					ResourceManager.getInstance().loadPembagianGameScene7();
					pembagianGameScene = new PembagianGameScene7();
					ResourceManager.getInstance().gTracker
							.sendView("Pembagian Game Scene 7");
					break;
				case PembagianStageMenuScene.MENU_PEMBAGIAN_8:
					ResourceManager.getInstance().loadPembagianGameScene8();
					pembagianGameScene = new PembagianGameScene8();
					ResourceManager.getInstance().gTracker
							.sendView("Pembagian Game Scene 8");
					break;
				case PembagianStageMenuScene.MENU_PEMBAGIAN_9:
					ResourceManager.getInstance().loadPembagianGameScene9();
					pembagianGameScene = new PembagianGameScene9();
					ResourceManager.getInstance().gTracker
							.sendView("Pembagian Game Scene 9");
					break;
				case PembagianStageMenuScene.MENU_PEMBAGIAN_10:
					ResourceManager.getInstance().loadPembagianGameScene10();
					pembagianGameScene = new PembagianGameScene10();
					ResourceManager.getInstance().gTracker
							.sendView("Pembagian Game Scene 10");
					break;
				default:
					break;
				}
				setScene(pembagianGameScene);
			}
		}));
	}

	public void resetPembagianGameScene(final Engine mEngine,
			final int sceneNumber) {
		setScene(loadingScene);
		ResourceManager.getInstance().unloadPembagianGameResource();
		mEngine.registerUpdateHandler(new TimerHandler(1, new ITimerCallback() {
			@Override
			public void onTimePassed(TimerHandler pTimerHandler) {
				// TODO Auto-generated method stub
				mEngine.unregisterUpdateHandler(pTimerHandler);
				switch (sceneNumber) {
				case 41:
					ResourceManager.getInstance().loadPembagianGameScene();
					pembagianGameScene = new PembagianGameScene();
					ResourceManager.getInstance().gTracker
							.sendView("Pembagian Reset Game Scene 1");
					break;
				case 42:
					ResourceManager.getInstance().loadPembagianGameScene2();
					pembagianGameScene = new PembagianGameScene2();
					ResourceManager.getInstance().gTracker
							.sendView("Pembagian Reset Game Scene 2");
					break;
				case 43:
					ResourceManager.getInstance().loadPembagianGameScene3();
					pembagianGameScene = new PembagianGameScene3();
					ResourceManager.getInstance().gTracker
							.sendView("Pembagian Reset Game Scene 3");
					break;
				case 44:
					ResourceManager.getInstance().loadPembagianGameScene4();
					pembagianGameScene = new PembagianGameScene4();
					ResourceManager.getInstance().gTracker
							.sendView("Pembagian Reset Game Scene 4");
					break;
				case 45:
					ResourceManager.getInstance().loadPembagianGameScene5();
					pembagianGameScene = new PembagianGameScene5();
					ResourceManager.getInstance().gTracker
							.sendView("Pembagian Reset Game Scene 5");
					break;
				case 46:
					ResourceManager.getInstance().loadPembagianGameScene6();
					pembagianGameScene = new PembagianGameScene6();
					ResourceManager.getInstance().gTracker
							.sendView("Pembagian Reset Game Scene 6");
					break;
				case 47:
					ResourceManager.getInstance().loadPembagianGameScene7();
					pembagianGameScene = new PembagianGameScene7();
					ResourceManager.getInstance().gTracker
							.sendView("Pembagian Reset Game Scene 7");
					break;
				case 48:
					ResourceManager.getInstance().loadPembagianGameScene8();
					pembagianGameScene = new PembagianGameScene8();
					ResourceManager.getInstance().gTracker
							.sendView("Pembagian Reset Game Scene 8");
					break;
				case 49:
					ResourceManager.getInstance().loadPembagianGameScene9();
					pembagianGameScene = new PembagianGameScene9();
					ResourceManager.getInstance().gTracker
							.sendView("Pembagian Reset Game Scene 9");
					break;
				case 50:
					ResourceManager.getInstance().loadPembagianGameScene10();
					pembagianGameScene = new PembagianGameScene10();
					ResourceManager.getInstance().gTracker
							.sendView("Pembagian Reset Game Scene 10");
					break;

				default:
					break;
				}
				setScene(pembagianGameScene);
			}
		}));
	}

}
