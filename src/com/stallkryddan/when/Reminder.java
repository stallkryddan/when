package com.stallkryddan.when;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Reminder {
	
	public static final String KEY_ROWID = "_id";
	public static final String KEY_NAME = "name";
	public static final String KEY_COMMENT = "comment";
	
	private static final String DATABASE_NAME = "Reminderdb";
	private static final String DATABASE_TABLE = "reminderTable";
	private static final int DATABASE_VERSION = 1;
	
	private DbHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;
	
	private static class DbHelper extends SQLiteOpenHelper{

		public DbHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" +
					KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
					KEY_NAME + " TEXT NOT NULL, " +
					KEY_COMMENT + " TEXT NOT NULL);"
			);	
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
			onCreate(db);
		}		
	}
	
	public Reminder(Context c){
		ourContext = c;
	}

	public Reminder open() throws SQLException{
		ourHelper = new DbHelper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		return this;
	}
	 public void close(){
		 ourHelper.close();
	 }
		public long createEntry(String name, String comment) {
			// TODO Auto-generated method stub
			ContentValues cv = new ContentValues();
			cv.put(KEY_NAME, name);
			cv.put(KEY_COMMENT, comment);
			return ourDatabase.insert(DATABASE_TABLE, null, cv);
		}
		public String getData() {
			// TODO Auto-generated method stub
			String[] columns = new String[]{ KEY_ROWID, KEY_NAME, KEY_COMMENT};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
			String result = "";
			
			int iRow = c.getColumnIndex(KEY_ROWID);
			int iName = c.getColumnIndex(KEY_NAME);
			int iComment = c.getColumnIndex(KEY_COMMENT);
			
			for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
				result = result + c.getString(iRow) + " " + c.getString(iName) + " " + c.getString(iComment) + "\n";
			}
			
			return result;
		}
		public String getName(long l) throws SQLException{
			// TODO Auto-generated method stub
			String[] columns = new String[]{ KEY_ROWID, KEY_NAME, KEY_COMMENT};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, KEY_ROWID + "=" + l, null, null, null, null);
			if (c != null){
				c.moveToFirst();
				String name = c.getString(1);
				return name;
			}
			return null;
		}
		public String getComment(long l) throws SQLException{
			// TODO Auto-generated method stub
			String[] columns = new String[]{ KEY_ROWID, KEY_NAME, KEY_COMMENT};
			Cursor c = ourDatabase.query(DATABASE_TABLE, columns, KEY_ROWID + "=" + l, null, null, null, null);
			if (c != null){
				c.moveToFirst();
				String comment = c.getString(2);
				return comment;
			}
			return null;
		}

		public void updateEntry(long lRow, String mName, String mComment) throws SQLException{
			// TODO Auto-generated method stub
			ContentValues cvUpdate = new ContentValues();
			cvUpdate.put(KEY_NAME, mName);
			cvUpdate.put(KEY_COMMENT, mComment);
			ourDatabase.update(DATABASE_TABLE, cvUpdate, KEY_ROWID + "=" + lRow, null);	
		}
		public void deleteEntry(long lRow1) throws SQLException{
			// TODO Auto-generated method stub
			ourDatabase.delete(DATABASE_TABLE, KEY_ROWID + "=" + lRow1, null);
		}
}
