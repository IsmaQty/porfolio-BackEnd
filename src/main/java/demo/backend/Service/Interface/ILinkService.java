package demo.backend.Service.Interface;

import demo.backend.Model.Link;
import java.util.List;

/**
 *
 * @author Ismael
 */
public interface ILinkService {
    public List<Link> getLinks();
    public void createLink(Link link);
    public void deleteLink(Integer dni);
    public Link findLink(Integer dni);
}
