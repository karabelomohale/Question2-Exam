/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package rc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author RC_Student_Lab
 */
public class ProductSalesGUI extends JFrame {
    private IProductSales productSales;
    private FileHandler fileHandler;
    private JTextArea textArea;
    private JLabel yearsProcessedLabel;
    
    public ProductSalesGUI() {
        productSales = new ProductSales();
        fileHandler = new FileHandler();
        initializeGUI();
    }
    
    private void initializeGUI() {
        setTitle("Product Sales Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        
        // Create menu bar
        createMenuBar();
        
        // Create main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        
         // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton loadButton = new JButton("Load Product Data");
        JButton saveButton = new JButton("Save Product Data");
        
        loadButton.setPreferredSize(new Dimension(150, 30));
        saveButton.setPreferredSize(new Dimension(150, 30));
        
        buttonPanel.add(loadButton);
        buttonPanel.add(saveButton);
        
        // Results area
        textArea = new JTextArea(8, 30);
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        textArea.setBorder(BorderFactory.createTitledBorder("Sales Results"));
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        // Years processed label
        yearsProcessedLabel = new JLabel("Years Processed: 0");
        yearsProcessedLabel.setFont(new Font("Arial", Font.BOLD, 12));
        yearsProcessedLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        
        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(yearsProcessedLabel, BorderLayout.SOUTH);
        
        add(mainPanel);
        
        // Add button listeners
        loadButton.addActionListener(new LoadButtonListener());
        saveButton.addActionListener(new SaveButtonListener());
    }
    
    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        
        // File menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitMenuItem);
        
        // Tools menu
        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem loadMenuItem = new JMenuItem("Load Product Data");
        JMenuItem saveMenuItem = new JMenuItem("Save Product Data");
        JMenuItem clearMenuItem = new JMenuItem("Clear");
        
        loadMenuItem.addActionListener(new LoadButtonListener());
        saveMenuItem.addActionListener(new SaveButtonListener());
        clearMenuItem.addActionListener(e -> clearData());
        
        toolsMenu.add(loadMenuItem);
        toolsMenu.add(saveMenuItem);
        toolsMenu.add(clearMenuItem);
        
        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        
        setJMenuBar(menuBar);
    }
    
    private class LoadButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            loadProductData();
        }
    }
    
    private class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            saveProductData();
        }
    }
    
    private void loadProductData() {
        // For this example, we're using the default data
        // In a real application, you would load from file/database here
        
        String dataString = fileHandler.loadProductDataAsString(productSales);
        textArea.setText(dataString);
        yearsProcessedLabel.setText("Years Processed: " + productSales.GetProductsProcessed());
        
        JOptionPane.showMessageDialog(this, "Product data loaded successfully!", "Success", 
                                    JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void saveProductData() {
        try {
            fileHandler.saveProductData(productSales, "data.txt");
            JOptionPane.showMessageDialog(this, "Data saved to data.txt", "Success", 
                                        JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + e.getMessage(), 
                                        "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void clearData() {
        textArea.setText("");
        yearsProcessedLabel.setText("Years Processed: 0");
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ProductSalesGUI().setVisible(true);
        });
    }
}