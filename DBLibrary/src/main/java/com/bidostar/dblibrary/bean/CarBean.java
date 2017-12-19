package com.bidostar.dblibrary.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author zsh27
 * @date 2017/12/18.
 * description .
 * @since 0
 */
@Entity
public class CarBean {
    private String name;
    private int carId;
    private String brand;

    @Generated(hash = 736436224)
    public CarBean(String name, int carId, String brand) {
        this.name = name;
        this.carId = carId;
        this.brand = brand;
    }

    @Generated(hash = 618925768)
    public CarBean() {
    }

    @Override
    public String toString() {
        return "CarBean{" +
                "name='" + name + '\'' +
                ", carId=" + carId +
                ", brand='" + brand + '\'' +
                '}';
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCarId() {
        return this.carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}

