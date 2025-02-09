package com.example.customcache.controller;

import com.example.customcache.service.CacheService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/cache")
public class CacheController {
    private final CacheService cacheService;

    public CacheController(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    // POST /cache → Stores a key-value pair
    @PostMapping
    public ResponseEntity<String> put(@RequestBody Map<String, String> request) {
        if (!request.containsKey("key") || !request.containsKey("value")) {
            return ResponseEntity.badRequest().body("Request must contain 'key' and 'value'.");
        }
        String response = cacheService.put(request.get("key"), request.get("value"));
        return ResponseEntity.ok(response);
    }

    // GET /cache/{key} → Retrieves a value (if exists)
    @GetMapping("/{key}")
    public ResponseEntity<String> get(@PathVariable String key) {
        return ResponseEntity.ok(cacheService.get(key));
    }

    // DELETE /cache/{key} → Remove from cache
    @DeleteMapping("/{key}")
    public ResponseEntity<String> delete(@PathVariable String key) {
        return ResponseEntity.ok(cacheService.delete(key));
    }
}
