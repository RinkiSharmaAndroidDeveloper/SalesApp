package Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by VS3 on 7/14/2017.
 */

public class JobAssetModel implements Serializable,Parcelable{
    String JobAssetId,JobCategoryId,JobAssetName,JobAssetKeywords,JobAssetThumnail,JobAssetCreated,JobAssetUpdated,JobAssetDeleted;

    public JobAssetModel(String jobAssetId, String jobCategoryId, String jobAssetName, String jobAssetKeywords, String jobAssetThumnail, String jobAssetCreated, String jobAssetUpdated, String jobAssetDeleted) {
        JobAssetId = jobAssetId;
        JobCategoryId = jobCategoryId;
        JobAssetName = jobAssetName;
        JobAssetKeywords = jobAssetKeywords;
        JobAssetThumnail = jobAssetThumnail;
        JobAssetCreated = jobAssetCreated;
        JobAssetUpdated = jobAssetUpdated;
        JobAssetDeleted = jobAssetDeleted;
    }

    public JobAssetModel() {

    }

    public JobAssetModel(String jobAssetId, String jobAssetUpdated, String jobAssetCreated, String jobAssetThumnail, String jobAssetKeywords, String jobAssetName, String jobCategoryId) {
        JobAssetId = jobAssetId;
        JobAssetUpdated = jobAssetUpdated;
        JobAssetCreated = jobAssetCreated;
        JobAssetThumnail = jobAssetThumnail;
        JobAssetKeywords = jobAssetKeywords;
        JobAssetName = jobAssetName;
        JobCategoryId = jobCategoryId;
    }

    protected JobAssetModel(Parcel in) {
        JobAssetId = in.readString();
        JobCategoryId = in.readString();
        JobAssetName = in.readString();
        JobAssetKeywords = in.readString();
        JobAssetThumnail = in.readString();
        JobAssetCreated = in.readString();
        JobAssetUpdated = in.readString();
        JobAssetDeleted = in.readString();
    }

    public static final Creator<JobAssetModel> CREATOR = new Creator<JobAssetModel>() {
        @Override
        public JobAssetModel createFromParcel(Parcel in) {
            return new JobAssetModel(in);
        }

        @Override
        public JobAssetModel[] newArray(int size) {
            return new JobAssetModel[size];
        }
    };

    public String getJobAssetId() {
        return JobAssetId;
    }

    public void setJobAssetId(String jobAssetId) {
        JobAssetId = jobAssetId;
    }

    public String getJobCategoryId() {
        return JobCategoryId;
    }

    public void setJobCategoryId(String jobCategoryId) {
        JobCategoryId = jobCategoryId;
    }

    public String getJobAssetName() {
        return JobAssetName;
    }

    public void setJobAssetName(String jobAssetName) {
        JobAssetName = jobAssetName;
    }

    public String getJobAssetKeywords() {
        return JobAssetKeywords;
    }

    public void setJobAssetKeywords(String jobAssetKeywords) {
        JobAssetKeywords = jobAssetKeywords;
    }

    public String getJobAssetThumnail() {
        return JobAssetThumnail;
    }

    public void setJobAssetThumnail(String jobAssetThumnail) {
        JobAssetThumnail = jobAssetThumnail;
    }

    public String getJobAssetCreated() {
        return JobAssetCreated;
    }

    public void setJobAssetCreated(String jobAssetCreated) {
        JobAssetCreated = jobAssetCreated;
    }

    public String getJobAssetUpdated() {
        return JobAssetUpdated;
    }

    public void setJobAssetUpdated(String jobAssetUpdated) {
        JobAssetUpdated = jobAssetUpdated;
    }

    public String getJobAssetDeleted() {
        return JobAssetDeleted;
    }

    public void setJobAssetDeleted(String jobAssetDeleted) {
        JobAssetDeleted = jobAssetDeleted;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(JobAssetId);
        dest.writeString(JobCategoryId);
        dest.writeString(JobAssetName);
        dest.writeString(JobAssetKeywords);
        dest.writeString(JobAssetThumnail);
        dest.writeString(JobAssetCreated);
        dest.writeString(JobAssetUpdated);
        dest.writeString(JobAssetDeleted);
    }
}
