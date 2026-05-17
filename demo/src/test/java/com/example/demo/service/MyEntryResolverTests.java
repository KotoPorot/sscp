package com.example.demo.service;

import com.example.demo.entity.MyEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MyEntryResolverTests {

    private MyEntryResolver<TestPojo> resolver;
    private TestPojo testOb;
    private Field[] testFields;

    static class TestPojo {
        String name = "test name";
        int age = 18;
    }

    @BeforeEach
    void setUp() {
        this.resolver = new MyEntryResolver<>();
        this.testOb = new TestPojo();
        this.testFields = this.testOb.getClass().getDeclaredFields();
    }

    @Nested
    @DisplayName("CollectObEntries Tests")
    class CollectObEntriesTests {

        @Test
        @DisplayName("Should CollectObEntries successfully when valid object and fields exists")
        void shouldCollectObEntriesSuccessfully() throws IllegalAccessException {
            //Given
            //setUp


            //When
            List<MyEntry> entries = resolver.collectObEntries(testOb, testFields);

            //Then
            assertNotNull(entries);
            assertEquals("com.example.demo.service.MyEntryResolverTests$TestPojo.name", entries.get(0).getKey());
            assertEquals("test name", entries.get(0).getValue());

            assertEquals("com.example.demo.service.MyEntryResolverTests$TestPojo.age", entries.get(1).getKey());
            assertEquals("18", entries.get(1).getValue());
        }

        @Test
        @DisplayName("Should thrown IllegalArgumentException when fields are incorrect")
        void shouldThrownIllegalArgumentExceptionWhenFieldsIncorrect() {

            class WrongPojo {
                int xxx = 0;
            }
            Field[] wrongFields = WrongPojo.class.getDeclaredFields();

            assertThrows(IllegalArgumentException.class, () -> resolver.collectObEntries(testOb, wrongFields));
        }
    }

    @Nested
    @DisplayName("ParseEntry tests")
    class ParseEntryTests {

        @Test
        @DisplayName("Should ParseEntry Successfully when a string matches a pattern")
        void shouldParseEntrySuccessfullyWhenStringMathesPattern() {
            String s = "simpleKey1=simlpe=Value1";

            MyEntry result = resolver.parseEntry(s);

            assertNotNull(result);
            assertEquals("simpleKey1", result.getKey());
            assertEquals("simlpe=Value1", result.getValue());
        }

        @Test
        @DisplayName("Should ParseEntry Successfully when value null")
        void shouldParseEntrySuccessfullyWhenValueNull() {
            String s = "simpleKey1=null";

            MyEntry result = resolver.parseEntry(s);

            assertNotNull(result);
            assertEquals("simpleKey1", result.getKey());
            assertNull(result.getValue());

        }

        @Test
        @DisplayName("Should ParseEntry Successfully when value is missing")
        void shouldParseEntrySuccessfullyWhenValueMissing() {
            String s = "simpleKey1=";

            MyEntry result = resolver.parseEntry(s);

            assertNotNull(result);
            assertEquals("simpleKey1", result.getKey());
            assertEquals("", result.getValue());

        }

        @ParameterizedTest
        @ValueSource(strings = {"=simpleKey1_simlpeValue1", "simpleKey2simlpeValue1", "simpleKey2\nsimlpeValue1"})
        @DisplayName("Should thrown IllegalArgumentException when string dosnt match a pattern")
        void shouldThrownIllegalArgumentException(String s) {
            assertThrows(IllegalArgumentException.class, () -> resolver.parseEntry(s));
        }

    }


    @Nested
    @DisplayName("ParseString Tests")
    class ParseStringTests {

        @Test
        @DisplayName("Should ParseString Successfully")
        void shouldParseStringSuccessfully() {
            //To avoid CRLF
            String expected = "simpleKey1=simlpeValue1" + System.lineSeparator() + "simpleKey2=" + System.lineSeparator() + "simpleKey3=null" + System.lineSeparator();

            List<MyEntry> testEntries = new ArrayList<>();
            testEntries.add(new MyEntry("simpleKey1", "simlpeValue1"));
            testEntries.add(new MyEntry("simpleKey2", ""));
            testEntries.add(new MyEntry("simpleKey3", null));

            String result = resolver.parseString(testEntries);
            assertNotNull(result);
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("ValuesToUpperCase Tests")
    class ValuesToUpperCaseTests {

        @Test
        @DisplayName("Should ValuesToUpperCase Successfully when valid input data")
        void shouldValuesToUpperCaseSuccessfullyWhenValidInputData() {
            List<MyEntry> testEntries = new ArrayList<>();
            testEntries.add(new MyEntry("simpleKey1", "simlpeValue1"));

            List<MyEntry> result = resolver.valuesToUpCase(testEntries);

            assertFalse(result.isEmpty());
            assertEquals("SIMLPEVALUE1", result.getFirst().getValue());
            assertEquals("simlpeValue1", testEntries.getFirst().getValue());

        }

        @Test
        @DisplayName("Should ValuesToUpperCase Successfully when value empty")
        void shouldValuesToUpperCaseSuccessfullyWhenValueEmpty() {
            List<MyEntry> testEntries = new ArrayList<>();
            testEntries.add(new MyEntry("simpleKey1", ""));

            List<MyEntry> result = resolver.valuesToUpCase(testEntries);

            assertFalse(result.isEmpty());
            assertEquals("", result.getFirst().getValue());
            assertEquals("", testEntries.getFirst().getValue());

        }

        @Test
        @DisplayName("Should ValuesToUpperCase Successfully when value null")
        void shouldValuesToUpperCaseSuccessfullyWhenValueNull() {
            List<MyEntry> testEntries = new ArrayList<>();
            testEntries.add(new MyEntry("simpleKey1", null));

            List<MyEntry> result = resolver.valuesToUpCase(testEntries);

            assertFalse(result.isEmpty());
            assertNull(result.getFirst().getValue());
            assertNull(testEntries.getFirst().getValue());
        }


        //I am not sure that this test have any sense
        @Test
        @DisplayName("Should Thrown NullPointerException when input null ")
        void shouldThrownNullPointerExceptionWhenInputNull() {

            assertThrows(NullPointerException.class, () -> resolver.valuesToUpCase(null));


        }
    }


}