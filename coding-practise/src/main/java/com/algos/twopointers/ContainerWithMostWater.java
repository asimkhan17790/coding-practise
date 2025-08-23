//Given an array representing heights of vertical lines, find the maximum area of water trapped between two lines.

//Input: [1,8,6,2,5,4,8,3,7].

//Output: 49.

public class ContainerWithMostWater {
    public static void main(String[] args) {
        // Run all test cases
        runTests();
    }
    
    public static void runTests() {
        System.out.println("Running Container With Most Water Tests...\n");
        
        // Test Case 1: Given example
        int[] test1 = {1,8,6,2,5,4,8,3,7};
        int expected1 = 49;
        testCase(test1, expected1, "Test 1 - Given example");
        
        // Test Case 2: Simple case with two elements
        int[] test2 = {1,1};
        int expected2 = 1;
        testCase(test2, expected2, "Test 2 - Two equal elements");
        
        // Test Case 3: Increasing heights
        int[] test3 = {1,2,3,4,5};
        int expected3 = 6; // between heights 1 and 5 (width=4, height=1)
        testCase(test3, expected3, "Test 3 - Increasing heights");
        
        // Test Case 4: Decreasing heights
        int[] test4 = {5,4,3,2,1};
        int expected4 = 6; // between heights 5 and 1 (width=4, height=1)
        testCase(test4, expected4, "Test 4 - Decreasing heights");
        
        // Test Case 5: All same heights
        int[] test5 = {3,3,3,3,3};
        int expected5 = 12; // width=4, height=3
        testCase(test5, expected5, "Test 5 - All same heights");
        
        // Test Case 6: Large difference in heights
        int[] test6 = {1,2,4,3};
        int expected6 = 4; // between heights 2 and 3 (width=2, height=2)
        testCase(test6, expected6, "Test 6 - Mixed heights");
        
        // Test Case 7: Peak in middle
        int[] test7 = {2,1,8,1,2};
        int expected7 = 8; // between first and last (width=4, height=2)
        testCase(test7, expected7, "Test 7 - Peak in middle");
        
        // Test Case 8: Larger array
        int[] test8 = {1,3,2,5,25,24,5};
        int expected8 = 24; // between heights 25 and 24 (width=1, height=24)
        testCase(test8, expected8, "Test 8 - Larger array with high peak");
        
        // Test Case 9: Edge case with zeros
        int[] test9 = {0,2,0};
        int expected9 = 0; // max area with zero heights
        testCase(test9, expected9, "Test 9 - Contains zeros");
        
        System.out.println("\nAll tests completed!");
    }
    
    public static void testCase(int[] heights, int expected, String testName) {
        int result = maxArea(heights);
        boolean passed = result == expected;
        
        System.out.print(testName + ": ");
        System.out.print("Input: [");
        for (int i = 0; i < heights.length; i++) {
            System.out.print(heights[i]);
            if (i < heights.length - 1) System.out.print(",");
        }
        System.out.println("]");
        System.out.println("Expected: " + expected + ", Got: " + result + 
                          " - " + (passed ? "PASS" : "FAIL"));
        
        if (!passed) {
            System.out.println("❌ Test failed!");
        } else {
            System.out.println("✅ Test passed!");
        }
        System.out.println();
    }

    public static int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;

        while (left < right) {
            int height = Math.min(heights[left], heights[right]);
            int width = right - left;
            int currentArea = height * width;
            maxArea = Math.max(maxArea, currentArea);
            
            // Move the pointer with smaller height inward
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
}