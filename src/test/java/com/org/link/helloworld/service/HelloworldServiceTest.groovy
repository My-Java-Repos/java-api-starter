package com.org.link.helloworld.service

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestOperations
import org.springframework.web.client.RestTemplate
import spock.lang.Specification


class HelloworldServiceTest extends Specification {
    def service
    RestOperations restTemplate

    def setup() {
        restTemplate = Mock(RestTemplate)
        service = new HelloworldService()
        service.restTemplate = restTemplate

    }

    def "Getdata"() {
        when:
        def response = service.getdata()
        then:
        response != null
        response == "test"
        and:
        1 * restTemplate.exchange(*_) >> new ResponseEntity("test", HttpStatus.OK)


    }

    def "GetdataFallback"() {

        when:
        def response = service.getdataFallback()

        then:
        response != null
        response == "Fallback"

    }

}