/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.Customer;
import Model.Employee;
import Model.Order;
import Model.OrderDetails;
import Model.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author alkassoumhaoua
 */
public class Dbutils {
    
    //Class used to access utils methods relating to connection and database queries
    
    public final static String DB_URL ="jdbc:mysql://localhost:8889/projet"; 
    //public final static String DB_URL ="jdbc:mysql://localhost:3306/projet"; 
    private ArrayList<Product> products = new ArrayList<Product>();
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    private ArrayList<Employee> employees = new ArrayList<Employee>();
    private ArrayList<Order> orders = new ArrayList<Order>();
    private ArrayList<OrderDetails> orderDetails = new ArrayList<OrderDetails>();
    private final ProductDBQuery productdb=new ProductDBQuery();
    private final EmployeeDBQuery employeedb=new EmployeeDBQuery();
    private final CustomerDBQuery customerdb=new CustomerDBQuery();
    private final OrderDBQuery orderdb=new OrderDBQuery();
    private final OrderDetailsDBQuery orderdetailsdb=new OrderDetailsDBQuery();
    
    //We establish the connection
    public static Connection getDbConnection()throws SQLException
    {
       String user="root";
       String password="root"; 
       //String password=""; 
       return DriverManager.getConnection(DB_URL,user, password);
    }
     
    //We create the statement
    public static Statement createStatement() throws SQLException
    {
        Connection conn= Dbutils.getDbConnection();
        return conn.createStatement();
    }
    
    //Method which execute the query
    public static ResultSet executeQuery(String rq) throws SQLException
    {
       return createStatement().executeQuery(rq);
    }
    
    //Method which execute the update
    public static int executeUpdate(String rq) throws SQLException
    {
        return createStatement().executeUpdate(rq); 
    }
    
    //On récupère l'id max pour insérer a la suite
    //We get the max id to insert afterwards
    public static int max(String table,String iDtable) throws SQLException
    {
         ResultSet rst;
         String rq= "SELECT Max("+iDtable+") FROM "+table;
         rst=Dbutils.executeQuery(rq);
         rst.next();
         int orderId=rst.getInt(1);
         return orderId+1;
    }
    
    public static void createTables(){
        try{
            Statement statement = Dbutils.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS `customer` (" +"`customerId` int(11) NOT NULL," +
                                "`name` varchar(20) NOT NULL," + "`lastname` varchar(20) NOT NULL," + "`address` varchar(50) NOT NULL," +
                               "`city` varchar(50) NOT NULL," + "`email` varchar(50) NOT NULL," + "`username` varchar(30) NOT NULL," +
                               "`password` varchar(30) NOT NULL," + "PRIMARY KEY (`customerId`))");
            
            statement.execute("CREATE TABLE IF NOT EXISTS `employee` (" +"`employeeId` int(11) NOT NULL," +
                                "`name` varchar(20) NOT NULL," + "`lastname` varchar(20) NOT NULL," + 
                                "`username` varchar(30) NOT NULL," + "`password` varchar(30) NOT NULL," + "PRIMARY KEY (`employeeId`))");
            
            statement.execute("CREATE TABLE IF NOT EXISTS `order1` (" +"`orderId` int(11) NOT NULL," +
                                "`quantity` int(11) NOT NULL," + "`discount` double NOT NULL," + 
                                "`totalPrice` double NOT NULL," + "`date` date NOT NULL," + "`username` varchar(50) NOT NULL," 
                                + "PRIMARY KEY (`orderId`))");
            
            statement.execute("CREATE TABLE IF NOT EXISTS `orderdetails` (" +"`orderdetailsId` int(11) NOT NULL," +
                                "`orderId` int(11) NOT NULL," + "`productId` int(11) NOT NULL," + 
                                "`quantity` int(11) NOT NULL," + "`price` double NOT NULL," + "`discount` double NOT NULL," 
                                + "PRIMARY KEY (`orderdetailsId`))");
            
            statement.execute("CREATE TABLE IF NOT EXISTS `product` (" +"`productId` int(11) NOT NULL," +
                                "`name` varchar(30) NOT NULL," + "`price` double NOT NULL," + 
                                "`stock` int(11) NOT NULL," + "`discount` double NOT NULL," + "`quantitydiscount` int(11) NOT NULL," 
                                + "PRIMARY KEY (`productId`))");
            
        }catch(Exception e){
            System.out.println("ERROR SQL in creating the tables " + e.getMessage());
        }
    } 
    
    public static void resetDB(){
        try{
            Statement statement = Dbutils.createStatement();
            statement.execute("DROP TABLE IF EXISTS `customer`");
            
            statement.execute("DROP TABLE IF EXISTS `employee`");
            
            statement.execute("DROP TABLE IF EXISTS `order1`");
            
            statement.execute("DROP TABLE IF EXISTS `orderdetails`");
            
            statement.execute("DROP TABLE IF EXISTS `product`");
        }catch(Exception e){
            System.out.println("ERROR SQL in droping the table " + e.getMessage());
        }
    }
    
