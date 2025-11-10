/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rc;

/**
 *
 * @author RC_Student_Lab
 */
public class ProductSales implements IProductSales {
    private int[][] productSales;
    private final int salesLimit = 500;
    
    public ProductSales() {
        // Default data
        this.productSales = new int[][] {
            {300, 150, 700}, // Year 1: Microphone, Speakers, Mixing Desk
            {250, 200, 600} // Year 2: Microphone, Speakers, Mixing Desk
        };
    }
    
    @Override
    public void setProductSales(int[][] productSales) {
        this.productSales = productSales;
    }
    
    @Override
    public int[][] GetProductSales() {
        return productSales;
    }
    
    @Override
    public int GetTotalSales() {
        int total = 0;
        for (int[] yearSales : productSales) {
            for (int sale : yearSales) {
                total += sale;
            }
        }
        return total;
    }
    
    @Override
    public int GetSalesOverLimit() {
        int count = 0;
        for (int[] yearSales : productSales) {
            for (int sale : yearSales) {
                if (sale > salesLimit) {
                    count++;
                }
            }
        }
        return count;
    }
    
    @Override
    public int GetSalesUnderLimit() {
        int count = 0;
        for (int[] yearSales : productSales) {
            for (int sale : yearSales) {
                if (sale <= salesLimit) {
                    count++;
                }
            }
        }
        return count;
    }
    
    @Override
    public int GetProductsProcessed() {
        return productSales.length; // Number of years
    }
    
    @Override
    public double GetAverageSales() {
        int total = GetTotalSales();
        int count = 0;
        for (int[] yearSales : productSales) {
            count += yearSales.length;
        }
        return (double) total / count;
    }
}