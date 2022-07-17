package fruitshop.util;

public enum FruitEnum {

	PEAR("Pear", 0.75),

	APPLE("Apple", 0.9),

	ORANGE("Orange", 1);

	private final Object[] values;

	FruitEnum(Object... vals) {
		values = vals;
	}

	public String getName() {
		return (String) values[0];
	}

	public Double getPrice() {
		return (Double) values[1];
	}
}
