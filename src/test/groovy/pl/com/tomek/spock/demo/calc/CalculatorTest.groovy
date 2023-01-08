package pl.com.tomek.spock.demo.calc

import spock.lang.Specification

class CalculatorTest extends Specification {

    Calculator calculator = new Calculator()

    def "should correctly multiply two digits"() {

        when:
        def result = calculator.multiply(a, b)
        then:
        result == expectedResult

        where:
        a   | b   | expectedResult
        1.0 | 2.0 | 2.0
        5.0 | 0   | 0
        5.0 | 1.0 | 5.0
    }

    def "dzielenie dwoch liczb"(){
        when:
        def result = calculator.divide(c, d)
        then:
        result == expectedResult

        where:
        c   | d   | expectedResult
        1.0 | 2.0 | 0.5
        5.0 | 1.0 | 5.0

    }

    def "wyjatek w przypadku dzielenia przez 0"(){
        given:
        double c = 10
        double d = 0

        when:
        calculator.divide(c, d)
        then:
        def exception = thrown(java.lang.ArithmeticException)
        exception.message == "nie dziel przez 0"



    }


}
