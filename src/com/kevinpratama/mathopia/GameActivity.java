package com.kevinpratama.mathopia;

import java.io.IOException;

import org.andengine.AndEngine;
import org.andengine.engine.Engine;
import org.andengine.engine.FixedStepEngine;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.WakeLockOptions;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.ui.activity.BaseGameActivity;

import com.google.analytics.tracking.android.GoogleAnalytics;
import com.kevinpratama.mathopia.datamanager.DatabaseHandler;

import android.view.KeyEvent;
import android.widget.RelativeLayout;

public class GameActivity extends BaseGameActivity {

	private Camera camera;
	private ResourceManager resourceManager;

	// private

	@Override
	public EngineOptions onCreateEngineOptions() {
		// TODO Auto-generated method stub
		camera = new Camera(0, 0, 1280, 800);
		EngineOptions engineOptions = new EngineOptions(true,
				ScreenOrientation.LANDSCAPE_FIXED, new FillResolutionPolicy(),
				this.camera);
		engineOptions.getAudioOptions().setNeedsMusic(true).setNeedsSound(true);
		engineOptions.setWakeLockOptions(WakeLockOptions.SCREEN_ON);
		return engineOptions;
	}

	@Override
	public void onCreateResources(
			OnCreateResourcesCallback pOnCreateResourcesCallback)
			throws IOException {
		// TODO Auto-generated method stub
		DatabaseHandler databaseHandler = new DatabaseHandler(this);
		GoogleAnalytics gAnalytics = GoogleAnalytics.getInstance(this);
		ResourceManager.prepareManager(mEngine, this, camera, databaseHandler,
				gAnalytics, getVertexBufferObjectManager());
		resourceManager = ResourceManager.getInstance();
		DataManager.getInstance().init(resourceManager.activity);
		pOnCreateResourcesCallback.onCreateResourcesFinished();
	}

