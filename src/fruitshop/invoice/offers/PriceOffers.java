package fruitshop.invoice.offers;

import java.util.List;

import fruitshop.invoice.dto.PriceOfferDTO;

public class PriceOffers {

	List<PriceOfferDTO> priceActiveOffers;

	public List<PriceOfferDTO> getPriceActiveOffers() {
		return priceActiveOffers;
	}

	public void setPriceActiveOffers(List<PriceOfferDTO> priceActiveOffers) {
		this.priceActiveOffers = priceActiveOffers;
	}

	public PriceOffers() {

		// For every 4 € spent on Pears, we will deduct one euro from your final invoice.
		PriceOfferDTO priceOffer = new PriceOfferDTO();
		priceOffer.setPrice(4d);
		priceOffer.setDiscount(1d);

		priceActiveOffers.add(priceOffer);

	}
}
