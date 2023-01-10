package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.demo.modle.DeviceIdCompanyInfo;
import com.example.demo.modle.SchoolOrder;
import com.example.demo.service.EquipmentService;
import com.example.demo.service.HuNanDataService;
import com.example.demo.util.HttpUtils;
import com.example.demo.util.KamUtil;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.alibaba.fastjson.JSON;
import org.springframework.web.cors.CorsConfiguration;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ChrisGaike
 * @Date: 2022/08/06/14:17
 * @Description:
 */
@WebFilter(filterName = "CorsFilter ")
@Configuration
@RestController
@RequestMapping(value = "/hunan")
public class HuNanDataController implements Filter {
    private static Logger logger = Logger.getLogger(testController.class);

    @Resource
    private HuNanDataService huNanDataService;


    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PATCH, DELETE, PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        chain.doFilter(req, res);
    }


//    @Bean
//    public CorsFilter corsFilter() {
//        final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
//        final CorsConfiguration corsConfiguration = new CorsConfiguration();
//        /*是否允许请求带有验证信息*/
//        corsConfiguration.setAllowCredentials(true);
//        /*springboot 2.4 之后需要注释 允许访问的客户端域名*/
//        //corsConfiguration.addAllowedOrigin("*");
//        /*springboot 2.4 之后需要增加 允许任何来源*/
//        corsConfiguration.setAllowedOriginPatterns(Collections.singletonList("*"));
//        /*允许服务端访问的客户端请求头*/
//        corsConfiguration.addAllowedHeader("*");
//        /*允许访问的方法名,GET POST等*/
//        corsConfiguration.addAllowedMethod("*");
//        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
//        return new CorsFilter(urlBasedCorsConfigurationSource);
//    }

    /**
     * 对比查询
     */
    @RequestMapping(value = "/findAllDataLists", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String findAllDataLists(SchoolOrder schoolOrder, String pager) {

        try {
            //湘数请求的数据
            String url_xs = "http://175.6.144.99:6203/hnxs/getInfo/querryVmeid";
            Map<String, Object> map_xs = new HashMap<>();
            map_xs.put("username", "huida");
            map_xs.put("password", "xs123456");
            map_xs.put("vmeid", "所有县");
            map_xs.put("startTime", "2022-01-01");
            map_xs.put("endTime", "2022-12-31");
            map_xs.put("count", "区县总数");
            map_xs.put("factory", "黑龙江惠达科技发展有限公司");
            JSON.toJSON(map_xs);
            String result = HttpUtils.sendPost2(url_xs, JSON.toJSON(map_xs).toString());
            JSON data = JSON.parseObject(result);
            JSONObject dataarray = JSONObject.fromObject(data);
//            JSONObject Data = JSONObject.fromObject(dataarray.get("msg"));
            JSONArray jobdetaillst = JSONArray.parseArray(dataarray.get("msg").toString());
//            System.out.println(jobdetaillst);

            //派得县级请求的数据
            Map<String, Object> map_all_pdxj = new HashMap<>();
            Map<String, Object> map_pd = new HashMap<>();
            map_pd.put("vmeid", "");
            map_pd.put("typecode", 0);
            map_pd.put("date", "2022-01-01,2022-12-31");
            map_all_pdxj.put("par", map_pd);
            String url_pdxj = "http://www.amtiot.cn/136/amtiot.api/jzzyservice.svc/SearchVehicleJob/huida/huida";

            String param = HttpUtils.sendPost2(url_pdxj, JSON.toJSONString(map_all_pdxj));
            JSON data_pdxj = JSON.parseObject(param);
            JSONObject dataarray_pdxj = JSONObject.fromObject(data_pdxj);
            JSONObject Data_pdxj = JSONObject.fromObject(dataarray_pdxj.get("Data"));
            JSONArray jobdetaillst_pdxj = JSONArray.parseArray(Data_pdxj.get("qxArealst").toString());

            //派得省平台
            Map<String, Object> map_all_sheng = new HashMap<>();
            Map<String, Object> map_pd_sheng = new HashMap<>();
            map_pd_sheng.put("vmeid", "");
            map_pd_sheng.put("typecode", 0);
            map_pd_sheng.put("date", "2022-01-01,2022-12-31");
            map_all_sheng.put("par", map_pd_sheng);
            String url_pds = "http://113.246.57.43:8084/amtiot.api/jzzyservice.svc/SearchVehicleJob/huida/huida";

            String param_sheng = HttpUtils.sendPost2(url_pds, JSON.toJSONString(map_all_sheng));
            JSON map_all_s = JSON.parseObject(param_sheng);
            JSONObject dataarray_pds = JSONObject.fromObject(map_all_s);
            JSONObject Data_pd_s = JSONObject.fromObject(dataarray_pds.get("Data"));
            JSONArray jobdetaillst_pds = JSONArray.parseArray(Data_pd_s.get("qxArealst").toString());

            //博创
            List<Map<String, Object>> list_bc = huNanDataService.findBochuangByLists();
//            JSONArray array_bc = JSONArray.parseArray(JSON.toJSONString(list_bc));

            //江苏北斗
            Map<String, Object> map_jsbd = new HashMap<>();
            Map<String, Object> map_jsbd_bd = new HashMap<>();
            map_jsbd_bd.put("account", "xiantanhddj");
            map_jsbd_bd.put("password", "123456");
            map_jsbd_bd.put("deviceId", "");
            map_jsbd_bd.put("typecode", 2);
            map_jsbd_bd.put("date", "2022-01-01,2022-12-31");
            map_jsbd.put("par", map_jsbd_bd);
            String url_jsbd = "http://58.213.150.69:16789/agri-api/job/queryHuNanWorkInfo";

            String param_jsbd = HttpUtils.sendPost2(url_jsbd, JSON.toJSONString(map_jsbd));
            JSON map_jsbd_s = JSON.parseObject(param_jsbd);
            JSONObject dataarray_jsbd = JSONObject.fromObject(map_jsbd_s);
            JSONObject Data_jsbd_s = JSONObject.fromObject(dataarray_jsbd.get("data"));
            JSONArray jobdetaillst_jsbd = JSONArray.parseArray(Data_jsbd_s.get("qxArealst").toString());


            //湘数
            List<Map<String, Object>> list = huNanDataService.findAllDataLists();
            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> map1 = list.get(i);
                String country = map1.get("county").toString();
                String areaVaild = map1.get("areaVaild").toString();
                Double areaVaild_hd = Double.parseDouble(areaVaild);
                Double jobArea;
                //湘数
                for (int j = 0; j < jobdetaillst.size(); j++) {
                    jobdetaillst.get(j);
                    JSONObject jsons = JSONObject.fromObject(jobdetaillst.get(j));
                    jsons.get("county");
                    String ccc = jsons.get("county").toString();
//                    System.out.println(ccc);
                    String ddd = jsons.get("jobArea").toString();
                    jobArea = Double.parseDouble(ddd);
                    Double minus = areaVaild_hd - jobArea;
                    minus = (double) Math.round(minus * 100) / 100.0;
//                    System.out.println(ccc);
//                    System.out.println(jobdetaillst.get(j));
                    if (country.contains(ccc)) {
                        map1.put("areaVaild_other", ddd);
                        map1.put("minus", minus);
                        map1.put("company", "湘数");

                    }
                    if (country.contains("西洞庭区") && ccc.contains("西洞庭管理区")) {
                        map1.put("areaVaild_other", ddd);
                        map1.put("minus", minus);
                        map1.put("company", "湘数");
                    }
                }

                //派得 县
                for (int j = 0; j < jobdetaillst_pdxj.size(); j++) {
                    jobdetaillst_pdxj.get(j);
                    JSONObject jsons = JSONObject.fromObject(jobdetaillst_pdxj.get(j));
                    String county_pdxj = jsons.get("countyname").toString();
                    String areaValid_pdxj = jsons.get("area").toString();
                    jobArea = Double.parseDouble(areaValid_pdxj);
                    Double minus = areaVaild_hd - jobArea;
                    minus = (double) Math.round(minus * 100) / 100.0;

                    if (country.contains(county_pdxj)) {
                        map1.put("areaVaild_other", areaValid_pdxj);
                        map1.put("minus", minus);
                        map1.put("company", "派得县级");
                    }
                }

                //博创
                for (int j = 0; j < list_bc.size(); j++) {
//                    JSONObject jsons = JSONObject.fromObject(array_bc.get(j));
                    Map<String, Object> map_bc = list_bc.get(j);
                    String county_bc = map_bc.get("county").toString();
                    String areaValid_bc = map_bc.get("areaVaild").toString();
                    jobArea = Double.parseDouble(areaValid_bc);
                    Double minus = areaVaild_hd - jobArea;
                    minus = (double) Math.round(minus * 100) / 100.0;

                    if (country.contains(county_bc)) {
                        map1.put("areaVaild_other", areaValid_bc);
                        map1.put("minus", minus);
                        map1.put("company", "博创");
                    }
                    if (country.contains("宁乡市") && county_bc.contains("宁乡县")) {
                        map1.put("areaVaild_other", areaValid_bc);
                        map1.put("minus", minus);
                        map1.put("company", "博创");
                    }
                }


                //派得省
                for (int j = 0; j < jobdetaillst_pds.size(); j++) {
                    jobdetaillst_pds.get(j);
                    JSONObject jsons = JSONObject.fromObject(jobdetaillst_pds.get(j));
                    String county_pdxj = jsons.get("countyname").toString();
                    String areaValid_pdxj = jsons.get("area").toString();
                    jobArea = Double.parseDouble(areaValid_pdxj);
                    Double minus = areaVaild_hd - jobArea;
                    minus = (double) Math.round(minus * 100) / 100.0;

                    if (country.contains(county_pdxj)) {
                        map1.put("areaVaild_other", areaValid_pdxj);
                        map1.put("minus", minus);
                        map1.put("company", "派得省级");
                    }
                }

                //江苏北斗
                for (int j = 0; j < jobdetaillst_jsbd.size(); j++) {
                    jobdetaillst_jsbd.get(j);
                    JSONObject jsons = JSONObject.fromObject(jobdetaillst_jsbd.get(j));
                    String county_jsbd = jsons.get("countyname").toString();
                    String areaValid_jsbd = jsons.get("area").toString();
                    jobArea = Double.parseDouble(areaValid_jsbd);
                    Double minus = areaVaild_hd - jobArea;
                    minus = (double) Math.round(minus * 100) / 100.0;

                    if (country.contains(county_jsbd)) {
                        map1.put("areaVaild_other", areaValid_jsbd);
                        map1.put("minus", minus);
                        map1.put("company", "江苏北斗");
                    }
                }


            }


            return KamUtil.returnSuccess(list);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return KamUtil.returnError();
        }
    }


    /**
     * 批量插入厂商设备号
     */
    @RequestMapping(value = "/insertdevicecompany", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String insertDeviceCompany(DeviceIdCompanyInfo deviceIdCompanyInfo) {
        try {

            int flag_c = huNanDataService.countDeviceId(deviceIdCompanyInfo);
            if (flag_c == 0) {
                int flag = huNanDataService.insertDeviceIdCompany(deviceIdCompanyInfo);
                return KamUtil.returnSuccess();
            }
            return KamUtil.returnError("已添加");
        } catch (Exception e) {
            e.printStackTrace();
            return KamUtil.returnError();
        }
    }


}
