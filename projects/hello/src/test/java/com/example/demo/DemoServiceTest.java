package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
public class DemoServiceTest {



    @Test
    public void test() {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);

        // String retCode = (String) request.getAttribute("retCode");
        String retCode = "0";
        doReturn(retCode).when(request).getAttribute("retCode");

        DemoService service = new DemoService();
        Assert.assertEquals(service.tryIt(request), true);

    }

}