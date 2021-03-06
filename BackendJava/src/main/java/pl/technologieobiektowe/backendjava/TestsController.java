package pl.technologieobiektowe.backendjava;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestsController {

    @Autowired
    Gson gson;

    @RequestMapping(method = RequestMethod.GET, path = "/test")
    public ResponseEntity test() {
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("I'am a Teapot");
    }


    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/simple")
    public ResponseEntity simple() {
        return ResponseEntity.status(HttpStatus.OK).body(gson.toJson("OK"));
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/data1k")
    public ResponseEntity data1k() {
        return ResponseEntity.status(HttpStatus.OK).body(gson.toJson(TestData.getData1k()));
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/data3k")
    public ResponseEntity data3k() {
        return ResponseEntity.status(HttpStatus.OK).body(gson.toJson(TestData.getData3k()));
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/data5k")
    public ResponseEntity data5k() {
        return ResponseEntity.status(HttpStatus.OK).body(gson.toJson(TestData.getData5k()));
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/data10k")
    public ResponseEntity data10k() {
        return ResponseEntity.status(HttpStatus.OK).body(gson.toJson(TestData.getData10k()));
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/data20k")
    public ResponseEntity data20k() {
        return ResponseEntity.status(HttpStatus.OK).body(gson.toJson(TestData.getData20k()));
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/data50k")
    public ResponseEntity data50k() {
        return ResponseEntity.status(HttpStatus.OK).body(gson.toJson(TestData.getData50k()));
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/data1m")
    public ResponseEntity data1m() {
        return ResponseEntity.status(HttpStatus.OK).body(gson.toJson(TestData.getData1m()));
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/data3m")
    public ResponseEntity data3m() {
        return ResponseEntity.status(HttpStatus.OK).body(gson.toJson(TestData.getData3m()));
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/data5m")
    public ResponseEntity data5m() {
        return ResponseEntity.status(HttpStatus.OK).body(gson.toJson(TestData.getData5m()));
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/data10m")
    public ResponseEntity data10m() {
        return ResponseEntity.status(HttpStatus.OK).body(gson.toJson(TestData.getData10m()));
    }

}
