package com.kevinpratama.mathopia;

import java.io.IOException;

import org.andengine.audio.music.Music;
import org.andengine.audio.music.MusicFactory;
import org.andengine.audio.sound.Sound;
import org.andengine.audio.sound.SoundFactory;
import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder.TextureAtlasBuilderException;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.debug.Debug;

import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;
import com.kevinpratama.mathopia.datamanager.DatabaseHandler;

import android.graphics.Color;

public class ResourceManager {
	// ---------------------------------------------
	// VARIABLES
	// ---------------------------------------------

	private static final ResourceManager INSTANCE = new ResourceManager();

	public Engine engine;
	public GameActivity activity;
	public Camera camera;
	public VertexBufferObjectManager vbom;
	public DatabaseHandler databaseHandler;
	public Tracker gTracker;
	// public EasyTracker easyTracker;
	// public GoogleAnalytics googleAnalytics;

	// ---------------------------------------------
	// TEXTURES & TEXTURE REGIONS
	// ---------------------------------------------
	public ITextureRegion splash_region;
	private BitmapTextureAtlas splashTextureAtlas;

	public ITextureRegion main_menu_background_region;
	public ITextureRegion play_region;
	public ITextureRegion cloud_region;
	public ITextureRegion cloud_region2;
	public ITextureRegion mathopia_region;
	public ITextureRegion credit_button_region;
	// public ITextureRegion options_region;

	private BuildableBitmapTextureAtlas mainMenuTextureAtlas;

	public Font menuFont, scoreFont, stageCompleteFont, dozensNumberFont,
			hundredsNumberFont, thousandsNumberFont, curlzFont, segoeFont, titleFont;

	public Music backSound;
	public Sound buttonSound;

	// stage menu texture
	public ITextureRegion stage_menu_background_region;
	public ITextureRegion garis_bilangan_region;
	public ITextureRegion penjumlahan_region;
	public ITextureRegion pengurangan_region;
	public ITextureRegion perkalian_region;
	public ITextureRegion pembagian_region;
	public ITextureRegion reward_region;
	public ITextureRegion how_to_button_region;

	private BuildableBitmapTextureAtlas stageMenuTextureAtlas;
	// stage menu texture

	// credit scene texture
	public ITextureRegion transparent_region;
	public ITextureRegion reset_region;
	public ITextureRegion logo_region;

	private BuildableBitmapTextureAtlas creditSceneTextureAtlas;
	// credit scene texture

	// how to scene texture
	public ITextureRegion howTo_region;

	private BuildableBitmapTextureAtlas howToSceneTextureAtlas;
	// how to scene texture

	// loading scene texture
	public ITextureRegion loading_region;
	public ITiledTextureRegion turtle_run_region;

	private BuildableBitmapTextureAtlas loadingSceneTextureAtlas;
	// loading scene texture

	// reward scene texture
	public ITextureRegion reward_scene_background_region;
	public ITextureRegion reward_scene_congratulation_text_region;
	public ITextureRegion reward_scene_saved_text_region;
	public ITiledTextureRegion reward_box_1;
	public ITiledTextureRegion reward_box_2;
	public ITiledTextureRegion reward_box_3;
	public ITiledTextureRegion reward_box_4;
	public ITiledTextureRegion reward_box_5;
	public ITiledTextureRegion reward_box_6;
	public ITiledTextureRegion reward_box_7;
	public ITiledTextureRegion reward_box_8;
	public ITiledTextureRegion reward_box_9;

	private BitmapTextureAtlas rewardSceneBackgroundTextureAtlas;
	private BitmapTextureAtlas rewardSceneCongratulationTextureAtlas;
	private BitmapTextureAtlas rewardSceneSavedTextureAtlas;
	private BuildableBitmapTextureAtlas rewardSceneTextureAtlas;
	private BuildableBitmapTextureAtlas rewardSceneTextureAtlas2;
	private BuildableBitmapTextureAtlas rewardSceneTextureAtlas3;
	// reward scene texture

	// all stage menu texture
	public ITextureRegion stage_select_1_region;
	public ITextureRegion stage_select_2_region;
	public ITextureRegion stage_select_3_region;

	public ITextureRegion lock_region;

	public ITextureRegion back_button_region;

	public ITiledTextureRegion stage_medal_region;

	public ITextureRegion garis_bilangan_stage_menu_background_region;
	public ITextureRegion penjumlahan_stage_menu_background_region;
	public ITextureRegion pengurangan_stage_menu_background_region;
	public ITextureRegion perkalian_stage_menu_background_region;
	public ITextureRegion pembagian_stage_menu_background_region;

	private BitmapTextureAtlas garisBilanganStageMenuBackgroundTextureAtlas;
	private BitmapTextureAtlas penjumlahanStageMenuBackgroundTextureAtlas;
	private BitmapTextureAtlas penguranganStageMenuBackgroundTextureAtlas;
	private BitmapTextureAtlas perkalianStageMenuBackgroundTextureAtlas;
	private BitmapTextureAtlas pembagianStageMenuBackgroundTextureAtlas;
	private BuildableBitmapTextureAtlas allStagesMenuTextureAtlas;
	// all stage menu texture

	// Level Complete Window
	public ITextureRegion complete_window_region;
	public ITextureRegion complete_button_region;
	public ITextureRegion restart_button_region;
	public ITiledTextureRegion complete_turtle_1_region;
	public ITiledTextureRegion complete_turtle_2_region;
	public ITiledTextureRegion complete_turtle_3_region;
	// Level Complete Window

	// garis bilangan game scene texture
	public ITextureRegion garis_bilangan_game_scene_background_region;
	public ITextureRegion line_region;

	private BuildableBitmapTextureAtlas garisBilanganGameSceneTextureAtlas;
	private BitmapTextureAtlas garisBilanganGameSceneBackgroundTextureAtlas;
	// garis bilangan game scene texture

	// penjumlahan game scene texture
	public ITextureRegion penjumlahan_game_scene_background_region;

	private BuildableBitmapTextureAtlas penjumlahanGameSceneTextureAtlas;
	private BitmapTextureAtlas penjumlahanGameSceneBackgroundTextureAtlas;
	// penjumlahan game scene texture

	// pengurangan game scene texture
	public ITextureRegion pengurangan_game_scene_background_region;

	private BuildableBitmapTextureAtlas penguranganGameSceneTextureAtlas;
	private BitmapTextureAtlas penguranganGameSceneBackgroundTextureAtlas;
	// pengurangan game scene texture

	// perkalian game scene texture
	public ITextureRegion perkalian_game_scene_background_region;
	public ITextureRegion perkalian_problem_region;

	private BuildableBitmapTextureAtlas perkalianGameSceneTextureAtlas;
	private BitmapTextureAtlas perkalianGameSceneBackgroundTextureAtlas;
	// perkalian game scene texture

	// pembagian game scene texture
	public ITextureRegion pembagian_game_scene_background_region;
	public ITextureRegion pembagian_problem_region;
	public ITextureRegion[] pembagian_choices_region;
	public ITextureRegion pembagian_holder_region;

	private BuildableBitmapTextureAtlas pembagianGameSceneTextureAtlas;
	private BitmapTextureAtlas pembagianGameSceneBackgroundTextureAtlas;
	// pembagian game scene texture

	// game element
	public ITextureRegion game_scene_check_button_region;
	public ITextureRegion game_scene_reset_button_region;
	public ITextureRegion game_scene_false_region;
	public ITextureRegion game_scene_holder_region;
	public ITextureRegion game_scene_number_holder_region;
	public ITextureRegion game_scene_mystery_box_region;
	public ITextureRegion game_scene_high_score_region;

	private BuildableBitmapTextureAtlas gameElementTextureAtlas;
	private BitmapTextureAtlas gameElementWinWindowTextureAtlas;
	// game element

	public ITiledTextureRegion eagle_region;

	public ITiledTextureRegion turtle_region1;
	public ITiledTextureRegion turtle_region2;
	public ITiledTextureRegion turtle_region3;

	public Sound beepSound, falseSound, applauseSound, screamSound1,
			screamSound2;
	public Music jungleMusic, oceanMusic, mountainMusic, lakeMusic,
			desertMusic;

	// public sou
	// garis bilangan game scene texture

	// Game Texture
	// public BuildableBitmapTextureAtlas gameTextureAtlas;

