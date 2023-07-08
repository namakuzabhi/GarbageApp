package com.example.garbagemanager;
import java.util.ArrayList;
import java.util.HashMap;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

  private static final String DB_NAME = "Garbage.db";
  private static final int DB_VERSION = 1;
  private static final String TABLE_NAME = "member";
  private static final String ID_COL = "id";
  private static final String ANO_COL = "ano";
  private static final String NAME_COL = "name";
  private static final String PHONE_COL = "phone";
  private static final String DATE_COL = "date";
  private static final String Location_COL = "location";
  private static final String Status_COL = "status";
  private static final String DStatus_COL = "dstatus";


  public static final String TABLE_NAME1 = "Users";
  public static final String _ID = "id";
  public static final String USER = "username";
  public static final String PASS = "password";


  private static final String TABLE_NAME2 = "driver";
  private static final String IDC= "id";
  private static final String DNO = "dno";
  private static final String NAME = "name";
  private static final String PHONE = "phone";
  private static final String Location = "location";



  public DBHelper(Context context) {
    super(context, DB_NAME, null, DB_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {

    String query = "CREATE TABLE " + TABLE_NAME + " ("
      + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
      + ANO_COL + " TEXT,"
      + NAME_COL + " TEXT,"
      + PHONE_COL + " TEXT,"
      + DATE_COL + " TEXT,"
      + Location_COL + " TEXT,"
      + Status_COL + " TEXT ,"
      + DStatus_COL + " TEXT)";

    db.execSQL(query);
   // db.execSQL("create Table users(username TEXT primary key, password TEXT)");


     String quer2 = "create table " + TABLE_NAME1 + "("
       + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
       + USER + " TEXT,"
       + PASS + " TEXT)";

    db.execSQL(quer2);


    String query3 = "CREATE TABLE " + TABLE_NAME2 + " ("
      + IDC + " INTEGER PRIMARY KEY AUTOINCREMENT, "
      + DNO + " TEXT,"
      + NAME + " TEXT,"
      + PHONE + " TEXT,"
      + Location + " TEXT)";

    db.execSQL(query3);

  }


  public void addNewCourse(String ano, String name, String phone, String date, String location, String st,String dst) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put(ANO_COL, ano);
    values.put(NAME_COL, name);
    values.put(PHONE_COL, phone);
    values.put(DATE_COL, date);
    values.put(Location_COL, location);
    values.put(Status_COL, st);
    values.put(DStatus_COL, dst);


    db.insert(TABLE_NAME, null, values);
    db.close();
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    onCreate(db);

    db.execSQL("drop Table if exists "+TABLE_NAME1);
    onCreate(db);

    db.execSQL("drop Table if exists "+TABLE_NAME2);
    onCreate(db);

  }

  public Boolean insertData(String username, String password) {
    SQLiteDatabase MyDB = this.getWritableDatabase();
    ContentValues contentValues = new ContentValues();
    contentValues.put("username", username);
    contentValues.put("password", password);
    long result = MyDB.insert(TABLE_NAME1, null, contentValues);
    if (result == -1)
      return false;
    else
      return true;

  }

  public Boolean checkusername(String username) {
    SQLiteDatabase MyDB = this.getWritableDatabase();
    Cursor cursor = MyDB.rawQuery("Select * from Users where username = ?", new String[]{username});
    if (cursor.getCount() > 0)
      return true;
    else
      return false;
  }

  public Boolean checkusernamepassword(String username, String password) {
    SQLiteDatabase MyDB = this.getWritableDatabase();
    Cursor cursor = MyDB.rawQuery("Select * from Users where username = ? and password = ?", new String[]{username, password});
    if (cursor.getCount() > 0)
      return true;
    else
      return false;

  }

  public Cursor getAllData(String id){
    SQLiteDatabase db = this.getWritableDatabase();
    Cursor cursor = db.rawQuery("select * from member where ano='"+id+"' " ,null);
    return cursor;
  }


  public ArrayList<HashMap<String, String>> GetUsers(){
    SQLiteDatabase db = this.getWritableDatabase();
    ArrayList<HashMap<String, String>> userList = new ArrayList<>();
    String q = "SELECT username,password FROM "+ TABLE_NAME1;
    Cursor cursor = db.rawQuery(q,null);
    while (cursor.moveToNext()){
      HashMap<String,String> user = new HashMap<>();
      user.put("username",cursor.getString(cursor.getColumnIndex(USER)));
      user.put("password",cursor.getString(cursor.getColumnIndex(PASS)));
      userList.add(user);
    }
    return  userList;
  }


  public ArrayList<HashMap<String, String>> GetRequest(){
    SQLiteDatabase db = this.getWritableDatabase();
    ArrayList<HashMap<String, String>> userList = new ArrayList<>();
    String q = "SELECT ano,phone,date,name,location FROM "+ TABLE_NAME;
    Cursor cursor = db.rawQuery(q,null);
    while (cursor.moveToNext()){
      HashMap<String,String> user = new HashMap<>();
      user.put("ano",cursor.getString(cursor.getColumnIndex(ANO_COL)));
      user.put("name",cursor.getString(cursor.getColumnIndex(NAME_COL)));
      user.put("phone",cursor.getString(cursor.getColumnIndex(PHONE_COL)));
      user.put("date",cursor.getString(cursor.getColumnIndex(DATE_COL)));
      user.put("location",cursor.getString(cursor.getColumnIndex(Location_COL)));
      userList.add(user);
    }
    return  userList;
  }

  public Cursor getStatus(String id){
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.rawQuery("select * from member where ano='"+id+"' " ,null);
    return cursor;
  }


  public Cursor getupdate(String id){
    SQLiteDatabase db = this.getWritableDatabase();
    Cursor cursor = db.rawQuery("update member  set status='Confirm' where ano='"+id+"' " ,null);
    return cursor;
  }


  public Cursor getReject(String id){
    SQLiteDatabase db = this.getWritableDatabase();
    Cursor cursor = db.rawQuery("update member  set status='Rejected' where ano='"+id+"' " ,null);
    return cursor;
  }

  public Cursor GetAllID(){
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.rawQuery("select ano ,location from member ",null);
    return cursor;
  }



  public ArrayList<HashMap<String, String>> GetRequest2(){
    SQLiteDatabase db = this.getWritableDatabase();
    ArrayList<HashMap<String, String>> userList = new ArrayList<>();
    String q = "SELECT status,phone,date,name,location FROM "+ TABLE_NAME;
    Cursor cursor = db.rawQuery(q,null);
    while (cursor.moveToNext()){
      HashMap<String,String> user = new HashMap<>();
      user.put("name",cursor.getString(cursor.getColumnIndex(NAME_COL)));
      user.put("phone",cursor.getString(cursor.getColumnIndex(PHONE_COL)));
      user.put("date",cursor.getString(cursor.getColumnIndex(DATE_COL)));
      user.put("location",cursor.getString(cursor.getColumnIndex(Location_COL)));
      user.put("status",cursor.getString(cursor.getColumnIndex(Status_COL)));
      userList.add(user);
    }
    return  userList;
  }


  public void addDriver(String dno, String name, String phone,String location) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put(DNO, dno);
    values.put(NAME, name);
    values.put(PHONE, phone);
    values.put(Location, location);

    db.insert(TABLE_NAME2, null, values);
    db.close();
  }

  public Boolean checkDriver(String name, String phone) {
    SQLiteDatabase MyDB = this.getWritableDatabase();
    Cursor cursor = MyDB.rawQuery("Select * from driver where name = ? and phone = ?", new String[]{name, phone});
    if (cursor.getCount() > 0)
      return true;
    else
      return false;

  }

  public ArrayList<HashMap<String, String>> GetDrivers(){
    SQLiteDatabase db = this.getWritableDatabase();
    ArrayList<HashMap<String, String>> userList = new ArrayList<>();
    String q = "SELECT * FROM "+ TABLE_NAME2;
    Cursor cursor = db.rawQuery(q,null);
    while (cursor.moveToNext()){
      HashMap<String,String> user = new HashMap<>();
      user.put("dno",cursor.getString(cursor.getColumnIndex(DNO)));
      user.put("name",cursor.getString(cursor.getColumnIndex(NAME)));
      user.put("phone",cursor.getString(cursor.getColumnIndex(PHONE)));
      user.put("location",cursor.getString(cursor.getColumnIndex(Location)));
      userList.add(user);
    }
    return  userList;
  }
}

