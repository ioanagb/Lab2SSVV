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
public class TestIncremental {
    StoreRepository storeRepository;
    @Test
    public void testAddProduct() throws IOException {
        storeRepository = new StoreRepository("productsTest1.txt");
        Random random = new Random();
        int code = random.nextInt((10000 - 5000) + 1) + 5000;
        Product p = new Product(code,"dress","fashion",10);

        int initSize = storeRepository.getAllProducts().size();
        storeRepository.addNewProduct(p);
        assertEquals(initSize+1,storeRepository.getAllProducts().size());
    }

    @Test
    public void testAddProductAndListItFromCategory() throws IOException {
        storeRepository = new StoreRepository("productsTest1.txt");
        Random random = new Random();
        int code = random.nextInt((10000 - 5000) + 1) + 5000;
        Product p = new Product(code,"gun","hunting",10);

        storeRepository.addNewProduct(p);

        ArrayList<Product> products = storeRepository.getProductsCategory("hunting");
        assertEquals(1,products.size());
    }

    @Test
    public void testAddProductListItFromCategoryAndStockSituation() throws IOException {
        storeRepository = new StoreRepository("productsTest1.txt");
        Random random = new Random();
        int code = random.nextInt((10000 - 5000) + 1) + 5000;
        Product p = new Product(code,"doll","toys",10);

        storeRepository.addNewProduct(p);

        storeRepository.stockSituationProduct("doll");
        assertEquals(10,storeRepository.stockSituationProduct("doll").get(0).getQuantity());
    }
}
