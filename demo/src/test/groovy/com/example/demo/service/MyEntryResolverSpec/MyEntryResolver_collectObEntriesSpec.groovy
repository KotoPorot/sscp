package com.example.demo.service.MyEntryResolverSpec

import com.example.demo.service.MyEntryResolver
import spock.lang.Specification
import spock.lang.Subject

class MyEntryResolver_collectObEntriesSpec extends Specification {
    @Subject
    def resolver = new MyEntryResolver<TestPojo>()

    def 'Should CollectObEntries successfully when valid object and fields exists'() {
        given:
        def testOb = new TestPojo()
        def testFields = testOb.class.getDeclaredFields()
        testFields.each { it.setAccessible(true) }

        when:
        def result = resolver.collectObEntries(testOb, testFields)

        then:
        result != null
        result.get(0).getKey() == "com.example.demo.service.MyEntryResolverSpec.TestPojo.name"
        result.get(0).getValue() == "test name"

        result.get(1).getKey() == "com.example.demo.service.MyEntryResolverSpec.TestPojo.age"
        result.get(1).getValue() == "18"
    }

    def 'Should thrown IllegalArgumentException when fields are incorrect'() {

        given:
        def testOb = new TestPojo()
        def testFields = new WrongPojo().class.getDeclaredFields()
        testFields.each { it.setAccessible(true) }

        when:
        resolver.collectObEntries(testOb, testFields)

        then:
        thrown IllegalArgumentException

    }


}

class TestPojo {
    public String name = "test name"
    public int age = 18
}

class WrongPojo {
    int xxx = 0
}
