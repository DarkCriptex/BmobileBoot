package bmobile.graphs;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bmobile.graphs.LoginInterface.Proveedores;
import bmobile.graphs.MenuFragment.MenuFragment;

public class MenuActivity extends AppCompatActivity {


    public static final String MENU_FRAGMENT = "Menu_List_fragment";
    public static final String OPTIONS_MENU = "option_Menu";

    FrameLayout frameLayout;
    public static ArrayList<String>optionsMenu = new ArrayList<String>(){ {
         /*add("Graficas");
         add("Chat");
         add("Aruba");*/
     } };


    public static ArrayList<String> getList (){
        return  optionsMenu;
    }
    public static void setList(List<Proveedores> list) {
        for(int i =1; i== list.size(); i++){
            optionsMenu.add(list.get(i).getNameProvider());
            Log.e("Lista: ",""+list.get(i).getNameProvider());
        }
        return;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Bundle bundle2 = getIntent().getExtras();
        if(bundle2 != null){
            ArrayList<Proveedores> proveedores = bundle2.getParcelableArrayList("List");
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
            Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
        }




    }

}
