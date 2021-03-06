package swoop

import groovy.util.XmlSlurper
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class ApiApplication {
    static void main(String[] args) {
        SpringApplication.run ApiApplication, args
    }
}

@RestController
@RequestMapping('/math')
class MathController {
    
    @RequestMapping(value='/add', method=RequestMethod.GET)
    def AddGet(@RequestParam(value='n1') int n1, @RequestParam(value='n2') int n2) {
        [result: n1 + n2]
    }

    @RequestMapping(value='/add', method=RequestMethod.POST)
    def AddPost(@RequestParam(value='n1') int n1, @RequestParam(value='n2') int n2) {
        [result: n1 + n2]
    }
}

@RestController
@RequestMapping('/time')
class TimeController {
    
    @RequestMapping(value = '/now')
    def Now() {
        def endpoint = 'http://api.timezonedb.com/v2/get-time-zone?key=JC3H0WOZH2YV&by=zone&zone=MST'
        def xml = new XmlSlurper().parse(endpoint)

        [timezone: xml.zoneName.text(), time: xml.formatted.text()]
    }
}
