package net.furikuri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CounterController {

  @Autowired
  private RedisTemplate<String, Long> redisClient;

  @RequestMapping("/")
  public String counter() {
    Long counter = redisClient.opsForValue().increment("counter", 1);
    return String.valueOf(counter);
  }

}
