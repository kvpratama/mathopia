package com.kevinpratama.mathopia;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.Scene;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.google.analytics.tracking.android.Tracker;
import com.kevinpratama.mathopia.SceneManager.SceneType;
import com.kevinpratama.mathopia.datamanager.DatabaseHandler;

import android.app.Activity;

public abstract class BaseScene extends Scene {
	// ---------------------------------------------
		// VARIABLES
		// ---------------------------------------------

		protected Engine engine;
		protected Activity activity;
		protected ResourceManager resourcesManager;
		protected VertexBufferObjectManager vbom;
		protected Camera camera;
		protected DatabaseHandler databaseHandler;
		protected Tracker gTracker;

		// ---------------------------------------------
		// CONSTRUCTOR
		// ---------------------------------------------

		public BaseScene() {
			this.resourcesManager = ResourceManager.getInstance();
			this.engine = resourcesManager.engine;
			this.activity = resourcesManager.activity;
			this.vbom = resourcesManager.vbom;
			this.camera = resourcesManager.camera;
			this.databaseHandler = resourcesManager.databaseHandler;
			this.gTracker = resourcesManager.gTracker;
			createScene();
		}

		// ---------------------------------------------
		// ABSTRACTION
		// ---------------------------------------------

		public abstract void createScene();

		public abstract void onBackKeyPressed();

		public abstract SceneType getSceneType();

		public abstract void disposeScene();
}
