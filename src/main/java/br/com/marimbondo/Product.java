package br.com.marimbondo;

import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.NonNull;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {

	@Include
	@NonNull
	private String name;
	@NonNull
	private LocalDate expirationDate;
	@NonNull
	private Double price;

	public Product(@NonNull String name, @NonNull LocalDate expirationDate, @NonNull Double price) {
		super();
		this.name = name;
		this.expirationDate = expirationDate;
		this.price = price;
	}

	public Product(@NonNull String name) {
		super();
		this.name = name;
	}

}
