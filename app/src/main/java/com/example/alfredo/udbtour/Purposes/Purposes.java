package com.example.alfredo.udbtour.Purposes;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Ariel on 12/05/2018.
 */

@Entity
public class Purposes {

    @Id(autoincrement = true)
    private Long Id;

    private String name;

    private String description;

    private String lat;

    private String lon;

    public Purposes() {
    }

    @Generated(hash = 1522195566)
    public Purposes(Long Id, String name, String description, String lat,
            String lon) {
        this.Id = Id;
        this.name = name;
        this.description = description;
        this.lat = lat;
        this.lon = lon;
    }

    public Long getId() {
        return this.Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLat() {
        return this.lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return this.lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }
}
