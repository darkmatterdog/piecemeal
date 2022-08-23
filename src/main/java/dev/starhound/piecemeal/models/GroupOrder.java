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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="group_orders")
public class GroupOrder {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	// TODO: change relationship to allow previous orders to be saved and allow "this house's/group's frequent items" functionality
	@OneToOne(fetch=FetchType.LAZY)
	private Group group;
	
	@OneToMany(mappedBy="order", fetch=FetchType.LAZY)
	private List<Item> orderItems;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date nextPickupDate;

	@OneToOne(targetEntity=User.class)
	private User nextPickupUser;
	
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	// TODO: checklist of who has ordered/is ordering this cycle
	// items need user(s) attached?
	
	
	public GroupOrder() {}
	public GroupOrder(Group group) {
		this.group = group;
	}
}
