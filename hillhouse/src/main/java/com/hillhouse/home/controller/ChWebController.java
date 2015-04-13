package com.hillhouse.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hillhouse.home.base.LanguageModel.Language;

@RequestMapping("/ch")
@Controller
public class ChWebController extends WebController {
	public ChWebController() {
		language=Language.CH;
		basePath="ch/";
	}
}
