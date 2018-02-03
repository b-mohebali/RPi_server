package com.example.gpio.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

@RestController
@RequestMapping("/gpio")
public class WebController {
	@RequestMapping("/firstMethod")
	public String home() {
		return "Hello world!";
	}
	
	@RequestMapping("/blink")
	public String blink(@RequestParam(value="count", required=false, defaultValue="10") int count) {
		GpioController controller = GpioFactory.getInstance();
		JSONObject output = new JSONObject();
		final GpioPinDigitalOutput pin = controller.provisionDigitalOutputPin(RaspiPin.GPIO_08, "MyLED", PinState.HIGH);
		try {
			for(int i=0;i<count;i++) {
				pin.setState(PinState.HIGH);
				Thread.sleep(300);
				pin.setState(PinState.LOW);
				Thread.sleep(300);
				System.out.println("Loop variable: " + i);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		controller.shutdown();
		controller.unprovisionPin(pin);
		System.out.println("--> GPIO state should be: ON");
		try {
			output.put("status", "success");
			output.put("count", count);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return output.toString();
	}
	
}
