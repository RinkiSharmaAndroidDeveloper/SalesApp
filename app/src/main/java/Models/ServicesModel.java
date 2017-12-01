package Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by VS3 on 7/14/2017.
 */

public class ServicesModel implements Serializable,Parcelable {
    String ServiceId,ServiceName,ServiceType,ServiceDescription,ServiceThumnail,ServiceCreated,ServiceUpdated,ServiceDeleted;

    public ServicesModel(String serviceId, String serviceName, String serviceType, String serviceDescription, String serviceThumnail, String serviceCreated, String serviceUpdated, String serviceDeleted) {
        ServiceId = serviceId;
        ServiceName = serviceName;
        ServiceType = serviceType;
        ServiceDescription = serviceDescription;
        ServiceThumnail = serviceThumnail;
        ServiceCreated = serviceCreated;
        ServiceUpdated = serviceUpdated;
        ServiceDeleted = serviceDeleted;
    }

    public ServicesModel() {

    }

    public ServicesModel(String serviceId, String serviceName, String serviceType, String serviceDescription, String serviceThumnail, String serviceCreated, String serviceUpdated) {
        ServiceId = serviceId;
        ServiceName = serviceName;
        ServiceType = serviceType;
        ServiceDescription = serviceDescription;
        ServiceThumnail = serviceThumnail;
        ServiceCreated = serviceCreated;
        ServiceUpdated = serviceUpdated;
    }

    protected ServicesModel(Parcel in) {
        ServiceId = in.readString();
        ServiceName = in.readString();
        ServiceType = in.readString();
        ServiceDescription = in.readString();
        ServiceThumnail = in.readString();
        ServiceCreated = in.readString();
        ServiceUpdated = in.readString();
        ServiceDeleted = in.readString();
    }

    public static final Creator<ServicesModel> CREATOR = new Creator<ServicesModel>() {
        @Override
        public ServicesModel createFromParcel(Parcel in) {
            return new ServicesModel(in);
        }

        @Override
        public ServicesModel[] newArray(int size) {
            return new ServicesModel[size];
        }
    };

    public String getServiceUpdated() {
        return ServiceUpdated;
    }

    public void setServiceUpdated(String serviceUpdated) {
        ServiceUpdated = serviceUpdated;
    }

    public String getServiceId() {
        return ServiceId;
    }

    public void setServiceId(String serviceId) {
        ServiceId = serviceId;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public void setServiceName(String serviceName) {
        ServiceName = serviceName;
    }

    public String getServiceType() {
        return ServiceType;
    }

    public void setServiceType(String serviceType) {
        ServiceType = serviceType;
    }

    public String getServiceDescription() {
        return ServiceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        ServiceDescription = serviceDescription;
    }

    public String getServiceThumnail() {
        return ServiceThumnail;
    }

    public void setServiceThumnail(String serviceThumnail) {
        ServiceThumnail = serviceThumnail;
    }

    public String getServiceCreated() {
        return ServiceCreated;
    }

    public void setServiceCreated(String serviceCreated) {
        ServiceCreated = serviceCreated;
    }

    public String getServiceDeleted() {
        return ServiceDeleted;
    }

    public void setServiceDeleted(String serviceDeleted) {
        ServiceDeleted = serviceDeleted;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ServiceId);
        dest.writeString(ServiceName);
        dest.writeString(ServiceType);
        dest.writeString(ServiceDescription);
        dest.writeString(ServiceThumnail);
        dest.writeString(ServiceCreated);
        dest.writeString(ServiceUpdated);
        dest.writeString(ServiceDeleted);
    }
}
