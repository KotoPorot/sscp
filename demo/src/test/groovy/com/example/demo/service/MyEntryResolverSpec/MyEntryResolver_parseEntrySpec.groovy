package com.example.demo.service.MyEntryResolverSpec

import com.example.demo.service.MyEntryResolver
import spock.lang.Specification
import spock.lang.Subject

class MyEntryResolver_parseEntrySpec extends Specification {
    @Subject
    def resolver = new MyEntryResolver()

    def 'Should ParseEntry Successfully when a string matches a pattern, value null or missing '() {
        when:
        def result = resolver.parseEntry(input)

        then:
        result
        result.getKey() == expKey
        result.getValue() == expValue

        where:
        input                      || expKey       || expValue
        "simpleKey1=simlpe=Value1" || "simpleKey1" || "simlpe=Value1"
        "simpleKey1=null"          || "simpleKey1" || null
        "simpleKey1="              || "simpleKey1" || ""
    }

    def 'Should thrown IllegalArgumentException when string dosnt match a pattern'() {
        when:
        resolver.parseEntry(input)

        then:
        thrown IllegalArgumentException

        where:
        input << [
                "=simpleKey1_simlpeValue1",
                "simpleKey2simlpeValue1",
                "simpleKey2\nsimlpeValue1"
        ]

    }


}
