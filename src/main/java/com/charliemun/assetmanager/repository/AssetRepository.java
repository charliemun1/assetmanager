package com.charliemun.assetmanager.repository;


import com.charliemun.assetmanager.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Asset, Long> {

}
