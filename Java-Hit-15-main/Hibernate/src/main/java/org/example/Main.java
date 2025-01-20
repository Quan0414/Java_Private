package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.example.entity.Category;
import org.example.entity.EntityManagerUtil;
import org.example.entity.Product;

import java.util.List;
import java.util.Scanner;


public class Main {
    static Scanner Ip = new Scanner(System.in);
    static EntityManager entityManager = EntityManagerUtil.getEntityManager();
    static CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    public static void main(String[] args) {
        while (true) {
            System.out.print("1.Create Category\n" +
                    "2.View All Categories\n" +
                    "3.Delete Category\n" +
                    "4.Update Category\n" +
                    "5.Insert Product\n" +
                    "6.View All Products\n" +
                    "Enter command: ");
            int choice = Ip.nextInt();
            if(choice == 1){
                Ip.nextLine();
                createCategory();
            }
            if(choice == 2){
                viewAllCategories();
            }
            if(choice == 3){
                Ip.nextLine();
                deleteCategory();
            }
            if(choice == 4){
                Ip.nextLine();
                update();
            }
            if(choice == 5){
                Ip.nextLine();
                insertProduct();
            }
            if(choice == 6){
                viewData(null);
                example();
            }
            if(choice == 0){
                return;
            }
        }
    }

    private static void update(){
        entityManager.getTransaction().begin();
        String id = Ip.nextLine();
        Category category = entityManager.find(Category.class, id);
        if(category != null){
            String newName = Ip.nextLine();
            category.setName(newName);
            entityManager.merge(category);
        }
        entityManager.getTransaction().commit();
    }

    private static void createCategory() {
        entityManager.getTransaction().begin();
        System.out.print("Enter the name of the category: ");
        String name = Ip.nextLine();
        System.out.print("Enter the description of the category: ");
        String description = Ip.nextLine();
        Category category = new Category(name, description);
        entityManager.persist(category);
        entityManager.getTransaction().commit();
    }

    private static void viewAllCategories() {
        TypedQuery<Category> query = entityManager.createQuery("SELECT c FROM Category c ", Category.class);
        List<Category> categories = query.getResultList();
        System.out.printf("%-50s%-30s%-20s", "Id" , "Name" , "Description");
        for (Category category : categories) {
            System.out.printf("%-50s%-30s%-20s", category.getId(), category.getName(), category.getDescription());
        }
    }

    private static void deleteCategory() {
        entityManager.getTransaction().begin();
        System.out.print("Enter the id of the category you want to delete: ");
        String id = Ip.nextLine();
        Category category = entityManager.find(Category.class, id);
        if(category != null){
            entityManager.remove(category);
        }
        entityManager.getTransaction().commit();
    }

    private static void insertProduct(){
        entityManager.getTransaction().begin();
        System.out.print("Enter the id of the category you want to insert: ");
        String categoryId = Ip.nextLine();
        Category category = entityManager.find(Category.class, categoryId);
        if(category != null){
            System.out.print("Name: ");
            String name = Ip.nextLine();
            System.out.print("Description: ");
            String description = Ip.nextLine();
            System.out.print("Price: ");
            double price = Ip.nextDouble();
            Product product = new Product(name, price, description, category);
            entityManager.persist(product);
        }
        entityManager.getTransaction().commit();
    }

    private static void viewData(String name){
        CriteriaQuery<Product> query= builder.createQuery(Product.class);
        Root<Product> root = query.from(Product.class);
        query.select(root);

        if(!name.isBlank()){
            query.where(builder.like(root.get("name"), builder.parameter(String.class, "name")));
        }

        TypedQuery<Product> typedQuery = entityManager.createQuery(query);
        if(!name.isBlank()){
            typedQuery.setParameter("name", "%" + name + "%");
        }
        List<Product> results = typedQuery.getResultList();
        for(Product product : results){
            System.out.println(product.getName() + " " + product.getDescription() + " " + product.getCategory().getName());
        }
    }

    private static void example(){
        TypedQuery<Category> categoryTypedQuery = entityManager.createQuery("SELECT c FROM Category c WHERE c.name LIKE CONCAT('%', :name , '%')", Category.class);
        categoryTypedQuery.setParameter("name", " ");
        List<Category> categories = categoryTypedQuery.getResultList();
        for (Category category : categories) {
            System.out.println(category.getName() + " " + category.getDescription());
        }
    }

}