section .text
global linear_search

; - RDI: Pointer to the array
; - RSI: Length of the array
; - RDX: Value to search for

linear_search:
    ; assume the element is not in the array, therefore -1
    mov rax, -1
    ; initialize loop counter to be used as an index
    mov rcx, 0

.loop:
    ; compare loop counter/index with the array length
    cmp rcx, rsi
    ; if loop counter >= arr length, end the loop
    jge .end
    ; compare current arr element with the rdx value that you search for
    cmp [rdi + rcx], rdx
    je .found
    ; if not found, increment rcx
    inc rcx
    jmp .loop

.found:
    ; move the index to rax
    mov rax, rcx

.end
    ret