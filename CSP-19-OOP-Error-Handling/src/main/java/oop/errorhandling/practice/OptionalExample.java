package oop.errorhandling.practice;

import java.util.Collection;
import java.util.Optional;

public class OptionalExample {
    private Optional<Double> mean(Collection<Double> nums) {
        if (nums.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(nums.stream()
                .mapToDouble(Double::doubleValue)
                .sum() / nums.size());
    }
}
