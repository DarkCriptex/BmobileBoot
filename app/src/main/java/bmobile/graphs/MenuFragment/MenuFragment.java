package bmobile.graphs.MenuFragment;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import bmobile.graphs.MainActivity;
import bmobile.graphs.MainActivityBoot;
import bmobile.graphs.MenuActivity;
import bmobile.graphs.MenuAdapter.MenuAdapter;
import bmobile.graphs.R;
import bmobile.graphs.SimpleDividerItemDecoration;


public class MenuFragment extends Fragment {

    private static final String TAG = MenuFragment.class.getSimpleName();
    private static final int MY_PERMISSIONS_READ_PHONE_STATE = 1;
    public ArrayList<String>menuList;
    RecyclerView recyclerView;
    public MenuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        menuList = bundle.getStringArrayList(MenuActivity.OPTIONS_MENU);
        if (menuList ==null){
            Log.d(TAG,"El array esta vacio");
        }
        else {
            
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        recyclerView = view.findViewById(R.id.MenuListRecyvlerView);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getContext()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        MenuAdapter menuAdapter = new MenuAdapter(menuList, getContext(), new MenuOnClickItem() {
            @Override
            public void onMenuItemClick(ArrayList<String> MenuList, int position ) {
                goToOptionMenuSelected(MenuList, position);

            }


        });
        recyclerView.setAdapter(menuAdapter);
        return view;
    }

    private void goToOptionMenuSelected(ArrayList<String>MenuList, int position) {
        String name = MenuList.get(position).toString();
        Toast.makeText(getContext(), ""+name, Toast.LENGTH_SHORT).show();

        MenuActivity menuActivity = new MenuActivity();
        if (MenuList.get(position).equals("Graficas")){
            Intent intent = new Intent(getContext(), MainActivity.class);
            startActivity(intent);
        }
        else if (MenuList.get(position).equals("Chat")){
            permissionsReadPhoneState();
        }
        else if(MenuList.get(position).equals("Aruba")){
            Toast.makeText(getContext(), "Lo sentimos esta función aún no esta disponible", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getContext(), "Ha ocurrido un error, inténte más tarde", Toast.LENGTH_SHORT).show();
        }
    }


    public interface MenuOnClickItem{
        void onMenuItemClick(ArrayList<String>menuList, int position);
    }

    public void permissionsReadPhoneState() {
        Log.d("Permission", "entrando al permiso");
        if (ContextCompat.checkSelfPermission(getContext(),
                Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.READ_PHONE_STATE},
                    MY_PERMISSIONS_READ_PHONE_STATE);
            Log.d("Permission denied", Manifest.permission.READ_PHONE_STATE);
        } else {
            getUniqueIMEIId(getContext());
            Long tsLong = System.currentTimeMillis()/1000;
            String ts = tsLong.toString();
            Log.e("TimeStamp", ts);
            MainActivityBoot.setId(getUniqueIMEIId(getContext())+ts);
            Intent intent = new Intent(getContext(), MainActivityBoot.class);
            startActivity(intent);
        }
    }

    public static String getUniqueIMEIId(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            int permissionCheck = ContextCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE);
            String imei = telephonyManager.getDeviceId();
            Log.e("imei", "=" + imei);
            if (imei != null && !imei.isEmpty()) {
                return imei;
            } else {
                return android.os.Build.SERIAL;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_READ_PHONE_STATE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getContext(), "Permission Granted", Toast.LENGTH_SHORT).show();
                    Long tsLong = System.currentTimeMillis()/1000;
                    String ts = tsLong.toString();
                    MainActivityBoot.setId(getUniqueIMEIId(getContext())+ts);
                    Intent intent = new Intent(getContext(), MainActivityBoot.class);
                    startActivity(intent);


                } else {
                    Toast.makeText(getContext(), "El permiso es necesario ", Toast.LENGTH_SHORT).show();

                }
                return;
            }
        }
    }
}
