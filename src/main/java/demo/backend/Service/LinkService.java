package demo.backend.Service;

import demo.backend.Model.Link;
import demo.backend.Repository.ILinkRepository;
import demo.backend.Service.Interface.ILinkService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ismael
 */
@Service
public class LinkService implements ILinkService{
    @Autowired ILinkRepository linkRepos;

    @Override
    public List<Link> getLinks() {
        return linkRepos.findAll();
    }

    @Override
    public void createLink(Link link) {
        linkRepos.save(link);
    }

    @Override
    public void deleteLink(Integer dni) {
        linkRepos.deleteById(dni);
    }

    @Override
    public Link findLink(Integer dni) {
        return linkRepos.findById(dni).orElse(null);
    }
    
}
