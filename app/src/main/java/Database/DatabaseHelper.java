package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import Models.EquipementAssetsModel;
import Models.EquipmentsModel;
import Models.JobAssetModel;
import Models.JobsModels;
import Models.RobotsAssetsModel;
import Models.RobotsModel;
import Models.ServiceAssetsModel;
import Models.ServicesModel;

/**
 * Created by VS3 on 7/14/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 2;
    // Database Name
    private static final String DATABASE_NAME ="InterestWingSales1.db";
    // Contacts table name

    private static final String TABLE_SERVICES ="Services";
    private static final String TABLE_ROBOTS ="Robots";
    private static final String TABLE_EQUIPEMENT ="Equipements";
    private static final String TABLE_JOB ="Jobs";

    private static final String TABLE_SERVICES_ASSESTS ="ServicesAsests";
    private static final String TABLE_ROBOTASSEST ="RobotAssest";
    private static final String TABLE_EQUASSEST ="EquipementAssests";
    private static final String TABLE_JOBASSETS ="JobAssets";
    String CREATE_SERVICE_TABLE;
    String CREATE_ROBOT_TABLE;
    String CREATE_EQUIPEMENT_TABLE;
    String CREATE_JOB_TABLE;
    String CREATE_Robot_ASSET_TABLE;
    String CREATE_SERVICE_ASSET_TABLE;
    String CREATE_EQU_ASSET_TABLE;
    String CREATE_JOB_ASSET_TABLE;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e("DataSqlite",DATABASE_NAME);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
//Service Table
          CREATE_SERVICE_TABLE ="CREATE TABLE "+ TABLE_SERVICES + "(ServiceID text, ServiceName text, ServiceType text, ServiceDescription text, ServiceThmunail text,CreateAt text,UpdateAt text);";

          CREATE_ROBOT_TABLE ="CREATE TABLE "+TABLE_ROBOTS +"(RobotID text, RobotName text, RobotType text, RobotDescription text, RobotThmunail text,RobotCreateAt text,RobotUpdateAt text);";

          CREATE_EQUIPEMENT_TABLE ="CREATE TABLE "+ TABLE_EQUIPEMENT +"(EquipementID text, EquipementName text, EquipementType text, EquipementDescription text, EquipementThmunail text, EquipementCreateAt text, EquipementUpdateAt text);";

          CREATE_JOB_TABLE ="CREATE TABLE "+ TABLE_JOB + "(JobID text, JobName text, JobType text, JobDescription text, JobThmunail text, JobCreateAt text, JobUpdateAt text);";

         CREATE_SERVICE_ASSET_TABLE ="CREATE TABLE "+ TABLE_SERVICES_ASSESTS + "(ServiceAssetID text, ServiceAssetCategoryId text, ServiceAssetName text, ServiceAssetKeywords text, ServiceAssetThumnail text, ServiceCreateAt text, ServiceUpdateAt text);";
         CREATE_Robot_ASSET_TABLE ="CREATE TABLE "+ TABLE_ROBOTASSEST + "(RobotAssetID text, RobotAssetCategoryId text, RobotAssetName text, RobotAssetKeywords text, RobotAssetThumnail text, RobotCreateAt text, RobotUpdateAt text);";
        CREATE_EQU_ASSET_TABLE ="CREATE TABLE "+ TABLE_EQUASSEST + "(EQUAssetID text, EQUAssetCategoryId text, EQUAssetName text, EQUAssetKeywords text, EQUAssetThumnail text, EQUCreateAt text, EQUUpdateAt text);";
        CREATE_JOB_ASSET_TABLE ="CREATE TABLE "+ TABLE_JOBASSETS + "(JobAssetID text, JobAssetCategoryId text, JobAssetName text, JobAssetKeywords text, JobAssetThumnail text, JobCreateAt text, JobUpdateAt text);";
        db.execSQL(CREATE_SERVICE_TABLE);
        Log.e("DataSqlite",DATABASE_NAME);
        db.execSQL(CREATE_ROBOT_TABLE);
        db.execSQL(CREATE_EQUIPEMENT_TABLE);
        db.execSQL(CREATE_JOB_TABLE);
        db.execSQL(CREATE_SERVICE_ASSET_TABLE);
        db.execSQL(CREATE_Robot_ASSET_TABLE);
        db.execSQL(CREATE_EQU_ASSET_TABLE);
        db.execSQL(CREATE_JOB_ASSET_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_SERVICES);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_ROBOTS);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_EQUIPEMENT);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_JOB);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_SERVICES_ASSESTS);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_ROBOTASSEST);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_EQUASSEST);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_JOBASSETS);
        onCreate(db);

    }
    public void resetDatabase() {

        SQLiteDatabase database = getWritableDatabase();
        database.execSQL("delete from "+ TABLE_SERVICES);
        database.execSQL("delete from "+ TABLE_ROBOTS );
        database.execSQL("delete from "+ TABLE_EQUIPEMENT);
        database.execSQL("delete from "+ TABLE_JOB);
        database.execSQL("delete from "+ TABLE_SERVICES_ASSESTS);
        database.execSQL("delete from "+ TABLE_ROBOTASSEST);
        database.execSQL("delete from "+ TABLE_EQUASSEST);
        database.execSQL("delete from "+ TABLE_JOBASSETS);
        database.close();
    }


    public void addServices(ArrayList<ServicesModel> model){

        SQLiteDatabase db = this.getWritableDatabase();
        for(int i=0;i<model.size();i++) {
            ContentValues values = new ContentValues();
            values.put("ServiceID", model.get(i).getServiceId());
            values.put("ServiceName", model.get(i).getServiceName());
            values.put("ServiceType", model.get(i).getServiceType());
            values.put("ServiceDescription", model.get(i).getServiceDescription());
            values.put("ServiceThmunail", model.get(i).getServiceThumnail());
            values.put("CreateAt", model.get(i).getServiceCreated());
            values.put("UpdateAt", model.get(i).getServiceUpdated());
            db.insert(TABLE_SERVICES, null, values);

        }
        db.close();
    }

    public void addRobots(ArrayList<RobotsModel> model){

        SQLiteDatabase db = this.getWritableDatabase();
        for(int i=0;i<model.size();i++) {
            ContentValues values = new ContentValues();
            values.put("RobotID", model.get(i).getRobotsId());
            values.put("RobotName", model.get(i).getRobotsName());
            values.put("RobotType", model.get(i).getRobotsType());
            values.put("RobotDescription", model.get(i).getRobotsDescription());
            values.put("RobotThmunail", model.get(i).getRobotsThumnail());
            values.put("RobotCreateAt", model.get(i).getRobotsCreated());
            values.put("RobotUpdateAt", model.get(i).getRobotsUpdated());
            db.insert(TABLE_ROBOTS, null, values);

        }
        db.close();
    }

    public void addEquipements(ArrayList<EquipmentsModel> model){

        SQLiteDatabase db = this.getWritableDatabase();
        for(int i=0;i<model.size();i++) {
            ContentValues values = new ContentValues();
            values.put("EquipementID", model.get(i).getEquipmentId());
            values.put("EquipementName", model.get(i).getEquipmentName());
            values.put("EquipementType", model.get(i).getEquipmentType());
            values.put("EquipementDescription", model.get(i).getEquipmentDescription());
            values.put("EquipementThmunail", model.get(i).getEquipmentThumnail());
            values.put("EquipementCreateAt", model.get(i).getEquipmentCreated());
            values.put("EquipementUpdateAt", model.get(i).getEquipmentUpdated());
            db.insert(TABLE_EQUIPEMENT, null, values);

        }
        db.close();
    }

    public void addJobs(ArrayList<JobsModels> model){

        SQLiteDatabase db = this.getWritableDatabase();
        for(int i=0;i<model.size();i++) {
            ContentValues values = new ContentValues();
            values.put("JobID", model.get(i).getJobId());
            values.put("JobName", model.get(i).getJobName());
            values.put("JobType", model.get(i).getJobType());
            values.put("JobDescription", model.get(i).getJobDescription());
            values.put("JobThmunail", model.get(i).getJobThumnail());
            values.put("JobCreateAt", model.get(i).getJobCreated());
            values.put("JobUpdateAt", model.get(i).getJobUpdated());
            db.insert(TABLE_JOB, null, values);

        }
        db.close();
    }


    public void addServiceAsset(ArrayList<ServiceAssetsModel> model){

        SQLiteDatabase db = this.getWritableDatabase();
        for(int i=0;i<model.size();i++) {
            ContentValues values = new ContentValues();
            values.put("ServiceAssetID", model.get(i).getAssetId());
            values.put("ServiceAssetCategoryId", model.get(i).getAssetCategoryId());
            values.put("ServiceAssetName", model.get(i).getAssetName());
            values.put("ServiceAssetKeywords", model.get(i).getAssetKeywords());
            values.put("ServiceAssetThumnail", model.get(i).getAssetThumnail());
            values.put("ServiceCreateAt", model.get(i).getAssetCreated());
            values.put("ServiceUpdateAt", model.get(i).getAssetUpdated());
            db.insert(TABLE_SERVICES_ASSESTS, null, values);

        }
        db.close();
    }



  public void addRobotAsset(ArrayList<RobotsAssetsModel> model){

        SQLiteDatabase db = this.getWritableDatabase();
        for(int i=0;i<model.size();i++) {
            ContentValues values = new ContentValues();
            values.put("RobotAssetID", model.get(i).getRobotId());
            values.put("RobotAssetCategoryId", model.get(i).getRobotCategoryId());
            values.put("RobotAssetName", model.get(i).getRobotName());
            values.put("RobotAssetKeywords", model.get(i).getRobotKeywords());
            values.put("RobotAssetThumnail", model.get(i).getRobotThumnail());
            values.put("RobotCreateAt", model.get(i).getRobotCreated());
            values.put("RobotUpdateAt", model.get(i).getRobotUpdated());
            db.insert(TABLE_ROBOTASSEST, null, values);

        }
      db.close();
    }
 public void addEquipementAsset(ArrayList<EquipementAssetsModel> model){

        SQLiteDatabase db = this.getWritableDatabase();
        for(int i=0;i<model.size();i++) {
            ContentValues values = new ContentValues();
            values.put("EQUAssetID", model.get(i).getEquipementAssetId());
            values.put("EQUAssetCategoryId", model.get(i).getEquipementCategoryId());
            values.put("EQUAssetName", model.get(i).getEquipementAssetName());
            values.put("EQUAssetKeywords", model.get(i).getEquipementAssetKeywords());
            values.put("EQUAssetThumnail", model.get(i).getEquipementAssetThumnail());
            values.put("EQUCreateAt", model.get(i).getEquipementAssetCreated());
            values.put("EQUUpdateAt", model.get(i).getEquipementAssetUpdated());
            db.insert(TABLE_EQUASSEST, null, values);

        }
     db.close();
    }

    public void addJobAsset(ArrayList<JobAssetModel> model){

        SQLiteDatabase db = this.getWritableDatabase();
        for(int i=0;i<model.size();i++) {
            ContentValues values = new ContentValues();
            values.put("JobAssetID", model.get(i).getJobAssetId());
            values.put("JobAssetCategoryId", model.get(i).getJobCategoryId());
            values.put("JobAssetName", model.get(i).getJobAssetName());
            values.put("JobAssetKeywords", model.get(i).getJobAssetKeywords());
            values.put("JobAssetThumnail", model.get(i).getJobAssetThumnail());
            values.put("JobCreateAt", model.get(i).getJobAssetCreated());
            values.put("JobUpdateAt", model.get(i).getJobAssetUpdated());
            db.insert(TABLE_JOBASSETS, null, values);

        }
        db.close();
    }

    public ArrayList<ServicesModel> getAllService() {
        ArrayList<ServicesModel> serviceList = new ArrayList<>();

        String selectQuery = "select * from " + TABLE_SERVICES;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        ServicesModel servicesModel;
        int a=cursor.getCount();
        if(a>0){
        if (cursor.moveToFirst()) {
           do {

                servicesModel= new ServicesModel(cursor.getString(cursor.getColumnIndex("ServiceID")),cursor.getString(cursor.getColumnIndex("ServiceName")),
                cursor.getString(cursor.getColumnIndex("ServiceType")), cursor.getString(cursor.getColumnIndex("ServiceDescription")),
                cursor.getString(cursor.getColumnIndex("ServiceThmunail")),cursor.getString(cursor.getColumnIndex("CreateAt")),cursor.getString(cursor.getColumnIndex("UpdateAt")));
               serviceList.add(servicesModel);
                cursor.moveToNext();
            }while (cursor.moveToNext());

            }}

        return serviceList;
    }

    public ArrayList<RobotsModel> getAllRobots() {
        ArrayList<RobotsModel> robotList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_ROBOTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        RobotsModel robotsModel;
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                robotsModel = new RobotsModel(cursor.getString(cursor.getColumnIndex("RobotID")),
                cursor.getString(cursor.getColumnIndex("RobotName")),
                cursor.getString(cursor.getColumnIndex("RobotType")),
                cursor.getString(cursor.getColumnIndex("RobotDescription")),
                cursor.getString(cursor.getColumnIndex("RobotThmunail")),
                cursor.getString(cursor.getColumnIndex("RobotCreateAt")),
                cursor.getString(cursor.getColumnIndex("RobotUpdateAt")));
                robotList.add(robotsModel);
                cursor.moveToNext();
            }
            }

        return robotList;
    }

   public ArrayList<EquipmentsModel> getAllEquipements() {
        ArrayList<EquipmentsModel> equipmentsModels = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_EQUIPEMENT;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
       EquipmentsModel equipementModel;
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                equipementModel = new EquipmentsModel(cursor.getString(cursor.getColumnIndex("EquipementID")),
                cursor.getString(cursor.getColumnIndex("EquipementName")),
                cursor.getString(cursor.getColumnIndex("EquipementType")),
                cursor.getString(cursor.getColumnIndex("EquipementDescription")),
                cursor.getString(cursor.getColumnIndex("EquipementThmunail")),
                cursor.getString(cursor.getColumnIndex("EquipementCreateAt")),
                cursor.getString(cursor.getColumnIndex("EquipementUpdateAt")));
                equipmentsModels.add(equipementModel);
                cursor.moveToNext();
            }
            }

        return equipmentsModels;
    }

    public ArrayList<JobsModels> getAllJobs() {
        ArrayList<JobsModels> jobsModelses = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_JOB;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        JobsModels jobsModel;
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                jobsModel = new JobsModels(cursor.getString(cursor.getColumnIndex("JobID")),
                        cursor.getString(cursor.getColumnIndex("JobName")),
                cursor.getString(cursor.getColumnIndex("JobType")),
                cursor.getString(cursor.getColumnIndex("JobDescription")),
                cursor.getString(cursor.getColumnIndex("JobThmunail")),
                cursor.getString(cursor.getColumnIndex("JobCreateAt")),
                cursor.getString(cursor.getColumnIndex("JobUpdateAt")));
                jobsModelses.add(jobsModel);
                cursor.moveToNext();
            }
            }
        return jobsModelses;
    }

    public ArrayList<ServiceAssetsModel> getAllServiceAssets() {
        ArrayList<ServiceAssetsModel> serviceAssetsModels = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_SERVICES_ASSESTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        ServiceAssetsModel serviceAssetsModel;
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                serviceAssetsModel = new ServiceAssetsModel(cursor.getString(cursor.getColumnIndex("ServiceAssetID")),
                cursor.getString(cursor.getColumnIndex("ServiceAssetCategoryId")),
                cursor.getString(cursor.getColumnIndex("ServiceAssetName")),
                cursor.getString(cursor.getColumnIndex("ServiceAssetKeywords")),
                cursor.getString(cursor.getColumnIndex("ServiceAssetThumnail")),
                cursor.getString(cursor.getColumnIndex("ServiceCreateAt")),
                cursor.getString(cursor.getColumnIndex("ServiceUpdateAt")));
                serviceAssetsModels.add(serviceAssetsModel);
                cursor.moveToNext();
            }
            }

        return serviceAssetsModels;
    }
    public ArrayList<RobotsAssetsModel> getAllRobotAssets() {
        ArrayList<RobotsAssetsModel> robotsAssetsModels = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_ROBOTASSEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        RobotsAssetsModel robotsAssetsModel;
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                robotsAssetsModel = new RobotsAssetsModel(cursor.getString(cursor.getColumnIndex("RobotAssetID")),
                cursor.getString(cursor.getColumnIndex("RobotAssetCategoryId")),
                cursor.getString(cursor.getColumnIndex("RobotAssetName")),
                cursor.getString(cursor.getColumnIndex("RobotAssettKeywords")),
                cursor.getString(cursor.getColumnIndex("RobotAssettThumnail")),
                cursor.getString(cursor.getColumnIndex("RobotAssetCreateAt")),
                cursor.getString(cursor.getColumnIndex("RobotAssetUpdateAt")));
                robotsAssetsModels.add(robotsAssetsModel);
                cursor.moveToNext();
            }
            }

        return robotsAssetsModels;
    }

    public ArrayList<EquipementAssetsModel> getAllEquipementAssets() {
        ArrayList<EquipementAssetsModel> equipementAssetsModels = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_EQUASSEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        EquipementAssetsModel equipementAssetsModel;
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                equipementAssetsModel = new EquipementAssetsModel(cursor.getString(cursor.getColumnIndex("EQUAssetID")),
                cursor.getString(cursor.getColumnIndex("EQUAssetCategoryId")),
                cursor.getString(cursor.getColumnIndex("EQUAssetName")),
                cursor.getString(cursor.getColumnIndex("EQUAssettKeywords")),
                cursor.getString(cursor.getColumnIndex("EQUAssettThumnail")),
                cursor.getString(cursor.getColumnIndex("EQUAssetCreateAt")),
                cursor.getString(cursor.getColumnIndex("EQUAssetUpdateAt")));
                equipementAssetsModels.add(equipementAssetsModel);
                cursor.moveToNext();
            }
            }

        return equipementAssetsModels;
    }
    public ArrayList<JobAssetModel> getAllJobsAssets() {
        ArrayList<JobAssetModel> jobsModelsList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_JOBASSETS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        JobAssetModel jobsModels;
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                jobsModels = new JobAssetModel(cursor.getString(cursor.getColumnIndex("JobAssetID")),
                cursor.getString(cursor.getColumnIndex("JobAssetCategoryId")),
                cursor.getString(cursor.getColumnIndex("JobAssetName")),
                cursor.getString(cursor.getColumnIndex("JobAssettKeywords")),
                cursor.getString(cursor.getColumnIndex("JobAssettThumnail")),
                cursor.getString(cursor.getColumnIndex("JobAssetCreateAt")),
                cursor.getString(cursor.getColumnIndex("JobAssetUpdateAt")));
                jobsModelsList.add(jobsModels);
                cursor.moveToNext();
            }
            }

        return jobsModelsList;
    }


  /*  // Deleting a shop
    public void deleteShop(ServiceDBModel shop) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SHOPS, KEY_ID + " = ?",
                new String[] { String.valueOf(shop.getId()) });
        db.close();
    }*/

}
