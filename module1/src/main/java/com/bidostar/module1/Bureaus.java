package com.bidostar.module1;

import java.io.Serializable;

/**
 * @author zsh27
 * @date 2017/12/22.
 * description .
 * @since 0
 */

public class Bureaus implements Serializable{

    /**
     * regionInitial : B
     * region : 北屯
     * name : xinjiang
     */

    private String regionInitial;
    private String region;
    private String name;

    public String getRegionInitial() {
        return regionInitial;
    }

    public void setRegionInitial(String regionInitial) {
        this.regionInitial = regionInitial;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bureaus{" +
                "regionInitial='" + regionInitial + '\'' +
                ", region='" + region + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
