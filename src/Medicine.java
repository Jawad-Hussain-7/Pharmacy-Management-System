/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



public class Medicine {
    private int id;
    private String name;
    private int price;
    private String company;
    private int quantity;
    private String type;
    
    public Medicine()
    {
        id=0;
        name=" ";
        price=0;
        company=" ";
        quantity=0;
        type=" ";
    }

    public Medicine(String name, int price, String company, int quantity, String type) {
        this.name = name;
        this.price = price;
        this.company = company;
        this.quantity = quantity;
        this.type = type;
    }
    
    public Medicine(int id, String name, int price, String company, int quantity, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.company = company;
        this.quantity = quantity;
        this.type = type;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public void calculatePrice()
    {
        price=price*quantity;
    }

    @Override
    public String toString() {
        return "Medicine{" + "id=" + id + ", name=" + name + ", price=" + price + ", company=" + company + ", quantity=" + quantity + ", type=" + type + '}';
    }
    
}
