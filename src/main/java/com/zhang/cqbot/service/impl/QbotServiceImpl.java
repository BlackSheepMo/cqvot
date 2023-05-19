package com.zhang.cqbot.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zhang.cqbot.service.QbotService;
import com.zhang.cqbot.utils.HttpRequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;


@Slf4j
@Service
public class QbotServiceImpl implements QbotService {

    @Override
    public void QqRobotEvenHandle(HttpServletRequest request) {
        JSONObject jsonParam = this.getJSONParam(request);
        log.info("接收参数:{}"+jsonParam.toString()!=null?"成功":"失败");
        if("message".equals(jsonParam.getString("post_type"))){
            String message = jsonParam.getString("message");
            if("你好".equals(message)){
                // user_id 为QQ好友QQ号
                String url = "http://127.0.0.1:5700/send_private_msg?user_id=xxxxx&message=你好~";
                String result = HttpRequestUtil.deGet(url);
                log.info("发送成功:==>{}",result);
            }
        }
    }

    public JSONObject getJSONParam(HttpServletRequest request){
        JSONObject jsonParam = null;
        try {
            // 获取输入流
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));

            // 数据写入Stringbuilder
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = streamReader.readLine()) != null) {
                sb.append(line);
            }
            jsonParam = JSONObject.parseObject(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonParam;
    }
}
