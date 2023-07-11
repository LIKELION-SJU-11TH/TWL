package com.example.api.entity;
import javax.persistence.*;

@Entity
@Table(name = "bikes")
public class BikeInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "shared")
    private int shared;
    @Column(name = "parkingBikeTotCnt")
    private int parkingBikeTotCnt;

    @Column(name = "stationName")
    private String stationName;

    @Column(name = "stationLatitude")
    private double stationLatitude;

    @Column(name = "stationLongitude")
    private double stationLongitude;

    @Column(name = "rackTotCnt")
    private int rackTotCnt;

    @Column(name = "stationId")
    private String stationId;


    public BikeInfo() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getShared() {
        return shared;
    }

    public void setShared(int shared) {
        this.shared = shared;
    }

    public int getParkingBikeToCnt() {
        return parkingBikeTotCnt;
    }

    public void setParkingBikeTotCnt(int parkingBikeTotCnt) {
        this.parkingBikeTotCnt = parkingBikeTotCnt;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public double getStationLatitude() {
        return stationLatitude;
    }

    public void setStationLatitude(double stationLatitude) {
        this.stationLatitude = stationLatitude;
    }

    public double getStationLongitude() {
        return stationLongitude;
    }

    public void setStationLongitude(double stationLongitude) {
        this.stationLongitude = stationLongitude;
    }

    public int getRackTotCnt() {
        return rackTotCnt;
    }

    public void setRackTotCnt(int rackTotCnt) {
        this.rackTotCnt = rackTotCnt;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }
}
