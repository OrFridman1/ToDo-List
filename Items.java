package il.hit.model;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * This class represent the item object of the user.
 * Each member of the class is matches to a column in the items table in the database.
 */
@Entity
@Table(name="Items")
public class Items {
	
	@Id @GeneratedValue
	@Column(name = "id")
	private long id;
	@Column(name = "itemName")
	private String itemName;
	@Column(name = "userName")
	private String userName;
	@Column(name = "status")
	private String status;
	@Column(name = "priority")
	private String priority;
	@Column(name = "dueDate")
	private Date dueDate;
	@Column(name = "note")
	private String note;

	public Items()
	{}

	
	public Items(String userName,String status,String priority, Date dueDate, String note)
	{
		this.userName=userName;
		this.status=status;
		this.priority=priority;
		this.dueDate=dueDate;
		this.note=note;
	}

	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public long getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Items [id=" + id + ", itemName=" + itemName + ", userName=" + userName + ", status=" + status
				+ ", priority=" + priority + ", dueDate=" + dueDate + ", note=" + note + "]";
	}
	
	
}
