package fruitshop.invoice.offers;

import java.util.List;

import fruitshop.invoice.dto.AmountOfferDTO;
import fruitshop.invoice.dto.FruitAmountDTO;
import fruitshop.invoice.dto.FruitDiscountDTO;
import fruitshop.util.FruitEnum;

public class AmountOffers {

	private List<AmountOfferDTO> amountActiveOffers;

	public List<AmountOfferDTO> getAmountActiveOffers() {
		return amountActiveOffers;
	}

	public void setAmountActiveOffers(List<AmountOfferDTO> amountActiveOffers) {
		this.amountActiveOffers = amountActiveOffers;
	}

	public AmountOffers() {

		// Buy 3 Apples and pay 2.
		AmountOfferDTO appleOffer = new AmountOfferDTO();

		FruitAmountDTO originalAppleAmount = new FruitAmountDTO();
		originalAppleAmount.setFruit(FruitEnum.APPLE);
		originalAppleAmount.setAmount(3);
		appleOffer.setOriginalFruitAmount(originalAppleAmount);

		FruitDiscountDTO freeAppleAmount = new FruitDiscountDTO();
		originalAppleAmount.setFruit(FruitEnum.APPLE);
		originalAppleAmount.setAmount(1);
		appleOffer.setFreeFruitAmount(freeAppleAmount);

		amountActiveOffers.add(appleOffer);

		// Get a free Orange for every 2 Pears you buy.

		AmountOfferDTO pearOffer = new AmountOfferDTO();

		FruitAmountDTO originalPearAmount = new FruitAmountDTO();
		originalPearAmount.setFruit(FruitEnum.PEAR);
		originalPearAmount.setAmount(2);
		pearOffer.setOriginalFruitAmount(originalPearAmount);

		FruitDiscountDTO freeOrangeAmount = new FruitDiscountDTO();
		freeOrangeAmount.setFruit(FruitEnum.ORANGE);
		freeOrangeAmount.setAmount(1);
		pearOffer.setFreeFruitAmount(freeOrangeAmount);

		amountActiveOffers.add(pearOffer);

	}
}
