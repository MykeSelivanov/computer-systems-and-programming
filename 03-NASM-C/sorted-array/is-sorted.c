int is_sorted(int *arr, int length) {
    // Assume array is sorted by default
    int result = 1;
    
    // Check if array length is zero
    if (length == 0) { return 1; }
    
    int i;
    for (i = 0; i < length - 1; i++) {
        // Compare current element with next element
        if (*(arr + i) > *(arr + i + 1)) {
            // If next element is smaller, set result to false
            result = 0;
            break;
        }
    }
    
    return result;
}