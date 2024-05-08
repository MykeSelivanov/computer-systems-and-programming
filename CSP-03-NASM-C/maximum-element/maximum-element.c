int max_element(int *arr, int length) {
    // Initialize the maximum element to the first element of the array
    int max = arr[0];
    
    // Iterate through the array
    for (int i = 1; i < length; i++) {
        // If the current element is greater than the current maximum, update the maximum
        if (arr[i] > max) {
            max = arr[i];
        }
    }
    
    // Return the maximum element
    return max;
}