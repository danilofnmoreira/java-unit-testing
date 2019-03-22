package br.com.marimbondo;

import static java.time.LocalDate.of;
import static java.time.LocalTime.now;
import static java.time.Month.APRIL;
import static java.time.Month.DECEMBER;
import static java.time.Month.JULY;
import static java.time.Month.NOVEMBER;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Shop {

	private Double money;

	public static Map<Product, Integer> estoque;

	static {
		estoque = new Shop().encherEstoque();
	}

	public List<Product> buyProducts(List<Product> productsToBuy, final Double money) {

		this.money = money;

		return productsToBuy.stream().sorted((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice())).filter(p -> {
			Integer currentAmount = estoque.get(p);
			Integer newAmount = estoque.computeIfPresent(p, (k, v) -> {
				if (this.money > k.getPrice()) {
					this.money = this.money - k.getPrice();
					return v - 1;
				} else {
					return v;
				}
			});
			if (currentAmount == newAmount) {
				return false;
			} else {
				return true;
			}
		}).collect(Collectors.toList());
	}

	public Product hasTheProduct(String name) {
		Product key = new Product(name);
		Integer value = estoque.get(key);
		if (value != null && value > 0) {
			return estoque.keySet().stream().filter(k -> k.equals(key)).findFirst().get();
		} else {
			return null;
		}
	}

	public Map<Product, Integer> encherEstoque() {
		Map<Product, Integer> estoqueCheio = new HashMap<Product, Integer>();
		estoqueCheio.put(new Product("Macarrao", of(2019, APRIL, 21), 33.0), 10);
		estoqueCheio.put(new Product("Cebola", of(2019, DECEMBER, 20), 50.0), 5);
		estoqueCheio.put(new Product("Celular", of(2019, JULY, 10), 11.0), 3);
		estoqueCheio.put(new Product("Mouse", of(2019, NOVEMBER, 18), 42.0), 20);
		estoqueCheio.put(new Product("Arroz", of(2019, DECEMBER, 14), 20.0), 8);
		return estoqueCheio;
	}

	public boolean isOpen() {
		LocalTime now = now();
		return now.compareTo(LocalTime.of(9, 0)) > 0 && now.compareTo(LocalTime.of(18, 0)) < 0;
	}

	public boolean isClose() {
		LocalTime now = now();
		return now.compareTo(LocalTime.of(9, 0)) < 0 || now.compareTo(LocalTime.of(18, 0)) > 0;
	}

}
