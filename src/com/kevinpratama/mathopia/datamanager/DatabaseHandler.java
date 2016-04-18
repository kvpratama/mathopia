package com.kevinpratama.mathopia.datamanager;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 12;

	// Database Name
	private static final String DATABASE_NAME = "mathopia_db";

	// Table name
	private static final String TABLE_STAGES = "stages";
	private static final String TABLE_REWARDS = "rewards";

	// Stages Table Columns names
	private static final String STAGE_ID = "stage_id";
	private static final String STAGE_SCORE = "score";
	private static final String STAGE_TURTLE_SAVED = "turtle_saved";
	private static final String STAGE_STATUS = "status";
	// Stages Table Columns names

	// Rewards table column names
	private static final String REWARD_ID = "reward_id";
	private static final String REWARD_NAME = "name";
	private static final String REWARD_STATUS = "status";
	// Rewards table column names

	public static final int STAGE_LOCKED = 0;
	public static final int STAGE_UNLOCKED = 1;

	public static final int REWARD_LOCKED = 0;
	public static final int REWARD_UNLOCKED = 1;

	public static final int GARIS_BILANGAN_STAGE_START_ID = 0;
	public static final int PENJUMLAHAN_STAGE_START_ID = 10;
	public static final int PENGURANGAN_STAGE_START_ID = 20;
	public static final int PERKALIAN_STAGE_START_ID = 30;
	public static final int PEMBAGIAN_STAGE_START_ID = 40;

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		// String CREATE_STAGES_TABLE = "CREATE TABLE " + TABLE_STAGES + "("
		// + STAGE_ID + " INTEGER PRIMARY KEY," + STAGE_SCORE
		// + " INTEGER," + STAGE_STATUS + " TEXT" + ")";
		String CREATE_STAGES_TABLE = "CREATE TABLE " + TABLE_STAGES + "("
				+ STAGE_ID + " INTEGER PRIMARY KEY," + STAGE_SCORE
				+ " INTEGER," + STAGE_TURTLE_SAVED + " INTEGER," + STAGE_STATUS
				+ " INTEGER" + ")";
		String CREATE_REWARDS_TABLE = "CREATE TABLE " + TABLE_REWARDS + "("
				+ REWARD_ID + " INTEGER PRIMARY KEY," + REWARD_NAME + " TEXT,"
				+ REWARD_STATUS + " INTEGER" + ")";
		// db.execSQL(CREATE_STAGES_TABLE);
		db.execSQL(CREATE_STAGES_TABLE);
		db.execSQL(CREATE_REWARDS_TABLE);

		// db.execSQL("INSERT INTO " + TABLE_REWARDS + "( NULL, COBA, 1 )");
		// Reward reward = new Reward("coba2", 1);
		// ContentValues values = new ContentValues();
		// values.put(REWARD_NAME, reward.getName()); // Reward Name
		// values.put(REWARD_STATUS, reward.getStatus());
		// db.insert(TABLE_REWARDS, null, values);

		createInitialStageData(db);
		createInitialRewardData(db);
		// addReward(new Reward("coba", 1));
	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		// db.execSQL("DROP TABLE IF EXISTS " + TABLE_STAGES);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_STAGES);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_REWARDS);

		// Create tables again
		onCreate(db);

		// Reward reward = new Reward("roda", 1);
	}

	/**
	 * All CRUD(Create, Read, Update, Delete) Operations
	 */

	private void addStage(SQLiteDatabase dba, Stage stage) {
		// SQLiteDatabase db = dba;

		ContentValues values = new ContentValues();
		values.put(STAGE_SCORE, stage.getScore()); // Stage Score
		values.put(STAGE_TURTLE_SAVED, stage.getTurtleSaved()); // Stage Turtle
																// Saved
		values.put(STAGE_STATUS, stage.getStatus()); // Stage Status

		// Inserting Row
		dba.insert(TABLE_STAGES, null, values);
		// dba.close(); // Closing database connection
	}

	private void createInitialStageData(SQLiteDatabase dba) {
		Stage[] stage = new Stage[50];

		for (int i = 0; i < stage.length; i++) {
			if (i == 9 || i == 19 || i == 29 || i == 39 || i == 49) {
				stage[i] = new Stage(0, 0, STAGE_LOCKED);
			} else {
				stage[i] = new Stage(0, 0, STAGE_UNLOCKED);
			}
		}

		for (int i = 0; i < stage.length; i++) {
			addStage(dba, stage[i]);
		}
	}

	private void addReward(SQLiteDatabase dba, Reward reward) {
		// SQLiteDatabase db = dba;

		ContentValues values = new ContentValues();
		values.put(REWARD_NAME, reward.getName()); // Reward Name
		values.put(REWARD_STATUS, reward.getStatus()); // Reward Status

		// Inserting Row
		dba.insert(TABLE_REWARDS, null, values);
		// dba.close(); // Closing database connection
	}

	private void createInitialRewardData(SQLiteDatabase dba) {
		Reward[] rewards = new Reward[9];
		for (int i = 0; i < rewards.length; i++) {
			rewards[i] = new Reward("reward " + i, REWARD_LOCKED);
		}

		for (int i = 0; i < rewards.length; i++) {
			addReward(dba, rewards[i]);
		}
	}

	// Getting single stage
	public Stage getSingleStage(int stageId) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TABLE_STAGES, new String[] { STAGE_ID,
				STAGE_SCORE, STAGE_TURTLE_SAVED, STAGE_STATUS }, STAGE_ID
				+ "=?", new String[] { String.valueOf(stageId) }, null, null,
				null, null);
		if (cursor != null)
			cursor.moveToFirst();

		Stage stage = new Stage(Integer.parseInt(cursor.getString(0)),
				Integer.parseInt(cursor.getString(1)), Integer.parseInt(cursor
						.getString(2)), Integer.parseInt(cursor.getString(3)));
		return stage;
	}

	// Getting single reward
	public Reward getSingleReward(int rewardId) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TABLE_REWARDS, new String[] { REWARD_ID,
				REWARD_NAME, REWARD_STATUS }, REWARD_ID + "=?",
				new String[] { String.valueOf(rewardId) }, null, null, null,
				null);
		if (cursor != null)
			cursor.moveToFirst();

		Reward reward = new Reward(Integer.parseInt(cursor.getString(0)),
				cursor.getString(1), Integer.parseInt(cursor.getString(2)));
		// return contact
		return reward;
	}

	// Getting All Stages
	public List<Stage> getAllStages() {
		List<Stage> stageList = new ArrayList<Stage>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_STAGES;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Stage stage = new Stage();
				stage.setId(Integer.parseInt(cursor.getString(0)));
				stage.setScore(Integer.parseInt(cursor.getString(1)));
				stage.setTurtleSaved(Integer.parseInt(cursor.getString(2)));
				stage.setStatus(Integer.parseInt(cursor.getString(3)));
				// Adding contact to list
				stageList.add(stage);
			} while (cursor.moveToNext());
		}

		// return contact list
		return stageList;
	}

	// Getting Stages
	public List<Stage> getStages(int stageStartId) {
		List<Stage> stageList = new ArrayList<Stage>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_STAGES + " ORDER BY "
				+ STAGE_ID + " LIMIT " + stageStartId + " ,10 ";

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Stage stage = new Stage();
				stage.setId(Integer.parseInt(cursor.getString(0)));
				stage.setScore(Integer.parseInt(cursor.getString(1)));
				stage.setTurtleSaved(Integer.parseInt(cursor.getString(2)));
				stage.setStatus(Integer.parseInt(cursor.getString(3)));
				// Adding contact to list
				stageList.add(stage);
			} while (cursor.moveToNext());
		}

		// return contact list
		return stageList;
	}

	// Getting All Rewards
	public List<Reward> getAllRewards() {
		List<Reward> rewardList = new ArrayList<Reward>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_REWARDS;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Reward reward = new Reward();
				reward.setId(Integer.parseInt(cursor.getString(0)));
				reward.setName(cursor.getString(1));
				reward.setStatus(Integer.parseInt(cursor.getString(2)));
				// Adding contact to list
				rewardList.add(reward);
			} while (cursor.moveToNext());
		}

		// return contact list
		return rewardList;
	}

	public int updateStage(Stage stage) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(STAGE_SCORE, stage.getScore());
		values.put(STAGE_TURTLE_SAVED, stage.getTurtleSaved());
		values.put(STAGE_STATUS, stage.getStatus());

		// updating row
		return db.update(TABLE_STAGES, values, STAGE_ID + " = ?",
				new String[] { String.valueOf(stage.getId()) });
	}

	public int updateReward(Reward reward) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(REWARD_STATUS, reward.getStatus());
		// values.put(STAGE_STATUS, stage.getStatus());

		// updating row
		return db.update(TABLE_REWARDS, values, REWARD_ID + " = ?",
				new String[] { String.valueOf(reward.getId()) });
	}

	private List<Stage> createInitialStages() {
		List<Stage> stages = getAllStages();

		for (int i = 0; i < stages.size(); i++) {
			stages.get(i).setScore(0);
			stages.get(i).setTurtleSaved(0);
			if (i == 9 || i == 19 || i == 29 || i == 39 || i == 49) {
				stages.get(i).setStatus(STAGE_LOCKED);
			} else {
				stages.get(i).setStatus(STAGE_UNLOCKED);
			}
		}
		return stages;
	}

	private boolean resetAllStages() {
		List<Stage> stages = createInitialStages();

		for (int i = 0; i < stages.size(); i++) {
			updateStage(stages.get(i));
		}
		return true;
	}

	private List<Reward> createInitialRewards() {
		List<Reward> rewards = getAllRewards();
		for (int i = 0; i < rewards.size(); i++) {
			rewards.get(i).setStatus(REWARD_LOCKED);
		}
		return rewards;
	}

	private boolean resetAllRewards() {
		List<Reward> rewards = createInitialRewards();
		for (int i = 0; i < rewards.size(); i++) {
			updateReward(rewards.get(i));
		}
		return true;
	}

	public boolean resetApplicationData() {
		if (resetAllStages() && resetAllRewards()) {
			return true;
		}
		return false;
	}

	// Deleting single contact
	// public void deleteContact(Contact contact) {
	// SQLiteDatabase db = this.getWritableDatabase();
	// db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
	// new String[] { String.valueOf(contact.getID()) });
	// db.close();
	// }

	// Getting contacts Count
	// public int getContactsCount() {
	// String countQuery = "SELECT  * FROM " + TABLE_STAGES;
	// SQLiteDatabase db = this.getReadableDatabase();
	// Cursor cursor = db.rawQuery(countQuery, null);
	// cursor.close();

	// return count
	// return cursor.getCount();
	// }

}