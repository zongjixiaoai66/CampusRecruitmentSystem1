package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 学校人员
 *
 * @author 
 * @email
 */
@TableName("xuexiaorenyuan")
public class XuexiaorenyuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XuexiaorenyuanEntity() {

	}

	public XuexiaorenyuanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 账户
     */
    @ColumnInfo(comment="账户",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @ColumnInfo(comment="密码",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * 学校人员姓名
     */
    @ColumnInfo(comment="学校人员姓名",type="varchar(200)")
    @TableField(value = "xuexiaorenyuan_name")

    private String xuexiaorenyuanName;


    /**
     * 头像
     */
    @ColumnInfo(comment="头像",type="varchar(255)")
    @TableField(value = "xuexiaorenyuan_photo")

    private String xuexiaorenyuanPhoto;


    /**
     * 学校人员手机号
     */
    @ColumnInfo(comment="学校人员手机号",type="varchar(200)")
    @TableField(value = "xuexiaorenyuan_phone")

    private String xuexiaorenyuanPhone;


    /**
     * 学校人员身份证号
     */
    @ColumnInfo(comment="学校人员身份证号",type="varchar(200)")
    @TableField(value = "xuexiaorenyuan_id_number")

    private String xuexiaorenyuanIdNumber;


    /**
     * 邮箱
     */
    @ColumnInfo(comment="邮箱",type="varchar(200)")
    @TableField(value = "xuexiaorenyuan_email")

    private String xuexiaorenyuanEmail;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 设置：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 设置：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：学校人员姓名
	 */
    public String getXuexiaorenyuanName() {
        return xuexiaorenyuanName;
    }
    /**
	 * 设置：学校人员姓名
	 */

    public void setXuexiaorenyuanName(String xuexiaorenyuanName) {
        this.xuexiaorenyuanName = xuexiaorenyuanName;
    }
    /**
	 * 获取：头像
	 */
    public String getXuexiaorenyuanPhoto() {
        return xuexiaorenyuanPhoto;
    }
    /**
	 * 设置：头像
	 */

    public void setXuexiaorenyuanPhoto(String xuexiaorenyuanPhoto) {
        this.xuexiaorenyuanPhoto = xuexiaorenyuanPhoto;
    }
    /**
	 * 获取：学校人员手机号
	 */
    public String getXuexiaorenyuanPhone() {
        return xuexiaorenyuanPhone;
    }
    /**
	 * 设置：学校人员手机号
	 */

    public void setXuexiaorenyuanPhone(String xuexiaorenyuanPhone) {
        this.xuexiaorenyuanPhone = xuexiaorenyuanPhone;
    }
    /**
	 * 获取：学校人员身份证号
	 */
    public String getXuexiaorenyuanIdNumber() {
        return xuexiaorenyuanIdNumber;
    }
    /**
	 * 设置：学校人员身份证号
	 */

    public void setXuexiaorenyuanIdNumber(String xuexiaorenyuanIdNumber) {
        this.xuexiaorenyuanIdNumber = xuexiaorenyuanIdNumber;
    }
    /**
	 * 获取：邮箱
	 */
    public String getXuexiaorenyuanEmail() {
        return xuexiaorenyuanEmail;
    }
    /**
	 * 设置：邮箱
	 */

    public void setXuexiaorenyuanEmail(String xuexiaorenyuanEmail) {
        this.xuexiaorenyuanEmail = xuexiaorenyuanEmail;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 设置：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Xuexiaorenyuan{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", xuexiaorenyuanName=" + xuexiaorenyuanName +
            ", xuexiaorenyuanPhoto=" + xuexiaorenyuanPhoto +
            ", xuexiaorenyuanPhone=" + xuexiaorenyuanPhone +
            ", xuexiaorenyuanIdNumber=" + xuexiaorenyuanIdNumber +
            ", xuexiaorenyuanEmail=" + xuexiaorenyuanEmail +
            ", sexTypes=" + sexTypes +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
