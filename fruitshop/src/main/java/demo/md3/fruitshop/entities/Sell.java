package demo.md3.fruitshop.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sell")
public class Sell extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(name = "total")
	private BigDecimal total;

	public Sell() {
	}

	public Sell(@NotNull BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

}
