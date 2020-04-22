package com.koo9.myspringboot.listener;


import java.util.Date;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

public class MyStartingMyListener implements ApplicationListener<ApplicationStartingEvent>{
	@Override
	public void onApplicationEvent(ApplicationStartingEvent event) {
		System.out.println("Spring Bean 컨테이너 생성에 호출됨 applicationStartion Event " + 
					new Date(event.getTimestamp()));
	}

}
