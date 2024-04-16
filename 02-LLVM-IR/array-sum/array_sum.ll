; Define global variables
@my_array = internal constant [5 x i32] [i32 1, i32 2, i32 3, i32 4, i32 5] ; An array of 5 integers
@sum = internal global i32 0                                                  ; Variable to store the sum

define i32 @main() {
    ; Initialize loop counter to 0
    %i = alloca i32
    store i32 0, i32* %i

    ; Start of the loop
    br label %loop_start

loop_start:
    ; Load the current element from the array
    %ptr = getelementptr inbounds [5 x i32], [5 x i32]* @my_array, i32 0, i32 0
    %current_val = load i32, i32* %ptr

    ; Add the current element to the sum
    %sum_val = load i32, i32* @sum
    %new_sum_val = add i32 %sum_val, %current_val
    store i32 %new_sum_val, i32* @sum

    ; Increment the loop counter
    %i_val = load i32, i32* %i
    %next_i_val = add i32 %i_val, 1
    store i32 %next_i_val, i32* %i

    ; Check if the loop counter has reached the end (5)
    %is_end = icmp eq i32 %next_i_val, 5
    br i1 %is_end, label %end_loop, label %loop_start

end_loop:
    ; Load the final sum value
    %final_sum = load i32, i32* @sum

    ; Return the final sum
    ret i32 %final_sum
}