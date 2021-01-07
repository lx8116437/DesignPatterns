package com.lx.cor.servlet.v02;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Request request = new Request();
        request.str = request.str = "大家好:)，<script>，欢迎访问 mashibing.com ，大家都是996 ";
        Response response = new Response();
        response.str = "response";
        ChainFilter chainFilter = new ChainFilter();
        chainFilter.add(new HTMLFilter()).add(new SensitiveFilter());
        chainFilter.doFilter(request, response);
        System.out.println(request.str);
        System.out.println(response.str);
    }
}

class Request {
    String str;
}

class Response {
    String str;
}

interface Filter {
    boolean doFilter(Request request, Response response);
}

class HTMLFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response response) {
        request.str = request.str.replaceAll("<", "[").replaceAll(">", "]");
        response.str += "--HTMLFilter()";
        return true;
    }
}

class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Request request, Response response) {
        request.str = request.str.replaceAll("996", "995");
        response.str += "--SensitiveFilter()";
        return true;
    }
}

class ChainFilter implements Filter {

    List<Filter> filters = new ArrayList<>();

    public ChainFilter add(Filter f) {
        filters.add(f);
        return this;
    }

    @Override
    public boolean doFilter(Request request, Response response) {
        for (Filter f : filters) {
            f.doFilter(request, response);
        }
        return true;
    }
}
