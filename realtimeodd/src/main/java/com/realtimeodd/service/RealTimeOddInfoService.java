package com.realtimeodd.service;

import java.io.IOException;

import com.realtimeodd.common.model.LiveEventResponse;

public interface RealTimeOddInfoService {
	LiveEventResponse getLiveEvent() throws IOException;
}
