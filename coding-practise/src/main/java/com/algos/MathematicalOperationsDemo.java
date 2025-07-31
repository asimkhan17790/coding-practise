package com.algos;

public class MathematicalOperationsDemo {
    
    public static void main(String[] args) {
        System.out.println("🧮 MATHEMATICAL OPERATIONS DEMO");
        System.out.println("=".repeat(50));
        
        // Basic Operations
        System.out.println("\n📊 BASIC ARITHMETIC OPERATIONS:");
        System.out.println("5 + 3 = " + add(5, 3));
        System.out.println("10 - 4 = " + subtract(10, 4));
        System.out.println("6 × 7 = " + multiply(6, 7));
        System.out.println("15 ÷ 3 = " + divide(15, 3));
        System.out.println("10 ÷ 0 = " + divide(10, 0));
        
        // Scientific Functions
        System.out.println("\n🔬 SCIENTIFIC FUNCTIONS:");
        System.out.println("sin(30°) = " + sin(30));
        System.out.println("cos(60°) = " + cos(60));
        System.out.println("tan(45°) = " + tan(45));
        System.out.println("log(100) = " + log(100));
        System.out.println("ln(2.718) = " + ln(2.718));
        System.out.println("√(16) = " + sqrt(16));
        
        // Power Functions
        System.out.println("\n⚡ POWER FUNCTIONS:");
        System.out.println("5² = " + square(5));
        System.out.println("3³ = " + cube(3));
        System.out.println("1/4 = " + reciprocal(4));
        
        // Constants
        System.out.println("\n📐 MATHEMATICAL CONSTANTS:");
        System.out.println("π = " + Math.PI);
        System.out.println("e = " + Math.E);
        
        // Complex Calculations
        System.out.println("\n🎯 COMPLEX CALCULATIONS:");
        double result1 = add(multiply(5, 3), subtract(20, 8));
        System.out.println("5 × 3 + (20 - 8) = " + result1);
        
        double result2 = divide(square(6), sqrt(9));
        System.out.println("6² ÷ √9 = " + result2);
        
        double result3 = multiply(sin(30), cos(60));
        System.out.println("sin(30°) × cos(60°) = " + result3);
        
        // Calculator Simulation
        System.out.println("\n🖥️ CALCULATOR SIMULATION:");
        simulateCalculator();
    }
    
    // Basic Operations
    public static double add(double a, double b) {
        return a + b;
    }
    
    public static double subtract(double a, double b) {
        return a - b;
    }
    
    public static double multiply(double a, double b) {
        return a * b;
    }
    
    public static double divide(double a, double b) {
        if (b == 0) {
            return Double.NaN; // Not a Number for division by zero
        }
        return a / b;
    }
    
    // Scientific Functions
    public static double sin(double degrees) {
        return Math.sin(Math.toRadians(degrees));
    }
    
    public static double cos(double degrees) {
        return Math.cos(Math.toRadians(degrees));
    }
    
    public static double tan(double degrees) {
        return Math.tan(Math.toRadians(degrees));
    }
    
    public static double log(double x) {
        return Math.log10(x);
    }
    
    public static double ln(double x) {
        return Math.log(x);
    }
    
    public static double sqrt(double x) {
        return Math.sqrt(x);
    }
    
    // Power Functions
    public static double square(double x) {
        return x * x;
    }
    
    public static double cube(double x) {
        return x * x * x;
    }
    
    public static double reciprocal(double x) {
        if (x == 0) {
            return Double.NaN;
        }
        return 1.0 / x;
    }
    
    public static void simulateCalculator() {
        System.out.println("Simulating calculator operations:");
        
        double currentValue = 0;
        System.out.println("Starting: " + currentValue);
        
        // Add 15
        currentValue = add(currentValue, 15);
        System.out.println("+ 15 = " + currentValue);
        
        // Multiply by 2
        currentValue = multiply(currentValue, 2);
        System.out.println("× 2 = " + currentValue);
        
        // Subtract 10
        currentValue = subtract(currentValue, 10);
        System.out.println("- 10 = " + currentValue);
        
        // Square the result
        currentValue = square(currentValue);
        System.out.println("x² = " + currentValue);
        
        // Take square root
        currentValue = sqrt(currentValue);
        System.out.println("√ = " + currentValue);
        
        // Calculate sin
        double sinResult = sin(currentValue);
        System.out.println("sin(" + currentValue + "°) = " + sinResult);
        
        System.out.println("Final result: " + currentValue);
    }
} 