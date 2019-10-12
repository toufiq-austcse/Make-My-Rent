package models;

public class Rent {
	private int rentId;
	private int houseId;
	private String noOfRooms;
	private String extras;
	private String rentPerMonth;
	private String advance;
	private String photos;
	private String featuredPhotos;
	private boolean ispublished;
	private String createdAt;
	private String updatedAt;
	
	public Rent(int rentId, int houseId, String noOfRooms, String extras, String rentPerMonth, String advance,
			String photos, String featuredPhotos, boolean ispublish) {
		super();
		this.rentId = rentId;
		this.houseId = houseId;
		this.noOfRooms = noOfRooms;
		this.extras = extras;
		this.rentPerMonth = rentPerMonth;
		this.advance = advance;
		this.photos = photos;
		this.featuredPhotos = featuredPhotos;
		this.ispublished = ispublish;
	}
	
	public Rent(int rentId, int houseId, String noOfRooms, String extras, String rentPerMonth, String advance,
			String photos, String featuredPhotos, boolean ispublished, String createdAt, String updatedAt) {
		super();
		this.rentId = rentId;
		this.houseId = houseId;
		this.noOfRooms = noOfRooms;
		this.extras = extras;
		this.rentPerMonth = rentPerMonth;
		this.advance = advance;
		this.photos = photos;
		this.featuredPhotos = featuredPhotos;
		this.ispublished = ispublished;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Rent(int houseId, String noOfRooms, String extras, String rentPerMonth, String advance,
			String photos, String featuredPhotos, boolean ispublish) {
		super();
		this.houseId = houseId;
		this.noOfRooms = noOfRooms;
		this.extras = extras;
		this.rentPerMonth = rentPerMonth;
		this.advance = advance;
		this.photos = photos;
		this.featuredPhotos = featuredPhotos;
		this.ispublished = ispublish;
	}
	public Rent() {
		// TODO Auto-generated constructor stub
	}

	public int getRentId() {
		return rentId;
	}
	public void setRentId(int rentId) {
		this.rentId = rentId;
	}
	public int getHouseId() {
		return houseId;
	}
	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}
	public String getNoOfRooms() {
		return noOfRooms;
	}
	public void setNoOfRooms(String noOfRooms) {
		this.noOfRooms = noOfRooms;
	}
	public String getExtras() {
		return extras;
	}
	public void setExtras(String extras) {
		this.extras = extras;
	}
	public String getRentPerMonth() {
		return rentPerMonth;
	}
	public void setRentPerMonth(String rentPerMonth) {
		this.rentPerMonth = rentPerMonth;
	}
	public String getAdvance() {
		return advance;
	}
	public void setAdvance(String advance) {
		this.advance = advance;
	}
	public String getPhotos() {
		return photos;
	}
	public void setPhotos(String photos) {
		this.photos = photos;
	}
	public String getFeaturedPhotos() {
		return featuredPhotos;
	}
	public void setFeaturedPhotos(String featuredPhotos) {
		this.featuredPhotos = featuredPhotos;
	}
	public boolean isIspublish() {
		return ispublished;
	}
	public void setIspublish(boolean ispublish) {
		this.ispublished = ispublish;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
	 

}
