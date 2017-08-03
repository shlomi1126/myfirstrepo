package model;

public class client {
private String f_name;
private String l_name;
private int client_id;
private String mail_client;
private long phone_client;
public String getF_name() {
	return f_name;
}
public void setF_name(String f_name) {
	this.f_name = f_name;
}
public String getL_name() {
	return l_name;
}
public void setL_name(String l_name) {
	this.l_name = l_name;
}
public int getClient_id() {
	return client_id;
}
public void setClient_id(int client_id) {
	this.client_id = client_id;
}
public String getMail_client() {
	return mail_client;
}
public void setMail_client(String mail_client) {
	this.mail_client = mail_client;
}
public long getPhone_client() {
	return phone_client;
}
public void setPhone_client(long phone_client) {
	this.phone_client = phone_client;
}
}