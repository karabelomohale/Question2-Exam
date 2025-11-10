/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package rc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_Lab
 */
public class ProductSalesGUITest {

    @Test
    void GetSalesOverLimit_ReturnsNumberOfSales() {
        IProductSales productSales = new ProductSales();
        int expectedOverLimit = 2;
        int actualOverLimit = productSales.GetSalesOverLimit();
        assertEquals(expectedOverLimit, actualOverLimit);
    }

    @Test
    void GetSalesUnderLimit_ReturnsNumberOfSales() {
        IProductSales productSales = new ProductSales();
        int expectedUnderLimit = 4;
        int actualUnderLimit = productSales.GetSalesUnderLimit();
        assertEquals(expectedUnderLimit, actualUnderLimit);
    }

    @Test
    void GetTotalSales_ReturnsCorrectTotal() {
        IProductSales productSales = new ProductSales();
        int expectedTotal = 300 + 150 + 700 + 250 + 200 + 600;
        int actualTotal = productSales.GetTotalSales();
        assertEquals(expectedTotal, actualTotal);
    }

    @Test
    void GetProductsProcessed_ReturnsNumberOfYears() {
        IProductSales productSales = new ProductSales();
        int expectedYears = 2;
        int actualYears = productSales.GetProductsProcessed();
        assertEquals(expectedYears, actualYears);
    }
}
