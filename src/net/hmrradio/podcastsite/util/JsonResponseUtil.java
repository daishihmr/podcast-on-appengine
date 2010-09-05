package net.hmrradio.podcastsite.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.hmrradio.podcastsite.bean.ResultBean;
import net.hmrradio.podcastsite.define.AttrName;

import org.slim3.controller.validator.Errors;

import com.google.common.collect.Maps;

public class JsonResponseUtil {

    public static Object jsonResponse(HttpServletRequest request, Object bean) {
        if (bean == null) {
            bean = new ResultBean(true);
        } else if (bean instanceof Object[] || bean instanceof Iterable) {
            Map<String, Object> map = Maps.newHashMap();
            map.put("list", bean);
            ResultBean wrapper = new ResultBean(true);
            wrapper.setBody(map);
            bean = wrapper;
        } else if (bean instanceof ResultBean == false) {
            ResultBean wrapper = new ResultBean(true);
            wrapper.setBody(bean);
            bean = wrapper;
        }
        request.setAttribute(AttrName.RESULT_JSON, bean);
        return bean;
    }

    public static Object jsonSuccess(HttpServletRequest request) {
        ResultBean result = new ResultBean(true);
        return jsonResponse(request, result);
    }

    public static Object jsonError(HttpServletRequest request, Errors errors) {
        ResultBean result = new ResultBean(false);
        result.getMessages().addAll(errors.values());
        return jsonResponse(request, result);
    }

    public static Object jsonError(HttpServletRequest request, String message) {
        ResultBean result = new ResultBean(false);
        result.getMessages().add(message);
        return jsonResponse(request, result);
    }

}
