package demo.md3.fruitshop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "role")
public class Role extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(name = "name")
	private String name;

	public Role() {
	}

	public Role(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
