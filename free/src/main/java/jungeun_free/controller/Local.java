package jungeun_free.controller;

public class Local {

	private String[] localList = {"강원도", "거제도", "남해", "여수", 
			"울릉도", "제주도", "부산", "통영", "포항",
	};
			
	
	public String[] getLocalList() {
		return localList;

	}
	private String point;
	private String name;
	
	public Local(String point,String name) {
		this.setPoint(point);
		this.name=name;
	}
	
	public Local() {
		setPoint("포인트");
		name="디폴트";
	}
	
	public String getName() {
		return name;
		
	}
	public void setName(String name) {
		this.name=name;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}
	

}
