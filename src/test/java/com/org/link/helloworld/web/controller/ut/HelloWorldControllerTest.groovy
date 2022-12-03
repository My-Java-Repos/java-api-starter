package com.org.link.helloworld.web.controller.ut

import org.springframework.http.HttpStatus
import org.springframework.test.context.web.WebAppConfiguration

import com.org.link.helloworld.service.HelloworldService
import com.org.link.helloworld.web.controller.HelloWorldController

import spock.lang.Specification


@WebAppConfiguration
class HelloWorldControllerTest extends Specification {

    HelloWorldController controller
    HelloworldService service

    def setup() {
        service = Mock(HelloworldService)
        controller = new HelloWorldController(service: service)
    }

    void 'Test the code here'() {

//        when: 'A GET call is made'
//        def response = controller.get();
//
//        then: 'The status should be 200'
//        response.statusCode == HttpStatus.OK
//
//        and: 'It should call the service'
//        0 * _._


    }
}
