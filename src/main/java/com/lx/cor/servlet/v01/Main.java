package com.lx.cor.servlet.v01;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // 大家好:)，[script]，欢迎访问 mashibing.com ，大家都是955
    public static void main(String[] args) {
        Request request = new Request();
        request.str = "大家好:)，<script>，欢迎访问 mashibing.com ，大家都是996 ";

        Response response = new Response();
        response.str = "";

        FilterChain filterChain = new FilterChain();
        filterChain.add(new HTMLFilter()).add(new SensitiveFilter());
        filterChain.doFilter(request, response);
        System.out.println(request.str);

    }
}

interface Filter{
    boolean doFilter(Request request, Response response);
}

class HTMLFilter implements Filter{

    @Override
    public boolean doFilter(Request request, Response response) {
        request.str = request.str.replaceAll("<", "[").replaceAll(">", "]");
        return true;
    }
}

class SensitiveFilter implements Filter{

    @Override
    public boolean doFilter(Request request, Response response) {
        request.str = request.str.replaceAll("996", "995");
        return true;
    }
}

class FilterChain implements Filter {
    List<Filter> filters = new ArrayList<>();

    public FilterChain add(Filter f){
        filters.add(f);
        return this;
    }

    @Override
    public boolean doFilter(Request request, Response response) {
        for(Filter f : filters){
            f.doFilter(request, response);
        }
        return true;
    }
}

class Request{
    String str;
}


class Response{
    String str;
}

