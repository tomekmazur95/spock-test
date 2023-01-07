package pl.com.tomek.spock.demo

import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class SpockDemoAppSpecification extends Specification {

    def "should load context"() {
        expect:
        1 == 1
    }
}
