import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet
public class AreaCheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ArrayList<Integer> rList = new ArrayList<>();
        System.out.println(request.getParameter("r"));
        Arrays.stream(request.getParameter("r").replaceAll("]", "")
                .replaceAll("\\[", "").split(",")).forEach(o -> rList.add(Integer.parseInt(o)));
        double yVal = Double.parseDouble(request.getParameter("y"));
        double xVal = Double.parseDouble(request.getParameter("x"));
        ArrayList<Point> data = request.getSession().getAttribute("pointsArray") == null ?
                new ArrayList<>(): (ArrayList<Point>) request.getSession().getAttribute("pointsArray");
        if (request.getParameter("key").equals("form")) {
            checkFormArea(xVal, rList, yVal, data);
        }else if (request.getParameter("key").equals("svg")){
            checkSvgArea(xVal,rList,yVal,data);
        }else if (request.getParameter("key").equals("clear")){
            request.getSession().setAttribute("pointsArray",null);
            data = new ArrayList<>();
        }
        request.getSession().setAttribute("pointsArray",data);
//        try (PrintWriter writer = response.getWriter()) {
//            writer.println(buildResponseBody(data));
//        }
        getServletContext().getRequestDispatcher("/WEB-INF/table.jsp").forward(request,response);
    }

    private void checkSvgArea(double xVal, ArrayList<Integer> rList, double yVal, ArrayList data) {
        for (Integer r : rList) {
            long start = System.nanoTime();
            data.add(new Point((float)Math.round((xVal-150)*r)/100,(float)Math.round((150-yVal)*r)/100,r,start));
        }
    }

    private void checkFormArea(double xVal, ArrayList<Integer> rList, double yVal, ArrayList data) {
        for (Integer r : rList) {
            long start = System.nanoTime();
            data.add(new Point(xVal,yVal,r,start));
        }
    }

    private String buildResponseBody(ArrayList<Point> data){
        StringBuilder responseBody = new StringBuilder("[");
        for (Point point:data) {
            responseBody.append(point.toString());
            if (data.indexOf(point)+1 == data.size()) {
                responseBody.append("]");
            } else {
                responseBody.append(",");
            }
        }
        return responseBody.toString();
    }
}
