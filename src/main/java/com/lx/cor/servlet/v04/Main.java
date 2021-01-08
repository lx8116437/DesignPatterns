package com.lx.cor.servlet.v04;

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
    void doFilter(Request request, Response response, ChainFilter chainFilter);
}

class HTMLFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, ChainFilter chainFilter) {
        request.str = request.str.replaceAll("<", "[").replaceAll(">", "]") + "-----HTMLFilter()";
        chainFilter.doFilter(request, response);
        response.str += "--HTMLFilter()";
    }
}

class SensitiveFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, ChainFilter chainFilter) {
        request.str = request.str.replaceAll("996", "995") + "-----SensitiveFilter()";
        chainFilter.doFilter(request, response);
        response.str += "--SensitiveFilter()";
    }
}

class ChainFilter{

    List<Filter> filters = new ArrayList<>();
    int index = 0;

    public ChainFilter add(Filter f) {
        filters.add(f);
        return this;
    }

    public void doFilter(Request request, Response response) {
        if(index == filters.size()){
            return;
        }
        Filter f = filters.get(index);
        index++;

        f.doFilter(request, response, this);
    }
}
