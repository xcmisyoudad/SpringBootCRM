package com.xcm.entity;

public class Dynamic {
	private Integer dynamic_Id;//编号
	private String dynamic_Text;//动态信息内容
	private Integer dynamic_Creator;//动态信息创建人
	private Integer dynamic_Recipients;//动态信息接收人
	private String dynamic_CreateTime;//创建时间
	private Integer dynamic_Status;//状态（0.已发送，1.已接收）
	private Integer dynamic_Exit1;//预留字段1
	private Integer dynamic_Exit2;//预留字段2
	private Users users;
	
	public Dynamic(Integer dynamic_Id, String dynamic_Text, Integer dynamic_Creator, Integer dynamic_Recipients,
			String dynamic_CreateTime, Integer dynamic_Status, Integer dynamic_Exit1, Integer dynamic_Exit2,
			Users users) {
		super();
		this.dynamic_Id = dynamic_Id;
		this.dynamic_Text = dynamic_Text;
		this.dynamic_Creator = dynamic_Creator;
		this.dynamic_Recipients = dynamic_Recipients;
		this.dynamic_CreateTime = dynamic_CreateTime;
		this.dynamic_Status = dynamic_Status;
		this.dynamic_Exit1 = dynamic_Exit1;
		this.dynamic_Exit2 = dynamic_Exit2;
		this.users = users;
	}
	public Dynamic() {
		super();
	}
	public Integer getDynamic_Id() {
		return dynamic_Id;
	}
	public void setDynamic_Id(Integer dynamic_Id) {
		this.dynamic_Id = dynamic_Id;
	}
	public String getDynamic_Text() {
		return dynamic_Text;
	}
	public void setDynamic_Text(String dynamic_Text) {
		this.dynamic_Text = dynamic_Text;
	}
	public Integer getDynamic_Creator() {
		return dynamic_Creator;
	}
	public void setDynamic_Creator(Integer dynamic_Creator) {
		this.dynamic_Creator = dynamic_Creator;
	}
	public Integer getDynamic_Recipients() {
		return dynamic_Recipients;
	}
	public void setDynamic_Recipients(Integer dynamic_Recipients) {
		this.dynamic_Recipients = dynamic_Recipients;
	}
	public String getDynamic_CreateTime() {
		return dynamic_CreateTime;
	}
	public void setDynamic_CreateTime(String dynamic_CreateTime) {
		this.dynamic_CreateTime = dynamic_CreateTime;
	}
	public Integer getDynamic_Exit1() {
		return dynamic_Exit1;
	}
	public void setDynamic_Exit1(Integer dynamic_Exit1) {
		this.dynamic_Exit1 = dynamic_Exit1;
	}
	public Integer getDynamic_Exit2() {
		return dynamic_Exit2;
	}
	public void setDynamic_Exit2(Integer dynamic_Exit2) {
		this.dynamic_Exit2 = dynamic_Exit2;
	}
	
	public Integer getDynamic_Status() {
		return dynamic_Status;
	}
	public void setDynamic_Status(Integer dynamic_Status) {
		this.dynamic_Status = dynamic_Status;
	}
	
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "Dynamic [dynamic_Id=" + dynamic_Id + ", dynamic_Text=" + dynamic_Text + ", dynamic_Creator="
				+ dynamic_Creator + ", dynamic_Recipients=" + dynamic_Recipients + ", dynamic_CreateTime="
				+ dynamic_CreateTime + ", dynamic_Status=" + dynamic_Status + ", dynamic_Exit1=" + dynamic_Exit1
				+ ", dynamic_Exit2=" + dynamic_Exit2 + ", users=" + users + "]";
	}

}
