package com.denovo.Listeners;

import com.denovo.Util.ExcelUtils;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MethodInterceptor implements IMethodInterceptor {

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext iTestContext) {

        List<Map<String, String>>list = ExcelUtils.getTestDetails();
       // System.out.println(list);
        List<IMethodInstance> result = new ArrayList<>();
        System.out.println(methods);

        for(int i=0;i<methods.size();i++){
            for (int j=0;j<list.size();j++){
                System.out.println(methods.get(i).getMethod().getMethodName());
                System.out.println(list.get(j).get("TestName"));
                if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("TestName"))){
                    if(list.get(j).get("Execute").equalsIgnoreCase("Yes")) {
                        methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("Count")));
                        result.add(methods.get(i));
                    }
                }
            }
        }
        return result;
    }
}