package com.example.sep17module.covid_19_data;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.sep17module.covid_19_data.pojo_class.Covid19StatsItem;
import com.example.sep17module.covid_19_data.pojo_class.CovidData;
import com.example.sep17module.databinding.ActivityCovid19DataBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Covid19DataActivity extends AppCompatActivity {
    private ActivityCovid19DataBinding binding;

    private List<Covid19StatsItem> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCovid19DataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();

        binding.btnFind.setOnClickListener(view -> {


            String countryName = binding.edtCountry.getText().toString();

            Covid19API api = Covid19APIClient.getAPI();

            Call<CovidData> call = api.getCovidData(countryName);

            call.enqueue(new Callback<CovidData>() {
                @Override
                public void onResponse(Call<CovidData> call, Response<CovidData> response) {

                    CovidData covidData = response.body();

                    list = covidData.getData().getCovid19Stats();

                    ArrayAdapter<Covid19StatsItem> adapter = new ArrayAdapter<>(Covid19DataActivity.this, android.R.layout.simple_list_item_1,list);

                    binding.listViewCovid.setAdapter(adapter);

                }

                @Override
                public void onFailure(Call<CovidData> call, Throwable t) {

                }
            });

        });

    }
}