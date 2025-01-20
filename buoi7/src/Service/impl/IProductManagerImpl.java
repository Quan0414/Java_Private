package Service.impl;

import Model.Product;
import Model.User;
import Service.IProductManager;

import java.util.ArrayList;

public class IProductManagerImpl implements IProductManager {
    private ArrayList<Product> products = new ArrayList<>();

    @Override
    public void displayProduct() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Override
    public boolean addProduct(User user) {

        return false;
    }
}
