package com.example.api.controller;
import com.example.api.service.ApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ApiParseController {

    private final ApiService apiService;

    @PostMapping("/{START_INDEX}/{END_INDEX}")
    public void getApi(@PathVariable("START_INDEX") String start,
                         @PathVariable("END_INDEX") String end) throws IOException{

        String baseUrl = "http://openapi.seoul.go.kr:8088";
        String apiKey = "4f667a796a696d6839376342666769";
        String fileType = "json";
        String service = "bikeList";
        String apiUrl = String.format("%s/%s/%s/%s/%s/%s", baseUrl,apiKey, fileType, service, start, end);
        this.apiService.getApi(apiUrl);
    }

    @GetMapping("/get/{START_INDEX}/{END_INDEX}")
    public String ListApi(){
        return this.apiService.showApi();
    }

    @GetMapping("/{shared}")
    public String ListApiWithShared(
            @PathVariable("shared") int shared) {
        return this.apiService.showApiSmallerThanShared(shared);
    }

    @GetMapping("/{latitude}/{longitude}")
    public String nearestBikeStation(
            @PathVariable("latitude") double latitude,
            @PathVariable("longitude") double longitude) {
        return this.apiService.findNearestBikeStation(latitude, longitude);

    }
}
