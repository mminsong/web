package com.example.web.Services;

import com.example.web.entities.BusinessEntity;
import com.example.web.mappers.IMainMapper;
import com.example.web.vos.UserTableVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    private final IMainMapper mainMapper;

    @Autowired
    public MainService(IMainMapper mainMapper) {
        this.mainMapper = mainMapper;
    }

    public BusinessEntity[] businesscard(int index) {
        return mainMapper.selectBusiness(index);
    }


    public void insertBusiness(BusinessEntity businessEntity) {
        this.mainMapper.insertBusiness(businessEntity);
    }
    public void deleteUser(int index) {
        this.mainMapper.deleteUser(index);
    }
    public BusinessEntity updateCard(int index) {
        return mainMapper.updateCard(index);
    }

    public void takeCard(BusinessEntity businessEntity) {
        this.mainMapper.takeCard(businessEntity);
    }

    public UserTableVo showTable(String findSelect, String find, int page){
        UserTableVo userTableVo = new UserTableVo();
        userTableVo.setTableCountPerPage(10);
        userTableVo.setRequestPage(page);
        int minPage = userTableVo.getMinPage();
        int total = this.mainMapper.findCount(findSelect, find);
        int maxPage = total / userTableVo.getTableCountPerPage() + (total % userTableVo.getTableCountPerPage() == 0 ? 0 : 1);
        final int pageRange = 4;
        int startPage = Math.max(minPage, page - pageRange);
        int endPage = Math.min(maxPage, page + pageRange);
        userTableVo.setMinPage(minPage);
        userTableVo.setMaxPage(maxPage);
        userTableVo.setStartPage(startPage);
        userTableVo.setEndPage(endPage);
        userTableVo.setBusinessEntities(this.mainMapper.selectfind(findSelect,find, userTableVo.getTableCountPerPage(), (page - 1) * userTableVo.getTableCountPerPage()));
        return userTableVo;
    }
    public UserTableVo getUser(int page){
        UserTableVo userTableVo = new UserTableVo();
        userTableVo.setTableCountPerPage(10);
        userTableVo.setRequestPage(page);
        int minPage = userTableVo.getMinPage();
        int total = this.mainMapper.totalCount();
        int maxPage = total / userTableVo.getTableCountPerPage() + (total % userTableVo.getTableCountPerPage() == 0 ? 0 : 1);
        final int pageRange = 4;
        int startPage = Math.max(minPage, page - pageRange);
        int endPage = Math.min(maxPage, page + pageRange);
        userTableVo.setMinPage(minPage);
        userTableVo.setMaxPage(maxPage);
        userTableVo.setStartPage(startPage);
        userTableVo.setEndPage(endPage);
        userTableVo.setBusinessEntities(this.mainMapper.selectUserTable(userTableVo.getTableCountPerPage(), (page - 1) * userTableVo.getTableCountPerPage()));
        return userTableVo;
    }



}
