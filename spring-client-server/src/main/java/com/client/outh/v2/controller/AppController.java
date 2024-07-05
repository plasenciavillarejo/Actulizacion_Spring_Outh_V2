package com.client.outh.v2.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.client.outh.v2.dto.MensajeDto;

@RestController
public class AppController {

  @GetMapping(value = "/listaMensaje")
  public ResponseEntity<List<MensajeDto>> listaMensajeDto() {
    return new ResponseEntity<>(Collections.singletonList(new MensajeDto("Prueba ejemplo")), HttpStatus.OK);
  }
  
  @PostMapping(value = "/crear")
  public ResponseEntity<MensajeDto> crearMensaje(@RequestBody MensajeDto mensajeDto) {
    return new ResponseEntity<>(new MensajeDto("Se ha guardado correctamente el menasje: "+ mensajeDto.getText()), HttpStatus.OK);
  }
  
  /**
   * Función encargada de obtener el código de autorizacion, recibe un code que es como se llama en el servidor de autorizacion.
   * Nos permite intercambiar el código de autorizacion por un token para que podamos acceder a las rutas protegidas.
   * @param code
   * @return
   */
  @GetMapping(value = "/authorized")
  public ResponseEntity<Map<String, String>> autorizacion(@RequestParam String code) {
    return new ResponseEntity<>(Collections.singletonMap("code", code), HttpStatus.OK);
    
  }
  
}
