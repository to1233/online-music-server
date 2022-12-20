package com.example.demo.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.base.BaseKuwoService;
import org.springframework.stereotype.Service;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/10/30 10:20
 * @Description
 */
@Service
public class KuwoSingerServiceImpl extends BaseKuwoService {


    public JSONObject findSingerDetailById(String artistid) {
        String aimUrl = "http://www.kuwo.cn/api/www/artist/artist?artistid="+artistid+"&httpsStatus=1&reqId=499a9a30-57fb-11ed-93fa-8dc3aecc7e24";
        return sendKuWoRequestJSON(aimUrl);
    }

    public JSONObject findSingerMusicById(String artistid) {
        String aimUrl = "http://www.kuwo.cn/api/www/artist/artistMusic?artistid="+artistid+"&pn=1&rn=30&httpsStatus=1&reqId=49b945c0-57fb-11ed-93fa-8dc3aecc7e24";
        return sendKuWoRequestJSON(aimUrl);
    }
}
