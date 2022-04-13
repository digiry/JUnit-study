package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("중복값이 제거된 Set collection 크기")
    void SizeOfSet_without_duplication() {
        int size = numbers.size();

        assertThat(size).isEqualTo(3);
    }

    @Test
    @DisplayName("Set가 테스트값을 포함하는 지 검사하기")
    void Contains_data_in_set() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    /* Test Run error troubleshooting
     *    error message: Execution failed for task ':test'.
     *    solution: https://dev-emmababy.tistory.com/86
     */
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("Set가 테스트값을 포함하는지 검사하기 - 인자 입력으로 테스트 코드 줄이기")
    void Contains_data_in_set_with_parameterized(int value) {
        assertThat(numbers).contains(value);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("Set가 테스트값을 포함하는지 검사하기 - CSV 양식 입력으로 테스트 코드 입력값 정의하기")
    void Contains_data_in_set_with_csvsource(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
