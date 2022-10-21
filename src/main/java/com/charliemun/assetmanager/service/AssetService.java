package com.charliemun.assetmanager.service;

import com.charliemun.assetmanager.model.Asset;

public interface AssetService {
    Iterable<Asset> findAllAssets();

    Asset getAssetById(Long id);

    Asset save(Asset asset);

    Asset update(Long assetId, Asset asset);

    void deleteAsset(Long assetId);
}
