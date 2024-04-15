section .data

section .text
    global _start

_start:
    ; This code calculates the factorial of 5 (5! = 120) by first loading the number 5 into the eax register and then calling the factorial function.
    mov eax, 5
    call factorial
    ; The result (120) is now stored in eax

    ; After calculating the factorial, the program exits. It sets eax to 1 (the exit system call number), clears ebx, and then performs a system call (int 0x80) to exit the program.
    mov eax, 1
    xor ebx, ebx
    int 0x80

; Factorial function using recursion
factorial:
    ; This code checks if the input (eax) is 0, which serves as the base condition for the recursion. If it's 0, the function returns 1.
    cmp eax, 0
    ; jz - jump if zero
    jz end_recursion

    ; Before calling itself recursively, the function saves the current value of eax onto the stack.
    push eax

    ; The function decrements eax and then calls itself recursively to calculate the factorial of the decremented value.
    dec eax
    call factorial

    ; After the recursion returns, the function multiplies the returned result (in eax) with the saved value of eax (which was pushed onto the stack earlier).
    pop ebx
    imul eax, ebx

    ; function returns to the caller.
    ret

; This handles the base condition of the recursion. When eax is 0, it returns 1, indicating the end of the recursion.
end_recursion:
    ; Return 1 when eax is 0 (base condition)
    mov eax, 1
    ret