package com.iquantex.otc.model;

import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.*;
import java.util.Date;

@Table(name = "`sys_user`")
public class User {
    /**
     * 主键
     */
    @Id
    @Column(name = "`id`")
    @ColumnType(jdbcType = JdbcType.BIGINT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 登录名
     */
    @Column(name = "`login_name`")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String loginName;

    /**
     * 密码
     */
    @Column(name = "`passwd`")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String passwd;

    /**
     * 真实姓名
     */
    @Column(name = "`user_name`")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String userName;

    /**
     * 邮箱
     */
    @Column(name = "`email`")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String email;

    /**
     * 手机号
     */
    @Column(name = "`phone`")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String phone;

    /**
     * 角色主键
     */
    @Column(name = "`role_id`")
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long roleId;

    /**
     * 角色名称
     */
    @Column(name = "`role_name`")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String roleName;

    /**
     * 上次登录时间
     */
    @Column(name = "`last_login_time`")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Date lastLoginTime;

    /**
     * 启用/禁用时间
     */
    @Column(name = "`disabled_time`")
    @ColumnType(jdbcType = JdbcType.TIMESTAMP)
    private Date disabledTime;

    /**
     * 是否启用(0:禁用；1：启用)
     */
    @Column(name = "`enabled`")
    @ColumnType(jdbcType = JdbcType.BIT)
    private Boolean enabled;

    /**
     * 是否删除（0：未删除；1：已删除）
     */
    @Column(name = "`deleted`")
    @ColumnType(jdbcType = JdbcType.BIT)
    private Boolean deleted;

    public static final String TABLE = "`sys_user`";

    public static final String f_id = "id";

    public static final String f_loginName = "loginName";

    public static final String f_passwd = "passwd";

    public static final String f_userName = "userName";

    public static final String f_email = "email";

    public static final String f_phone = "phone";

    public static final String f_roleId = "roleId";

    public static final String f_roleName = "roleName";

    public static final String f_lastLoginTime = "lastLoginTime";

    public static final String f_disabledTime = "disabledTime";

    public static final String f_enabled = "enabled";

    public static final String f_deleted = "deleted";

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取登录名
     *
     * @return login_name - 登录名
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 设置登录名
     *
     * @param loginName 登录名
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * 获取密码
     *
     * @return passwd - 密码
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * 设置密码
     *
     * @param passwd 密码
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    /**
     * 获取真实姓名
     *
     * @return user_name - 真实姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置真实姓名
     *
     * @param userName 真实姓名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取手机号
     *
     * @return phone - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取角色主键
     *
     * @return role_id - 角色主键
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置角色主键
     *
     * @param roleId 角色主键
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取角色名称
     *
     * @return role_name - 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * 获取上次登录时间
     *
     * @return last_login_time - 上次登录时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 设置上次登录时间
     *
     * @param lastLoginTime 上次登录时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 获取启用/禁用时间
     *
     * @return disabled_time - 启用/禁用时间
     */
    public Date getDisabledTime() {
        return disabledTime;
    }

    /**
     * 设置启用/禁用时间
     *
     * @param disabledTime 启用/禁用时间
     */
    public void setDisabledTime(Date disabledTime) {
        this.disabledTime = disabledTime;
    }

    /**
     * 获取是否启用(0:禁用；1：启用)
     *
     * @return enabled - 是否启用(0:禁用；1：启用)
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * 设置是否启用(0:禁用；1：启用)
     *
     * @param enabled 是否启用(0:禁用；1：启用)
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * 获取是否删除（0：未删除；1：已删除）
     *
     * @return deleted - 是否删除（0：未删除；1：已删除）
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * 设置是否删除（0：未删除；1：已删除）
     *
     * @param deleted 是否删除（0：未删除；1：已删除）
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", loginName=").append(loginName);
        sb.append(", passwd=").append(passwd);
        sb.append(", userName=").append(userName);
        sb.append(", email=").append(email);
        sb.append(", phone=").append(phone);
        sb.append(", roleId=").append(roleId);
        sb.append(", roleName=").append(roleName);
        sb.append(", lastLoginTime=").append(lastLoginTime);
        sb.append(", disabledTime=").append(disabledTime);
        sb.append(", enabled=").append(enabled);
        sb.append(", deleted=").append(deleted);
        sb.append(", TABLE=").append(TABLE);
        sb.append(", f_id=").append(f_id);
        sb.append(", f_loginName=").append(f_loginName);
        sb.append(", f_passwd=").append(f_passwd);
        sb.append(", f_userName=").append(f_userName);
        sb.append(", f_email=").append(f_email);
        sb.append(", f_phone=").append(f_phone);
        sb.append(", f_roleId=").append(f_roleId);
        sb.append(", f_roleName=").append(f_roleName);
        sb.append(", f_lastLoginTime=").append(f_lastLoginTime);
        sb.append(", f_disabledTime=").append(f_disabledTime);
        sb.append(", f_enabled=").append(f_enabled);
        sb.append(", f_deleted=").append(f_deleted);
        sb.append("]");
        return sb.toString();
    }
}