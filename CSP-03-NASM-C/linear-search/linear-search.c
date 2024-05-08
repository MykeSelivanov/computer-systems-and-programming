int linear_search(int *arr, int length, int value) {
    for (int i = 0; i < length; i++) {
        if (arr[i] == value) {
            return i; // Return index if value is found
        }
    }
    return -1; // Return -1 if value is not found
}