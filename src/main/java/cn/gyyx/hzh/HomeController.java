package cn.gyyx.hzh;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.gyyx.hzh.model.GameInfo;
import cn.gyyx.hzh.model.ServerInfo;
import cn.gyyx.hzh.dal.GameDal;
import cn.gyyx.hzh.dal.ServerDal;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private GameDal gameDal;
	private ServerDal serverDal;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = 
				DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/GetForList", method = RequestMethod.GET)
	public String GetForList(Model model)
	{   
		gameDal = new GameDal();
		List<GameInfo> list =gameDal.queryList();
		model.addAttribute("gameList",list);
		return "list";			
	}
	
	/*
	 * 根据游戏ID获取区服列表
	 */
	@RequestMapping(value = "/getServerList", method = RequestMethod.GET)
	public @ResponseBody List<ServerInfo> getServerList(
			@RequestParam("gameId") int gameId) {
		serverDal = new ServerDal();
		List<ServerInfo> list = serverDal.queryListByGameId(gameId);
		return list;
	}
	
	
}
