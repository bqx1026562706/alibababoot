package com.xs.cloud.common.common.controller;

import com.xs.cloud.common.common.pojo.EsUserResponse;
import com.xs.cloud.common.common.service.UserService;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private UserService userService;


    /**
     * es查询 没数据，写法放在这
     * @return
     */
    @GetMapping("/esSelectUser")
    public  List<EsUserResponse> esSelectUser(){
        List<EsUserResponse> list =  userService.esSelectUser();
        return list;
    }


    public static void main(String[] args) {
        int[] a= {1,2,8,9};

        int i = searchInsert(a, 5);
        System.out.println(i);
    }

    public static void helper(char[] s, int left, int right) {
        if (left >= right) return;
        char tmp = s[left];
        s[left++] = s[right];
        s[right--] = tmp;
        helper(s, left, right);
    }

    public  static void reverseString2(char[] s) {
        // 获取前后位置
        int start = 0, end = s.length - 1;
        while (start < end) {
            // 前后位置交换
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            // 更新前后坐标
            start++;
            end--;
        }

    }

    /**
     * 二分查询
     */
        public static int searchInsert(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while(left <= right) {
                int mid = (left + right) / 2;
                if(nums[mid] == target) {
                    return mid;
                } else if(nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }




    public void reverseString(char[] s) {
        helper(s, 0, s.length - 1);
    }

    @GetMapping("/hello")
    public  List<Map> testCity(){
     List<Map> cityList =   userService.testCity();

        return cityList;
    }




}
