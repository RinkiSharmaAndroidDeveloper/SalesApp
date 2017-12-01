package Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by VS3 on 7/14/2017.
 */

public class RobotsModel implements Serializable,Parcelable {
    String RobotsId,RobotsName,RobotsType,RobotsDescription,RobotsThumnail,RobotsCreated,RobotsUpdated,RobotsDeleted;

    public RobotsModel(String robotsId, String robotsName, String robotsType, String robotsDescription, String robotsThumnail, String robotsCreated, String robotsUpdated, String robotsDeleted) {
        RobotsId = robotsId;
        RobotsName = robotsName;
        RobotsType = robotsType;
        RobotsDescription = robotsDescription;
        RobotsThumnail = robotsThumnail;
        RobotsCreated = robotsCreated;
        RobotsUpdated = robotsUpdated;
        RobotsDeleted = robotsDeleted;
    }

    public RobotsModel(String robotsId, String robotsName, String robotsType, String robotsDescription, String robotsThumnail, String robotsCreated, String robotsUpdated) {
        RobotsId = robotsId;
        RobotsName = robotsName;
        RobotsType = robotsType;
        RobotsDescription = robotsDescription;
        RobotsThumnail = robotsThumnail;
        RobotsCreated = robotsCreated;
        RobotsUpdated = robotsUpdated;
    }

    public RobotsModel() {

    }

    protected RobotsModel(Parcel in) {
        RobotsId = in.readString();
        RobotsName = in.readString();
        RobotsType = in.readString();
        RobotsDescription = in.readString();
        RobotsThumnail = in.readString();
        RobotsCreated = in.readString();
        RobotsUpdated = in.readString();
        RobotsDeleted = in.readString();
    }

    public static final Creator<RobotsModel> CREATOR = new Creator<RobotsModel>() {
        @Override
        public RobotsModel createFromParcel(Parcel in) {
            return new RobotsModel(in);
        }

        @Override
        public RobotsModel[] newArray(int size) {
            return new RobotsModel[size];
        }
    };

    public String getRobotsUpdated() {
        return RobotsUpdated;
    }

    public void setRobotsUpdated(String robotsUpdated) {
        RobotsUpdated = robotsUpdated;
    }

    public String getRobotsType() {
        return RobotsType;
    }

    public void setRobotsType(String robotsType) {
        RobotsType = robotsType;
    }

    public String getRobotsId() {
        return RobotsId;
    }

    public void setRobotsId(String robotsId) {
        RobotsId = robotsId;
    }

    public String getRobotsName() {
        return RobotsName;
    }

    public void setRobotsName(String robotsName) {
        RobotsName = robotsName;
    }

    public String getRobotsDescription() {
        return RobotsDescription;
    }

    public void setRobotsDescription(String robotsDescription) {
        RobotsDescription = robotsDescription;
    }

    public String getRobotsThumnail() {
        return RobotsThumnail;
    }

    public void setRobotsThumnail(String robotsThumnail) {
        RobotsThumnail = robotsThumnail;
    }

    public String getRobotsCreated() {
        return RobotsCreated;
    }

    public void setRobotsCreated(String robotsCreated) {
        RobotsCreated = robotsCreated;
    }

    public String getRobotsDeleted() {
        return RobotsDeleted;
    }

    public void setRobotsDeleted(String robotsDeleted) {
        RobotsDeleted = robotsDeleted;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(RobotsId);
        dest.writeString(RobotsName);
        dest.writeString(RobotsType);
        dest.writeString(RobotsDescription);
        dest.writeString(RobotsThumnail);
        dest.writeString(RobotsCreated);
        dest.writeString(RobotsUpdated);
        dest.writeString(RobotsDeleted);
    }
}
