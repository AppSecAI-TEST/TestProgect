package com.tianniu.custom.model;

/**
 * Created by Administrator on 2017/6/1 0001.
 */

public class IdentityInfo {
    private int id;


    private String groupCode;
    private String groupName;
    private String value;
    private String name;
    private String sort;
    private String parent;
    private int status;


    private String shortName;



    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    private String remark;
    private int textColor=0;
    private int icon=0;

    public int getSelectedBordor() {
        return selectedBordor;
    }

    public void setSelectedBordor(int selectedBordor) {
        this.selectedBordor = selectedBordor;
    }

    public int getSelectedMark() {
        return selectedMark;
    }

    public void setSelectedMark(int selectedMark) {
        this.selectedMark = selectedMark;
    }

    private int selectedBordor=0;
    private int selectedMark=0;

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    private int dictStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDictStatus() {
        return dictStatus;
    }

    public void setDictStatus(int dictStatus) {
        this.dictStatus = dictStatus;
    }
}

