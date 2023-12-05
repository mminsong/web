package com.example.web.vos;

import com.example.web.entities.BusinessEntity;
import com.example.web.entities.UserEntity;

public class UserTableVo extends BusinessEntity {
    private int minPage=1;
    private int maxPage;
    private int requestPage;
    private int tableCountPerPage;
    private int startPage;
    private int endPage;
    private BusinessEntity[] businessEntities;
    private String findSelect;
    private String find;

    public int getMinPage() {
        return minPage;
    }

    public void setMinPage(int minPage) {
        this.minPage = minPage;
    }

    public int getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }

    public int getRequestPage() {
        return requestPage;
    }

    public void setRequestPage(int requestPage) {
        this.requestPage = requestPage;
    }

    public int getTableCountPerPage() {
        return tableCountPerPage;
    }

    public void setTableCountPerPage(int tableCountPerPage) {
        this.tableCountPerPage = tableCountPerPage;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public BusinessEntity[] getBusinessEntities() {
        return businessEntities;
    }

    public void setBusinessEntities(BusinessEntity[] businessEntities) {
        this.businessEntities = businessEntities;
    }

    public String getFindSelect() {
        return findSelect;
    }

    public void setFindSelect(String findSelect) {
        this.findSelect = findSelect;
    }

    public String getFind() {
        return find;
    }

    public void setFind(String find) {
        this.find = find;
    }
}
