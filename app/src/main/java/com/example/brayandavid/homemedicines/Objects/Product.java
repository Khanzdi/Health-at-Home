package com.example.brayandavid.homemedicines.Objects;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Kevin Ortiz on 14/03/2018.
 */

public class Product implements Serializable{

    private String id = null;
    private String name = null;
    private String description = null;
    private String medical_characteristics = null;
    private String volume = null;
    private List<String> photos = null;
    private String platform = null;
    private Category category = null;
    private double eachPrice;
    private Bitmap image;

    public String getMedical_characteristics() {
        return medical_characteristics;
    }

    public void setMedical_characteristics(String medical_characteristics) {
        this.medical_characteristics = medical_characteristics;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMedicalCharacteristics() {
        return medical_characteristics;
    }

    public void setMedicalCharacteristics(String medicalCharacteristics) {
        this.medical_characteristics = medicalCharacteristics;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getEachPrice() {
        return eachPrice;
    }

    public void setEachPrice(double eachPrice) {
        this.eachPrice = eachPrice;
    }
}