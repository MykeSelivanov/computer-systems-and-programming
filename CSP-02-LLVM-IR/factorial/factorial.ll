define i32 @factorial(i32 %n) {
entry:
  ; Check if n is 0 or 1
  ; icmp = integer comparison
  %is_zero = icmp eq i32 %n, 0
  %is_one = icmp eq i32 %n, 1
  %is_zero_or_one = or i1 %is_zero, %is_one
  br i1 %is_zero_or_one, label %result, label %loop

loop:
  ; In LLVM IR, the phi instruction (short for "phi node") is used to represent a value that depends on control flow.
  ; The phi instruction selects a value based on which predecessor basic block was executed.
  ; Initialize result to 1
  %result = phi i32 [1, %entry], [%fact, %recurse]

  ; Decrement n
  %n_minus_one = sub i32 %n, 1

  ; Calculate factorial(n - 1) recursively
  %fact = call i32 @factorial(i32 %n_minus_one)

  ; Multiply result by n
  %mul = mul i32 %result, %n

  ; Return the result
  ret i32 %mul

result:
  ; If n is 0 or 1, return 1
  ret i32 1
}
