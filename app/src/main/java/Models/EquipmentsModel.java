package Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by VS3 on 7/14/2017.
 */

public class EquipmentsModel implements Serializable,Parcelable {
    String EquipmentId,EquipmentName,EquipmentType,EquipmentDescription,EquipmentThumnail,EquipmentCreated,EquipmentUpdated,EquipmentDeleted;

    public EquipmentsModel(String equipmentId, String equipmentName, String equipmentType, String equipmentDescription, String equipmentThumnail, String equipmentCreated, String equipmentUpdated, String equipmentDeleted) {
        EquipmentId = equipmentId;
        EquipmentName = equipmentName;
        EquipmentType = equipmentType;
        EquipmentDescription = equipmentDescription;
        EquipmentThumnail = equipmentThumnail;
        EquipmentCreated = equipmentCreated;
        EquipmentUpdated = equipmentUpdated;
        EquipmentDeleted = equipmentDeleted;
    }

    public EquipmentsModel() {

    }

    public EquipmentsModel(String equipmentId, String equipmentName, String equipmentType, String equipmentDescription, String equipmentThumnail, String equipmentCreated, String equipmentUpdated) {
        EquipmentId = equipmentId;
        EquipmentName = equipmentName;
        EquipmentType = equipmentType;
        EquipmentDescription = equipmentDescription;
        EquipmentThumnail = equipmentThumnail;
        EquipmentCreated = equipmentCreated;
        EquipmentUpdated = equipmentUpdated;
    }

    protected EquipmentsModel(Parcel in) {
        EquipmentId = in.readString();
        EquipmentName = in.readString();
        EquipmentType = in.readString();
        EquipmentDescription = in.readString();
        EquipmentThumnail = in.readString();
        EquipmentCreated = in.readString();
        EquipmentUpdated = in.readString();
        EquipmentDeleted = in.readString();
    }

    public static final Creator<EquipmentsModel> CREATOR = new Creator<EquipmentsModel>() {
        @Override
        public EquipmentsModel createFromParcel(Parcel in) {
            return new EquipmentsModel(in);
        }

        @Override
        public EquipmentsModel[] newArray(int size) {
            return new EquipmentsModel[size];
        }
    };

    public String getEquipmentUpdated() {
        return EquipmentUpdated;
    }

    public void setEquipmentUpdated(String equipmentUpdated) {
        EquipmentUpdated = equipmentUpdated;
    }

    public String getEquipmentId() {
        return EquipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        EquipmentId = equipmentId;
    }

    public String getEquipmentName() {
        return EquipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        EquipmentName = equipmentName;
    }

    public String getEquipmentType() {
        return EquipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        EquipmentType = equipmentType;
    }

    public String getEquipmentDescription() {
        return EquipmentDescription;
    }

    public void setEquipmentDescription(String equipmentDescription) {
        EquipmentDescription = equipmentDescription;
    }

    public String getEquipmentThumnail() {
        return EquipmentThumnail;
    }

    public void setEquipmentThumnail(String equipmentThumnail) {
        EquipmentThumnail = equipmentThumnail;
    }

    public String getEquipmentCreated() {
        return EquipmentCreated;
    }

    public void setEquipmentCreated(String equipmentCreated) {
        EquipmentCreated = equipmentCreated;
    }

    public String getEquipmentDeleted() {
        return EquipmentDeleted;
    }

    public void setEquipmentDeleted(String equipmentDeleted) {
        EquipmentDeleted = equipmentDeleted;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(EquipmentId);
        dest.writeString(EquipmentName);
        dest.writeString(EquipmentType);
        dest.writeString(EquipmentDescription);
        dest.writeString(EquipmentThumnail);
        dest.writeString(EquipmentCreated);
        dest.writeString(EquipmentUpdated);
        dest.writeString(EquipmentDeleted);
    }
}
