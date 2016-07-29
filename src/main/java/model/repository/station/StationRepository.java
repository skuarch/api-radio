package model.repository.station;

import java.util.List;
import model.persistence.Station;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * interface for Station bean.
 *
 * @author skuarch
 */
@Repository
public interface StationRepository extends CrudRepository<Station, Long> {

    //==========================================================================
    /**
     * get station.
     *
     * @param name String
     * @return Station
     */
    Station getStationByName(String name);

    //==========================================================================
    /**
     * get active station.
     *
     * @param name String
     * @return Station
     */
    Station getActiveStationByName(String name);

    //==========================================================================
    /**
     * get all stations without order.
     *
     * @return List
     */
    List<Station> getStations();

    //==========================================================================
    /**
     * get active stations.
     *
     * @return List
     */
    List<Station> getActiveStations();
    
    
    //==========================================================================
    /**
     * get active stations Pageables.
     *
     * @param pageable Pageable
     * @return Page
     */
    Page<Station> getActiveStations(Pageable pageable);

    //==========================================================================
    /**
     * get stations order by asc or desc.
     *
     * @param order String asc or desc
     * @return List
     */
    List<Station> getStationsByOrder(String order);

    //==========================================================================
    /**
     * get active stations order by asc or desc.
     *
     * @param order String asc or desc
     * @return List
     */
    List<Station> getActiveStationsByOrder(String order);

}
