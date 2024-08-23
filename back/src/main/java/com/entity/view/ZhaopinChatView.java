package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ZhaopinChatEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 用户咨询
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("zhaopin_chat")
public class ZhaopinChatView extends ZhaopinChatEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 状态的值
	*/
	@ColumnInfo(comment="状态的字典表值",type="varchar(200)")
	private String zhuangtaiValue;
	/**
	* 数据类型的值
	*/
	@ColumnInfo(comment="数据类型的字典表值",type="varchar(200)")
	private String zhaopinChatValue;

	//级联表 企业
		/**
		* 企业名称
		*/

		@ColumnInfo(comment="企业名称",type="varchar(200)")
		private String qiyeName;
		/**
		* 企业类型
		*/
		@ColumnInfo(comment="企业类型",type="int(11)")
		private Integer qiyeTypes;
			/**
			* 企业类型的值
			*/
			@ColumnInfo(comment="企业类型的字典表值",type="varchar(200)")
			private String qiyeValue;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String qiyePhone;
		/**
		* 邮箱
		*/

		@ColumnInfo(comment="邮箱",type="varchar(200)")
		private String qiyeEmail;
		/**
		* 企业logo
		*/

		@ColumnInfo(comment="企业logo",type="varchar(200)")
		private String qiyePhoto;
		/**
		* 规模
		*/

		@ColumnInfo(comment="规模",type="varchar(200)")
		private String qiyeGuimo;
		/**
		* 企业成立时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="企业成立时间",type="timestamp")
		private Date qiyeChenglishijianTime;
		/**
		* 企业介绍
		*/

		@ColumnInfo(comment="企业介绍",type="text")
		private String qiyeContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer qiyeDelete;
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



	public ZhaopinChatView() {

	}

	public ZhaopinChatView(ZhaopinChatEntity zhaopinChatEntity) {
		try {
			BeanUtils.copyProperties(this, zhaopinChatEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 状态的值
	*/
	public String getZhuangtaiValue() {
		return zhuangtaiValue;
	}
	/**
	* 设置： 状态的值
	*/
	public void setZhuangtaiValue(String zhuangtaiValue) {
		this.zhuangtaiValue = zhuangtaiValue;
	}
	//当前表的
	/**
	* 获取： 数据类型的值
	*/
	public String getZhaopinChatValue() {
		return zhaopinChatValue;
	}
	/**
	* 设置： 数据类型的值
	*/
	public void setZhaopinChatValue(String zhaopinChatValue) {
		this.zhaopinChatValue = zhaopinChatValue;
	}


	//级联表的get和set 企业

		/**
		* 获取： 企业名称
		*/
		public String getQiyeName() {
			return qiyeName;
		}
		/**
		* 设置： 企业名称
		*/
		public void setQiyeName(String qiyeName) {
			this.qiyeName = qiyeName;
		}
		/**
		* 获取： 企业类型
		*/
		public Integer getQiyeTypes() {
			return qiyeTypes;
		}
		/**
		* 设置： 企业类型
		*/
		public void setQiyeTypes(Integer qiyeTypes) {
			this.qiyeTypes = qiyeTypes;
		}


			/**
			* 获取： 企业类型的值
			*/
			public String getQiyeValue() {
				return qiyeValue;
			}
			/**
			* 设置： 企业类型的值
			*/
			public void setQiyeValue(String qiyeValue) {
				this.qiyeValue = qiyeValue;
			}

		/**
		* 获取： 联系方式
		*/
		public String getQiyePhone() {
			return qiyePhone;
		}
		/**
		* 设置： 联系方式
		*/
		public void setQiyePhone(String qiyePhone) {
			this.qiyePhone = qiyePhone;
		}

		/**
		* 获取： 邮箱
		*/
		public String getQiyeEmail() {
			return qiyeEmail;
		}
		/**
		* 设置： 邮箱
		*/
		public void setQiyeEmail(String qiyeEmail) {
			this.qiyeEmail = qiyeEmail;
		}

		/**
		* 获取： 企业logo
		*/
		public String getQiyePhoto() {
			return qiyePhoto;
		}
		/**
		* 设置： 企业logo
		*/
		public void setQiyePhoto(String qiyePhoto) {
			this.qiyePhoto = qiyePhoto;
		}

		/**
		* 获取： 规模
		*/
		public String getQiyeGuimo() {
			return qiyeGuimo;
		}
		/**
		* 设置： 规模
		*/
		public void setQiyeGuimo(String qiyeGuimo) {
			this.qiyeGuimo = qiyeGuimo;
		}

		/**
		* 获取： 企业成立时间
		*/
		public Date getQiyeChenglishijianTime() {
			return qiyeChenglishijianTime;
		}
		/**
		* 设置： 企业成立时间
		*/
		public void setQiyeChenglishijianTime(Date qiyeChenglishijianTime) {
			this.qiyeChenglishijianTime = qiyeChenglishijianTime;
		}

		/**
		* 获取： 企业介绍
		*/
		public String getQiyeContent() {
			return qiyeContent;
		}
		/**
		* 设置： 企业介绍
		*/
		public void setQiyeContent(String qiyeContent) {
			this.qiyeContent = qiyeContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getQiyeDelete() {
			return qiyeDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setQiyeDelete(Integer qiyeDelete) {
			this.qiyeDelete = qiyeDelete;
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


	@Override
	public String toString() {
		return "ZhaopinChatView{" +
			", zhuangtaiValue=" + zhuangtaiValue +
			", zhaopinChatValue=" + zhaopinChatValue +
			", yonghuName=" + yonghuName +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuEmail=" + yonghuEmail +
			", qiyeName=" + qiyeName +
			", qiyePhone=" + qiyePhone +
			", qiyeEmail=" + qiyeEmail +
			", qiyePhoto=" + qiyePhoto +
			", qiyeGuimo=" + qiyeGuimo +
			", qiyeChenglishijianTime=" + DateUtil.convertString(qiyeChenglishijianTime,"yyyy-MM-dd") +
			", qiyeContent=" + qiyeContent +
			", qiyeDelete=" + qiyeDelete +
			"} " + super.toString();
	}
}
