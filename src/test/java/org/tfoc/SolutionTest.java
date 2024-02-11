package org.tfoc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class SolutionTest {

    private static Stream<Arguments> provideInputString() {
        return Stream.of(
                Arguments.of("()", true),
                Arguments.of("()[]{}", true),
                Arguments.of("(]", false),
                Arguments.of("{[]}", true),
                Arguments.of("({[]})", true),
                Arguments.of("{]}", false),
                Arguments.of("({[]})()({[]})", true)
        );
    }

    @ParameterizedTest
    @MethodSource("provideInputString" )
    void testSolution(String chain, Boolean responseExpected) {

        boolean response = Solution.isValid(chain);

        assertEquals(responseExpected, response);

    }
}