	// Game Texture Regions
	// public ITextureRegion platform1_region;
	// public ITextureRegion platform2_region;
	// public ITextureRegion platform3_region;
	// public ITextureRegion coin_region;

	// ---------------------------------------------
	// CLASS LOGIC
	// ---------------------------------------------

	public void loadMenuResources() {
		loadMenuGraphics();
		// loadMenuAudio();
		loadMenuFonts();
		// loadGameSceneAudio();
		// loadGameSceneFonts();
	}
	
	public void loadMenuResourcesAgain(){
		loadMenuTextures();
		loadMenuFontsAgain();
	}

	public void unloadMenuResources() {
		unloadMenuTextures();
		unloadMenuAudio();
		unloadMenuFonts();
	}

	public void loadMenuGraphics() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		mainMenuTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1500, 1200,
				TextureOptions.BILINEAR);
		main_menu_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(mainMenuTextureAtlas, activity,
						"main_menu_background.png");
		play_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				mainMenuTextureAtlas, activity, "play.png");
		cloud_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				mainMenuTextureAtlas, activity, "cloud.png");
		cloud_region2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				mainMenuTextureAtlas, activity, "cloud2.png");
		credit_button_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(mainMenuTextureAtlas, activity, "credit.png");
		mathopia_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(mainMenuTextureAtlas, activity, "mathopia.png");
		// options_region = BitmapTextureAtlasTextureRegionFactory
		// .createFromAsset(menuTextureAtlas, activity, "options.png");

		try {
			this.mainMenuTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.mainMenuTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			Debug.e(e);
		}
	}

	private void unloadMenuTextures() {
		mainMenuTextureAtlas.unload();
	}

	private void loadMenuTextures() {
		mainMenuTextureAtlas.load();
	}

	private void loadMenuFonts() {
		FontFactory.setAssetBasePath("font/");
		final ITexture mainFontTexture = new BitmapTextureAtlas(
				activity.getTextureManager(), 256, 256,
				TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		menuFont = FontFactory.createStrokeFromAsset(activity.getFontManager(),
				mainFontTexture, activity.getAssets(), "Helvetica Bold.ttf",
				25, true, Color.WHITE, 0, Color.WHITE);
		menuFont.load();
	}

	private void unloadMenuFonts() {
//		menuFont.unload();
	}
	
	private void loadMenuFontsAgain(){
//		menuFont.load();
	}

	// ////////////////////////////////////////////////////////////// Load
	// Audio//////////////////////////////////////////////////

	private void loadAllAudio() {
		loadMenuAudio();
		loadGameSceneAudio();
		loadGarisBilanganMusic();
		loadPenjumlahanMusic();
		loadPenguranganMusic();
		loadPerkalianMusic();
		loadPembagianMusic();
	}

	private void loadMenuAudio() {
		MusicFactory.setAssetBasePath("sfx/");
		SoundFactory.setAssetBasePath("sfx/");
		try {
			backSound = MusicFactory.createMusicFromAsset(
					engine.getMusicManager(), activity, "backsound.ogg");
			backSound.setLooping(true);
			backSound.setVolume(0.4f);
			buttonSound = SoundFactory.createSoundFromAsset(
					engine.getSoundManager(), activity, "button.ogg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void unloadMenuAudio() {
		// backSound.stop();
		// buttonSound.stop();
		//
		// backSound.release();
		// buttonSound.release();

		backSound.pause();
		backSound.seekTo(0);
	}

	private void loadGameSceneAudio() {

		SoundFactory.setAssetBasePath("sfx/");
		try {
			// jungleMusic = MusicFactory.createMusicFromAsset(
			// engine.getMusicManager(), activity, "jungle.ogg");

			beepSound = SoundFactory.createSoundFromAsset(
					engine.getSoundManager(), activity, "beep.ogg");
			falseSound = SoundFactory.createSoundFromAsset(
					engine.getSoundManager(), activity, "error.mp3");
			falseSound.setVolume(0.4f);
			screamSound1 = SoundFactory.createSoundFromAsset(
					engine.getSoundManager(), activity, "scream1.mp3");
			screamSound2 = SoundFactory.createSoundFromAsset(
					engine.getSoundManager(), activity, "scream2.mp3");
			applauseSound = SoundFactory.createSoundFromAsset(
					engine.getSoundManager(), activity, "applause.ogg");

			// jungleMusic.setLooping(true);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void unloadGameSceneAudio() {
		// beepSound.stop();
		// falseSound.stop();
		// screamSound1.stop();
		// screamSound2.stop();
		// applauseSound.stop();
		// beepSound.pause();
		// falseSound.pause();
		// screamSound1.pause();
		// screamSound2.pause();
		// applauseSound.pause();

		// beepSound.release();
		// falseSound.release();
		// screamSound1.release();
		// screamSound2.release();
		// applauseSound.release();
	}

	private void loadGarisBilanganMusic() {
		MusicFactory.setAssetBasePath("sfx/");

		try {
			oceanMusic = MusicFactory.createMusicFromAsset(
					engine.getMusicManager(), activity, "ocean.ogg");
			oceanMusic.setLooping(true);
			oceanMusic.setVolume(0.4f);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void unloadGarisBilanganMusic() {
		// oceanMusic.stop();
		oceanMusic.pause();
		oceanMusic.seekTo(0);
		// oceanMusic.release();
	}

	private void loadPenjumlahanMusic() {
		MusicFactory.setAssetBasePath("sfx/");

		try {
			mountainMusic = MusicFactory.createMusicFromAsset(
					engine.getMusicManager(), activity, "mountain.ogg");
			mountainMusic.setLooping(true);
			mountainMusic.setVolume(0.9f);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void unloadPenjumlahanMusic() {
		// mountainMusic.stop();
		mountainMusic.pause();
		mountainMusic.seekTo(0);
		// mountainMusic.release();
	}

	private void loadPenguranganMusic() {
		MusicFactory.setAssetBasePath("sfx/");

		try {
			jungleMusic = MusicFactory.createMusicFromAsset(
					engine.getMusicManager(), activity, "jungle.ogg");
			jungleMusic.setLooping(true);
			jungleMusic.setVolume(0.6f);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void unloadPenguranganMusic() {
		// jungleMusic.stop();
		jungleMusic.pause();
		jungleMusic.seekTo(0);
		// jungleMusic.release();
	}

	private void loadPerkalianMusic() {
		MusicFactory.setAssetBasePath("sfx/");

		try {
			lakeMusic = MusicFactory.createMusicFromAsset(
					engine.getMusicManager(), activity, "lake.ogg");
			lakeMusic.setLooping(true);
			lakeMusic.setVolume(0.4f);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void unloadPerkalianMusic() {
		// lakeMusic.stop();
		lakeMusic.pause();
		lakeMusic.seekTo(0);
		// lakeMusic.release();
	}

	private void loadPembagianMusic() {
		MusicFactory.setAssetBasePath("sfx/");

		try {
			desertMusic = MusicFactory.createMusicFromAsset(
					engine.getMusicManager(), activity, "desert.ogg");
			desertMusic.setLooping(true);
			// desertMusic.setVolume(1f);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void unloadPembagianMusic() {
		// desertMusic.stop();
		desertMusic.pause();
		desertMusic.seekTo(0);
		// desertMusic.release();
	}

	// //////////////////////////////////////////////////////////////Load
	// Audio//////////////////////////////////////////////////

	private void loadGameSceneFonts() {
		FontFactory.setAssetBasePath("font/");
		final ITexture mainFontTexture = new BitmapTextureAtlas(
				activity.getTextureManager(), 256, 256,
				TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		final ITexture mainFontTexture2 = new BitmapTextureAtlas(
				activity.getTextureManager(), 256, 256,
				TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		final ITexture mainFontTexture3 = new BitmapTextureAtlas(
				activity.getTextureManager(), 256, 256,
				TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		final ITexture mainFontTexture4 = new BitmapTextureAtlas(
				activity.getTextureManager(), 256, 256,
				TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		final ITexture mainFontTexture5 = new BitmapTextureAtlas(
				activity.getTextureManager(), 480, 480,
				TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		scoreFont = FontFactory.createStrokeFromAsset(
				activity.getFontManager(), mainFontTexture,
				activity.getAssets(), "Helvetica Bold.ttf", 50, true,
				Color.WHITE, 0, Color.WHITE);
		dozensNumberFont = FontFactory.createStrokeFromAsset(
				activity.getFontManager(), mainFontTexture2,
				activity.getAssets(), "Helvetica Bold.ttf", 40, true,
				Color.WHITE, 0, Color.WHITE);
		hundredsNumberFont = FontFactory.createStrokeFromAsset(
				activity.getFontManager(), mainFontTexture3,
				activity.getAssets(), "Helvetica Bold.ttf", 35, true,
				Color.WHITE, 0, Color.WHITE);
		thousandsNumberFont = FontFactory.createStrokeFromAsset(
				activity.getFontManager(), mainFontTexture4,
				activity.getAssets(), "Helvetica Bold.ttf", 27, true,
				Color.WHITE, 0, Color.WHITE);
		stageCompleteFont = FontFactory.createStrokeFromAsset(
				activity.getFontManager(), mainFontTexture5,
				activity.getAssets(), "Helvetica Bold.ttf", 100, true,
				Color.WHITE, 0, Color.WHITE);
		scoreFont.load();
		dozensNumberFont.load();
		hundredsNumberFont.load();
		thousandsNumberFont.load();
		stageCompleteFont.load();
	}

	private void unloadGameSceneFonts() {
		scoreFont.unload();
		dozensNumberFont.unload();
		hundredsNumberFont.unload();
		thousandsNumberFont.unload();
		stageCompleteFont.unload();
	}

	public void loadSplashScreen() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		splashTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		splash_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				splashTextureAtlas, activity, "splash.png", 0, 0);
		splashTextureAtlas.load();
		loadAllAudio();
	}

	public void unloadSplashScreen() {
		splashTextureAtlas.unload();
		splash_region = null;
	}

	public void loadCreditScene() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");

		creditSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		transparent_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(creditSceneTextureAtlas, activity,
						"credit/transparent.png");
		reset_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				creditSceneTextureAtlas, activity, "credit/reset.png");
		logo_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				creditSceneTextureAtlas, activity, "credit/logo.png");
		

		loadCreditSceneFonts();

		try {
			this.creditSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.creditSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void unloadCreditScene() {
		creditSceneTextureAtlas.unload();
		unloadCreditSceneFonts();
	}
	
	public void loadCreditSceneTexture(){
		creditSceneTextureAtlas.load();
		loadCreditSceneFontsTexture();
	}

	public void loadHowToScene() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");

		howToSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		howTo_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				howToSceneTextureAtlas, activity, "how_to.png");

		loadCreditSceneFonts();

		try {
			this.howToSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.howToSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void unloadHowToScene() {
		howToSceneTextureAtlas.unload();
	}
	
	public void loadHowToSceneTexture(){
		howToSceneTextureAtlas.load();
	}

	public void loadLoadingScene() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");

		loadingSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		loading_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(loadingSceneTextureAtlas, activity,
						"loading.png");
		turtle_run_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(loadingSceneTextureAtlas, activity,
						"turtle/turtle_run.png", 2, 1);

		try {
			this.loadingSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.loadingSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	private void loadCreditSceneFonts() {
		FontFactory.setAssetBasePath("font/");

		final ITexture curlzTexture = new BitmapTextureAtlas(
				activity.getTextureManager(), 256, 256,
				TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		final ITexture segoeTexture = new BitmapTextureAtlas(
				activity.getTextureManager(), 256, 256,
				TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		final ITexture titleTexture = new BitmapTextureAtlas(
				activity.getTextureManager(), 256, 256,
				TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		curlzFont = FontFactory.createStrokeFromAsset(
				activity.getFontManager(), curlzTexture, activity.getAssets(),
				"Curlz.TTF", 35, true, Color.WHITE, 0, Color.WHITE);
		segoeFont = FontFactory.createStrokeFromAsset(
				activity.getFontManager(), segoeTexture, activity.getAssets(),
				"Segoe.ttf", 20, true, Color.WHITE, 0, Color.WHITE);
		titleFont = FontFactory.createStrokeFromAsset(
				activity.getFontManager(), titleTexture, activity.getAssets(),
				"Segoe.ttf", 30, true, Color.WHITE, 0, Color.WHITE);

		curlzFont.load();
		segoeFont.load();
		titleFont.load();
	}

	private void unloadCreditSceneFonts() {
//		curlzFont.unload();
//		segoeFont.unload();
	}
	
	private void loadCreditSceneFontsTexture(){
//		curlzFont.load();
//		segoeFont.load();
	}

	public void loadStageMenuGraphics() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		stageMenuTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1300, 1000,
				TextureOptions.BILINEAR);
		stage_menu_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(stageMenuTextureAtlas, activity,
						"stage_menu_background.png");
		garis_bilangan_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(stageMenuTextureAtlas, activity,
						"garis_bilangan.png");
		penjumlahan_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(stageMenuTextureAtlas, activity,
						"penjumlahan.png");
		pengurangan_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(stageMenuTextureAtlas, activity,
						"pengurangan.png");
		perkalian_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(stageMenuTextureAtlas, activity,
						"perkalian.png");
		pembagian_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(stageMenuTextureAtlas, activity,
						"pembagian.png");
		reward_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				stageMenuTextureAtlas, activity, "reward_button.png");
		how_to_button_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(stageMenuTextureAtlas, activity,
						"how_to_button.png");

		try {
			this.stageMenuTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.stageMenuTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void unloadStageMenuTexture() {
		stageMenuTextureAtlas.unload();
	}

	public void loadStageMenuTexture() {
		stageMenuTextureAtlas.load();
	}

	public void loadRewardSceneGraphics() {
		BitmapTextureAtlasTextureRegionFactory
				.setAssetBasePath("gfx/menu/reward_scene/");
		rewardSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1100, 410,
				TextureOptions.BILINEAR);
		rewardSceneTextureAtlas2 = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1100, 410,
				TextureOptions.BILINEAR);
		rewardSceneTextureAtlas3 = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1100, 410,
				TextureOptions.BILINEAR);
		rewardSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		rewardSceneCongratulationTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 512, 110, TextureOptions.BILINEAR);
		rewardSceneSavedTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 741, 80, TextureOptions.BILINEAR);
		reward_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(rewardSceneBackgroundTextureAtlas, activity,
						"reward_scene_background.jpg", 0, 0);
		reward_scene_congratulation_text_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(rewardSceneCongratulationTextureAtlas,
						activity, "congratulation_text.png", 0, 0);
		reward_scene_saved_text_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(rewardSceneSavedTextureAtlas,
						activity, "saved_text.png", 0, 0);
		reward_box_1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(rewardSceneTextureAtlas, activity,
						"1.png", 2, 1);
		reward_box_2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(rewardSceneTextureAtlas, activity,
						"2.png", 2, 1);
		reward_box_3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(rewardSceneTextureAtlas, activity,
						"3.png", 2, 1);
		reward_box_4 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(rewardSceneTextureAtlas2, activity,
						"4.png", 2, 1);
		reward_box_5 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(rewardSceneTextureAtlas2, activity,
						"5.png", 2, 1);
		reward_box_6 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(rewardSceneTextureAtlas2, activity,
						"6.png", 2, 1);
		reward_box_7 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(rewardSceneTextureAtlas3, activity,
						"7.png", 2, 1);
		reward_box_8 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(rewardSceneTextureAtlas3, activity,
						"8.png", 2, 1);
		reward_box_9 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(rewardSceneTextureAtlas3, activity,
						"9.png", 2, 1);

		rewardSceneBackgroundTextureAtlas.load();
		rewardSceneCongratulationTextureAtlas.load();
		rewardSceneSavedTextureAtlas.load();

		try {
			this.rewardSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.rewardSceneTextureAtlas.load();
			this.rewardSceneTextureAtlas2
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.rewardSceneTextureAtlas2.load();
			this.rewardSceneTextureAtlas3
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.rewardSceneTextureAtlas3.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void unloadRewardSceneTexture() {
		rewardSceneBackgroundTextureAtlas.unload();
		rewardSceneCongratulationTextureAtlas.unload();
		rewardSceneSavedTextureAtlas.unload();
		rewardSceneTextureAtlas.unload();
		rewardSceneTextureAtlas2.unload();
		rewardSceneTextureAtlas3.unload();
	}

	public void loadRewardSceneTexture() {
		rewardSceneBackgroundTextureAtlas.load();
		rewardSceneCongratulationTextureAtlas.load();
		rewardSceneSavedTextureAtlas.load();
		rewardSceneTextureAtlas.load();
		rewardSceneTextureAtlas2.load();
		rewardSceneTextureAtlas3.load();
	}

	public void loadAllStagesMenuGraphics() {
		BitmapTextureAtlasTextureRegionFactory
				.setAssetBasePath("gfx/menu/stage_menu/");

		garisBilanganStageMenuBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		penjumlahanStageMenuBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		penguranganStageMenuBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		perkalianStageMenuBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		pembagianStageMenuBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		allStagesMenuTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1024, 480,
				TextureOptions.BILINEAR);

		garis_bilangan_stage_menu_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(garisBilanganStageMenuBackgroundTextureAtlas,
						activity, "garis_bilangan_background.jpg", 0, 0);
		penjumlahan_stage_menu_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(penjumlahanStageMenuBackgroundTextureAtlas,
						activity, "penjumlahan_background.jpg", 0, 0);
		pengurangan_stage_menu_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(penguranganStageMenuBackgroundTextureAtlas,
						activity, "pengurangan_background.jpg", 0, 0);
		perkalian_stage_menu_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(perkalianStageMenuBackgroundTextureAtlas,
						activity, "perkalian_background.jpg", 0, 0);
		pembagian_stage_menu_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(pembagianStageMenuBackgroundTextureAtlas,
						activity, "pembagian_background.jpg", 0, 0);

		stage_select_1_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(allStagesMenuTextureAtlas, activity, "1.png");
		stage_select_2_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(allStagesMenuTextureAtlas, activity, "2.png");
		stage_select_3_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(allStagesMenuTextureAtlas, activity, "3.png");

		lock_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(allStagesMenuTextureAtlas, activity,
						"lock.png");

		back_button_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(allStagesMenuTextureAtlas, activity,
						"back_button.png");

		stage_medal_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(allStagesMenuTextureAtlas, activity,
						"stage_medal.png", 4, 1);

		garisBilanganStageMenuBackgroundTextureAtlas.load();
		penjumlahanStageMenuBackgroundTextureAtlas.load();
		penguranganStageMenuBackgroundTextureAtlas.load();
		perkalianStageMenuBackgroundTextureAtlas.load();
		pembagianStageMenuBackgroundTextureAtlas.load();

		try {
			this.allStagesMenuTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.allStagesMenuTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void unloadAllStagesMenuGraphics() {
		garisBilanganStageMenuBackgroundTextureAtlas.unload();
		penjumlahanStageMenuBackgroundTextureAtlas.unload();
		penguranganStageMenuBackgroundTextureAtlas.unload();
		perkalianStageMenuBackgroundTextureAtlas.unload();
		pembagianStageMenuBackgroundTextureAtlas.unload();

		allStagesMenuTextureAtlas.unload();
	}
	
	public void loadAllStagesMenuGraphicsTexture(){
		garisBilanganStageMenuBackgroundTextureAtlas.load();
		penjumlahanStageMenuBackgroundTextureAtlas.load();
		penguranganStageMenuBackgroundTextureAtlas.load();
		perkalianStageMenuBackgroundTextureAtlas.load();
		pembagianStageMenuBackgroundTextureAtlas.load();

		allStagesMenuTextureAtlas.load();
	}

	private void loadGameElement() {
		gameElementTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		gameElementWinWindowTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 910, 700, TextureOptions.BILINEAR);

		game_scene_check_button_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(gameElementTextureAtlas, activity,
						"game_element/check_button.png");
		game_scene_reset_button_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(gameElementTextureAtlas, activity,
						"game_element/reset_button.png");
		game_scene_false_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(gameElementTextureAtlas, activity,
						"game_element/false_sign.png");
		game_scene_holder_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(gameElementTextureAtlas, activity,
						"game_element/holder.png");
		game_scene_number_holder_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(gameElementTextureAtlas, activity,
						"game_element/number_holder.png");
		game_scene_mystery_box_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(gameElementTextureAtlas, activity,
						"game_element/mystery_box.png");
		complete_window_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(gameElementWinWindowTextureAtlas, activity,
						"game_element/complete_window.png", 0, 0);
		complete_button_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(gameElementTextureAtlas, activity,
						"game_element/complete_button.png");
		restart_button_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(gameElementTextureAtlas, activity,
						"game_element/restart_button.png");
		game_scene_high_score_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(gameElementTextureAtlas, activity,
						"game_element/high_score.png");

		try {
			this.gameElementTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.gameElementTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
		gameElementWinWindowTextureAtlas.load();
	}

	private void unloadGameElement() {
		gameElementTextureAtlas.unload();
		gameElementWinWindowTextureAtlas.unload();
	}

	private void unloadGarisBilanganGameTexture() {
		garisBilanganGameSceneTextureAtlas.unload();
		garisBilanganGameSceneBackgroundTextureAtlas.unload();
	}

	public void unloadGarisBilanganGameResource() {
		unloadGarisBilanganGameTexture();
		unloadGameElement();
		unloadGameSceneAudio();
		unloadGarisBilanganMusic();
		unloadGameSceneFonts();
	}

	private void loadGarisBilanganGameElement() {
		line_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				garisBilanganGameSceneTextureAtlas, activity,
				"garis_bilangan/line.png");
	}

	public void loadGarisBilanganGameScene() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		garisBilanganGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		garisBilanganGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 900,
				TextureOptions.BILINEAR);

		garis_bilangan_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(
						garisBilanganGameSceneBackgroundTextureAtlas,
						activity,
						"garis_bilangan/garis_bilangan_game_scene_background.jpg",
						0, 0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "eagle/eagle.png", 4, 1);

		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/turtle1.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/turtle2.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/turtle3.png", 2, 1);

		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_1.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_2.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_3.png", 3, 1);

		loadGameElement();
		loadGarisBilanganGameElement();

		garisBilanganGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadGarisBilanganMusic();
		loadGameSceneFonts();

		try {
			this.garisBilanganGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.garisBilanganGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	// public void loadGarisBilanganGameTexture() {
	// garisBilanganGameSceneTextureAtlas.load();
	// }

	public void loadGarisBilanganGameScene2() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		garisBilanganGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		garisBilanganGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 900,
				TextureOptions.BILINEAR);

		garis_bilangan_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(
						garisBilanganGameSceneBackgroundTextureAtlas,
						activity,
						"garis_bilangan/garis_bilangan_game_scene_background.jpg",
						0, 0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "eagle/eagle.png", 4, 1);
		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/turtle2.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/turtle3.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/turtle4.png", 2, 1);
		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_2.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_3.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_4.png", 3, 1);

		loadGameElement();
		loadGarisBilanganGameElement();

		garisBilanganGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadGarisBilanganMusic();
		loadGameSceneFonts();

		try {
			this.garisBilanganGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.garisBilanganGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}

		// loadGarisBilanganGameSceneAudio();
		// loadGameSceneFonts();
	}

	public void loadGarisBilanganGameScene3() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		garisBilanganGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		garisBilanganGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 900,
				TextureOptions.BILINEAR);

		garis_bilangan_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(
						garisBilanganGameSceneBackgroundTextureAtlas,
						activity,
						"garis_bilangan/garis_bilangan_game_scene_background.jpg",
						0, 0);
		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "eagle/eagle.png", 4, 1);
		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/turtle3.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/turtle4.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/turtle5.png", 2, 1);
		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_3.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_4.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_5.png", 3, 1);

		loadGameElement();
		loadGarisBilanganGameElement();

		garisBilanganGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadGarisBilanganMusic();
		loadGameSceneFonts();

		try {
			this.garisBilanganGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.garisBilanganGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}

		// loadGarisBilanganGameSceneAudio();
		// loadGameSceneFonts();
	}

	public void loadGarisBilanganGameScene4() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		garisBilanganGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		garisBilanganGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 900,
				TextureOptions.BILINEAR);
		garis_bilangan_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(
						garisBilanganGameSceneBackgroundTextureAtlas,
						activity,
						"garis_bilangan/garis_bilangan_game_scene_background.jpg",
						0, 0);
		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "eagle/eagle.png", 4, 1);

		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/turtle4.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/turtle5.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/turtle6.png", 2, 1);

		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_4.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_5.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_6.png", 3, 1);

		loadGameElement();
		loadGarisBilanganGameElement();

		garisBilanganGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadGarisBilanganMusic();
		loadGameSceneFonts();

		try {
			this.garisBilanganGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.garisBilanganGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}

		// loadGarisBilanganGameSceneAudio();
		// loadGameSceneFonts();
	}

	public void loadGarisBilanganGameScene5() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		garisBilanganGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		garisBilanganGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 900,
				TextureOptions.BILINEAR);
		garis_bilangan_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(
						garisBilanganGameSceneBackgroundTextureAtlas,
						activity,
						"garis_bilangan/garis_bilangan_game_scene_background.jpg",
						0, 0);
		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "eagle/eagle.png", 4, 1);
		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/turtle5.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/turtle6.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/turtle7.png", 2, 1);
		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_5.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_6.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_7.png", 3, 1);

		loadGameElement();
		loadGarisBilanganGameElement();

		garisBilanganGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadGarisBilanganMusic();
		loadGameSceneFonts();

		try {
			this.garisBilanganGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.garisBilanganGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadGarisBilanganGameScene6() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		garisBilanganGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		garisBilanganGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 900,
				TextureOptions.BILINEAR);
		garis_bilangan_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(
						garisBilanganGameSceneBackgroundTextureAtlas,
						activity,
						"garis_bilangan/garis_bilangan_game_scene_background.jpg",
						0, 0);
		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "eagle/eagle.png", 4, 1);
		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/turtle7.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/turtle1.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/turtle2.png", 2, 1);
		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_7.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_1.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_2.png", 3, 1);

		loadGameElement();
		loadGarisBilanganGameElement();

		garisBilanganGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadGarisBilanganMusic();
		loadGameSceneFonts();

		try {
			this.garisBilanganGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.garisBilanganGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadGarisBilanganGameScene7() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		garisBilanganGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		garisBilanganGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 900,
				TextureOptions.BILINEAR);
		garis_bilangan_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(
						garisBilanganGameSceneBackgroundTextureAtlas,
						activity,
						"garis_bilangan/garis_bilangan_game_scene_background.jpg",
						0, 0);
		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "eagle/eagle.png", 4, 1);
		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/turtle7.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/turtle6.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/turtle5.png", 2, 1);
		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_7.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_6.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_5.png", 3, 1);

		loadGameElement();
		loadGarisBilanganGameElement();

		garisBilanganGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadGarisBilanganMusic();
		loadGameSceneFonts();

		try {
			this.garisBilanganGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.garisBilanganGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadGarisBilanganGameScene8() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		garisBilanganGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		garisBilanganGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 900,
				TextureOptions.BILINEAR);
		garis_bilangan_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(
						garisBilanganGameSceneBackgroundTextureAtlas,
						activity,
						"garis_bilangan/garis_bilangan_game_scene_background.jpg",
						0, 0);
		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "eagle/eagle.png", 4, 1);
		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/turtle6.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/turtle5.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/turtle4.png", 2, 1);
		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_6.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_5.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_4.png", 3, 1);

		loadGameElement();
		loadGarisBilanganGameElement();

		garisBilanganGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadGarisBilanganMusic();
		loadGameSceneFonts();

		try {
			this.garisBilanganGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.garisBilanganGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadGarisBilanganGameScene9() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		garisBilanganGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		garisBilanganGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 900,
				TextureOptions.BILINEAR);
		garis_bilangan_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(
						garisBilanganGameSceneBackgroundTextureAtlas,
						activity,
						"garis_bilangan/garis_bilangan_game_scene_background.jpg",
						0, 0);
		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "eagle/eagle.png", 4, 1);
		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/turtle5.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/turtle4.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/turtle1.png", 2, 1);
		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_5.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_4.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_3.png", 3, 1);

		loadGameElement();
		loadGarisBilanganGameElement();

		garisBilanganGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadGarisBilanganMusic();
		loadGameSceneFonts();

		try {
			this.garisBilanganGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.garisBilanganGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}

		// loadGarisBilanganGameSceneAudio();
		// loadGameSceneFonts();
	}

	public void loadGarisBilanganGameScene10() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		garisBilanganGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		garisBilanganGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 900,
				TextureOptions.BILINEAR);
		garis_bilangan_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(
						garisBilanganGameSceneBackgroundTextureAtlas,
						activity,
						"garis_bilangan/garis_bilangan_game_scene_background.jpg",
						0, 0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "eagle/eagle.png", 4, 1);
		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/turtle4.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/turtle3.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/turtle2.png", 2, 1);
		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_4.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_3.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(garisBilanganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_2.png", 3, 1);

		loadGameElement();
		loadGarisBilanganGameElement();

		garisBilanganGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadGarisBilanganMusic();
		loadGameSceneFonts();

		try {
			this.garisBilanganGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.garisBilanganGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	private void unloadPenjumlahanGameTexture() {
		penjumlahanGameSceneTextureAtlas.unload();
		penjumlahanGameSceneBackgroundTextureAtlas.unload();
	}

	public void unloadPenjumlahanGameResource() {
		unloadPenjumlahanGameTexture();
		unloadGameElement();
		unloadGameSceneAudio();
		unloadPenjumlahanMusic();
		unloadGameSceneFonts();
	}

	public void loadPenjumlahanGameScene() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		penjumlahanGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		penjumlahanGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		penjumlahan_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(penjumlahanGameSceneBackgroundTextureAtlas,
						activity,
						"penjumlahan/penjumlahan_game_scene_background.jpg", 0,
						0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "eagle/eagle.png", 4, 1);
		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/turtle3.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/turtle2.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/turtle1.png", 2, 1);
		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_3.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_2.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_1.png", 3, 1);

		loadGameElement();

		penjumlahanGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPenjumlahanMusic();
		loadGameSceneFonts();

		try {
			this.penjumlahanGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.penjumlahanGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadPenjumlahanGameScene2() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		penjumlahanGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		penjumlahanGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		penjumlahan_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(penjumlahanGameSceneBackgroundTextureAtlas,
						activity,
						"penjumlahan/penjumlahan_game_scene_background.jpg", 0,
						0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "eagle/eagle.png", 4, 1);
		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/turtle2.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/turtle1.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/turtle7.png", 2, 1);
		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_2.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_1.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_7.png", 3, 1);

		loadGameElement();

		penjumlahanGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPenjumlahanMusic();
		loadGameSceneFonts();

		try {
			this.penjumlahanGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.penjumlahanGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadPenjumlahanGameScene3() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		penjumlahanGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		penjumlahanGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		penjumlahan_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(penjumlahanGameSceneBackgroundTextureAtlas,
						activity,
						"penjumlahan/penjumlahan_game_scene_background.jpg", 0,
						0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "eagle/eagle.png", 4, 1);
		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/turtle1.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/turtle7.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/turtle6.png", 2, 1);
		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_1.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_7.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_6.png", 3, 1);

		loadGameElement();

		penjumlahanGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPenjumlahanMusic();
		loadGameSceneFonts();

		try {
			this.penjumlahanGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.penjumlahanGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadPenjumlahanGameScene4() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		penjumlahanGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		penjumlahanGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		penjumlahan_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(penjumlahanGameSceneBackgroundTextureAtlas,
						activity,
						"penjumlahan/penjumlahan_game_scene_background.jpg", 0,
						0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "eagle/eagle.png", 4, 1);
		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/turtle1.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/turtle3.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/turtle5.png", 2, 1);
		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_1.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_3.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_5.png", 3, 1);

		loadGameElement();

		penjumlahanGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPenjumlahanMusic();
		loadGameSceneFonts();

		try {
			this.penjumlahanGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.penjumlahanGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadPenjumlahanGameScene5() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		penjumlahanGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		penjumlahanGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		penjumlahan_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(penjumlahanGameSceneBackgroundTextureAtlas,
						activity,
						"penjumlahan/penjumlahan_game_scene_background.jpg", 0,
						0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "eagle/eagle.png", 4, 1);
		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/turtle1.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/turtle3.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/turtle7.png", 2, 1);
		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_1.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_3.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_7.png", 3, 1);

		loadGameElement();

		penjumlahanGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPenjumlahanMusic();
		loadGameSceneFonts();

		try {
			this.penjumlahanGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.penjumlahanGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadPenjumlahanGameScene6() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		penjumlahanGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		penjumlahanGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		penjumlahan_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(penjumlahanGameSceneBackgroundTextureAtlas,
						activity,
						"penjumlahan/penjumlahan_game_scene_background.jpg", 0,
						0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "eagle/eagle.png", 4, 1);
		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/turtle2.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/turtle4.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/turtle6.png", 2, 1);
		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_2.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_4.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_6.png", 3, 1);

		loadGameElement();

		penjumlahanGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPenjumlahanMusic();
		loadGameSceneFonts();

		try {
			this.penjumlahanGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.penjumlahanGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadPenjumlahanGameScene7() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		penjumlahanGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		penjumlahanGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		penjumlahan_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(penjumlahanGameSceneBackgroundTextureAtlas,
						activity,
						"penjumlahan/penjumlahan_game_scene_background.jpg", 0,
						0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "eagle/eagle.png", 4, 1);
		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/turtle3.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/turtle1.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/turtle7.png", 2, 1);
		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_3.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_1.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_7.png", 3, 1);

		loadGameElement();

		penjumlahanGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPenjumlahanMusic();
		loadGameSceneFonts();

		try {
			this.penjumlahanGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.penjumlahanGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadPenjumlahanGameScene8() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		penjumlahanGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		penjumlahanGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		penjumlahan_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(penjumlahanGameSceneBackgroundTextureAtlas,
						activity,
						"penjumlahan/penjumlahan_game_scene_background.jpg", 0,
						0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "eagle/eagle.png", 4, 1);
		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/turtle1.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/turtle2.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/turtle3.png", 2, 1);
		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_1.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_2.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_3.png", 3, 1);

		loadGameElement();

		penjumlahanGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPenjumlahanMusic();
		loadGameSceneFonts();

		try {
			this.penjumlahanGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.penjumlahanGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadPenjumlahanGameScene9() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		penjumlahanGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		penjumlahanGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		penjumlahan_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(penjumlahanGameSceneBackgroundTextureAtlas,
						activity,
						"penjumlahan/penjumlahan_game_scene_background.jpg", 0,
						0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "eagle/eagle.png", 4, 1);
		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/turtle7.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/turtle1.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/turtle6.png", 2, 1);
		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_7.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_1.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_6.png", 3, 1);

		loadGameElement();

		penjumlahanGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPenjumlahanMusic();
		loadGameSceneFonts();

		try {
			this.penjumlahanGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.penjumlahanGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadPenjumlahanGameScene10() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		penjumlahanGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		penjumlahanGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		penjumlahan_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(penjumlahanGameSceneBackgroundTextureAtlas,
						activity,
						"penjumlahan/penjumlahan_game_scene_background.jpg", 0,
						0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "eagle/eagle.png", 4, 1);
		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/turtle6.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/turtle2.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/turtle3.png", 2, 1);
		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_6.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_2.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penjumlahanGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_3.png", 3, 1);

		loadGameElement();

		penjumlahanGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPenjumlahanMusic();
		loadGameSceneFonts();

		try {
			this.penjumlahanGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.penjumlahanGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	private void unloadPenguranganGameTexture() {
		penguranganGameSceneTextureAtlas.unload();
		penguranganGameSceneBackgroundTextureAtlas.unload();
	}

	public void unloadPenguranganGameResource() {
		unloadPenguranganGameTexture();
		unloadGameElement();
		unloadGameSceneAudio();
		unloadPenguranganMusic();
		unloadGameSceneFonts();
	}

	public void loadPenguranganGameScene() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		penguranganGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		penguranganGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		pengurangan_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(penguranganGameSceneBackgroundTextureAtlas,
						activity,
						"pengurangan/pengurangan_game_scene_background.jpg", 0,
						0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "eagle/eagle.png", 4, 1);

		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/turtle2.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/turtle5.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/turtle4.png", 2, 1);

		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_2.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_5.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_4.png", 3, 1);

		loadGameElement();

		penguranganGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPenguranganMusic();
		loadGameSceneFonts();

		try {
			this.penguranganGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.penguranganGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadPenguranganGameScene2() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		penguranganGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		penguranganGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		pengurangan_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(penguranganGameSceneBackgroundTextureAtlas,
						activity,
						"pengurangan/pengurangan_game_scene_background.jpg", 0,
						0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "eagle/eagle.png", 4, 1);

		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/turtle3.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/turtle7.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/turtle6.png", 2, 1);

		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_3.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_7.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_6.png", 3, 1);

		loadGameElement();

		penguranganGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPenguranganMusic();
		loadGameSceneFonts();

		try {
			this.penguranganGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.penguranganGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadPenguranganGameScene3() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		penguranganGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		penguranganGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		pengurangan_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(penguranganGameSceneBackgroundTextureAtlas,
						activity,
						"pengurangan/pengurangan_game_scene_background.jpg", 0,
						0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "eagle/eagle.png", 4, 1);

		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/turtle4.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/turtle1.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/turtle5.png", 2, 1);

		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_4.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_1.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_5.png", 3, 1);

		loadGameElement();

		penguranganGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPenguranganMusic();
		loadGameSceneFonts();

		try {
			this.penguranganGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.penguranganGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadPenguranganGameScene4() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		penguranganGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		penguranganGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		pengurangan_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(penguranganGameSceneBackgroundTextureAtlas,
						activity,
						"pengurangan/pengurangan_game_scene_background.jpg", 0,
						0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "eagle/eagle.png", 4, 1);

		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/turtle2.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/turtle3.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/turtle7.png", 2, 1);

		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_2.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_3.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_7.png", 3, 1);

		loadGameElement();

		penguranganGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPenguranganMusic();
		loadGameSceneFonts();

		try {
			this.penguranganGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.penguranganGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadPenguranganGameScene5() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		penguranganGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		penguranganGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		pengurangan_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(penguranganGameSceneBackgroundTextureAtlas,
						activity,
						"pengurangan/pengurangan_game_scene_background.jpg", 0,
						0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "eagle/eagle.png", 4, 1);

		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/turtle1.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/turtle4.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/turtle5.png", 2, 1);

		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_1.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_4.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_5.png", 3, 1);

		loadGameElement();

		penguranganGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPenguranganMusic();
		loadGameSceneFonts();

		try {
			this.penguranganGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.penguranganGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadPenguranganGameScene6() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		penguranganGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		penguranganGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		pengurangan_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(penguranganGameSceneBackgroundTextureAtlas,
						activity,
						"pengurangan/pengurangan_game_scene_background.jpg", 0,
						0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "eagle/eagle.png", 4, 1);

		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/turtle2.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/turtle6.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/turtle3.png", 2, 1);

		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_2.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_6.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_3.png", 3, 1);

		loadGameElement();

		penguranganGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPenguranganMusic();
		loadGameSceneFonts();

		try {
			this.penguranganGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.penguranganGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadPenguranganGameScene7() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		penguranganGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		penguranganGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		pengurangan_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(penguranganGameSceneBackgroundTextureAtlas,
						activity,
						"pengurangan/pengurangan_game_scene_background.jpg", 0,
						0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "eagle/eagle.png", 4, 1);

		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/turtle6.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/turtle1.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/turtle2.png", 2, 1);

		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_6.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_1.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_2.png", 3, 1);

		loadGameElement();

		penguranganGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPenguranganMusic();
		loadGameSceneFonts();

		try {
			this.penguranganGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.penguranganGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadPenguranganGameScene8() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		penguranganGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		penguranganGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		pengurangan_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(penguranganGameSceneBackgroundTextureAtlas,
						activity,
						"pengurangan/pengurangan_game_scene_background.jpg", 0,
						0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "eagle/eagle.png", 4, 1);

		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/turtle7.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/turtle3.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/turtle6.png", 2, 1);

		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_7.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_3.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_6.png", 3, 1);

		loadGameElement();

		penguranganGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPenguranganMusic();
		loadGameSceneFonts();

		try {
			this.penguranganGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.penguranganGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadPenguranganGameScene9() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		penguranganGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		penguranganGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		pengurangan_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(penguranganGameSceneBackgroundTextureAtlas,
						activity,
						"pengurangan/pengurangan_game_scene_background.jpg", 0,
						0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "eagle/eagle.png", 4, 1);

		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/turtle4.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/turtle5.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/turtle1.png", 2, 1);

		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_4.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_5.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_1.png", 3, 1);

		loadGameElement();

		penguranganGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPenguranganMusic();
		loadGameSceneFonts();

		try {
			this.penguranganGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.penguranganGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadPenguranganGameScene10() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		penguranganGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		penguranganGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		pengurangan_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(penguranganGameSceneBackgroundTextureAtlas,
						activity,
						"pengurangan/pengurangan_game_scene_background.jpg", 0,
						0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "eagle/eagle.png", 4, 1);

		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/turtle7.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/turtle2.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/turtle5.png", 2, 1);

		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_7.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_2.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(penguranganGameSceneTextureAtlas,
						activity, "turtle/complete_turtle_5.png", 3, 1);

		loadGameElement();

		penguranganGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPenguranganMusic();
		loadGameSceneFonts();

		try {
			this.penguranganGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.penguranganGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	private void unloadPerkalianGameTexture() {
		perkalianGameSceneTextureAtlas.unload();
		perkalianGameSceneBackgroundTextureAtlas.unload();
	}

	public void unloadPerkalianGameResource() {
		unloadPerkalianGameTexture();
		unloadGameElement();
		unloadGameSceneAudio();
		unloadPerkalianMusic();
		unloadGameSceneFonts();
	}

	public void loadPerkalianGameScene() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		perkalianGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		perkalianGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		perkalian_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(perkalianGameSceneBackgroundTextureAtlas,
						activity,
						"perkalian/perkalian_game_scene_background.jpg", 0, 0);

		perkalian_problem_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(perkalianGameSceneTextureAtlas, activity,
						"perkalian/22.png");

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"eagle/eagle.png", 4, 1);

		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/turtle6.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/turtle2.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/turtle3.png", 2, 1);

		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_6.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_2.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_3.png", 3, 1);

		loadGameElement();

		perkalianGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPerkalianMusic();
		loadGameSceneFonts();

		try {
			this.perkalianGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.perkalianGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadPerkalianGameScene2() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		perkalianGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		perkalianGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		perkalian_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(perkalianGameSceneBackgroundTextureAtlas,
						activity,
						"perkalian/perkalian_game_scene_background.jpg", 0, 0);

		perkalian_problem_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(perkalianGameSceneTextureAtlas, activity,
						"perkalian/26.png");

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"eagle/eagle.png", 4, 1);

		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/turtle2.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/turtle4.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/turtle5.png", 2, 1);

		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_2.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_4.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_5.png", 3, 1);

		loadGameElement();

		perkalianGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPerkalianMusic();
		loadGameSceneFonts();

		try {
			this.perkalianGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.perkalianGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadPerkalianGameScene3() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		perkalianGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		perkalianGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		perkalian_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(perkalianGameSceneBackgroundTextureAtlas,
						activity,
						"perkalian/perkalian_game_scene_background.jpg", 0, 0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"eagle/eagle.png", 4, 1);

		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/turtle6.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/turtle5.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/turtle2.png", 2, 1);

		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_6.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_5.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_2.png", 3, 1);

		loadGameElement();

		perkalianGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPerkalianMusic();
		loadGameSceneFonts();

		try {
			this.perkalianGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.perkalianGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadPerkalianGameScene4() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		perkalianGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		perkalianGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		perkalian_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(perkalianGameSceneBackgroundTextureAtlas,
						activity,
						"perkalian/perkalian_game_scene_background.jpg", 0, 0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"eagle/eagle.png", 4, 1);

		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/turtle2.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/turtle6.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/turtle3.png", 2, 1);

		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_2.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_6.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_3.png", 3, 1);

		loadGameElement();

		perkalianGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPerkalianMusic();
		loadGameSceneFonts();

		try {
			this.perkalianGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.perkalianGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadPerkalianGameScene5() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		perkalianGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		perkalianGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		perkalian_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(perkalianGameSceneBackgroundTextureAtlas,
						activity,
						"perkalian/perkalian_game_scene_background.jpg", 0, 0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"eagle/eagle.png", 4, 1);

		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/turtle3.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/turtle7.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/turtle5.png", 2, 1);

		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_3.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_7.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_5.png", 3, 1);

		loadGameElement();

		perkalianGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPerkalianMusic();
		loadGameSceneFonts();

		try {
			this.perkalianGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.perkalianGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadPerkalianGameScene6() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		perkalianGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		perkalianGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		perkalian_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(perkalianGameSceneBackgroundTextureAtlas,
						activity,
						"perkalian/perkalian_game_scene_background.jpg", 0, 0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"eagle/eagle.png", 4, 1);

		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/turtle5.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/turtle1.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/turtle3.png", 2, 1);

		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_5.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_1.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_3.png", 3, 1);

		loadGameElement();

		perkalianGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPerkalianMusic();
		loadGameSceneFonts();

		try {
			this.perkalianGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.perkalianGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadPerkalianGameScene7() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		perkalianGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		perkalianGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		perkalian_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(perkalianGameSceneBackgroundTextureAtlas,
						activity,
						"perkalian/perkalian_game_scene_background.jpg", 0, 0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"eagle/eagle.png", 4, 1);

		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/turtle1.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/turtle3.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/turtle2.png", 2, 1);

		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_1.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_3.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_2.png", 3, 1);

		loadGameElement();

		perkalianGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPerkalianMusic();
		loadGameSceneFonts();

		try {
			this.perkalianGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.perkalianGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadPerkalianGameScene8() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		perkalianGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		perkalianGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		perkalian_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(perkalianGameSceneBackgroundTextureAtlas,
						activity,
						"perkalian/perkalian_game_scene_background.jpg", 0, 0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"eagle/eagle.png", 4, 1);

		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/turtle4.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/turtle3.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/turtle7.png", 2, 1);

		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_4.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_3.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_7.png", 3, 1);

		loadGameElement();

		perkalianGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPerkalianMusic();
		loadGameSceneFonts();

		try {
			this.perkalianGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.perkalianGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadPerkalianGameScene9() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		perkalianGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		perkalianGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		perkalian_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(perkalianGameSceneBackgroundTextureAtlas,
						activity,
						"perkalian/perkalian_game_scene_background.jpg", 0, 0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"eagle/eagle.png", 4, 1);

		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/turtle2.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/turtle3.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/turtle4.png", 2, 1);

		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_2.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_3.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_4.png", 3, 1);

		loadGameElement();

		perkalianGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPerkalianMusic();
		loadGameSceneFonts();

		try {
			this.perkalianGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.perkalianGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadPerkalianGameScene10() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		perkalianGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		perkalianGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		perkalian_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(perkalianGameSceneBackgroundTextureAtlas,
						activity,
						"perkalian/perkalian_game_scene_background.jpg", 0, 0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"eagle/eagle.png", 4, 1);

		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/turtle5.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/turtle6.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/turtle7.png", 2, 1);

		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_5.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_6.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(perkalianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_7.png", 3, 1);

		loadGameElement();

		perkalianGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPerkalianMusic();
		loadGameSceneFonts();

		try {
			this.perkalianGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.perkalianGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	private void unloadPembagianGameTexture() {
		pembagianGameSceneTextureAtlas.unload();
		pembagianGameSceneBackgroundTextureAtlas.unload();
	}

	public void unloadPembagianGameResource() {
		unloadPembagianGameTexture();
		unloadGameElement();
		unloadGameSceneAudio();
		unloadPembagianMusic();
		unloadGameSceneFonts();
	}

	public void loadPembagianGameScene() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		pembagianGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		pembagianGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		pembagian_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(pembagianGameSceneBackgroundTextureAtlas,
						activity,
						"pembagian/pembagian_game_scene_background.jpg", 0, 0);

		pembagian_problem_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(pembagianGameSceneTextureAtlas, activity,
						"pembagian/40.png");

		pembagian_choices_region = new ITextureRegion[4];

		pembagian_choices_region[0] = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(pembagianGameSceneTextureAtlas, activity,
						"pembagian/160404.png");
		pembagian_choices_region[1] = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(pembagianGameSceneTextureAtlas, activity,
						"pembagian/160405.png");
		pembagian_choices_region[2] = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(pembagianGameSceneTextureAtlas, activity,
						"pembagian/160406.png");
		pembagian_choices_region[3] = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(pembagianGameSceneTextureAtlas, activity,
						"pembagian/170404.png");

		pembagian_holder_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(pembagianGameSceneTextureAtlas, activity,
						"pembagian/pembagian_holder.png");

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"eagle/eagle.png", 4, 1);

		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/turtle5.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/turtle6.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/turtle2.png", 2, 1);

		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_5.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_6.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_2.png", 3, 1);

		loadGameElement();

		pembagianGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPembagianMusic();
		loadGameSceneFonts();

		try {
			this.pembagianGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.pembagianGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadPembagianGameScene2() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		pembagianGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		pembagianGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		pembagian_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(pembagianGameSceneBackgroundTextureAtlas,
						activity,
						"pembagian/pembagian_game_scene_background.jpg", 0, 0);

		pembagian_problem_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(pembagianGameSceneTextureAtlas, activity,
						"pembagian/28.png");

		pembagian_choices_region = new ITextureRegion[4];

		pembagian_choices_region[0] = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(pembagianGameSceneTextureAtlas, activity,
						"pembagian/140285.png");
		pembagian_choices_region[1] = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(pembagianGameSceneTextureAtlas, activity,
						"pembagian/140284.png");
		pembagian_choices_region[2] = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(pembagianGameSceneTextureAtlas, activity,
						"pembagian/140286.png");
		pembagian_choices_region[3] = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(pembagianGameSceneTextureAtlas, activity,
						"pembagian/140295.png");

		pembagian_holder_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(pembagianGameSceneTextureAtlas, activity,
						"pembagian/pembagian_holder.png");

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"eagle/eagle.png", 4, 1);

		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/turtle4.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/turtle2.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/turtle1.png", 2, 1);

		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_4.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_2.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_1.png", 3, 1);

		loadGameElement();

		pembagianGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPembagianMusic();
		loadGameSceneFonts();

		try {
			this.pembagianGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.pembagianGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadPembagianGameScene3() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		pembagianGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		pembagianGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		pembagian_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(pembagianGameSceneBackgroundTextureAtlas,
						activity,
						"pembagian/pembagian_game_scene_background.jpg", 0, 0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"eagle/eagle.png", 4, 1);

		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/turtle3.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/turtle7.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/turtle2.png", 2, 1);

		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_3.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_7.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_2.png", 3, 1);

		loadGameElement();

		pembagianGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPembagianMusic();
		loadGameSceneFonts();

		try {
			this.pembagianGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.pembagianGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadPembagianGameScene4() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		pembagianGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		pembagianGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		pembagian_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(pembagianGameSceneBackgroundTextureAtlas,
						activity,
						"pembagian/pembagian_game_scene_background.jpg", 0, 0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"eagle/eagle.png", 4, 1);

		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/turtle1.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/turtle6.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/turtle4.png", 2, 1);

		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_1.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_6.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_4.png", 3, 1);

		loadGameElement();

		pembagianGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPembagianMusic();
		loadGameSceneFonts();

		try {
			this.pembagianGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.pembagianGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadPembagianGameScene5() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		pembagianGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		pembagianGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		pembagian_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(pembagianGameSceneBackgroundTextureAtlas,
						activity,
						"pembagian/pembagian_game_scene_background.jpg", 0, 0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"eagle/eagle.png", 4, 1);

		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/turtle2.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/turtle4.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/turtle7.png", 2, 1);

		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_2.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_4.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_7.png", 3, 1);

		loadGameElement();

		pembagianGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPembagianMusic();
		loadGameSceneFonts();

		try {
			this.pembagianGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.pembagianGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadPembagianGameScene6() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		pembagianGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		pembagianGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		pembagian_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(pembagianGameSceneBackgroundTextureAtlas,
						activity,
						"pembagian/pembagian_game_scene_background.jpg", 0, 0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"eagle/eagle.png", 4, 1);

		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/turtle1.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/turtle5.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/turtle7.png", 2, 1);

		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_1.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_5.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_7.png", 3, 1);

		loadGameElement();

		pembagianGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPembagianMusic();
		loadGameSceneFonts();

		try {
			this.pembagianGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.pembagianGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadPembagianGameScene7() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		pembagianGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		pembagianGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		pembagian_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(pembagianGameSceneBackgroundTextureAtlas,
						activity,
						"pembagian/pembagian_game_scene_background.jpg", 0, 0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"eagle/eagle.png", 4, 1);

		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/turtle7.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/turtle4.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/turtle3.png", 2, 1);

		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_7.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_4.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_3.png", 3, 1);

		loadGameElement();

		pembagianGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPembagianMusic();
		loadGameSceneFonts();

		try {
			this.pembagianGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.pembagianGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadPembagianGameScene8() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		pembagianGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		pembagianGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		pembagian_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(pembagianGameSceneBackgroundTextureAtlas,
						activity,
						"pembagian/pembagian_game_scene_background.jpg", 0, 0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"eagle/eagle.png", 4, 1);

		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/turtle6.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/turtle5.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/turtle7.png", 2, 1);

		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_6.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_5.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_7.png", 3, 1);

		loadGameElement();

		pembagianGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPembagianMusic();
		loadGameSceneFonts();

		try {
			this.pembagianGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.pembagianGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadPembagianGameScene9() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		pembagianGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		pembagianGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		pembagian_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(pembagianGameSceneBackgroundTextureAtlas,
						activity,
						"pembagian/pembagian_game_scene_background.jpg", 0, 0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"eagle/eagle.png", 4, 1);

		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/turtle3.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/turtle1.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/turtle6.png", 2, 1);

		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_3.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_1.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_6.png", 3, 1);

		loadGameElement();

		pembagianGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPembagianMusic();
		loadGameSceneFonts();

		try {
			this.pembagianGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.pembagianGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	public void loadPembagianGameScene10() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
		pembagianGameSceneBackgroundTextureAtlas = new BitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);
		pembagianGameSceneTextureAtlas = new BuildableBitmapTextureAtlas(
				activity.getTextureManager(), 1280, 800,
				TextureOptions.BILINEAR);

		pembagian_game_scene_background_region = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(pembagianGameSceneBackgroundTextureAtlas,
						activity,
						"pembagian/pembagian_game_scene_background.jpg", 0, 0);

		eagle_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"eagle/eagle.png", 4, 1);

		turtle_region1 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/turtle2.png", 2, 1);
		turtle_region2 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/turtle4.png", 2, 1);
		turtle_region3 = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/turtle6.png", 2, 1);

		complete_turtle_1_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_2.png", 3, 1);
		complete_turtle_2_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_4.png", 3, 1);
		complete_turtle_3_region = BitmapTextureAtlasTextureRegionFactory
				.createTiledFromAsset(pembagianGameSceneTextureAtlas, activity,
						"turtle/complete_turtle_6.png", 3, 1);

		loadGameElement();

		pembagianGameSceneBackgroundTextureAtlas.load();

		// loadGameSceneAudio();
		// loadPembagianMusic();
		loadGameSceneFonts();

		try {
			this.pembagianGameSceneTextureAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 0));
			this.pembagianGameSceneTextureAtlas.load();
		} catch (final TextureAtlasBuilderException e) {
			// TODO: handle exception
			Debug.e(e);
		}
	}

	/**
	 * @param engine
	 * @param activity
	 * @param camera
	 * @param vbom
	 * <br>
	 * <br>
	 *            We use this method at beginning of game loading, to prepare
	 *            Resources Manager properly, setting all needed parameters, so
	 *            we can latter access them from different classes (eg. scenes)
	 */
	public static void prepareManager(Engine engine, GameActivity activity,
			Camera camera, VertexBufferObjectManager vbom) {
		getInstance().engine = engine;
		getInstance().activity = activity;
		getInstance().camera = camera;
		getInstance().vbom = vbom;
	}

	public static void prepareManager(Engine engine, GameActivity activity,
			Camera camera, DatabaseHandler databaseHandler,
			VertexBufferObjectManager vbom) {
		getInstance().engine = engine;
		getInstance().activity = activity;
		getInstance().camera = camera;
		getInstance().databaseHandler = databaseHandler;
		// getInstance().gTracker = ;
		getInstance().vbom = vbom;
	}

	public static void prepareManager(Engine engine, GameActivity activity,
			Camera camera, DatabaseHandler databaseHandler,
			GoogleAnalytics gAnalytics, VertexBufferObjectManager vbom) {
		getInstance().engine = engine;
		getInstance().activity = activity;
		getInstance().camera = camera;
		getInstance().databaseHandler = databaseHandler;
		getInstance().gTracker = gAnalytics.getTracker("UA-41152903-1");
		getInstance().vbom = vbom;
	}

	// ---------------------------------------------
	// GETTERS AND SETTERS
	// ---------------------------------------------

	public static ResourceManager getInstance() {
		return INSTANCE;
	}
}
