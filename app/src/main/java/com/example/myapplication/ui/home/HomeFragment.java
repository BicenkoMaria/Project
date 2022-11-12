package com.example.myapplication.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.Recipies;
import com.example.myapplication.databinding.FragmentHomeBinding;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    String jsonPath = "https://raw.githubusercontent.com/Lpirskaya/JsonLab/master/recipes2022.json";
    JSONObject obj;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // пытаемся открыть ссылку
                URL url = null;
                try{
                    url = new URL(jsonPath);

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

                // пытаемся установить соединение
                HttpURLConnection conn = null;
                try{
                    conn = (HttpURLConnection) url.openConnection();


                    // получаем строку запихиваем в буффер
                    StringBuilder response = new StringBuilder();
                    BufferedReader input = new BufferedReader(
                            new InputStreamReader(conn.getInputStream()), 8192
                    );
                    String line = null;

                    // парсим нащ буффер на строки и выводим в лог
                    while((line = input.readLine())!= null){
                        response.append(line);
                        Log.i("info", line);

                    }
                    input.close();

                    // создаем гсон обьект
                    Gson gson = new Gson();

                    // запихиваем в массив все наши строки джейсон файла
                    JSONArray jsonArray = new JSONArray(response.toString());
                    Recipies Items; // датакласс наш класс со структурой

                    // пытаемся распарсить пообъектно
                    try {
                        //Items = gson.fromJson(response.toString(), DataClass.class);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject current = jsonArray.getJSONObject(i);

                            String otv = "\n" + "Рецепт " + Integer.toString(i+1) + "\n"
                                    + "Название: " + current.getString("Name") + "\n"
                                    + "Калорийность: "+ Integer.toString(current.getInt("Calorie")) + "\n"
                                    + "Ингредиенты: " + current.getString("Ingredients") + "\n"
                                    + "Сложность: " + Integer.toString(current.getInt("Difficulty")) + "\n";
                            Log.i("RECIPES", otv);
                        }
                        //   jsonArray = obj.getJSONArray("recipe");
                    }
                    catch (JSONException e){
                        e.printStackTrace();
                    }

                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }

                Log.i("MyThread", "inBackground");
            }
        });
        thread.start();

        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}