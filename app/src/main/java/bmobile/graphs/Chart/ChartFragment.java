package bmobile.graphs.Chart;


import android.content.Intent;
import android.hardware.Sensor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.anychart.anychart.AnyChart;
import com.anychart.anychart.AnyChartView;
import com.anychart.anychart.Cartesian;
import com.anychart.anychart.CartesianSeriesLine;
import com.anychart.anychart.DataEntry;
import com.anychart.anychart.EnumsAnchor;
import com.anychart.anychart.Mapping;
import com.anychart.anychart.MarkerType;
import com.anychart.anychart.Set;
import com.anychart.anychart.Stroke;
import com.anychart.anychart.TooltipPositionMode;
import com.anychart.anychart.ValueDataEntry;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.Nullable;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import bmobile.graphs.ErrorBody.Status;
import bmobile.graphs.LoginActivity;
import bmobile.graphs.MainActivity;
import bmobile.graphs.MenuActivity;
import bmobile.graphs.ObtenerDatosSensorInterface.ArraySensorData;
import bmobile.graphs.ObtenerDatosSensorInterface.GetSensorDataInterface;
import bmobile.graphs.ObtenerDatosSensorInterface.GetSensorDataService;
import bmobile.graphs.ObtenerDatosSensorInterface.SensorData;
import bmobile.graphs.ObtenerSensoresInterface.Sensores;
import bmobile.graphs.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ChartFragment extends Fragment {
    List<DataEntry> seriesData;
    ArrayList<SensorData> sensorData;
    ArrayList<Sensores> arrayFomBundle;
    Set set;
    Mapping series1Mapping ;
    Mapping series2Mapping ;
    Mapping series3Mapping;

    Mapping temperature;
    Mapping hightemp;
    Mapping lowtemp;
    Mapping humidity;
    Mapping highhum;
    Mapping lowhum;
    Mapping consume;
    Mapping stream;

    CartesianSeriesLine series1;
    CartesianSeriesLine series2;
    CartesianSeriesLine series3;
    CartesianSeriesLine series4;
    CartesianSeriesLine series5;
    CartesianSeriesLine series6;
    CartesianSeriesLine series7;
    CartesianSeriesLine series8;

    Cartesian cartesian = AnyChart.line();
    AnyChartView anyChartView;
    int position;
    int id_device;



    public ChartFragment() {
        // Required empty public constructor
    }





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {

            position = bundle.getInt(MainActivity.POSITION_KEY);
            arrayFomBundle = bundle.getParcelableArrayList(MainActivity.SENSORES_DATA);
        }
        else {
            position = 0;
        }
        Log.e("Array", ""+ arrayFomBundle);
         new asyncTask().execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       // Toast.makeText(getContext(), "Pocision desde fragment: "+ position, Toast.LENGTH_SHORT).show();
        View view = inflater.inflate(R.layout.fragment_chart, container, false);
        anyChartView = view.findViewById(R.id.any_chart_view);
        anyChartView.setProgressBar(view.findViewById(R.id.progress_bar));

        cartesian.setAnimation(true);

        cartesian.setPadding(10d, 20d, 5d, 20d);

        cartesian.getCrosshair().setEnabled(true);
        cartesian.getCrosshair()
                .setYLabel(true)
                .setYStroke((Stroke) null, null, null, null, null);

        cartesian.getTooltip().setPositionMode(TooltipPositionMode.POINT);

        cartesian.setTitle("Monitoreo de Sensores");

        cartesian.getYAxis().setTitle("Parametro de medición (thousands)");
        cartesian.getXAxis().getLabels().setPadding(5d, 5d, 5d, 5d);

        //Chart(position);
        //fillChart();

        cartesian.getLegend().setEnabled(true);
        cartesian.getLegend().setFontSize(13d);
        cartesian.getLegend().setPadding(0d, 0d, 10d, 0d);

        anyChartView.setChart(cartesian);

        return view;
    }
    private class CustomDataEntry extends ValueDataEntry {

        CustomDataEntry(String x, Number value, Number value2, Number value3, Number value4,Number value5,Number value6,Number value7,Number value8) {
            super(x, value);
            setValue("value2", value2);
            setValue("value3", value3);
            setValue("value4", value4);
            setValue("value5", value5);
            setValue("value6", value6);
            setValue("value7", value7);
            setValue("value8", value8);
        }

    }


    public void  getsensorData (int position, ArrayList<Sensores> sensores){
        String uniquenumber_device = sensores.get(position).getUniquenumberDevice();
        final int id_device1 = sensores.get(position).getIdDevice();
        //String uniquenumber_device = "M-636693458406042207";
        //int id_device = 3;
        if (uniquenumber_device != null) {

            Call<ArraySensorData<Status>> getData = GetSensorDataService.getSensorData().getSensorData(uniquenumber_device, id_device1);
            getData.enqueue(new Callback<ArraySensorData<Status>>() {
                @Override
                public void onResponse(Call<ArraySensorData<Status>> call, Response<ArraySensorData<Status>> response) {

                    if (response.code() == LoginActivity.SUCCESFUL_RESPONSE_CODE && response.isSuccessful()) {
                        if (response.body().getStatus() != null) {
                            Toast.makeText(getContext(), "" + response.body().getStatus().getDescription(), Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getContext(), MenuActivity.class);
                            startActivity(intent);
                        } else {
                            //sensorData = response.body().getSensorData();
                            setChart(response.body().getSensorData(), id_device1);
                            //Log.e("Datos del sensor", "" + sensorData.toString());
                        }
                    } else {
                        Toast.makeText(getContext(), "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                        /*Intent intent = new Intent(getContext(), MenuActivity.class);
                        startActivity(intent);*/
                        Log.e("OnResponseFail", "" + response.body().toString());
                    }
                }


                @Override
                public void onFailure(Call<ArraySensorData<Status>> call, Throwable t) {
                    t.getMessage();
                    Log.e("ErrorSensores", "" + t.getMessage());
                }
            });



        }
    }

    private void fillChart(int id_device){
        if (sensorData != null) {

            int size = sensorData.size();
            if (size > 0) {
                seriesData = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    seriesData.add(new CustomDataEntry(sensorData.get(i).getTimestamp_monitoring(), sensorData.get(i).getTemperatureMonitoring(), sensorData.get(i).getHightempMonitoring(),
                            sensorData.get(i).getLowtempMonitoring(), sensorData.get(i).getHumidityMonitoring(), sensorData.get(i).getHighhumMonitoring(), sensorData.get(i).getLowhumMonitoring(),
                            sensorData.get(i).getConsume_monitoring(), sensorData.get(i).getStream_monitoring()));
                }
                cartesian.setAnimation(true);

                cartesian.setPadding(10d, 20d, 5d, 20d);

                cartesian.getCrosshair().setEnabled(true);
                cartesian.getCrosshair()
                        .setYLabel(true)
                        .setYStroke((Stroke) null, null, null, null, null);

                cartesian.getTooltip().setPositionMode(TooltipPositionMode.POINT);

                cartesian.setTitle("Monitoreo de Sensores");

                cartesian.getYAxis().setTitle("Parametros de Medición ");
                cartesian.getXAxis().getLabels().setPadding(5d, 5d, 5d, 5d);
                set = new Set(seriesData);

                series1Mapping = set.mapAs("{ x: 'x', value: 'value' }");
                series2Mapping = set.mapAs("{ x: 'x', value: 'value2' }");
                series3Mapping = set.mapAs("{ x: 'x', value: 'value3' }");

                temperature = set.mapAs("{ x: 'x', value: 'value' }");
                hightemp = set.mapAs("{ x: 'x', value: 'value2' }");
                lowtemp = set.mapAs("{ x: 'x', value: 'value3' }");
                humidity = set.mapAs("{ x: 'x', value: 'value4' }");
                highhum = set.mapAs("{ x: 'x', value: 'value5' }");
                lowhum = set.mapAs("{ x: 'x', value: 'value6' }");
                consume = set.mapAs("{ x: 'x', value: 'value7' }");
                stream = set.mapAs("{ x: 'x', value: 'value8' }");
                switch (id_device){
                    case 1:
                        if (temperature != null) {
                            series1 = cartesian.line(temperature);
                            series1.setName("Temperatura");
                            series1.getHovered().getMarkers().setEnabled(true);

                        }
                        if(hightemp != null){
                            series2 = cartesian.line(hightemp);
                            series2.setName("Temperatura más alta");
                            series2.getHovered().getMarkers()
                                    .setType(MarkerType.CIRCLE)
                                    .setSize(4d);
                            series2.getTooltip()
                                    .setPosition("right")
                                    .setAnchor(EnumsAnchor.LEFT_CENTER)
                                    .setOffsetX(5d)
                                    .setOffsetY(5d);
                        }
                        if(lowtemp != null){
                            series3 = cartesian.line(lowtemp);
                            series3.setName("Temperatura más baja");
                            series3.getHovered().getMarkers()
                                    .setType(MarkerType.CIRCLE)
                                    .setSize(4d);
                            series3.getTooltip()
                                    .setPosition("right")
                                    .setAnchor(EnumsAnchor.LEFT_CENTER)
                                    .setOffsetX(5d)
                                    .setOffsetY(5d);
                        }
                        if(humidity != null){
                            series4 = cartesian.line(humidity);
                            series4.setName("Humedad");
                            series4.getHovered().getMarkers()
                                    .setType(MarkerType.CIRCLE)
                                    .setSize(4d);
                            series4.getTooltip()
                                    .setPosition("right")
                                    .setAnchor(EnumsAnchor.LEFT_CENTER)
                                    .setOffsetX(5d)
                                    .setOffsetY(5d);
                        }
                        if(highhum != null){
                            series5 = cartesian.line(highhum);
                            series5.setName("Nivel de humedad más alto");
                            series5.getHovered().getMarkers()
                                    .setType(MarkerType.CIRCLE)
                                    .setSize(4d);
                            series5.getTooltip()
                                    .setPosition("right")
                                    .setAnchor(EnumsAnchor.LEFT_CENTER)
                                    .setOffsetX(5d)
                                    .setOffsetY(5d);
                        }
                        if(lowhum != null){
                            series6 = cartesian.line(lowhum);
                            series6.setName("Nivel de humedad más bajo");
                            series6.getHovered().getMarkers()
                                    .setType(MarkerType.CIRCLE)
                                    .setSize(4d);
                            series6.getTooltip()
                                    .setPosition("right")
                                    .setAnchor(EnumsAnchor.LEFT_CENTER)
                                    .setOffsetX(5d)
                                    .setOffsetY(5d);
                        }
                        break;
                    case 2:
                        if(consume != null){
                            series7 = cartesian.line(consume);
                            series7.setName("Consumo");
                            series7.getHovered().getMarkers()
                                    .setType(MarkerType.CIRCLE)
                                    .setSize(4d);
                            series7.getTooltip()
                                    .setPosition("right")
                                    .setAnchor(EnumsAnchor.LEFT_CENTER)
                                    .setOffsetX(5d)
                                    .setOffsetY(5d);
                        }
                        if(stream != null){

                            series8 = cartesian.line(stream);
                            series8.setName("Stream");
                            series8.getHovered().getMarkers()
                                    .setType(MarkerType.CIRCLE)
                                    .setSize(4d);
                            series8.getTooltip()
                                    .setPosition("right")
                                    .setAnchor(EnumsAnchor.LEFT_CENTER)
                                    .setOffsetX(5d)
                                    .setOffsetY(5d);
                        }
                        break;
                    case 3:
                        if (temperature != null) {
                            series1 = cartesian.line(temperature);
                            series1.setName("Temperatura");
                            series1.getHovered().getMarkers().setEnabled(true);

                        }
                        if(hightemp != null){
                            series2 = cartesian.line(hightemp);
                            series2.setName("Temperatura más alta");
                            series2.getHovered().getMarkers()
                                    .setType(MarkerType.CIRCLE)
                                    .setSize(4d);
                            series2.getTooltip()
                                    .setPosition("right")
                                    .setAnchor(EnumsAnchor.LEFT_CENTER)
                                    .setOffsetX(5d)
                                    .setOffsetY(5d);
                        }
                        if(lowtemp != null){
                            series3 = cartesian.line(lowtemp);
                            series3.setName("Temperatura más baja");
                            series3.getHovered().getMarkers()
                                    .setType(MarkerType.CIRCLE)
                                    .setSize(4d);
                            series3.getTooltip()
                                    .setPosition("right")
                                    .setAnchor(EnumsAnchor.LEFT_CENTER)
                                    .setOffsetX(5d)
                                    .setOffsetY(5d);
                        }
                        if(humidity != null){
                            series4 = cartesian.line(humidity);
                            series4.setName("Humedad");
                            series4.getHovered().getMarkers()
                                    .setType(MarkerType.CIRCLE)
                                    .setSize(4d);
                            series4.getTooltip()
                                    .setPosition("right")
                                    .setAnchor(EnumsAnchor.LEFT_CENTER)
                                    .setOffsetX(5d)
                                    .setOffsetY(5d);
                        }
                        if(highhum != null){
                            series5 = cartesian.line(highhum);
                            series5.setName("Nivel de humedad más alto");
                            series5.getHovered().getMarkers()
                                    .setType(MarkerType.CIRCLE)
                                    .setSize(4d);
                            series5.getTooltip()
                                    .setPosition("right")
                                    .setAnchor(EnumsAnchor.LEFT_CENTER)
                                    .setOffsetX(5d)
                                    .setOffsetY(5d);
                        }
                        if(lowhum != null){
                            series6 = cartesian.line(lowhum);
                            series6.setName("Nivel de humedad más bajo");
                            series6.getHovered().getMarkers()
                                    .setType(MarkerType.CIRCLE)
                                    .setSize(4d);
                            series6.getTooltip()
                                    .setPosition("right")
                                    .setAnchor(EnumsAnchor.LEFT_CENTER)
                                    .setOffsetX(5d)
                                    .setOffsetY(5d);
                        }
                        if(consume != null){
                            series7 = cartesian.line(consume);
                            series7.setName("Consumo");
                            series7.getHovered().getMarkers()
                                    .setType(MarkerType.CIRCLE)
                                    .setSize(4d);
                            series7.getTooltip()
                                    .setPosition("right")
                                    .setAnchor(EnumsAnchor.LEFT_CENTER)
                                    .setOffsetX(5d)
                                    .setOffsetY(5d);
                        }
                        if(stream != null){

                            series8 = cartesian.line(stream);
                            series8.setName("Stream");
                            series8.getHovered().getMarkers()
                                    .setType(MarkerType.CIRCLE)
                                    .setSize(4d);
                            series8.getTooltip()
                                    .setPosition("right")
                                    .setAnchor(EnumsAnchor.LEFT_CENTER)
                                    .setOffsetX(5d)
                                    .setOffsetY(5d);
                        }
                        break;
                    default:
                        Log.e("Ocurrio un error", "ID_device no existe");
                        break;
                }

                cartesian.getLegend().setEnabled(true);
                cartesian.getLegend().setFontSize(13d);
                cartesian.getLegend().setPadding(0d, 0d, 10d, 0d);
            }
        }
    }

    private void setChart(ArrayList<SensorData> sensorData, int id_device){
        this.sensorData = sensorData;
        this.id_device = id_device;
        Log.e("ArraySensorsData",""+ this.sensorData);
        fillChart(this.id_device);
    }

    public class asyncTask extends AsyncTask<Void, Void, Void>{


        @Override
        protected Void doInBackground(Void... strings) {

                getsensorData(position, arrayFomBundle);



            return null;
        }

    }
}
