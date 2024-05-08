; Defines a function named sumArray that takes two arguments: a pointer to an array of integers (i32* %arr) and the length of the array (i32 %length). It returns an integer (i32).
define i32 @sumArray(i32* %arr, i32 %length) {
entry:
    ; Allocates memory on the stack to store an integer (i32). This memory will be used to store the sum of the elements of the array.
    %sum = alloca i32
    ; Stores the value 0 into the memory location pointed to by %sum. This initializes the sum to zero.
    store i32 0, i32* %sum
    ; Allocates memory on the stack to store an integer (i32). This memory will be used to store the loop counter.
    %i = alloca i32
    ; Stores the value 0 into the memory location pointed to by %i. This initializes the loop counter to zero.
    store i32 0, i32* %i1
    ; Unconditional branch to the loop label. This starts the loop.
    br label %loop

loop:
    ; Loads the current value of the loop counter %i from memory into %i_val.
    %i_val = load i32, i32* %i1
    ; Compares the current value of %i_val with the length of the array %length using a signed less-than (slt) comparison. The result is stored in %cond.
    %cond = icmp slt i32 %i_val, %length
    ; Branches to %body if %cond is true (i.e., if %i_val is less than %length), otherwise, it branches to %end.
    br i1 %cond, label %body, label %end

body:
    ; Computes the memory address of the current element of the array arr using the current value of the loop counter %i_val.
    %element_ptr = getelementptr i32, i32* %arr, i32 %i_val
    ; Loads the value of the current element from memory into %element.
    %element = load i32, i32* %element_ptr
    ; Loads the current sum from memory into %sum_val.
    %sum_val = load i32, i32* %sum
    ; Adds the value of the current element %element to the current sum %sum_val, storing the result in %new_sum.
    %new_sum = add i32 %sum_val, %element
    ; Stores the updated sum %new_sum back into the memory location pointed to by %sum.
    store i32 %new_sum, i32* %sum
    ; Increments the loop counter %i_val by 1, storing the result in %next_i.
    %next_i = add i32 %i_val, 1
    ; Stores the updated value of the loop counter %next_i back into memory.
    store i32 %next_i, i32* %i1
    ; Unconditional branch back to the start of the loop.
    br label %loop

end:
    ; Loads the final sum from memory into %result.
    %result = load i32, i32* %sum
    ; Returns %result as the result of the function.
    ret i32 %result
}