package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private int cartId;
	
	@Column(name = "total")
	private double total;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "animal_id_fk")
	private Animals animalId;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(double total, Animals animalId) {
		super();
		this.total = total;
		this.animalId = animalId;
	}

	public Cart(int cartId, double total, Animals animalId) {
		super();
		this.cartId = cartId;
		this.total = total;
		this.animalId = animalId;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", total=" + total + ", animalId=" + animalId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((animalId == null) ? 0 : animalId.hashCode());
		result = prime * result + cartId;
		long temp;
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (animalId == null) {
			if (other.animalId != null)
				return false;
		} else if (!animalId.equals(other.animalId))
			return false;
		if (cartId != other.cartId)
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		return true;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Animals getAnimalId() {
		return animalId;
	}

	public void setAnimalId(Animals animalId) {
		this.animalId = animalId;
	}
	
}
