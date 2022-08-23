package dev.starhound.piecemeal.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="items")
public class Item {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	// instacart id? maybe??

	@ManyToOne(fetch=FetchType.LAZY)
	private GroupOrder order;
	
	@NotEmpty
	private String name;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;
	

	// amount needed
	@NotNull
	private String units;
	private Float amount;
	
	@NotNull
	private Double price;
	
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	// constructors
	public Item() {}
	public Item(GroupOrder order, String name, User user) {
		this.order = order;
		this.name = name;
		this.user = user;
	}
	
}
