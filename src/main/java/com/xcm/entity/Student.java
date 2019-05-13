package com.xcm.entity;

public class Student {
private Integer student_Id;//编号
private String student_Name;//姓名
private String student_Sex;//性别
private String student_Birthday;//出生日期
private String student_Source;//学员来源
private String student_IdentityNumber;//身份证号
private String student_Email;//电子邮件
private String student_Qq;//qq
private String student_Tel;//电话
private String student_Address;//地区
private Integer student_Creator;//跟进人
private String student_CreateTime;//入学时间
private String student_UpdateTime;//更新时间
private String student_Remarks;//备注
private Integer student_ClassId;//班级Id
private Integer student_Status;//缴费状态(默认为0,0:未缴费,1:已缴费)
private Double student_Amount;//缴费金额
private Integer student_Exit1;//预留1
private String student_Exit2;//预留2
public Integer getStudent_Id() {
	return student_Id;
}
public void setStudent_Id(Integer student_Id) {
	this.student_Id = student_Id;
}
public String getStudent_Name() {
	return student_Name;
}
public void setStudent_Name(String student_Name) {
	this.student_Name = student_Name;
}
public String getStudent_Sex() {
	return student_Sex;
}
public void setStudent_Sex(String student_Sex) {
	this.student_Sex = student_Sex;
}
public String getStudent_Birthday() {
	return student_Birthday;
}
public void setStudent_Birthday(String student_Birthday) {
	this.student_Birthday = student_Birthday;
}
public String getStudent_Source() {
	return student_Source;
}
public void setStudent_Source(String student_Source) {
	this.student_Source = student_Source;
}
public String getStudent_IdentityNumber() {
	return student_IdentityNumber;
}
public void setStudent_IdentityNumber(String student_IdentityNumber) {
	this.student_IdentityNumber = student_IdentityNumber;
}
public String getStudent_Email() {
	return student_Email;
}
public void setStudent_Email(String student_Email) {
	this.student_Email = student_Email;
}
public String getStudent_Qq() {
	return student_Qq;
}
public void setStudent_Qq(String student_Qq) {
	this.student_Qq = student_Qq;
}
public String getStudent_Tel() {
	return student_Tel;
}
public void setStudent_Tel(String student_Tel) {
	this.student_Tel = student_Tel;
}
public String getStudent_Address() {
	return student_Address;
}
public void setStudent_Address(String student_Address) {
	this.student_Address = student_Address;
}
public Integer getStudent_Creator() {
	return student_Creator;
}
public void setStudent_Creator(Integer student_Creator) {
	this.student_Creator = student_Creator;
}
public String getStudent_CreateTime() {
	return student_CreateTime;
}
public void setStudent_CreateTime(String student_CreateTime) {
	this.student_CreateTime = student_CreateTime;
}
public String getStudent_UpdateTime() {
	return student_UpdateTime;
}
public void setStudent_UpdateTime(String student_UpdateTime) {
	this.student_UpdateTime = student_UpdateTime;
}
public String getStudent_Remarks() {
	return student_Remarks;
}
public void setStudent_Remarks(String student_Remarks) {
	this.student_Remarks = student_Remarks;
}
public Integer getStudent_ClassId() {
	return student_ClassId;
}
public void setStudent_ClassId(Integer student_ClassId) {
	this.student_ClassId = student_ClassId;
}
public Integer getStudent_Status() {
	return student_Status;
}
public void setStudent_Status(Integer student_Status) {
	this.student_Status = student_Status;
}
public Double getStudent_Amount() {
	return student_Amount;
}
public void setStudent_Amount(Double student_Amount) {
	this.student_Amount = student_Amount;
}
public Integer getStudent_Exit1() {
	return student_Exit1;
}
public void setStudent_Exit1(Integer student_Exit1) {
	this.student_Exit1 = student_Exit1;
}
public String getStudent_Exit2() {
	return student_Exit2;
}
public void setStudent_Exit2(String student_Exit2) {
	this.student_Exit2 = student_Exit2;
}
public Student(Integer student_Id, String student_Name, String student_Sex, String student_Birthday,
		String student_Source, String student_IdentityNumber, String student_Email, String student_Qq,
		String student_Tel, String student_Address, Integer student_Creator, String student_CreateTime,
		String student_UpdateTime, String student_Remarks, Integer student_ClassId, Integer student_Status,
		Double student_Amount, Integer student_Exit1, String student_Exit2) {
	super();
	this.student_Id = student_Id;
	this.student_Name = student_Name;
	this.student_Sex = student_Sex;
	this.student_Birthday = student_Birthday;
	this.student_Source = student_Source;
	this.student_IdentityNumber = student_IdentityNumber;
	this.student_Email = student_Email;
	this.student_Qq = student_Qq;
	this.student_Tel = student_Tel;
	this.student_Address = student_Address;
	this.student_Creator = student_Creator;
	this.student_CreateTime = student_CreateTime;
	this.student_UpdateTime = student_UpdateTime;
	this.student_Remarks = student_Remarks;
	this.student_ClassId = student_ClassId;
	this.student_Status = student_Status;
	this.student_Amount = student_Amount;
	this.student_Exit1 = student_Exit1;
	this.student_Exit2 = student_Exit2;
}
public Student() {
	super();
}
@Override
public String toString() {
	return "Student [student_Id=" + student_Id + ", student_Name=" + student_Name + ", student_Sex=" + student_Sex
			+ ", student_Birthday=" + student_Birthday + ", student_Source=" + student_Source
			+ ", student_IdentityNumber=" + student_IdentityNumber + ", student_Email=" + student_Email
			+ ", student_Qq=" + student_Qq + ", student_Tel=" + student_Tel + ", student_Address=" + student_Address
			+ ", student_Creator=" + student_Creator + ", student_CreateTime=" + student_CreateTime
			+ ", student_UpdateTime=" + student_UpdateTime + ", student_Remarks=" + student_Remarks
			+ ", student_ClassId=" + student_ClassId + ", student_Status=" + student_Status + ", student_Amount="
			+ student_Amount + ", student_Exit1=" + student_Exit1 + ", student_Exit2=" + student_Exit2 + "]";
}

}
