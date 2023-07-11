package com.example.api.repository;

import com.example.api.entity.BikeInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BikeInfoRepository extends JpaRepository<BikeInfo, Long> {
}
