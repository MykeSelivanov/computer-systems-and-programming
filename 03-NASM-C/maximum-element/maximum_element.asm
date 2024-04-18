section .text
global max_element

; - array pointer in RDI
; - length in RSI
max_element:
    ; init the max element to 0
    mov rdx, 0

.loop:
    ; check if array length is zero
    test rsi, rsi
    jz .end
    ; compare current max with array value at rdi
    cmp rdx, [rdi]
    ; If the current maximum is greater than or equal to the array element, skip the update
    jge .skip
    ; Update the maximum element with the array element if it's greater
    mov rdx, [rdi]

.skip:
    inc rdi
    dec rsi
    jnz .loop

.end
    ret