package com.entity.vo;

import com.entity.XuexiaorenyuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 学校人员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xuexiaorenyuan")
public class XuexiaorenyuanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 学校人员姓名
     */

    @TableField(value = "xuexiaorenyuan_name")
    private String xuexiaorenyuanName;


    /**
     * 头像
     */

    @TableField(value = "xuexiaorenyuan_photo")
    private String xuexiaorenyuanPhoto;


    /**
     * 学校人员手机号
     */

    @TableField(value = "xuexiaorenyuan_phone")
    private String xuexiaorenyuanPhone;


    /**
     * 学校人员身份证号
     */

    @TableField(value = "xuexiaorenyuan_id_number")
    private String xuexiaorenyuanIdNumber;


    /**
     * 邮箱
     */

    @TableField(value = "xuexiaorenyuan_email")
    private String xuexiaorenyuanEmail;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：学校人员姓名
	 */
    public String getXuexiaorenyuanName() {
        return xuexiaorenyuanName;
    }


    /**
	 * 获取：学校人员姓名
	 */

    public void setXuexiaorenyuanName(String xuexiaorenyuanName) {
        this.xuexiaorenyuanName = xuexiaorenyuanName;
    }
    /**
	 * 设置：头像
	 */
    public String getXuexiaorenyuanPhoto() {
        return xuexiaorenyuanPhoto;
    }


    /**
	 * 获取：头像
	 */

    public void setXuexiaorenyuanPhoto(String xuexiaorenyuanPhoto) {
        this.xuexiaorenyuanPhoto = xuexiaorenyuanPhoto;
    }
    /**
	 * 设置：学校人员手机号
	 */
    public String getXuexiaorenyuanPhone() {
        return xuexiaorenyuanPhone;
    }


    /**
	 * 获取：学校人员手机号
	 */

    public void setXuexiaorenyuanPhone(String xuexiaorenyuanPhone) {
        this.xuexiaorenyuanPhone = xuexiaorenyuanPhone;
    }
    /**
	 * 设置：学校人员身份证号
	 */
    public String getXuexiaorenyuanIdNumber() {
        return xuexiaorenyuanIdNumber;
    }


    /**
	 * 获取：学校人员身份证号
	 */

    public void setXuexiaorenyuanIdNumber(String xuexiaorenyuanIdNumber) {
        this.xuexiaorenyuanIdNumber = xuexiaorenyuanIdNumber;
    }
    /**
	 * 设置：邮箱
	 */
    public String getXuexiaorenyuanEmail() {
        return xuexiaorenyuanEmail;
    }


    /**
	 * 获取：邮箱
	 */

    public void setXuexiaorenyuanEmail(String xuexiaorenyuanEmail) {
        this.xuexiaorenyuanEmail = xuexiaorenyuanEmail;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
