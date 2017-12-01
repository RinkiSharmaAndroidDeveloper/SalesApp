package salesapp.interstatesawing.com.salesapp;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.prefs.Preferences;

import Database.DatabaseHelper;
import Models.EquipementAssetsModel;
import Models.EquipmentsModel;
import Models.JobAssetModel;
import Models.JobsModels;
import Models.RobotsAssetsModel;
import Models.RobotsModel;
import Models.ServiceAssetsModel;
import Models.ServicesModel;

public class DashboradActivity extends AppCompatActivity implements View.OnClickListener {
    private String assetUrl = "https://interstatesawingassets.blob.core.windows.net/assets";

    private final int TIMEOUT_CONNECTION = 5000;//5sec
    private final int TIMEOUT_SOCKET = 30000;//30sec
    ImageView syncImageView;
    LinearLayout servicesLayout, RobotsLayout, EquipementLayout, Jobslayout;
    TextView servicesText, RobotsText, EquipementText, JobsText;
    ServicesModel servicesModel;
    ServiceAssetsModel serviceAssetsModel;
    RobotsModel robotsModel;
    RobotsAssetsModel robotsAssetsModel;
    EquipementAssetsModel equipementAssetsModel;
    EquipmentsModel equipmentsModel;
    JobAssetModel jobAssetModel;
    JobsModels jobsModels;
    ArrayList<ServicesModel> servicesModels = new ArrayList<>();
    ArrayList<ServiceAssetsModel> serviceAssetsModels = new ArrayList<>();
    ArrayList<RobotsModel> robotsModels = new ArrayList<>();
    ArrayList<RobotsAssetsModel> robotsAssetsModels = new ArrayList<>();
    ArrayList<EquipmentsModel> equipmentsModels = new ArrayList<>();
    ArrayList<EquipementAssetsModel> equipementAssetsModels = new ArrayList<>();
    ArrayList<JobsModels> jobsModelses = new ArrayList<>();
    ArrayList<JobAssetModel> jobAssetModels = new ArrayList<>();
    ArrayList<String> localFilesList;
    DatabaseHelper databaseHelper;
    ProgressDialog progressBar;
    int totalSize = 0;
    Dialog dialog;
    int downloadedSize = 0;
    String remoteImageName;
    private String sd_cid;
    String dirpath;
    File folder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashborad);
        servicesLayout = (LinearLayout) findViewById(R.id.layout_1);
        RobotsLayout = (LinearLayout) findViewById(R.id.layout_2);
        EquipementLayout = (LinearLayout) findViewById(R.id.layout_3);
        Jobslayout = (LinearLayout) findViewById(R.id.layout_4);
        servicesText = (TextView) findViewById(R.id.servicetext);
        RobotsText = (TextView) findViewById(R.id.robottext);
        EquipementText = (TextView) findViewById(R.id.equipmenttext);
        JobsText = (TextView) findViewById(R.id.jobtext);
        syncImageView = (ImageView) findViewById(R.id.syncImage);
        progressBar = new ProgressDialog(this);
      /*  if(shouldAskPermissions())
        {
            isStoragePermissionGranted();
        }*/
        databaseHelper = new DatabaseHelper(this);
        makeDriectiry();
        File filePathPdf = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/salesApp");
        localFilesList = getAllPdf(filePathPdf);

        servicesLayout.setOnClickListener(this);
        RobotsLayout.setOnClickListener(this);
        EquipementLayout.setOnClickListener(this);
        Jobslayout.setOnClickListener(this);
        servicesText.setOnClickListener(this);
        RobotsText.setOnClickListener(this);
        EquipementText.setOnClickListener(this);
        JobsText.setOnClickListener(this);
        syncImageView.setOnClickListener(this);

    }
    public void makeDriectiry() {
       folder = new File(Environment.getExternalStorageDirectory() + "/Interest");
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

   /* public  boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
             //   Log.v(TAG,"Permission is granted");
                return true;
            } else {

               // Log.v(TAG,"Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            //Log.v(TAG,"Permission is granted");
            return true;
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
         //   Log.v(TAG,"Permission: "+permissions[0]+ "was "+grantResults[0]);
            //resume tasks needing this permission
        }
    }*/
    public ArrayList<String> getAllPdf(File dir) {
        String pdfPattern = ".pdf";
        ArrayList<String> pdfList = new ArrayList<>();
        File listFile[] = dir.listFiles();

        if (listFile != null) {
            for (int i = 0; i < listFile.length; i++) {

                if (listFile[i].isDirectory()) {
                    getAllPdf(listFile[i]);
                } else {
                    if (listFile[i].getName().endsWith(pdfPattern) || listFile[i].getName().endsWith(".jpeg") || listFile[i].getName().endsWith(".mp4")) {

                        pdfList.add(listFile[i].getName());
                    }
                }
            }
        }
        return pdfList;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.layout_1):
                Intent intent = new Intent(DashboradActivity.this, DisplayListDataActivity.class);
                intent.putExtra("isInterest","1");
                startActivity(intent);
                break;
            case (R.id.layout_2):
                Intent intent1 = new Intent(DashboradActivity.this, DisplayListDataActivity.class);
                intent1.putExtra("isInterest","2");
                startActivity(intent1);

                break;
            case (R.id.layout_3):
                Intent intent2 = new Intent(DashboradActivity.this, DisplayListDataActivity.class);
                intent2.putExtra("isInterest","3");
                startActivity(intent2);
                break;
            case (R.id.layout_4):
                Intent intent7 = new Intent(DashboradActivity.this, DisplayListDataActivity.class);
                intent7.putExtra("isInterest","4");
                startActivity(intent7);
                break;
            case (R.id.servicetext):
                Intent intent3 = new Intent(DashboradActivity.this, DisplayListDataActivity.class);
                intent3.putExtra("isInterest","1");
                startActivity(intent3);

                break;
            case (R.id.robottext):
                Intent intent4 = new Intent(DashboradActivity.this, DisplayListDataActivity.class);
                intent4.putExtra("isInterest","2");
                startActivity(intent4);
                break;
            case (R.id.equipmenttext):
                Intent intent5 = new Intent(DashboradActivity.this, DisplayListDataActivity.class);
                intent5.putExtra("isInterest","3");
                startActivity(intent5);
                break;
            case (R.id.jobtext):
                Intent intent6 = new Intent(DashboradActivity.this, DisplayListDataActivity.class);
                intent6.putExtra("isInterest","4");
                startActivity(intent6);
                break;
            case (R.id.syncImage):
                databaseHelper.resetDatabase();
                getInterestWingData();
                break;

        }
    }

    public void getInterestWingData() {
        progressBar.show();
        RequestQueue queue = Volley.newRequestQueue(this);
        String URL = "https://app.interstatesawing.com/api/test";
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        System.out.println(response);
                        Log.e("Response", response.toString());
                        String responsemessage = null;
                        try {
                            response.getString("message");
                            Log.e("Data23", response.getString("message"));

                            JSONObject jsonObj = new JSONObject(response.getString("data"));

                            String service = jsonObj.getString("services");
                            String robotSpeces = jsonObj.getString("robot-specs");
                            String equipmentList = jsonObj.getString("equipment-lists");
                            String jobSiteVideos = jsonObj.getString("job-site-videos");
                            JSONArray jsonServiceArrayField = new JSONArray(service);
                            JSONArray jsonRobotArrayField = new JSONArray(robotSpeces);
                            JSONArray jsonEquipementArrayField = new JSONArray(equipmentList);
                            JSONArray jsonJobArrayField = new JSONArray(jobSiteVideos);
                            for (int i = 0; i < jsonServiceArrayField.length(); i++) {

                                JSONObject serviceList = jsonServiceArrayField.getJSONObject(i);

                                // Json Data set to Service
                                String ServiceId = serviceList.getString("id");
                                String ServiceName = serviceList.getString("name");
                                String ServiceType = serviceList.getString("type");
                                String ServiceDescription = serviceList.getString("description");
                                String ServiceThumnail = serviceList.getString("thumbnail");
                                String ServiceCreated = serviceList.getString("created_at");
                                String Serviceupdated = serviceList.getString("updated_at");
                                String Servicedeleted = serviceList.getString("deleted_at");
                                servicesModel = new ServicesModel(ServiceId, ServiceName, ServiceType, ServiceDescription, ServiceThumnail, ServiceCreated, Serviceupdated, Servicedeleted);
                                servicesModels.add(servicesModel);
                                boolean isResourceAvilable = findPicture(localFilesList, ServiceThumnail);
                                if (isResourceAvilable) {
                                    // databaseHelper.addServices(servicesModels);
                                } else {
                                    setFilePath(ServiceThumnail);

                                }

                                JSONArray serviceAssets = new JSONArray(serviceList.getString("assets"));
                                if(serviceAssetsModels.size()>0){
                                    serviceAssetsModels.clear();
                                }
                                for (int j = 0; j < serviceAssets.length(); j++) {
                                    JSONObject jsonObjectService = serviceAssets.getJSONObject(j);
                                    String ServiceAssetId = jsonObjectService.getString("id");
                                    String ServiceAssetCategoryId = jsonObjectService.getString("category_id");
                                    String ServiceAssetName = jsonObjectService.getString("name");
                                    String ServiceAssetKeywords = jsonObjectService.getString("keywords");
                                    String ServiceAssetsPath = jsonObjectService.getString("path");
                                    String ServiceAssetCreated = jsonObjectService.getString("created_at");
                                    String ServiceAssetsUpdated = jsonObjectService.getString("updated_at");
                                    String ServiceAssetDeleted = jsonObjectService.getString("deleted_at");
                                    serviceAssetsModel = new ServiceAssetsModel(ServiceAssetId, ServiceAssetCategoryId, ServiceAssetName, ServiceAssetKeywords, ServiceAssetsPath, ServiceAssetCreated, ServiceAssetsUpdated, ServiceAssetDeleted);
                                    serviceAssetsModels.add(serviceAssetsModel);
                                    boolean isSerivceAssetAvilable = findPicture(localFilesList, ServiceAssetsPath);
                                    if (isSerivceAssetAvilable) {
                                        // databaseHelper.addServiceAsset(serviceAssetsModels);
                                    } else {
                                        setFilePath(ServiceAssetsPath);

                                    }

                                }
                                databaseHelper.addServiceAsset(serviceAssetsModels);
                            }
                            databaseHelper.addServices(servicesModels);

                            // Json Data set to Robots
                            for (int a = 0; a < jsonRobotArrayField.length(); a++) {
                                JSONObject robotList = jsonRobotArrayField.getJSONObject(a);
                                String RobotsId = robotList.getString("id");
                                String RobotName = robotList.getString("name");
                                String RobotType = robotList.getString("type");
                                String RobotDescription = robotList.getString("description");
                                String RobotThumnail = robotList.getString("thumbnail");
                                String RobotCreated = robotList.getString("created_at");
                                String Robotupdated = robotList.getString("updated_at");
                                String Robotdeleted = robotList.getString("deleted_at");
                                robotsModel = new RobotsModel(RobotsId, RobotName, RobotType, RobotDescription, RobotThumnail, RobotCreated, Robotupdated, Robotdeleted);
                                robotsModels.add(robotsModel);
                                boolean isRobotAvilable = findPicture(localFilesList, RobotThumnail);
                                if (isRobotAvilable) {
                                    // databaseHelper.addRobots(robotsModels);
                                } else {
                                    setFilePath(RobotThumnail);

                                }


                                JSONArray robotsAssets = new JSONArray(robotList.getString("assets"));
                                if(robotsAssetsModels.size()>0){
                                    robotsAssetsModels.clear();
                                }
                                for (int j = 0; j < robotsAssets.length(); j++) {
                                    JSONObject jsonObjectRobots = robotsAssets.getJSONObject(j);
                                    String RobotAssetId = jsonObjectRobots.getString("id");
                                    String RobotAssetCategoryId = jsonObjectRobots.getString("category_id");
                                    String RobotAssetName = jsonObjectRobots.getString("name");
                                    String RobotAssetKeywords = jsonObjectRobots.getString("keywords");
                                    String RobotAssetsPath = jsonObjectRobots.getString("path");
                                    String RobotAssetCreated = jsonObjectRobots.getString("created_at");
                                    String RobotAssetsUpdated = jsonObjectRobots.getString("updated_at");
                                    String RobotAssetDeleted = jsonObjectRobots.getString("deleted_at");
                                    robotsAssetsModel = new RobotsAssetsModel(RobotAssetId, RobotAssetCategoryId, RobotAssetName, RobotAssetKeywords, RobotAssetsPath, RobotAssetCreated, RobotAssetsUpdated, RobotAssetDeleted);
                                    robotsAssetsModels.add(robotsAssetsModel);

                                    boolean isRobotAssetAvilable = findPicture(localFilesList, RobotAssetsPath);
                                    if (isRobotAssetAvilable) {
                                        //   databaseHelper.addRobotAsset(robotsAssetsModels);
                                    } else {
                                        setFilePath(RobotAssetsPath);

                                    }
                                }
                                databaseHelper.addRobotAsset(robotsAssetsModels);
                            }
                            databaseHelper.addRobots(robotsModels);
                            // Json Data set to Equipment
                            for (int e = 0; e < jsonEquipementArrayField.length(); e++) {

                                JSONObject equiptList = jsonEquipementArrayField.getJSONObject(e);
                                String EquipmentId = equiptList.getString("id");
                                String EquipmentName = equiptList.getString("name");
                                String EquipmentType = equiptList.getString("type");
                                String EquipmentDescription = equiptList.getString("description");
                                String EquipmentThumnail = equiptList.getString("thumbnail");
                                String EquipmentCreated = equiptList.getString("created_at");
                                String Equipmentupdated = equiptList.getString("updated_at");
                                String Equipmentdeleted = equiptList.getString("deleted_at");
                                equipmentsModel = new EquipmentsModel(EquipmentId, EquipmentName, EquipmentType, EquipmentDescription, EquipmentThumnail, EquipmentCreated, Equipmentupdated, Equipmentdeleted);
                                equipmentsModels.add(equipmentsModel);
                                boolean isEquipementAvilable = findPicture(localFilesList, EquipmentThumnail);
                                if (isEquipementAvilable) {
                                    // databaseHelper.addEquipements(equipmentsModels);
                                } else {
                                    setFilePath(EquipmentThumnail);

                                }

                                JSONArray EquipmentAssets = new JSONArray(equiptList.getString("assets"));
                                if(equipementAssetsModels.size()>0){
                                    equipementAssetsModels.clear();
                                }
                                for (int j = 0; j < EquipmentAssets.length(); j++) {
                                    JSONObject jsonObjectEquipement = EquipmentAssets.getJSONObject(j);
                                    String EquipmentAssetId = jsonObjectEquipement.getString("id");
                                    String EquipmentAssetCategoryId = jsonObjectEquipement.getString("category_id");
                                    String EquipmentAssetName = jsonObjectEquipement.getString("name");
                                    String EquipmentAssetKeywords = jsonObjectEquipement.getString("keywords");
                                    String EquipmentAssetsPath = jsonObjectEquipement.getString("path");
                                    String EquipmentAssetCreated = jsonObjectEquipement.getString("created_at");
                                    String EquipmentAssetsUpdated = jsonObjectEquipement.getString("updated_at");
                                    String EquipmentAssetDeleted = jsonObjectEquipement.getString("deleted_at");
                                    equipementAssetsModel = new EquipementAssetsModel(EquipmentAssetId, EquipmentAssetCategoryId, EquipmentAssetName, EquipmentAssetKeywords, EquipmentAssetsPath, EquipmentAssetCreated, EquipmentAssetsUpdated, EquipmentAssetDeleted);
                                    equipementAssetsModels.add(equipementAssetsModel);
                                    boolean isEquipementAssetAvilable = findPicture(localFilesList, EquipmentAssetsPath);
                                    if (isEquipementAssetAvilable) {
                                        // databaseHelper.addEquipementAsset(equipementAssetsModels);
                                    } else {
                                        setFilePath(EquipmentAssetsPath);

                                    }

                                }
                                databaseHelper.addEquipementAsset(equipementAssetsModels);
                            }
                            databaseHelper.addEquipements(equipmentsModels);
                            // Json Data set to Jobs

                            for (int b = 0; b < jsonJobArrayField.length(); b++) {
                                JSONObject jobSiteList = jsonJobArrayField.getJSONObject(b);
                                String JobId = jobSiteList.getString("id");
                                String JobName = jobSiteList.getString("name");
                                String JobType = jobSiteList.getString("type");
                                String JobDescription = jobSiteList.getString("description");
                                String JobThumnail = jobSiteList.getString("thumbnail");
                                String JobCreated = jobSiteList.getString("created_at");
                                String Jobupdated = jobSiteList.getString("updated_at");
                                String Jobdeleted = jobSiteList.getString("deleted_at");
                                jobsModels = new JobsModels(JobId, JobName, JobType, JobDescription, JobThumnail, JobCreated, Jobupdated, Jobdeleted);
                                jobsModelses.add(jobsModels);
                                boolean isJobAvilable = findPicture(localFilesList, JobThumnail);
                                if (isJobAvilable) {
                                    //  databaseHelper.addJobs(jobsModelses);
                                } else {
                                    setFilePath(JobThumnail);

                                }


                                JSONArray JobAssets = new JSONArray(jobSiteList.getString("assets"));
                                if(jobAssetModels.size()>0){
                                    jobAssetModels.clear();
                                }
                                for (int j = 0; j < JobAssets.length(); j++) {
                                    JSONObject jsonObjectJob = JobAssets.getJSONObject(j);
                                    String ServiceAssetId = jsonObjectJob.getString("id");
                                    String ServiceAssetCategoryId = jsonObjectJob.getString("category_id");
                                    String ServiceAssetName = jsonObjectJob.getString("name");
                                    String ServiceAssetKeywords = jsonObjectJob.getString("keywords");
                                    String ServiceAssetsPath = jsonObjectJob.getString("path");
                                    String ServiceAssetCreated = jsonObjectJob.getString("created_at");
                                    String ServiceAssetsUpdated = jsonObjectJob.getString("updated_at");
                                    String ServiceAssetDeleted = jsonObjectJob.getString("deleted_at");
                                    jobAssetModel = new JobAssetModel(ServiceAssetId, ServiceAssetCategoryId, ServiceAssetName, ServiceAssetKeywords,
                                            ServiceAssetsPath, ServiceAssetCreated, ServiceAssetsUpdated, ServiceAssetDeleted);
                                    jobAssetModels.add(jobAssetModel);
                                    boolean isJobAssetAvilable = findPicture(localFilesList, ServiceAssetsPath);
                                    if (isJobAssetAvilable) {
                                        // databaseHelper.addJobAsset(jobAssetModels);
                                    } else {
                                        setFilePath(ServiceAssetsPath);

                                    }
                                    setFilePath(ServiceAssetsPath);
                                    databaseHelper.addJobAsset(jobAssetModels);
                                }
                                databaseHelper.addJobs(jobsModelses);

                            }
                            progressBar.hide();
                            // progressBar.hide();
                            // mAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {

                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        queue.add(jsObjRequest);
    }

    public boolean findPicture(ArrayList<String> images, String ImageName) {
        boolean isResourceAvilable = false;
        for (int i = 0; i < images.size(); i++) {
            if (images.get(i).equals(ImageName)) {
                isResourceAvilable = true;
                return isResourceAvilable;
            } else {
                isResourceAvilable = false;
            }
        }
        return isResourceAvilable;
    }

    public void setFilePath(final String fileName) {
        remoteImageName=fileName;
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {

        } else {
            File direct = new File(Environment.getExternalStorageDirectory()
                    + "/InterestWings1");

            if (!direct.exists()) {
                direct.mkdirs();
            }

            DownloadManager mgr = (DownloadManager) getApplicationContext().getSystemService(Context.DOWNLOAD_SERVICE);

            Uri downloadUri = Uri.parse(assetUrl + "/" + remoteImageName);
            DownloadManager.Request request = new DownloadManager.Request(
                    downloadUri);

            request.setAllowedNetworkTypes(
                    DownloadManager.Request.NETWORK_WIFI
                            | DownloadManager.Request.NETWORK_MOBILE)
                    .setAllowedOverRoaming(false).setTitle("File")
                    .setDescription("")
                    .setDestinationInExternalPublicDir("/InterestWings1", remoteImageName);

            mgr.enqueue(request);


/*
            URL url = null;
            try {
                url = new URL(assetUrl + "/" + remoteImageName);
                URLConnection ucon = url.openConnection();
                ucon.setReadTimeout(TIMEOUT_CONNECTION);
                ucon.setConnectTimeout(TIMEOUT_SOCKET);


                //Define InputStreams to read from the URLConnection.
                // uses 3KB download buffer
                InputStream is = ucon.getInputStream();
                BufferedInputStream inStream = new BufferedInputStream(is, 1024 * 5);
                FileOutputStream outStream = new FileOutputStream(dir);
                byte[] buff = new byte[5 * 1024];

                //Read bytes (and store them) until there is nothing more to read(-1)
                int len;
                while ((len = inStream.read(buff)) != -1)
                {
                    outStream.write(buff,0,len);
                }

                //clean up
                outStream.flush();
                outStream.close();
                inStream.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            long startTime = System.currentTimeMillis();*/
          //  Log.i(TAG, "image download beginning: "+imageURL);

            //Open a connection to that URL.


            //this timeout affects how long it takes for the app to realize there's a connection problem


           /* new DownloadFile().execute();
            final File folder = new File(dir); //folder name
            String memBlk;
            if (folder.exists() && folder.isDirectory()) {

            } else {
                folder.mkdirs();
            }
            new Thread(new Runnable() {

                public void run() {
                  //  downloadFile(dir, fileName);
                }
            }).start();*/


        }
    }
    public class DownloadFile extends AsyncTask<String, Integer, String> {
        String videoToDownload = assetUrl + "/" + remoteImageName;

        @Override
        protected String doInBackground(String... params) {
            int count;

            try {
                mp4load(videoToDownload);
            } catch (Exception e) {

            }

            return null;
        }

        public void mp4load(String urling) {
            try {
                URL url = new URL(urling);
                URLConnection con =  url.openConnection();
                con.connect();

                String downloadsPath = Environment.getExternalStorageDirectory() + File.separator + "/sdcard/SalesApp";

                String fileName = remoteImageName;

                File outputFile = new File(downloadsPath, "test");

                if (!outputFile.exists()) {
                    outputFile.createNewFile();
                }
                FileInputStream stream = new FileInputStream(outputFile);
               // FileOutputStream fos = new FileOutputStream(outputFile);
                int count;
                byte[] buffer = new byte[1024];
                ByteArrayOutputStream byteStream =
                        new ByteArrayOutputStream(stream.available());

                while (true) {
                    count = stream.read(buffer);
                    if (count <= 0)
                        break;
                    byteStream.write(buffer, 0, count);
                }
                byteStream.close();
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void downloadFile(String dir, String fileName) {
        try {
            URL url = new URL(assetUrl + "/" + fileName);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setRequestMethod("GET");
            urlConnection.setDoOutput(true);

            //connect
            urlConnection.connect();
            int lenghtOfFile = urlConnection.getContentLength();

            //set the path where we want to save the file
            File SDCardRoot = new File(Environment.getExternalStorageDirectory() + File.separator + "/sdcard/SalesApp");
            //create a new file, to save the downloaded file

            File file = new File(SDCardRoot, "Service");

            if (!file.exists()) {
                file.mkdir();//If there is no folder it will be created.
                Log.e("Directory", "mkdir");

            }

            FileOutputStream fileOutput = new FileOutputStream(file);

            //Stream used for reading the data from the internet
          //  InputStream inputStream = urlConnection.getInputStream();
            InputStream input = new BufferedInputStream(url.openStream());
            //this is the total size of the file which we are downloading
            totalSize = urlConnection.getContentLength();

            runOnUiThread(new Runnable() {
                public void run() {
                    //  pb.setMax(totalSize);
                }
            });

            //create a buffer...
            byte[] buffer = new byte[1024];
            int bufferLength = 0;

            while ((bufferLength = input.read(buffer)) != -1) {
                downloadedSize += bufferLength;

                fileOutput.write(buffer, 0, bufferLength);

            }


            fileOutput.flush();
            fileOutput.close();
            input.close();

            runOnUiThread(new Runnable() {
                public void run() {
                    // pb.dismiss(); // if you want close it..
                }
            });

        } catch (final MalformedURLException e) {
            showError("Error : MalformedURLException " + e);
            e.printStackTrace();
        } catch (final IOException e) {
            showError("Error : IOException " + e);
            e.printStackTrace();
        } catch (final Exception e) {
            showError("Error : Please check your internet connection " + e);
        }
    }

    void showError(final String err) {
        runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(DashboradActivity.this, err, Toast.LENGTH_SHORT).show();
            }
        });

    }





   /* protected boolean shouldAskPermissions() {
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }

    @TargetApi(23)
    protected void askPermissions() {
        String[] permissions = {
                "android.permission.READ_EXTERNAL_STORAGE",
                "android.permission.WRITE_EXTERNAL_STORAGE"
        };
        int requestCode = 200;
        requestPermissions(permissions, requestCode);
    }*/

}
