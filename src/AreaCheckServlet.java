import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

@WebServlet
public class AreaCheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ArrayList<Integer> rList = new ArrayList<>();
        try {
            Arrays.stream(request.getParameter("r").replaceAll("]", "")
                    .replaceAll("\\[", "").split(",")).forEach(o -> rList.add(Integer.parseInt(o)));
            double yVal = Double.parseDouble(request.getParameter("y"));
            double xVal = Double.parseDouble(request.getParameter("x"));
            ArrayList<Point> data = request.getSession().getAttribute("pointsArray") == null ?
                    new ArrayList<>(): (ArrayList<Point>) request.getSession().getAttribute("pointsArray");
            boolean reqStatus = true;
            if (request.getParameter("key").equals("form")) {
                reqStatus = checkFormArea(xVal, rList, yVal, data);
            }else if (request.getParameter("key").equals("svg")){
                reqStatus = checkSvgArea(xVal,rList,yVal,data,response);
            }else if (request.getParameter("key").equals("clear")){
                request.getSession().setAttribute("pointsArray",null);
                data = new ArrayList<>();
            }
            request.getSession().setAttribute("pointsArray",data);
            if (reqStatus)
            getServletContext().getRequestDispatcher("/WEB-INF/table.jsp").forward(request,response);
            else errorResponse(response);
        }catch (NumberFormatException var1){
            errorResponse(response);
        }

//        try (PrintWriter writer = response.getWriter()) {
//            writer.println(buildResponseBody(data));
//        }
    }

    private void errorResponse(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setStatus(400);
        response.getWriter().println("Invalid data sent");
    }

    private boolean checkSvgArea(double xVal, ArrayList<Integer> rList, double yVal, ArrayList data, HttpServletResponse response) throws IOException {
        for (Integer r : rList) {
            long start = System.nanoTime();
            float x =(float)Math.round((xVal-150)*r)/100;
            float y = (float)Math.round((150-yVal)*r)/100;
            if (validData(x,y,r,"svg"))
            data.add(new Point(x,y,r,start));
            else {
                return false;
            }
        }
        return true;
    }

    private boolean validData(float x, float y, Integer r, String method) {
        int[] rVal = new int[] {1,2,3,4,5};
        int[] xVal = new int[] {-5,-4,-3,-2,-1,0,1,2,3};
        if (method.equals("form")) {
            return IntStream.of(rVal).anyMatch(z->z==r) && IntStream.of(xVal).anyMatch(z->z==x)
                    && y < 5 && y > -5;
        }else {
            return IntStream.of(rVal).anyMatch(z->z==r) && x <= 1.5 * r && x >= -1.5 * r
                    && y <= 1.5 * r && y >= -1.5 * r;
        }
    }

    private boolean checkFormArea(double xVal, ArrayList<Integer> rList, double yVal, ArrayList data) {
        for (Integer r : rList) {
            long start = System.nanoTime();
            if (validData((float) xVal,(float) yVal,r,"form"))
            data.add(new Point(xVal,yVal,r,start));
            else return false;
        }
        return true;
    }

//    private String buildResponseBody(ArrayList<Point> data){
//        StringBuilder responseBody = new StringBuilder("[");
//        for (Point point:data) {
//            responseBody.append(point.toJson());
//            if (data.indexOf(point)+1 == data.size()) {
//                responseBody.append("]");
//            } else {
//                responseBody.append(",");
//            }
//        }
//        return responseBody.toString();
//    }
}
