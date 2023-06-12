package hello.servlet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream(); // HTTP Message body에 있는 데이터 스트림 형태로 받아옴
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8); // UTF-8 인코딩으로 스트림을 문자열화

        System.out.println("messageBody = " + messageBody);

        response.getWriter().write("ok");
    }
}
