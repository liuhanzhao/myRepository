package cn.tedu.store.entity;

public class Goods extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3389887946313202625L;
	private String id;
	private String categoryId;
	private String itemType;
	private String title;
	private String sellPoint;
	private Long price;
	private Integer num;
	private String barcode;
	private String image;
	private Integer status;
	private Integer priority;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getId() {
		return id;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public String getItemType() {
		return itemType;
	}
	public String getTitle() {
		return title;
	}
	public String getSellPoint() {
		return sellPoint;
	}
	public Long getPrice() {
		return price;
	}
	public Integer getNum() {
		return num;
	}
	public String getBarcode() {
		return barcode;
	}
	public String getImage() {
		return image;
	}
	public Integer getStatus() {
		return status;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setSellPoint(String sellPoint) {
		this.sellPoint = sellPoint;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", categoryId=" + categoryId + ", itemType=" + itemType + ", title=" + title
				+ ", sellPoint=" + sellPoint + ", price=" + price + ", num=" + num + ", barcode=" + barcode + ", image="
				+ image + ", status=" + status + ", priority=" + priority + "]";
	}
	


}
