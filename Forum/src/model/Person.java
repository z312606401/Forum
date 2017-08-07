package model;

import java.util.Date;

public class Person {
	private Integer id;

	private Date datecreated;

	private Boolean deleted;

	private Integer version;

	private String account;

	private String birthday;

	private Date datelastactived;

	private String email;

	private String ipcreated;

	private String iplastactived;

	private String name;

	private String password;

	private String sex;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDatecreated() {
		return datecreated;
	}

	public void setDatecreated(Date datecreated) {
		this.datecreated = datecreated;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Date getDatelastactived() {
		return datelastactived;
	}

	public void setDatelastactived(Date datelastactived) {
		this.datelastactived = datelastactived;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIpcreated() {
		return ipcreated;
	}

	public void setIpcreated(String ipcreated) {
		this.ipcreated = ipcreated;
	}

	public String getIplastactived() {
		return iplastactived;
	}

	public void setIplastactived(String iplastactived) {
		this.iplastactived = iplastactived;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}