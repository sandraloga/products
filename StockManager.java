import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<Product>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        stock.add(item);
    }
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
      Product producto = findProduct(id);
      if(producto != null){
         producto.increaseQuantity(amount);
      }
      else{
        System.out.println("El id indicado no pertenece a ningun producto");
      }
    
    }
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
       Product producto = null;
      int index = 0;
      boolean encontrado = false;
      while(!encontrado && index < stock.size()) {
        if (stock.get(index).getID() == id) {
            producto = stock.get(index);
          encontrado = true;
        }
        index++;
      }
       return producto;
    }
    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    
    public int numberInStock(int id)
    {
       int cantidad = 0;
      Product producto = findProduct(id); 
      if (producto != null) {
         cantidad = producto.getQuantity();
      }
      return cantidad;
    }

    

    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        for (Product  producto : stock)
        {
                System.out.println (producto.toString());
        }
    }
    /**
     * A partir del código terminado de la actividad 0704, implementa un nuevo método llamado 
     * underGivenNumberInStock en la clase StockManager que imprima los detalles de todos los
     * productos cuyo stock está por debajo de un determinado número que será pasado como parámetro al método.
     */
    public void underGivenNumberInStock(int numero)
    {
        Product numeroStock = null; 
        for (Product producto : stock)
        {
            if (producto.getQuantity() < numero)
            {
                System.out.println(producto);
            }
        }
    
    }
}
