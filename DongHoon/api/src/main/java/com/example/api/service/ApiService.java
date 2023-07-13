package com.example.api.service;

import com.example.api.entity.BikeInfo;
import com.example.api.entity.BikeStation;
import com.example.api.repository.BikeInfoRepository;
import com.google.gson.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class ApiService {

    private final BikeInfoRepository bikeInfoRepository;
    public void getApi(String apiUrl) throws IOException {

        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("Content-type", "application/json");

        int responseCode = conn.getResponseCode();
        BufferedReader reader = new BufferedReader(new InputStreamReader(responseCode >= 200 && responseCode <= 300 ? conn.getInputStream() : conn.getErrorStream()));

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }


        String jsonString = sb.toString();
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);
        JsonObject rentBikeStatus = jsonObject.getAsJsonObject("rentBikeStatus");
        JsonArray rowArray = rentBikeStatus.getAsJsonArray("row");
        for (JsonElement element : rowArray)
        {
            JsonObject rowObject = element.getAsJsonObject();
            BikeInfo bikeInfo = gson.fromJson(rowObject, BikeInfo.class);
            this.bikeInfoRepository.save(bikeInfo);
        }
        reader.close();
        conn.disconnect();
    }

    public String showApi()
    {
        List<BikeInfo> bikeInfoList;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        bikeInfoList = this.bikeInfoRepository.findAll();


        String bike = gson.toJson(bikeInfoList);
        log.info(bike);
        return bike;
    }

}
