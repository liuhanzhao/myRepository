package cn.tedu.store.entity;

public class Address extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1075644529438604795L;
	private Integer id;
	private Integer uid;
	private String recvName;
	private String recvProvince;
	private String recvCity;
	private String recvArea;
	private String recvDistrict;
	private String recvAddress;
	private String recvPhone;
	private String recvTel;
	private String recvZip;
	private String recvTag;
	private Integer isDefault;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getId() {
		return id;
	}
	public Integer getUid() {
		return uid;
	}
	public String getRecvName() {
		return recvName;
	}
	public String getRecvProvince() {
		return recvProvince;
	}
	public String getRecvCity() {
		return recvCity;
	}
	public String getRecvArea() {
		return recvArea;
	}
	public String getRecvDistrict() {
		return recvDistrict;
	}
	public String getRecvAddress() {
		return recvAddress;
	}
	public String getRecvPhone() {
		return recvPhone;
	}
	public String getRecvTel() {
		return recvTel;
	}
	public String getRecvZip() {
		return recvZip;
	}
	public String getRecvTag() {
		return recvTag;
	}
	public Integer getIsDefault() {
		return isDefault;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public void setRecvName(String recvName) {
		this.recvName = recvName;
	}
	public void setRecvProvince(String recvProvince) {
		this.recvProvince = recvProvince;
	}
	public void setRecvCity(String recvCity) {
		this.recvCity = recvCity;
	}
	public void setRecvArea(String recvArea) {
		this.recvArea = recvArea;
	}
	public void setRecvDistrict(String recvDistrict) {
		this.recvDistrict = recvDistrict;
	}
	public void setRecvAddress(String recvAddress) {
		this.recvAddress = recvAddress;
	}
	public void setRecvPhone(String recvPhone) {
		this.recvPhone = recvPhone;
	}
	public void setRecvTel(String recvTel) {
		this.recvTel = recvTel;
	}
	public void setRecvZip(String recvZip) {
		this.recvZip = recvZip;
	}
	public void setRecvTag(String recvTag) {
		this.recvTag = recvTag;
	}
	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", uid=" + uid + ", recvName=" + recvName + ", recvProvince=" + recvProvince
				+ ", recvCity=" + recvCity + ", recvArea=" + recvArea + ", recvDistrict=" + recvDistrict
				+ ", recvAddress=" + recvAddress + ", recvPhone=" + recvPhone + ", recvTel=" + recvTel + ", recvZip="
				+ recvZip + ", recvTag=" + recvTag + ", isDefault=" + isDefault + "]";
	}
	
}
