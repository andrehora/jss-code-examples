ResponseEntity<User> responseEntity = restTemplate.getForEntity(uri, User.class); // (1)
HttpStatus statusCode = responseEntity.getStatusCode(); // (2)
HttpHeaders header = responseEntity.getHeaders(); // (3)
User user = responseEntity.getBody(); // (4)