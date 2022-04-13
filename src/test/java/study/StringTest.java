package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    private StringUtil testStringUtil;

    @BeforeEach
    public void setup() {
        testStringUtil = new StringUtil();
    }

    @AfterEach
    public void teardown() {

    }

    @Test
    @DisplayName("쉼표를 가진 문자열에서 쉼표구분자로 문자열 나누기")
    public void SplitByComma_StringArray_from_StringDataWithComma() {
        String input = "1,2";

        String[] result = testStringUtil.SplitByComma(input);

        assertThat(result).contains("1", "2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("쉼표가 없는 문자열에서 쉼표구분자로 문자열 나누기")
    public void SplitByComma_SingleString_from_StringDataWithoutComma() {
        String input = "1";

        String[] result = testStringUtil.SplitByComma(input);

        assertThat(result).contains("1");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("괄호로 둘러쌓인 문자열에서 괄호를 제거하기")
    public void RemoveBrakets_from_StringDataSurroundingBrakets() {
        String input = "(1,2)";

        String result = testStringUtil.RemoveBrakets(input);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열에서 특정 위치 문자 가져오기")
    public void GetACharacter_from_String() {
        String input = "abc";

        char result = testStringUtil.GetAt(input, 0);

        assertThat(result).isEqualTo('a');
    }

    @Test
    @DisplayName("문자열에서 잘못된 위치 문자 가져오기")
    public void GetACharacter_throw_Exception() {
        String input = "abc";
        int outOfIndex = 4;

        assertThatThrownBy(() -> {
            char result = testStringUtil.GetAt(input, outOfIndex);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + outOfIndex);
    }
}
