package com.entity.model;

import com.entity.XuexiaorenyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 学校人员
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XuexiaorenyuanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 学校人员姓名
     */
    private String xuexiaorenyuanName;


    /**
     * 头像
     */
    private String xuexiaorenyuanPhoto;


    /**
     * 学校人员手机号
     */
    private String xuexiaorenyuanPhone;


    /**
     * 学校人员身份证号
     */
    private String xuexiaorenyuanIdNumber;


    /**
     * 邮箱
     */
    private String xuexiaorenyuanEmail;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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

    }
