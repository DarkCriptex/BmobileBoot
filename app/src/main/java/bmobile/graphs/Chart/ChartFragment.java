package bmobile.graphs.Chart;


import android.os.Bundle;
import android.support.v4.app.Fragment;
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

import java.util.ArrayList;
import java.util.List;

import bmobile.graphs.MainActivity;
import bmobile.graphs.R;


public class ChartFragment extends Fragment {
    List<DataEntry> seriesData;
    Set set;
    Mapping series1Mapping ;
    Mapping series2Mapping ;
    Mapping series3Mapping;
    CartesianSeriesLine series1;
    CartesianSeriesLine series2;
    CartesianSeriesLine series3;
    Cartesian cartesian = AnyChart.line();
    AnyChartView anyChartView;
    int position;



    public ChartFragment() {
        // Required empty public constructor
    }





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {

            position = bundle.getInt(MainActivity.POSITION_KEY);
        }
        else {
            position = 0;
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Toast.makeText(getContext(), "Pocision desde fragment: "+ position, Toast.LENGTH_SHORT).show();
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

        cartesian.setTitle("Trend of Sales of the Most Popular Products of ACME Corp.");

        cartesian.getYAxis().setTitle("Number of Bottles Sold (thousands)");
        cartesian.getXAxis().getLabels().setPadding(5d, 5d, 5d, 5d);

        Chart(position);

        cartesian.getLegend().setEnabled(true);
        cartesian.getLegend().setFontSize(13d);
        cartesian.getLegend().setPadding(0d, 0d, 10d, 0d);

        anyChartView.setChart(cartesian);

        return view;
    }
    private class CustomDataEntry extends ValueDataEntry {

        CustomDataEntry(String x, Number value, Number value2, Number value3) {
            super(x, value);
            setValue("value2", value2);
            setValue("value3", value3);
        }

    }

