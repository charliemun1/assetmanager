package com.charliemun.assetmanager.controller;

import com.charliemun.assetmanager.model.Asset;
import com.charliemun.assetmanager.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Asset controller.
 */
@Controller
public class AssetController {
    
    @Autowired
    private AssetService assetService;

    

    /**
     * List all assets.
     *
     * @param model
     * @return
     */
    @GetMapping
    public String list(Model model) {
        model.addAttribute("assets", assetService.findAllAssets());
        return "index";
    }

    /**
     * View a specific asset by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/assets/{id}")
    public String showAsset(@PathVariable Long id, Model model) {
        model.addAttribute("asset", assetService.getAssetById(id));
        return "assetdetails";
    }

    @RequestMapping("/assets/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("asset", assetService.getAssetById(id));
        return "editassetform";
    }

    /**
     * New asset.
     *
     * @param model
     * @return
     */
    @RequestMapping("/assets/new")
    public String newAsset(Model model) {
        model.addAttribute("asset", new Asset());
        return "newassetform";
    }

    /**
     * Save asset to database.
     *
     * @param asset
     * @return
     */
    @PostMapping("/assets")
    public String saveAsset(Asset asset) {
        assetService.save(asset);
        return "redirect:/assets/" + asset.getId();
    }

    /**
     * Update asset in the database.
     *
     * @param asset
     * @return
     */
    @PostMapping("/assets/edit")
    public String updateAsset(Asset asset) {
        assetService.update(asset.getId(), asset);
        return "redirect:/assets/" + asset.getId();
    }

    /**
     * Delete asset by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("/assets/delete/{id}")
    public String delete(@PathVariable Long id) {
        assetService.deleteAsset(id);
        return "redirect:/";
    }

}
