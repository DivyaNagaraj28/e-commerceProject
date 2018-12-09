package code.pro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Category {

	@Id
	@GeneratedValue
	private int CategoryId;
	private String CategoryName;
	private String CategoryDescrip;
	
	
	public Category()
	{
		
	}

	public int getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	public String getCategoryDescrip() {
		return CategoryDescrip;
	}

	public void setCategoryDescrip(String categoryDescrip) {
		CategoryDescrip = categoryDescrip;
	}

	@Override
	public String toString() {
		return "Category [CategoryId=" + CategoryId + ", CategoryName=" + CategoryName + ", CategoryDescrip="
				+ CategoryDescrip + "]";
	}
	
	
}
