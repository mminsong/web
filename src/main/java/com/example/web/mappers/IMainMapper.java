package com.example.web.mappers;

import com.example.web.entities.BusinessEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IMainMapper {
    BusinessEntity[] selectBusiness(@Param(value="index")int index);
    int insertBusiness(BusinessEntity businessEntity);
    int deleteUser(@Param(value = "index")int index);

    int takeCard(BusinessEntity businessEntity);
    BusinessEntity updateCard(@Param(value="index")int index);
    BusinessEntity[] selectUserTable(@Param(value = "limit") int limit,
                                     @Param(value = "offset") int offset);

    BusinessEntity[] selectfind (@Param(value = "findSelect")String findSelect,
                                 @Param(value = "find") String find,
                                 @Param(value = "limit") int limit,
                                 @Param(value = "offset") int offset);
    int totalCount();
    int findCount(@Param(value = "findSelect")String findSelect,
                  @Param(value = "find") String find);
}
