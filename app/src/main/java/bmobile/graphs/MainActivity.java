package bmobile.graphs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import bmobile.graphs.Chart.ChartFragment;
import bmobile.graphs.ErrorBody.Status;
import bmobile.graphs.MenuFragment.MenuFragment;
import bmobile.graphs.ObtenerSensoresInterface.GetSensorsBody;
import bmobile.graphs.ObtenerSensoresInterface.Sensores;
import bmobile.graphs.ObtenerSensoresInterface.SensorsBody;
import bmobile.graphs.ObtenerSensoresInterface.SensorsService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    private static final String CHART_FRAGMENT = "chart_fragment";
    public static final String POSITION_KEY="position";
    public static final String SENSORES_DATA = "SENDOR_DATA";
    public static  Integer USERS_ID;
    private ArrayList<String> sensores = new ArrayList<>();
    ArrayAdapter<String> adapter;
    ArrayList<Sensores> sensoresData = new ArrayList<Sensores>();
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            spinner =  findViewById(R.id.planets_spinner);
            Bundle bundle = getIntent().getExtras();

            if(bundle != null){
                sensoresData = bundle.getParcelableArrayList(MenuFragment.ARRAY_SENSORES);

                Log.e("MainActivity", "SensorData" +sensoresData);

                                // Create an ArrayAdapter using the string array and a default spinner layout
                               // ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,




                                        //R.array.planets_array, android.R.layout.simple_spinner_item);
                                // Specify the layout to use when the list of choices appears
                                //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                // Apply the adapter to the spinner

                                //spinner.setAdapter(adapter);



                        }





           else {
                Toast.makeText(this, "No se encontraron datos", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        fillSpinner(sensoresData);
        Log.e("ListaSpinner", ""+ sensores);


    }


    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);

    }

    public static Integer getUsersId() {
        return USERS_ID;
    }

    public static void setUsersId(Integer usersId) {
        USERS_ID = usersId;
    }

    public void fillSpinner(ArrayList<Sensores> sensores){
        int size =  sensores.size();
        for(int i = 0 ; i < size; i++){
            this.sensores.add(sensores.get(i).getNameDevice());
            Log.e("MainActivity Sensores", "" + this.sensores.get(i));
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, this.sensores);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spinner = new Spinner(this);
        spinner.setAdapter(adapter);
        //fillSpinner(sensoresData);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("SpinnerData", "" + sensoresData.toString());
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                ChartFragment chartFragment = new ChartFragment();
                Bundle bundle = new Bundle();
                bundle.putInt(POSITION_KEY, position);
                bundle.putParcelableArrayList(SENSORES_DATA,sensoresData);
                chartFragment.setArguments(bundle);
                fragmentTransaction.add(R.id.FrameChart, chartFragment, CHART_FRAGMENT);
                fragmentTransaction.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


}

