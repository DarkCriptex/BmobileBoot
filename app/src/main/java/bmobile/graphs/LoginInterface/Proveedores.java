package bmobile.graphs.LoginInterface;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

public class Proveedores implements Parcelable{
    @SerializedName("name_provider")
    @Expose
    @Nullable
    private String name_provider;
    @SerializedName("url_endpoints")
    @Expose
    @Nullable
    private String urlEndpoints;
    @SerializedName("awtenantcode_endpoints")
    @Expose
    @Nullable
    private String awtenantcodeEndpoints;
    @SerializedName("serverpassword_endpoints")
    @Expose
    @Nullable
    private String serverpasswordEndpoints;
    @SerializedName("serveruser_endpoints")
    @Expose
    @Nullable
    private String serveruserEndpoints;



    @Nullable
    public String getName_provider() {
        return name_provider;
    }

    public void setName_provider(@Nullable String name_provider) {
        this.name_provider = name_provider;
    }

    @Nullable
    public String getUrlEndpoints() {
        return urlEndpoints;
    }

    public void setUrlEndpoints(@Nullable String urlEndpoints) {
        this.urlEndpoints = urlEndpoints;
    }

    @Nullable
    public String getAwtenantcodeEndpoints() {
        return awtenantcodeEndpoints;
    }

    public void setAwtenantcodeEndpoints(@Nullable String awtenantcodeEndpoints) {
        this.awtenantcodeEndpoints = awtenantcodeEndpoints;
    }

    @Nullable
    public String getServerpasswordEndpoints() {
        return serverpasswordEndpoints;
    }

    public void setServerpasswordEndpoints(@Nullable String serverpasswordEndpoints) {
        this.serverpasswordEndpoints = serverpasswordEndpoints;
    }

    @Nullable
    public String getServeruserEndpoints() {
        return serveruserEndpoints;
    }

    public void setServeruserEndpoints(@Nullable String serveruserEndpoints) {
        this.serveruserEndpoints = serveruserEndpoints;
    }

    @Nullable
    public String getNameProvider() {
        return name_provider;
    }

    public void setNameProvider(@Nullable String name_provider) {
        this.name_provider = name_provider;
    }

    protected Proveedores(Parcel in) {

        name_provider = in.readString();
        urlEndpoints = in.readString();
        awtenantcodeEndpoints = in.readString();
        serverpasswordEndpoints = in.readString();
        serveruserEndpoints = in.readString();
    }

    public static final Creator<Proveedores> CREATOR = new Creator<Proveedores>() {
        @Override
        public Proveedores createFromParcel(Parcel in) {
            return new Proveedores(in);
        }

        @Override
        public Proveedores[] newArray(int size) {
            return new Proveedores[size];
        }
    };



    @Override
    public String toString() {
        return "Proveedores{" +
                "name_provider='" + name_provider + '\'' +
                ", urlEndpoints='" + urlEndpoints + '\'' +
                ", awtenantcodeEndpoints='" + awtenantcodeEndpoints + '\'' +
                ", serverpasswordEndpoints='" + serverpasswordEndpoints + '\'' +
                ", serveruserEndpoints='" + serveruserEndpoints + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name_provider);
        dest.writeString(urlEndpoints);
        dest.writeString(awtenantcodeEndpoints);
        dest.writeString(serverpasswordEndpoints);
        dest.writeString(serveruserEndpoints);
    }
}
