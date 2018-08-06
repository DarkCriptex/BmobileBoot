package bmobile.graphs;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import bmobile.graphs.Chart.ChartFragment;


public class MainActivity extends AppCompatActivity {
    private static final String CHART_FRAGMENT = "chart_fragment";
    public static final String POSITION_KEY="position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner =  findViewById(R.id.planets_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



                // Toast.makeText(MainActivity.this, ""+ position, Toast.LENGTH_SHORT).show();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                ChartFragment chartFragment = new ChartFragment();
                Bundle bundle = new Bundle();
                bundle.putInt(POSITION_KEY, position);
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

