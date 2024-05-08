def reverse_array(arr):
    for i in range(0, len(arr) // 2):
        temp = arr[i]
        arr[i] = arr[-1 - i]
        arr[-1 - i] = temp
    return arr

test_arr = [1,2,3,4,5]
reverse_array(test_arr)
print(test_arr)