package bmobile.graphs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bmobile.graphs.LoginInterface.Error;
import bmobile.graphs.LoginInterface.LoginBody;
import bmobile.graphs.LoginInterface.Proveedores;
import bmobile.graphs.LoginInterface.User;
import bmobile.graphs.LoginInterface.UserService;
import bmobile.graphs.MenuFragment.MenuFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static bmobile.graphs.LoginActivity.SUCCESFUL_RESPONSE_CODE;

public class MenuActivity extends AppCompatActivity {


    public static final String MENU_FRAGMENT = "Menu_List_fragment";
    public static final String OPTIONS_MENU = "option_Menu";
    private ArrayList<Proveedores> proveedores;
    private View mLoginFormView;
    private View mProgressView;
    FrameLayout frameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

            mLoginFormView = findViewById(R.id.login_form_Fragment);
            mProgressView = findViewById(R.id.login_progressFragment);
            Bundle bundle2 = getIntent().getExtras();
            if(bundle2 != null){
                proveedores = bundle2.getParcelableArrayList(LoginActivity.STRING_ARRAYLIS_KEY);
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList(OPTIONS_MENU,proveedores);

                MenuFragment menuFragment = new MenuFragment();
                menuFragment.setArguments(bundle);
                frameLayout = findViewById(R.id.menuFrameLayout);
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.menuFrameLayout, menuFragment, MENU_FRAGMENT);
                fragmentTransaction.commit();
            }
            else {
                    getMenu();
            }

        }

    private void getMenu(){
        showProgress(true);
        final SharedPreferences sharedPreferences = this.getSharedPreferences(LoginActivity.LOGIN_DATA, Context.MODE_PRIVATE);
        String userEmail = sharedPreferences.getString(LoginActivity.USER_MAIL,null);
        String userPass  = sharedPreferences.getString(LoginActivity.USER_PASSWORD, null);
        Call<User<Error>> menuFill= UserService.getUserEndpoints().login(new LoginBody(userEmail, userPass));
        menuFill.enqueue(new Callback<User<Error>>() {
            @Override
            public void onResponse(Call<User<Error>> call, Response<User<Error>> response) {
                showProgress(false);
                if (response.code() == SUCCESFUL_RESPONSE_CODE && response.isSuccessful()) {

                    if(response.body().getError() != null){
                        Toast.makeText(MenuActivity.this, "" + response.body().getError().getText(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                    else {
                        proveedores = response.body().proveedores();
                        Bundle bundle = new Bundle();
                        bundle.putParcelableArrayList(OPTIONS_MENU, proveedores);

                        MenuFragment menuFragment = new MenuFragment();
                        menuFragment.setArguments(bundle);
                        frameLayout = findViewById(R.id.menuFrameLayout);
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.add(R.id.menuFrameLayout, menuFragment, MENU_FRAGMENT);
                        fragmentTransaction.commit();
                    }

                }
                else {
                    Toast.makeText(MenuActivity.this, "Ha ocurrido un error inténtelo más tarde" , Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<User<Error>> call, Throwable t) {
                showProgress(false);
                t.getMessage();
                Toast.makeText(MenuActivity.this, "Ha ocurrido un error inténtelo más tarde" , Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿Está seguro que desea salir?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                      /*Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
                      startActivity(intent);*/
                      finishAffinity();
                      android.os.Process.killProcess(android.os.Process.myPid());
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }
 }



