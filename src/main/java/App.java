import controller.StoreController;
import repository.StoreRepository;
import ui.StoreUI;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Ioana on 3/14/2018.
 */
public class App {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

//		Product p=new Product();
        //p.read();
        Scanner in = new Scanner(System.in);
        System.out.println("Name of the file: ");
        String fileName = "";
        fileName = in.nextLine();
        StoreRepository storeRepository = new StoreRepository(fileName);
        StoreController c=new StoreController(storeRepository);
        c.readProducts("products.txt");

        StoreUI u = new StoreUI(c);
        u.run();
        //c.addProduct(p);
        //	for(Product q:c.getProductsCategory("second")){
        //	System.out.println(q.toString());
        //}
//		for(Product q:c.stockSituationProduct("Laptop"))
//			System.out.println(q.toString());
//
    }
}
