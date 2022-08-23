package dev.starhound.piecemeal.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="groups")
public class Group {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="A group name is required.")
	private String groupName;
	
	@OneToMany(mappedBy="group", fetch = FetchType.LAZY)
	private List<User> users;

	@OneToOne(targetEntity=User.class)
	private User groupAdmin;
	
	@OneToOne(fetch=FetchType.LAZY)
	private GroupOrder currentOrder;
	
	@OneToMany(targetEntity=GroupOrder.class)
	private List<GroupOrder> allOrders;
	
	@NotNull
	private Integer orderInterval; // in days
	
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    // constructors
    public Group() {}
    public Group(String groupName, User groupAdmin, Integer orderInterval) {
    	this.groupName = groupName;
    	this.groupAdmin = groupAdmin;
    	this.orderInterval = orderInterval;
    }
	
	// create/update methods
		@PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	        this.updatedAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
	    
	    // getters/setters
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getGroupName() {
			return groupName;
		}
		public void setGroupName(String groupName) {
			this.groupName = groupName;
		}
		public Date getUpdatedAt() {
			return updatedAt;
		}
		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}
		public Date getCreatedAt() {
			return createdAt;
		}
		public List<User> getUsers() {
			return users;
		}
		public GroupOrder getCurrentOrder() {
			return currentOrder;
		}
}