    private void Chart(int position){
        switch (position){
            case 0:
                seriesData = new ArrayList<>();
                seriesData.add(new CustomDataEntry("1986", 3.6, 2.3, 2.8));
                seriesData.add(new CustomDataEntry("1987", 7.1, 4.0, 4.1));
                seriesData.add(new CustomDataEntry("1988", 8.5, 6.2, 5.1));
                seriesData.add(new CustomDataEntry("1989", 9.2, 11.8, 6.5));
                seriesData.add(new CustomDataEntry("1990", 10.1, 13.0, 12.5));
                seriesData.add(new CustomDataEntry("1991", 11.6, 13.9, 18.0));
                seriesData.add(new CustomDataEntry("1992", 16.4, 18.0, 21.0));
                seriesData.add(new CustomDataEntry("1993", 18.0, 23.3, 20.3));
                seriesData.add(new CustomDataEntry("1994", 13.2, 24.7, 19.2));
                seriesData.add(new CustomDataEntry("1995", 12.0, 18.0, 14.4));
                seriesData.add(new CustomDataEntry("1996", 3.2, 15.1, 9.2));
                seriesData.add(new CustomDataEntry("1997", 4.1, 11.3, 5.9));
                seriesData.add(new CustomDataEntry("1998", 6.3, 14.2, 5.2));
                seriesData.add(new CustomDataEntry("1999", 9.4, 13.7, 4.7));
                seriesData.add(new CustomDataEntry("2000", 11.5, 9.9, 4.2));
                seriesData.add(new CustomDataEntry("2001", 13.5, 12.1, 1.2));
                seriesData.add(new CustomDataEntry("2002", 14.8, 13.5, 5.4));
                seriesData.add(new CustomDataEntry("2003", 16.6, 15.1, 6.3));
                seriesData.add(new CustomDataEntry("2004", 18.1, 17.9, 8.9));
                seriesData.add(new CustomDataEntry("2005", 17.0, 18.9, 10.1));
                seriesData.add(new CustomDataEntry("2006", 16.6, 20.3, 11.5));
                seriesData.add(new CustomDataEntry("2007", 14.1, 20.7, 12.2));
                seriesData.add(new CustomDataEntry("2008", 15.7, 21.6, 10));
                seriesData.add(new CustomDataEntry("2009", 12.0, 22.5, 8.9));

                set = new Set(seriesData);
                series1Mapping = set.mapAs("{ x: 'x', value: 'value' }");
                series2Mapping = set.mapAs("{ x: 'x', value: 'value2' }");
                series3Mapping = set.mapAs("{ x: 'x', value: 'value3' }");

                series1 = cartesian.line(series1Mapping);
                series1.setName("Brandy");
                series1.getHovered().getMarkers().setEnabled(true);
                series1.getHovered().getMarkers()
                        .setType(MarkerType.CIRCLE)
                        .setSize(4d);
                series1.getTooltip()
                        .setPosition("right")
                        .setAnchor(EnumsAnchor.LEFT_CENTER)
                        .setOffsetX(5d)
                        .setOffsetY(5d);

                series2 = cartesian.line(series2Mapping);
                series2.setName("Whiskey");
                series2.getHovered().getMarkers().setEnabled(true);
                series2.getHovered().getMarkers()
                        .setType(MarkerType.CIRCLE)
                        .setSize(4d);
                series2.getTooltip()
                        .setPosition("right")
                        .setAnchor(EnumsAnchor.LEFT_CENTER)
                        .setOffsetX(5d)
                        .setOffsetY(5d);

                series3 = cartesian.line(series3Mapping);
                series3.setName("Tequila");
                series3.getHovered().getMarkers().setEnabled(true);
                series3.getHovered().getMarkers()
                        .setType(MarkerType.CIRCLE)
                        .setSize(4d);
                series3.getTooltip()
                        .setPosition("right")
                        .setAnchor(EnumsAnchor.LEFT_CENTER)
                        .setOffsetX(5d)
                        .setOffsetY(5d);
                break;
            case 1:
                cartesian.setAnimation(true);

                cartesian.setPadding(10d, 20d, 5d, 20d);

                cartesian.getCrosshair().setEnabled(true);
                cartesian.getCrosshair()
                        .setYLabel(true)
                        .setYStroke((Stroke) null, null, null, null, null);

                cartesian.getTooltip().setPositionMode(TooltipPositionMode.POINT);

                cartesian.setTitle("Trend of Sales of the Most Popular Products of ACME Corp.");

                cartesian.getYAxis().setTitle("Number of Bottles Sold (thousands)");
                cartesian.getXAxis().getLabels().setPadding(5d, 5d, 5d, 5d);

                seriesData = new ArrayList<>();

                seriesData.add(new CustomDataEntry("1986", 4.6, 12.3, 2.8));
                seriesData.add(new CustomDataEntry("1987", 6.1, 14.0, 3.1));
                seriesData.add(new CustomDataEntry("1988", 7.5, 16.2, 1.1));
                seriesData.add(new CustomDataEntry("1989", 8.2, 1.8, 16.5));
                seriesData.add(new CustomDataEntry("1990", 11.1, 3.0, 22.5));
                seriesData.add(new CustomDataEntry("1991", 12.6, 15.9, 14.0));
                seriesData.add(new CustomDataEntry("1992", 15.4, 12.0, 11.0));
                seriesData.add(new CustomDataEntry("1993", 17.0, 13.3, 10.3));
                seriesData.add(new CustomDataEntry("1994", 12.2, 14.7, 9.2));
                seriesData.add(new CustomDataEntry("1995", 15.0, 28.0, 4.4));
                seriesData.add(new CustomDataEntry("1996", 1.2, 12.1, 19.2));
                seriesData.add(new CustomDataEntry("1997", 2.1, 10.3, 15.9));
                seriesData.add(new CustomDataEntry("1998", 3.3, 11.2, 15.2));
                seriesData.add(new CustomDataEntry("1999", 3.4, 16.7, 14.7));
                seriesData.add(new CustomDataEntry("2000", 21.5, 19.9, 2.2));
                seriesData.add(new CustomDataEntry("2001", 23.5, 22.1, 2.2));
                seriesData.add(new CustomDataEntry("2002", 24.8, 23.5, 15.4));
                seriesData.add(new CustomDataEntry("2003", 11.6, 25.1, 16.3));
                seriesData.add(new CustomDataEntry("2004", 11.1, 27.9, 18.9));
                seriesData.add(new CustomDataEntry("2005", 15.0, 11.9, 12.1));
                seriesData.add(new CustomDataEntry("2006", 17.6, 10.3, 12.5));
                seriesData.add(new CustomDataEntry("2007", 11.1, 10.7, 14.2));
                seriesData.add(new CustomDataEntry("2008", 11.7, 11.6, 11));
                seriesData.add(new CustomDataEntry("2009", 2.0, 12.5, 18.9));

                set = new Set(seriesData);
                series1Mapping = set.mapAs("{ x: 'x', value: 'value' }");
                series2Mapping = set.mapAs("{ x: 'x', value: 'value2' }");
                series3Mapping = set.mapAs("{ x: 'x', value: 'value3' }");

                series1 = cartesian.line(series1Mapping);
                series1.setName("Brandy");
                series1.getHovered().getMarkers().setEnabled(true);
                series1.getHovered().getMarkers()
                        .setType(MarkerType.CIRCLE)
                        .setSize(4d);
                series1.getTooltip()
                        .setPosition("right")
                        .setAnchor(EnumsAnchor.LEFT_CENTER)
                        .setOffsetX(5d)
                        .setOffsetY(5d);

                series2 = cartesian.line(series2Mapping);
                series2.setName("Whiskey");
                series2.getHovered().getMarkers().setEnabled(true);
                series2.getHovered().getMarkers()
                        .setType(MarkerType.CIRCLE)
                        .setSize(4d);
                series2.getTooltip()
                        .setPosition("right")
                        .setAnchor(EnumsAnchor.LEFT_CENTER)
                        .setOffsetX(5d)
                        .setOffsetY(5d);

                series3 = cartesian.line(series3Mapping);
                series3.setName("Tequila");
                series3.getHovered().getMarkers().setEnabled(true);
                series3.getHovered().getMarkers()
                        .setType(MarkerType.CIRCLE)
                        .setSize(4d);
                series3.getTooltip()
                        .setPosition("right")
                        .setAnchor(EnumsAnchor.LEFT_CENTER)
                        .setOffsetX(5d)
                        .setOffsetY(5d);
                break;
            case 2:
                cartesian.setAnimation(true);

                cartesian.setPadding(10d, 20d, 5d, 20d);

                cartesian.getCrosshair().setEnabled(true);
                cartesian.getCrosshair()
                        .setYLabel(true)
                        .setYStroke((Stroke) null, null, null, null, null);

                cartesian.getTooltip().setPositionMode(TooltipPositionMode.POINT);

                cartesian.setTitle("Trend of Sales of the Most Popular Products of ACME Corp.");

                cartesian.getYAxis().setTitle("Number of Bottles Sold (thousands)");
                cartesian.getXAxis().getLabels().setPadding(5d, 5d, 5d, 5d);

                seriesData = new ArrayList<>();
                seriesData.add(new CustomDataEntry("1986", 23.6, 12.3, 12.8));
                seriesData.add(new CustomDataEntry("1987", 27.1, 14.0, 14.1));
                seriesData.add(new CustomDataEntry("1988", 18.5, 16.2, 15.1));
                seriesData.add(new CustomDataEntry("1989", 19.2, 21.8, 16.5));
                seriesData.add(new CustomDataEntry("1990", 12.1, 23.0, 22.5));
                seriesData.add(new CustomDataEntry("1991", 12.6, 23.9, 28.0));
                seriesData.add(new CustomDataEntry("1992", 14.4, 28.0, 1.0));
                seriesData.add(new CustomDataEntry("1993", 28.0, 13.3, 10.3));
                seriesData.add(new CustomDataEntry("1994", 23.2, 14.7, 9.2));
                seriesData.add(new CustomDataEntry("1995", 22.0, 28.0, 4.4));
                seriesData.add(new CustomDataEntry("1996", 23.2, 25.1, 19.2));
                seriesData.add(new CustomDataEntry("1997", 24.1, 18.3, 15.9));
                seriesData.add(new CustomDataEntry("1998", 16.3, 17.2, 15.2));
                seriesData.add(new CustomDataEntry("1999", 19.4, 16.7, 24.7));
                seriesData.add(new CustomDataEntry("2000", 1.5, 19.9, 14.2));
                seriesData.add(new CustomDataEntry("2001", 3.5, 22.1, 21.2));
                seriesData.add(new CustomDataEntry("2002", 24.8, 23.5, 25.4));
                seriesData.add(new CustomDataEntry("2003", 26.6, 5.1, 26.3));
                seriesData.add(new CustomDataEntry("2004", 8.1, 7.9, 8.9));
                seriesData.add(new CustomDataEntry("2005", 7.0, 8.9, 10.1));
                seriesData.add(new CustomDataEntry("2006", 6.6, 22.3, 21.5));
                seriesData.add(new CustomDataEntry("2007", 4.1, 25.7, 22.2));
                seriesData.add(new CustomDataEntry("2008", 5.7, 11.6, 10));
                seriesData.add(new CustomDataEntry("2009", 2.0, 12.5, 8.9));

                set = new Set(seriesData);
                series1Mapping = set.mapAs("{ x: 'x', value: 'value' }");
                series2Mapping = set.mapAs("{ x: 'x', value: 'value2' }");
                series3Mapping = set.mapAs("{ x: 'x', value: 'value3' }");

                series1 = cartesian.line(series1Mapping);
                series1.setName("Brandy");
                series1.getHovered().getMarkers().setEnabled(true);
                series1.getHovered().getMarkers()
                        .setType(MarkerType.CIRCLE)
                        .setSize(4d);
                series1.getTooltip()
                        .setPosition("right")
                        .setAnchor(EnumsAnchor.LEFT_CENTER)
                        .setOffsetX(5d)
                        .setOffsetY(5d);

                series2 = cartesian.line(series2Mapping);
                series2.setName("Whiskey");
                series2.getHovered().getMarkers().setEnabled(true);
                series2.getHovered().getMarkers()
                        .setType(MarkerType.CIRCLE)
                        .setSize(4d);
                series2.getTooltip()
                        .setPosition("right")
                        .setAnchor(EnumsAnchor.LEFT_CENTER)
                        .setOffsetX(5d)
                        .setOffsetY(5d);

                series3 = cartesian.line(series3Mapping);
                series3.setName("Tequila");
                series3.getHovered().getMarkers().setEnabled(true);
                series3.getHovered().getMarkers()
                        .setType(MarkerType.CIRCLE)
                        .setSize(4d);
                series3.getTooltip()
                        .setPosition("right")
                        .setAnchor(EnumsAnchor.LEFT_CENTER)
                        .setOffsetX(5d)
                        .setOffsetY(5d);
                break;
            case 3:
                cartesian.setAnimation(true);

                cartesian.setPadding(10d, 20d, 5d, 20d);

                cartesian.getCrosshair().setEnabled(true);
                cartesian.getCrosshair()
                        .setYLabel(true)
                        .setYStroke((Stroke) null, null, null, null, null);

                cartesian.getTooltip().setPositionMode(TooltipPositionMode.POINT);

                cartesian.setTitle("Trend of Sales of the Most Popular Products of ACME Corp.");

                cartesian.getYAxis().setTitle("Number of Bottles Sold (thousands)");
                cartesian.getXAxis().getLabels().setPadding(5d, 5d, 5d, 5d);

                seriesData = new ArrayList<>();
                seriesData.add(new CustomDataEntry("1986", 13.6, 22.3, 12.8));
                seriesData.add(new CustomDataEntry("1987", 27.1, 24.0, 14.1));
                seriesData.add(new CustomDataEntry("1988", 28.5, 26.2, 15.1));
                seriesData.add(new CustomDataEntry("1989", 29.2, 1.8, 16.5));
                seriesData.add(new CustomDataEntry("1990", 20.1, 23.0, 22.5));
                seriesData.add(new CustomDataEntry("1991", 21.6, 23.9, 8.0));
                seriesData.add(new CustomDataEntry("1992", 26.4, 8.0, 1.0));
                seriesData.add(new CustomDataEntry("1993", 28.0, 13.3, 22.3));
                seriesData.add(new CustomDataEntry("1994", 23.2, 14.7, 9.2));
                seriesData.add(new CustomDataEntry("1995", 22.0, 8.0, 24.4));
                seriesData.add(new CustomDataEntry("1996", 23.2, 5.1, 19.2));
                seriesData.add(new CustomDataEntry("1997", 24.1, 1.3, 15.9));
                seriesData.add(new CustomDataEntry("1998", 26.3, 4.2, 15.2));
                seriesData.add(new CustomDataEntry("1999", 29.4, 3.7, 14.7));
                seriesData.add(new CustomDataEntry("2000", 21.5, 19.9, 14.2));
                seriesData.add(new CustomDataEntry("2001", 23.5, 2.1, 11.2));
                seriesData.add(new CustomDataEntry("2002", 24.8, 3.5, 15.4));
                seriesData.add(new CustomDataEntry("2003", 16.6, 5.1, 16.3));
                seriesData.add(new CustomDataEntry("2004", 18.1, 7.9, 18.9));
                seriesData.add(new CustomDataEntry("2005", 17.0, 8.9, 11.1));
                seriesData.add(new CustomDataEntry("2006", 16.6, 10.3, 21.5));
                seriesData.add(new CustomDataEntry("2007", 14.1, 10.7, 22.2));
                seriesData.add(new CustomDataEntry("2008", 15.7, 11.6, 20));
                seriesData.add(new CustomDataEntry("2009", 2.0, 12.5, 18.9));

                set = new Set(seriesData);
                series1Mapping = set.mapAs("{ x: 'x', value: 'value' }");
                series2Mapping = set.mapAs("{ x: 'x', value: 'value2' }");
                series3Mapping = set.mapAs("{ x: 'x', value: 'value3' }");

                series1 = cartesian.line(series1Mapping);
                series1.setName("Brandy");
                series1.getHovered().getMarkers().setEnabled(true);
                series1.getHovered().getMarkers()
                        .setType(MarkerType.CIRCLE)
                        .setSize(4d);
                series1.getTooltip()
                        .setPosition("right")
                        .setAnchor(EnumsAnchor.LEFT_CENTER)
                        .setOffsetX(5d)
                        .setOffsetY(5d);

                series2 = cartesian.line(series2Mapping);
                series2.setName("Whiskey");
                series2.getHovered().getMarkers().setEnabled(true);
                series2.getHovered().getMarkers()
                        .setType(MarkerType.CIRCLE)
                        .setSize(4d);
                series2.getTooltip()
                        .setPosition("right")
                        .setAnchor(EnumsAnchor.LEFT_CENTER)
                        .setOffsetX(5d)
                        .setOffsetY(5d);

                series3 = cartesian.line(series3Mapping);
                series3.setName("Tequila");
                series3.getHovered().getMarkers().setEnabled(true);
                series3.getHovered().getMarkers()
                        .setType(MarkerType.CIRCLE)
                        .setSize(4d);
                series3.getTooltip()
                        .setPosition("right")
                        .setAnchor(EnumsAnchor.LEFT_CENTER)
                        .setOffsetX(5d)
                        .setOffsetY(5d);

                cartesian.getLegend().setEnabled(true);
                cartesian.getLegend().setFontSize(13d);
                cartesian.getLegend().setPadding(0d, 0d, 10d, 0d);
                break;
            default:
                break;
        }

    }

}
