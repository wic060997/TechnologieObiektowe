package pl.technologieobiektowe.backendjava;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestsController {

    @RequestMapping(method = RequestMethod.GET, path = "/test")
    public ResponseEntity test() {
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("I'am a Teapot");
    }


    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/simple")
    public ResponseEntity simple() {
        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/data1k")
    public ResponseEntity data1k() {
        return ResponseEntity.status(HttpStatus.OK).body(TestData.getData1k());
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/data10k")
    public ResponseEntity data10k() {
        return ResponseEntity.status(HttpStatus.OK).body(TestData.getData10k());
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/data1m")
    public ResponseEntity data1m() {
        return ResponseEntity.status(HttpStatus.OK).body(TestData.getData1m());
    }

//    @RequestMapping(method = RequestMethod.GET, path = "/data10m")
//    public ResponseEntity data10m() {
//        return ResponseEntity.status(HttpStatus.OK).body(TestData.getData10m());
//    }

}
