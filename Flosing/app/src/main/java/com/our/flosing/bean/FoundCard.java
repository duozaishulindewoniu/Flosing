package com.our.flosing.bean;

import java.util.Date;

/**
 * Created by huangrui on 2016/12/28.
 */

public class FoundCard {
    private String id;
    private String type;
    private String name;
    private String title;
    private String description;
    private Date sDate;
    private Date eDate;
    private Boolean isFinish;
    private String contactWay;
    private String contactDetail;

    public String getId() { return this.id; }
    public void setId(String id) { this.id = id; }

    public String getType() { return this.type; }
    public void setType(String type) { this.type = type; }

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    public String getTitle() { return this.title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription()  { return this.description; }
    public void setDescription(String description) { this.description = description; }

    public Date getSDate() { return this.sDate; }
    public void setSDate(Date sDate) { this.sDate = sDate; }

    public Date getEDate() { return this.eDate; }
    public void setEDate(Date eDate) { this.eDate = eDate; }

    public Boolean getIsFinish() { return this.isFinish; }
    public void setIsFinish(Boolean isFinish) { this.isFinish = isFinish; }

    public String getContactWay() { return this.contactWay; }
    public void setContactWay(String contactWay) { this.contactWay = contactWay; }

    public String getContactDetail()  { return this.contactDetail; }
    public void setContactDetail(String contactDetail) { this.contactDetail = contactDetail; }
}
