package com.iquantex.otc.mapper;

import com.iquantex.otc.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    List<User> selectBy(Object... var1);

}
