
public class Member {
	//회원가입
	String id;
	String name;
	String password;
	int age;
	String phone;
	
	//로그인
	String pcNum;

	Member(String id, String name, String password, int age, String phone){
		this.id = id;
		this.name = name;
		this.password = password;
		this.age = age;
		this.phone = phone;
	}
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPcNum() {
		return pcNum;
	}
	public void setPcNum(String pcNum) {
		this.pcNum = pcNum;
	}
	Member(String id, String password, String pcNum){
		this.id = id;
		this.password = password;
		this.pcNum = pcNum;
	}//login 
	
}//end Member