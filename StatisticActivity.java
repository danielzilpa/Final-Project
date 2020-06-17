package com.example.babyincar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;

import java.util.ArrayList;
import java.util.List;

public class StatisticActivity extends AppCompatActivity {

    AnyChartView anyChartView;
    int trueAlert = 80;
    int falseAlert = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);
        anyChartView = findViewById(R.id.any_chart_view);
        setUpPieChart();
    }

    public void setUpPieChart() {
        Pie pie = AnyChart.pie();
        pie.background(String.valueOf(Color.BLACK));
        List<DataEntry> list = new ArrayList<>();
        list.add(new ValueDataEntry("True Alert", trueAlert));
        list.add(new ValueDataEntry("False Alert", falseAlert));
        pie.data(list);
        anyChartView.setChart(pie);
    }
}
