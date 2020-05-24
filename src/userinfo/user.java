package userinfo;

public class user {
	private String address;
	private String qq;
	private String emial;
	private int age;
	private int id;
	private String name;
	private String gender;
	user(){
		
	}
	public user(int id,String name,String gender,int age,String address,String qq,String email){
		
		this.id=id;
		this.name=name;
		this.gender=gender;
		this.age=age;
		this.address=address;
		this.qq=qq;
		this.emial=email;	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getEmial() {
		return emial;
	}
	public void setEmial(String emial) {
		this.emial = emial;
	}
	

}
