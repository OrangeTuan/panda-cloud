package com.example.apigeteway.Filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;

/**
 *  创建处理postRoute过程的异常
 */
public class ErrorExtFilter extends SendErrorFilter {
    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 30;  //>ErrorFilter的值
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        ZuulFilter failerFilter = (ZuulFilter) ctx.get("failed.filter");
        if (failerFilter != null && failerFilter.filterType().equals("post")) {
            return true;
        }
        return false;
    }

    @Override
    public Object run() {
        return super.run();
    }
}
