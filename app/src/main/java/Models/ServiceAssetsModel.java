package Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by VS3 on 7/14/2017.
 */

public class ServiceAssetsModel implements Serializable,Parcelable {
    String AssetId,AssetCategoryId,AssetName,AssetKeywords,AssetThumnail,AssetCreated,AssetUpdated,AssetDeleted;

    public ServiceAssetsModel(String assetId, String assetCategoryId, String assetName, String assetKeywords, String assetThumnail, String assetCreated, String assetUpdated, String assetDeleted) {
        AssetId = assetId;
        AssetCategoryId = assetCategoryId;
        AssetName = assetName;
        AssetKeywords = assetKeywords;
        AssetThumnail = assetThumnail;
        AssetCreated = assetCreated;
        AssetUpdated = assetUpdated;
        AssetDeleted = assetDeleted;
    }

    public ServiceAssetsModel(String assetId, String assetUpdated, String assetCreated, String assetThumnail, String assetKeywords, String assetName, String assetCategoryId) {
        AssetId = assetId;
        AssetUpdated = assetUpdated;
        AssetCreated = assetCreated;
        AssetThumnail = assetThumnail;
        AssetKeywords = assetKeywords;
        AssetName = assetName;
        AssetCategoryId = assetCategoryId;
    }

    public ServiceAssetsModel() {

    }

    protected ServiceAssetsModel(Parcel in) {
        AssetId = in.readString();
        AssetCategoryId = in.readString();
        AssetName = in.readString();
        AssetKeywords = in.readString();
        AssetThumnail = in.readString();
        AssetCreated = in.readString();
        AssetUpdated = in.readString();
        AssetDeleted = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(AssetId);
        dest.writeString(AssetCategoryId);
        dest.writeString(AssetName);
        dest.writeString(AssetKeywords);
        dest.writeString(AssetThumnail);
        dest.writeString(AssetCreated);
        dest.writeString(AssetUpdated);
        dest.writeString(AssetDeleted);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ServiceAssetsModel> CREATOR = new Creator<ServiceAssetsModel>() {
        @Override
        public ServiceAssetsModel createFromParcel(Parcel in) {
            return new ServiceAssetsModel(in);
        }

        @Override
        public ServiceAssetsModel[] newArray(int size) {
            return new ServiceAssetsModel[size];
        }
    };

    public String getAssetId() {
        return AssetId;
    }

    public void setAssetId(String assetId) {
        AssetId = assetId;
    }

    public String getAssetCategoryId() {
        return AssetCategoryId;
    }

    public void setAssetCategoryId(String assetCategoryId) {
        AssetCategoryId = assetCategoryId;
    }

    public String getAssetName() {
        return AssetName;
    }

    public void setAssetName(String assetName) {
        AssetName = assetName;
    }

    public String getAssetKeywords() {
        return AssetKeywords;
    }

    public void setAssetKeywords(String assetKeywords) {
        AssetKeywords = assetKeywords;
    }

    public String getAssetThumnail() {
        return AssetThumnail;
    }

    public void setAssetThumnail(String assetThumnail) {
        AssetThumnail = assetThumnail;
    }

    public String getAssetCreated() {
        return AssetCreated;
    }

    public void setAssetCreated(String assetCreated) {
        AssetCreated = assetCreated;
    }

    public String getAssetUpdated() {
        return AssetUpdated;
    }

    public void setAssetUpdated(String assetUpdated) {
        AssetUpdated = assetUpdated;
    }

    public String getAssetDeleted() {
        return AssetDeleted;
    }

    public void setAssetDeleted(String assetDeleted) {
        AssetDeleted = assetDeleted;
    }
}
