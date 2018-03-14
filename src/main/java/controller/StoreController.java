package controller;

import model.Product;
import repository.StoreRepository;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Ioana on 3/14/2018.
 */
public class StoreController {
    StoreRepository io;

    public StoreController(StoreRepository storeRepository){
        this.io = storeRepository;
    }

    public void readProducts(String f){
        try {
            io.readFile();
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void addProduct(Product p){
        try {

            io.addNewProduct(p);
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public ArrayList<Product> getProductsCategory(String cat){
        return io.getProductsCategory(cat);
    }

    public ArrayList<Product> stockSituationProduct(String pname){
        return io.stockSituationProduct(pname);
    }
    public ArrayList<Product> stockSituation(){
        return io.stockSituation();
    }

}
