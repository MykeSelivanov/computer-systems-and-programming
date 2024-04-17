section .data
my_array db 1, 2, 3, 4, 5 ; An array of 5 bytes
sum_byte db 0             ; Reserved byte to store the sum

section .text
    mov ecx, 5 ; Set the loop counter to the number of elements in the array
    lea esi, [my_array] ; Load the address of the first element into ESI

.loop_start:
    ; Do something with [esi], the current element of the array
    add al, [esi]
    inc esi ; Move to the next element
    dec ecx ; Decrement the loop counter
    jnz loop_start ; If the loop counter is not zero, jump back to loop_start

    ; Store the sum in the designated memory location
    mov [sum_byte], al

    ; Exit the program, returning the value of al as the exit code
    mov eax, 1              ; syscall number for sys_exit
    mov ebx, [sum_byte]     ; Use the stored sum as the exit code
    int 0x80                ; Call kernel