package com.xcm.entity;

//分配表
public class Distribution {
	private Integer distribution_Id;// 分配表id
	private Integer distribution_UsersId;// 用户id(咨询师经理)
	private Integer distribution_Status;// 状态:默认为1,1:为不开启自动分配2:为开启自动分配
	private Integer distribution_Exit1;// 预留1
	private String distribution_Exit2;// 预留2
	private Users users;// 用户(咨询师经理对象信息)

	public Integer getDistribution_Id() {
		return distribution_Id;
	}

	public void setDistribution_Id(Integer distribution_Id) {
		this.distribution_Id = distribution_Id;
	}

	public Integer getDistribution_UsersId() {
		return distribution_UsersId;
	}

	public void setDistribution_UsersId(Integer distribution_UsersId) {
		this.distribution_UsersId = distribution_UsersId;
	}

	public Integer getDistribution_Status() {
		return distribution_Status;
	}

	public void setDistribution_Status(Integer distribution_Status) {
		this.distribution_Status = distribution_Status;
	}

	public Integer getDistribution_Exit1() {
		return distribution_Exit1;
	}

	public void setDistribution_Exit1(Integer distribution_Exit1) {
		this.distribution_Exit1 = distribution_Exit1;
	}

	public String getDistribution_Exit2() {
		return distribution_Exit2;
	}

	public void setDistribution_Exit2(String distribution_Exit2) {
		this.distribution_Exit2 = distribution_Exit2;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Distribution(Integer distribution_Id, Integer distribution_UsersId, Integer distribution_Status,
			Integer distribution_Exit1, String distribution_Exit2, Users users) {
		super();
		this.distribution_Id = distribution_Id;
		this.distribution_UsersId = distribution_UsersId;
		this.distribution_Status = distribution_Status;
		this.distribution_Exit1 = distribution_Exit1;
		this.distribution_Exit2 = distribution_Exit2;
		this.users = users;
	}

	public Distribution() {
		super();
	}

	@Override
	public String toString() {
		return "Distribution [distribution_Id=" + distribution_Id + ", distribution_UsersId=" + distribution_UsersId
				+ ", distribution_Status=" + distribution_Status + ", distribution_Exit1=" + distribution_Exit1
				+ ", distribution_Exit2=" + distribution_Exit2 + ", users=" + users + "]";
	}

}
