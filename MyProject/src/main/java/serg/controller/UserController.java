
package serg.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("/")
public class UserController {
    
    @Autowired
    UserService userService;
    @Autowired
    TestService testService;
    @Autowired
    QuestionService questionService;
    @Autowired
    AnswerService answerService;
    
    
    @RequestMapping(value = {"/", "/startPage"}, method = RequestMethod.GET)
    public ModelAndView startPage(ModelMap model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("startPage");
        return modelAndView;
    }
    
    @RequestMapping(value="/valid", method = RequestMethod.POST)
    public String enter(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model, HttpServletRequest request) {
        if(bindingResult.hasErrors()){
            return "startPage";
        }
        HttpSession se = request.getSession(true);
        String login = user.getLogin();
        String password = user.getPassword();
        
        for(User u: userService.getUsers()){
            if(u.getLogin().equals(login) && u.getPassword().equals(password)){
                se.setAttribute("login", u.getLogin());
                if(login.equals("admin")){
                    return "adminHomePage";
                }
                else{
                    if(testService.getTests().size()>0){
                        model.addAttribute("tests", testService.getTests());
                        return "userChooseTest";
                    }
                    return "userAnyTest";
                }
            }
        }
        return "incorrectUser";      
    }
    
    @RequestMapping(value="/choise-test-user", method=RequestMethod.POST)
    public String deleteTest(ModelMap model, WebRequest webRequest){
        Test test = testService.getTestById(Integer.valueOf(webRequest.getParameter("testId")));
        model.addAttribute("test", test);
        List<Question> questions = questionService.getQuestionsByTest(test);
        model.addAttribute("questions", questions);
        List<Answer> answers = new ArrayList<Answer>();
        for(Question q: questions){
            answerService.getAnswersByQuestion(q);
            answers.addAll(answerService.getAnswersByQuestion(q));
        }
        model.addAttribute("answers", answers);
        return "passTest";
    }
    
    @RequestMapping(value="/counting", method=RequestMethod.POST)
    public String countTestResult(@RequestParam Map<String,String> allRequestParams, ModelMap model, HttpServletRequest request){
        Collection<String> answersId = allRequestParams.values();
        double point = 0;
        double count = 0;
        Iterator it = answersId.iterator();
        while(it.hasNext()){
            String ansId = String.valueOf(it.next());
            Answer answer = answerService.getAnswerById(Integer.valueOf(ansId));
            if(answer.isRightAns()){
                point++;
            }
            count++;
        }
        HttpSession se = request.getSession(true);
        String login = String.valueOf(se.getAttribute("login"));
        double testResult = Math.round(point/count*10000)/100;
        userService.updateResult(login, testResult);
        User user = userService.getUserByLogin(login);
        model.addAttribute("user", user);
        return "result";
    }
}
