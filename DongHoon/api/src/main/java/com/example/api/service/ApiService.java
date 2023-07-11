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

    public String showApiSmallerThanShared(int shared) {

        Iterable<BikeInfo> bikeInfoIterable = this.bikeInfoRepository.findAll();
        List<BikeInfo> bikeInfoList = new ArrayList<>();
        for (BikeInfo bikeInfo : bikeInfoIterable) {
            if (bikeInfo.getShared() <= shared) {
                bikeInfoList.add(bikeInfo);
            }
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String bike = gson.toJson(bikeInfoList);

        log.info("{}", gson);
        return bike;
    }
    public String findNearestBikeStation(double userLatitude, double userLongitude)
    {
        double searchRadius = 1.0;
        double minDistance = Double.MAX_VALUE;
        BikeInfo nearestBikeStation = null;

        List<BikeInfo> bikeInfoList = findWithinRadius(userLatitude, userLongitude, searchRadius);
        for (BikeInfo bikeInfo : bikeInfoList) {
            double stopLatitude = bikeInfo.getStationLatitude();
            double stopLongitude = bikeInfo.getStationLongitude();
            double distance = calculateDistance(
                    userLatitude,
                    userLongitude,
                    stopLatitude,
                    stopLongitude);

            if (distance < minDistance) {
                minDistance = distance;
                nearestBikeStation = bikeInfo;
            }
        }

        BikeStation bikeStation = new BikeStation();
        bikeStation.setStationId(nearestBikeStation.getStationId());
        bikeStation.setStationName(nearestBikeStation.getStationName());
        bikeStation.setStationLongitude(nearestBikeStation.getStationLongitude());
        bikeStation.setStationLatitude(nearestBikeStation.getStationLatitude());
        bikeStation.setDistance(minDistance);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String result = gson.toJson(bikeStation);
        return result;
    }
    public List<BikeInfo> findWithinRadius(double latitude, double longitude, double radius) {
        List<BikeInfo> BikeStationWithinRadius = new ArrayList<>();

        // 데이터베이스에서 모든 정류장 조회
        List<BikeInfo> allBikeStation = this.bikeInfoRepository.findAll();

        // 거리 계산 및 반경 내 정류장 선택
        for (BikeInfo bikeStop : allBikeStation) {
            double distance = calculateDistance(latitude, longitude,
                    bikeStop.getStationLatitude(),
                    bikeStop.getStationLongitude());

            if (distance <= radius) {
                BikeStationWithinRadius.add(bikeStop);
            }
        }

        return BikeStationWithinRadius;
    }

    public double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // 지구 반지름 (단위: km)
        final double EARTH_RADIUS = 6371.0;

        // 경도 및 위도를 라디안 단위로 변환
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        // 두 지점 사이의 차이 계산
        double dLon = lon2Rad - lon1Rad;
        double dLat = lat2Rad - lat1Rad;

        // 헤버식 공식 적용
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(lat1Rad) * Math.cos(lat2Rad)
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c;
    }

}
