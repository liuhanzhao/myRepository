package cn.tedu.store.entity;

public class GoodsCategory extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8089005569632151554L;
    private String id;
    private String parentId;
    private String name;
    private Integer status;
    private Integer sortOrder;
    private Integer isParent;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getId() {
		return id;
	}
	public String getParentId() {
		return parentId;
	}
	public String getName() {
		return name;
	}
	public Integer getStatus() {
		return status;
	}
	public Integer getSortOrder() {
		return sortOrder;
	}
	public Integer getIsParent() {
		return isParent;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	public void setIsParent(Integer isParent) {
		this.isParent = isParent;
	}
	@Override
	public String toString() {
		return "GoodsCategory [id=" + id + ", parentId=" + parentId + ", name=" + name + ", status=" + status
				+ ", sortOrder=" + sortOrder + ", isParent=" + isParent + "]";
	}
    
}
