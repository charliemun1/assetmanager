package com.charliemun.assetmanager.service;

import com.charliemun.assetmanager.model.Asset;
import com.charliemun.assetmanager.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


/**
 * Asset service implementation
 */
@Service
@Transactional
public class AssetServiceImpl implements AssetService {

    @Autowired
    private AssetRepository assetRepository;

    @Override
    public Iterable<Asset> findAllAssets() {
        return assetRepository.findAll();
    }

    @Override
    public Asset getAssetById(Long id) {
        return assetRepository.findById(id).orElse(null);
    }

    @Override
    public Asset save(Asset asset) {
        asset.setCreatedAt(new Date());
        return assetRepository.save(asset);
    }

    @Override
    public Asset update(Long assetId, Asset asset) {
        Asset updatedAsset = assetRepository.findById(assetId).orElse(null);
        if(updatedAsset != null) {
            updatedAsset.setNumber(asset.getNumber());
            updatedAsset.setName(asset.getName());
            updatedAsset.setDescription(asset.getDescription());
            updatedAsset.setCurrentValuation(asset.getCurrentValuation());
            updatedAsset.setUpdatedAt(new Date());
            return assetRepository.save(updatedAsset);
        } else return null;
    }

    @Override
    public void deleteAsset(Long assetId) {
        assetRepository.deleteById(assetId);
    }
}

