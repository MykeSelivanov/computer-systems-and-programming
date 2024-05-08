def is_palindrome(str_list):
    for i in range(len(str_list) // 2):
        if str_list[i] != str_list[-1 - i]:
            return False
    return True

palindrome = ["hey", "hello", "world", "hello", "hey"]
print(is_palindrome(palindrome))