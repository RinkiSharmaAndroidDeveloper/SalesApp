package salesapp.interstatesawing.com.salesapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

import Adapters.EquipementListAdapter;
import Adapters.JobsListAdapter;
import Adapters.RobotListAdapter;
import Adapters.ServiceListAdapter;
import Database.DatabaseHelper;
import Models.EquipmentsModel;
import Models.JobsModels;
import Models.RobotsModel;
import Models.ServicesModel;

/**
 * Created by VS3 on 7/17/2017.
 */

public class DisplayListDataActivity extends AppCompatActivity implements View.OnClickListener {
   TextView serviceText,homeText,serviceListText,robotListText,equipementListText,jobListText;
    EditText search;
    RecyclerView recyclerView;
    ProgressDialog progressDialog;
    DatabaseHelper databaseHelper;
    ArrayList<ServicesModel> servicesModels;
    ArrayList<RobotsModel> robotsModels;
    ArrayList<EquipmentsModel> equipmentsModels;
    ArrayList<JobsModels> jobsModelses;
    ServiceListAdapter serviceListAdapter;
    RobotListAdapter robotListAdapter;
    EquipementListAdapter equipementListAdapter;
    JobsListAdapter jobsListAdapter;

    String showList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_list_layout);

        serviceText= (TextView)findViewById(R.id.service_field);
        homeText= (TextView)findViewById(R.id.home_text);
        serviceListText= (TextView)findViewById(R.id.servicetext);
        robotListText= (TextView)findViewById(R.id.robottext);
        equipementListText= (TextView)findViewById(R.id.equipmenttext);
        jobListText= (TextView)findViewById(R.id.jobtext);
        recyclerView= (RecyclerView) findViewById(R.id.list_data);
        search= (EditText)findViewById(R.id.searchitems);
        progressDialog= new ProgressDialog(this);
        Intent intent =getIntent();
        showList=intent.getStringExtra("isInterest");
        databaseHelper= new DatabaseHelper(this);
        showListData();

        serviceListText.setOnClickListener(this);
        robotListText.setOnClickListener(this);
        equipementListText.setOnClickListener(this);
        jobListText.setOnClickListener(this);
        homeText.setOnClickListener(this);


    }
    public void setRecyclerViewData() {
        serviceListAdapter = new ServiceListAdapter(servicesModels, DisplayListDataActivity.this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(serviceListAdapter);
        serviceListAdapter.notifyDataSetChanged();

    }
    public void setRobotRecyclerViewData() {
        robotListAdapter = new RobotListAdapter(robotsModels, DisplayListDataActivity.this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(robotListAdapter);
        robotListAdapter.notifyDataSetChanged();

    }
    public void setEquipementRecyclerViewData() {
        equipementListAdapter = new EquipementListAdapter(equipmentsModels, DisplayListDataActivity.this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(equipementListAdapter);
        equipementListAdapter.notifyDataSetChanged();

    }
    public void setJobsRecyclerViewData() {
        jobsListAdapter = new JobsListAdapter(jobsModelses, DisplayListDataActivity.this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(jobsListAdapter);
        jobsListAdapter.notifyDataSetChanged();

    }
    public void showListData(){
        switch(showList){
            case "1":
                servicesModels= databaseHelper.getAllService();
                serviceText.setText("Service");
                setRecyclerViewData();
                break;
            case "2":
                robotsModels= databaseHelper.getAllRobots();
                serviceText.setText("Robot");
                setRobotRecyclerViewData();
                break;
            case "3":
                equipmentsModels= databaseHelper.getAllEquipements();
                serviceText.setText("Equipement");
                setEquipementRecyclerViewData();
                break;
            case "4":
                jobsModelses= databaseHelper.getAllJobs();
                serviceText.setText("Jobs");
                setJobsRecyclerViewData();
                break;



        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.servicetext):
                if(servicesModels.size()>0 && servicesModels !=null){
                    servicesModels.clear();
                }
                servicesModels= databaseHelper.getAllService();
                serviceText.setText("Service");
                setRecyclerViewData();

                break;
            case (R.id.robottext):
                if(robotsModels.size()>0 && robotsModels!=null){
                    robotsModels.clear();
                }
                robotsModels= databaseHelper.getAllRobots();
                serviceText.setText("Robot");
                setRobotRecyclerViewData();
                break;
            case (R.id.equipmenttext):
                if(equipmentsModels.size()>0 &&equipmentsModels !=null){
                    equipmentsModels.clear();
                }
                equipmentsModels= databaseHelper.getAllEquipements();
                serviceText.setText("Equipement");
                setEquipementRecyclerViewData();

                break;
            case (R.id.jobtext):
                if(jobsModelses.size()>0 && jobsModelses!=null){
                    jobsModelses.clear();
                }
                jobsModelses= databaseHelper.getAllJobs();
                serviceText.setText("Jobs");
                setJobsRecyclerViewData();
                break;
            case (R.id.home_text):
               Intent intent=new Intent(DisplayListDataActivity.this,DashboradActivity.class);
                startActivity(intent);
                break;
        }

    }
}
