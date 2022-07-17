package fruitshop.invoice.dto;

public class AmountOfferDTO {

	private FruitAmountDTO originalFruitAmount;

	private FruitDiscountDTO freeFruitAmount;

	private boolean appliedOffer;

	public FruitAmountDTO getOriginalFruitAmount() {
		return originalFruitAmount;
	}

	public void setOriginalFruitAmount(FruitAmountDTO originalFruitAmount) {
		this.originalFruitAmount = originalFruitAmount;
	}

	public FruitDiscountDTO getFreeFruitAmount() {
		return freeFruitAmount;
	}

	public void setFreeFruitAmount(FruitDiscountDTO freeFruitAmount) {
		this.freeFruitAmount = freeFruitAmount;
	}

	public boolean isAppliedOffer() {
		return appliedOffer;
	}

	public void setAppliedOffer(boolean appliedOffer) {
		this.appliedOffer = appliedOffer;
	}

}
