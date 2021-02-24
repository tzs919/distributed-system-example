package com.thoughtmechanix.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
@EnableResourceServer
@EnableAuthorizationServer
public class Application {
//    http://172.18.0.2:8901/auth/oauth/token
    //curl  eagleeye:thisissecret@172.18.0.2:8901/auth/oauth/token -d grant_type=password -client_id=eagleeye  -d scope=webclient -d username=william.woodward -d password=password2
    //curl  eagleeye:thisissecret@localhost:8901/auth/oauth/token -d grant_type=password -client_id=eagleeye  -d scope=webclient -d username=william.woodward -d password=password2
    //curl -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJvcmdhbml6YXRpb25JZCI6IjQyZDNkNGY1LTlmMzMtNDJmNC04YWNhLWI3NTE5ZDZhZjFiYiIsInVzZXJfbmFtZSI6IndpbGxpYW0ud29vZHdhcmQiLCJzY29wZSI6WyJ3ZWJjbGllbnQiXSwiZXhwIjoxNjE0MTc1MDE5LCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOIiwiUk9MRV9VU0VSIl0sImp0aSI6ImUzOThjMTUwLWYxMTEtNDMzNy04ODJmLTMxZjQ4NThlMTQ0OSIsImNsaWVudF9pZCI6ImVhZ2xlZXllIn0.3xTb3ltyuHSdy_kA3JVh3PoCygmU9-Bgensfoc91dQI" http://localhost:8901/auth/user
//    curl -i -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJvcmdhbml6YXRpb25JZCI6IjQyZDNkNGY1LTlmMzMtNDJmNC04YWNhLWI3NTE5ZDZhZjFiYiIsInVzZXJfbmFtZSI6IndpbGxpYW0ud29vZHdhcmQiLCJzY29wZSI6WyJ3ZWJjbGllbnQiXSwiZXhwIjoxNjEyNjYyMTQ4LCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOIiwiUk9MRV9VU0VSIl0sImp0aSI6ImIwZjk1NDJiLTU5YTUtNGI5MC04MGRmLWNjNDdjYjAxMGIzNCIsImNsaWVudF9pZCI6ImVhZ2xlZXllIn0.SWeX66RdJhwd-IoxnTd-kKHa_xbh_nx0RjzVIxLu4wo" http://172.18.0.2:8901/auth/user
//    curl -i -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJvcmdhbml6YXRpb25JZCI6IjQyZDNkNGY1LTlmMzMtNDJmNC04YWNhLWI3NTE5ZDZhZjFiYiIsInVzZXJfbmFtZSI6IndpbGxpYW0ud29vZHdhcmQiLCJzY29wZSI6WyJ3ZWJjbGllbnQiXSwiZXhwIjoxNjEyNjYyMTQ4LCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOIiwiUk9MRV9VU0VSIl0sImp0aSI6ImIwZjk1NDJiLTU5YTUtNGI5MC04MGRmLWNjNDdjYjAxMGIzNCIsImNsaWVudF9pZCI6ImVhZ2xlZXllIn0.SWeX66RdJhwd-IoxnTd-kKHa_xbh_nx0RjzVIxLu4wo" common_zuulserver_1:5555/api/licensing/v1/organizations/e254f8c-c442-4ebe-a82a-e2fc1d1ff78a/licenses/f3831f8c-c338-4ebe-a82a-e2fc1d1ff78a
//    curl -i -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJvcmdhbml6YXRpb25JZCI6IjQyZDNkNGY1LTlmMzMtNDJmNC04YWNhLWI3NTE5ZDZhZjFiYiIsInVzZXJfbmFtZSI6IndpbGxpYW0ud29vZHdhcmQiLCJzY29wZSI6WyJ3ZWJjbGllbnQiXSwiZXhwIjoxNjEyNjYyMTQ4LCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOIiwiUk9MRV9VU0VSIl0sImp0aSI6ImIwZjk1NDJiLTU5YTUtNGI5MC04MGRmLWNjNDdjYjAxMGIzNCIsImNsaWVudF9pZCI6ImVhZ2xlZXllIn0.SWeX66RdJhwd-IoxnTd-kKHa_xbh_nx0RjzVIxLu4wo" localhost:5555/api/licensing/v1/organizations/e254f8c-c442-4ebe-a82a-e2fc1d1ff78a/licenses/f3831f8c-c338-4ebe-a82a-e2fc1d1ff78a
//    curl -i -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJvcmdhbml6YXRpb25JZCI6IjQyZDNkNGY1LTlmMzMtNDJmNC04YWNhLWI3NTE5ZDZhZjFiYiIsInVzZXJfbmFtZSI6IndpbGxpYW0ud29vZHdhcmQiLCJzY29wZSI6WyJ3ZWJjbGllbnQiXSwiZXhwIjoxNjEyNjYyMTQ4LCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOIiwiUk9MRV9VU0VSIl0sImp0aSI6ImIwZjk1NDJiLTU5YTUtNGI5MC04MGRmLWNjNDdjYjAxMGIzNCIsImNsaWVudF9pZCI6ImVhZ2xlZXllIn0.SWeX66RdJhwd-IoxnTd-kKHa_xbh_nx0RjzVIxLu4w2" common_licensingservice_1:8080/v1/organizations/e254f8c-c442-4ebe-a82a-e2fc1d1ff78a/licenses/f3831f8c-c338-4ebe-a82a-e2fc1d1ff78a

//    curl -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJvcmdhbml6YXRpb25JZCI6IjQyZDNkNGY1LTlmMzMtNDJmNC04YWNhLWI3NTE5ZDZhZjFiYiIsInVzZXJfbmFtZSI6IndpbGxpYW0ud29vZHdhcmQiLCJzY29wZSI6WyJ3ZWJjbGllbnQiXSwiZXhwIjoxNjEyNjYyMTQ4LCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOIiwiUk9MRV9VU0VSIl0sImp0aSI6ImIwZjk1NDJiLTU5YTUtNGI5MC04MGRmLWNjNDdjYjAxMGIzNCIsImNsaWVudF9pZCI6ImVhZ2xlZXllIn0.SWeX66RdJhwd-IoxnTd-kKHa_xbh_nx0RjzVIxLu4wo" http://172.18.0.2:8901/auth/user
//    curl -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJvcmdhbml6YXRpb25JZCI6IjQyZDNkNGY1LTlmMzMtNDJmNC04YWNhLWI3NTE5ZDZhZjFiYiIsInVzZXJfbmFtZSI6IndpbGxpYW0ud29vZHdhcmQiLCJzY29wZSI6WyJ3ZWJjbGllbnQiXSwiZXhwIjoxNjEyNjYyMTQ4LCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOIiwiUk9MRV9VU0VSIl0sImp0aSI6ImIwZjk1NDJiLTU5YTUtNGI5MC04MGRmLWNjNDdjYjAxMGIzNCIsImNsaWVudF9pZCI6ImVhZ2xlZXllIn0.SWeX66RdJhwd-IoxnTd-kKHa_xbh_nx0RjzVIxLu4wo" http://172.18.0.2:8901/auth/user
//    curl -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJvcmdhbml6YXRpb25JZCI6IjQyZDNkNGY1LTlmMzMtNDJmNC04YWNhLWI3NTE5ZDZhZjFiYiIsInVzZXJfbmFtZSI6IndpbGxpYW0ud29vZHdhcmQiLCJzY29wZSI6WyJ3ZWJjbGllbnQiXSwiZXhwIjoxNjEyNjYyMTQ4LCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOIiwiUk9MRV9VU0VSIl0sImp0aSI6ImIwZjk1NDJiLTU5YTUtNGI5MC04MGRmLWNjNDdjYjAxMGIzNCIsImNsaWVudF9pZCI6ImVhZ2xlZXllIn0.SWeX66RdJhwd-IoxnTd-kKHa_xbh_nx0RjzVIxLu4wo" http://172.18.0.2:8901/auth/user
//    curl -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJvcmdhbml6YXRpb25JZCI6IjQyZDNkNGY1LTlmMzMtNDJmNC04YWNhLWI3NTE5ZDZhZjFiYiIsInVzZXJfbmFtZSI6IndpbGxpYW0ud29vZHdhcmQiLCJzY29wZSI6WyJ3ZWJjbGllbnQiXSwiZXhwIjoxNjEyNjYyMTQ4LCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOIiwiUk9MRV9VU0VSIl0sImp0aSI6ImIwZjk1NDJiLTU5YTUtNGI5MC04MGRmLWNjNDdjYjAxMGIzNCIsImNsaWVudF9pZCI6ImVhZ2xlZXllIn0.SWeX66RdJhwd-IoxnTd-kKHa_xbh_nx0RjzVIxLu4wo" http://172.18.0.2:8901/auth/user


    @RequestMapping(value = { "/user" }, produces = "application/json")
    public Map<String, Object> user(OAuth2Authentication user) {
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("user", user.getUserAuthentication().getPrincipal());
        userInfo.put("authorities", AuthorityUtils.authorityListToSet(user.getUserAuthentication().getAuthorities()));
        return userInfo;
    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
