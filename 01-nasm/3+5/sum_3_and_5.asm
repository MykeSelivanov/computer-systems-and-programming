section .text
    global sum_3_and_5

sum_3_and_5:
    ; Load the nums into registers
    mov eax, 3          ; Move the value 3 into the EAX register
    mov ebx, 5          ; Move the value 5 into the EBX register

    add eax, ebx        ; Add the value in EBX to the value in EAX

    ; Prepare arguments for write syscall
    mov rdi, 1          ; File descriptor 1 (stdout)
    lea rsi, [rax]      ; Load the address of the result into RSI register
    mov rdx, 1          ; Length of the message (1 byte)
    
    ; Perform write syscall to print the result
    mov rax, 0x02000004 ; Move the 64-bit system call number for write into RAX register
    syscall             ; Call kernel to write to stdout
    
    ; Prepare arguments for exit syscall
    xor edi, edi        ; Clear EDI (exit code 0)

    ; Perform exit syscall
    mov rax, 0x02000001 ; Move the 64-bit system call number for exit into RAX register
    syscall             ; Call kernel to exit the program
