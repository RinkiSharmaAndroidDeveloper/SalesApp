package Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by VS3 on 7/14/2017.
 */

public class JobsModels implements Serializable,Parcelable {
    String JobId,JobName,JobType,JobDescription,JobThumnail,JobCreated,JobUpdated,JobDeleted;

    public JobsModels(String jobId, String jobName, String jobType, String jobDescription, String jobThumnail, String jobCreated, String jobUpdated, String jobDeleted) {
        JobId = jobId;
        JobName = jobName;
        JobType = jobType;
        JobDescription = jobDescription;
        JobThumnail = jobThumnail;
        JobCreated = jobCreated;
        JobUpdated = jobUpdated;
        JobDeleted = jobDeleted;
    }

    public JobsModels(String jobId, String jobName, String jobDescription, String jobType, String jobThumnail, String jobUpdated, String jobCreated) {
        JobId = jobId;
        JobName = jobName;
        JobDescription = jobDescription;
        JobType = jobType;
        JobThumnail = jobThumnail;
        JobUpdated = jobUpdated;
        JobCreated = jobCreated;
    }

    public JobsModels() {

    }

    protected JobsModels(Parcel in) {
        JobId = in.readString();
        JobName = in.readString();
        JobType = in.readString();
        JobDescription = in.readString();
        JobThumnail = in.readString();
        JobCreated = in.readString();
        JobUpdated = in.readString();
        JobDeleted = in.readString();
    }

    public static final Creator<JobsModels> CREATOR = new Creator<JobsModels>() {
        @Override
        public JobsModels createFromParcel(Parcel in) {
            return new JobsModels(in);
        }

        @Override
        public JobsModels[] newArray(int size) {
            return new JobsModels[size];
        }
    };

    public String getJobUpdated() {
        return JobUpdated;
    }

    public void setJobUpdated(String jobUpdated) {
        JobUpdated = jobUpdated;
    }

    public String getJobId() {
        return JobId;
    }

    public void setJobId(String jobId) {
        JobId = jobId;
    }

    public String getJobName() {
        return JobName;
    }

    public void setJobName(String jobName) {
        JobName = jobName;
    }

    public String getJobType() {
        return JobType;
    }

    public void setJobType(String jobType) {
        JobType = jobType;
    }

    public String getJobDescription() {
        return JobDescription;
    }

    public void setJobDescription(String jobDescription) {
        JobDescription = jobDescription;
    }

    public String getJobThumnail() {
        return JobThumnail;
    }

    public void setJobThumnail(String jobThumnail) {
        JobThumnail = jobThumnail;
    }

    public String getJobCreated() {
        return JobCreated;
    }

    public void setJobCreated(String jobCreated) {
        JobCreated = jobCreated;
    }

    public String getJobDeleted() {
        return JobDeleted;
    }

    public void setJobDeleted(String jobDeleted) {
        JobDeleted = jobDeleted;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(JobId);
        dest.writeString(JobName);
        dest.writeString(JobType);
        dest.writeString(JobDescription);
        dest.writeString(JobThumnail);
        dest.writeString(JobCreated);
        dest.writeString(JobUpdated);
        dest.writeString(JobDeleted);
    }
}
