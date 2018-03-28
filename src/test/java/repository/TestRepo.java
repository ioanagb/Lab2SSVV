package repository;

import controller.StoreController;
import junit.framework.TestCase;
import model.Product;
import org.junit.Test;
import repository.StoreRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ioana on 3/14/2018.
 */
public class TestRepo extends TestCase{
    private StoreRepository storeRepository;
    int size;
    //private StoreController storeController;

    //code, name, category, quantity

    @Test
    public void testAddValid() throws IOException {
        storeRepository = new StoreRepository("productsTest.txt");

        ArrayList<Product> products = storeRepository.getAllProducts();
        size = products.size();
        Random random = new Random();
        int code = random.nextInt((10000 - 5000) + 1) + 5000;
        Product p = new Product(code,"p","c",1);
        storeRepository.addNewProduct(p);

        products = storeRepository.getAllProducts();
        size ++;
        assertEquals(size,products.size());
    }

    @Test
    public void testAddCodeNegative() throws IOException {
        storeRepository = new StoreRepository("productsTest.txt");

        ArrayList<Product> products = storeRepository.getAllProducts();
        size = products.size();
        //assertEquals(5,products.size());
        Product p = new Product(-1,"p","c",1);
        storeRepository.addNewProduct(p);

        products = storeRepository.getAllProducts();
        assertEquals(size,products.size());
    }

    @Test
    public void testAddCode0() throws IOException {
        storeRepository = new StoreRepository("productsTest.txt");

        ArrayList<Product> products = storeRepository.getAllProducts();
        size = products.size();
        //assertEquals(5,products.size());
        Product p = new Product(0,"p","c",1);
        storeRepository.addNewProduct(p);

        products = storeRepository.getAllProducts();
        assertEquals(size,products.size());
    }

    @Test
    public void testAddCodeExists() throws IOException {
        storeRepository = new StoreRepository("productsTest.txt");

        ArrayList<Product> products = storeRepository.getAllProducts();
        size = products.size();
        //assertEquals(5,products.size());
        Product p = new Product(44,"p","c",1);
        storeRepository.addNewProduct(p);

        products = storeRepository.getAllProducts();
        assertEquals(size,products.size());
    }

    @Test
    public void testAddInvalidQuantity() throws IOException {
        storeRepository = new StoreRepository("productsTest.txt");

        ArrayList<Product> products = storeRepository.getAllProducts();
        size = products.size();
        Product p = new Product(2999,"p","c",-2);
        storeRepository.addNewProduct(p);

        products = storeRepository.getAllProducts();
        assertEquals(size,products.size());
    }

    @Test
    public void testAddInvalidName() throws IOException {
        storeRepository = new StoreRepository("productsTest.txt");

        ArrayList<Product> products = storeRepository.getAllProducts();
        size = products.size();
        Product p = new Product(2999,"*","c",2);
        storeRepository.addNewProduct(p);

        products = storeRepository.getAllProducts();
        assertEquals(size,products.size());
    }

    @Test
    public void testAddInvalidCategory() throws IOException {
        storeRepository = new StoreRepository("productsTest.txt");

        ArrayList<Product> products = storeRepository.getAllProducts();
        size = products.size();
        Product p = new Product(2999,"p","*",2);
        storeRepository.addNewProduct(p);

        products = storeRepository.getAllProducts();
        assertEquals(size,products.size());
    }

    @Test
    public void testAddInvalid() throws IOException {
        storeRepository = new StoreRepository("productsTest.txt");

        ArrayList<Product> products = storeRepository.getAllProducts();
        size = products.size();
        Product p = new Product(-1,"*","c",-1);
        storeRepository.addNewProduct(p);

        products = storeRepository.getAllProducts();
        assertEquals(size,products.size());
    }

    @Test
    public void testGetAll(){
        storeRepository = new StoreRepository("productsTest1.txt");
        ArrayList<Product> products = storeRepository.getAllProducts();
        assertEquals(5,products.size());
    }

    @Test
    public void testStockSituationProductCategory(){
        storeRepository = new StoreRepository("productsTest.txt");
        ArrayList<Product> products = storeRepository.getProductsCategory("aliment");
        assertEquals(3,products.size());
    }

    @Test
    public void testGetByCategory(){
        storeRepository = new StoreRepository("productsTest.txt");
        ArrayList<Product> products = storeRepository.getProductsCategory("category");
        assertEquals(0,products.size());
    }
}
