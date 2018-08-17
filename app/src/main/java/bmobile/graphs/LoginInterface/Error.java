package bmobile.graphs.LoginInterface;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.Nullable;

public class Error {
    @SerializedName("text")
    @Expose
    @Nullable
    private String  text;

    @Nullable
    public String getText() {
        return text;
    }

    public void setText(@Nullable String text) {
        this.text = text;
    }

    public Error(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Error{" +
                "text='" + text + '\'' +
                '}';
    }
}
