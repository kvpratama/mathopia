package com.kevinpratama.mathopia;

import android.content.Context;
import android.content.SharedPreferences;

public class DataManager {
	private static DataManager INSTANCE;

	private static final String PREFS_NAME = "GAME_USERDATA";

	private SharedPreferences mSettings;
	private SharedPreferences.Editor mEditor;

	private static final String UNLOCK_MYSTERY_BOX_KEY = "mysteryBox";

	// keep track of our max unlocked level
	private int mUnlockedMysteryBox;

	DataManager() {
		// The constructor is of no use to us
	}

	public synchronized static DataManager getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new DataManager();
		}
		return INSTANCE;
	}

	public synchronized void init(Context pContext) {
		if (mSettings == null) {
			/*
			 * Retrieve our shared preference file, or if it's not yet created
			 * (first application execution) then create it now
			 */
			mSettings = pContext.getSharedPreferences(PREFS_NAME,
					Context.MODE_PRIVATE);

			/*
			 * Define the editor, used to store data to our preference file
			 */
			mEditor = mSettings.edit();

			mUnlockedMysteryBox = mSettings.getInt(UNLOCK_MYSTERY_BOX_KEY, 0);
		}
	}

	/* retrieve the max unlocked level value */
	public synchronized int getMaxUnlockedMysteryBox() {
		return mUnlockedMysteryBox;
	}

	/*
	 * This method provides a means to increase the max unlocked level by a
	 * value of 1. unlockNextLevel would be called if a player defeats the
	 * current maximum unlocked level
	 */
	public synchronized void unlockMysteryBox() {
		// Increase the max level by 1
		mUnlockedMysteryBox++;

		/*
		 * Edit our shared preferences unlockedLevels key, setting its value our
		 * new mUnlockedLevels value
		 */
		mEditor.putInt(UNLOCK_MYSTERY_BOX_KEY, mUnlockedMysteryBox);

		/*
		 * commit() must be called by the editor in order to save changes made
		 * to the shared preference data
		 */
		mEditor.commit();
	}
	
	public synchronized void resetMysteryBox() {
		// Increase the max level by 1
		mUnlockedMysteryBox = 0;

		/*
		 * Edit our shared preferences unlockedLevels key, setting its value our
		 * new mUnlockedLevels value
		 */
		mEditor.putInt(UNLOCK_MYSTERY_BOX_KEY, mUnlockedMysteryBox);

		/*
		 * commit() must be called by the editor in order to save changes made
		 * to the shared preference data
		 */
		mEditor.commit();
	}

}
