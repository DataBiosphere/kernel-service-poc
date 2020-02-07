package bio.terra.TEMPLATE.app.controller;

import bio.terra.TEMPLATE.generated.controller.TemplateApi;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TemplateApiController implements TemplateApi {
    @Override
    public ResponseEntity<String> ping(@RequestParam(value = "message", required = false) String message) {
        if (StringUtils.isEmpty(message)) {
            return new ResponseEntity<>("pong", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
