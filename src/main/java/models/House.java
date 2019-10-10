package models;

public class House {
	private int houseId;
	private String district;
	private String region;
	private String houseAddress;
	private int ownerId;
	
	public House(int houseId, String district, String region, String houseAddress, int ownerId) {
		super();
		this.houseId = houseId;
		this.district = district;
		this.region = region;
		this.houseAddress = houseAddress;
		this.ownerId = ownerId;
	}

	public House(String district, String region, String houseAddress, int ownerId) {
		super();
		this.district = district;
		this.region = region;
		this.houseAddress = houseAddress;
		this.ownerId = ownerId;
	}

	public House() {
		// TODO Auto-generated constructor stub
	}

	public int getHouseId() {
		return houseId;
	}

	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getHouseAddress() {
		return houseAddress;
	}

	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	
	
	
	
	
}
