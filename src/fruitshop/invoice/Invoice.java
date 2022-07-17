package fruitshop.invoice;

import java.util.ArrayList;
import java.util.List;

import fruitshop.invoice.dto.AmountOfferDTO;
import fruitshop.invoice.dto.FruitAmountDTO;
import fruitshop.invoice.dto.PriceOfferDTO;

public class Invoice {

	Double totalPrice = 0d;

	List<String> offersApplied;

	public void calculateTotalPriceWithoutOffers(List<FruitAmountDTO> purchasedFruit, List<AmountOfferDTO> amountActiveOffers, List<PriceOfferDTO> priceActiveOffers) {
		for (FruitAmountDTO fruitOrder : purchasedFruit) {
			this.totalPrice = this.totalPrice + (fruitOrder.getFruit().getPrice() * fruitOrder.getAmount());
		}

		applyOffers(purchasedFruit, amountActiveOffers, priceActiveOffers);
	}

	private void applyOffers(List<FruitAmountDTO> purchasedFruit, List<AmountOfferDTO> amountActiveOffers, List<PriceOfferDTO> priceActiveOffers) {

		List<FruitAmountDTO> freeFruits = new ArrayList<>();

		// Get a free fruit
		for (AmountOfferDTO amountOfferDTO : amountActiveOffers) {
			for (FruitAmountDTO fruitAmountDTO : purchasedFruit) {
				if (fruitAmountDTO.getFruit().equals(amountOfferDTO.getOriginalFruitAmount().getFruit())
						&& fruitAmountDTO.getAmount() > amountOfferDTO.getOriginalFruitAmount().getAmount()) {
					FruitAmountDTO freeFruit = new FruitAmountDTO();
					int discount = fruitAmountDTO.getAmount() / amountOfferDTO.getOriginalFruitAmount().getAmount();
					freeFruit.setAmount(discount);
					freeFruit.setFruit(amountOfferDTO.getFreeFruitAmount().getFruit());
					amountOfferDTO.setAppliedOffer(true);
				}
			}
		}

		for (FruitAmountDTO purchaseFruit : purchasedFruit) {
			for (FruitAmountDTO freeFruit : freeFruits) {
				if (purchaseFruit.getFruit().equals(freeFruit.getFruit())) {
					if (purchaseFruit.getAmount() < freeFruit.getAmount()) {
						this.totalPrice = this.totalPrice - (freeFruit.getFruit().getPrice() * freeFruit.getAmount());
					} else {
						this.totalPrice = this.totalPrice - (purchaseFruit.getFruit().getPrice() * purchaseFruit.getAmount());
					}
				}
			}

		}

		// deduct in the final invoice
		for (PriceOfferDTO priceActiveOffer : priceActiveOffers) {
			int numberOfDiscount = (int) (this.totalPrice / priceActiveOffer.getPrice());
			this.totalPrice = this.totalPrice - (numberOfDiscount * priceActiveOffer.getDiscount());
			priceActiveOffer.setAppliedOffer(true);
		}
	}

	public void printInvoice(List<FruitAmountDTO> purchasedFruit, List<AmountOfferDTO> amountActiveOffers, List<PriceOfferDTO> priceActiveOffers) {
		System.out.println("TotalPrice: " + this.totalPrice);

		for (FruitAmountDTO fruitAmountDTO : purchasedFruit) {
			System.out.println(fruitAmountDTO.getFruit().getName() + " " + fruitAmountDTO.getAmount());
		}

		for (AmountOfferDTO amountOfferDTO : amountActiveOffers) {
			if (amountOfferDTO.isAppliedOffer()) {
				System.out.println("For each " + amountOfferDTO.getOriginalFruitAmount().getAmount() + " " + amountOfferDTO.getOriginalFruitAmount().getFruit().getName()
						+ " you obtained " + amountOfferDTO.getFreeFruitAmount().getAmount() + " " + amountOfferDTO.getFreeFruitAmount().getFruit().getName());
			}
		}

		for (PriceOfferDTO priceActiveOffer : priceActiveOffers) {
			if (priceActiveOffer.isAppliedOffer()) {
				System.out.println(
						"For every " + priceActiveOffer.getPrice() + " € spent, we will deduct " + priceActiveOffer.getDiscount() + " euro from your final invoice.");
			}
		}

	}

}
