package leapstream.scoreboard.warts.providers.hudson.hooks;

import hudson.model.Action;
import hudson.model.Hudson;
import leapstream.scoreboard.warts.providers.hudson.transforms.Scorer;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

import java.io.IOException;
import java.io.PrintWriter;

public final class ScoreAction implements Action {
    Scorer scorer;
    Hudson hudson;

    public String getIconFileName() {
        return "/plugin/scoreboard/scoreboard.png";
    }

    public String getDisplayName() {
        return "Scoreboard Feed";
    }

    public String getUrlName() {
        return "score";
    }

    public Hudson getHudson() {
        return hudson;
    }

    public void doDynamic(StaplerRequest request, StaplerResponse response) throws IOException {
        String name = name(request);
        String score = scorer.score(name);
        write(response, score);
    }

    private void write(StaplerResponse response, String text) throws IOException {
        response.setContentType("text/plain");
        PrintWriter w = response.getWriter();
        w.append(text);
        w.flush();
        w.close();
    }

    private String name(StaplerRequest request) {
        String name = request.getRestOfPath();
        name = name.replaceFirst("/", "");
        return name;
    }
}
