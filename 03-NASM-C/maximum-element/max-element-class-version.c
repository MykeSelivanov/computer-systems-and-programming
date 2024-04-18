 int max_element(int arr, int len) {  
    int *ptr = arr;
    int max = *ptr;

    start_loop:
        if (ptr < arr + len) {
            if (*ptr > max) {
                max = *ptr;
            }
            ptr++;
            goto start_loop;
        }
 }