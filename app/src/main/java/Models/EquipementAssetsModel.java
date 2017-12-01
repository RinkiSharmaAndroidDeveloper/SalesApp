package Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by VS3 on 7/14/2017.
 */

public class EquipementAssetsModel implements Serializable,Parcelable {
    String EquipementAssetId,EquipementCategoryId,EquipementAssetName,EquipementAssetKeywords,EquipementAssetThumnail,EquipementAssetCreated,EquipementAssetUpdated,EquipementAssetDeleted;

    public EquipementAssetsModel(String equipementAssetId, String equipementCategoryId, String equipementAssetName, String equipementAssetKeywords, String equipementAssetThumnail, String equipementAssetCreated, String equipementAssetUpdated, String equipementAssetDeleted) {
        EquipementAssetId = equipementAssetId;
        EquipementCategoryId = equipementCategoryId;
        EquipementAssetName = equipementAssetName;
        EquipementAssetKeywords = equipementAssetKeywords;
        EquipementAssetThumnail = equipementAssetThumnail;
        EquipementAssetCreated = equipementAssetCreated;
        EquipementAssetUpdated = equipementAssetUpdated;
        EquipementAssetDeleted = equipementAssetDeleted;
    }

    public EquipementAssetsModel(String equipementAssetId, String equipementAssetUpdated, String equipementAssetCreated, String equipementAssetThumnail, String equipementAssetKeywords, String equipementAssetName, String equipementCategoryId) {
        EquipementAssetId = equipementAssetId;
        EquipementAssetUpdated = equipementAssetUpdated;
        EquipementAssetCreated = equipementAssetCreated;
        EquipementAssetThumnail = equipementAssetThumnail;
        EquipementAssetKeywords = equipementAssetKeywords;
        EquipementAssetName = equipementAssetName;
        EquipementCategoryId = equipementCategoryId;
    }

    public EquipementAssetsModel() {

    }

    protected EquipementAssetsModel(Parcel in) {
        EquipementAssetId = in.readString();
        EquipementCategoryId = in.readString();
        EquipementAssetName = in.readString();
        EquipementAssetKeywords = in.readString();
        EquipementAssetThumnail = in.readString();
        EquipementAssetCreated = in.readString();
        EquipementAssetUpdated = in.readString();
        EquipementAssetDeleted = in.readString();
    }

    public static final Creator<EquipementAssetsModel> CREATOR = new Creator<EquipementAssetsModel>() {
        @Override
        public EquipementAssetsModel createFromParcel(Parcel in) {
            return new EquipementAssetsModel(in);
        }

        @Override
        public EquipementAssetsModel[] newArray(int size) {
            return new EquipementAssetsModel[size];
        }
    };

    public String getEquipementAssetId() {
        return EquipementAssetId;
    }

    public void setEquipementAssetId(String equipementAssetId) {
        EquipementAssetId = equipementAssetId;
    }

    public String getEquipementCategoryId() {
        return EquipementCategoryId;
    }

    public void setEquipementCategoryId(String equipementCategoryId) {
        EquipementCategoryId = equipementCategoryId;
    }

    public String getEquipementAssetName() {
        return EquipementAssetName;
    }

    public void setEquipementAssetName(String equipementAssetName) {
        EquipementAssetName = equipementAssetName;
    }

    public String getEquipementAssetKeywords() {
        return EquipementAssetKeywords;
    }

    public void setEquipementAssetKeywords(String equipementAssetKeywords) {
        EquipementAssetKeywords = equipementAssetKeywords;
    }

    public String getEquipementAssetThumnail() {
        return EquipementAssetThumnail;
    }

    public void setEquipementAssetThumnail(String equipementAssetThumnail) {
        EquipementAssetThumnail = equipementAssetThumnail;
    }

    public String getEquipementAssetCreated() {
        return EquipementAssetCreated;
    }

    public void setEquipementAssetCreated(String equipementAssetCreated) {
        EquipementAssetCreated = equipementAssetCreated;
    }

    public String getEquipementAssetUpdated() {
        return EquipementAssetUpdated;
    }

    public void setEquipementAssetUpdated(String equipementAssetUpdated) {
        EquipementAssetUpdated = equipementAssetUpdated;
    }

    public String getEquipementAssetDeleted() {
        return EquipementAssetDeleted;
    }

    public void setEquipementAssetDeleted(String equipementAssetDeleted) {
        EquipementAssetDeleted = equipementAssetDeleted;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(EquipementAssetId);
        dest.writeString(EquipementCategoryId);
        dest.writeString(EquipementAssetName);
        dest.writeString(EquipementAssetKeywords);
        dest.writeString(EquipementAssetThumnail);
        dest.writeString(EquipementAssetCreated);
        dest.writeString(EquipementAssetUpdated);
        dest.writeString(EquipementAssetDeleted);
    }
}
