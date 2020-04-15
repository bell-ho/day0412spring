package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVo;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
//BoardController는 BoardService에 대해서 의존적이므로 
//@AllArgsConstructor를 이용해서 생성자를 만들고 자동으로 주입
//(만일 생성자를 만들지 않을 경우 에는 @Setter(onMethod. = { @Autowired })를 이용
public class BoardController {
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list");
		
		model.addAttribute("list",service.getList());
		//list( )는 나중에 게시물의 목록을 전달해야 하므로 Model을 파라미터로 지정하고，
		//이를 통해서 BoardServiceImpl 객체의 getList( ) 결과를 담아 전달합니다(addAttribute). 
		//BoardController 테스트는 스프링의 테스트 기능을 통해서 확인해 볼 수 있습니다. 
	}
	
	@PostMapping("/register")
	public String register(BoardVo board, RedirectAttributes rttr) {
		//RedirectAttributes를 파라미터로 지정 , 등록 작업이 끝난 후 다시 목록 화면으로 가기 위함
		log.info("register: "+board);
		
		service.register(board);
		rttr.addFlashAttribute("result",board.getBno());
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("bno")Long bno , Model model) {
		
		log.info("/get or modify");
		model.addAttribute("board",service.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVo board, RedirectAttributes rttr) {
		System.out.println("1");
		log.info("modify:"+board);
		System.out.println(board);
		if(service.modify(board)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/board/list";
	}
	@PostMapping("/remove")
	public String remove(@RequestParam("bno")Long bno,RedirectAttributes rttr) {
		log.info("remove..." + bno);
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/board/list";
	}
}
