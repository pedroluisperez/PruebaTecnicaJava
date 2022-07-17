package fruitshop.invoice.dto;

public class PriceOfferDTO {

	private Double price;

	private Double discount;

	private boolean appliedOffer;

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public boolean isAppliedOffer() {
		return appliedOffer;
	}

	public void setAppliedOffer(boolean appliedOffer) {
		this.appliedOffer = appliedOffer;
	}

}
