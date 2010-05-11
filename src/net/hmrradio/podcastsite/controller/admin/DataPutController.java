package net.hmrradio.podcastsite.controller.admin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import net.hmrradio.podcastsite.controller.BaseController;

import org.slim3.controller.Navigation;

import com.google.appengine.repackaged.com.google.common.collect.Lists;

public class DataPutController extends BaseController {

    public DataPutController() {
        necessaryLoggedIn = false;
    }

    @Override
    protected Navigation exec() throws Exception {
        List<Object> list = Lists.newArrayList();

        File folder = new File("data");
        String[] filelist = folder.list();

        StringBuffer sb = new StringBuffer();
        for (String filename : filelist) {
            sb = new StringBuffer();
            BufferedReader in =
                new BufferedReader(new FileReader("data/" + filename));
            String s = null;
            while ((s = in.readLine()) != null) {
                sb.append(s + "\n");
            }
        }

        response.setContentType("text/plain;charset=utf-8");
        response.getWriter().print(sb.toString());
        return null;
    }

}
