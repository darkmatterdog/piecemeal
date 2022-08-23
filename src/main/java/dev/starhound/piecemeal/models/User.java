package dev.starhound.piecemeal.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

// import javax.persistence.Entity;

@Entity
@Table(name="users")
public class User {
	
	// database parameters
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="An email is required.")
    @Email(message="Please enter a valid email.")
    private String email;
	
	@NotEmpty(message="A house name is required.")
    @Size(min=3, max=30, message="House name must be between 2 and 30 characters.")
    private String houseName;
	
	@NotEmpty(message="A password is required.")
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters.")
    private String password;
	
	@Transient
    @NotEmpty(message="Confirming your password is required.")
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters.")
    private String confirm;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private Group group;
	
	@OneToOne(fetch=FetchType.LAZY)
	private GroupOrder groupOrder;
	    
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private List<Item> items;
    
	// constructors
	public User() {}
	public User(String houseName, String email, String password) {
		this.houseName = houseName;
		this.email = email;
		this.password = password;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
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
}