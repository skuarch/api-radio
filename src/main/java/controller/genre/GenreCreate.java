package controller.genre;

import controller.application.BaseController;
import model.bean.GenericMessage;
import model.bean.Genre;
import model.repository.genre.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController.
 */
@RestController
public class GenreCreate extends BaseController {

    @Autowired
    private GenericMessage genericMessage;

    @Autowired
    private GenreRepository genreRepository;

    //==========================================================================
    @RequestMapping(value = { "/v1/genre/create" }, method = RequestMethod.POST)
    public GenericMessage createGenre(@ModelAttribute Genre genre) {

        long id;

        try {

            //genre already exists?
            if(genreRepository.findByName(genre.getName()) == null ){
                id = genreRepository.save(genre).getId();
                genericMessage = getSuccessfulMessage(id);
            }else{
                genericMessage.setMessage("genre already exits");
            }           
            

        } catch (Exception e) {
            genericMessage = handleException("GenreCreate.createGenre", e, getClass());
        }

        return genericMessage;

    }

}
