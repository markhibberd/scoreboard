package leapstream.scoreboard.warts.providers.hudson.hooks;

import hudson.model.Action;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

import java.io.IOException;

public final class LeapstreamAction  implements Action {
    public String getIconFileName() {
        return "/plugin/scoreboard/leapstream.png";
    }

    public String getDisplayName() {
        return "Leapstream";
    }

    public String getUrlName() {
        return "leapstream";
    }

    public void doIndex(StaplerRequest request, StaplerResponse response) throws IOException {
        response.sendRedirect("http://www.leapstream.com.au/products/scoreboard/");
    }
}
