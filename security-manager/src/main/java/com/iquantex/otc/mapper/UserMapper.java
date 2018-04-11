package com.iquantex.otc.mapper;

import com.iquantex.otc.model.SysPermission;
import com.iquantex.otc.model.SysRole;
import com.iquantex.otc.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    @Select("SELECT * FROM user_info\n" +
            "WHERE username = #{username, jdbcType=VARCHAR}")
    UserInfo findByUsername(String username);

    @Select("SELECT\n" +
            "\tsr.id id,\n" +
            "\tsr.available available,\n" +
            "\tsr.description description,\n" +
            "\tsr.role role\n" +
            "FROM\n" +
            "\tsys_role sr\n" +
            "LEFT JOIN sys_user_role sur ON sur.role_id = sr.id\n" +
            "WHERE\n" +
            "\tsur.uid = #{uid, jdbcType=INTEGER}")
    List<SysRole> findRoleListByUser(UserInfo userInfo);

    @Select("SELECT\n" +
            "\tsp.id id,\n" +
            "\tsp.available available,\n" +
            "\tsp. NAME NAME,\n" +
            "\tsp.parent_id parent_id,\n" +
            "\tsp.parent_ids parent_ids,\n" +
            "\tsp.permission permission,\n" +
            "\tsp.resource_type resource_type,\n" +
            "\tsp.url url\n" +
            "FROM\n" +
            "\tsys_permission sp\n" +
            "LEFT JOIN sys_role_permission srp ON sp.id = srp.permission_id\n" +
            "WHERE\n" +
            "\tsrp.role_id = #{id}")
    List<SysPermission> findPermissionsByRole(SysRole role);

}