	@Override
	public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback)
			throws IOException {
		// TODO Auto-generated method stub
		SceneManager.getInstance().createSplashScene(pOnCreateSceneCallback);
	}

	@Override
	public void onPopulateScene(Scene pScene,
			OnPopulateSceneCallback pOnPopulateSceneCallback)
			throws IOException {
		// TODO Auto-generated method stub
		mEngine.registerUpdateHandler(new TimerHandler(0.1f,
				new ITimerCallback() {
					@Override
					public void onTimePassed(final TimerHandler pTimerHandler) {
						mEngine.unregisterUpdateHandler(pTimerHandler);
						SceneManager.getInstance().createMenuScene();
						// DataManager.getInstance().init(resourceManager.activity);
						// load menu resources, create menu scene
						// set menu scene using scene manager
						// disposeSplashScene();
						// READ NEXT ARTICLE FOR THIS PART.
					}
				}));
		pOnPopulateSceneCallback.onPopulateSceneFinished();
	}
	
	@Override
	protected void onSetContentView() {
		// TODO Auto-generated method stub
		if(!AndEngine.isDeviceSupported(this)) {
	        //this device is not supported, create a toast to tell the user
	        //then kill the activity
	        Thread thread = new Thread() {
	            @Override
	            public void run() {
	                try{
	                    Thread.sleep(3500);
	                    android.os.Process.killProcess(android.os.Process.myPid());
	                }
	                catch (InterruptedException e) {}
	            }
	        };
	        this.toastOnUiThread("This device does not support AndEngine GLES2. Sorry.");
	        finish();
	        thread.start();
	    
	        this.setContentView(new RelativeLayout(this));
	     }
		super.onSetContentView();
	}

	@Override
	public Engine onCreateEngine(EngineOptions pEngineOptions) {
		// TODO Auto-generated method stub
		// return new LimitedFPSEngine(pEngineOptions, 60);
		return new FixedStepEngine(pEngineOptions, 60);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		// We need to check if game is actually loaded!
		if (this.isGameLoaded()) {
			System.exit(0);
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			SceneManager.getInstance().getCurrentScene().onBackKeyPressed();
		}
		return false;
	}
	
	@Override
	public synchronized void onResumeGame() {
		// TODO Auto-generated method stub
		super.onResumeGame();

		if (SceneManager.getInstance().getCurrentScene() == SceneManager.menuScene
				|| SceneManager.getInstance().getCurrentScene() == SceneManager.stageMenuScene
				|| SceneManager.getInstance().getCurrentScene() == SceneManager.creditScene
				|| SceneManager.getInstance().getCurrentScene() == SceneManager.howToScene
				|| SceneManager.getInstance().getCurrentScene() == SceneManager.rewardScene
				|| SceneManager.getInstance().getCurrentScene() == SceneManager.garisBilanganStageMenuScene
				|| SceneManager.getInstance().getCurrentScene() == SceneManager.penjumlahanStageMenuScene
				|| SceneManager.getInstance().getCurrentScene() == SceneManager.penguranganStageMenuScene
				|| SceneManager.getInstance().getCurrentScene() == SceneManager.perkalianStageMenuScene
				|| SceneManager.getInstance().getCurrentScene() == SceneManager.pembagianStageMenuScene) {
			// if (resourceManager.backSound != null
			// && !resourceManager.backSound.isPlaying()) {
			resourceManager.backSound.play();
			// }
		}
		// if (SceneManager.getInstance().getCurrentScene() ==
		// SceneManager.stageMenuScene) {
		// resourceManager.back
		// }
		if (SceneManager.getInstance().getCurrentScene() == SceneManager.garisBilanganGameScene) {
			// if (resourceManager.oceanMusic != null
			// && !resourceManager.oceanMusic.isPlaying()) {
			resourceManager.oceanMusic.play();
			// }
		}
		if (SceneManager.getInstance().getCurrentScene() == SceneManager.penguranganGameScene) {
			// if (resourceManager.jungleMusic != null
			// && !resourceManager.jungleMusic.isPlaying()) {
			resourceManager.jungleMusic.play();
			// }
		}
		if (SceneManager.getInstance().getCurrentScene() == SceneManager.perkalianGameScene) {
			// if (resourceManager.lakeMusic != null
			// && !resourceManager.lakeMusic.isPlaying()) {
			resourceManager.lakeMusic.play();
			// }
		}
		if (SceneManager.getInstance().getCurrentScene() == SceneManager.pembagianGameScene) {
			// if (resourceManager.desertMusic != null
			// && !resourceManager.desertMusic.isPlaying()) {
			resourceManager.desertMusic.play();
			// }
		}
		if (SceneManager.getInstance().getCurrentScene() == SceneManager.penjumlahanGameScene) {
			// if (resourceManager.mountainMusic != null
			// && !resourceManager.mountainMusic.isPlaying()) {
			resourceManager.mountainMusic.play();
			// }
		}
	}

	@Override
	public synchronized void onPauseGame() {
		// TODO Auto-generated method stub
		if (SceneManager.getInstance().getCurrentScene() == SceneManager.menuScene
				|| SceneManager.getInstance().getCurrentScene() == SceneManager.stageMenuScene
				|| SceneManager.getInstance().getCurrentScene() == SceneManager.creditScene
				|| SceneManager.getInstance().getCurrentScene() == SceneManager.howToScene
				|| SceneManager.getInstance().getCurrentScene() == SceneManager.rewardScene
				|| SceneManager.getInstance().getCurrentScene() == SceneManager.garisBilanganStageMenuScene
				|| SceneManager.getInstance().getCurrentScene() == SceneManager.penjumlahanStageMenuScene
				|| SceneManager.getInstance().getCurrentScene() == SceneManager.penguranganStageMenuScene
				|| SceneManager.getInstance().getCurrentScene() == SceneManager.perkalianStageMenuScene
				|| SceneManager.getInstance().getCurrentScene() == SceneManager.pembagianStageMenuScene) {
			// if (resourceManager.backSound != null
			// && resourceManager.backSound.isPlaying()) {
			resourceManager.backSound.pause();
			// }
		}
		if (SceneManager.getInstance().getCurrentScene() == SceneManager.garisBilanganGameScene) {
			// if (resourceManager.oceanMusic != null
			// && resourceManager.oceanMusic.isPlaying()) {
			resourceManager.oceanMusic.pause();
			// }
		}
		if (SceneManager.getInstance().getCurrentScene() == SceneManager.penguranganGameScene) {
			// if (resourceManager.jungleMusic != null
			// && resourceManager.jungleMusic.isPlaying()) {
			resourceManager.jungleMusic.pause();
			// }
		}
		if (SceneManager.getInstance().getCurrentScene() == SceneManager.perkalianGameScene) {
			// if (resourceManager.lakeMusic != null
			// && resourceManager.lakeMusic.isPlaying()) {
			resourceManager.lakeMusic.pause();
			// }
		}
		if (SceneManager.getInstance().getCurrentScene() == SceneManager.pembagianGameScene) {
			// if (resourceManager.desertMusic != null
			// && resourceManager.desertMusic.isPlaying()) {
			resourceManager.desertMusic.pause();
			// }
		}
		if (SceneManager.getInstance().getCurrentScene() == SceneManager.penjumlahanGameScene) {
			// if (resourceManager.mountainMusic != null
			// && resourceManager.mountainMusic.isPlaying()) {
			resourceManager.mountainMusic.pause();
			// }
		}
		super.onPauseGame();
	}
}
