package com.ch.wchya.study.sptboot.provider;

import com.alibaba.fastjson.JSON;
import com.ch.wchya.study.sptboot.dto.AccessTokenDTO;
import com.ch.wchya.study.sptboot.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @program: spt-boot
 * @description: GitHub 相关方法的提供者
 * @author: 王超
 * @create: 2020-05-24 23:05
 **/
@Component
public class GithubProvider {

    /**
     * 获取用户 token
     * @param accessTokenDTO 用户 token 对象
     * @return 获取的token
     */
    public String getAccessToken(AccessTokenDTO accessTokenDTO) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            // access_token=6df5f1773b0d16e2611f848eac809145c03369f8&scope=user&token_type=bearer
            String string = response.body().string();
            String token = string.split("&")[0].split("=")[1];
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取 github 用户信息
     * @param accessToken 获取的 token
     * @return 用户信息
     */
    public GithubUser getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + accessToken)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
