def remove_duplicates(nums):
    result = [nums[0]]  # Initialize the result list with the first element

    for i in range(1, len(nums)):
        if nums[i] != result[-1]:
            result.append(nums[i])  # Append non-duplicate elements to the result list

    return result

nums = [1, 1, 2, 2, 3, 4, 4, 5, 5, 5]
result = remove_duplicates(nums)
print(result)