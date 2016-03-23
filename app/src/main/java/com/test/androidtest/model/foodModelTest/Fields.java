
package com.test.androidtest.model.foodModelTest;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fields {
    private String itemId;
    private String itemName;
    private String brandName;
    private Integer nfCalories;
    private Integer nfTotalFat;
    private Integer nfServingSizeQty;
    private String nfServingSizeUnit;

    /**
     * 
     * @return
     *     The itemId
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * 
     * @param itemId
     *     The item_id
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * 
     * @return
     *     The itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 
     * @param itemName
     *     The item_name
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * 
     * @return
     *     The brandName
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * 
     * @param brandName
     *     The brand_name
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * 
     * @return
     *     The nfCalories
     */
    public Integer getNfCalories() {
        return nfCalories;
    }

    /**
     * 
     * @param nfCalories
     *     The nf_calories
     */
    public void setNfCalories(Integer nfCalories) {
        this.nfCalories = nfCalories;
    }

    /**
     * 
     * @return
     *     The nfTotalFat
     */
    public Integer getNfTotalFat() {
        return nfTotalFat;
    }

    /**
     * 
     * @param nfTotalFat
     *     The nf_total_fat
     */
    public void setNfTotalFat(Integer nfTotalFat) {
        this.nfTotalFat = nfTotalFat;
    }

    /**
     * 
     * @return
     *     The nfServingSizeQty
     */
    public Integer getNfServingSizeQty() {
        return nfServingSizeQty;
    }

    /**
     * 
     * @param nfServingSizeQty
     *     The nf_serving_size_qty
     */
    public void setNfServingSizeQty(Integer nfServingSizeQty) {
        this.nfServingSizeQty = nfServingSizeQty;
    }

    /**
     * 
     * @return
     *     The nfServingSizeUnit
     */
    public String getNfServingSizeUnit() {
        return nfServingSizeUnit;
    }

    /**
     * 
     * @param nfServingSizeUnit
     *     The nf_serving_size_unit
     */
    public void setNfServingSizeUnit(String nfServingSizeUnit) {
        this.nfServingSizeUnit = nfServingSizeUnit;
    }

}
