/*
 * Product Calculator (Recursive)
 * 
 * This program allows the user to enter five numbers through a user interface.
 * It calculates and displays the product of these numbers using recursion.
 * 
 * Features:
 * - Uses JOptionPane for input and output.
 * - Ensures only numbers are accepted.
 * - Allows users to close the program using the X button.
 * - Implements recursion to calculate the product.
 * 
 * Author: Andrew Marhefka
 * Date: 02-16-2025
 */

 import javax.swing.*;

 public class ProductCalculator {
 
     // Recursive method to compute product of numbers in an array
     public static long computeProduct(long[] numbers, int index) {
         if (index == numbers.length) {
             return 1; // Base case: Return 1 when the end of the array is reached
         }
         return numbers[index] * computeProduct(numbers, index + 1);
     }
 
     public static void main(String[] args) {
         long[] numbers = new long[5];
 
         // Loop to collect user input
         for (int i = 0; i < 5; i++) {
             numbers[i] = getValidNumber("Enter number " + (i + 1) + ":");
         }
 
         // Calculate product using recursion
         long product = computeProduct(numbers, 0);
 
         // Show result
         JOptionPane.showMessageDialog(null, 
             "The product of the entered numbers is: " + product, 
             "Result", 
             JOptionPane.INFORMATION_MESSAGE);
     }
 
     // Method to get valid integer input
     public static long getValidNumber(String message) {
         while (true) {
             String input = JOptionPane.showInputDialog(null, message, "Product Calculator", JOptionPane.QUESTION_MESSAGE);
             
             if (input == null) { // X button or Cancel
                 JOptionPane.showMessageDialog(null, "Program terminated by user.", "Exit", JOptionPane.INFORMATION_MESSAGE);
                 System.exit(0);
             }
 
             try {
                 return Long.parseLong(input.trim());
             } catch (NumberFormatException e) {
                 JOptionPane.showMessageDialog(null, "Invalid input. Please enter an integer.", "Error", JOptionPane.ERROR_MESSAGE);
             }
         }
     }
 }