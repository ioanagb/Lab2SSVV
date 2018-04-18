package repository;

import model.Product;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Ioana on 4/18/2018.
 */
public class TestIntegration {
    private StoreRepository storeRepository;
    @Test
    public void testGetStockSituation(){
        storeRepository = new StoreRepository("productsTest.txt");

        ArrayList<Product> products = storeRepository.stockSituationProduct("lapte");
        assertEquals(144,products.get(0).getQuantity());
    }

    @Test
    public void testIntegration() throws IOException {
        storeRepository = new StoreRepository("productsTest.txt");
        Random random = new Random();
        int code = random.nextInt((10000 - 5000) + 1) + 5000;
        Product p = new Product(code,"bread","food",10);

        storeRepository.addNewProduct(p);
        ArrayList<Product> productsCat = storeRepository.getProductsCategory("food");
        int stock = storeRepository.stockSituation().get(0).getQuantity();

        assertEquals(10,stock);
    }

}
