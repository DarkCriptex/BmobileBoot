package bmobile.graphs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bmobile.graphs.MenuFragment.MenuFragment;

/**
 * A login screen that offers login via email/password.
 */
public class UserEndpointsActivity extends AppCompatActivity implements LoaderCallbacks<Cursor> {

    /**
     * Id to identity READ_CONTACTS permission request.
     */
    private static final int REQUEST_READ_CONTACTS = 0;

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */

    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
    private UserLoginTask mAuthTask = null;

    // UI references.
    private EditText urlEndPointEditText;
    private EditText serverPasswordEditText;
    private EditText awtenatCodeEditText;
    private EditText serverUserEditText;
    private View mProgressView;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_endpoints);


        // Set up the login form.
        urlEndPointEditText = findViewById(R.id.url_endpoints);


        serverPasswordEditText = findViewById(R.id.serverpassword_endpoints);
        serverPasswordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                    if(!isOnline()){
                        showLoginError(getString(R.string.error_network));
                        return false;
                    }
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        Button mEmailSignInButton = findViewById(R.id.send_endpoints_parameters);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isOnline()){
                    showLoginError(getString(R.string.error_network));
                    return;
                }
                attemptLogin();
            }
        });
        serverUserEditText = findViewById(R.id.serveruser_endpoints);
        awtenatCodeEditText = findViewById(R.id.awtenantcode_endpoints);
        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
                urlEndPointEditText.setText(bundle.getString(MenuFragment.URL_ENDPOINTS));
                awtenatCodeEditText.setText(bundle.getString(MenuFragment.AWTENANTCODE_ENDPOINTS));
                serverUserEditText.setText(bundle.getString(MenuFragment.SERVER_USER_ENDPOINTS));
                serverPasswordEditText.setText(bundle.getString(MenuFragment.SERVER_PASSWORD_ENDPOINTS));
        }
    }

    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {
        if (mAuthTask != null) {
            return;
        }

        // Reset errors.
        urlEndPointEditText.setError(null);
        serverPasswordEditText.setError(null);
        serverUserEditText.setError(null);
        awtenatCodeEditText.setError(null);
        // Store values at the time of the login attempt.
        String urlEndpoits = urlEndPointEditText.getText().toString();
        String serverPassword = serverPasswordEditText.getText().toString();
        String serverUser = serverUserEditText.getText().toString();
        String awtenantCode = awtenatCodeEditText.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(serverPassword) && !isPasswordValid(serverPassword)) {
            serverPasswordEditText.setError(getString(R.string.error_invalid_password));
            focusView = serverPasswordEditText;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(urlEndpoits)) {
            urlEndPointEditText.setError(getString(R.string.error_field_required));
            focusView = urlEndPointEditText;
            cancel = true;
        } else if (!isURLValid(urlEndpoits)) {
            urlEndPointEditText.setError(getString(R.string.error_invalid_email));
            focusView = urlEndPointEditText;
            cancel = true;
        }
        if (TextUtils.isEmpty(serverUser)) {
            serverUserEditText.setError(getString(R.string.error_field_required));
            focusView = serverUserEditText;
            cancel = true;
        }
        if (TextUtils.isEmpty(awtenantCode)) {
            awtenatCodeEditText.setError(getString(R.string.error_field_required));
            focusView = awtenatCodeEditText;
            cancel = true;
        }
        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true);
            startAvtivictyOnSuccesLogin();
        }
    }

    private boolean isURLValid(String urlEdponits) {
        //TODO: Replace this with your own logic
        return urlEdponits.contains(".");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

    /**
     * Shows the progress UI and hides the login form.
     */
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
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this,
                // Retrieve data rows for the device user's 'profile' contact.
                Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI,
                        ContactsContract.Contacts.Data.CONTENT_DIRECTORY), ProfileQuery.PROJECTION,

                // Select only email addresses.
                ContactsContract.Contacts.Data.MIMETYPE +
                        " = ?", new String[]{ContactsContract.CommonDataKinds.Email
                .CONTENT_ITEM_TYPE},

                // Show primary email addresses first. Note that there won't be
                // a primary email address if the user hasn't specified one.
                ContactsContract.Contacts.Data.IS_PRIMARY + " DESC");
    }

    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
        List<String> emails = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            emails.add(cursor.getString(ProfileQuery.ADDRESS));
            cursor.moveToNext();
        }


    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {

    }


    private interface ProfileQuery {
        String[] PROJECTION = {
                ContactsContract.CommonDataKinds.Email.ADDRESS,
                ContactsContract.CommonDataKinds.Email.IS_PRIMARY,
        };

        int ADDRESS = 0;
        int IS_PRIMARY = 1;
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mEmail;
        private final String mPassword;

        UserLoginTask(String email, String password) {
            mEmail = email;
            mPassword = password;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return false;
            }

            // TODO: register the new account here.
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;
            showProgress(false);

            if (success) {
                finish();
            } else {
                serverPasswordEditText.setError(getString(R.string.error_incorrect_password));
                serverPasswordEditText.requestFocus();
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            showProgress(false);
        }
    }
    public  boolean isOnline(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();

    }

    private void startAvtivictyOnSuccesLogin() {
        startActivity(new Intent(this, MenuActivity.class));
        finish();
    }

    private void showLoginError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }
}

