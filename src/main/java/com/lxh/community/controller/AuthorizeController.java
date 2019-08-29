package com.lxh.community.controller;

import com.lxh.community.dto.AccessTokenDTO;
import com.lxh.community.dto.GitHubUser;
import com.lxh.community.mapper.UserMapper;
import com.lxh.community.model.User;
import com.lxh.community.provider.GitHubProvider;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author LXH
 * @date 2019/8/28 -10:11
 */
@Controller
public class AuthorizeController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    GitHubProvider gitHubProvider;
    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;
    @GetMapping("/callback")
    public String callBack(@RequestParam(value = "code") String code,
                           @RequestParam(value = "state" )String state,
                           HttpServletRequest request,
                           HttpServletResponse response){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_uri(redirectUri);
        String accessToken = gitHubProvider.getAccessToken(accessTokenDTO);
        GitHubUser gitHubUser = gitHubProvider.getUser(accessToken);

        if (gitHubUser!=null){
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setAccountId((gitHubUser.getId()));
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            if (userMapper.FindByAccountId(user.getAccountId())!=null){
                userMapper.updateToken(user);
                response.addCookie(new Cookie("token",token));
                return "redirect:/";
            }
            user.setName(gitHubUser.getName());
            user.setAvatar(gitHubUser.getAvatar_url());
            userMapper.insert(user);
            response.addCookie(new Cookie("token",token));
//            request.getSession().setAttribute("user",gitHubUser);
        }else {

        }
        return "redirect:/";
    }
}
