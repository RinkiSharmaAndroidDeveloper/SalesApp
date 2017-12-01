package Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;

import Models.ServicesModel;
import salesapp.interstatesawing.com.salesapp.R;

/**
 * Created by VS3 on 7/17/2017.
 */

public class ServiceListAdapter extends RecyclerView.Adapter<ServiceListAdapter.MyViewHolder> {
    ArrayList<ServicesModel> servicesModels;
    Context context;
    ServicesModel servicesModel;


    public ServiceListAdapter(ArrayList<ServicesModel> servicesModels,Context context) {
        this.servicesModels = servicesModels;
        this.context = context;

    }

    @Override
    public ServiceListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_of_dasboard_data, parent, false);
        return new ServiceListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ServiceListAdapter.MyViewHolder holder, final int position) {
     servicesModel = servicesModels.get(position);
       holder.Name.setText(servicesModel.getServiceName());
        if(position %2==0){
            holder.linearLayout.setBackgroundColor(Color.GRAY);
        }else{
            holder.linearLayout.setBackgroundColor(Color.WHITE);
        }
        File direct = new File(Environment.getExternalStorageDirectory()
                + "/InterestWings1");
        final File ServiceappDir = new File(direct, "");
        String imagePath= ServiceappDir + "/" + servicesModel.getServiceThumnail();
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        Bitmap bmp = BitmapFactory.decodeFile(imagePath);
       // String image= BitMapToString(bmp);
       // Bitmap bmp1 = BitmapFactory.decodeFile(image);
        holder.imageView.setImageBitmap(bmp);
    }
    public String BitMapToString(Bitmap bitmap){
        ByteArrayOutputStream baos=new  ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100, baos);
        byte [] b=baos.toByteArray();
        String temp=null;
        try{
            System.gc();
            temp=Base64.encodeToString(b, Base64.DEFAULT);
        }catch(Exception e){
            e.printStackTrace();
        }catch(OutOfMemoryError e){
            baos=new  ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG,50, baos);
            b=baos.toByteArray();
            temp=Base64.encodeToString(b, Base64.DEFAULT);
            //Log.e("EWN", "Out of memory error catched");
        }
        return temp;
    }
    @Override
    public int getItemCount() {
        return servicesModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView Name;
        ImageView imageView;
        LinearLayout linearLayout;


        public MyViewHolder(View view) {
            super(view);
            Name = (TextView) view.findViewById(R.id.text_view);
            imageView=(ImageView) view.findViewById(R.id.image_view);
            linearLayout = (LinearLayout) view.findViewById(R.id.linear_layout);

        }

    }
}