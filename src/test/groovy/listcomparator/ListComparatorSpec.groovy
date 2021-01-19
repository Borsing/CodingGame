package listcomparator

import spock.lang.Specification
import spock.lang.Unroll

class ListComparatorSpec extends Specification {

    @Unroll
    void "Test ListComparator haveSameElements for the give #testCase"() {
        when:
        def result = ListComparator.haveSameElements(listA, listB)

        then:
        result == expectedResult

        where:
        testCase          | listA                | listB                | expectedResult
        "Null"            | null                 | null                 | false
        "None"            | []                   | []                   | true

        "Simple Case"     | ["A"]                | ["A"]                | true
        "Simple Case 2"   | ["A"]                | ["B"]                | false

        "Same Order"      | ["A", "B", "C"]      | ["A", "B", "C"]      | true
        "Different Order" | ["A", "B", "C"]      | ["C", "B", "A"]      | true

        "Bad typing"      | ["A", "B", "C"]      | ["A", "D", "C"]      | false
        "Intruder"        | ["A", "B", "C"]      | ["A", "B", "C", "D"] | false
        "Intruder 2"      | ["A", "B", "C", "D"] | ["A", "B", "C"]      | false

        "Duplicated"      | ["A", "B", "C"]      | ["A", "A", "B", "C"] | true
        "Duplicated 2"    | ["A", "A", "B", "C"] | ["C", "B", "A"]      | true

//        "Other type"      | [1, 2, 3]               | [1, 2, 3]               | true

//        "Limits"          | listRange(0, 10000000) | listRange(1, 10000000) | false
//        "Limits"          | listRange(0, 10000000) | listRange(0, 10000000) | true
    }

//    private static List<Integer> listRange(int min, int max) {
//        return IntStream.range(min, max).boxed().collect(Collectors.toList())
//    }
}
