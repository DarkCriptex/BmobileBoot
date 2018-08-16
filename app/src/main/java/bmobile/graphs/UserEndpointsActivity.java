package bmobile.graphs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserEndpointsActivity extends AppCompatActivity {
    @BindView(R.id.urlEdpointsEditText)
    EditText urlEndPointEditText;
    @BindView(R.id.awtenantcode_endpointsEditText) EditText awtenanrCodeEditText;
    @BindView(R.id.serveruser_endpointsEditText) EditText serverUserEditText;
    @BindView(R.id.serverpassword_endpointsEditText) EditText serverPassword;
    @BindView(R.id.send_Endpoints_button)
    Button sendEndpointsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_endpoints);
        ButterKnife.bind(this);
        Intent intent = getIntent();

        if (intent.hasExtra(LoginActivity.URL_ENDPOINTS)){
            urlEndPointEditText.setText(intent.getStringExtra(LoginActivity.URL_ENDPOINTS));
        }
        else {
            throw new IllegalArgumentException("Activity cannot find  extras " + LoginActivity.URL_ENDPOINTS);
        }
        if (intent.hasExtra(LoginActivity.AWTENANTCODE_ENDPOINTS)){
            awtenanrCodeEditText.setText(intent.getStringExtra(LoginActivity.AWTENANTCODE_ENDPOINTS));
        }
        else {
            throw new IllegalArgumentException("Activity cannot find  extras " + LoginActivity.AWTENANTCODE_ENDPOINTS);
        }
        if (intent.hasExtra(LoginActivity.SERVER_PASSWORD_ENDPOINTS)){
            serverPassword.setText(intent.getStringExtra(LoginActivity.SERVER_PASSWORD_ENDPOINTS));
        }
        else {
            throw new IllegalArgumentException("Activity cannot find  extras " + LoginActivity.SERVER_PASSWORD_ENDPOINTS);
        }
        if (intent.hasExtra(LoginActivity.SERVER_USER_ENDPOINTS)){
            serverUserEditText.setText(intent.getStringExtra(LoginActivity.SERVER_USER_ENDPOINTS));
        }
        else {
            throw new IllegalArgumentException("Activity cannot find  extras " + LoginActivity.SERVER_USER_ENDPOINTS);
        }
    }

    @OnClick(R.id.send_Endpoints_button)
    public void SendEndpoints(){

    }
}
