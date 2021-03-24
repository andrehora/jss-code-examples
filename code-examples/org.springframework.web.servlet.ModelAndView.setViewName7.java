@RequestMapping("/multipleChoiceResult")
public ModelAndView multipleChoiceResult(ModelAndView mav, int questionNo, String answer) throws SQLException {

	System.out.println("questionNo:" + questionNo);
	System.out.println("answer:" + answer);
	int result = questionService.checkAnswer(questionNo, answer);
	boolean resultBoolean=false;
	if(result!=0) resultBoolean=true;
	mav.addObject("result", resultBoolean);

	mav.addObject("questionNo", questionNo);
	mav.addObject("multipleChoice", "multipleChoice");
	mav.setViewName("/question/general/generalResult");

	return mav;
}