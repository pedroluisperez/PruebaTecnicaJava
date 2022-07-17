package fruitshop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import fruitshop.invoice.Invoice;
import fruitshop.invoice.dto.AmountOfferDTO;
import fruitshop.invoice.dto.FruitAmountDTO;
import fruitshop.invoice.dto.PriceOfferDTO;
import fruitshop.invoice.offers.AmountOffers;
import fruitshop.invoice.offers.PriceOffers;

public class FruitShop {

	public static void main(String[] args) {

		List<FruitAmountDTO> purchasedFruit = null;
		try {
			purchasedFruit = convertFileToFruitAmountDTOList(args);
		} catch (Exception e) {
			e.printStackTrace();
		}

		AmountOffers amountOffers = new AmountOffers();
		List<AmountOfferDTO> amountActiveOffers = amountOffers.getAmountActiveOffers();

		PriceOffers priceOffers = new PriceOffers();
		List<PriceOfferDTO> priceActiveOffers = priceOffers.getPriceActiveOffers();

		Invoice invoice = new Invoice();
		invoice.calculateTotalPriceWithoutOffers(purchasedFruit, amountActiveOffers, priceActiveOffers);

		invoice.printInvoice(purchasedFruit, amountActiveOffers, priceActiveOffers);

	}

	private static List<FruitAmountDTO> convertFileToFruitAmountDTOList(String[] args) throws IOException {
		// TODO: Read the file and convert to List<FruitAmountDTO>, one element of the file into a FruitAmountDTO

		String cadena;
		FileReader f = new FileReader(args[0]);
		BufferedReader b = new BufferedReader(f);
		while ((cadena = b.readLine()) != null) {
			System.out.println(cadena);
		}
		b.close();

		return null;
	}

}
