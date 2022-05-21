package dat.startcode.control;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandUnprotectedPage extends Command
{
    public String pageToShow;

    public CommandUnprotectedPage(String pageToShow)
    {
        this.pageToShow = pageToShow;
    }

    public String execute(
            HttpServletRequest request,
            HttpServletResponse response)
    {
        return pageToShow;
    }
}


