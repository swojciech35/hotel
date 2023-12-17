package com.tijo.kw.hotel.security.auth;

import com.tijo.kw.hotel.security.auth.exception.InvalidEmailAddressException;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
  private final AuthenticationService service;

  @CrossOrigin(origins = "http://localhost:3000")
  @PostMapping(value = "/register")
  public ResponseEntity<Boolean> register(@RequestBody RegisterRequest request) {
    try {
      boolean response = service.register((request));
      return ResponseEntity.ok(response);
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @PostMapping(value = "/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
    try {
      AuthenticationResponse response = service.authenticate(request);
      return ResponseEntity.ok(response);
    } catch (InvalidEmailAddressException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AuthenticationResponse("Nieprawidłowy adres email"));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new AuthenticationResponse("Wystąpił błąd serwera"));
    }

  }

  @Hidden
  @PostMapping("/cleanup")
  public ResponseEntity<Boolean> cleanup() {
    service.cleanup();
    return ResponseEntity.ok(true);
  }
}
