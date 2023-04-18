package com.example.studentregistration;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;

	private static final String DATABASE_NAME = "Placement";

	private static final String TABLE_DETAILS = "detail";

	private static final String KEY_ID = "regno";
	private static final String KEY_NAME = "name";
	private static final String KEY_GENDER = "gender";
	private static final String KEY_DEPT = "dept";
	private static final String KEY_10TH = "tenthmark";
	private static final String KEY_12TH = "twlvethmark";
	private static final String KEY_UG = "ugmark";

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String cQuery = "CREATE TABLE " + TABLE_DETAILS + "(" + KEY_ID
				+ " INTEGER PRIMARY KEY, " + KEY_NAME + " TEXT, " + KEY_GENDER
				+ " TEXT, " + KEY_DEPT + " TEXT, " + KEY_10TH + " REAL, "
				+ KEY_12TH + " REAL, " + KEY_UG + " REAL " + ");";

		db.execSQL(cQuery);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_DETAILS);
		onCreate(db);
	}

	public void insertEntry(int reg, String nam, String gen, String dept,
			float tenmark, float twlemark, float ugmark) {

		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();

		values.put(KEY_ID, reg); // Dept ID
		values.put(KEY_NAME, nam); // Dept Name
		values.put(KEY_GENDER, gen);
		values.put(KEY_DEPT, dept);
		values.put(KEY_10TH, tenmark);
		values.put(KEY_12TH, twlemark);
		values.put(KEY_UG, ugmark);

		// Inserting Row
		db.insert(TABLE_DETAILS, null, values);

		db.close(); // Closing database connection
	}
}
