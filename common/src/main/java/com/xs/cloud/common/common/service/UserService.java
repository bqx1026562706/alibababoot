package com.xs.cloud.common.common.service;

import com.xs.cloud.common.common.pojo.EsUserResponse;

import java.util.List;
import java.util.Map;

public interface UserService {


    List<Map> testCity();

    List<EsUserResponse> esSelectUser();
}
