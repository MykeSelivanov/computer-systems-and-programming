section .text
global is_sorted

; - array pointer in RDI
; - length in RSI
is_sorted:
    mov rax, 1          ; let's assume that array is sorted by default
    test rsi, rsi       ; check if array length is zero
    jz .end             ; if length is zero - return 1 right away for true

    xor rdx, rdx        ; clear rdx

.loop_start:
    mov al, [rdi + rdx] ; Load current element
    cmp byte [rdi + rdx + 1], al  ; Compare with next element
    jge .next_element   ; If next element is greater or equal, continue checking
    mov rax, 0          ; If not, set result to false
    jmp .end            ; Exit loop

.next_element:
    inc rdx             ; Move to next element
    dec rsi             ; Decrement array length counter
    jnz .loop_start     ; Loop until array length becomes zero

.end:
    ret                     ; Return result in RAX