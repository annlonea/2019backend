package Application.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class SimpleMessageController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String defaultMessage(){
        String ret = "Home Page";
        System.out.println("Home Page");
        return ret;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginEndPoint(@RequestParam(value="username", required=true) String username, 
                                @RequestParam(value="password", required=true) String password){
        String ret = username + ' ' + password;
        //EX: 127.0.0.1:8090/login?username=kkkk&password=aaaa
        System.out.println(ret);
        return ret;
    }

    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public String loginProcess(@ModelAttribute("login") String username, String password){
        String ret = "check";
        //EX: 
        System.out.println(ret);
        return ret;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signupEndPoint(@RequestParam(value="username", required=true) String username, 
                                @RequestParam(value="password", required=true) String password,
                                @RequestParam(value="email", required=true) String email){
        String ret = username + ' ' + password + ' ' + email;
        //EX: 127.0.0.1:8090/signup?username=kkkk&password=aaaa&email=sth@a.com
        System.out.println(ret);
        return ret;
    }

   @RequestMapping(value = "/signupProcess", method = RequestMethod.POST)
    public String loginProcess(@ModelAttribute("signup") String username, String password, String email){
        String ret = "check";
        //EX: 
        System.out.println(ret);
        return ret;
    }

}
