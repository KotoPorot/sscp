package com.example.demo.service.MyEntryResolverSpec

import com.example.demo.entity.MyEntry
import com.example.demo.service.MyEntryResolver
import spock.lang.Specification

class MyEntryResolver_valuesToUpCaseSpec extends Specification {
    def resolver = new MyEntryResolver()

    def 'Should ValuesToUpperCase Successfully when valid input data, value empty and null'() {
        when:
        def result = resolver.valuesToUpCase(input)

        then:
        !result.isEmpty()
        result.first.getValue() == exp
        input.first.getValue() == expOldValue

        where:
        input                                       || exp            || expOldValue
        [new MyEntry("simpleKey1", "simlpeValue1")] || "SIMLPEVALUE1" || "simlpeValue1"
        [new MyEntry("simpleKey1", "")]             || ""             || ""
        [new MyEntry("simpleKey1", null)]           || null           || null

    }

    def 'Should Thrown NullPointerException when input null'(){
        when:
        resolver.valuesToUpCase(null)
        then:
        thrown NullPointerException
    }

}
