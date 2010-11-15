package leapstream.scoreboard.warts.providers.cruise.hooks;

import leapstream.scoreboard.alien.clobber.core.Dumper;
import leapstream.scoreboard.legacy.model.Score;
import leapstream.scoreboard.warts.providers.cruise.transforms.CruiseScore;
import net.sourceforge.cruisecontrol.dashboard.Build;
import net.sourceforge.cruisecontrol.dashboard.service.HistoricalBuildSummariesService;
import net.sourceforge.cruisecontrol.dashboard.service.LatestBuildSummariesService;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class ScoreView implements View {
    HistoricalBuildSummariesService fu;
    LatestBuildSummariesService gu;
    CruiseScore scorer;
    Dumper dumper;

    public String getContentType() {
        return "text/plain";
    }

    public void render(Map map, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String project = project(request);
        Score score = score(project);
        String dump = dumper.dump(score);
        write(response, dump);
    }

    private String project(HttpServletRequest request) {
        String path = request.getPathInfo();
        String project = path.replace("/score/", "");
        if (project.contains("/")) throw new IllegalArgumentException("Invalid project name, check for trailing slash.");
        return project;
    }

    private Score score(String project) {
        Build build = gu.getLatestProject(project);
        if (build == null) throw new IllegalStateException("Project not found.");
        List<Build> histories = fu.getAll(project);
        return scorer.score(build, histories);
    }

    private void write(HttpServletResponse response, String dump) throws IOException {
        String type = getContentType();
        response.setContentType(type);
        PrintWriter writer = response.getWriter();
        writer.println(dump);
    }
}
