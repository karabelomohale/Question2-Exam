/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author RC_Student_Lab
 */
public class FileHandler {
    
    public void saveProductData(IProductSales productSales, String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("DATA LOG");
            writer.println("*****************************");
            writer.println("Total Sales: " + productSales.GetTotalSales());
            writer.println("Average Sales: " + Math.round(productSales.GetAverageSales()));
            writer.println("Sales over limit: " + productSales.GetSalesOverLimit());
            writer.println("Sales under limit: " + productSales.GetSalesUnderLimit());
            writer.println("*****************************");
        }
    }
    
    public String loadProductDataAsString(IProductSales productSales) {
        StringBuilder sb = new StringBuilder();
        sb.append("Product Sales Data:\n");
        sb.append("===================\n");
        sb.append("Total Sales: ").append(productSales.GetTotalSales()).append("\n");
        sb.append("Average Sales: ").append(Math.round(productSales.GetAverageSales())).append("\n");
        sb.append("Sales over limit: ").append(productSales.GetSalesOverLimit()).append("\n");
        sb.append("Sales under limit: ").append(productSales.GetSalesUnderLimit()).append("\n\n");
        
        // Display actual sales data
        int[][] salesData = productSales.GetProductSales();
        sb.append("Detailed Sales Data:\n");
        sb.append("Year 1 - Microphone: ").append(salesData[0][0])
          .append(", Speakers: ").append(salesData[0][1])
          .append(", Mixing Desk: ").append(salesData[0][2]).append("\n");
        sb.append("Year 2 - Microphone: ").append(salesData[1][0])
          .append(", Speakers: ").append(salesData[1][1])
          .append(", Mixing Desk: ").append(salesData[1][2]).append("\n");
        
        return sb.toString();
    }
}