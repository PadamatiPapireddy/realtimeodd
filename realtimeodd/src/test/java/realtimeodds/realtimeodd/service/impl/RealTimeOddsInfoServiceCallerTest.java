package realtimeodds.realtimeodd.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.realtimeodd.common.model.Event;
import com.realtimeodd.common.model.LiveEvent;
import com.realtimeodd.common.model.LiveEventResponse;
import com.realtimeodd.service.impl.RealTimeOddsInfoServiceCaller;

/**
 * 
 * Provides the operations to run the test cases for Real Time Odds.
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class RealTimeOddsInfoServiceCallerTest {

	@InjectMocks
	private RealTimeOddsInfoServiceCaller realTimeOddsInfoServiceCaller;
	@Mock
	private ObjectMapper objectMapper;

	/**
	 * Test case to verify when event Id matches.
	 * 
	 * @throws Exception throws the exception if any issue occurs.
	 */
	@Test
	public void verifyGetLiveEvent_when_eventid_match() throws Exception {

		LiveEventResponse mockLiveEventResponse = new LiveEventResponse();
		List<LiveEvent> liveEvents = new ArrayList<>();

		Long eventId = 12345L;

		LiveEvent liveEvent = new LiveEvent();
		Event event = new Event();
		event.setId(eventId);
		liveEvent.setEvent(event);
		liveEvents.add(liveEvent);
		mockLiveEventResponse.setLiveEvents(liveEvents);

		Mockito.doReturn(mockLiveEventResponse).when(objectMapper).readValue(Mockito.any(URL.class),
				Mockito.eq(LiveEventResponse.class));

		LiveEventResponse actualLiveEventResponse = realTimeOddsInfoServiceCaller.getLiveEvent();

		assertEquals(eventId, actualLiveEventResponse.getLiveEvents().get(0).getEvent().getId());
		Mockito.verify(objectMapper, Mockito.only()).readValue(Mockito.any(URL.class),
				Mockito.eq(LiveEventResponse.class));

	}

	/**
	 * Test case to verify when event Id not matches.
	 * 
	 * @throws Exception throws the exception if any issue occurs.
	 */
	@Test
	public void verifyGetLiveEvent_when_eventid_not_match() throws Exception {

		LiveEventResponse mockLiveEventResponse = new LiveEventResponse();
		List<LiveEvent> liveEvents = new ArrayList<>();

		Long actualEventId = 12345L;
		Long unexpectedEventId = 1234L;

		LiveEvent liveEvent = new LiveEvent();
		Event event = new Event();
		event.setId(actualEventId);
		liveEvent.setEvent(event);
		liveEvents.add(liveEvent);
		mockLiveEventResponse.setLiveEvents(liveEvents);

		Mockito.doReturn(mockLiveEventResponse).when(objectMapper).readValue(Mockito.any(URL.class),
				Mockito.eq(LiveEventResponse.class));

		LiveEventResponse actualLiveEventResponse = realTimeOddsInfoServiceCaller.getLiveEvent();

		assertNotEquals(unexpectedEventId, actualLiveEventResponse.getLiveEvents().get(0).getEvent().getId());
		Mockito.verify(objectMapper, Mockito.only()).readValue(Mockito.any(URL.class),
				Mockito.eq(LiveEventResponse.class));

	}

}