package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ZhaopinLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 职位留言
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("zhaopin_liuyan")
public class ZhaopinLiuyanView extends ZhaopinLiuyanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 头像
		*/

		@ColumnInfo(comment="头像",type="varchar(255)")
		private String yonghuPhoto;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 邮箱
		*/

		@ColumnInfo(comment="邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 用户状态
		*/
		@ColumnInfo(comment="用户状态",type="int(11)")
		private Integer yonghuZhuangtaiTypes;
			/**
			* 用户状态的值
			*/
			@ColumnInfo(comment="用户状态的字典表值",type="varchar(200)")
			private String yonghuZhuangtaiValue;
	//级联表 职位招聘
					 
		/**
		* 职位招聘 的 企业
		*/
		@ColumnInfo(comment="企业",type="int(11)")
		private Integer zhaopinQiyeId;
		/**
		* 招聘信息名称
		*/

		@ColumnInfo(comment="招聘信息名称",type="varchar(200)")
		private String zhaopinName;
		/**
		* 招聘信息照片
		*/

		@ColumnInfo(comment="招聘信息照片",type="varchar(200)")
		private String zhaopinPhoto;
		/**
		* 薪资待遇
		*/

		@ColumnInfo(comment="薪资待遇",type="varchar(200)")
		private String zhaopinDaiyu;
		/**
		* 上班地点
		*/

		@ColumnInfo(comment="上班地点",type="varchar(200)")
		private String zhaopinAddress;
		/**
		* 联系人
		*/

		@ColumnInfo(comment="联系人",type="varchar(200)")
		private String lianxirenName;
		/**
		* 招聘电话
		*/

		@ColumnInfo(comment="招聘电话",type="varchar(200)")
		private String zhaopinPhone;
		/**
		* 招聘岗位
		*/
		@ColumnInfo(comment="招聘岗位",type="int(11)")
		private Integer zhaopinTypes;
			/**
			* 招聘岗位的值
			*/
			@ColumnInfo(comment="招聘岗位的字典表值",type="varchar(200)")
			private String zhaopinValue;
		/**
		* 招聘人数
		*/

		@ColumnInfo(comment="招聘人数",type="int(11)")
		private Integer zhaopinRenshuNumber;
		/**
		* 是否上架
		*/
		@ColumnInfo(comment="是否上架",type="int(11)")
		private Integer shangxiaTypes;
			/**
			* 是否上架的值
			*/
			@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
			private String shangxiaValue;
		/**
		* 招聘信息详情
		*/

		@ColumnInfo(comment="招聘信息详情",type="text")
		private String zhaopinContent;
		/**
		* 审核状态
		*/
		@ColumnInfo(comment="审核状态",type="int(11)")
		private Integer zhaopinYesnoTypes;
			/**
			* 审核状态的值
			*/
			@ColumnInfo(comment="审核状态的字典表值",type="varchar(200)")
			private String zhaopinYesnoValue;
		/**
		* 投递回复
		*/

		@ColumnInfo(comment="投递回复",type="text")
		private String zhaopinYesnoText;
		/**
		* 回复时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="回复时间",type="timestamp")
		private Date zhaopinShenheTime;



	public ZhaopinLiuyanView() {

	}

	public ZhaopinLiuyanView(ZhaopinLiuyanEntity zhaopinLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, zhaopinLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}
		/**
		* 获取： 用户状态
		*/
		public Integer getYonghuZhuangtaiTypes() {
			return yonghuZhuangtaiTypes;
		}
		/**
		* 设置： 用户状态
		*/
		public void setYonghuZhuangtaiTypes(Integer yonghuZhuangtaiTypes) {
			this.yonghuZhuangtaiTypes = yonghuZhuangtaiTypes;
		}


			/**
			* 获取： 用户状态的值
			*/
			public String getYonghuZhuangtaiValue() {
				return yonghuZhuangtaiValue;
			}
			/**
			* 设置： 用户状态的值
			*/
			public void setYonghuZhuangtaiValue(String yonghuZhuangtaiValue) {
				this.yonghuZhuangtaiValue = yonghuZhuangtaiValue;
			}
	//级联表的get和set 职位招聘
		/**
		* 获取：职位招聘 的 企业
		*/
		public Integer getZhaopinQiyeId() {
			return zhaopinQiyeId;
		}
		/**
		* 设置：职位招聘 的 企业
		*/
		public void setZhaopinQiyeId(Integer zhaopinQiyeId) {
			this.zhaopinQiyeId = zhaopinQiyeId;
		}

		/**
		* 获取： 招聘信息名称
		*/
		public String getZhaopinName() {
			return zhaopinName;
		}
		/**
		* 设置： 招聘信息名称
		*/
		public void setZhaopinName(String zhaopinName) {
			this.zhaopinName = zhaopinName;
		}

		/**
		* 获取： 招聘信息照片
		*/
		public String getZhaopinPhoto() {
			return zhaopinPhoto;
		}
		/**
		* 设置： 招聘信息照片
		*/
		public void setZhaopinPhoto(String zhaopinPhoto) {
			this.zhaopinPhoto = zhaopinPhoto;
		}

		/**
		* 获取： 薪资待遇
		*/
		public String getZhaopinDaiyu() {
			return zhaopinDaiyu;
		}
		/**
		* 设置： 薪资待遇
		*/
		public void setZhaopinDaiyu(String zhaopinDaiyu) {
			this.zhaopinDaiyu = zhaopinDaiyu;
		}

		/**
		* 获取： 上班地点
		*/
		public String getZhaopinAddress() {
			return zhaopinAddress;
		}
		/**
		* 设置： 上班地点
		*/
		public void setZhaopinAddress(String zhaopinAddress) {
			this.zhaopinAddress = zhaopinAddress;
		}

		/**
		* 获取： 联系人
		*/
		public String getLianxirenName() {
			return lianxirenName;
		}
		/**
		* 设置： 联系人
		*/
		public void setLianxirenName(String lianxirenName) {
			this.lianxirenName = lianxirenName;
		}

		/**
		* 获取： 招聘电话
		*/
		public String getZhaopinPhone() {
			return zhaopinPhone;
		}
		/**
		* 设置： 招聘电话
		*/
		public void setZhaopinPhone(String zhaopinPhone) {
			this.zhaopinPhone = zhaopinPhone;
		}
		/**
		* 获取： 招聘岗位
		*/
		public Integer getZhaopinTypes() {
			return zhaopinTypes;
		}
		/**
		* 设置： 招聘岗位
		*/
		public void setZhaopinTypes(Integer zhaopinTypes) {
			this.zhaopinTypes = zhaopinTypes;
		}


			/**
			* 获取： 招聘岗位的值
			*/
			public String getZhaopinValue() {
				return zhaopinValue;
			}
			/**
			* 设置： 招聘岗位的值
			*/
			public void setZhaopinValue(String zhaopinValue) {
				this.zhaopinValue = zhaopinValue;
			}

		/**
		* 获取： 招聘人数
		*/
		public Integer getZhaopinRenshuNumber() {
			return zhaopinRenshuNumber;
		}
		/**
		* 设置： 招聘人数
		*/
		public void setZhaopinRenshuNumber(Integer zhaopinRenshuNumber) {
			this.zhaopinRenshuNumber = zhaopinRenshuNumber;
		}
		/**
		* 获取： 是否上架
		*/
		public Integer getShangxiaTypes() {
			return shangxiaTypes;
		}
		/**
		* 设置： 是否上架
		*/
		public void setShangxiaTypes(Integer shangxiaTypes) {
			this.shangxiaTypes = shangxiaTypes;
		}


			/**
			* 获取： 是否上架的值
			*/
			public String getShangxiaValue() {
				return shangxiaValue;
			}
			/**
			* 设置： 是否上架的值
			*/
			public void setShangxiaValue(String shangxiaValue) {
				this.shangxiaValue = shangxiaValue;
			}

		/**
		* 获取： 招聘信息详情
		*/
		public String getZhaopinContent() {
			return zhaopinContent;
		}
		/**
		* 设置： 招聘信息详情
		*/
		public void setZhaopinContent(String zhaopinContent) {
			this.zhaopinContent = zhaopinContent;
		}
		/**
		* 获取： 审核状态
		*/
		public Integer getZhaopinYesnoTypes() {
			return zhaopinYesnoTypes;
		}
		/**
		* 设置： 审核状态
		*/
		public void setZhaopinYesnoTypes(Integer zhaopinYesnoTypes) {
			this.zhaopinYesnoTypes = zhaopinYesnoTypes;
		}


			/**
			* 获取： 审核状态的值
			*/
			public String getZhaopinYesnoValue() {
				return zhaopinYesnoValue;
			}
			/**
			* 设置： 审核状态的值
			*/
			public void setZhaopinYesnoValue(String zhaopinYesnoValue) {
				this.zhaopinYesnoValue = zhaopinYesnoValue;
			}

		/**
		* 获取： 投递回复
		*/
		public String getZhaopinYesnoText() {
			return zhaopinYesnoText;
		}
		/**
		* 设置： 投递回复
		*/
		public void setZhaopinYesnoText(String zhaopinYesnoText) {
			this.zhaopinYesnoText = zhaopinYesnoText;
		}

		/**
		* 获取： 回复时间
		*/
		public Date getZhaopinShenheTime() {
			return zhaopinShenheTime;
		}
		/**
		* 设置： 回复时间
		*/
		public void setZhaopinShenheTime(Date zhaopinShenheTime) {
			this.zhaopinShenheTime = zhaopinShenheTime;
		}


	@Override
	public String toString() {
		return "ZhaopinLiuyanView{" +
			", zhaopinName=" + zhaopinName +
			", zhaopinPhoto=" + zhaopinPhoto +
			", zhaopinDaiyu=" + zhaopinDaiyu +
			", zhaopinAddress=" + zhaopinAddress +
			", lianxirenName=" + lianxirenName +
			", zhaopinPhone=" + zhaopinPhone +
			", zhaopinRenshuNumber=" + zhaopinRenshuNumber +
			", zhaopinContent=" + zhaopinContent +
			", zhaopinYesnoText=" + zhaopinYesnoText +
			", zhaopinShenheTime=" + DateUtil.convertString(zhaopinShenheTime,"yyyy-MM-dd") +
			", yonghuName=" + yonghuName +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
