package repository;

import controller.StoreController;
import junit.framework.TestCase;
import model.Product;
import org.junit.Test;
import repository.StoreRepository;

import java.util.ArrayList;

/**
 * Created by Ioana on 3/14/2018.
 */
public class TestRepo extends TestCase{
    private StoreRepository storeRepository;
    private StoreController storeController;

    @Test
    public void testGetAll(){
        storeRepository = new StoreRepository("products.txt");
        //storeController = new StoreController(storeRepository);

        ArrayList<Product> products = storeRepository.getAllProducts();
        assertEquals(5,products.size());

    }

    @Test
    public void testStockSituationProductCategory(){
        storeRepository = new StoreRepository("products.txt");

        ArrayList<Product> products = storeRepository.getProductsCategory("aliment");
        assertEquals(3,products.size());

    }

}
