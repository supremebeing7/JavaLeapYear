import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class LeapYear {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/detector", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/detector.vtl");

      String year = request.queryParams("year");
      Integer yearNumber = Integer.parseInt(year);
      Boolean isLeapYear = isLeapYear(yearNumber);
      model.put("isLeapYear", isLeapYear);
      model.put("year", year);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

  public static Boolean isLeapYear(Integer year) {
    if ( year % 400 == 0 ) {
      return true;
    } else {
      return (year % 100 != 0) && (year % 4 == 0);
    }
  }
}