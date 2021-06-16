package com.realtimeodd.common.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LiveEventResponse {

	protected List<LiveEvent> liveEvents = new ArrayList<>();

	protected Group group;

	public LiveEventResponse() {
		super();
	}

	public List<LiveEvent> getLiveEvents() {
		return liveEvents;
	}

	public void setLiveEvents(List<LiveEvent> liveEvents) {
		this.liveEvents = liveEvents;
	}

	public Group getGroup() {
		return group;
	}

}
