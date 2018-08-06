package bmobile.graphs;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import java.util.ArrayList;

import bmobile.graphs.MenuFragment.MenuFragment;

public class MenuActivity extends AppCompatActivity {


    public static final String MENU_FRAGMENT = "Menu_List_fragment";
    public static final String OPTIONS_MENU = "option_Menu";

    FrameLayout frameLayout;
    public ArrayList<String>optionsMenu = new ArrayList<String>(){ {
         add("Graficas");
         add("Chat");
         add("Aruba");
     } };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        Bundle bundle = new Bundle();
        bundle.putStringArrayList(OPTIONS_MENU,optionsMenu);

        MenuFragment menuFragment = new MenuFragment();
        menuFragment.setArguments(bundle);
        frameLayout = findViewById(R.id.menuFrameLayout);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.menuFrameLayout, menuFragment, MENU_FRAGMENT);
        fragmentTransaction.commit();
    }

}
