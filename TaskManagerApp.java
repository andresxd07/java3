import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.thymeleaf.ThymeleafTemplateEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskManagerApp {
    public static void main(String[] args) {
        // Configuración para servir archivos estáticos desde la carpeta 'public'
        staticFiles.location("/public");

        asasa

        // Lista para almacenar las tareas
        List<String> tasks = new ArrayList<>();

        // Ruta para mostrar la página principal
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("tasks", tasks);

            // Renderiza la página usando Thymeleaf
            return new ThymeleafTemplateEngine().render(new ModelAndView(model, "index"));
        });

        // Ruta para agregar una nueva tarea
        post("/addTask", (req, res) -> {
            // Obtiene la tarea desde el formulario
            String task = req.queryParams("task");
            // Agrega la tarea a la lista
            tasks.add(task);

            // Redirige nuevamente a la página principal
            res.redirect("/");
            return null;
        });
    }
}