    public void initData(){
        Product produit1 = new Product(1,"Joystick Switch",4.95,100,45,10);
        Product produit2 = new Product(2,"USB controller Game pad", 5.5, 100,50,10);
        Product produit3 = new Product(3,"Bottle o Bubbles",0.99,100,0,0);
        Product produit4 = new Product(4,"Nintendo Wii System",399.99,100,0,0);
        Product produit5 = new Product(5,"Small X-box",65,100,0,0);
        Product produit6 = new Product(6,"Mario Wii",55.99,100,0,0);
        Product produit7 = new Product(7,"E-pen",4.5,100,0,0);
        Product produit8 = new Product(8,"Rubrik Cube",5,100,0,0);
        Product produit9 = new Product(9,"Java is amazing! Button",1.5,100,11,10);
        Product produit10 = new Product(10,"Java Java Java! Sticker",0.99,100,9,10);
        
        products.add(produit1);
        products.add(produit2);
        products.add(produit3);
        products.add(produit4);
        products.add(produit5);
        products.add(produit6);
        products.add(produit7);
        products.add(produit8);
        products.add(produit9);
        products.add(produit10);
        
        Employee employee1 = new Employee(1,"Haoua","Alkassoum","Haoua","azertyuiop");
        Employee employee2 = new Employee(2, "Maï-linh","Neff","ML","azertyuiop");
        Employee employee3 = new Employee(3, "Guillaume","Sanson","Guigzz","azertyuiop");
        
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        
        Customer customer1 = new Customer(1,"Haoua","Alkassoum","10 rue Voltaire","Paris","haoua.alkassoum@edu.ece.fr","Haoua","azertyuiop");
        Customer customer2 = new Customer(2,"Maï-linh","Neff","2 rue Rousseau","Courbevoie","mailinh.neff@edu.ece.fr","ML","azertyuiop");
        Customer customer3 = new Customer(3,"Guillaume","Sanson","1 rue des nouvelles","Suresnes","gsanson66@gmail.com","Guigzz","azertyuiop");
        Customer customer4 = new Customer(4,"Paul","Leviet","70 boulevard escudier","Lyon","paul.leviet@gmail.com","Paulo","123Projet");
        Customer customer5 = new Customer(5,"Martine","Mauricienne","2 route de la paix","Port Louis","mart.mau@gmail.com","Martine","123Projet");
        
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);
        
        Order order1 = new Order(1,2,0,455.98,"Guigzz");
        Order order2 = new Order(2,3,0,13.5,"Haoua");
        Order order3 = new Order(3,1,0,65,"ML");
        Order order4 = new Order(4,3,0,10.89,"Martine");
        Order order5 = new Order(5,2,0,10.5,"ML");
        Order order6 = new Order(6,4,0,19,"Haoua");
        Order order7 = new Order(7,20,4.9,20,"Paulo");
        
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);
        orders.add(order5);
        orders.add(order6);
        orders.add(order7);
        
        OrderDetails orderdetails1 = new OrderDetails(1,1,6,1,55.99,0);
        OrderDetails orderdetails2 = new OrderDetails(2,1,4,1,399.99,0);
        OrderDetails orderdetails3 = new OrderDetails(3,2,7,3,13.5,0);
        OrderDetails orderdetails4 = new OrderDetails(4,3,5,1,65,0);
        OrderDetails orderdetails5 = new OrderDetails(5,4,1,2,9.9,0);
        OrderDetails orderdetails6 = new OrderDetails(6,4,3,1,0.99,0);
        OrderDetails orderdetails7 = new OrderDetails(7,5,2,1,5.5,0);
        OrderDetails orderdetails8 = new OrderDetails(8,5,8,1,5,0);
        OrderDetails orderdetails9 = new OrderDetails(9,6,7,2,9,0);
        OrderDetails orderdetails10 = new OrderDetails(10,6,8,2,10,0);
        OrderDetails orderdetails11 = new OrderDetails(11,7,9,10,11,4);
        OrderDetails orderdetails12 = new OrderDetails(12,7,10,10,9,0.9);
        
        orderDetails.add(orderdetails1);
        orderDetails.add(orderdetails2);
        orderDetails.add(orderdetails3);
        orderDetails.add(orderdetails4);
        orderDetails.add(orderdetails5);
        orderDetails.add(orderdetails6);
        orderDetails.add(orderdetails7);
        orderDetails.add(orderdetails8);
        orderDetails.add(orderdetails9);
        orderDetails.add(orderdetails10);
        orderDetails.add(orderdetails11);
        orderDetails.add(orderdetails12);
        
    }
    
    public void initDB(){
        resetDB();
        createTables();
        initData();
        try{
            for(int i=0;i<products.size();i++){
                productdb.addProduct(products.get(i));
            }
            for(int i=0;i<employees.size();i++){
                employeedb.addEmployee(employees.get(i));
            }
            for(int i=0;i<customers.size();i++){
                customerdb.addCustomer(customers.get(i));
            }
            for(int i=0;i<orders.size();i++){
                orderdb.submitOrder(orders.get(i));
            }
            for(int i=0;i<orderDetails.size();i++){
                orderdetailsdb.submitBucket(orderDetails.get(i));
            }
            
        }catch(Exception e){
            System.out.println("ERROR SQL in initialization of tables " + e.getMessage());
        }
    }
 
}
