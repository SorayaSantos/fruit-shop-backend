package demo.md3.fruitshop.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "user")
public class User extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(name = "name")
	private String name;

	@NotNull
	@Column(name = "username")
	private String username;

	@NotNull
	@Column(name = "email")
	private String email;

	@NotNull
	@Column(name = "password")
	private String password;

	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Role> roles;

	@JoinTable(name = "user_basket_product", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "basket_product_id"))
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<BasketProduct> basketProducts;

	public User() {
	}

	public User(@NotNull String name, @NotNull String username, @NotNull String email, @NotNull String password,
			List<Role> roles, List<BasketProduct> basketProducts) {
		super(true);
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.basketProducts = basketProducts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		if (roles == null) {
			roles = new ArrayList<>();
		}
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void addRole(Role role) {
		this.roles.add(role);
	}

	public List<BasketProduct> getBasketProducts() {
		if (basketProducts == null) {
			basketProducts = new ArrayList<>();
		}
		return basketProducts;
	}

	public void setBasketProducts(List<BasketProduct> basketProducts) {
		this.basketProducts = basketProducts;
	}

}
