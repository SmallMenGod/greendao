package com.bidostar.dblibrary.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Transient;

/**
 * @author zsh27
 * @date 2017/12/18.
 * description .
 * @since 0
 */
@Entity
public class UserBean {
    @Id(autoincrement = true)
    private Long id;
    private String name;
    private int age;
    private String address;
    private int sex;
    private String headImgUrl;
    private String signature;
    @Transient
    private String wxName;
    private int maxAge=0;
    private String fuck;
    private int height=170;
    private String wxHeadImgUrl;
    private int width=0;
    private int chineseScore;
    private String chineseName;
    public String getWxName() {
        return wxName;
    }

    public void setWxName(String wxName) {
        this.wxName = wxName;
    }

    @Generated(hash = 1799694802)
    public UserBean(Long id, String name, int age, String address, int sex,
            String headImgUrl, String signature, int maxAge, String fuck,
            int height, String wxHeadImgUrl, int width, int chineseScore,
            String chineseName) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.sex = sex;
        this.headImgUrl = headImgUrl;
        this.signature = signature;
        this.maxAge = maxAge;
        this.fuck = fuck;
        this.height = height;
        this.wxHeadImgUrl = wxHeadImgUrl;
        this.width = width;
        this.chineseScore = chineseScore;
        this.chineseName = chineseName;
    }

    @Generated(hash = 1203313951)
    public UserBean() {
    }


    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", sex=" + sex +
                ", headImgUrl='" + headImgUrl + '\'' +
                ", signature='" + signature + '\'' +
                ", wxName='" + wxName + '\'' +
                ", maxAge=" + maxAge +
                ", fuck='" + fuck + '\'' +
                ", height=" + height +
                ", wxHeadImgUrl='" + wxHeadImgUrl + '\'' +
                ", width=" + width +
                ", chineseScore=" + chineseScore +
                ", chineseName='" + chineseName + '\'' +
                '}';
    }

    public Long getId() {
        return this.id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return this.name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return this.age;
    }


    public void setAge(int age) {
        this.age = age;
    }


    public String getAddress() {
        return this.address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public int getSex() {
        return this.sex;
    }


    public void setSex(int sex) {
        this.sex = sex;
    }


    public String getHeadImgUrl() {
        return this.headImgUrl;
    }


    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }


    public String getSignature() {
        return this.signature;
    }


    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getMaxAge() {
        return this.maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public String getFuck() {
        return this.fuck;
    }

    public void setFuck(String fuck) {
        this.fuck = fuck;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getWxHeadImgUrl() {
        return this.wxHeadImgUrl;
    }

    public void setWxHeadImgUrl(String wxHeadImgUrl) {
        this.wxHeadImgUrl = wxHeadImgUrl;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getChineseScore() {
        return this.chineseScore;
    }

    public void setChineseScore(int chineseScore) {
        this.chineseScore = chineseScore;
    }

    public String getChineseName() {
        return this.chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }


}
