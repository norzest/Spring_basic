package hello.hellospring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") // get 방식 localhost/hello
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
        // templates에 있는 hello.html로 가서 data는 hello!!로 치환해라
    }

    @GetMapping("hello-mvc")
    // @requestParam -> localhost:8080/hello-mvc?name="전달하고자 하는 값"
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // http 통신의 body에 내용(name)을 넣는다(html 없음)
    public String helloString(@RequestParam("name") String name) {
        // ViewResolver 대신 HttpMessageConverter(StringConverter) 동작
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody // json 방식 -> {"name" : "값"} 이렇게 화면에 출력
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        // 문자일경우 그냥 화면에 넘겨주는데 객체일 경우 디폴트의 경우 json으로 반환
        // HttpMessageConverter(JsonConverter) 동작
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    } // class hello
}
