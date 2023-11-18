package com.tiger.designPatterns200.entity.component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.tiger.designPatterns200.model.component.CompositeComponent;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ComponentEntity implements CompositeComponent {
	
	@Id
	private Long id;

	protected transient List<CompositeComponent> children = new ArrayList<>();

	private BigDecimal price;

	private String name;

	private String url;
	

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public BigDecimal getPrice() {
		return price;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	@Override
	public BigDecimal getCombinedPrice() {
		BigDecimal fullPrice = this.getPrice();
		for (CompositeComponent c : children) {
			fullPrice = fullPrice.add(c.getCombinedPrice());
		}
		return fullPrice;
	}
	
	

	public void addCompositeComponent(CompositeComponent c) {

	}

}
