package bean;

import java.sql.Date;

public class InquiryInfo {

	private int inquiryNo;
	private String name;
	private String number;
	private String email;
	private String selectmenu;
	private String text;
	private Date date;

	public InquiryInfo() {
		int inquiryNo = 0;
		String name = null;
		String number = null;
		String email = null;
		String selectmenu = null;
		String text = null;
		Date date = null;

	}

	public int getInquiryNo() {
		return inquiryNo;
	}

	public void setInquiryNo(int inquiryNo) {
		this.inquiryNo = inquiryNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSelectmenu() {
		return selectmenu;
	}

	public void setSelectmenu(String selectmenu) {
		this.selectmenu = selectmenu;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}