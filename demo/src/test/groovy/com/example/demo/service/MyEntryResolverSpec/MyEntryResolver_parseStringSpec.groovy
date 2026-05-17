package com.example.demo.service.MyEntryResolverSpec

import com.example.demo.entity.MyEntry
import com.example.demo.service.MyEntryResolver
import spock.lang.Specification
import spock.lang.Subject

class MyEntryResolver_parseStringSpec extends Specification {
    @Subject
    def resolver = new MyEntryResolver()

    def 'Should ParseString Successfully'() {
        given:
        def exp = "simpleKey1=simlpeValue1" + System.lineSeparator() + "simpleKey2=" + System.lineSeparator() + "simpleKey3=null" + System.lineSeparator()
        def testEntries = [new MyEntry("simpleKey1", "simlpeValue1"), new MyEntry("simpleKey2", ""), new MyEntry("simpleKey3", null)]

        when:
        def result = resolver.parseString(testEntries)

        then:
        result
        result == exp


    }
}
