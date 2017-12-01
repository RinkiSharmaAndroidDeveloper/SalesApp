package Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by VS3 on 7/14/2017.
 */

public class RobotsAssetsModel implements Serializable,Parcelable {
    String RobotId,RobotCategoryId,RobotName,RobotKeywords,RobotThumnail,RobotCreated,RobotUpdated,RobotDeleted;

    public RobotsAssetsModel(String robotId, String robotCategoryId, String robotName, String robotKeywords, String robotThumnail, String robotCreated, String robotUpdated, String robotDeleted) {
        RobotId = robotId;
        RobotCategoryId = robotCategoryId;
        RobotName = robotName;
        RobotKeywords = robotKeywords;
        RobotThumnail = robotThumnail;
        RobotCreated = robotCreated;
        RobotUpdated = robotUpdated;
        RobotDeleted = robotDeleted;
    }

    public RobotsAssetsModel(String robotId, String robotCategoryId, String robotName, String robotKeywords, String robotThumnail, String robotCreated, String robotUpdated) {
        RobotId = robotId;
        RobotCategoryId = robotCategoryId;
        RobotName = robotName;
        RobotKeywords = robotKeywords;
        RobotThumnail = robotThumnail;
        RobotCreated = robotCreated;
        RobotUpdated = robotUpdated;
    }

    public RobotsAssetsModel() {

    }

    protected RobotsAssetsModel(Parcel in) {
        RobotId = in.readString();
        RobotCategoryId = in.readString();
        RobotName = in.readString();
        RobotKeywords = in.readString();
        RobotThumnail = in.readString();
        RobotCreated = in.readString();
        RobotUpdated = in.readString();
        RobotDeleted = in.readString();
    }

    public static final Creator<RobotsAssetsModel> CREATOR = new Creator<RobotsAssetsModel>() {
        @Override
        public RobotsAssetsModel createFromParcel(Parcel in) {
            return new RobotsAssetsModel(in);
        }

        @Override
        public RobotsAssetsModel[] newArray(int size) {
            return new RobotsAssetsModel[size];
        }
    };

    public String getRobotId() {
        return RobotId;
    }

    public void setRobotId(String robotId) {
        RobotId = robotId;
    }

    public String getRobotCategoryId() {
        return RobotCategoryId;
    }

    public void setRobotCategoryId(String robotCategoryId) {
        RobotCategoryId = robotCategoryId;
    }

    public String getRobotName() {
        return RobotName;
    }

    public void setRobotName(String robotName) {
        RobotName = robotName;
    }

    public String getRobotKeywords() {
        return RobotKeywords;
    }

    public void setRobotKeywords(String robotKeywords) {
        RobotKeywords = robotKeywords;
    }

    public String getRobotThumnail() {
        return RobotThumnail;
    }

    public void setRobotThumnail(String robotThumnail) {
        RobotThumnail = robotThumnail;
    }

    public String getRobotCreated() {
        return RobotCreated;
    }

    public void setRobotCreated(String robotCreated) {
        RobotCreated = robotCreated;
    }

    public String getRobotUpdated() {
        return RobotUpdated;
    }

    public void setRobotUpdated(String robotUpdated) {
        RobotUpdated = robotUpdated;
    }

    public String getRobotDeleted() {
        return RobotDeleted;
    }

    public void setRobotDeleted(String robotDeleted) {
        RobotDeleted = robotDeleted;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(RobotId);
        dest.writeString(RobotCategoryId);
        dest.writeString(RobotName);
        dest.writeString(RobotKeywords);
        dest.writeString(RobotThumnail);
        dest.writeString(RobotCreated);
        dest.writeString(RobotUpdated);
        dest.writeString(RobotDeleted);
    }
}
