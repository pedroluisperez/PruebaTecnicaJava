package fruitshop.invoice.dto;

import fruitshop.util.FruitEnum;

public class FruitAmountDTO {

	private FruitEnum fruit;

	private int amount;

	public FruitEnum getFruit() {
		return fruit;
	}

	public void setFruit(FruitEnum fruit) {
		this.fruit = fruit;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
