package com.ch.wchya.study.sptboot.provider;

import com.ch.wchya.study.sptboot.dto.EmailDTO;
import okhttp3.*;
import org.springframework.stereotype.Component;

/**
 * @program: spt-boot
 * @description:
 * @author: 王超
 * @create: 2020-05-25 15:54
 **/
@Component
public class PostMailProvider {

    public String sendMail (String post, String res, String userId, String name) {
        String token = "eyJhbGciOiJSU0EtT0FFUC0yNTYiLCJlbmMiOiJBMTI4R0NNIn0.Q6hwUOyQTyWLSH9KSG1tSoWDxYJxxjWYRHjqqYNCHMjUf4voFvyPewsJi9bb6SxyiyY2wtILbdeh5gcs7bh4bf4rc7YN3fIdNFllU7KG4Add2EbiIwC38gA58t5I-7FprQZnP4NwNhwAzV5hHW_8hudLknwOada5rPn1ayhOm-4.XBFFkk1xPw_1Fvsy.-EdOhJZej5j8ZU1Spd6-2PYNegJsau3sLMC_3bfCPADUTNcRWBuK6G6422c2Ht0qssnTZl5LnLmbIDOSk2N1DBWvpbkIt__nlAQ0rV38kEIjdItDcfy0T97iM4wygvvNP-TL-mx-hqIenZl-umnLy5qVfwc6roMyZTi-VbA_Ta9RDh28YTdQ-w5jbILC1LGpaMNMQMvG2j86IJ1SksnE41x9fsIHWfLlMpsX8Rs-_tUcUhewbdC0cz1JQwpQtwvD5PVx4l_giHh5Y4UwkAKV46SvaZ1D34mBLdCIS5UMIa1d2TaYzUFxSkuTBQftwkK42cJA5cy-eNM0f2RIZRoqpZD6Pvsz0rpFhcCNpovLNXgkd_jtFw4oM1m2j_qyDQ78EVDGs3Y2zWP34bMyZc7_oKGWx6gY-MGIWmESXX4Cr_ZJ0MXFrIYLaWQRHQ44Y85rtcbdEy-ydcpOXnASe47IylQQIUETBefKyptnCIVKrnJFxFZAKF_Ocx5RHD_uKInefgWQMttMB6Oak3Ce2RXmqSJa5fDv80KXlh0ZSCyMzT_0crEzWnM7rVGJz7h_BOMaXGSiNgnGLlYkaIquyQkEn5uF3Gss7z5XQGZZ1mxqidZ-0_ci5JMXQ6qI5Hm7-uOFCyDEqklKU9ojJ3Cra-4sT65CVSMssNckgDJMVHDtesx1tSOlbK9iwuM-rD9KOJm0hxPxtEd1dCv7ROg9UrKlLUFZfp2gAJY9ja-s9QI7VFQ0dO5X1_1PwPgEk_6juLTmjEQjPbMuf5u3cpYwPGMm_rrcnabnB331xIURVMOSWPFEmaeTGYNt2_u01h50fnxcW_oRRobPncMVlpBH4ghw3e9Jz6M1bLZM1nWABH6tL1hR6bxFw6E2fYrBovVew46A-543mYQA6xJ82nUmXSHA7JiI0lNbIbu9uz2z1U0oRIERVgq5C1ZkoG-7khfteta2UpGs40kwk4Fj3NmdtcHcKZvKL8dtJIG2zwwtQEAA6iciP74Bo2X0Y4t759AunKtiasNsOzHXWO2B_hVSInhOvrrNtL1KqdvJAQ66wDPbdydKAbefy0uXcqkLrJi1taGSXV5sGKgJ1Zwkj67yvJ5DmxCBAb05HwPUYGz0ng3kQxsYZSwax2jSuhF_KNzjX40jFrOSMX4rJxmOyhirNkNcllTcCqYabVoEcMbAwvkGcRC7vVoJIBoKdw69hlYz2PjOESwcwYRuX_qXFuX1Knms8Nf01f7Q7qHjyxi8uIVe8ovex6SbssksjurUZ3KCzcYoO3P50L_qlWZXdezc4kholEcQ5sQDFZ1oUIYPxCar0Y4F3WBpmWP-P0KTTdQzMqVIO0nsLC2tRGn0zdGpbaQl_Cj6lMRO47CPueyC92Wp_FdwsLwehjANnIflNX9hG7MjW-_aoy2gR0SIeCePmvCFQGtpIcOd_RLPwOIPJ_rcsgQ36kUuG_UzwWm5eWKCMOLjNmwIp2vwklE90loCnONcV2gudOnh-1uRKO1FSIc-QY1qgewiWidJ7SgUXg4KEahFSQBiJIEsH9vlcoxIBi7TrGJelsMiR62_Jb67No225bhlWclZ2BkVzW7Y.LtJ6xuSy3WXhP0fcohEDIg|topDeptId=ff808081389aa60301389ac3109e0068|topDeptName=%E8%BD%AF%E4%BB%B6%E4%BA%8B%E4%B8%9A%E9%83%A8|postName=%E7%A7%91%E5%91%98";

        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setUserId(userId);
        emailDTO.setUserrName(name);
        emailDTO.setPerformanceResult(res);
        emailDTO.setPost(post);
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");


        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("http://10.18.27.56:7777/app-userinfo/api/postSalary/sendEntryOaMail?userId="+userId+"&userName="+name+"&performanceResult="+res+"&post="+post)
                .addHeader("Authorization", token)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
