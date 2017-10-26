
package serg.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import serg.basicClasses.Answer;
import serg.basicClasses.Question;
import serg.basicClasses.Test;
import serg.basicClasses.User;
import serg.service.AnswerService;
import serg.service.QuestionService;
import serg.service.TestService;
import serg.service.UserService;


@Controller
public class AdminController {
    
    @Autowired
    UserService userService;
    @Autowired
    TestService testService;
    @Autowired
    QuestionService questionService;
    @Autowired
    AnswerService answerService;
    
    @RequestMapping(value = {"/add-test"}, method = RequestMethod.GET)
    public ModelAndView addTestForn(ModelMap model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("test", new Test());
        modelAndView.setViewName("addTest");
        return modelAndView;
    }
    
    @RequestMapping(value="/save-test", method = RequestMethod.POST)
    public String addTest(@ModelAttribute("test") @Valid Test test, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "addTest";
        }
        
        testService.addTest(test);
        model.addAttribute("test", test);
	return "addTestSuccess";
    }
    
    @RequestMapping(value="/del-test", method=RequestMethod.GET)
    public String deleteTestForm(ModelMap model){
        List<Test> tests = testService.getTests();
        if(!tests.isEmpty()){
            model.addAttribute("tests", tests);
            return "deleteTest";
        }
        return "adminAnyTest";
    }
    
    @RequestMapping(value="/remove-test", method=RequestMethod.POST)
    public String deleteTest(ModelMap model, WebRequest webRequest){
        String testsId[] = webRequest.getParameterValues("testId");
        
        if(testsId.length!=0){
            for(int i=0; i<testsId.length; i++){
                testService.removeTest(Integer.valueOf(testsId[i]));
            }
            return "deleteTestSuccess";
        }
        return "incorrectChoise";
    }
    
    @RequestMapping(value="/add-quest", method=RequestMethod.GET)
    public String addTestForQuest(ModelMap model){
        List<Test> tests = testService.getTests();
        if(!tests.isEmpty()){
            model.addAttribute("tests", tests);
            return "adminChooseTest";
        }
        return "adminAnyTest";
    }
    
    @RequestMapping(value="/add-quest2", method=RequestMethod.POST)
    public ModelAndView addQuestForm(ModelMap model, WebRequest webRequest){
        Integer id = Integer.valueOf(webRequest.getParameter("testId"));
        Test test = testService.getTestById(id);
        
        ModelAndView modelAndView = new ModelAndView();
        Question question = new Question();
        question.setTest(test);
        modelAndView.addObject("question", question);
        modelAndView.setViewName("addQuestion");
        return modelAndView;
    }
    
    @RequestMapping(value="/choose-ans", method = RequestMethod.POST)
    public String addQuestion(@ModelAttribute("question") @Valid Question question, BindingResult bindingResult, WebRequest webRequest, Model model) {
        if(bindingResult.hasErrors()){
            return "addQuestion";
        }
        Test test = testService.getTestByName(webRequest.getParameter("testName"));
        question.setTest(test);
        questionService.setQuestion(question);
        String answers[] = question.getAnswer().split("--");
        for(int i=0; i<answers.length; i++){
            Answer ans = new Answer();
            ans.setAnswer(answers[i]);
            ans.setQuestion(question);
            ans.setRightAns(false);
            answerService.setAnswer(ans);
        }
        List<Answer> answer = answerService.getAnswersByQuestion(question);
        model.addAttribute("question", question);
        model.addAttribute("answer", answer);
        return "chooseRightAnswer";
    }
    
    @RequestMapping(value="/choose-rightAns", method = RequestMethod.POST)
    public String chooseRightAnswer(Model model, WebRequest webRequest) {
        Integer answerId = Integer.valueOf(webRequest.getParameter("answerId"));
        answerService.setRightAnswer(answerId);
        return "adminHomePage";
    }
    
    @RequestMapping(value = {"/del-quest"}, method = RequestMethod.GET)
    public String delQuestionTestForm(Model model) {
        List<Test> tests = testService.getTests();
        if(!tests.isEmpty()){
            model.addAttribute("tests", tests);
            return "adminChooseTest2";
        }
        return "adminAnyTest";
    }
    
    @RequestMapping(value="/del-quest2", method = RequestMethod.POST)
    public String chooseQuestionsDel(Model model, WebRequest webRequest) {
        Integer testId = Integer.valueOf(webRequest.getParameter("testId"));
        Test test = testService.getTestById(testId);
        List<Question> questions = questionService.getQuestionsByTest(test);
        model.addAttribute("test", test);
        model.addAttribute("questions", questions);
        return "deleteQuestions";
    }
    
    @RequestMapping(value="/delete-questions", method = RequestMethod.GET)
    public String deleteQuestions(Model model, WebRequest webRequest) {
        String questionsId[] = webRequest.getParameterValues("questionId");
        if(questionsId.length!=0){
            for(int i=0; i<questionsId.length; i++){
                questionService.removeQuestion(Integer.valueOf(questionsId[i]));
            }
            return "deleteQuestionsSuccess";
        }
        return "incorrectChoise";
    }
    
    @RequestMapping(value = {"/add-user"}, method = RequestMethod.GET)
    public ModelAndView addUserForn(ModelMap model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("addUser");
        return modelAndView;
    }
    
    @RequestMapping(value="/save-user", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "addUser";
        }
        userService.setUser(user);
        model.addAttribute("user", user);
	return "addUserSuccess";
    }
    
    @RequestMapping(value="/del-user", method=RequestMethod.GET)
    public String deleteUserForm(ModelMap model){
        List<User> users = userService.getUsers();
        if(!users.isEmpty()){
            model.addAttribute("users", users);
            return "deleteUser";
        }
        return "adminAnyUser";
    }
    
    @RequestMapping(value="/del-user2", method=RequestMethod.POST)
    public String deleteUser(ModelMap model, WebRequest webRequest){
        String usersId[] = webRequest.getParameterValues("userId");
        
        if(usersId.length!=0){
            for(int i=0; i<usersId.length; i++){
                userService.removeUser(Integer.valueOf(usersId[i]));
            }
            return "deleteUserSuccess";
        }
        return "";
    }
    
    @RequestMapping(value="/show-user", method=RequestMethod.GET)
    public String showUser(ModelMap model){
        List<User> users = userService.getUsers();
        if(!users.isEmpty()){
            model.addAttribute("users", users);
            return "showUser";
        }
        return "adminAnyUser";
    }
}
