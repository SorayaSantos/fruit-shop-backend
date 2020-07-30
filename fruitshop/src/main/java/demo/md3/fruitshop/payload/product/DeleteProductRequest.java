package demo.md3.fruitshop.payload.product;

import javax.validation.constraints.NotNull;

public class DeleteProductRequest {

	@NotNull
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
