package au.edu.murdoch.assg2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "loginSQLite.db";

    public static final String USER_TABLE_NAME = "user";
    public static final String USER_COLUMN_ID = "id";
    public static final String USER_COLUMN_USERNAME = "username";
    public static final String USER_COLUMN_PASSWORD = "password";

    public static final String SESSION_TABLE_NAME = "session";
    public static final String SESSION_COLUMN_ID = "id";
    public static final String SESSION_COLUMN_LOGIN = "login";

    public static final String CATEGORY_TABLE_NAME = "category";
    public static final String CATEGORY_COLUMN_ID = "id";
    public static final String CATEGORY_COLUMN_NAME = "name";

    public static final String EXPENSE_TABLE_NAME = "expense";
    public static final String EXPENSE_COLUMN_ID = "id";
    public static final String EXPENSE_COLUMN_CATEGORY_ID = "category_id";
    public static final String EXPENSE_USER_ID = "user_id";
    public static final String EXPENSE_COLUMN_AMOUNT = "amount";
    public static final String EXPENSE_COLUMN_REMARKS = "remarks";

    public static final String INCOME_TABLE_NAME = "income";
    public static final String INCOME_COLUMN_ID = "id";
    public static final String INCOME_COLUMN_CATEGORY_ID = "category_id";
    public static final String INCOME_USER_ID = "user_id";
    public static final String INCOME_COLUMN_AMOUNT = "amount";
    public static final String INCOME_COLUMN_REMARKS = "remarks";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + SESSION_TABLE_NAME + "(" +
                SESSION_COLUMN_ID + " integer PRIMARY KEY, " +
                SESSION_COLUMN_LOGIN + "text)");


        db.execSQL("CREATE TABLE " + USER_TABLE_NAME + "(" +
                USER_COLUMN_ID + " integer PRIMARY KEY AUTOINCREMENT, " +
                USER_COLUMN_USERNAME + " text, " + USER_COLUMN_PASSWORD + "text)");

        db.execSQL("CREATE TABLE " + CATEGORY_TABLE_NAME + "(" +
                CATEGORY_COLUMN_ID + " integer PRIMARY KEY AUTOINCREMENT, " +
                CATEGORY_COLUMN_NAME + " text)");

        db.execSQL("CREATE TABLE " + EXPENSE_TABLE_NAME + "(" +
                EXPENSE_COLUMN_ID + " integer PRIMARY KEY AUTOINCREMENT, " +
                EXPENSE_COLUMN_AMOUNT + " real ," +
                EXPENSE_COLUMN_REMARKS + " text, " +
                EXPENSE_COLUMN_CATEGORY_ID + " integer, " +
                EXPENSE_USER_ID + " integer,  FOREIGN KEY (" + EXPENSE_USER_ID + ") REFERENCES " +
                USER_TABLE_NAME + "(" + USER_COLUMN_ID + "), " +
                " FOREIGN KEY (" + EXPENSE_COLUMN_CATEGORY_ID + ") REFERENCES " +
                CATEGORY_TABLE_NAME + "(" + CATEGORY_COLUMN_ID + "))");

        db.execSQL("CREATE TABLE " + INCOME_TABLE_NAME + "(" +
                INCOME_COLUMN_ID + " integer PRIMARY KEY AUTOINCREMENT, " +
                INCOME_COLUMN_AMOUNT + " real ," +
                INCOME_COLUMN_REMARKS + " text, " +
                INCOME_COLUMN_CATEGORY_ID + " integer," +
                INCOME_USER_ID + " integer,  FOREIGN KEY (" + INCOME_USER_ID + ") REFERENCES " +
                USER_TABLE_NAME + "(" + USER_COLUMN_ID + "), " +
                "FOREIGN KEY (" + INCOME_COLUMN_CATEGORY_ID + ") REFERENCES " +
                CATEGORY_TABLE_NAME + "(" + CATEGORY_COLUMN_ID + "))");

        db.execSQL("INSERT INTO session(id, login) VALUES(1, 'empty')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + SESSION_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + CATEGORY_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + EXPENSE_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + INCOME_TABLE_NAME);
        onCreate(db);
    }

    //check session
    public Boolean checkSession(String sessionValues) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM session WHERE login = ?", new String[]{sessionValues});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    //upgrade session
    public Boolean upgradeSession(String sessionValues, int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("login", sessionValues);
        long update = db.update("session", contentValues, "id=" + id, null);
        if (update == -1) {
            return false;
        } else {
            return true;
        }
    }

    //insert user
    public Boolean insertUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long insert = db.insert("user", null, contentValues);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }

    //check login
    public Boolean checkLogin(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user WHERE username = ? AND password = ?", new String[]{username, password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
